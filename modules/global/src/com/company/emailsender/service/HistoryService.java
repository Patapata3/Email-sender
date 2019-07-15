package com.company.emailsender.service;

import com.company.emailsender.entity.History;

public interface HistoryService {
    String NAME = "emailsender_HistoryService";
    void addHistory(History note);
}