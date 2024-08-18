package homepage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlmosaferClass {
	String WebSiteLink = "https://www.almosafer.com/en";
	WebDriver driver = new ChromeDriver();
	@BeforeTest
	public void mysetup() {
		driver.manage().window().maximize();
		driver.get(WebSiteLink);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test(priority = 1,enabled = true )
	public void DefaultLanguageTest() {}
	@Test(priority = 2,enabled = true )
	public void DefaultCurrencyTest() {}
	@Test(priority = 3,enabled = true )
	public void ContactInformationVerification() {}
	@Test(priority = 4,enabled = true )
	public void LogoVerification() {}
	@Test(priority = 5,enabled = true )
	public void HotelSearchTabDefaultState() {}
	@Test(priority = 6,enabled = true )
	public void FlightDepartureDate () {}
	@Test(priority = 6,enabled = true )
	public void FlightReturnDate    () {}
	@Test(priority = 7,enabled = true )
	public void InitialLoadTest() {}
	
	@Test(priority = 8,enabled = true)
	public void LanguageSwitchTest() {}
	
	@Test(priority = 9,enabled = true)
	public void HotelSearchTest() {}
	@Test(priority = 10,enabled = true)
	public void RoomSelectionTes() {}
	
	@Test(priority = 11,enabled = true)
	public void SearchButtonFunctionality() {}		
	@Test(priority = 12,enabled = true)
	public void SearchResultsPageLoad() {}
	@Test(priority = 13,enabled = true)
	public void PriceSortingTest() {}

}
