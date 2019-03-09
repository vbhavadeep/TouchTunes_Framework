package touch_Tunes.automation.testscripts;

import java.util.List;

import org.testng.annotations.Test;
import org.testng.internal.Utils;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;

import touch_Tunes.automation.pages.GoogleHomePage;
import touch_Tunes.automation.pages.GoogleSearchResultsPage;

public class TestGoogleResults extends WebDriverTestCase{

	@Test
	public void verifySearchResults() {
		String url = getProps().getPropertyValue("env.baseurl");
		logger.info(" Launching the application - "  + url);
		getDriver().get(url);
		GoogleHomePage googleHomePage = new GoogleHomePage();
		googleHomePage.search("touchtunes");
		
		GoogleSearchResultsPage googleSearchResultsPage = new GoogleSearchResultsPage();
		List<String> resultTitles = googleSearchResultsPage.getAllSearchResultTitles();
		String allHeadings = "";
		for (String string : resultTitles) {
			allHeadings = allHeadings + string + "\n";
			
			  if(string.toLowerCase().contains("touchtunes")) {
			  System.out.println("TouchTunes is present in the link"); } else {
			  System.out.println("TouchTunes is not present in the link"); }
			 
			
			System.out.println(string);
			
		}
		
		Utils.writeFile("reports", "TouchTunes_in_Search_report"+System.currentTimeMillis()+".log", allHeadings);
	}
}
