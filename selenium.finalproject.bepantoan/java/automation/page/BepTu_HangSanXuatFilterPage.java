package automation.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import automation.common.CommonBase;

public class BepTu_HangSanXuatFilterPage extends CommonBase {
	private WebDriver driver;

	public BepTu_HangSanXuatFilterPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void navigateToBepTu() {
		click(By.xpath("//a[text()=' Bếp Từ ']"));
	}

	public void clickXemThemButton() {
		click(By.xpath("(//span[text()='Xem thêm'])[1]"));
	}

	// Phương thức chọn bộ lọc theo hãng
	public void selectBrand(String brand) {
		click(By.xpath("//a[@href='/danh-muc/bep-tu/" + brand.toLowerCase() + "']"));

	}
	
	public List<WebElement> getProductNames() {
	    if (isElementPresent(By.xpath("//div[@class='flex flex-wrap product-list']"))) {
	    	scrollToElement(By.xpath("//div[@class='flex flex-wrap product-list']"));
	        List<WebElement> productElements = driver.findElements(By.xpath("//div[@class='flex flex-wrap product-list']//h4"));
	        return productElements;
	    }
	    return new ArrayList<>();
	}

	
}
