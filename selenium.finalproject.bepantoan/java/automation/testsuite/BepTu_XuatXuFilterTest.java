package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.page.BepTu_XuatXuFilterPage;


public class BepTu_XuatXuFilterTest extends CommonBase {
	public BepTu_XuatXuFilterPage beptu;
	
	@BeforeMethod
	public void openBrowser() {
		driver = initChromeDriver(CT_PageURL.BEP_AN_TOAN);
		beptu = new BepTu_XuatXuFilterPage(driver);
		beptu.navigateToBepTu();
		beptu.clickXemThemButton();
	}
	
	@Test(priority = 1)
	public void FilterCountryWithProductsSuccessfully() {
		beptu.selectCheckboxByCountry("Spain");
		if(isElementPresent(By.xpath("//div[@class='flex flex-wrap product-list']//h4"))) {
			beptu.getAndClickFirstProduct();
			assertTrue(isElementPresent(By.xpath("(//span[text()='Spain'])[1]")));
		}else {
			assertTrue(isElementPresent(By.xpath("//span[text()='Rất tiếc, không tìm thấy sản phẩm phù hợp với lựa chọn của bạn']")));
		}
	}
	
}
