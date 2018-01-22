import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.FilmPage;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.Keys.*;
import static org.openqa.selenium.Keys.chord;

public class KinoPoiskTest {

    WebDriver driver;
    private static final String GEO = "Геошторм";

    @Before
    public void createDriver() {
        driver = new ChromeDriver();
        driver.get("https://www.kinopoisk.ru/");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void closeDriver(){
        driver.quit();
    }

    @Test
    public void searchFilm() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        FilmPage filmPage = mainPage.searchInfo(GEO);
        Assert.assertEquals(GEO, filmPage.findMovieTitle());
    }

    @Test
    public void openNewWindowHandler() throws InterruptedException {
//      Как нажимать на клавиатуре сочетание клавиш
//        String keys = chord(Keys.COMMAND, "T");
//        driver.switchTo().activeElement().sendKeys(keys);

//      Как исполнять js-скрипты (в данном случае открытие новой вкладки)
        ((JavascriptExecutor) driver).executeScript("window.open('https://www.google.com')");
        Thread.sleep(3000);
    }

    @Test
    public void explicitlyWaitTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.hoverOnElementAndCheckPopUp();
    }
}
