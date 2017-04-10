package page.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    public void inputFahrenheit(double valueOfFahrenheit){
        String s = Double.toString(valueOfFahrenheit);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("_Aif")));
        System.out.println("Found Aif");
        driver.findElement(By.xpath(".//*[@id='_Aif']/input")).clear();
        driver.findElement(By.xpath(".//*[@id='_Aif']/input")).sendKeys(s);
    }
    public String actualResult(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("_Cif")));
        System.out.println("Found Cif");
        String valueOfCelsius = driver.findElement(By.xpath(".//*[@id='_Cif']/input")).getAttribute("value");
        System.out.println(valueOfCelsius);
        return valueOfCelsius;
    }
    public String expectedResult(){ return "37"; }
}
