package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerPractice {
	
	@Test(retryAnalyzer = vtiger.GenericUtility.RetryAnalyzerImplementation.class)
	public void retryPractice()
	{
		System.out.println("Hi");
		Assert.fail();
	}
	
}
