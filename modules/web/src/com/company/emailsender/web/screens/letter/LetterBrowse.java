package com.company.emailsender.web.screens.letter;

import com.company.emailsender.entity.Receiver;
import com.haulmont.cuba.core.app.EmailService;
import com.haulmont.cuba.core.global.EmailInfo;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.Collapsable;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.CollectionPropertyContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.emailsender.entity.Letter;

import javax.inject.Inject;
import java.util.List;

@UiController("emailsender_Letter.browse")
@UiDescriptor("letter-browse.xml")
@LookupComponent("lettersTable")
@LoadDataBeforeShow
public class LetterBrowse extends StandardLookup<Letter> {

    @Inject
    private CollectionContainer<Letter> lettersDc;

    @Inject
    private EmailService emailService;

    @Inject
    private Notifications notifications;

    @Inject
    private Button sendBtn;

    private Letter SelectedLetter = null;


    @Subscribe("lettersTable")
    private void onLettersTableSelection(Table.SelectionEvent<Letter> event) {
        if (!sendBtn.isEnabled()) {
            sendBtn.setEnabled(true);
        }
        SelectedLetter = event.getSource().getSingleSelected();
    }

    @Subscribe("sendBtn")
    private void onSendBtnClick(Button.ClickEvent event) {
        if(!SelectedLetter.getReceivers().isEmpty()) {
            EmailInfo emailInfo = new EmailInfo(
                    ReceiversToString(SelectedLetter.getReceivers()),
                    SelectedLetter.getTitle(),
                    null,
                    SelectedLetter.getContent(),
                    null
            );
            emailService.sendEmailAsync(emailInfo);
            notifications.create(Notifications.NotificationType.TRAY).withCaption("Message has been successfully sent")
                    .show();
        }
        else {
            notifications.create(Notifications.NotificationType.ERROR).withCaption("Message cannot be sent")
                    .withDescription("The receivers' list is empty").show();
        }

    }

    private String ReceiversToString(List<Receiver> receivers) {
        String result = receivers.get(0).getEmail();
        for (int i = 1; i < receivers.size(); i++) {
            result += ("," + receivers.get(i).getEmail());
        }
        return result;
    }
}
