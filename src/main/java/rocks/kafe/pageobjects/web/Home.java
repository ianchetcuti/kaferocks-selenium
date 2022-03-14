package rocks.kafe.pageobjects.web;

import rocks.kafe.utils.Driver;

public class Home implements rocks.kafe.pageobjects.interfaces.HomePage {

    public Driver driver = new Driver();

    @Override
    public void navigate() {
        driver.getWebDriver().navigate().to("https://www.kafe.rocks");
    }
}
