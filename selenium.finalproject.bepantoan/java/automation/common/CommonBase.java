package automation.common;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonBase {
	public static WebDriver driver;
	public int initWaitTime = 30;

	public WebDriver initChromeDriver(String URL) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		System.out.println("user.dir is: " + System.getProperty("user.dir"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(initWaitTime, TimeUnit.SECONDS);
		return driver;
	}

	public WebDriver initFireFox(String URL) {
		System.setProperty("webdriver.firefox,driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(initWaitTime, TimeUnit.SECONDS);
		return driver;

	}

	public WebDriver initEdge(String URL) {
		System.setProperty("webdriver.edge,driver", System.getProperty("user.dir") + "\\driver\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(initWaitTime, TimeUnit.SECONDS);
		return driver;

	}

	// Thay cho hàm isDisplayed
	public boolean isElementPresent(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
			wait.until(ExpectedConditions.visibilityOf(getElementPresentDOM(locator)));
			return getElementPresentDOM(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		} catch (org.openqa.selenium.TimeoutException e2) {
			return false;
		}
	}

	// Thay cho hàm findElement(locator)
	private WebElement getElementPresentDOM(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator);
	}

	// Thay cho webelement.click()
	public void click(By locator) {
		WebElement element = getElementPresentDOM(locator);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	// Thay cho hàm senkeys
	public void type(By locator, String value) {
		WebElement element = getElementPresentDOM(locator);
		element.clear();
		element.sendKeys(value);
	}

	// scroll
	public void scrollToElement(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = getElementPresentDOM(locator);
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	private WebDriver initChromeDriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		System.out.println("user.dir is: " + System.getProperty("user.dir"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(initWaitTime, TimeUnit.SECONDS);
		return driver;
	}

	private WebDriver initFireFoxDriver() {
		System.setProperty("webdriver.firefox,driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(initWaitTime, TimeUnit.SECONDS);
		return driver;

	}

	private WebDriver initMSEdgeDriver() {
		System.setProperty("webdriver.edge,driver", System.getProperty("user.dir") + "\\driver\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(initWaitTime, TimeUnit.SECONDS);
		return driver;

	}

	public WebDriver setupDriver(String browserName) {
		switch (browserName.trim()) {
		case "chrome":
			System.out.println("Initialize chrome browser....");
			initChromeDriver();
			break;
		case "firefox":
			System.out.println("Initialize firefox browser....");
			initFireFoxDriver();
			break;
		case "edge":
			System.out.println("Initialize edge browser....");
			initMSEdgeDriver();
			break;
		default:
			System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
			initChromeDriver();
		}
		return driver;
	}
}
