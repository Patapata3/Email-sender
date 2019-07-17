package com.company.emailsender.core

import com.company.emailsender.entity.History
import com.company.emailsender.entity.Receiver

def result = []
def entities = params['entities']
entities.each {
    History history = (History)it
    result.add(["date": history.getDate(), "letter.title": history.getLetter().getTitle(), "letter.content": history.getLetter().getContent(), "letter.receiver": receiversToString(history.getLetter().getReceivers())])
}
return result

static String receiversToString(List<Receiver> receivers) {
    String result = receivers.get(0).getEmail()
    for (int i = 1; i < receivers.size(); i++) {
        result += ("; " + receivers.get(i).getEmail())
    }
    return result
}