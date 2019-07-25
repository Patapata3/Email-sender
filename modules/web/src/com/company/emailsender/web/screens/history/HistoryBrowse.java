package com.company.emailsender.web.screens.history;

import com.haulmont.charts.gui.components.charts.SerialChart;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.screen.*;
import com.company.emailsender.entity.History;
import com.haulmont.reports.gui.actions.TablePrintFormAction;

import javax.inject.Inject;

@UiController("emailsender_History.browse")
@UiDescriptor("history-browse.xml")
@LookupComponent("historiesTable")
@LoadDataBeforeShow
public class HistoryBrowse extends StandardLookup<History> {

    @Inject
    private Button createReport;

    @Inject
    private GroupTable<History> historiesTable;

    @Subscribe
    private void onInit(InitEvent event) {
        TablePrintFormAction action = new TablePrintFormAction("report", historiesTable);
        historiesTable.addAction(action);
        createReport.setAction(action);
    }
    
    
}