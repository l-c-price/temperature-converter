package converter.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.info.Google;
import page.info.TemperatureConverterPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


/**
 * Created by Novus_Admin on 4/7/2017.
 */
public class ConversionStepDefs {
    private WebDriver driver;
    public Google googlePage;
    public TemperatureConverterPage temperatureConverterPage;
    @Given("^I want to convert (\\d+)\\.(\\d+) degree Fahrenheit to Celsius$")
    public void i_want_to_convert_degree_Fahrenheit_to_Celsius(int arg1, int arg2) throws Throwable {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Novus_Admin\\Downloads\\Selenium Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        googlePage = new Google(driver);
        temperatureConverterPage = googlePage.goToTemperatureConversionPage();
    }

    @When("^I input the value of Fahrenheit as (\\d+)\\.(\\d+) in text field$")
    public void i_input_the_value_of_Fahrenheit_as_in_text_field(int arg1, int arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        temperatureConverterPage.inputFahrenheit(98.6);
    }

    @Then("^It should be converted to Celsius as (\\d+) degree$")
    public void it_should_be_converted_to_Celsius_as_degree(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(temperatureConverterPage.actualResult(), temperatureConverterPage.expectedResult());
        driver.quit();
    }


}
