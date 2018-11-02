package core;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.safari.*;
import org.openqa.selenium.chrome.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;
import org.openqa.selenium.By;
import java.lang.*;
import java.io.*;


class MainPageTest {
    static WebDriver driver;

    static void initialize(String browser, String url) {
        switch (browser.toLowerCase()) {
            case "chrome": {
                Logger.getLogger("").setLevel(Level.OFF);
                if (System.getProperty("os.name").toUpperCase().contains("MAC")) {
                    System.setProperty("webdriver.chrome.driver", "resources/webdriver/mac/chromedriver");
                } else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS")) {
                    System.setProperty("webdriver.chrome.driver", "resources/webdriver/pc/chromedriver.exe");
                } else throw new IllegalArgumentException("Unknown OS");
                System.setProperty("webdriver.chrome.silentOutput", "true");
                ChromeOptions setoption = new ChromeOptions();
                setoption.addArguments("disable-infobars");
                setoption.addArguments("--disable-notifications");
                setoption.addArguments("--disable-annotations");
                if (System.getProperty("os.name").toUpperCase().contains("MAC"))
                    setoption.addArguments("--start-fullscreen");
                else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))
                    setoption.addArguments("--start-maximized");
                else throw new IllegalArgumentException("Unknown OS");
                driver = new ChromeDriver(setoption);
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.get(url);
                break;
            }
            case "firefox": {
                Logger.getLogger("").setLevel(Level.OFF);
                if (System.getProperty("os.name").toUpperCase().contains("MAC"))
                    System.setProperty("webdriver.gecko.driver", "resources/webdriver/mac/geckodriver.sh");
                else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))
                    System.setProperty("webdriver.gecko.driver", "resources/webdriver/mac/geckodriver.exe");
                else throw new IllegalArgumentException("Unknown OS");
                driver = new FirefoxDriver();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                driver.get(url);
                break;
            }
            case "safari": {
                Logger.getLogger("").setLevel(Level.OFF);
                driver = new SafariDriver();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                driver.get(url);
                break;
            }
            default:
                throw new IllegalArgumentException("Unknown browser");
        }
    }
    //To initialize browser

    static String getElementText (By by) {
        String text = driver.findElement(by).getText(); return text; }

    static String getElementColor (By by) {
        String color = driver.findElement(by).getCssValue("color"); return color; }

    static boolean colorMatch (String actualColor, String expectedColor) {
         if(actualColor.equals(expectedColor)) return true; return false; }

    static boolean isUpperCase (String entry) {
        if(entry.equals(entry.toUpperCase())) return true; else return false;}

    static void click(By by) {driver.findElement(by).click();}

    static By carouselBackground = By.xpath("//div[@data-reactid='108']");
    static By carouselDotOne = By.xpath("//*[@data-testid='carouselControlDot-0']");
    static By carouselDotTwo = By.xpath("//*[@data-testid='carouselControlDot-1']");
    static By carouselDotThree = By.xpath("//*[@data-testid='carouselControlDot-2']");
    static By carouselDotFour = By.xpath("//*[@data-testid='carouselControlDot-3']");
    static By carouselDotFive = By.xpath("//*[@data-testid='carouselControlDot-4']");
    static By textLineOne = By.xpath("//a[@data-reactid='160']");
    static By textLineTwo = By.xpath("//a[@data-reactid='161']");
    static By textLineThree = By.xpath("//a[@data-reactid='162']");
    static By textLineFour = By.xpath("//a[@data-reactid='165']");
    static By textLineFive = By.xpath("//a[@data-reactid='166']");
    static By textLineSix = By.xpath("//a[@data-reactid='167']");
    static By textLineSeven = By.xpath("//a[@data-reactid='170']");
    static By textLineEight = By.xpath("//a[@data-reactid='171']");
    static By textLineNine = By.xpath("//a[@data-reactid='172']");
    static By textLineTen = By.xpath("//a[@data-reactid='175']");
    static By textLineEleven = By.xpath("//a[@data-reactid='176']");
    static By textLineTwelfth = By.xpath("//a[@data-reactid='177']");
    static By textLineThirteen = By.xpath("//a[@data-reactid='180']");
    static By textLineFourteen = By.xpath("//a[@data-reactid='181']");
    static By textLineFifteen = By.xpath("//a[@data-reactid='182']");

    static ArrayList<String> colorList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        initialize("chrome", "https://tunein.com/?homecarouselautoscroll=false");
        FileOutputStream f = new FileOutputStream("report.txt");
        System.setOut(new PrintStream(f));

        System.out.printf("\nTC-01.01.01: %s", (isUpperCase(getElementText(textLineOne))?"Passed":"Failed : Text must be in Upper case"));
        System.out.printf("\nTC-01.01.02: %s", (isUpperCase(getElementText(textLineTwo))?"Passed":"Failed : Text must be in Upper case"));
        System.out.printf("\nTC-01.01.03: %s", (isUpperCase(getElementText(textLineThree))?"Passed":"Failed : Text must be in Upper case"));
        System.out.printf("\nTC-01.01.04: %s", (isUpperCase(getElementText(textLineFour))?"Passed":"Failed : Text must be in Upper case"));
        System.out.printf("\nTC-01.01.05: %s", (isUpperCase(getElementText(textLineFive))?"Passed":"Failed : Text must be in Upper case"));
        System.out.printf("\nTC-01.01.06: %s", (isUpperCase(getElementText(textLineSix))?"Passed":"Failed : Text must be in Upper case"));
        System.out.printf("\nTC-01.01.07: %s", (isUpperCase(getElementText(textLineSeven))?"Passed":"Failed : Text must be in Upper case"));
        System.out.printf("\nTC-01.01.08: %s", (isUpperCase(getElementText(textLineEight))?"Passed":"Failed : Text must be in Upper case"));
        System.out.printf("\nTC-01.01.09: %s", (isUpperCase(getElementText(textLineNine))?"Passed":"Failed : Text must be in Upper case"));
        System.out.printf("\nTC-01.01.10: %s", (isUpperCase(getElementText(textLineTen))?"Passed":"Failed : Text must be in Upper case"));
        System.out.printf("\nTC-01.01.11: %s", (isUpperCase(getElementText(textLineEleven))?"Passed":"Failed : Text must be in Upper case"));
        System.out.printf("\nTC-01.01.12: %s", (isUpperCase(getElementText(textLineTwelfth))?"Passed":"Failed : Text must be in Upper case"));
        System.out.printf("\nTC-01.01.13: %s", (isUpperCase(getElementText(textLineThirteen))?"Passed":"Failed : Text must be in Upper case"));
        System.out.printf("\nTC-01.01.14: %s", (isUpperCase(getElementText(textLineFourteen))?"Passed":"Failed : Text must be in Upper case"));
        System.out.printf("\nTC-01.01.15: %s", (isUpperCase(getElementText(textLineFifteen))?"Passed":"Failed : Text must be in Upper case"));

        System.out.printf("\n\nTC-01.02.01: %s", (colorMatch(getElementColor(textLineOne),"rgba(255, 255, 255, 1)")?"Passed":"Failed : Font color mismatch"));
        System.out.printf("\nTC-01.02.02: %s", (colorMatch(getElementColor(textLineTwo),"rgba(255, 255, 255, 1)")?"Passed":"Failed : Font color mismatch"));
        System.out.printf("\nTC-01.02.03: %s", (colorMatch(getElementColor(textLineThree),"rgba(28, 32, 60, 1)")?"Passed":"Failed : Font color mismatch"));
        System.out.printf("\nTC-01.02.04: %s", (colorMatch(getElementColor(textLineFour),"rgba(255, 255, 255, 1)")?"Passed":"Failed : Font color mismatch"));
        System.out.printf("\nTC-01.02.05: %s", (colorMatch(getElementColor(textLineFive),"rgba(255, 255, 255, 1)")?"Passed":"Failed : Font color mismatch"));
        System.out.printf("\nTC-01.02.06: %s", (colorMatch(getElementColor(textLineSix),"rgba(28, 32, 60, 1)")?"Passed":"Failed : Font color mismatch"));
        System.out.printf("\nTC-01.02.07: %s", (colorMatch(getElementColor(textLineSeven),"rgba(255, 255, 255, 1)")?"Passed":"Failed : Font color mismatch"));
        System.out.printf("\nTC-01.02.08: %s", (colorMatch(getElementColor(textLineEight),"rgba(255, 255, 255, 1)")?"Passed":"Failed : Font color mismatch"));
        System.out.printf("\nTC-01.02.09: %s", (colorMatch(getElementColor(textLineNine),"rgba(28, 32, 60, 1)")?"Passed":"Failed : Font color mismatch"));
        System.out.printf("\nTC-01.02.10: %s", (colorMatch(getElementColor(textLineTen),"rgba(255, 255, 255, 1)")?"Passed":"Failed : Font color mismatch"));
        System.out.printf("\nTC-01.02.11: %s", (colorMatch(getElementColor(textLineEleven),"rgba(255, 255, 255, 1)")?"Passed":"Failed : Font color mismatch"));
        System.out.printf("\nTC-01.02.12: %s", (colorMatch(getElementColor(textLineTwelfth),"rgba(28, 32, 60, 1)")?"Passed":"Failed : Font color mismatch"));
        System.out.printf("\nTC-01.02.13: %s", (colorMatch(getElementColor(textLineThirteen),"rgba(255, 255, 255, 1)")?"Passed":"Failed : Font color mismatch"));
        System.out.printf("\nTC-01.02.14: %s", (colorMatch(getElementColor(textLineFourteen),"rgba(255, 255, 255, 1)")?"Passed":"Failed : Font color mismatch"));
        System.out.printf("\nTC-01.02.15: %s", (colorMatch(getElementColor(textLineFifteen),"rgba(28, 32, 60, 1)")?"Passed":"Failed : Font color mismatch"));

        click(carouselDotOne); colorList.add(driver.findElement(carouselBackground).getCssValue("background-color"));
        click(carouselDotTwo); colorList.add(driver.findElement(carouselBackground).getCssValue("background-color"));
        click(carouselDotThree); colorList.add(driver.findElement(carouselBackground).getCssValue("background-color"));
        click(carouselDotFour); colorList.add(driver.findElement(carouselBackground).getCssValue("background-color"));
        click(carouselDotFive); colorList.add(driver.findElement(carouselBackground).getCssValue("background-color"));

        int count = 0;
        while(count<colorList.size()) {
            LOOP:
            for(int i = colorList.size() - 1; i >= 0; i--) {
                for(int j = i - 1; j >= 0; j--) {
                    if(colorList.get(i).equals(colorList.get(j))) {System.out.print("\n\nTC-01.03.01: Failed : Backgrounds color should not match"); break LOOP;} }
                count++; }
            System.out.print("\n\nTC-01.03.01: Passed"); }

        driver.quit();
    }
}