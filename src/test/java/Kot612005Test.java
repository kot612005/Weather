import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Kot612005Test {

    @Test
    public void testH2TagText_WhenSearchingCityCountry() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "http://openweathermap.org/";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";

        driver.get(url);
        Thread.sleep(5000);


        WebElement searchCityField = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//input[@placeholder = 'Search city']"));
        searchCityField.click();
        searchCityField.sendKeys(cityName);

        WebElement searchButton = driver.findElement(
                By.xpath("//div [@id = 'weather-widget']//button[@type = 'submit']")
        );
        searchButton.click();

        Thread.sleep(1000);

        WebElement parisFrChoiceInDropdownMenu = driver.findElement(
                By.xpath("//ul[@class = 'search-dropdown-menu']/li/span[text() = 'Paris, FR ']")
        );
        parisFrChoiceInDropdownMenu.click();

        WebElement h2CityCountryHeader = driver.findElement(
                By.xpath("//div [@id = 'weather-widget']//h2")
        );

        Thread.sleep(5000);

        String actualResult = h2CityCountryHeader.getText();

        Assert.assertEquals(actualResult, expectedResult);


        driver.quit();

    }

    // TC_11_01
//1.  Открыть базовую ссылку
//2.  Нажать на пункт меню Guide
//3.  Подтвердить, что вы перешли на страницу со ссылкой https://openweathermap.org/guide и
// что title этой страницы OpenWeatherMap API guide - OpenWeatherMap
//
    @Test
    public void testOpenAndClickToGuid() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "http://openweathermap.org/";
        String buttonGuide = "Guide";
        String expectedResult1 = "OpenWeatherMap API guide - OpenWeatherMap";
        String expectedResult2 = "https://openweathermap.org/guide";

        driver.get(url);
        Thread.sleep(5000);

        WebElement menuGuide = driver.findElement(
                By.xpath("//div[@id ='desktop-menu']// a[@href = '/guide']"));

        menuGuide.click();

        driver.getTitle();
        Thread.sleep(5000);


        String actualResult1 = driver.getTitle();
        String actualResult2 = driver.getCurrentUrl();

        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);

        driver.quit();

    }

// TC_11_02
//1.  Открыть базовую ссылку
//2.  Нажать на единицы измерения
//    3.  Подтвердить, что температура для города показана в Фарингейтах

    @Test
    public void testOpenAndClickToUnit() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "http://openweathermap.org/";
        String expectedResult = "°F";
        String fTempSymbol = "°F";

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement buttonUnit = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//div[text() = 'Imperial: °F, mph']"));
        buttonUnit.click();

        Thread.sleep(5000);

        WebElement tempF = driver.findElement(By.xpath("//div[@class='current-temp']/span"));

        String tempInF = tempF.getText();

        String actualResult = tempInF.substring((tempInF.length() - 2));

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();

    }


//    TC_11_03
//1.  Открыть базовую ссылку
//2. Подтвердить, что внизу страницы есть панель с текстом
// “We use cookies which are essential for the site to work.
// We also use non-essential cookies to help us improve our services.
// Any data collected is anonymised. You can allow all cookies or manage them individually.”
//3. Подтвердить, что на панели внизу страницы есть 2 кнопки “Allow all” и “Manage cookies”


    @Test
    public void testTextConfirmAndButtons() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "http://openweathermap.org/";
        String expectedResult = "We use cookies which are essential for the site to work. We also use non-essential cookies to help us improve our services. Any data collected is anonymised. You can allow all cookies or manage them individually.";
        String expectedResult1 = "Allow all";
        String expectedResult2 = "Manage cookies";


        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);


        WebElement panelWithText = driver.findElement(
                By.xpath("//div[@id='stick-footer-panel']//p[@class ='stick-footer-panel__description']"));

        String actualResult = panelWithText.getText();

        Assert.assertEquals(actualResult, expectedResult);

        Thread.sleep(5000);

        WebElement allowAllButton = driver.findElement(
                By.xpath("//div[@id='stick-footer-panel']//button[text() = 'Allow all']"));

        String actualResult1 = allowAllButton.getText();

        Assert.assertEquals(actualResult1, expectedResult1);

        WebElement manageCookiesButton = driver.findElement(
                By.xpath("//div[@id='stick-footer-panel']//a[text() = ' Manage cookies ']"));

        String actualResult2 = manageCookiesButton.getText();

        Assert.assertEquals(actualResult2, expectedResult2);


        driver.quit();

    }

//    TC_11_04
//1.  Открыть базовую ссылку
//2.  Подтвердить, что в меню Support есть 3 подменю с названиями “FAQ”, “How to start” и “Ask a question”

    @Test
    public void testSupportMenuThreeItems() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "http://openweathermap.org/";
        String expectedResult = "FAQ";
        String expectedResult1 = "How to start";
        String expectedResult2 = "Ask a question";

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement menuSupport = driver.findElement(
                By.xpath("//div[@id='support-dropdown']"));

        menuSupport.click();
        Thread.sleep(500);

//        Assert.assertEquals(driver.findElements(
//                By.xpath("ul[@id = 'support-dropdown-menu']/li")).size(),3);



        WebElement textFACIsPresents = driver.findElement(
                By.xpath("//ul[@id='support-dropdown-menu']//a[@href = '/faq']"));
        String actualResult = textFACIsPresents.getText();
        Assert.assertEquals(actualResult, expectedResult);

        Thread.sleep(500);

        WebElement textHowToStart = driver.findElement(
                By.xpath("//ul[@id='support-dropdown-menu']//a[@href = '/appid']"));
        String actualResult1 = textHowToStart.getText();
        Assert.assertEquals(actualResult1, expectedResult1);

        Thread.sleep(500);

        WebElement textAskAQuestion = driver.findElement(
                By.xpath("//ul[@id='support-dropdown-menu']//a[@href = 'https://home.openweathermap.org/questions']"));
        String actualResult2 = textAskAQuestion.getText();
        Assert.assertEquals(actualResult2, expectedResult2);




        driver.quit();

    }

//
//    TC_11_05
//1. Открыть базовую ссылку
//2. Нажать пункт меню Support → Ask a question
//3. Заполнить поля Email, Subject, Message
//4. Не подтвердив CAPTCHA, нажать кнопку Submit
//5. Подтвердить, что пользователю будет показана ошибка “reCAPTCHA verification failed, please try again.”
//


    @Test
    public void testFillEmailSubjectMessageInMenuSupportAskAQuestion() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "http://openweathermap.org/";
        String expectedResult = "reCAPTCHA verification failed, please try again.";
        String email = "google@mail.com";
        String message = "Test message";

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement menuSupport = driver.findElement(
                By.xpath("//div[@id='support-dropdown']"));

        menuSupport.click();
        Thread.sleep(5000);
        WebElement textAskAQuestion = driver.findElement(
                By.xpath("//ul[@id='support-dropdown-menu']//a[@href = 'https://home.openweathermap.org/questions']"));


        textAskAQuestion.click();

        Thread.sleep(5000);


        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        WebElement emailField = driver.findElement(By.xpath(""));

        emailField.sendKeys(email);

        WebElement selectField = driver.findElement(By.xpath(""));

        selectField.click();

        WebElement selectFieldChoice = driver.findElement(By.xpath(""));

        selectFieldChoice.click();

        WebElement messageField = driver.findElement(By.xpath(""));
        messageField.sendKeys(message);


        WebElement submitButton = driver.findElement(By.xpath(""));

        submitButton.click();
        Thread.sleep(5000);

        WebElement reCaptchaText = driver.findElement(By.xpath(""));

        String actualResult = reCaptchaText.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();



    }




}
