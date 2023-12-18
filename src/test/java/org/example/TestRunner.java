package org.example;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRunner {

    public static void main(String[] args) {

        // Replace TestClass1, TestClass2, ... with the actual names of your test classes
        Result result = JUnitCore.runClasses(TicTacToeTest.class);

        // Print the results
        System.out.println("Total tests run: " + result.getRunCount());
        System.out.println("Failures: " + result.getFailureCount());

        // Print details of failures
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        // Exit with status code indicating success or failure
        System.exit(result.wasSuccessful() ? 0 : 1);
    }
}

