package com.company.emailsender.service;

import com.company.emailsender.entity.Letter;

public interface LetterService {
    String NAME = "emailsender_LetterService";
    void send(Letter letter);
}