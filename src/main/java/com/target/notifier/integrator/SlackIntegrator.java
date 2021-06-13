package com.target.notifier.integrator;

import com.target.notifier.channel.DeliveryStatus;
import com.target.notifier.channel.Slack;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//used for sending slack
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SlackIntegrator {
    private static final Logger LOG = LogManager.getLogger();
    private String slackId;
    public DeliveryStatus sendSlackMessage(Slack slack)
    {
        //stubbed
        LOG.info("Message is sent successfully from [{}], to [{}], message [{}] ",
                slack.getFrom(), slack.getSlackId(), slack.getMessage().getMessage());
        return DeliveryStatus.DELIVERED;
    }
}
