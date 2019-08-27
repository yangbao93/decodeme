package com.azuray.decodeme.controller;

import com.azuray.decodeme.service.SmsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
@Api(value = "SmsController", description = "腾讯云短信平台")
public class SmsController {

    @Autowired
    private SmsService smsService;


    @ApiOperation(value = "短信发送", notes = "仅用于发送12306bypass抢票通知")
    @ApiImplicitParam(name = "value", value = "打印字段", dataType = "String")
    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String getTicket(@RequestParam("phone") String phoneNumber,
                            @RequestParam("appId") int appId,
                            @RequestParam("appKey") String appKey,
                            @RequestParam("templateId") int templateId,
                            @RequestParam("sign") String sign) {
        smsService.sendTicketSms(appId, appKey, phoneNumber, templateId, sign);
        return "done!";
    }
}
