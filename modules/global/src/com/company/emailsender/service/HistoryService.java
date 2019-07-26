package com.company.emailsender.service;

import com.company.emailsender.entity.Letter;

public interface HistoryService {
    String NAME = "emailsender_HistoryService";
    void addHistory(Letter letter);
}