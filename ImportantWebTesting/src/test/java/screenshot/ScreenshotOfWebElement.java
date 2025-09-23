package screenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotOfWebElement {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://way2automation.com/way2auto_jquery/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement name = driver.findElement(By.xpath("//*[@id=\"load_form\"]/fieldset[1]/input"));
		File namesrc = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(namesrc, new File("./screenshot/elementname.jpg"));
	
		WebElement phone = driver.findElement(By.xpath("//*[@id=\"load_form\"]/fieldset[2]/input"));
		File phonesrc = phone.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(phonesrc, new File("./screenshot/elementphone.jpg"));

	}

}
