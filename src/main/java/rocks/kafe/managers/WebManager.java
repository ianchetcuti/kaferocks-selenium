package rocks.kafe.managers;

import rocks.kafe.pageobjects.interfaces.CareersPage;
import rocks.kafe.pageobjects.interfaces.NavigationMenu;
import rocks.kafe.pageobjects.interfaces.HomePage;
import rocks.kafe.pageobjects.web.Careers;
import rocks.kafe.pageobjects.web.Home;
import rocks.kafe.pageobjects.web.NavBar;
import rocks.kafe.utils.Driver;

public class WebManager {
    private HomePage homePage = new Home();
    private NavigationMenu topMenu = new NavBar();
    private CareersPage careersPage = new Careers();

    public void initialiseWebTests(){
        Driver.setBrowser(System.getProperty("browser"));
        Driver.startWebDriver();

        homePage.navigate();
        topMenu.elements().get(NavBar.MenuItems.CAREERS.getIndex()).click();
        System.out.println("There are "+careersPage.getOpenPositions().size()+" positions open");
        careersPage.searchCareers("qa");
        System.out.println("There are "+careersPage.getOpenPositions().size()+" QA related positions open");

        Driver.nullifyWebDriver();
    }
}
