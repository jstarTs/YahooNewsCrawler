import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

//import org.apache.cxf.jaxrs.client.ClientState;
//import org.apache.cxf.jaxrs.client.WebClient;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;  

import com.thoughtworks.selenium.*;  

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class testJsoupYahoo 
{
	
	public static void main(String[] args)
	{

		
		try 
		{

			WebClient webClient = new WebClient(BrowserVersion.FIREFOX_45);
            HtmlPage htmlPage = (HtmlPage) webClient.getPage("https://tw.news.yahoo.com/archive");
			
            webClient.getOptions().setThrowExceptionOnScriptError(false);
            
            DomNodeList domNodeList = htmlPage.getElementsByTagName("li");
            for (int i = 0; i < domNodeList.size(); i++) {
                DomElement domElement = (DomElement) domNodeList.get(i);
                System.out.println(domElement.asText());
            }
            webClient.close();
            
            
            //String urlstr = "https://tw.news.yahoo.com/%E6%B7%A1%E5%AD%A3%E8%A1%9D%E8%B2%B7%E6%B0%A3-%E9%87%8F%E8%B2%A9%E5%BA%97%E6%8E%A8%E9%AE%91%E9%AD%9A-%E7%87%95%E7%AA%A9%E8%A9%A6%E5%90%83-042031924.html";
			
			String urlstr = "http://tw.news.yahoo.com/archive";
			
			
			//URL url = new URL(urlstr);
			
			//Document document = Jsoup.parse(url, 3000);
			Document document = Jsoup.connect(urlstr).get();
			
			//Document document=Jsoup.parse(htmlPage.asXml());
			
			//Element newlistone = document.getElementById("Col1-3-StreamContainerArchive-Proxy");
			
			Elements newlistone = document.getElementsByTag("li");
			
			System.out.println(newlistone.size());
			
			
			Elements newsList = document.getElementsByClass("Pos(r) Mt(30px) Ff(standardFf) Fw(standardFw) C(#000) Mt(11px)!");
			
			System.out.println(newsList.first().getElementsByTag("li").size());
			
//			for(Element newsArticle : newsList.first().getAllElements())
//			{
//				System.out.println(newsArticle.child(0).tagName());
//			}
			
//			String title , testurl ;
//			
//			for(Element newsArticle : newlistone)
//			{
//				testurl = newsArticle.getElementsByClass("h3").first().absUrl("href");
//				title = newsArticle.getElementsByClass("h3").first().text();
//				System.out.println(testurl);
//				System.out.println(title);
//			}
			
//			Element title = document.getElementById("mediaarticlehead").getElementsByClass("headline").first();
//			System.out.println(title.text());
//			
//			Elements pList = document.getElementById("mediaarticlebody").getElementsByClass("bd").first().select("p");
//			System.out.println(pList.size());
//			
//			String content = "";
//			for (Element p : pList) {
//				System.out.println(p.text());
//				content += p.text();
//			}
//			System.out.println(content);
		
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
