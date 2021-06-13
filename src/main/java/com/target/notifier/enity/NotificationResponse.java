package com.target.notifier.enity;

import com.target.notifier.channel.MessageDelivery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationResponse {

    private String consumerName;
    private MessageDelivery messageDelivery;
    private String topicName;


}
