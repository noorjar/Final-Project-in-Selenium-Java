package homepage;

import java.time.Duration;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parameters {
	String WebSiteLink = "https://www.almosafer.com/en";
	WebDriver driver = new ChromeDriver();
	Date TodayDate =  new Date();
	Random rand = new Random();
	
	String ExpectedLanguage = "en";
	String ExpectedCurrency = "SAR";
	String ExpectedContactInformation = "+966554400000";
	String ExpectedLogo = "Footer__QitafLogo";
	String ExpectedHotelTabState = "false";
	int ExpectedDepartureDate = TodayDate.getDate()+1;     
    String StringExpectedDepartureDate = String.valueOf(ExpectedDepartureDate);
    int ExpectedReturnDate = TodayDate.getDate()+2;     
    String StringExpectedReturnDate = String.valueOf(ExpectedReturnDate);
    String [] AreasForEnglish = {"Dubai","Jeddah","Riyadh"};
	String [] AreasForArabic = {"دبي","جده"};
	int RandomEngArea = rand.nextInt(AreasForEnglish.length);
	int RandomArabArea = rand.nextInt(AreasForArabic.length);
	String arrayRooms [] = {"option[value='A']","option[value='B']"};
	int RandomRoomNumber  = rand.nextInt(arrayRooms.length);
	String TexstsinResultPage [] = {"properties found in","عقار وجدنا في"};
	String Text;		
	
	
    
    
   public void RandomLangaugeFun() {
	   String LanguagesURLs []= {"https://www.almosafer.com/en?ncr=1","https://www.almosafer.com/ar?ncr=1"};
		int RandomURL = rand.nextInt(LanguagesURLs.length);
		driver.get(LanguagesURLs[RandomURL]);
}
    
    
	public void GeneralSetUp() {
		driver.manage().window().maximize();
		driver.get(WebSiteLink);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	

}
