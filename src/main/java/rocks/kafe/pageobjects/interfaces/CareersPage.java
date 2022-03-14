package rocks.kafe.pageobjects.interfaces;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface CareersPage {
    List<WebElement> getOpenPositions();
    void searchCareers(String searchTerm);
}
