package page.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
    public TemperatureConverterPage goToTemperatureConversionPage(){
        driver.findElement(By.id("lst-ib")).clear();
        driver.findElement(By.id("lst-ib")).sendKeys("fahrenheit to celsius");
        driver.findElement(By.name("btnK")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("resultstats")));
        return new TemperatureConverterPage(driver);
    }
}
