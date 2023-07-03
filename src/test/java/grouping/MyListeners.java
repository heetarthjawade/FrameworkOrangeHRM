package grouping;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners implements ITestListener {
	public void onTestStart(ITestResult result) {
	   System.out.println("onTestStart() -> Test Name: "+result.getName());
	  }
	
	public void onTestSucces(ITestResult result) {
		   System.out.println("onTestSuccess() -> Test Name: "+result.getName());
		  }
	public void onTestFailure(ITestResult result) {
		   System.out.println("onTestFailure() -> Test Name: "+result.getName());
		  }
	public void onTestSkipped(ITestResult result) {
		   System.out.println("onTestSkipped() -> Test Name: "+result.getName());
		  }

	

}
