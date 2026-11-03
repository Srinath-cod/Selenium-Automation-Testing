package com.tricentis.testscript;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tricentis.generic.BaseClass;
@Listeners(com.tricentis.generic.ListenerImplementation.class)
public class AddressModule extends BaseClass{
	@Test
public void addNewAddress() {
	
}
}
