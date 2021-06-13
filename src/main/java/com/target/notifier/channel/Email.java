package com.target.notifier.channel;

import com.target.notifier.enity.Message;
import com.target.notifier.integrator.EmailService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email implements  Channel {

    private String emailId;
    private Message message;
    private String from;




    @Override
    public MessageDelivery sendMessage() {

        EmailService emailService = new EmailService();
        DeliveryStatus en = emailService.sendEmailMessage(this);
        MessageDelivery md = new MessageDelivery();
        md.setMessage(this.message.getMessage());
        md.setStatus(DeliveryStatus.DELIVERED);
        md.setType("EMAIL");
        return md;
    }
}
