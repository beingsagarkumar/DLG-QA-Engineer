package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Utils;

public class Utils{
	static WebDriver driver = null;
	static Properties props;
	
	public static WebDriver getDriver() {
		try {
			if (driver == null) {
				System.setProperty("webdriver.chrome.silentOutput", "true");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
		}
		catch (Exception e) {
		}
		return driver;
	}
	
// Fetching config.property files properties
	public static String getProperties(String property){
		try{
			props = new Properties();
			props.load(new FileInputStream("src//main//resources//config.properties"));
			}
		catch(Exception exp) {}
		
		return props.getProperty(property);
	}	
	
// Helping method for extent reports
	public static String getReportConfigPath(){
		String reportConfigPath = System.getProperty("user.dir") + getProperties("reportConfigPath");
		System.out.println("Report Path : " + reportConfigPath);
		
		if(reportConfigPath!= null) 
			return reportConfigPath;
		else 
			throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}
	
//	Screenshot capturing
	public static byte[] getByteScreenshot() throws IOException{
	    File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    byte[] fileContent = FileUtils.readFileToByteArray(src);
	    return fileContent;
	}
}