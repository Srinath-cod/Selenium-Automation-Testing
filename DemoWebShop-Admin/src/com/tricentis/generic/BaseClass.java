package com.tricentis.generic;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.tricentis.pom.DashBoardPage;
import com.tricentis.pom.HomePage;
import com.tricentis.pom.LoginPage;

public class BaseClass {
	public static WebDriver driver;
	public FileLib f=new FileLib();
	@BeforeTest
public void openBrowser() throws IOException {
	ChromeOptions opt=new ChromeOptions();
	opt.addArguments("--incognito");
	driver=new ChromeDriver(opt);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	String url = f.readDataFromProperty("url");
	driver.get(url);
}	@BeforeMethod
public void login() throws IOException {
	DashBoardPage d=new DashBoardPage(driver);
	d.setLoginLink();
	LoginPage l=new LoginPage(driver);
	String email = f.readDataFromProperty("email");
	String pwd = f.readDataFromProperty("pwd");
	l.setLogin(email,pwd);
}	@AfterMethod
public void logout() {
	HomePage h=new HomePage(driver);
	h.setLogoutLink();
}	@AfterTest
public void closeBrowser() {
	driver.quit();
}
}
