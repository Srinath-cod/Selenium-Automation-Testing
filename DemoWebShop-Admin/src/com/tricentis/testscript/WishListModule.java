package com.tricentis.testscript;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tricentis.generic.BaseClass;
import com.tricentis.pom.DescriptionPage;
import com.tricentis.pom.HomePage;
import com.tricentis.pom.ProductListPage;
import com.tricentis.pom.WishListPage;

@Listeners(com.tricentis.generic.ListenerImplementation.class)
public class WishListModule extends BaseClass{
	@Test
public void addAndRemoveProduct() throws InterruptedException, EncryptedDocumentException, IOException {
	String data = f.readDataFromExcel("Sheet1", 1, 1);
	String expectedAddedText = f.readDataFromExcel("Sheet1", 1, 3);
	String expectedRemovedText = f.readDataFromExcel("Sheet1", 1, 4);
HomePage h=new HomePage(driver);
h.setSearchBox(data);
ProductListPage p=new ProductListPage(driver);
p.setProductIcon();
DescriptionPage d=new DescriptionPage(driver);
String qty = d.getProductQuanity().getText();
int qtyInNum = Integer.parseInt(qty.replace('(', ' ').replace(')', ' ').trim());
d.getAddToWishlistBtn().click();
Thread.sleep(2000);
String qtyAfterAdding = d.getProductQuanity().getText();
int qtyInNumAfterAdding = Integer.parseInt(qtyAfterAdding.replace('(', ' ').replace(')', ' ').trim());
Assert.assertEquals(qtyInNum+1, qtyInNumAfterAdding);
boolean res = d.getWishlistMsg().isDisplayed();
Assert.assertTrue(res, "Popup is not displayed");
String addedText = d.getWishlistMsg().getText();
Assert.assertEquals(addedText, expectedAddedText);
d.getWishlistLink().click();
WishListPage w=new WishListPage(driver);
w.removeProduct();
boolean res2 = w.getEmptyWishlistMsgIsDisplayed();
Assert.assertTrue(res2, "Item is not removed from wishlist");
String removedText = w.getEmptyWishlistMsg();
Assert.assertEquals(removedText, expectedRemovedText);
}
}
