package com.tricentis.testscript;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tricentis.generic.BaseClass;

@Listeners(com.tricentis.generic.ListenerImplementation.class)
public class CartModule extends BaseClass{
	@Test
	public void purchaseProduct() {
		
	}

}
