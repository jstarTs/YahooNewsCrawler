package testSelenium;
//We specify the package of our tests  

import com.thoughtworks.selenium.*;  
import com.thoughtworks.selenium.SeleneseTestCase;  
//This is the driver's import. You'll use this for instantiating a  
//browser and making it do what you need.  

import java.util.regex.Pattern;  
//Selenium-IDE add the Pattern module because it's sometimes used for  
//regex validations. You can remove the module if it's not used in your  
//script.  

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NewTest extends SeleneseTestCase 
{  
//We create our Selenium test case  

   public void setUp() throws Exception {  
     setUp("http://www.google.com/", "*firefox");  
          // We instantiate and start the browser  
	   //setUp("http://tw.news.yahoo.com/archive", "*chrome");  
	     //selenium.waitForPageToLoad("30000");  
   }  

   public void testNew() throws Exception {  
//        selenium.open("/");  
//        selenium.type("q", "selenium rc");  
//        selenium.click("btnG");  
//        selenium.waitForPageToLoad("30000");  
//        assertTrue(selenium.isTextPresent("Results * for selenium rc"));  
        // These are the real test steps  
	   
	   selenium.open("http://tw.news.yahoo.com/archive");  
	   selenium.windowMaximize();  
	   
   }
   
   public static void print(String msg, Object... args) {  
       System.out.println(String.format(msg, args));  
       
   }  
   
   public static void gettips(Document doc){  
       
       //Elements tips = doc.select(".tipText");  
       Elements tips = doc.select("li"); 
        int count = 0;  
        //BasicDBObject document4 = new BasicDBObject();  
        for (Element link : tips){  
              
            String str2 = new String(link.text());  
            count++;  
            String tempint = String.valueOf(count);  
            //document4.put(tempint, str);  
            print("%s \r\n", str2);  
        }  
   } 
   
   public static void main(String[] args)
   {
	   NewTest test = new NewTest();
	   
	   try 
	   {
		   test.setUp();
		   test.testNew();
		   
		   
		   
	   } catch (Exception e) {
		// TODO Auto-generated catch block
		   e.printStackTrace();
	   }
	   
   }
   
   
}  