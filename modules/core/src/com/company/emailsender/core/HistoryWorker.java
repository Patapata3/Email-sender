package com.company.emailsender.core;

import com.company.emailsender.entity.History;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component(HistoryWorker.NAME)
public class HistoryWorker {
    public static final String NAME = "emailsender_HistoryWorker";

    @Inject
    private DataManager dataManager;

    public void addHistory(History note) {
        dataManager.commit(note);
    }
}