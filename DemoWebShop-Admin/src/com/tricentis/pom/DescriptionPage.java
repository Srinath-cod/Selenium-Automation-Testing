package com.tricentis.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DescriptionPage {
@FindBy(xpath = "//span[text()='Wishlist']/following-sibling::span[@class='wishlist-qty']")
private WebElement productQuanity;
@FindBy(xpath = "//input[@value='Add to wishlist']")
private WebElement addToWishlistBtn;
@FindBy(xpath = "//*[@class='content']")
private WebElement wishlistMsg;
@FindBy(xpath = "//span[text()='Wishlist']")
private WebElement wishlistLink;

public DescriptionPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getProductQuanity() {
	return productQuanity;
}

public WebElement getAddToWishlistBtn() {
	return addToWishlistBtn;
}

public WebElement getWishlistMsg() {
	return wishlistMsg;
}

public WebElement getWishlistLink() {
	return wishlistLink;
}

}
