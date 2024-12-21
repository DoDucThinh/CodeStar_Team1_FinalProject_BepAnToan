package automation.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automation.common.CommonBase;

public class BepTu_XuatXuFilterPage extends CommonBase {

	private WebDriver driver;

	public BepTu_XuatXuFilterPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void navigateToBepTu() {
		click(By.xpath("//a[text()=' Bếp Từ ']"));
	}

	public void clickXemThemButton() {
		click(By.xpath("(//span[text()='Xem thêm'])[2]"));
	}

	// Hàm chọn checkbox theo quốc gia
	public void selectCheckboxByCountry(String country) {
		String xpath = "//div[@class='grid gap-x-[4px] grid-cols-2']//label[span[contains(text(), '" + country
				+ "')]]/input";
		WebElement checkbox = driver.findElement(By.xpath(xpath));
		if (!checkbox.isSelected()) {
			checkbox.click();
			System.out.println("Đã chọn: " + country);
		} else {
			System.out.println(country + "Đã được chọn mặc định");
		}
	}

	public void getAndClickFirstProduct() {
		if (isElementPresent(By.xpath("//div[@class='flex flex-wrap product-list']"))) {
			scrollToElement(By.xpath("//div[@class='flex flex-wrap product-list']"));

			List<WebElement> productElements = driver
					.findElements(By.xpath("//div[@class='flex flex-wrap product-list']//h4"));
			
			System.out.println("---Danh sách bếp từ được tìm thấy---");
			if (!productElements.isEmpty()) {
				for (WebElement product : productElements) {
	                System.out.println(product.getText());
	            }
				productElements.get(0).click();
			} else {
				System.out.println("Không có sản phẩm nào.");
			}
		} else {
			System.out.println("Danh sách sản phẩm không tồn tại.");
		}
	}

}
