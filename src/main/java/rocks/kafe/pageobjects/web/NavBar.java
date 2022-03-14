package rocks.kafe.pageobjects.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import rocks.kafe.pageobjects.interfaces.NavigationMenu;

import java.util.List;

public class NavBar extends Home implements NavigationMenu {

    private By menuElement = By.xpath("//*[@id=\"top-menu\"]/li");

    @Override
    public List<WebElement> elements(){return super.driver.getWebDriver().findElements(menuElement);}

    public enum MenuItems {
        ABOUT(0),
        CAREERS(1),
        PARTNERS(2),
        VALUES(3),
        ENVIRONMENT(4),
        NEWS(5),
        CONTACT(6);

        final int index;
        MenuItems(int idx){
            this.index = idx;
        }

        public int getIndex(){
            return index;
        }
    }
}
