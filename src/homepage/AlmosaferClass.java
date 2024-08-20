package homepage;

import java.time.Duration;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlmosaferClass {
	String WebSiteLink = "https://www.almosafer.com/en";
	WebDriver driver = new ChromeDriver();
	Date TodayDate =  new Date();
	Random rand = new Random();
	//_______________________________________________________________________________________________________________________
	@BeforeTest
	public void mysetup() {
		driver.manage().window().maximize();
		driver.get(WebSiteLink);
		driver.findElement(By.className("cta__saudi")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	//_______________________________________________________________________________________________________________________
	@Test(priority = 1,enabled = true )
	public void DefaultLanguageTest() {
		/*
		WebElement Language =  driver.findElement(By.cssSelector(".sc-gkFcWv.jJNggu"));
		String Actual= Language.getText();
		String Expected = "العربية";
		Assert.assertEquals(Actual, Expected);
		*/
		WebElement Language =  driver.findElement(By.tagName("html"));
		String Actual= Language.getAttribute("lang");
		String Expected = "en";
		Assert.assertEquals(Actual, Expected);
	}
	//_______________________________________________________________________________________________________________________
	@Test(priority = 2,enabled = true )
	public void DefaultCurrencyTest() {
		WebElement Currency = driver.findElement(By.cssSelector(".sc-dRFtgE.fPnvOO"));
		String Actual= Currency.getText();
		String Expected = "SAR";
		Assert.assertEquals(Actual, Expected);
	}
	//_______________________________________________________________________________________________________________________
	@Test(priority = 3,enabled = true )
	public void ContactInformationVerification() {
		WebElement ContactInformation = driver.findElement(By.cssSelector("a[class='sc-hUfwpO bWcsTG'] strong"));
		String Actual= ContactInformation.getText();
		String Expected = "+966554400000";
		Assert.assertEquals(Actual, Expected);
	}
	//_______________________________________________________________________________________________________________________
	@Test(priority = 4,enabled = true )
	public void LogoVerification() {
		//JavascriptExecutor JS = (JavascriptExecutor) driver;
		//JS.executeScript("scrollTo(0,10000)");
		WebElement FooterContainer = driver.findElement(By.cssSelector("body > div:nth-child(1) > footer:nth-child(16) > div:nth-child(3) > div:nth-child(3)"));
		WebElement QitafLogo =  FooterContainer.findElement(By.className("eYboXF"));
		String Actual= QitafLogo.getAttribute("data-testid");
		String Expected = "Footer__QitafLogo";
		Assert.assertEquals(Actual, Expected);
	}
	//_______________________________________________________________________________________________________________________
	@Test(priority = 5,enabled = true )
	public void HotelSearchTabDefaultState() {
		WebElement HotelsTab= driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		String Actual=  HotelsTab.getAttribute("aria-selected");
		String Expected = "false";
		Assert.assertEquals(Actual, Expected);
		}
	//_______________________________________________________________________________________________________________________
	@Test(priority = 6,enabled = true )
	public void FlightDepartureDate() {
		  WebElement DepartureDate =driver.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-kqlzXE blwiEW'] span[class='sc-cPuPxo LiroG']"));
		  String Actual=DepartureDate.getText().trim();
		  int Expected = TodayDate.getDate()+1;     
	      String ExpectedString = String.valueOf(Expected);
		  Assert.assertEquals(Actual,ExpectedString);
	}
	//_______________________________________________________________________________________________________________________
	@Test(priority = 6,enabled = true )
	public void FlightReturnDate() {
		 WebElement ReturnDate =driver.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-OxbzP edzUwL'] span[class='sc-cPuPxo LiroG']"));
		 String Actual=ReturnDate.getText().trim();
		 int Expected = TodayDate.getDate()+2;     
	     String ExpectedString = String.valueOf(Expected);
		 Assert.assertEquals(Actual,ExpectedString);
	}
	//_______________________________________________________________________________________________________________________
	@Test(priority = 7,enabled = true)
	public void LanguageSwitchTest(){
		String LanguagesURLs []= {"https://www.almosafer.com/en?ncr=1","https://www.almosafer.com/ar?ncr=1"};
		int RandomURL = rand.nextInt(LanguagesURLs.length);
		driver.get(LanguagesURLs[RandomURL]);
	}
	//_______________________________________________________________________________________________________________________
	@Test(priority = 9,enabled = true)
	public void HotelSearchTest() throws InterruptedException {
		WebElement HotelsTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		HotelsTab.click();
		WebElement HotelSearchTab = driver.findElement(By.xpath("//input[@data-testid='AutoCompleteInput']"));
		HotelSearchTab.click();
		WebElement SearchButton = driver.findElement(By.xpath("//button[@data-testid='HotelSearchBox__SearchButton']"));
		///////////////////////////////////////////////////////////////////////////////////////////////////////
		String Language =  driver.findElement(By.xpath("//a[@data-testid='Header__LanguageSwitch']")).getText();
		String [] AreasForEnglish = {"Dubai","Jeddah","Riyadh"};
		String [] AreasForArabic = {"دبي","جده"};
		int RandomEngArea = rand.nextInt(AreasForEnglish.length);
		int RandomArabArea = rand.nextInt(AreasForArabic.length);
	
		
		if(Language.equals("العربية")) {
			HotelSearchTab.sendKeys(AreasForEnglish[RandomEngArea]);
			SearchButton.click();
			Thread.sleep(5000);
			WebElement FirstHotel = driver.findElement(By.xpath("//img[@alt='Image']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", FirstHotel);

		}
		else
			if (Language.equals("English")){
			HotelSearchTab.sendKeys(AreasForArabic[RandomArabArea]);
			SearchButton.click();
			Thread.sleep(5000);
			WebElement FirstHotel = driver.findElement(By.xpath("//img[@alt='Image']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", FirstHotel);
			//to get Language we can use driver.getCurrentUrl().contains();
		}	
	}
	
	
	
	
	
	
	
	
	
	
	
	@Test(priority = 10,enabled = false)
	public void RoomSelectionTes() {}
	
	@Test(priority = 11,enabled = false)
	public void SearchButtonFunctionality() {}		
	@Test(priority = 12,enabled = false)
	public void SearchResultsPageLoad() {}
	@Test(priority = 13,enabled = false)
	public void PriceSortingTest() {}

}
