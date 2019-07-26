package com.company.emailsender.service;

import com.company.emailsender.entity.History;
import com.company.emailsender.entity.Letter;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Date;

@Service(HistoryService.NAME)
public class HistoryServiceBean implements HistoryService {

    @Inject
    private Metadata metadata;
    @Inject
    private DataManager dataManager;

    public void addHistory(Letter letter) {
        History newNote = metadata.create(History.class);
        newNote.setDate(new Date());
        newNote.setLetter(letter);
        dataManager.commit(newNote);
    }
}