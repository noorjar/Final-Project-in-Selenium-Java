package homepage;

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
		
	}
	
	@Test(priority = 1,enabled = true )
	public void InitialLoadTest() { 
		
	}
	
	@Test(priority = 2,enabled = true)
	public void LanguageSwitchTest() { 
		
	}
	
	@Test(priority = 3,enabled = true)
	public void HotelSearchTest() { 
		
	}
	@Test(priority = 4,enabled = true)
	public void RoomSelectionTes() { 
		
	}
	
	@Test(priority = 5,enabled = true)
	public void SearchButtonFunctionality() { 
		
	}		
	@Test(priority = 6,enabled = true)
	public void SearchResultsPageLoad() { 
		
	}
	@Test(priority = 7,enabled = true)
	public void PriceSortingTest() { 
		
	}

}
