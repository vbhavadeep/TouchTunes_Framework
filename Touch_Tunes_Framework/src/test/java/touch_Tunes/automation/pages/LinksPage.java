package touch_Tunes.automation.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.FindBy;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class LinksPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(xpath = "//a[contains(@href,'touchtunes')]")
	private List<QAFWebElement> linkElements;

	@Override
	protected void openPage(PageLocator locator, Object... args) {

	}

	public List<String> getAllLinksWithTouchtunes() {
		List<String> list = new ArrayList<String>();
		String baseUrl = driver.getCurrentUrl();

		for (QAFWebElement linkElement : linkElements) {
			String link = "";
			String url = linkElement.getAttribute("href").trim();
			if (url.startsWith("/")) {
				link = baseUrl + url;
			} else {
				link = url;
			}

			list.add(link);
		}

		return list;
	}

}
