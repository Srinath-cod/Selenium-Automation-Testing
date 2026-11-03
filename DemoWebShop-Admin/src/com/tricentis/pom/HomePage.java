package com.tricentis.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
@FindBy(xpath = "//input[@value='Search store']")
private WebElement searchBox;
@FindBy(linkText = "Log out")
private WebElement logoutLink;

public HomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public void setSearchBox(String value) {
	searchBox.sendKeys(value,Keys.ENTER);
}
public void setLogoutLink() {
	logoutLink.click();
}
}
