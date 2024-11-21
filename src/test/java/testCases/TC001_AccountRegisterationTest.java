package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.*;

public class TC001_AccountRegisterationTest extends BaseClass
{	
	
	@Test
	public void verifyAccount() throws InterruptedException
	{
		HomePage hm=new HomePage(driver);
		Thread.sleep(5000);
		try
		{
		hm.clickMyAccount();
		hm.clickRegister();
		
		AccountRegistrationPage accReg=new AccountRegistrationPage(driver);
		accReg.setFirstName("Shanvi");
		accReg.setLastName("S");
		accReg.setEmail("Shanvi@gmail.com");
		accReg.setTelephone("12345678");
		accReg.setPassword("shanvi123");
		accReg.setConfirmPassword("shanvi123");
		accReg.setPrivacyPolicy();
		accReg.clickContinue();
		String confMsg=accReg.getConfirmationMsg();
		Assert.assertEquals(confMsg, "Your Account Has Been Created!");
		System.out.println("Success");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
	}
	

}
