package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.page.BepTu_SoBepFilterPage;

public class BepTu_SoBepFilterTest extends CommonBase{
	public BepTu_SoBepFilterPage beptu;
	
	@BeforeMethod
	public void openBrowser() {
		driver = initChromeDriver(CT_PageURL.BEP_AN_TOAN);
		beptu = new BepTu_SoBepFilterPage(driver);
		beptu.navigateToBepTu();
		beptu.clickXemThemButton();
	}
	
	@Test(priority = 1)
	public void FilterTypeProductsSuccessfully() {
		beptu.selectCheckboxByType("6 bếp");
		if(isElementPresent(By.xpath("//div[@class='flex flex-wrap product-list']//h4"))) {
			beptu.getAndClickFirstProduct();
			assertTrue(isElementPresent(By.xpath("//span[text()='Mô tả sản phẩm']")));
		}else {
			assertTrue(isElementPresent(By.xpath("//span[text()='Rất tiếc, không tìm thấy sản phẩm phù hợp với lựa chọn của bạn']")));
		}
		
	}
	
}
