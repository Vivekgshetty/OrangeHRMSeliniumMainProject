package com.tests;

import com.myinfo.AdminPage;
import com.myinfo.DeleteUserPage;
import com.myinfo.EditUserPage;
import com.myinfo.MyinfoPages;
import com.myinfo.SearchPage;
import com.pages.LoginPages;
import com.pages.LogoutPages;
import com.utilities.TestBase;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test(dataProvider = "loginCredentials", dataProviderClass = LoginDDT.class)
    public void testSuccessfulLogin(String username, String password) throws InterruptedException {
        LoginPages loginPage = new LoginPages(getDriver());
        loginPage.login(username, password);
        
//        MyinfoPages myinfo = new MyinfoPages(getDriver());  
//        myinfo.myinfo();
//        System.out.println("sucess");
        AdminPage adminPage = new AdminPage(driver);
        adminPage.openAdmin();
        adminPage.clickAdd();
        String employeeName = "Thomas Kutty Benny";
        String usernames = "Vivek1689";
        String passwords = "Jellyfish@123";
        String confirmPassword = "Jellyfish@123";

        adminPage.fillUserDetails(
        		employeeName, usernames, passwords, confirmPassword
        );
        Thread.sleep(5000);
        adminPage.saveUser();
        
        SearchPage search= new SearchPage(driver);
        search.searchUser(username, "Admin", "Enabled");

        Thread.sleep(2000);

        EditUserPage editPage = new EditUserPage(driver);
        editPage.editUserStatus("Disabled");
 
         
 
        
        search.searchUser(username, "Admin", "Enabled"); 
        
        DeleteUserPage deletePage = new DeleteUserPage(driver);
        deletePage.deleteUser();
//        
//        LogoutPages logoutpage=new LogoutPages(getDriver());
//        logoutpage.logout();
//        System.out.println("logout sucessfull");

        
    }
}
