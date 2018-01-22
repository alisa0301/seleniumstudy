package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FilmPage {
    private static final String MOVIE_NAME = ".moviename-big";
    private WebDriver driver;

    public FilmPage(WebDriver driver) {
        this.driver = driver;
    }

    public String findMovieTitle() {
        WebElement nameField = driver.findElement(By.cssSelector(MOVIE_NAME));
        return nameField.getText();
    }
}
