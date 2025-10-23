package com.utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelReporterListener implements ITestListener {

    private static final String FILE_PATH = "./target/TestReport.xlsx";
    private Workbook workbook;
    private Sheet sheet;
    private int rowCount = 0;

    @Override
    public void onStart(ITestContext context) {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Test Results");

        // Header row
        Row header = sheet.createRow(rowCount++);
        header.createCell(0).setCellValue("Test Name");
        header.createCell(1).setCellValue("Username");
        header.createCell(2).setCellValue("Password");
        header.createCell(3).setCellValue("Status");
        header.createCell(4).setCellValue("Message");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logResult(result, "PASS", "Logout successful");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logResult(result, "FAIL", result.getThrowable() != null ? result.getThrowable().getMessage() : "Exception occurred");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logResult(result, "SKIPPED", "Test was skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        try (FileOutputStream out = new FileOutputStream(FILE_PATH)) {
            // Auto-size columns
            for (int i = 0; i < 5; i++) {
                sheet.autoSizeColumn(i);
            }
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void logResult(ITestResult result, String status, String message) {
        Row row = sheet.createRow(rowCount++);
        Object[] params = result.getParameters();
        String username = params.length > 0 ? params[0].toString() : "";
        String password = params.length > 1 ? params[1].toString() : "";

        row.createCell(0).setCellValue(result.getMethod().getMethodName());
        row.createCell(1).setCellValue(username);
        row.createCell(2).setCellValue(password);
        row.createCell(3).setCellValue(status);
        row.createCell(4).setCellValue(message.replaceAll("[\\r\\n]+", " "));
    }
}
