package homepage;

import java.nio.file.WatchEvent;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	public void HotelSearchTest()  {
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
		
		System.out.println(Language+"******");
		
		
		if(Language.equals("العربية")) {
			HotelSearchTab.sendKeys(AreasForEnglish[RandomEngArea]);
			//SearchButton.click();

		}
		else
			if (Language.equals("English")){
			HotelSearchTab.sendKeys(AreasForArabic[RandomArabArea]);
			//SearchButton.click();
			//to get Language we can use driver.getCurrentUrl().contains();
			
		}	
		WebElement SearchContainer =driver.findElement(By.cssSelector(".sc-phbroq-4.gGwzVo.AutoComplete__List"));
		List<WebElement> SearchLista =SearchContainer.findElements(By.tagName("li"));
		WebElement FirstResult = SearchLista.get(1) ;
		FirstResult.click();
		SearchButton.click();
	}
	//_______________________________________________________________________________________________________________________
	@Test(priority = 10,enabled = true)
	public void RoomSelectionTest() {
		//11111111111111111111 
		String array [] = {"option[value='A']","option[value='B']"};
		int RandomRoomNumber  = rand.nextInt(array.length);
		System.out.println(array[RandomRoomNumber]+"*****");
		WebElement Rooms = driver.findElement(By.cssSelector(array[RandomRoomNumber]));
		Rooms.click();
		/*22222222222222222222
		WebElement SelectTag = driver.findElement(By.xpath("//select[@data-testid='HotelSearchBox__ReservationSelect_Select']"));
		Select select = new Select(SelectTag);
		List<WebElement>AllOptions =  select.getOptions();
		List<WebElement> FirstTwoOptions = AllOptions.subList(0,2);
		int RandomNumber =rand.nextInt(FirstTwoOptions.size());
		FirstTwoOptions.get(RandomNumber).click();
		*/
		/*33333333333333333333
		WebElement SelectTag = driver.findElement(By.xpath("//select[@data-testid='HotelSearchBox__ReservationSelect_Select']"));
		Select select = new Select(SelectTag);
		int RandomNumber = rand.nextInt(2);
		select.selectByIndex(RandomNumber);
	*/
	}
	//_______________________________________________________________________________________________________________________
	@Test(priority = 11,enabled = true)
	public void SearchButtonFunctionality() {
		WebElement SearchButton = driver.findElement(By.xpath("//button[@data-testid='HotelSearchBox__SearchButton']"));
		SearchButton.click();
	}		
	//_______________________________________________________________________________________________________________________
	@Test(priority = 12,enabled = true)
	public void SearchResultsPageLoad() throws InterruptedException {
		 Thread.sleep(10000);//in this case we can use Thread.sleep
		String Language =  driver.findElement(By.xpath("//a[@data-testid='Header__LanguageSwitch']")).getText();
		WebElement SearchResult = driver.findElement(By.xpath("//span[@data-testid='HotelSearchResult__resultsFoundCount']"));
		String Actual = SearchResult.getText();
		String Texsts [] = {"properties found in","عقار وجدنا في"};
		String Text;
		
	    if (Language.equals("العربية")) {
	    	Text = Texsts[0]; 
		        
	    } 
	    else {
		    	Text = Texsts[1]; 
		    }
	   
		Assert.assertEquals(Actual.contains(Text), true);
	}
	//_______________________________________________________________________________________________________________________
	@Test(priority = 13,enabled = true)
	  // Note: Both old and new price elements share the same class ("Price__Value").
    // This presents a challenge for distinguishing between the old and new prices as they cannot be differentiated by class alone.
	public void PriceSortingTest() {
		WebElement LowestToHighst =driver.findElement(By.xpath("//button[@data-testid='HotelSearchResult__sort__LOWEST_PRICE']"));
		LowestToHighst.click();
		WebElement container =  driver.findElement(By.cssSelector(".sc-htpNat.KtFsv.col-9"));
		List<WebElement> Prices= container.findElements(By.className("Price__Value"));
		System.out.println(Prices.size());
		
		String LowestPrice =Prices.get(0).getText();
		String HighstPrice =Prices.get(Prices.size()-1).getText();
		
		int intLowestPrice = Integer.parseInt(LowestPrice);
		int intHighstPrice = Integer.parseInt(HighstPrice);
		
		boolean isSorted = intHighstPrice > intLowestPrice;
		Assert.assertEquals(isSorted, true);
		
	}

}
