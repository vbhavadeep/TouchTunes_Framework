package touch_Tunes.automation.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class GoogleSearchResultsPage extends WebDriverBaseTestPage<GoogleHomePage>{

	
	@FindBy(xpath="//h3[contains(@class,LC20lb) or contains(@class,zTpPx)]")
    private List<QAFWebElement> titleElements;
	
	@Override
	protected void openPage(PageLocator locator, Object... args) {
		
	}

	
	public List<String> getAllSearchResultTitles(){
		List<String> list = new ArrayList<String>();
		
		
		
		for(QAFWebElement qaele : titleElements) {
			String text = qaele.getText();
			if(!text.equals(""))
				list.add(text);
		}
		
		return list;
	}
}
