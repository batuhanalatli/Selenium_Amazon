package org.example;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest  {


    @Test
    public void loginPageTest() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\batuh\\Desktop\\chrome driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com.tr/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        WebElement girisButon = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]"));
        girisButon.click();
        Thread.sleep(1000);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.amazon.com.tr/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com.tr%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=trflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&";
        Assert.assertEquals(actualUrl,expectedUrl);
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void loginTest1() throws InterruptedException{

        //E-posta ve şifre doğru
        System.setProperty("webdriver.chrome.driver","C:\\Users\\batuh\\Desktop\\chrome driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com.tr/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com.tr%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=trflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        WebElement userName = driver.findElement(By.xpath("//*[@id=\"ap_email\"]"));
        userName.click();
        userName.sendKeys("test.case.deneme@gmail.com");
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"continue\"]"));
        Thread.sleep(1000);
        loginButton.click();
        WebElement password = driver.findElement(By.xpath("//*[@id=\"ap_password\"]"));
        password.click();
        password.sendKeys("Testcase1");
        Thread.sleep(1000);
        WebElement loginButton2 = driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]"));
        loginButton2.click();
        Thread.sleep(1000);
        WebElement actual_name = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]"));
        String actualtext = actual_name.getText();
        Assert.assertTrue(actualtext.contentEquals("Batuhan"));
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void loginTest2() throws InterruptedException{

        //E-posta yanlış şifre doğru
        System.setProperty("webdriver.chrome.driver","C:\\Users\\batuh\\Desktop\\chrome driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com.tr/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com.tr%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=trflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        WebElement userName = driver.findElement(By.xpath("//*[@id=\"ap_email\"]"));
        userName.click();
        userName.sendKeys("test.case.yanlis@gmail.com");
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"continue\"]"));
        Thread.sleep(1000);
        loginButton.click();

        WebElement actual_error = driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span"));
        String actual_error_txt = actual_error.getText();
        Assert.assertTrue(actual_error_txt.contains("Bu e-posta adresiyle bir hesap bulamıyoruz"));
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void loginTest3() throws InterruptedException{

        //E-posta doğru şifre yanlış
        System.setProperty("webdriver.chrome.driver","C:\\Users\\batuh\\Desktop\\chrome driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com.tr/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com.tr%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=trflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        WebElement userName = driver.findElement(By.xpath("//*[@id=\"ap_email\"]"));
        userName.click();
        userName.sendKeys("test.case.deneme@gmail.com");
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"continue\"]"));
        Thread.sleep(1000);
        loginButton.click();
        WebElement password = driver.findElement(By.xpath("//*[@id=\"ap_password\"]"));
        password.click();
        password.sendKeys("TestcaseYanlis");
        Thread.sleep(1000);
        WebElement loginButton2 = driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]"));
        loginButton2.click();
        Thread.sleep(1000);

        WebElement actual_error = driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span"));
        String actual_error_txt = actual_error.getText();
        Assert.assertTrue(actual_error_txt.contains("Şifreniz yanlış"));
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void loginTest4() throws InterruptedException{

        //Alana değer girilmeden formun gönderilmeye çalışılması
        System.setProperty("webdriver.chrome.driver","C:\\Users\\batuh\\Desktop\\chrome driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com.tr/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com.tr%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=trflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
        driver.manage().window().maximize();
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"continue\"]"));
        Thread.sleep(1000);
        loginButton.click();

        WebElement actual_error = driver.findElement(By.xpath("//*[@id=\"auth-email-missing-alert\"]/div/div"));
        String actual_error_txt = actual_error.getText();
        Assert.assertTrue(actual_error_txt.contains("E-posta adresinizi veya cep telefonu numaranızı girin"));
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void logOutTest() throws InterruptedException{

        //Çıkış yapmak
        System.setProperty("webdriver.chrome.driver","C:\\Users\\batuh\\Desktop\\chrome driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com.tr/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com.tr%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=trflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        WebElement userName = driver.findElement(By.xpath("//*[@id=\"ap_email\"]"));
        userName.click();
        userName.sendKeys("test.case.deneme@gmail.com");
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"continue\"]"));
        Thread.sleep(1000);
        loginButton.click();
        WebElement password = driver.findElement(By.xpath("//*[@id=\"ap_password\"]"));
        password.click();
        password.sendKeys("Testcase1");
        Thread.sleep(1000);
        WebElement loginButton2 = driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]"));
        loginButton2.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"nav-hamburger-menu\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[16]/a")).click();
        Thread.sleep(5000);
        driver.quit();


    }


}
