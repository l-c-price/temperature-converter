package page.info;

import org.openqa.selenium.WebDriver;

/**
 * Created by Novus_Admin on 4/10/2017.
 */
public class Google {
    private WebDriver driver;
    private String baseURL;

    public Google(WebDriver driver){
        this.driver = driver;
        baseURL = "https://www.google.co.uk/";
        //driver.get(baseURL + "?gfe_rd=cr&ei=HU_rWP_SFcPU8ge0x5noDA#q=fahrenheit+to+celsius");
        System.out.println(driver.getTitle());
        //if (!driver.getTitle().equals("fahrenheit to celsius - Google Search"))
        if (!driver.getTitle().equals("Google")) {
            throw new WrongPageException("Incorrect page for the Google");
        }
    }
}
