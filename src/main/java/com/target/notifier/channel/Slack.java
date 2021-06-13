package com.target.notifier.channel;

import com.target.notifier.enity.Message;
import com.target.notifier.integrator.EmailService;
import com.target.notifier.integrator.SlackIntegrator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Slack implements  Channel {

    private String slackId;
    private Message message;
    private String from;

    @Override
    public MessageDelivery sendMessage() {

        SlackIntegrator slackService = new SlackIntegrator();
        DeliveryStatus en = slackService.sendSlackMessage(this);
        MessageDelivery md = new MessageDelivery();
        md.setMessage(this.message.getMessage());
        md.setStatus(DeliveryStatus.DELIVERED);
        md.setType("SLACK");
        return md;
    }
}
