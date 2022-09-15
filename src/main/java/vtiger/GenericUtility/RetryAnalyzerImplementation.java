package vtiger.GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplementation implements IRetryAnalyzer{
	
	int count = 0;
	int retryCount = 4; // manually try and then specify the retry count

	public boolean retry(ITestResult result) {
		
		while (count < retryCount) 
		{
			count++;
			return true;
		}
		return false;
	}

}
