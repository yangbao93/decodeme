package com.azuray.decodeme.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.azuray.decodeme.service.SmsService;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service("smsService")
@Slf4j
public class SmsServiceImpl implements SmsService {


    @Override
    public void sendTicketSms(int appId, String sign, String appKey, int templateId, String phoneNumber) {
        // 配置发送sender
        SmsSingleSender ssender = new SmsSingleSender(appId, appKey);

        // 配置参数
        ArrayList<String> params = new ArrayList<>();
        params.add("12306byPass");
        DateFormat format = new SimpleDateFormat("MM-dd HH:mm");
        String dateStr = format.format(new Date());
        params.add(dateStr);
        try {
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumber,
                    templateId, params, sign, "", "");
            log.info("发送的结果为：" + JSONObject.toJSONString(result));
        } catch (HTTPException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
