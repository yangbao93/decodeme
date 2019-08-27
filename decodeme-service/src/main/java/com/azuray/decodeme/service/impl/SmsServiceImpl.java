package com.azuray.decodeme.service.impl;

import com.azuray.decodeme.service.SmsService;
import com.github.qcloudsms.SmsMultiSender;
import com.github.qcloudsms.SmsMultiSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service("smsService")
@Slf4j
public class SmsServiceImpl implements SmsService {


    @Override
    public void sendTicketSms(int appId, String appKey, String phoneNumber) {
        SmsMultiSender msender = new SmsMultiSender(appId, appKey);
        ArrayList<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add(phoneNumber);
        try {
            SmsMultiSenderResult result =  msender.send(0, "86", phoneNumbers,
                    "【12306ByPass】抢票成功，快去付款吧！", "", "");
        } catch (HTTPException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
