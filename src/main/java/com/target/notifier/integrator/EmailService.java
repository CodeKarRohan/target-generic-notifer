package com.target.notifier.integrator;

//used for sending mail

import com.target.notifier.channel.DeliveryStatus;
import com.target.notifier.channel.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailService {

    private static final Logger LOG = LogManager.getLogger();
    String emailId;

    public DeliveryStatus sendEmailMessage(Email email)
    {
        //stubbed
        LOG.info("Email is sent successfully from [{}], to [{}], message [{}] ",
                email.getFrom(), email.getEmailId(), email.getMessage().getMessage());
        return DeliveryStatus.DELIVERED;
    }
}
