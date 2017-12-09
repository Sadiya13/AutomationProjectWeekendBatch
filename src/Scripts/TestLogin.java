package Scripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POMPages.LoginPage;
import generic.BaseTest;
import generic.Lib;

public class TestLogin extends BaseTest{
	@Test
	public void testLogin() throws InterruptedException {
		LoginPage l=new LoginPage(driver);
		String un = Lib.getCellValue(Excel_PATH, "ValidLogin", 1, 0);
		String pwd = Lib.getCellValue(Excel_PATH, "ValidLogin", 1, 1);
		String expectedTitle = Lib.getCellValue(Excel_PATH, "ValidLogin", 1, 2);
		l.setUsername(un);
		l.setPassword(pwd);
		l.Login();
		Thread.sleep(5000);
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		SoftAssert s=new SoftAssert();
		s.assertEquals(actualTitle, expectedTitle);
		s.assertAll();
	}

}
