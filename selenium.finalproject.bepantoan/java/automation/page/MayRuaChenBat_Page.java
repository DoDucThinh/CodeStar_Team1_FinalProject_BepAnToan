package automation.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.common.CommonBase;

public class MayRuaChenBat_Page extends CommonBase{
	private WebDriver driver;
	
	@FindBy (xpath="(//a[@class='menu-link'])[3]") WebElement linkMayRuaChen;
	@FindBy (xpath = "//img[@src='https://static.bepantoan.vn/userfiles/images/logo bosch.jpg?w=100']") WebElement linkBOSCH;
	@FindBy (xpath="//span[@class='relative z-10']") WebElement linkPhantrang;
	@FindBy (xpath = "//span[text()='Germany']") WebElement textXuatSu;
	@FindBy(xpath = "(//span[@class='relative z-10 text'])[2]") WebElement textXemThem;
	@FindBy(id="10-bo-1042") WebElement textBo;
	@FindBy(xpath ="//span[text()='England']" ) WebElement textEngland;
	@FindBy(xpath = "(//span[@class='text-sm leading-3 px-3 py-1.5 rounded-full transition-all ease-in-out duration-200 cursor-pointer hover:text-white hover:bg-maroon-500 text-grey-800 bg-grey-100'])[3]") 
	WebElement textGia;
	
	public MayRuaChenBat_Page(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void mayRuaChenBat() {
		linkMayRuaChen.click();
	}
	public void sortHang() throws InterruptedException {
		Thread.sleep(5000);
		linkBOSCH.click();
		
	}
	public void sortGia() {
		textGia.click();
	}
	public void sortXuatSu() {
		textXemThem.click();
		textXuatSu.click();
	}
	public void sortSoBo() {
		textBo.click();
		
	}
	
	public void sortXuatSuFail() {
		textEngland.click();
	}
	
	public void clickXemThem() throws InterruptedException {
		linkPhantrang.click();
		
	}
	

}
