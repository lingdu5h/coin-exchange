package com.lingdu.service;

import com.lingdu.domain.Sms;
import com.baomidou.mybatisplus.extension.service.IService;
public interface SmsService extends IService<Sms>{


    /**
     * 发送一个短信
     * @param sms
     * 短信内容
     * @return
     * 是否发送成功
     */
    boolean sendSms(Sms sms);
}
