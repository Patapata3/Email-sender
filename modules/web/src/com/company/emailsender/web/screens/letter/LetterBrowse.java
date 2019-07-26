package com.company.emailsender.web.screens.letter;

import com.company.emailsender.service.HistoryService;
import com.company.emailsender.service.LetterService;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.emailsender.entity.Letter;

import javax.inject.Inject;


@UiController("emailsender_Letter.browse")
@UiDescriptor("letter-browse.xml")
@LookupComponent("lettersTable")
@LoadDataBeforeShow
public class LetterBrowse extends StandardLookup<Letter> {

    @Inject
    private CollectionContainer<Letter> lettersDc;

    @Inject
    private Notifications notifications;

    @Inject
    private LetterService letterService;

    @Inject
    private HistoryService historyService;


    @Subscribe("lettersTable.send")
    private void onLettersTableSend(Action.ActionPerformedEvent event) {
        Letter selectedLetter = lettersDc.getItem();
        if(!selectedLetter.getReceivers().isEmpty()) {
            letterService.send(selectedLetter);
            historyService.addHistory(selectedLetter);
            notifications.create(Notifications.NotificationType.TRAY).withCaption("Message has been successfully sent")
                    .show();
        }
        else {
            notifications.create(Notifications.NotificationType.ERROR).withCaption("Message cannot be sent")
                    .withDescription("The receivers' list is empty").show();
        }
    }
}
