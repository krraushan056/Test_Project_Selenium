package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonBaseClass {
	
	WebDriver driver;
	public static String trip;
	public static String airCompany;
	public static String Price_of_each_adult="0";
	public static String Price_of_each_Children="0";
	public static String Price_of_each_Infant="0";
	public static String fromCity;
	public static String toCity;
	public static String departureDate;
	public static String returnDate;
	public static String noOfAdult="0";
	public static String Children="0";
	public static String infant="0";
	public static String Fee_Surcharges="0";
	public static String other_charge="0";
	public static String totalPrice="0";
	public static String retMonth;
	public static String retYear;
	public static String retDate;
	public static String depMonth;
	public static String depYear;
	public static String depDate;
	public static String basisOfSort1;
	public static String typeOfSort1;
	public static String basisOfSort2;
	public static String typeOfSort2;
	public static String card1;
	public static String plan;
	
	
	
	public void setUpTheDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\raushan.kum\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	public static   String trip_formatter(String trip1) {
		System.out.println("TRIP FROMATER CALLED");
		trip1=trip1.toLowerCase();
		if(trip1.contains(" "))
		trip1=trip1.replace(" ", "");
		if(trip1.contains("t"))
		trip1=trip1.replace("t","T");
		if(trip1.contains("w"))
			trip1=trip1.replace("w","W");
		return trip1;
	}
	
	
	public  void handleLoginPopUp() {
		WebDriverWait wait0=new WebDriverWait(driver,5);
		try {
		WebElement logFar=wait0.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='autopop__wrap makeFlex column defaultCursor']//p[@class='login__earn font18 latoBlack appendBottom20 defaultCursor']")));
		if(logFar.isEnabled()) {
			driver.findElement(By.xpath("//li[@data-cy='account']")).click();	
		}
		}catch(Exception e) {
			
			System.out.println("Proceed Ahead NO POPUP SHOWN FOR LOGIN");
			
		}
	}
	
	
	public  void chooseTripType() {
		try {
		Actions actions=new Actions(driver);
		WebElement x=driver.findElement(By.xpath("//a[@class='active makeFlex hrtlCenter column']//span[@class='chNavIcon appendBottom2 chSprite chFlights active']"));
		actions.doubleClick(x);
		System.out.println(trip);
		driver.findElement(By.xpath("//a[@class='active makeFlex hrtlCenter column']//span[@class='chNavIcon appendBottom2 chSprite chFlights active']")).click();
		String finalTripType=trip_formatter(trip);
		System.out.println(trip);
		System.out.println(finalTripType);
		WebElement trip1=driver.findElement(By.xpath("//li[@data-cy="+"'"+finalTripType+"'"+"]"));
		if(trip1.isSelected()) {
			System.out.println("Trip Selected type--->"+finalTripType);
		}else {
			trip1.click();
			System.out.println("Trip Selected type--->"+finalTripType);
		}
		}catch(Exception e) {
			
		}
		
		
		
	}
	
	
	
	

}
