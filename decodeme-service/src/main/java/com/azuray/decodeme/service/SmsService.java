package com.azuray.decodeme.service;

public interface SmsService {
    /**
     * 发送12306bypass抢票信息
     * @param appId id
     * @param appKey key
     * @param phoneNumber 手机号
     */
    void sendTicketSms(int appId, String appKey, String phoneNumber);
}
