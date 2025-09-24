package screenshotutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TimeStampScreenshot2 {

	public static WebDriver driver;

	public static void captureScreenshot() throws IOException {
		
		Date d = new Date();
		String name = d.toString().replace(":", "_").replace(" ", "_");
        if(driver instanceof ChromeDriver) {
		File page = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(page, new File("./screenshot/"+name+".jpg"));
        }else if(driver instanceof FirefoxDriver) {
        	
        	File fullpage = ((FirefoxDriver) driver).getScreenshotAs(OutputType.FILE);
    		FileUtils.copyFile(fullpage, new File("./screenshot/"+name+".jpg"));
        	
        }

	}

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.way2automation.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		captureScreenshot();

	}

}
