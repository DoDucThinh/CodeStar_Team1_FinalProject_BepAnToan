package automation.testsuite;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.page.MayRuaChenBat_Page;

public class SortMayRuaChenBatTest extends CommonBase {
	@BeforeMethod
	public void OpenFireFox() {
		driver = initFireFox(CT_PageURL.BEP_AN_TOAN);

	}

	@Test(priority = 1)
	public void SortHang() throws InterruptedException {
		MayRuaChenBat_Page sortHang = new MayRuaChenBat_Page(driver);
		sortHang.mayRuaChenBat();
		sortHang.sortHang();
		Thread.sleep(3000);
//Duyệt qua các danh sách( kể cả phân trang)
//		while (true) {
//			try {
//				WebElement linkPhanTrang = driver.findElement(By.xpath("//span[@class='relative z-10']//parent::a"));
//
//				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});",
//						linkPhanTrang);
//
//				if (!linkPhanTrang.isDisplayed()) {
//					break;
//				}
//
//				// scrollToElement(By.xpath("//span[@class='relative z-10']//parent::a"));
//				sortHang.clickXemThem();
//				Thread.sleep(3000);
//			} catch (NoSuchElementException | StaleElementReferenceException e) {
//				break;
//			} catch (Exception e) {
//				e.printStackTrace();
//				break;
//			}
//		}

		List<WebElement> ptoductList = driver.findElements(By.xpath("//div[@class='flex flex-wrap product-list']/a"));

		String originalWindow = driver.getWindowHandle();

		Actions actions = new Actions(driver);

		for (WebElement item : ptoductList) {
			// dùng để scroll tới vị trí của element
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);
			// click chuyển qua tab mới
			actions.keyDown(Keys.CONTROL).click(item).keyUp(Keys.CONTROL).build().perform();
			Thread.sleep(5000);
			Set<String> allWindows = driver.getWindowHandles();

			// Chuyển qua tab chi tiết
			for (String window : allWindows) {
				if (!window.equals(originalWindow)) {
					driver.switchTo().window(window);
					break;
				}
			}

			WebElement detailElement = driver
					.findElement(By.xpath("(//span[@class='font-bold uppercase text-maroon-600'])[1]"));
			String detailTitle = detailElement.getText();

			System.out.println("Tên sản phẩm trong trang chi tiết: " + detailTitle);

			// Kiểm tra dữ liệu
			assertTrue(detailTitle.toLowerCase().contains("bosch"));

			// ===== Đóng tab chi tiết và quay về tab gốc =====
			driver.close(); // Đóng tab chi tiết
			driver.switchTo().window(originalWindow);
		}
	}

	@Test(priority = 2)
	public void SortXuatSu() throws InterruptedException {
		MayRuaChenBat_Page sortXuatSu = new MayRuaChenBat_Page(driver);
		sortXuatSu.mayRuaChenBat();
		Thread.sleep(5000);
		scrollToElement(By.xpath("//h3[text()='Kích Thước']"));
		sortXuatSu.sortXuatSu();
		Thread.sleep(5000);
		List<WebElement> ptoductList = driver.findElements(By.xpath("//div[@class='flex flex-wrap product-list']/a"));
		// lấy tab hiện tại
		String originalWindow = driver.getWindowHandle();
		Actions actions = new Actions(driver);

		for (WebElement item : ptoductList) {
			// dùng để scroll tới vị trí của element
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);
			// click chuyển qua tab mới
			actions.keyDown(Keys.CONTROL).click(item).keyUp(Keys.CONTROL).build().perform();
			Thread.sleep(5000);
			Set<String> allWindows = driver.getWindowHandles();

			// Chuyển qua tab chi tiết
			// sau đó kiểm tra nếu đang ở màn hình chính thì chuyển qua tab khác
			for (String window : allWindows) {
				if (!window.equals(originalWindow)) {
					driver.switchTo().window(window);
					break;
				}
			}

			//lấy thành phần muốn so sánh
			WebElement detailElement = driver
					.findElement(By.xpath("(//span[@class='font-bold uppercase text-maroon-600'])[2]"));
			String detailTitle = detailElement.getText();

			System.out.println("Tên sản phẩm trong trang chi tiết: " + detailTitle);

			// Kiểm tra dữ liệu
			assertTrue(detailTitle.toLowerCase().contains("germany"));

			// ===== Đóng tab chi tiết và quay về tab gốc =====
			driver.close(); // Đóng tab chi tiết
			driver.switchTo().window(originalWindow);
		}
	}
	
//	@Test
//	public void SortSoBo() throws InterruptedException {
//		MayRuaChenBat_Page sortXuatSu = new MayRuaChenBat_Page(driver);
//		sortXuatSu.mayRuaChenBat();
//		scrollToElement(By.xpath("//h3[text()='Kích Thước']"));
//		sortXuatSu.sortSoBo();
//		
//		List<WebElement> ptoductList = driver.findElements(By.xpath("//div[@class='flex flex-wrap product-list']/a"));
//		// lấy tab hiện tại
//		String originalWindow = driver.getWindowHandle();
//		Actions actions = new Actions(driver);
//
//		for (WebElement item : ptoductList) {
//			// dùng để scroll tới vị trí của element
//			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);
//			// click chuyển qua tab mới
//			actions.keyDown(Keys.CONTROL).click(item).keyUp(Keys.CONTROL).build().perform();
//			Thread.sleep(2000);
//			Set<String> allWindows = driver.getWindowHandles();
//
//			// Chuyển qua tab chi tiết
//			// sau đó kiểm tra nếu đang ở màn hình chính thì chuyển qua tab khác
//			for (String window : allWindows) {
//				if (!window.equals(originalWindow)) {
//					driver.switchTo().window(window);
//					break;
//				}
//			}
//
//			//lấy thành phần muốn so sánh
//			WebElement detailElement = driver
//					.findElement(By.xpath("//span[text()[contains(.,'10 bộ')]]"));
//			String detailTitle = detailElement.getText();
//
//			System.out.println("Tên sản phẩm trong trang chi tiết: " + detailTitle);
//
//			// Kiểm tra dữ liệu
//			assertTrue(detailTitle.toLowerCase().contains("10 bộ"));
//
//			// ===== Đóng tab chi tiết và quay về tab gốc =====
//			driver.close(); // Đóng tab chi tiết
//			driver.switchTo().window(originalWindow);
//		}
//	}
	
	@Test(priority = 3)
	public void SortGia() throws InterruptedException {
		MayRuaChenBat_Page sortXuatSu = new MayRuaChenBat_Page(driver);
		sortXuatSu.mayRuaChenBat();
		Thread.sleep(7000);
		scrollToElement(By.xpath("//h3[text()='Kích Thước']"));
		sortXuatSu.sortGia();
		Thread.sleep(7000);
		List<WebElement> ptoductList = driver.findElements(By.xpath("//div[@class='flex flex-wrap product-list']/a"));
	
		for (WebElement item : ptoductList) {

			// Chuyển qua tab chi tiết
			// sau đó kiểm tra nếu đang ở màn hình chính thì chuyển qua tab khác

			//lấy thành phần muốn so sánh
			WebElement price = item.findElement(By.xpath(".//span[@class='text-base font-bold md:text-lg text-maroon-500 sale-price']"));
			String priceString = price.getText().replace("₫", "").replace(".", "").trim();

			//WebElement namePro = item.findElement(By.cssSelector("span.sale-price"));
			//System.out.println(namePro.getText());
			
			System.out.println("Tên sản phẩm trong trang chi tiết: " + priceString);
			int giaTien = Integer.parseInt(priceString);
			// Kiểm tra dữ liệu
			assertTrue(giaTien >= 5000000 && giaTien <= 10000000);

			
		}
	}
	
	// Test trường hợp không có dữ liệu khi sort theo xuất sứ (các loại lọc khác tương tự)
	@Test(priority = 4)
	public void SortXuatSuFail() throws InterruptedException {
		MayRuaChenBat_Page sortXuatSuFail = new MayRuaChenBat_Page(driver);
		sortXuatSuFail.mayRuaChenBat();
		Thread.sleep(5000);
		scrollToElement(By.xpath("//h3[text()='Kích Thước']"));
		sortXuatSuFail.sortXuatSuFail();
		Thread.sleep(5000);
		assertTrue(isElementPresent(By.xpath("//span[text()='Rất tiếc, không tìm thấy sản phẩm phù hợp với lựa chọn của bạn']")));
		
		
	}

}
