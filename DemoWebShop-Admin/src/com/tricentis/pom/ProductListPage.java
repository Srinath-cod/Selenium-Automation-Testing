package com.tricentis.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListPage {
@FindBy(className = "product-item")
private WebElement productIcon;

public ProductListPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public void setProductIcon() {
	productIcon.click();
}

}
