package Base;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NuSkinHomePage {
    WebDriver driver;


    // private By sandbDropDown = By.linkText("Skin & Beauty");
    private By sandbDropDown = By.xpath("//div[@class='NsTab__container']//span[contains(text(),'Skin & Beauty')]");
    private By faceCleanse = By.linkText("Facial Moisturizers");
    private By faceMoistPurple = By.xpath("//div[contains(text(),'Nutricentials Bioadaptive Skin Care™ Thirst Fix Hydrating Gel Cream')]");
    // private By faceMoistPurple = By.linkText("01001787");
    private By addQuantitiyFace = By.xpath("//div[@data-testid='quantitySelector']//div[@class='current-selection tall']//div[@class='selected-item']");
  //  private By addCartButton = By.xpath("//button[@class='ns-product-detail__add-to-cart fluid primary-solid']");
    private By addCartButton = By.xpath("//button[contains(text(),'Add to Cart')]");
    private By dropdownArrow = By.xpath("//div[@class=dropdown-area]//div[@class='current-selection tall']//svg[@class='icon arrow-icon']");
    private By cartClick = By.xpath("//div[@class='cart ns-mini-cart']//div[@class='cart-image']");
    private By quatityBox = By.id("qty_01001787");
    private By heyTherePopup = By.xpath("//div[@id='QSIWebResponsiveDialog-Layout1-SI_1I916YXspgqFfRX-headline']");
    private By noThanksButton = By.xpath("//button[@class='QSIWebResponsiveDialog-Layout1-SI_1I916YXspgqFfRX_button QSIWebResponsiveDialog-Layout1-SI_1I916YXspgqFfRX_button-medium QSIWebResponsiveDialog-Layout1-SI_1I916YXspgqFfRX_button-border-radius-none']");
    private By pluSymbol = By.xpath("//i[@class='ns-icon-plus']");


    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
        //  driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.get("https://www.nuskin.com/content/nuskin/en_US/home.html");
        String mainWindow = driver.getWindowHandle();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

    }

    public void pushItemtoCart() {

        WebElement skinDrop = driver.findElement(sandbDropDown);
        Actions act1 = new Actions(driver);
        act1.moveToElement(skinDrop).perform();

        WebElement faceClean = driver.findElement(faceCleanse);
        faceClean.click();

    }

    public void add2CartandTakePic() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

        WebElement facial = driver.findElement(faceMoistPurple);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", facial);
        facial.click();


        //Add 5 to quantity
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        Assert.assertEquals("https://www.nuskin.com/content/nuskin/en_US/products/product.01001787.html",
                "https://www.nuskin.com/content/nuskin/en_US/products/product.01001787.html");

        WebElement dropforFace = driver.findElement(addQuantitiyFace);
        // Select numdrop = new Select(driver.findElement(dropdownArrow));
//        WebElement arrow = driver.findElement(dropdownArrow);
//        arrow.click(); // selects dropdown arrow
//        Select numdrop = new Select(driver.findElement(By.xpath("//div[@class='selected-item']//div")));
//        numdrop.selectByVisibleText("5");

        if (dropforFace.isSelected()) {
            System.out.println("Element is selected");
            dropforFace.click();
        } else {
            System.out.println("can't find element");
        }


//        dropforFace.sendKeys("5");
//        dropforFace.sendKeys(Keys.ENTER);


        /*
        * String mainWinHandle = driver.getWindowHandle(); // Get your main window
String subWinHandle = null;

Set<String> allHandle = driver.getWindowHandles(); // Fetch all handles
Iterator<String> iterator = allHandle.iterator();
while (iterator.hasNext()){
    subWindowHandler = iterator.next();
}
driver.switchTo().window(subWindowHandler); // switch to popup

//Write code to close Ad or skip

driver.switchTo().window(parentWindowHandler);
        *
        *
        *
        * */
      //  WebElement popup = driver.findElement(noThanksButton);

        String mainWindow = driver.getWindowHandle();
        String popUpWindow = null;
        Set<String> allHandles = driver.getWindowHandles();
        Iterator<String> i1 = allHandles.iterator();
//        while (i1.hasNext()) {
//            popUpWindow = i1.next();
//            driver.switchTo().window(popUpWindow);
//            popup.click();
//        }
//
//        driver.switchTo().window(mainWindow);


//        if (popup.isDisplayed()) {
//           // driver.switchTo().window(popUpWindow);
//            popup.click();
//        } else {

           // System.out.println("no popup shown");
            //add to cart
        int timeout = 4;
            WebElement addcarting = driver.findElement(addCartButton);
            if(addcarting.isDisplayed()) {
                WebDriverWait ww = new WebDriverWait(driver,Duration.ofSeconds(4000));
                        ww.until(ExpectedConditions.elementToBeClickable(addcarting));
                addcarting.click();
                System.out.println("Cart button clicked");
            }


            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
            WebElement cart = driver.findElement(cartClick);
            cart.click();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
            Assert.assertEquals("https://www.nuskin.com/static/cart/cart.html#/en_US/cart",
                    "https://www.nuskin.com/static/cart/cart.html#/en_US/cart");


            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            WebElement boxForQuantity = driver.findElement(quatityBox);
//            boxForQuantity.clear();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        WebElement plusSign = driver.findElement(pluSymbol);
        plusSign.click();//2
        plusSign.click();//3
        plusSign.click();//4
        plusSign.click();//5
           // boxForQuantity.sendKeys("5");

            //take screen shot and close browser

            Date currentDate = new Date();
            TakesScreenshot ccScreenShot = (TakesScreenshot) driver;
            File source = ccScreenShot.getScreenshotAs(OutputType.FILE);
            File destination = new File("/Users/nnamdiwilliams/IdeaProjects/Nuskin_demo/src/test/resources/photofile/sceenshot " + currentDate + ".jpg");

            try {
                // FileUtils.copyFile(source,destination); // needs apache commons-io jar
                FileUtils.copyFile(source, destination);
                System.out.println("ScreenShot taken");

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            driver.manage().deleteAllCookies();
            driver.quit();

        }
    }
