package com.tests;

import org.testng.annotations.DataProvider;

public class LoginDDT {

    @DataProvider(name = "loginCredentials")
    public Object[][] getLoginData() {
        return new Object[][] {
        	{"Admin","admin123"},
//            { "user1", "password1" },
//            { "invalidUser", "wrongPass" }
        };
    }
}
