package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TicTacToePage {
    private final WebDriver driver;
    private final String baseUrl;

    public TicTacToePage(WebDriver driver, String baseUrl) {
        this.driver = driver;
        this.baseUrl = baseUrl;
    }

    public void navigateTo() {
        driver.get(baseUrl);
    }

    public void play() {
        WebElement pressPlay = driver.findElement(By.xpath(Selectors.PLAY_BUTTON));
        pressPlay.click();
    }

    public void enterMove(int number) {
        WebElement cell = driver.findElement(By.xpath(String.format("//td[@id='%s']", number)));
        cell.click();
    }

    public void enterNumber(int number) {
        WebElement numberInput = driver.findElement(By.cssSelector(Selectors.NUMBER_INPUT_FIELD));
        numberInput.click();
        numberInput.sendKeys(String.valueOf(number));
    }

    public String getGameResultMessage() {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement endgameElement = driver.findElement(By.id(Selectors.ENDGAME_MESSAGE_XPATH));
        return endgameElement.getText();
    }
}