package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.page.BepTu_MucGiaFilterPage;

public class BepTu_MucGiaFilterTest extends CommonBase{
	public BepTu_MucGiaFilterPage beptu;

	@BeforeMethod
	public void openBrowser() {
		driver = initChromeDriver(CT_PageURL.BEP_AN_TOAN);
		beptu = new BepTu_MucGiaFilterPage(driver);
		beptu.navigateToBepTu();
	}
	
	@Test(priority = 1)
	public void filterNhoHon3TrieuSuccessfully() {
		beptu.filterNhoHon3Trieu();
		
		List<WebElement> products = beptu.getProductPrices();
		
		// Kiểm tra tất cả sản phẩm có chứa giá nhỏ hơn 3tr
	    for (WebElement product : products) {
	    	String priceText = product.getText().toLowerCase();

	        if (priceText.contains("liên hệ")) {
	            System.out.println("Sản phẩm không có giá cụ thể: " + product.getText());
	            continue;
	        }
	        // Loại bỏ ký tự không phải số và chuyển đổi thành số nguyên
	        int price = Integer.parseInt(priceText.replaceAll("[^\\d]", ""));
	        assertTrue(price < 3000000, "Sản phẩm có giá lớn hơn 3 triệu: " + priceText);
	    }
	}
	
	@Test(priority = 2)
	public void filterLonHon3TrieuNhoHon5TrieuSuccessfully() {
		beptu.filterLonHon3TrieuNhoHon5Trieu();
		
		List<WebElement> products = beptu.getProductPrices();
		
		// Kiểm tra tất cả sản phẩm có chứa giá lớn hơn 3tr nhỏ hơn 5tr
	    for (WebElement product : products) {
	    	String priceText = product.getText().toLowerCase();

	        if (priceText.contains("liên hệ")) {
	            System.out.println("Sản phẩm không có giá cụ thể: " + product.getText());
	            continue;
	        }
	        // Loại bỏ ký tự không phải số và chuyển đổi thành số nguyên
	        int price = Integer.parseInt(priceText.replaceAll("[^\\d]", ""));
	        assertTrue(price >= 3000000 && price <= 5000000, "Sản phẩm có giá không nằm trong khoảng 3 - 5 triệu: " + priceText);
	    }
	}
	
	@Test(priority = 3)
	public void filterLonHon5TrieuNhoHon10TrieuSuccessfully() {
		beptu.filterLonHon5TrieuNhoHon10Trieu();
		
		List<WebElement> products = beptu.getProductPrices();
		
		// Kiểm tra tất cả sản phẩm có chứa giá lớn hơn 5tr nhỏ hơn 10tr
	    for (WebElement product : products) {
	    	String priceText = product.getText().toLowerCase();

	        if (priceText.contains("liên hệ")) {
	            System.out.println("Sản phẩm không có giá cụ thể: " + product.getText());
	            continue;
	        }
	        // Loại bỏ ký tự không phải số và chuyển đổi thành số nguyên
	        int price = Integer.parseInt(priceText.replaceAll("[^\\d]", ""));
	        assertTrue(price >= 5000000 && price <= 10000000, "Sản phẩm có giá không nằm trong khoảng 5 - 10 triệu: " + priceText);
	    }
	}
	
	@Test(priority = 4)
	public void filterLonHon10TrieuNhoHon15TrieuSuccessfully() {
		beptu.filterLonHon10TrieuNhoHon15Trieu();
		
		List<WebElement> products = beptu.getProductPrices();
		
		// Kiểm tra tất cả sản phẩm có chứa giá lớn hơn 10tr nhỏ hơn 15tr
	    for (WebElement product : products) {
	    	String priceText = product.getText().toLowerCase();

	        if (priceText.contains("liên hệ")) {
	            System.out.println("Sản phẩm không có giá cụ thể: " + product.getText());
	            continue;
	        }
	        // Loại bỏ ký tự không phải số và chuyển đổi thành số nguyên
	        int price = Integer.parseInt(priceText.replaceAll("[^\\d]", ""));
	        assertTrue(price >= 10000000 && price <= 15000000, "Sản phẩm có giá không nằm trong khoảng 10 - 15 triệu: " + priceText);
	    }
	}
	
	@Test(priority = 5)
	public void filterLonHon15TrieuSuccessfully() {
		beptu.filterLonHon15Trieu();
		
		List<WebElement> products = beptu.getProductPrices();
		
		// Kiểm tra tất cả sản phẩm có chứa giá lớn hơn 15tr
	    for (WebElement product : products) {
	    	String priceText = product.getText().toLowerCase();

	        if (priceText.contains("liên hệ")) {
	            System.out.println("Sản phẩm không có giá cụ thể: " + product.getText());
	            continue;
	        }
	        // Loại bỏ ký tự không phải số và chuyển đổi thành số nguyên
	        int price = Integer.parseInt(priceText.replaceAll("[^\\d]", ""));
	        assertTrue(price >= 15000000, "Sản phẩm có giá nhỏ hơn 15 triệu: " + priceText);
	    }
	}
}
