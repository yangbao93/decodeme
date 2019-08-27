package com.azuray.decodeme.service;

public interface SmsService {
    /**
     * 发送12306bypass抢票信息
     * @param appId id
     * @param sign
     * @param appKey key
     * @param templateId
     * @param phoneNumber 手机号
     */
    void sendTicketSms(int appId, String sign, String appKey, int templateId, String phoneNumber);
}
