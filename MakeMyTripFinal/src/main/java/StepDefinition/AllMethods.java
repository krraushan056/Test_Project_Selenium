package StepDefinition;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AllMethods extends CommonBaseClass {
	
public void validateTrip() {
	try {
		WebDriverWait wait1=new WebDriverWait(driver,15);
		trip=trip_formatter(trip);
		if(trip.equals("roundTrip")) {
			driver.findElement(By.xpath("//span[@class='returnCross landingSprite']")).click();	
			WebElement selectedTrip=driver.findElement(By.xpath("//li[@data-cy='oneWayTrip']"));
			Assert.assertEquals(selectedTrip.isEnabled(), true, "VERIFICATION FAILED FOR ONE WAY ");
			System.out.println("VALIDATION OF ROUND TRIP COMPLETED");
		}else {
			driver.findElement(By.xpath("//span[@class='lbl_input latoBold appendBottom10' and text()='RETURN']")).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='DayPicker-Months']")));
			WebElement selectedTrip=driver.findElement(By.xpath("//li[@data-cy='roundTrip']"));
			Assert.assertEquals(selectedTrip.isEnabled(), true, "VERIFICATION FAILED FOR ROUND TRIP ");
			System.out.println("VALIDATION OF ONEWAY COMPLETED");
			
		}
	}catch(Exception e) {
		System.out.println("ERROR IN VALIDATE TRIP");
		System.out.println(e);
		Assert.fail();
		
	}
}
		
public static void dateModify(String dep_date,String return_date){
		LocalDate currentDate= LocalDate.parse(dep_date);
	    depDate = Integer.toString(currentDate.getDayOfMonth());
		Month month = currentDate.getMonth();
		depMonth=month.toString();
		depMonth=depMonth.toLowerCase();
		depMonth=depMonth.substring(0, 1).toUpperCase() + depMonth.substring(1);
		depYear = Integer.toString(currentDate.getYear());

		if(!return_date.isEmpty()) {
		    currentDate= LocalDate.parse(return_date);
			retDate = Integer.toString(currentDate.getDayOfMonth());
			month = currentDate.getMonth();
			retMonth=month.toString();
			retMonth=retMonth.toLowerCase();
			retMonth=retMonth.substring(0, 1).toUpperCase() + retMonth.substring(1);
			retYear = Integer.toString(currentDate.getYear());	 
		         }
		 
 }
		 
public void setCity(String from_city,String to_city) {
	try {
			 WebDriverWait wait1=new WebDriverWait(driver,15);
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
	}catch(Exception e) {
		System.out.println("ERROR IN SET CITY");
		System.out.println(e);
		Assert.fail();
		
	}
}
		 
		 
public  void selectDate(String month,String date ) {
	
	try {
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
				
			}catch(Exception e) {
				System.out.println("ERROR IN SELECTING DATE");
				System.out.println(e);
				Assert.fail();
			}
}
		 
		 
public void  setDetailOfTraverlers(String noOfAdult,String Children,String infant) {
	try {
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
		 }catch(Exception e) {
			 System.out.println("ERROR IN setDetailOfTraverlers");
				System.out.println(e);
				Assert.fail();
			 
		 }
}
		 
 public void  selectAndVerifyAirline(String Airplane_) {
	 try {
	 			WebDriverWait wait11=new WebDriverWait(driver,15);
			 	WebElement AirlineFilter=driver.findElement(By.xpath("//p[@class='filtersHeading appendBottom15' and contains(text(),'Arrival at')]"));
				WebElement  checkAir=driver.findElement(By.xpath("//span[@class='truncate' and contains(text(),"+"'"+Airplane_+"'"+")]//parent::span[contains(@title,"+"'"+Airplane_+"'"+")]//parent::span//parent::div"));
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click()", checkAir);
				String verify_Arirline=driver.findElement(By.xpath("//ul[@class='appliedFilter']//li")).getText();
				Assert.assertEquals( Airplane_.toUpperCase(),verify_Arirline,"NOT VERIFIED THE AIROPLANE");
				System.out.println("SUCESSFully VERIED NAME OF FLIGHT");
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='filtersHeading appendBottom15' and contains(text(),'Airline')]")));
				
				
		 }catch(Exception e) {
			 System.out.println("ERROR IN selectAndVerifyAirline");
				System.out.println(e);
				Assert.fail();
		 }
 }
		 
		 
		 
public void verifyEachCardDetailsTrip(String to_city,String from_city,String Airplane_ ) {
	try {
			 
			 String page_source=driver.getPageSource();
			//System.out.println(page_source);
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
			    
			   //To city from city // 
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
		 }catch(Exception e) {
			 System.out.println("ERROR IN verifyEachCardDetailsTrip");
			 System.out.println(e);
			 Assert.fail();
		 }
}
	
		 
		
		 
public void validateTheDatesBothSide(String city,String month,String date) {
	try {
			 /* VALIDATE THE DEPARTURE DATE*/
			    String city_=city+" ";
			    JavascriptExecutor js = (JavascriptExecutor)driver;
			    js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
			    String date_shown=driver.findElement(By.xpath("//div[@class='paneView']//b[contains(text(),"+"'"+city_+"'"+")]//parent::p")).getText();
			    System.out.println(date_shown);
				//VERIFY DATE  Sat, Jun 12	       
				String verify=" "+date+" "+month.substring(0,3);
				String forVerify[]=date_shown.split(",");
				Assert.assertEquals(forVerify[1], verify,"VERIFIED DATE NOT DONE FOR DEPARTURE AND RETURN ");
				

		 }catch(Exception e) {
			 System.out.println("ERROR IN validateTheDatesBothSide");
			 System.out.println(e);
			 Assert.fail();
			 
		 }
}
		 
		 
public void validateTheDatesOneSide(String month,String date) {
	try {
			 	JavascriptExecutor js = (JavascriptExecutor)driver;
			 	js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
			    String date_shown=driver.findElement(By.xpath("//div[@class='weeklyFareItems active']//p[@class='blackFont fontSize12 appendBottom3']")).getText();
				String verify=" "+month.substring(0,3)+" "+date;
				String forVerify[]=date_shown.split(",");
				Assert.assertEquals(forVerify[1], verify,"VERIFIED DATE NOT DONE");
				
		  }catch(Exception e) {
			 System.out.println("ERROR IN validateTheDatesOneSide");
			 System.out.println(e);
			 Assert.fail();
			 
		 }
}
		 
		
		 
public void  sortDeptTrip(String type_sort,String sort) {
	try {
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			if(sort=="Accending") {
				System.out.println("ENTERED");
			WebElement click1=driver.findElement(By.xpath("//div[@class='paneView'][1]//div[@id='sorting-togglers']//span[contains(text(),"+"'"+type_sort+"'"+")]//parent::span[@class='pointer']"));
			js.executeScript("arguments[0].click()",click1);
			}else {
				System.out.println("ENTERED");
				WebElement click1=driver.findElement(By.xpath("//div[@class='paneView'][1]//div[@id='sorting-togglers']//span[contains(text(),"+"'"+type_sort+"'"+")]//parent::span[@class='pointer']"));
				js.executeScript("arguments[0].click()",click1);
				js.executeScript("arguments[0].click()",click1);	
			}
	}catch(Exception e) {
		 System.out.println("ERROR IN sortDeptTrip");
		 System.out.println(e);
		 Assert.fail();
	}
			
}
		
public void sortRetTrip(String type_sort,String sort) {
	
	try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
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
			
		}catch(Exception e) {
			 System.out.println("ERROR IN sortRetTrip");
			 System.out.println(e);
			 Assert.fail();
		}
}
		
		
public void sortTrip(String type_sort,String sort) {
	try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			if(sort=="Accending") {
				System.out.println("ENTERD");
			WebElement click1=driver.findElement(By.xpath("//div[@id='sorting-togglers']//span[contains(text(),"+"'"+type_sort+"'"+")]//parent::span[@class='pointer']"));
			js.executeScript("arguments[0].click()",click1);
			}else {
				System.out.println("ENTERD11");
				WebElement click1=driver.findElement(By.xpath("//div[@id='sorting-togglers']//span[contains(text(),"+"'"+type_sort+"'"+")]//parent::span[@class='pointer']"));
				js.executeScript("arguments[0].click()",click1);
				js.executeScript("arguments[0].click()",click1);	
			}
		}catch(Exception e) {
			 System.out.println("ERROR IN sortTrip");
			 System.out.println(e);
			 Assert.fail();
		}
}
		
		
public void selectPlanRound( String fare_type) {
	try {
			    JavascriptExecutor js = (JavascriptExecutor)driver;
				fare_type="'"+fare_type+"'";
				driver.findElement(By.xpath("//div[@class='multifareContent appendBottom10'][1]//p[contains(text(),"+fare_type+")]//ancestor::div[@class='multifareSelection flexOne']")).click();
				WebElement dept_class=driver.findElement(By.xpath("//div[@class='multifareContent appendBottom10'][2]//p[contains(text(),"+fare_type+")]//ancestor::div[@class='multifareSelection flexOne']"));
				js.executeScript("arguments[0].scrollIntoView(true);",dept_class );
				dept_class.click();
				driver.findElement(By.xpath("//button[text()='Continue']")).click();
			
		}catch(Exception e) {
			 System.out.println("ERROR IN selectPlanRound");
			 System.out.println(e);
			 Assert.fail();
		}
}

public void selectPlanOne( String fare_type,String card) {
	try {
	fare_type="'"+fare_type+"'";
		driver.findElement(By.xpath("//div[@class='fli-list ']["+card+"]//div[@class='collapse show']//p[@class='fareNameHead blackFont blackText appendBottom3' and contains( text(),"+fare_type+")]// ancestor::div[@class='viewFareRowWrap']//div[@class='viewFareBtnCol']//button")).click();
		}catch(Exception e) {
			 System.out.println("ERROR IN selectPlanOne");
			 System.out.println(e);
			 Assert.fail();
		}
}
		
		
		
public void validateReviewPage(String Airplane_,String to_city,String from_city ) {
	
	try {

			ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(newTb.get(1));		
			String pageSourceFinal=driver.getPageSource();
///FLIGHT NAME TYPE 
			System.out.println(pageSourceFinal);
			Pattern  p=Pattern.compile("<p class=\"append_bottom5 font14 LatoBold\" style=\"color: rgb\\(0, 0, 0\\);\">[A-Za-z0-9\\s]+</p>");
			Matcher    m = p.matcher(pageSourceFinal);
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
			    
			    
		}catch(Exception e) {
			 System.out.println("REDIRECTED TO THE BOOKING PAGE ");
			 ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());		
				String pageSourceFinal=driver.getPageSource();
				
				System.out.println(pageSourceFinal);
				Pattern  p=Pattern.compile("<span class=\"fontSize14 boldFont appendRight10\">[A-Za-z0-9]+</span>");
				Matcher    m = p.matcher(pageSourceFinal);
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
				    String to=driver.findElement(By.xpath("//div//span[@class='fontSize14 blackFont']")).getText();
					 String regex = "["+from_city+"]+";
				     Pattern P1= Pattern.compile(regex);
				     Matcher m1 = P1.matcher(to);
				     Assert.assertTrue(m1.find());  
				     String from=driver.findElement(By.xpath("//div//span[@class='fontSize14 blackFont']")).getText();
					 regex = "["+to_city+"]+";
				     P1= Pattern.compile(regex);
				     m1 = P1.matcher(from);
				     Assert.assertTrue(m1.find());
				    
				    
				
			
		}
}
		
		
		
public void validateReviewPageOneWay(String Airplane_,String to_city,String from_city) {
	try {
			ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(newTb.get(1));
			String FightName=driver.findElement(By.xpath("//p[@class='append_bottom5 font14 LatoBold']")).getText();
			Assert.assertEquals(Airplane_.toUpperCase(),FightName.toUpperCase());
			String to=driver.findElement(By.xpath("//div[@class='fli-time-section pull-left']//p[@class='dept-city']//span[@class='LatoBold']")).getText();
			 String regex = "["+from_city+"]+";
		     Pattern P1= Pattern.compile(regex);
		     Matcher m1 = P1.matcher(to);
		     Assert.assertTrue(m1.find());  
		     String from=driver.findElement(By.xpath("//div[@class='fli-time-section pull-left']//p[@class='arrival-city']//span[@class='LatoBold']")).getText();
			 regex = "["+to_city+"]+";
		     P1= Pattern.compile(regex);
		     m1 = P1.matcher(from);
		     Assert.assertTrue(m1.find());
		
		     
		}catch(Exception e) {
			 System.out.println("REDIRECTED TO BOOKING PAGE");
			 ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());		
				String pageSourceFinal=driver.getPageSource();
				
				System.out.println(pageSourceFinal);
				Pattern  p=Pattern.compile("<span class=\"fontSize14 boldFont appendRight10\">[A-Za-z0-9]+</span>");
				Matcher    m = p.matcher(pageSourceFinal);
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
				    String to=driver.findElement(By.xpath("//div//span[@class='fontSize14 blackFont']")).getText();
					 String regex = "["+from_city+"]+";
				     Pattern P1= Pattern.compile(regex);
				     Matcher m1 = P1.matcher(to);
				     Assert.assertTrue(m1.find());  
				     String from=driver.findElement(By.xpath("//div//span[@class='fontSize14 blackFont']")).getText();
					 regex = "["+to_city+"]+";
				     P1= Pattern.compile(regex);
				     m1 = P1.matcher(from);
				     Assert.assertTrue(m1.find());
				    
			
		}
}
		
		
		
public static void validateCountPerson(String regex,String validate,String exact_data) {
	try {
			
			 Pattern P1= Pattern.compile(regex);
	 	     Matcher m1 = P1.matcher(validate);
	 	    if (m1.find()) {
	 	    	String final_ans=(m1.group());
	 	    	System.out.println(final_ans.substring(1));
	 	    	Assert.assertEquals(exact_data,final_ans.substring(1) );
	 	    } 
			
		}catch(Exception e) {
			 System.out.println("ERROR IN validateCountPerson ");
			 System.out.println(e);
			 Assert.fail();
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

public void validateReviewPaymentCard() {
	try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			WebDriverWait wait1=new WebDriverWait(driver,15);
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
		 	if(Fee_Surcharges.contains("₹"))
		 	Fee_Surcharges=Fee_Surcharges.replace("₹", "");
		 	if(Fee_Surcharges.contains(","))
		 	Fee_Surcharges=Fee_Surcharges.replace(",", "");
		 	if(Fee_Surcharges.contains(" "))
		 	Fee_Surcharges=Fee_Surcharges.replace(" ", "");
		 	
		 	other_charge=driver.findElement(By.xpath("//span[text()='Other Services']//ancestor::div[@class='fareSmry-header LatoBold']//span[@class='font16']")).getText();
		 	if(other_charge.contains("₹"))
		 	other_charge=other_charge.replace("₹", "");
		 	if(other_charge.contains(" "))
		 	other_charge=other_charge.replace(" ", "");
		 	if(other_charge.contains(","))
		 		other_charge=other_charge.replace(",", "");
		 	
		 	
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
		}catch(Exception e) {
			 System.out.println("ERROR IN validateReviewPaymentCard ");
			 System.out.println(e);
			 Assert.fail();
		}
}
		
		
		
public void insuranceAndVerifyAgain() {
	try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			WebDriverWait wait1=new WebDriverWait(driver,15);
			try {
			 	WebElement insurance=driver.findElement(By.xpath("//p[text()='Add-ons']"));
			 	 js.executeScript("arguments[0].scrollIntoView(true);",insurance );
			 	driver.findElement(By.xpath("//div[@class='labeltext block paddL30']")).click();
			 	
			 	js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
			 	
			 	driver.findElement(By.xpath("//span[text()='Other Services']//parent::p//span[@class='fareSmry-expand-icon cursor_pointer marR15 ']")).click();
			 	other_charge=driver.findElement(By.xpath("//span[text()='Other Services']//ancestor::div[@class='fareSmry-header LatoBold']//following-sibling::div[@class='fareSmry-wrap']//span[@class='font16 LatoBold text-right']//span")).getText();
			 	if(other_charge.contains("₹"))
			 	other_charge=other_charge.replace("₹", "");
			 	if(other_charge.contains(" "))
			 	other_charge=other_charge.replace(" ", "");
			 	if(other_charge.contains(",")) {
			 	other_charge=other_charge.replace(",", "");	
			 	}
			 	System.out.println(other_charge);
			 	}catch(Exception e) {
			 		
			 	try {
			 		WebElement insurance=driver.findElement(By.xpath("//span[@class='bgProperties insuranceIcon appendRight10']"));
				 	 js.executeScript("arguments[0].scrollIntoView(true);",insurance );
				 	driver.findElement(By.xpath("//span[@class='darkText lightFont fontSize14 appendLeft10']//child::b[text()='Yes,']")).click();
				 	
				 	js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
				 	
				 	driver.findElement(By.xpath("//span[text()='Other Services']//parent::p//span[@class='fareSmry-expand-icon cursor_pointer marR15 ']")).click();
				 	other_charge=driver.findElement(By.xpath("//span[text()='Other Services']//ancestor::div[@class='fareSmry-header LatoBold']//following-sibling::div[@class='fareSmry-wrap']//span[@class='font16 LatoBold text-right']//span")).getText();
				 	if(other_charge.contains("₹"))
				 	other_charge=other_charge.replace("₹", "");
				 	if(other_charge.contains(" "))
				 	other_charge=other_charge.replace(" ", "");
				 	if(other_charge.contains(",")) {
				 	other_charge=other_charge.replace(",", "");	
				 	
				 	}
			 		
			 	}catch(Exception e1) {
			 		System.out.println("Insurance Not Found");
			 		System.out.println(e);
			 	}
			 		
			 	}
			
			 	totalPrice=driver.findElement(By.xpath("//span[text()='Total Amount:']//ancestor::div[@class='fareSmry-sctn reqPad-fareSmry-sctn']//span[@class='font20']//span//span")).getText();
			 	if(totalPrice.contains("₹"))
			 	totalPrice=totalPrice.replace("₹", "");
			 	if(totalPrice.contains(","))
			 	totalPrice=totalPrice.replace(",", "");
			 	if(totalPrice.contains(" "))
			 	totalPrice=totalPrice.replace(" ", "");
			 	
			 	String s1=driver.getWindowHandle();
			 	validateAmount();
		}catch(Exception e) {
			 System.out.println("ERROR IN insuranceAndVerifyAgain");
			 System.out.println(e);
			 Assert.fail();
		}
}
}
