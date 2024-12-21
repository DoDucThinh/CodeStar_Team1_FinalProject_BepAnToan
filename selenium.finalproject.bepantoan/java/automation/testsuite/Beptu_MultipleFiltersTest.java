package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.page.BepTu_HangSanXuatFilterPage;
import automation.page.BepTu_MucGiaFilterPage;
import automation.page.BepTu_SoBepFilterPage;
import automation.page.BepTu_XuatXuFilterPage;

public class Beptu_MultipleFiltersTest extends CommonBase{
	public BepTu_HangSanXuatFilterPage hangSanXuat;
	public BepTu_MucGiaFilterPage mucGia;
	public BepTu_XuatXuFilterPage xuatXu;
	public BepTu_SoBepFilterPage soBep;
	
	@BeforeMethod
	public void openBrowser() {
		driver = initChromeDriver(CT_PageURL.BEP_AN_TOAN);
		hangSanXuat = new BepTu_HangSanXuatFilterPage(driver);
		mucGia = new BepTu_MucGiaFilterPage(driver);
		xuatXu = new BepTu_XuatXuFilterPage(driver);
		soBep = new BepTu_SoBepFilterPage(driver);
		
		hangSanXuat.navigateToBepTu();
	}
	
	@Test
	public void multipleFiltersSuccessfully() throws InterruptedException {
		hangSanXuat.clickXemThemButton();
		hangSanXuat.selectBrand("Bosch");
		System.out.println("Clicking on Hãng sản xuất...");
		Thread.sleep(1000);
		mucGia.filterLonHon5TrieuNhoHon10Trieu();
		System.out.println("Clicking on Mức giá...");
		Thread.sleep(1000);
		xuatXu.clickXemThemButton();
		Thread.sleep(1000);
		xuatXu.selectCheckboxByCountry("Spain");
		System.out.println("Clicking on Xuất xứ...");
		Thread.sleep(1000);
		soBep.selectCheckboxByType("1 bếp");
		System.out.println("Clicking on Xuất xứ...");
		
		if (isElementPresent(By.xpath("//div[@class='flex flex-wrap product-list']//h4"))) {
		    soBep.getAndClickFirstProduct();
		    assertTrue(isElementPresent(By.xpath("//span[text()='Mô tả sản phẩm']")));
		} else if (isElementPresent(By.xpath("//span[text()='Rất tiếc, không tìm thấy sản phẩm phù hợp với lựa chọn của bạn']"))) {
		    System.out.println("Rất tiếc, không tìm thấy sản phẩm phù hợp với lựa chọn của bạn.");
		} else {
		    System.out.println("Không tìm thấy phần tử danh sách sản phẩm hoặc thông báo lỗi.");
		}

		
	}
}
