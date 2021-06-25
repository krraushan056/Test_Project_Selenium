package Cucumber.MakeMyTripFinal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Test11 {
	public static WebDriver driver;
	public static String trip="Round Trip";
	public static String Price_of_each_adult="0";
	public static String Price_of_each_Children="0";
	public static String Price_of_each_Infant="0";
	public static String from_city="Mumbai";
	public static String to_city="Bhubaneswar";
	public static String departureDate="24-08-2021";
	public static String departureDate1="24/08/2021";
	public static String noOfAdult="5";
	public static String Children="1";
	public static String infant="0";
	public static String Fee_Surcharges="0";
	public static String other_charge="0";
	public static String totalPrice="0";
	
	public static String exp_month="June";
	public static String exp_year="2021";
	public static String exp_date="12";
	public static String dep_month="July";
	public static String dep_year="2021";
	public static String dep_date="13";
	
	
	
	
	public static String trip_formatter(String trip1) {
		System.out.println("TRIP FROMATER CALLED");
		trip1=trip1.toLowerCase();
		trip1=trip1.replace(" ", "");
		trip1=trip1.replace("t","T");
		return trip1;
	}
	
	
	
	public static void validateCountPerson(String regex,String validate,String exact_data) {
		
		 Pattern P1= Pattern.compile(regex);
 	     Matcher m1 = P1.matcher(validate);
 	    if (m1.find()) {
 	    	String final_ans=(m1.group());
 	    	System.out.println(final_ans.substring(1));
 	    	Assert.assertEquals(exact_data,final_ans.substring(1) );
 	    } 
		
	}
	
	
	public static String price_indivisual(String regex_price,String priceDetail) {
		
		Pattern P1=Pattern.compile(regex_price);
		Matcher m1=P1.matcher(priceDetail);
		String Price_of_each=null;
		
 	   if (m1.find()) {
	    	String final_ans=(m1.group());
	    	Price_of_each=final_ans.substring(0, final_ans.length()-1);
	    	Price_of_each=Price_of_each.replace(",", "");
	    } 
 	   System.out.println(Price_of_each);
 	  return Price_of_each;
 	   
	}
	
	
	public static void validateAmount() {
		int amountPridicted=(Integer.parseInt(Price_of_each_adult))*(Integer.parseInt(noOfAdult))+(Integer.parseInt(Price_of_each_Children))*(Integer.parseInt(Children))+(Integer.parseInt(Price_of_each_Infant))*(Integer.parseInt(infant))+(Integer.parseInt(Fee_Surcharges))+(Integer.parseInt(other_charge));
		int intTotalPrice=Integer.parseInt(totalPrice);
		
		Assert.assertEquals(amountPridicted, intTotalPrice);
		System.out.println("TOTAL AMOUNT VALIDATED");
	
	}
	
	
	
	public static void selectDate(String month,String date ) {
		while(true) {
			String text_shown=driver.findElement(By.xpath("//div[@class='DayPicker-Month'][1]//div[@class='DayPicker-Caption']//div")).getText();
			System.out.println(text_shown);
			if(text_shown.equals(month)) {
				break;
			}else {
				driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			}
		}
		
		driver.findElement(By.xpath("//div[@class='DayPicker-Month'][1]//div[@class='dateInnerCell']//p[text()="+date+"]//ancestor::div[@class='DayPicker-Day']")).click();
		
	}
	
	public static void main(String args[]) {
		
		//*****************************FIRST*********************************************//
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\raushan.kum\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver=new ChromeDriver();
	Actions actions=new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	WebDriverWait wait=new WebDriverWait(driver,15);
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://www.makemytrip.com/");
	String parent=driver.getWindowHandle();
	WebDriverWait wait1=new WebDriverWait(driver,30);
	System.out.println(parent);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ' and text()='Search']")));
	
	System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXX1111111");
	
	
	WebDriverWait wait0=new WebDriverWait(driver,10);
	try {
	WebElement logFar=wait0.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='autopop__wrap makeFlex column defaultCursor']//p[@class='login__earn font18 latoBlack appendBottom20 defaultCursor']")));
	if(logFar.isEnabled()) {
		driver.findElement(By.xpath("//li[@data-cy='account']")).click();	
	}
	}catch(Exception e) {
		
		System.out.println("Proceed Ahead");
		
	}

	
	WebElement x=driver.findElement(By.xpath("//a[@class='active makeFlex hrtlCenter column']//span[@class='chNavIcon appendBottom2 chSprite chFlights active']"));
	actions.doubleClick(x);
	
	driver.findElement(By.xpath("//a[@class='active makeFlex hrtlCenter column']//span[@class='chNavIcon appendBottom2 chSprite chFlights active']")).click();
	System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXX22222222");
	
	String finaltrip=trip_formatter(trip);
	System.out.println(finaltrip);
	
	
	WebElement trip=driver.findElement(By.xpath("//li[@data-cy="+"'"+finaltrip+"'"+"]"));
	System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXX33333332");
	if(trip.isSelected()) {
		System.out.println("Already Selecetd44444444");
	}else {
		trip.click();
		System.out.println("Already Selecetd555555555");
	}
	
	
	//*****************************FIRST*********************************************//
	
	////VLAIDATE THE ROUND TRIP /////////////////////////////
	
	
	
	
	driver.findElement(By.xpath("//span[@class='returnCross landingSprite']")).click();	
	WebElement selectedTrip=driver.findElement(By.xpath("//li[@data-cy='oneWayTrip']"));
	Assert.assertEquals(selectedTrip.isEnabled(), true, "VERTFIED THE SELECTED TRIP IS OF ONE WAY ");
	System.out.println("VALIDATION OF ROUND TRIP COMPLETED");
	
////VLAIDATE THE ROUND TRIP /////////////////////////////
	
/*******************************************************************************************************/	
//	String x1=driver.getWindowHandle();
//	System.out.println(x1);
//	WebElement x1=driver.findElement(By.xpath("//div[@class='DayPicker-Months']//div[@role='grid'][2]//div[@class='DayPicker-Day']//div[@class='dateInnerCell']//p[text()='2']"));
//	js.executeScript("arguments[0].click();", x1);
//	wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='DayPicker-Months']")));
	
/*******************************************************************************************************/
	
//navigate back to round trip
	
	driver.findElement(By.xpath("//li[@data-cy="+"'"+finaltrip+"'"+"]")).click();
	System.out.println("###################");
//navigate back to round trip
	
	
	
	
	///////////////////////888888888888888888888888888888888////////////////////////////
	
//	if(Integer.parseInt(noOfAdult)<Integer.parseInt(infant)) {
//		Assert.fail();
//	}
//	
//	
//
	
	//COMMON FOR BOTH
	driver.findElement(By.xpath("//div[@class='fsw_inputBox searchCity inactiveWidget ']")).click();
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='hsw_autocomplePopup autoSuggestPlugin']")));
	driver.findElement(By.xpath("//div[@role='combobox']//input[@type='text'  and @placeholder='From']")).sendKeys(from_city);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='react-autosuggest__section-title']//p[contains(text(),'SUGGESTIONS')]")));
	System.out.println("12345678");
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0' and @data-section-index='0' ]//p[contains(text(),"+"'"+from_city+"'"+")]")));
	driver.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0' and @data-section-index='0' ]")).click();
	
	driver.findElement(By.xpath("//div[@role='combobox']//input[@type='text' and @placeholder='To']")).sendKeys(to_city);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='react-autosuggest__section-title']//p[contains(text(),'SUGGESTIONS')]")));
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0' and @data-section-index='0' ]//p[contains(text(),"+"'"+to_city+"'"+")]")));
	driver.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0' and @data-section-index='0' ]")).click();
	//COMMON FOR BOTH
	
	
	
	
	
	selectDate(exp_month+exp_year,exp_date);
	selectDate(dep_month+dep_year,dep_date);
	
	
	driver.findElement(By.xpath("//label[@for='travellers']//span[@class='lbl_input latoBold appendBottom10']")).click();
	
	
	String noOfAdult1="'"+"adults-"+noOfAdult+"'";
	if(noOfAdult.isEmpty()) {
		System.out.println("NO ADULT");
	}
	else if(Integer.parseInt(noOfAdult)>9) {
		driver.findElement(By.xpath("//ul[@class='guestCounter font12 darkText gbCounter']//li[@data-cy='adults-10']")).click();	
	}else {
		driver.findElement(By.xpath("//ul[@class='guestCounter font12 darkText gbCounter']//li[@data-cy="+noOfAdult1+"]")).click();
	}
	
	String noOfChildren="'"+"children-"+Children+"'";
	if(Children.isEmpty()) {
		System.out.println("NO Children");
	}
	else if(Integer.parseInt(noOfAdult)>6) {
		driver.findElement(By.xpath("//ul[@class='guestCounter font12 darkText gbCounter']//li[@data-cy='children-7']")).click();	
	}else {
		driver.findElement(By.xpath("//ul[@class='guestCounter font12 darkText gbCounter']//li[@data-cy="+noOfChildren+"]")).click();
	}
	
	
	
	String noOfinfants="'"+"infants-"+infant+"'";
	
	if(infant.isEmpty()) {
		System.out.println("NO infant");
	}
	else if(Integer.parseInt(noOfAdult)>6) {
		driver.findElement(By.xpath("//ul[@class='guestCounter font12 darkText gbCounter']//li[@data-cy='infants-7']")).click();	
	}else {
		driver.findElement(By.xpath("//ul[@class='guestCounter font12 darkText gbCounter']//li[@data-cy="+noOfinfants+"]")).click();
	}
	
	
	driver.findElement(By.xpath("//div[@class='right makeFlex hrtlCenter']//button[@data-cy='travellerApplyBtn']")).click();
	
	driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ' and text()='Search']")).click();
	WebDriverWait wait11=new WebDriverWait(driver,20);
	wait11.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@class='loadingIcon']")));
	wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='flightsContainer makeFlex spaceBetween']")));
	
	
	System.out.println("HELLO");
	
	
	WebElement AirlineFilter=driver.findElement(By.xpath("//p[@class='filtersHeading appendBottom15' and contains(text(),'Arrival at')]"));

	
	String  Airplane_="AirAsia"; 
	WebElement  xx1=driver.findElement(By.xpath("//span[@class='truncate' and contains(text(),"+"'"+Airplane_+"'"+")]//parent::span[contains(@title,"+"'"+Airplane_+"'"+")]//parent::span//parent::div"));
	js.executeScript("arguments[0].click()", xx1);
	

	String verify_Arirline=driver.findElement(By.xpath("//ul[@class='appliedFilter']//li")).getText();
	
	Assert.assertEquals( Airplane_.toUpperCase(),verify_Arirline,"NOT VERIFIED THE AIROPLANE");
	System.out.println("SucesFully VERIED NAME OF FLIGHT");
	
	
	
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='filtersHeading appendBottom15' and contains(text(),'Airline')]")));
	
	String page_source=driver.getPageSource();
	System.out.println(page_source);
	
	
	Pattern p= Pattern.compile("<span class=\"boldFont blackText airlineName\">[A-Za-z0-9\\s]+</span>");
    Matcher m = p.matcher(page_source);
   
    while (m.find()) {
    	String type_air=m.group();
    	  String regex = ">[A-Za-z0-9\\s]+<";
    	   Pattern P1= Pattern.compile(regex);
    	    Matcher m1 = P1.matcher(type_air);
    	    while (m1.find())
    	    {
    	       String check=m1.group();
    	       check=check.substring(1,check.length()-1);
    	       System.out.println(check);
    	       
    	       Assert.assertEquals(Airplane_.toUpperCase(),check.toUpperCase(),"NOT VERIFIED THE AIROPLANE");
    	       
    	    }
    	
    	
    }
    
    
    
    
   /*********************/ 
    p=Pattern.compile("<p class=\"darkText\">[A-Za-z0-9\\s]+</p>");
    m = p.matcher(page_source);
    int count=0;
    while (m.find()) {
    	String type_air=m.group();
    	String regex = ">[A-Za-z0-9\\s]+<";
    	   Pattern P1= Pattern.compile(regex);
    	    Matcher m1 = P1.matcher(type_air);
    	   if(m1.find())
    	    {  
    	    if(count%2==0) {
    	       String check1=m1.group();
    	       check1=check1.substring(1,check1.length()-1);
    	       System.out.println(check1);
    	       regex = "["+from_city+"]+";
    	       P1= Pattern.compile(regex);
    	       m1 = P1.matcher(check1);
    	       Assert.assertTrue(m1.find());
    	    }else {
    	       String check2=m1.group();
      	       check2=check2.substring(1,check2.length()-1);
      	       System.out.println(check2);
      	       regex="["+to_city+"]+";
      	     P1= Pattern.compile(regex);
      	     m1 = P1.matcher(check2); 
      	     Assert.assertTrue(m1.find()); 
    	    }
    	  
    	       
    	    }
    	   count++;
    	    
    	   
}
    
    System.out.println(count);
    
    
    
    
    /* VALIDATE THE DEPARTURE DATE*/
    String from=from_city+" ";
    js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
    String date_shown=driver.findElement(By.xpath("//div[@class='paneView']//b[contains(text(),"+"'"+from+"'"+")]//parent::p")).getText();
    System.out.println(date_shown);
//	//VERIFY DATE  Sat, Jun 12	       
	String verify=" "+exp_date+" "+exp_month.substring(0,3);
	String forVerify[]=date_shown.split(",");
	Assert.assertEquals(forVerify[1], verify,"VERIFIED DATE NOT DONE FOR DEPARTURE");
	
	/* VALIDATE THE DEPARTURE DATE*/

	
	
/*************	FOR COMING*****************/
	
	 	String to=to_city+" ";
	    js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	    String date_shown_come=driver.findElement(By.xpath("//div[@class='paneView']//b[contains(text(),"+"'"+to+"'"+")]//parent::p")).getText();
	    System.out.println(date_shown_come);
	    String verify1=" "+dep_date+" "+dep_month.substring(0,3);
		String forVerify1[]=date_shown_come.split(",");
		 System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&");
		    System.out.println(verify1);
		    System.out.println(forVerify1[1]);
		    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&");
		Assert.assertEquals(forVerify1[1], verify1,"VERIFIED DATE NOT DONE FOR COMING");
		
/*************	FOR COMING*****************/
		
		
		
		
	
	
	
	
	//select the type of sort
		
		////1st cart
	String type_sort="Duration";
	String sort="Accendings";
	if(sort=="Accending") {
		System.out.println("ENTERD");
	WebElement click1=driver.findElement(By.xpath("//div[@class='paneView'][1]//div[@id='sorting-togglers']//span[contains(text(),"+"'"+type_sort+"'"+")]//parent::span[@class='pointer']"));
	js.executeScript("arguments[0].click()",click1);
	}else {
		System.out.println("ENTERD11");
		WebElement click1=driver.findElement(By.xpath("//div[@class='paneView'][1]//div[@id='sorting-togglers']//span[contains(text(),"+"'"+type_sort+"'"+")]//parent::span[@class='pointer']"));
		js.executeScript("arguments[0].click()",click1);
		js.executeScript("arguments[0].click()",click1);	
	}
	
	
	
	//2nd cart
	 type_sort="Duration";
	 sort="Accendings";
	if(sort=="Accending") {
		System.out.println("ENTERD");
	WebElement click1=driver.findElement(By.xpath("//div[@class='paneView'][2]//div[@id='sorting-togglers']//span[contains(text(),"+"'"+type_sort+"'"+")]//parent::span[@class='pointer']"));
	js.executeScript("arguments[0].click()",click1);
	}else {
		System.out.println("ENTERD11");
		WebElement click1=driver.findElement(By.xpath("//div[@class='paneView'][2]//div[@id='sorting-togglers']//span[contains(text(),"+"'"+type_sort+"'"+")]//parent::span[@class='pointer']"));
		js.executeScript("arguments[0].click()",click1);
		js.executeScript("arguments[0].click()",click1);	
	}
	
	
	
	
	
	///one side ......
	
	String card_no="1";
	driver.findElement(By.xpath("//div[@class='paneView'][1]//label[@class='splitViewListing  ']["+card_no+"]")).click();
	
	///another side 
	
	driver.findElement(By.xpath("//div[@class='paneView'][2]//label[contains(@class,'splitViewListing')]["+card_no+"]")).click();
	
	
	driver.findElement(By.xpath("//button[text()='Book Now']")).click();
	
	
	
	
	
	
	/*******************TYPE OF TRIP************************/
	String fare_type="'"+"Premium Flex"+"'";
	driver.findElement(By.xpath("//div[@class='multifareContent appendBottom10'][1]//p[contains(text(),"+fare_type+")]//ancestor::div[@class='multifareSelection flexOne']")).click();
	WebElement dept_class=driver.findElement(By.xpath("//div[@class='multifareContent appendBottom10'][2]//p[contains(text(),"+fare_type+")]//ancestor::div[@class='multifareSelection flexOne']"));
	 js.executeScript("arguments[0].scrollIntoView(true);",dept_class );
	dept_class.click();
	
	
	driver.findElement(By.xpath("//button[text()='Continue']")).click();
	
	
	
	
	
	
	

	
	
//	////validate from,to,and airline from new page
//	
	ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(newTb.get(1));
// 
//  

///////////RETURN VALIDATION VVVVVVVI///////////////////////////////
	
	
	String pageSourceFinal=driver.getPageSource();
	//////FLIGHT NAME TYPE 
	System.out.println(pageSourceFinal);
	  p=Pattern.compile("<p class=\"append_bottom5 font14 LatoBold\" style=\"color: rgb\\(0, 0, 0\\);\">[A-Za-z0-9\\s]+</p>");
	    m = p.matcher(pageSourceFinal);
	    while (m.find()) {
	    	String type_air=m.group();
	    	System.out.println(type_air);
	    	  String regex = ">[A-Za-z0-9\\s]+<";
	    	   Pattern P1= Pattern.compile(regex);
	    	    Matcher m1 = P1.matcher(type_air);
	    	    while (m1.find())
	    	    {
	    	       String check=m1.group();
	    	       check=check.substring(1,check.length()-1);
	    	       System.out.println(check);
	    	       
	    	       Assert.assertEquals(Airplane_.toUpperCase(),check.toUpperCase(),"NOT VERIFIED THE AIROPLANE");
	    	       
	    	    }
	    	
	    	
	    }
	    
	//////FLIGHT NAME TYPE
	    
	    
	    /////DEPARTURE AND RETURN VERIFICATION......
	    
	   
	    String ids=driver.findElement(By.xpath("//p[text()='DEPART']//ancestor::div[@class='itnry-flt-header make_relative']//span[contains(text(),'-')]")).getText();
	    ids=ids.replace("-", "");
	    System.out.println(ids);
	    System.out.println("//div[contains(@id,"+ids+")]//p//span[@class='LatoBold']");
	    List<WebElement> elementName = driver.findElements(By.xpath("//div[contains(@id,"+"'"+ids+"'"+")]//p//span[@class='LatoBold']"));
	    ArrayList<String> placeList=new ArrayList<String>();
	    for(WebElement s:elementName) {
	    	
	    	placeList.add(s.getText());
	    	System.out.println("SEEE HERE ");
	    	System.out.println(s.getText());
	    	System.out.println("SEEE HERE ");
	    	
	    }
	    
	    if(placeList.size()==2) {
	    	
	    	Assert.assertTrue(placeList.get(0).contains(from_city));
	    	Assert.assertTrue(placeList.get(1).contains(to_city));
	    	
	    }else {
	    	
	    	Assert.assertTrue(placeList.get(0).contains(from_city));
	    	for(int i=1;i<placeList.size()-2;i=i+2) {
	    		System.out.println("------------------");
	    		System.out.println(placeList.get(i));
	    		Assert.assertEquals( placeList.get(i).toUpperCase(), placeList.get(i+1).toUpperCase());	
	    		System.out.println("------------------");
	    	}
	    	Assert.assertTrue(placeList.get(placeList.size()-1).contains(to_city));
	    	
	    }
	    
	    
	    System.out.println("*****************************");
	    
	    ////////RETURN LE LIYE BHAI BNAO AB
	    
	    
	    
	    ids=driver.findElement(By.xpath("//p[text()='RETURN']//ancestor::div[@class='itnry-flt-header make_relative']//span[contains(text(),'-')]")).getText();
	    ids=ids.replace("-", "");
	    System.out.println(ids);   
	    elementName = driver.findElements(By.xpath("//div[contains(@id,"+"'"+ids+"'"+")]//p//span[@class='LatoBold']"));
	    placeList=new ArrayList<String>();
	    for(WebElement s:elementName) {
	    	
	    	placeList.add(s.getText());
	    	System.out.println(s.getText());
	    	
	    }
	    
	    if(placeList.size()==2) {
	    	
	    	Assert.assertTrue(placeList.get(0).contains(to_city));
	    	Assert.assertTrue(placeList.get(1).contains(from_city));
	    	
	    }else {
	    	
	    	Assert.assertTrue(placeList.get(0).contains(to_city));
	    	for(int i=1;i<placeList.size()-2;i=i+2) {
	    		System.out.println(placeList.get(i));
	    		Assert.assertEquals( placeList.get(i).toUpperCase(), placeList.get(i+1).toUpperCase());	
	    	}
	    	Assert.assertTrue(placeList.get(placeList.size()-1).contains(from_city));
	    	
	    }
	    
	    
	    System.out.println("BHAI SHI JA RHE");
	    
	    
	  
	    
	
	
	

	
	
	
	
	
	    
     
     System.out.println("Hello Good");
     
  
 	
 	String Adult_detail;
 	String Infant_detail;
 	String Children_detail;
 	String regexNoOfindivisual="\\([0-9,]+";
	String indivisualPrice="[0-9,]+\\)";
	
	

 	if(Integer.parseInt(noOfAdult)>=1 &&Integer.parseInt(Children)>=1 && Integer.parseInt(infant)>=1) {
 		///ADULT///
 		Adult_detail=driver.findElement(By.xpath("//p[@class='fareSmry-row'][1]//span[contains(text(),'Adult')]")).getText();
 		validateCountPerson(regexNoOfindivisual,Adult_detail,noOfAdult); 
	    Price_of_each_adult=price_indivisual(indivisualPrice,Adult_detail); 
	    ///Children///
 	    
 		Children_detail=driver.findElement(By.xpath("//p[@class='fareSmry-row'][2]//span[contains(text(),'Children')]")).getText();
 		validateCountPerson(regexNoOfindivisual,Children_detail,Children); 
 	    Price_of_each_Children=price_indivisual(indivisualPrice,Children_detail); 
 	    
 		
 		//Infants////
 		Infant_detail=driver.findElement(By.xpath("//p[@class='fareSmry-row'][3]//span[contains(text(),'Infant')]")).getText();
 		validateCountPerson(regexNoOfindivisual,Infant_detail,infant); 
  	    Price_of_each_Infant=price_indivisual(indivisualPrice,Infant_detail); 
  	     
 		
 		
 		
 		
 	}else if(Integer.parseInt(noOfAdult)>=1 &&Integer.parseInt(Children)>=1) {
 		Adult_detail=driver.findElement(By.xpath("//p[@class='fareSmry-row'][1]//span[contains(text(),'Adult')]")).getText();
 		validateCountPerson(regexNoOfindivisual,Adult_detail,noOfAdult);
 		Price_of_each_adult=price_indivisual(indivisualPrice,Adult_detail); 
 	   
 		
 		Children_detail=driver.findElement(By.xpath("//p[@class='fareSmry-row'][2]//span[contains(text(),'Children')]")).getText();
 		validateCountPerson(regexNoOfindivisual,Children_detail,Children); 
 	    Price_of_each_Children=price_indivisual(indivisualPrice,Children_detail); 
 		
 	}else if(Integer.parseInt(noOfAdult)>=1 && Integer.parseInt(infant)>=1) {
 		Adult_detail=driver.findElement(By.xpath("//p[@class='fareSmry-row'][1]//span[contains(text(),'Adult')]")).getText();
 		validateCountPerson(regexNoOfindivisual,Adult_detail,noOfAdult);
 		Price_of_each_adult=price_indivisual(indivisualPrice,Adult_detail);  
 		Infant_detail=driver.findElement(By.xpath("//p[@class='fareSmry-row'][2]//span[contains(text(),'Infant')]")).getText();
 		validateCountPerson(regexNoOfindivisual,Infant_detail,infant); 
  	    Price_of_each_Infant=price_indivisual(indivisualPrice,Infant_detail); 
 		
 	}else {
 		Adult_detail=driver.findElement(By.xpath("//p[@class='fareSmry-row'][1]//span[contains(text(),'Adult')]")).getText();
 		validateCountPerson(regexNoOfindivisual,Adult_detail,noOfAdult);
 		Price_of_each_adult=price_indivisual(indivisualPrice,Adult_detail);  	
 	}
     
    
 	Fee_Surcharges=driver.findElement(By.xpath("//span[text()='Fee & Surcharges']//ancestor::div[@class='fareSmry-header LatoBold']//span[@class='font16']")).getText();
 	Fee_Surcharges=Fee_Surcharges.replace("₹", "");
 	Fee_Surcharges=Fee_Surcharges.replace(",", "");
 	Fee_Surcharges=Fee_Surcharges.replace(" ", "");
 	
 	other_charge=driver.findElement(By.xpath("//span[text()='Other Services']//ancestor::div[@class='fareSmry-header LatoBold']//span[@class='font16']")).getText();
 	other_charge=other_charge.replace("₹", "");
 	other_charge=other_charge.replace(" ", "");
 	
 	
 	totalPrice=driver.findElement(By.xpath("//span[text()='Total Amount:']//ancestor::div[@class='fareSmry-sctn reqPad-fareSmry-sctn']//span[@class='font20']//span//span")).getText();
 	totalPrice=totalPrice.replace("₹", "");
 	totalPrice=totalPrice.replace(",", "");
 	totalPrice=totalPrice.replace(" ", "");
 	
 	
 	validateAmount();
 	
 	driver.findElement(By.xpath("//span[text()='Other Services']//parent::p//span[@class='fareSmry-expand-icon cursor_pointer marR15 ']")).click();
 	
 	try {
 	   driver.findElement(By.xpath("//span[text()='Charity']"));
 	   WebElement charity=driver.findElement(By.xpath("//span[contains(text(),'Thank You for Donating ')]"));
 	  js.executeScript("arguments[0].scrollIntoView(true);",charity );
 	  charity.click();
 	 other_charge="0";
 	   
 	   
 	} catch (Exception e) {
 		
 		System.out.println("NO CHARITY OPTION IS AVAILABLE");
 	  
 	}
 	
 	js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
 	
 	try {
 		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Other Services']//ancestor::div[@class='fareSmry-header LatoBold']//span[@class='font16']")));
 		Assert.fail();
  	   }catch(Exception e) {
  		 other_charge="0";
  		 System.out.println("OTHER NOT FOUND");
  	   }
  	   
 	
 	
 	try {
 	WebElement insurance=driver.findElement(By.xpath("//p[text()='Add-ons']"));
 	 js.executeScript("arguments[0].scrollIntoView(true);",insurance );
 	driver.findElement(By.xpath("//div[@class='labeltext block paddL30']")).click();
 	
 	js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
 	
 	driver.findElement(By.xpath("//span[text()='Other Services']//parent::p//span[@class='fareSmry-expand-icon cursor_pointer marR15 ']")).click();
 	other_charge=driver.findElement(By.xpath("//span[text()='Other Services']//ancestor::div[@class='fareSmry-header LatoBold']//following-sibling::div[@class='fareSmry-wrap']//span[@class='font16 LatoBold text-right']//span")).getText();
 	other_charge=other_charge.replace("₹", "");
 	other_charge=other_charge.replace(" ", "");
 	System.out.println(other_charge);
 	}catch(Exception e) {
 		
 		System.out.println("Insurance Not Found");
 	}
 	totalPrice=driver.findElement(By.xpath("//span[text()='Total Amount:']//ancestor::div[@class='fareSmry-sctn reqPad-fareSmry-sctn']//span[@class='font20']//span//span")).getText();
 	totalPrice=totalPrice.replace("₹", "");
 	totalPrice=totalPrice.replace(",", "");
 	totalPrice=totalPrice.replace(" ", "");
 	
 	String s1=driver.getWindowHandle();
 	validateAmount();
 	driver.switchTo().window(s1);
 	driver.navigate().back();
 	
 	driver.close();
 	driver.quit();
 	
 	
}
}
