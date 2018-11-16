package com.azuray.decodeme.controller;

import com.azuray.decodeme.common.CommonResponse;
import com.azuray.decodeme.constant.ResultCode;
import com.azuray.decodeme.entity.vo.vote.VoteChoose;
import com.azuray.decodeme.entity.vo.vote.VoteHead;
import com.azuray.decodeme.entity.vo.vote.VoteTopic;
import com.azuray.decodeme.service.VoteChooseService;
import com.azuray.decodeme.service.VoteHeadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/vote")
public class VoteController {

    @Autowired
    private VoteHeadService VoteHeadService;

    @Autowired
    private VoteChooseService voteChooseService;

    @RequestMapping(value = "/head/add", method = RequestMethod.POST)
    public CommonResponse addVoteHead(@RequestBody VoteHead VoteHead) {
        assert VoteHead != null;
        log.debug("新增一个投票信息");
        String checkResult = checkVoteHeadParam(VoteHead);
        if (!StringUtils.isEmpty(checkResult)) {
            return new CommonResponse(ResultCode.PARAM_ILLEGAL_CODE, checkResult);
        }
        boolean saveResult = VoteHeadService.save(VoteHead);
        if (!saveResult) {
            return new CommonResponse(ResultCode.FAIL_CODE, ResultCode.FAIL_MSG);
        }
        return new CommonResponse(ResultCode.SUCCESS_CODE, ResultCode.SUCCESS_MSG, VoteHead);
    }


    @RequestMapping(value = "/choose/add", method = RequestMethod.POST)
    public CommonResponse addChoose(@RequestBody List<VoteChoose> voteChooseList) {
        String checkResult = checkChooseParam(voteChooseList);
        if (!StringUtils.isEmpty(checkResult)) {
            return new CommonResponse(ResultCode.PARAM_ILLEGAL_CODE, checkResult);
        }
        boolean saveResult = voteChooseService.saveBatch(voteChooseList);
        if (!saveResult) {
            return new CommonResponse(ResultCode.FAIL_CODE, ResultCode.FAIL_MSG);
        }
        return new CommonResponse(ResultCode.SUCCESS_CODE, ResultCode.SUCCESS_MSG, voteChooseList);
    }

    /**
     * 检查投票选项是否合规
     *
     * @param voteChooseList
     */
    private String checkChooseParam(List<VoteChoose> voteChooseList) {
        for (VoteChoose voteChoose : voteChooseList) {
            if (StringUtils.isEmpty(voteChoose.getChoName())) {
                return "答案不允许为空";
            }
            if (StringUtils.isEmpty(voteChoose.getVoteId())) {
                return "题目不允许为空";
            }
            if (StringUtils.isEmpty(voteChoose.getChoValue())) {
                return "选项值不允许为空";
            }
        }
        return null;
    }

    /**
     * 检查投票题目参数是否合规
     *
     * @param voteTopic
     */
    @Deprecated
    private String checkVoteTopicParam(VoteTopic voteTopic) {
        if (StringUtils.isEmpty(voteTopic.getTopicName())) {
            return "题目名称不允许为空";
        }
        if (StringUtils.isEmpty(voteTopic.getTopicType())) {
            return "题目类型不允许为空";
        }
        if (StringUtils.isEmpty(voteTopic.getVotePid())) {
            return "请提供投票所需";
        }

        return null;
    }

    /**
     * 检查投票主体参数是否合规
     *
     * @param VoteHead
     */
    private String checkVoteHeadParam(VoteHead VoteHead) {
        if (StringUtils.isEmpty(VoteHead.getVoteName())) {
            return "投票名称不允许为空";
        }
        if (StringUtils.isEmpty(VoteHead.getVoteUserCode())) {
            return "用户编码不允许为空";
        }
        List<String> typeList = Arrays.asList("1", "2");
        if (StringUtils.isEmpty(VoteHead.getVoteType()) || (!typeList.contains(VoteHead.getVoteType()))) {
            return "投票类型不正确";
        }
        if (StringUtils.isEmpty(VoteHead.getVoteUserName())) {
            return "用户名不允许为空";
        }
        if (VoteHead.getStartTime() == null || VoteHead.getEndTime() == null) {
            return "起止时间不能为空";
        }
        if (VoteHead.getStartTime().after(VoteHead.getEndTime())) {
            return "起始时间不能晚于结束时间";
        }
        return null;
    }

    @Deprecated
    @RequestMapping(value = "/topic/add", method = RequestMethod.POST)
    public CommonResponse addVoteTopic(@RequestBody VoteTopic voteTopic) {
        checkVoteTopicParam(voteTopic);
        return null;
    }
}
