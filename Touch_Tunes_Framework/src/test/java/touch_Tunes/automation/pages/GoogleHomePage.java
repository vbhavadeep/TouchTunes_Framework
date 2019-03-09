package touch_Tunes.automation.pages;

import org.openqa.selenium.support.FindBy;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class GoogleHomePage extends WebDriverBaseTestPage<WebDriverTestPage>{

	@FindBy(name="q")
    private QAFWebElement searchEle;
	
	@FindBy(name="btnK")
    private QAFWebElement clickEle;
	
	@Override
	protected void openPage(PageLocator locator, Object... args) {
		driver.get("/");
	}

	
	public void search(String searchQuery) {
		searchEle.sendKeys(searchQuery);
		clickEle.click();
	}
}
