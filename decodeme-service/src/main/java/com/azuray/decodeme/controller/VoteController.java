package com.azuray.decodeme.controller;

import com.azuray.decodeme.common.CommonResponse;
import com.azuray.decodeme.constant.ResultCode;
import com.azuray.decodeme.entity.vo.vote.VoteAnswer;
import com.azuray.decodeme.entity.vo.vote.VoteChoose;
import com.azuray.decodeme.entity.vo.vote.VoteHead;
import com.azuray.decodeme.entity.vo.vote.VoteTopic;
import com.azuray.decodeme.service.VoteAnswerService;
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

    @Autowired
    private VoteAnswerService voteAnswerService;

    @RequestMapping(value = "/head/add", method = RequestMethod.POST)
    public CommonResponse addVoteHead(@RequestBody VoteHead VoteHead) {
        assert VoteHead != null;
        log.debug("新增一个投票信息");
        String checkResult = checkVoteHeadParam(VoteHead);
        if (!StringUtils.isEmpty(checkResult)) {
            return CommonResponse.failResponse(checkResult);
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
            return CommonResponse.failResponse(checkResult);
        }
        boolean saveResult = voteChooseService.saveBatch(voteChooseList);
        if (!saveResult) {
            return CommonResponse.failResponse();
        }
        return new CommonResponse(ResultCode.SUCCESS_CODE, ResultCode.SUCCESS_MSG, voteChooseList);
    }

    @RequestMapping(value = "/answer/add", method = RequestMethod.POST)
    public CommonResponse addAnswer(@RequestBody List<VoteAnswer> answerList) {
        String checkResult = checkAnswerParam(answerList);
        if (!StringUtils.isEmpty(checkResult)) {
            return CommonResponse.failResponse(checkResult);
        }
        boolean saveResult = voteAnswerService.saveBatch(answerList);
        if (saveResult) {
            return CommonResponse.successResponse(answerList);
        }
        return CommonResponse.failResponse();
    }

    /**
     * 查询答案是否合规
     *
     * @param answerList 参数
     * @return 错误信息
     */
    private String checkAnswerParam(List<VoteAnswer> answerList) {
        // 检查是否有该投票信息
        Long voteId = answerList.get(0).getVoteId();
        if (voteId == null) {
            return "投票题目编码不正确，请检查";
        }
        VoteHead voteHead = VoteHeadService.getById(voteId);
        if (voteHead == null) {
            return "没有查到对应的投票题目";
        }
        for (VoteAnswer answer : answerList) {
            if (StringUtils.isEmpty(answer.getVoteChoId())) {
                return "投票选择不能为空";
            }
            if (StringUtils.isEmpty(answer.getAnsValue())) {
                return "投票结果不能为空";
            }
            if (!voteHead.getIsAnonymous()) {
                if (StringUtils.isEmpty(answer.getAnsUserCode()) || StringUtils.isEmpty(answer.getAnsUserName())) {
                    return "非匿名投票用户不能为空";
                }
            }
        }
        return null;
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
