package org.demon.springcloud.service.impl;

import org.demon.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author demon
 * @create 2020-12-16 14:58
 */
@EnableBinding(Source.class) // 定义消息的推送管道
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        // 构建消息，并发送
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("发送消息：" + serial);
        return "发送消息：" + serial;
    }
}
