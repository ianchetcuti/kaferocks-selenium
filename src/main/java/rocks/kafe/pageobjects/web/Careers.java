package rocks.kafe.pageobjects.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import rocks.kafe.utils.Driver;
import java.util.List;

public class Careers implements rocks.kafe.pageobjects.interfaces.CareersPage {
    private Driver driver = new Driver();

    private By openPositionBoxes = By.cssSelector("article[class*='dp-dfg-item']");
    private By searchTxtBox = By.cssSelector("input[class*='dp-dfg-search-input']");
    private By searchBtn = By.cssSelector("span[class*='dp-dfg-search-icon']");
    private By spinnerAnimation = By.cssSelector("div[class*='et-fb-loader-wrapper']");

    @Override
    public List<WebElement> getOpenPositions(){
        return driver.getWebDriver().findElements(openPositionBoxes);
    }

    @Override
    public void searchCareers(String searchTerm){
        //driver.getWebDriver().findElement(searchTxtBox).click();
        driver.getWebDriver().findElement(searchTxtBox).sendKeys(searchTerm);
        driver.getWebDriver().findElement(searchBtn).click();

        new WebDriverWait(driver.getWebDriver(), 10).until(
                ExpectedConditions.invisibilityOfElementLocated(spinnerAnimation));
    }

}
