package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    private static final String POP_UP_SELECTOR = ".header-menu-partial-component__subitems";

    @FindBy(className = "header-search-partial-component__search-field")
    private SelenideElement searchField;

    @FindBy(xpath = "//span[text()='Рейтинги']")
    private SelenideElement ratings;

    public FilmPage searchInfo(String info) {
        searchField.sendKeys(info);
        searchField.submit();
        return page(FilmPage.class);
    }

    public void hoverOnElementAndCheckPopUp(){
        //наведение на элемент
        ratings.hover();
        SelenideElement popUp = $(POP_UP_SELECTOR);
        //явные ожидания в Selenide:
        popUp.waitUntil(Condition.visible, 10000);
        //Можно использовать вместо Ассертов, здесь
        //используются неявные ожидания
        //popUp.shouldBe(Condition.appear);
    }
}
