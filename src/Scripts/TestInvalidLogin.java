package Scripts;

import org.testng.annotations.Test;

import POMPages.LoginPage;
import generic.BaseTest;
import generic.Lib;

public class TestInvalidLogin extends BaseTest{
	@Test
	public void testInvalidLogin() throws InterruptedException{
		LoginPage l=new LoginPage(driver);
		int rowCount = Lib.getRowCount(Excel_PATH, "InvalidLogin");
		System.out.println(rowCount);
		for(int i=1;i<=rowCount;i++) {
			String un = Lib.getCellValue(Excel_PATH, "InvalidLogin", i, 0);
			String pw = Lib.getCellValue(Excel_PATH, "InvalidLogin", i, 1);
			l.setUsername(un);
			l.setPassword(pw);
			l.Login();
		}
	}
}