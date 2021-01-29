package jp.kmb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class chromeDriverCheck {

	public static void openchrome() {

		WebDriver driver = null;

		try {

			driver = downloadWebDriver();
			// driver.get("https://www.google.co.jp");

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get("TEST_TARGET_URL");
			@SuppressWarnings("unused")
			WebElement loginButton = driver.findElement(By.name("Submit_ELEMENT_NAME"));

			ChangePassword cp = new ChangePassword(driver);
			cp.changeProcess();

		} catch (NoSuchElementException e) {
			System.out.println("ページの読み込みに失敗しました。(読み込み待ち時間超過)");
			e.printStackTrace();
		} catch (Exception e) {

		} finally {
			if (driver != null) {
				// driver.quit();
			}
		}
	}

	private static WebDriver downloadWebDriver() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		return driver;

	}
}
