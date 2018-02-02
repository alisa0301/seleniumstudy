package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class FilmPage {


    @FindBy(css = ".moviename-big")
    private SelenideElement filmTitle;


    public SelenideElement findMovieTitle() {
        return filmTitle;
    }
}
