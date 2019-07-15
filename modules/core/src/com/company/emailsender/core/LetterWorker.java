package com.company.emailsender.core;

import com.company.emailsender.entity.Letter;
import com.company.emailsender.entity.Receiver;
import com.haulmont.cuba.core.app.EmailService;
import com.haulmont.cuba.core.global.EmailInfo;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;

@Component(LetterWorker.NAME)
public class LetterWorker {
    public static final String NAME = "emailsender_LetterWorker";

    @Inject
    private EmailService emailService;

    public void send(Letter letter) {
        EmailInfo emailInfo = new EmailInfo(
                receiversToString(letter.getReceivers()),
                letter.getTitle(),
                null,
                letter.getContent(),
                null
        );
        emailService.sendEmailAsync(emailInfo);
    }

    private String receiversToString(List<Receiver> receivers) {
        String result = receivers.get(0).getEmail();
        for (int i = 1; i < receivers.size(); i++) {
            result += ("," + receivers.get(i).getEmail());
        }
        return result;
    }
}