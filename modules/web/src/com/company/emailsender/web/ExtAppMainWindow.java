package com.company.emailsender.web;

import com.company.emailsender.entity.History;
import com.haulmont.charts.gui.components.charts.SerialChart;
import com.haulmont.charts.gui.data.MapDataItem;
import com.haulmont.cuba.core.app.DataService;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.web.app.mainwindow.AppMainWindow;

import javax.inject.Inject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ExtAppMainWindow extends AppMainWindow {
    @Inject
    private SerialChart historyChart;
    @Inject
    private DataManager dataManager;
    @Inject
    private DataService dataService;

    @Subscribe
    private void onBeforeShow(BeforeShowEvent event) throws ParseException {
        List<History> histories = dataManager.load(History.class).list();
        SimpleDateFormat dateOnly = new SimpleDateFormat("dd/MM/yyyy");
        Map<Date, Set<History>> historyGroups = new HashMap<Date, Set<History>>();

        for (History note:
             histories) {
            Date simpleDate = dateOnly.parse(dateOnly.format(note.getDate()));
            historyGroups.putIfAbsent(simpleDate, new HashSet<History>());
            historyGroups.get(simpleDate).add(note);
        }
        for (Date key:
             historyGroups.keySet()) {
            historyChart.addData(MapDataItem.of("date", key,
                    "amount", historyGroups.get(key).size()));
        };
    }


}