package com.company.emailsender.core;

import com.company.emailsender.entity.Receiver;
import com.haulmont.bali.collections.ReadOnlyLinkedMapValuesView;
import com.haulmont.yarg.formatters.CustomReport;
import com.haulmont.yarg.structure.BandData;
import com.haulmont.yarg.structure.Report;


import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.company.emailsender.entity.History;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;


public class ReportCreator implements CustomReport{

    public byte[] createReport(Report report, BandData rootBand, Map<String, Object> Params) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        CreationHelper createHelper = workbook.getCreationHelper();
        CellStyle dateStyle = workbook.createCellStyle();
        dateStyle.setDataFormat(createHelper.createDataFormat().getFormat("m/d/yy h:mm"));
        HSSFSheet sheet = workbook.createSheet("Лист1");

        int rowNum = 0;
        Row row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue("Date");
        row.createCell(1).setCellValue("Title");
        row.createCell(2).setCellValue("Content");
        row.createCell(3).setCellValue("Receivers");

        ReadOnlyLinkedMapValuesView histories = (ReadOnlyLinkedMapValuesView) Params.get("entities");
        for  ( Object entity: histories) {
            History history = (History)entity;
            rowNum++;
            fillRow(sheet, dateStyle, rowNum, history);

        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            workbook.write(bos);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bos.toByteArray();
    }

    private void fillRow(HSSFSheet sheet, CellStyle dateStyle, int rowNum, History history) {
        Row row = sheet.createRow(rowNum);
        Cell dateCell = row.createCell(0);
        dateCell.setCellValue(history.getDate());
        dateCell.setCellStyle(dateStyle);
        row.createCell(1).setCellValue(history.getLetter().getTitle());
        row.createCell(2).setCellValue(history.getLetter().getContent());
        row.createCell(3).setCellValue(receiversToString(history.getLetter().getReceivers()));
    }

    private String receiversToString(List<Receiver> receivers) {
        String result = receivers.get(0).getEmail();
        for (int i = 1; i < receivers.size(); i++) {
            result += ("; " + receivers.get(i).getEmail());
        }
        return result;
    }
}