package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.page.BepTu_HangSanXuatFilterPage;

public class BepTu_HangSanXuatFilterTest extends CommonBase {
	public BepTu_HangSanXuatFilterPage beptu;

	@BeforeMethod
	public void openBrowser() {
		driver = initChromeDriver(CT_PageURL.BEP_AN_TOAN);
		beptu = new BepTu_HangSanXuatFilterPage(driver);
		beptu.navigateToBepTu();
		beptu.clickXemThemButton();
	}

	@Test(priority = 1)
	public void testFilterByBoschSuccessfully() {
		beptu.selectBrand("Bếp%20An%20Toàn");
	   
	    List<WebElement> products = beptu.getProductNames();
	    
	    // Kiểm tra tất cả sản phẩm có chứa tên "bosch"
	    for (WebElement product : products) {
	    	System.out.println("Sản phầm: " + product.getText());
	        assertTrue(product.getText().toLowerCase().contains("bosch"), "Sản phẩm không chứa tên hãng 'bosch': " + product.getText());
	    }

	}
	
//	@Test(priority = 2)
//	public void testFilterByKainerSuccessfully() {
//		beptu.selectBrand("Kainer");
//	   
//	    List<WebElement> products = beptu.getProductNames();
//	    
//	    // Kiểm tra tất cả sản phẩm có chứa tên "Kainer"
//	    for (WebElement product : products) {
//	    	System.out.println("Sản phầm: " + product.getText());
//	        assertTrue(product.getText().toLowerCase().contains("kainer"), "Sản phẩm không chứa tên hãng 'Kainer': " + product.getText());
//	    }
//
//	}
//	
//	@Test(priority = 3)
//	public void testFilterByBinovaSuccessfully() {
//		beptu.selectBrand("Binova");
//	   
//	    List<WebElement> products = beptu.getProductNames();
//	    
//	    // Kiểm tra tất cả sản phẩm có chứa tên "Binova"
//	    for (WebElement product : products) {
//	    	System.out.println("Sản phầm: " + product.getText());
//	        assertTrue(product.getText().toLowerCase().contains("binova") || product.getText().toLowerCase().contains("bi"), "Sản phẩm không chứa tên hãng 'Binova': " + product.getText());
//	    }
//
//	}
//	
//	@Test(priority = 4)
//	public void testFilterByFagorSuccessfully() {
//		beptu.selectBrand("Fagor");
//	   
//	    List<WebElement> products = beptu.getProductNames();
//	    
//	    // Kiểm tra tất cả sản phẩm có chứa tên "Fagor"
//	    for (WebElement product : products) {
//	    	System.out.println("Sản phầm: " + product.getText());
//	        assertTrue(product.getText().toLowerCase().contains("fagor") || product.getText().toLowerCase().contains("if"), "Sản phẩm không chứa tên hãng 'Fagor': " + product.getText());
//	    }
//
//	}
//	
//	@Test(priority = 5)
//	public void testFilterByCanzySuccessfully() {
//		beptu.selectBrand("Canzy");
//	   
//	    List<WebElement> products = beptu.getProductNames();
//	    
//	    // Kiểm tra tất cả sản phẩm có chứa tên "Canzy"
//	    for (WebElement product : products) {
//	    	System.out.println("Sản phầm: " + product.getText());
//	        assertTrue(product.getText().toLowerCase().contains("canzy") || product.getText().toLowerCase().contains("cz"), "Sản phẩm không chứa tên hãng 'Canzy': " + product.getText());
//	    }
//
//	}
//	
//	@Test(priority = 6)
//	public void testFilterByEurosunSuccessfully() {
//		beptu.selectBrand("Eurosun");
//	   
//	    List<WebElement> products = beptu.getProductNames();
//	    
//	    // Kiểm tra tất cả sản phẩm có chứa tên "Eurosun"
//	    for (WebElement product : products) {
//	    	System.out.println("Sản phầm: " + product.getText());
//	        assertTrue(product.getText().toLowerCase().contains("eurosun") || product.getText().toLowerCase().contains("eu"), "Sản phẩm không chứa tên hãng 'Eurosun': " + product.getText());
//	    }
//
//	}
//	
//	@Test(priority = 7)
//	public void testFilterByNapoliSuccessfully() {
//		beptu.selectBrand("Napoli");
//	   
//	    List<WebElement> products = beptu.getProductNames();
//	    
//	    // Kiểm tra tất cả sản phẩm có chứa tên "Napoli"
//	    for (WebElement product : products) {
//	    	System.out.println("Sản phầm: " + product.getText());
//	        assertTrue(product.getText().toLowerCase().contains("napoli"), "Sản phẩm không chứa tên hãng 'Eurosun': " + product.getText());
//	    }
//
//	}
	
	
}
