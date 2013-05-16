package amuraco.bug5448;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirefoxDelayedCommandIT {

	private WebDriver driver;
	private WebDriverWait wait;

	@Before
	public void setUp() throws Exception {
		driver = new RemoteWebDriver(
				new URL("http://192.168.9.15:4444/wd/hub"),
				DesiredCapabilities.firefox());
		wait = new WebDriverWait(driver, 30L);
	}

	@Test
	public void test() {
		driver.get("http://192.168.9.12:8080/");
		driver.findElement(id("submitBtn")).click();
		wait.until(invisibilityOfElementLocated(id("submitBtn")));
		wait.until(elementToBeClickable(id("cancelBtn"))).click();
		wait.until(invisibilityOfElementLocated(id("cancelBtn")));
		assertEquals("failed/canceled.", driver.findElement(id("status"))
				.getText());
	}

	@After
	public void after() throws Exception {
		driver.quit();
	}
}
