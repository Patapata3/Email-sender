package com.company.emailsender.service;

import com.company.emailsender.core.HistoryWorker;
import com.company.emailsender.entity.History;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service(HistoryService.NAME)
public class HistoryServiceBean implements HistoryService {

    @Inject
    private HistoryWorker historyWorker;

    public void addHistory(History note) {
        historyWorker.addHistory(note);
    }
}