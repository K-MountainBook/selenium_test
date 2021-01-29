package jp.kmb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class firefoxDriverCheck {

	public static void openff() {

		WebDriver driver = null;

		try {

			driver = downloadWebDriver();
			// driver.get("https://www.google.co.jp");

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();

		return driver;

	}
}
