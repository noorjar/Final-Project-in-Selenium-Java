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

public class AlmosaferClass extends Parameters {
	
	@BeforeTest
	public void mysetup() {
		GeneralSetUp();
		driver.findElement(By.className("cta__saudi")).click();
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
		String ActualLanguage =  driver.findElement(By.tagName("html")).getAttribute("lang");
		Assert.assertEquals(ActualLanguage, ExpectedLanguage);
	}
	//_______________________________________________________________________________________________________________________
	@Test(priority = 2,enabled = true )
	public void DefaultCurrencyTest() {
		String ActualCurrency = driver.findElement(By.cssSelector(".sc-dRFtgE.fPnvOO")).getText();
		Assert.assertEquals(ActualCurrency, ExpectedCurrency);
	}
	//_______________________________________________________________________________________________________________________
	@Test(priority = 3,enabled = true )
	public void ContactInformationVerification() {
		String ActualContactInformation = driver.findElement(By.cssSelector("a[class='sc-hUfwpO bWcsTG'] strong")).getText();
		Assert.assertEquals(ActualContactInformation, ExpectedContactInformation);
	}
	//_______________________________________________________________________________________________________________________
	@Test(priority = 4,enabled = true )
	public void LogoVerification() {
		//JavascriptExecutor JS = (JavascriptExecutor) driver;
		//JS.executeScript("scrollTo(0,10000)");
		WebElement FooterContainer = driver.findElement(By.cssSelector("body > div:nth-child(1) > footer:nth-child(16) > div:nth-child(3) > div:nth-child(3)"));
		String ActualQitafLogo =  FooterContainer.findElement(By.className("eYboXF")).getAttribute("data-testid");
		
		Assert.assertEquals(ActualQitafLogo, ExpectedLogo);
	}
	//_______________________________________________________________________________________________________________________
	@Test(priority = 5,enabled = true )
	public void HotelSearchTabDefaultState() {
		WebElement HotelsTab= driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		String ActualHotelTabState=  HotelsTab.getAttribute("aria-selected");
		Assert.assertEquals(ActualHotelTabState, ExpectedHotelTabState);
		}
	//_______________________________________________________________________________________________________________________
	@Test(priority = 6,enabled = true )
	public void FlightDepartureDate() {
		  WebElement DepartureDate =driver.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-kqlzXE blwiEW'] span[class='sc-cPuPxo LiroG']"));
		  String ActualDepartureDate=DepartureDate.getText().trim();
		  Assert.assertEquals(ActualDepartureDate,StringExpectedDepartureDate);
	}
	//_______________________________________________________________________________________________________________________
	@Test(priority = 6,enabled = true )
	public void FlightReturnDate() {
		 WebElement ReturnDate =driver.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-OxbzP edzUwL'] span[class='sc-cPuPxo LiroG']"));
		 String ActualReturnDate=ReturnDate.getText().trim();
		 Assert.assertEquals(ActualReturnDate,StringExpectedReturnDate);
	}
	//_______________________________________________________________________________________________________________________
	@Test(priority = 7,enabled = true)
	public void LanguageSwitchTest(){
		RandomLangaugeFun();
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
		
		System.out.println(Language+"******");
		
		
		if(Language.equals("العربية")) {
			HotelSearchTab.sendKeys(AreasForEnglish[RandomEngArea]);
		}
		else
			if (Language.equals("English")){
			HotelSearchTab.sendKeys(AreasForArabic[RandomArabArea]);
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
		//1111111111111111111
		WebElement Rooms = driver.findElement(By.cssSelector(arrayRooms[RandomRoomNumber]));
		Rooms.click();
		System.out.println(arrayRooms[RandomRoomNumber]+"*****");
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
		String ActualSearchResult = driver.findElement(By.xpath("//span[@data-testid='HotelSearchResult__resultsFoundCount']")).getText();
		
	    if (Language.equals("العربية")) {
	    	Text = TexstsinResultPage[0];       
	    } 
	    else {
		    	Text = TexstsinResultPage[1]; 
		    }
	   
		Assert.assertEquals(ActualSearchResult.contains(Text), true);
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
