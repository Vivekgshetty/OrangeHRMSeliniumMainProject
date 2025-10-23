package com.utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CSVReporterListner implements ITestListener {
	
	    private static final String FILE_PATH = "./target/test-report.csv";
	    private static PrintWriter writer;

	    @Override
	    public void onStart(ITestContext context) {
	        try {
	            writer = new PrintWriter(new FileWriter(FILE_PATH));
	            writer.println("Test Name,Username,Password,Status,Message");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        logResult(result, "PASS", "Logout successful");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        logResult(result, "FAIL", result.getThrowable().getMessage());
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        logResult(result, "SKIPPED", "Test skipped");
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        if (writer != null) {
	            writer.close();
	        }
	    }

	    private void logResult(ITestResult result, String status, String message) {
	        Object[] params = result.getParameters();
	        String username = params.length > 0 ? params[0].toString() : "";
	        String password = params.length > 1 ? params[1].toString() : "";
	        String testName = result.getMethod().getMethodName();

	        writer.printf("%s,%s,%s,%s,%s%n",
	                testName, username, password, status, message.replaceAll(",", " "));
	        writer.flush();
	    }
	}

