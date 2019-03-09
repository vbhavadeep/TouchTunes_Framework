package touch_Tunes.automation.testscripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.internal.Utils;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.ws.rest.RestTestBase;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import touch_Tunes.automation.pages.LinksPage;

public class TestLinksPages extends WebDriverTestCase {

	

	@Test
	public void testPageLinks() {
		String url = getProps().getPropertyValue("pageurl");
		getDriver().get(url);

		// Fetching all links
		LinksPage foodServicesPage = new LinksPage();
		List<String> allHrefLinksList = foodServicesPage.getAllLinksWithTouchtunes();
		String allHeadings = "";
		for (String food : allHrefLinksList) {
			allHeadings = allHeadings + food + "\n";
		}

		
		// Verify status of each link for 200 and 302 , if not print to console
		List<String> brokenLinks = new ArrayList<String>();

		String headingstatus = "";
		for (String link : allHrefLinksList) {
			if (!(link.equals("") || link == null)) {
				try {
					WebResource webResource = new RestTestBase().getWebResource(link, "/");
					ClientResponse cr = webResource.get(ClientResponse.class);
					verifyTrue((cr.getStatus() != 200 || cr.getStatus() != 302), "Broken Link", "Working");
					headingstatus = headingstatus + link + "\n";
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		// Writing into file
		Utils.writeFile("reports", "Href_Results_file" + System.currentTimeMillis() + ".log", headingstatus);

		System.out.println("---------- Broken Links ----------");
		for (String string : brokenLinks) {
			
			System.out.println(string);
			}
		if(brokenLinks.isEmpty()) {
			System.out.println("---------- No Broken Links Found ----------");
			
		}
	}

}
