package traveloka;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CarRental {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);

        driver.get("https://www.traveloka.com/en-en");
    }

    public void accessMenuCarRental(){
        WebElement carRentalTabMenu = driver.findElement(By.partialLinkText("Car Rental"));
        carRentalTabMenu.click();
    }

    public void inputDataCarRental(){
        WebElement withoutDriverRadioButton = driver.findElement(By.cssSelector("[data-testid='rental-search-form'] [role='radiogroup'] [role='radio']:nth-of-type(1)"));
        WebElement rentalLocationTextField = driver.findElement(By.cssSelector("[data-testid='rental-search-form-location-input']"));
        WebElement selectRentalLocation = driver.findElement(By.xpath("//div[@aria-label='Jakarta']"));
        WebElement rentalStartDateTextField = driver.findElement(By.cssSelector("[data-testid='rental-search-form-date-input-start']"));
        WebElement rentalStartTimeTextField = driver.findElement(By.cssSelector("[data-testid='rental-search-form-time-input-start']"));
        WebElement rentalEndDateTextField = driver.findElement(By.cssSelector("[data-testid='rental-search-form-date-input-end']"));
        WebElement rentalEndTimeTextField = driver.findElement(By.cssSelector("[data-testid='rental-search-form-time-input-end']"));
        WebElement searchCarButton = driver.findElement(By.cssSelector("[data-testid='rental-search-form-cta']"));


        withoutDriverRadioButton.click();
        rentalLocationTextField.sendKeys("Jakarta");
        selectRentalLocation.click();
        rentalStartDateTextField.sendKeys("20 March 2024");
        rentalStartTimeTextField.sendKeys("09:00");
        rentalEndDateTextField.sendKeys("22 March 2024");
        rentalEndTimeTextField.sendKeys("09:00");
        searchCarButton.click();
    }

    public void hardWait(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void runnerRentalCar(){
        accessMenuCarRental();
        inputDataCarRental();
        hardWait();
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
