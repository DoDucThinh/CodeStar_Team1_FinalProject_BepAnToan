package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.page.BepDienTu_FilterPage;

public class BepDienTu_FilterTest extends CommonBase{
	BepDienTu_FilterPage filterPage;
	
	@BeforeMethod
    public void setUp() {
        // Mở trang web bepantoan.vn
        driver = initChromeDriver("https://bepantoan.vn");
        filterPage = new BepDienTu_FilterPage(driver)
        		;
    }

    @Test (priority = 1)
    public void testFilterByBrand() throws InterruptedException {
        // Bước 1: Click vào danh mục "Máy rửa chén bát"
        filterPage.clickHoodCategory();
        //Bước 2: Chọn lọc theo thương hiệu
        filterPage.clickfilterByBrand();
        Thread.sleep(1000); // Chờ để bộ lọc được chọn
        // Bước 3: Kiểm tra tiêu đề của trang lọc
        String title = filterPage.getFilterResultTitle();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Top Máy hút mùi tốt nhất cho gia đình')]")).isDisplayed());
        
        
    }
        
     
        @Test (priority = 2)
        public void testFilterByPrice() throws InterruptedException {
            // Bước 1: Click vào danh mục "Máy rửa chén bát"
            filterPage.clickHoodCategory();
            // Bước 2: Click Chọn lọc theo giá
            filterPage.filterByPrice();
            //Thread.sleep(1000); // Chờ để bộ lọc được chọn
            // Bước 3: Kiểm tra tiêu đề của trang lọc
            String title = filterPage.getFilterResultTitle();
            assertTrue(driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/main/section[1]/div/div[1]/div[2]/div[1]/div[1]/div[1]/h2")).isDisplayed());
            // Bước 4: Kiểm tra danh sách sản phẩm có hiển thị không
            assertTrue(filterPage.isProductListDisplayed(),"Danh sách sản phẩm không hiển thị!");   
    }
        @Test (priority = 3)
        public void testFilterByBowlSizeAndOrigin() {
        	// Bước 1: Click vào danh mục "Máy rửa chén bát"
            filterPage.clickHoodCategory();
        	// Chọn số bộ
            filterPage.selectBowlSize();
            // Chọn xuất xứ
            filterPage.selectOrigin();
            // Kiểm tra danh sách sản phẩm được hiển thị
            assertTrue(filterPage.isProductListDisplayed(), "Danh sách sản phẩm không hiển thị!");
        }

}
