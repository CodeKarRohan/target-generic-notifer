package com.target.notifier.channel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDelivery {

    String message;
    DeliveryStatus status;
    String type;


}
