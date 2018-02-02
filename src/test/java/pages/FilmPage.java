package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilmPage {


    @FindBy(css = ".moviename-big")
    private SelenideElement filmTitle;


    public SelenideElement findMovieTitle() {
        return filmTitle;
    }
}
