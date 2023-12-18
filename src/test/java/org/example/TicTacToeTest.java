package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class TicTacToeTest {

    private WebDriver driver;

    private TicTacToePage ticTacToePage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/ericedmonds/Downloads/chromedriver_mac64/chromedriver");
        driver = new ChromeDriver();
        ticTacToePage = new TicTacToePage(driver, "https://roomy-fire-houseboat.glitch.me/");
    }

    @Test
    public void testXWins() {
        ticTacToePage.navigateTo();
        ticTacToePage.enterNumber(3);
        ticTacToePage.play();

        // X wins by filling a row
        ticTacToePage.enterMove(0); // X
        ticTacToePage.enterMove(7); // O
        ticTacToePage.enterMove(3); // X
        ticTacToePage.enterMove(4); // O
        ticTacToePage.enterMove(6); // X

        // Assert that the game declares "X" as the winner
        assertEquals("Congratulations player X! You've won. Refresh to play again!", ticTacToePage.getGameResultMessage());
    }

    @Test
    public void testOWins() {

        ticTacToePage.navigateTo();
        ticTacToePage.enterNumber(3);
        ticTacToePage.play();

        // O wins by filling a column
        ticTacToePage.enterMove(0); //X
        ticTacToePage.enterMove(2); //O
        ticTacToePage.enterMove(7); //X
        ticTacToePage.enterMove(4); //O
        ticTacToePage.enterMove(3); //X
        ticTacToePage.enterMove(6); //O

        // Assert that the game declares "O" as the winner
        assertEquals("Congratulations player O! You've won. Refresh to play again!", ticTacToePage.getGameResultMessage());
    }

    @Test
    public void testDraw() {
        ticTacToePage.navigateTo();
        ticTacToePage.enterNumber(3);
        ticTacToePage.play();

        // Play a sequence of moves resulting in a draw
        ticTacToePage.enterMove(0); //X
        ticTacToePage.enterMove(2); //O
        ticTacToePage.enterMove(1); //X
        ticTacToePage.enterMove(3); //0
        ticTacToePage.enterMove(5); //X
        ticTacToePage.enterMove(4); //O
        ticTacToePage.enterMove(6); //X
        ticTacToePage.enterMove(8); //O
        ticTacToePage.enterMove(7); //X

        // Assert that the game declares a draw
        assertEquals("It's a draw!", ticTacToePage.getGameResultMessage());
    }
    @Test
    public void testReset(){
        ticTacToePage.navigateTo();
        ticTacToePage.enterNumber(3);
        ticTacToePage.play();
    }

    @After
    public void tearDown() {
        // Close the WebDriver instance after the test execution
        if (driver != null) {
            driver.quit();
        }
    }

}