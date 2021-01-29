package jp.kmb;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChangePassword {

	private WebDriver driver;

	public ChangePassword(WebDriver driver) {
		this.driver = driver;
	}

	public void changeProcess() {
		try {
			loginProcess();
			// ログイン後の画面チェック。移動後のページにあるエレメントの有無を確認する。
			driver.findElement(By.className("ELEMENT_NAME"));
			
		} catch (NoSuchElementException e) {
			System.out.println("ログインに失敗しました。ID/パスワード、アカウントがロックされていないかご確認ください。");
//			System.exit(-1);
		}
	}

	private void loginProcess() {
		WebElement loginID = driver.findElement(By.name("loginID_ELEMENT_NAME"));
		WebElement password = driver.findElement(By.name("Password_ELEMENT_NAME"));
		WebElement loginButton = driver.findElement(By.name("Submit_ELEMENT_NAME"));

		loginID.sendKeys("LOGINID");
		password.sendKeys("LOGINPASSWORD");
		loginButton.click();
	}

}
