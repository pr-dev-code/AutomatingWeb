package screenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageAndFullPageScreenshot {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://way2automation.com/way2auto_jquery/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		if(driver instanceof ChromeDriver) {
		File page =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(page, new File("./screenshot/page.jpg"));
		}else if(driver instanceof FirefoxDriver) {
		
		File fullpage = ((FirefoxDriver)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fullpage, new File("./screenshot/fullpage.jpg"));
		}

	}

}
