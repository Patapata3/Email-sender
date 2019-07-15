package com.company.emailsender.service;

import com.company.emailsender.core.LetterWorker;
import com.company.emailsender.entity.Letter;
import com.haulmont.cuba.core.Persistence;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service(LetterService.NAME)
public class LetterServiceBean implements LetterService {

    @Inject
    private LetterWorker letterWorker;

    @Inject
    private Persistence persistence;

    @Transactional
    @Override
    public void send(Letter letter)
    {
        Letter entity = persistence.getEntityManager().merge(letter);
        letterWorker.send(entity);
    }
}