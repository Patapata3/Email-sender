package com.company.emailsender.web.screens.history;

import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.emailsender.entity.History;

@UiController("emailsender_History.browse")
@UiDescriptor("history-browse.xml")
@LookupComponent("historiesTable")
@LoadDataBeforeShow
public class HistoryBrowse extends StandardLookup<History> {

}