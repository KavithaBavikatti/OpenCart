package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.BaseTestMethod;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.*;

public class TC002_LoginTest extends BaseClass{
	
	@Test
	public void verify_Login()
	{
	
		try
		{
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//MyAccount
		MyAccountPage mp=new MyAccountPage(driver);
		boolean myacc=mp.isMyAccountExists();
		Assert.assertTrue(myacc);
		}
		catch (Exception e) {
			Assert.fail();
			// TODO: handle exception
		}
	}

}
