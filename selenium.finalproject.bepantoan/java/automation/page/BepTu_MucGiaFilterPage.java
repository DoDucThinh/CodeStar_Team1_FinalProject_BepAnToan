package automation.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automation.common.CommonBase;

public class BepTu_MucGiaFilterPage extends CommonBase{
	private WebDriver driver;
	
	public BepTu_MucGiaFilterPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void navigateToBepTu() {
		click(By.xpath("//a[text()=' Bếp Từ ']"));
	}
	
	public void filterNhoHon3Trieu() {
		click(By.xpath("//span[contains(text(),'< 3.000.000')]"));
	}
	
		public void filterLonHon3TrieuNhoHon5Trieu() {
			click(By.xpath("//span[contains(text(),'3.000.000 > 5.000.000')]"));
		}
	
	public void filterLonHon5TrieuNhoHon10Trieu() {
		click(By.xpath("//span[contains(text(),'5.000.000 > 10.000.000')]"));
	}
	
	public void filterLonHon10TrieuNhoHon15Trieu() {
		click(By.xpath("(//span[contains(text(),'> 15.000.000')])[1]"));
	}
	
	public void filterLonHon15Trieu() {
		click(By.xpath("(//span[contains(text(),'> 15.000.000')])[2]"));
	}

	public List<WebElement> getProductPrices() {
	    if (isElementPresent(By.xpath("//div[@class='flex flex-wrap product-list']"))) {
	    	scrollToElement(By.xpath("//div[@class='flex flex-wrap product-list']"));
	        List<WebElement> priceElements = driver.findElements(By.xpath("//span[contains(@class,'text-maroon-500 sale-price')] | //div[contains(@class,'text-maroon-500 sale-price')]"));
	        return priceElements;
	    }
	    return new ArrayList<>();
	}
}
