package automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BepDienTu_FilterPage {
	WebDriver driver;

    // Phần tử danh mục "Máy rửa chén bát"
    @FindBy(xpath = "//*[@id=\"__layout\"]/div/header/div[1]/section/div/div/ul/li[3]/a")
    WebElement hoodCategoryLink;
    
    // phần tử danh mục "bếp từ"
    @FindBy(xpath = "//*[@id=\"__layout\"]/div/header/div[1]/section/div/div/ul/li[1]/a")
    WebElement hoodCategoryLink1;
    // Bộ lọc thương hiệu (ví dụ: "Brand bosch")
    @FindBy(xpath = "//a[@href='/danh-muc/may-hut-mui/bosch']")
    WebElement brandFilter;
    // Bộ lọc giá (ví dụ: khoảng giá từ 5-10 triệu)
    @FindBy(xpath = "//span[contains(text(),'5.000.000 > 10.000.000')]")
    WebElement priceFilter;
    // Tiêu đề trang đã lọc
    @FindBy(css = "h1")
    WebElement filterResultTitle;
    // Danh sách sản phẩm
    @FindBy(xpath = "//*[@id=\"__layout\"]/div/header/div[1]/section/div/div/div/div[1]/span")
    WebElement productList;
    
    @FindBy(id = "england-1027") // ID cho bộ lọc xuất xứ
    WebElement originDropdown;
    
    @FindBy(id = "10-bo-1042") // ID cho bộ lọc số bộ
    WebElement bowlSizeDropdown;
    
    
    // Constructor
    public BepDienTu_FilterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    // Hành động click vào danh mục "Máy rửa chén bát"
    public void clickHoodCategory() {
        hoodCategoryLink.click();
    }
 // Hành động click vào danh mục "Bếp từ"
    public void clickHoodCategory1() {
        hoodCategoryLink1.click();
    }
    // Hành động click lọc theo thương hiệu
    public void clickfilterByBrand() {
        brandFilter.click();
    }
    // Hành động lọc theo giá
    public void filterByPrice() {
        priceFilter.click();
    }
    // Lấy tiêu đề của trang lọc
    public String getFilterResultTitle() {
        return filterResultTitle.getText();
    }
    // Kiểm tra xem danh sách sản phẩm có hiển thị không
    public boolean isProductListDisplayed() {
        return productList.isDisplayed();
    }
    public void selectBowlSize() {
        bowlSizeDropdown.click();
    }
    public void selectOrigin() {
        originDropdown.click();
    }

}
