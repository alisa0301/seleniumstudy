import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Before;
import org.junit.Test;
import pages.FilmPage;
import pages.MainPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class KinoPoiskTest {

    private static final String GEO = "Геошторм";

    @Before
    public void createDriver() {
        //Открытие страницы в Selenide:
        //Если ранее был создан экземпляр WebDriver, то будет
        //использован он, иначе будет создан новый экземпляр
        //WebDriver. В конце теста нет необходимости закрывать
        //окно браузера
        open("https://www.kinopoisk.ru/");
        //В селениде есть возможность получить текущий экземпляр
        //драйвера и вызвать его методы:
        WebDriverRunner.getWebDriver().manage().window().fullscreen();
        //Получить текущий url страницы:
        WebDriverRunner.url();
    }

    @Test
    public void searchFilm() throws InterruptedException {
        //инициализация страницы:
        MainPage mainPage = Selenide.page(MainPage.class);
        FilmPage filmPage = mainPage.searchInfo(GEO);
        //Ожидания: можно использовать вместо ассертов
        filmPage.findMovieTitle().shouldHave(text(GEO));
        //Получить title страницы:
        title();
        //Снять скриншот элемента
        //(проблемы при кастомном разрешении)
        filmPage.findMovieTitle().screenshot();
        //снять скриншот всей страницы:
        Selenide.screenshot("kinopoisk");
    }

    @Test
    public void openNewWindowHandler() throws InterruptedException {
//      Как нажимать на клавиатуре сочетание клавиш
//        String keys = chord(Keys.COMMAND, "T");
//        driver.switchTo().activeElement().sendKeys(keys);

//      Как исполнять js-скрипты (в данном случае открытие новой вкладки)
        executeJavaScript("window.open('https://www.google.com')");
        Thread.sleep(3000);
    }

    @Test
    public void explicitlyWaitTest() {
        MainPage mainPage = page(MainPage.class);
        mainPage.hoverOnElementAndCheckPopUp();
    }
}
