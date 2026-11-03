package com.tricentis.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {
@FindBy(xpath = "//span[text()='Remove:']/following-sibling::input")
private WebElement removeCheckBox;
@FindBy(name="updatecart")
private WebElement updatecartBtn;
@FindBy(className = "wishlist-content")
private WebElement emptyWishlistMsg;

public WishListPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public void removeProduct() {
	removeCheckBox.click();
	updatecartBtn.click();
}
public boolean getEmptyWishlistMsgIsDisplayed() {
	return emptyWishlistMsg.isDisplayed();
}
public String getEmptyWishlistMsg() {
	return emptyWishlistMsg.getText();
}

}
