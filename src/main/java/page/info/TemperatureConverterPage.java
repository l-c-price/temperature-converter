package page.info;

import org.openqa.selenium.WebDriver;

/**
 * Created by Novus_Admin on 4/10/2017.
 */
public class TemperatureConverterPage {
    private WebDriver driver;

    public TemperatureConverterPage(WebDriver driver){
        this.driver = driver;
        System.out.println(driver.getTitle());
        if (!driver.getTitle().equals("fahrenheit to celsius - Google Search")) {
            throw new WrongPageException("Incorrect page for temperature conversion");
        }
    }
}
