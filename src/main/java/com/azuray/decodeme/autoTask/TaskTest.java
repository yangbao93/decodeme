package com.azuray.decodeme.autoTask;

import org.springframework.stereotype.Component;

/**
 * 定时任务测试
 */
@Component
public class TaskTest {

    // @Scheduled(cron = "0/10 * * * * ?")
    public void autoTask() {
        System.out.println("this is task");
    }
}
