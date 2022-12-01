package org.example;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductTest {

    @Test
    public void ProductSearchTest() throws InterruptedException{

        //Ürün adı ile arama
        System.setProperty("webdriver.chrome.driver","C:\\Users\\batuh\\Desktop\\chrome driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com.tr/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        WebElement cookieDestroyer = driver.findElement(By.xpath("//*[@id=\"sp-cc-accept\"]"));
        cookieDestroyer.click();
        WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
        searchBar.click();
        searchBar.sendKeys("iPhone");
        driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();

        WebElement actual_product = driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span"));
        String actual_product_txt = actual_product.getText();
        Assert.assertTrue(actual_product_txt.contains("iPhone"));
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void ProductTestDetails() throws InterruptedException{

        //Teknik bilgiler var mı?
        System.setProperty("webdriver.chrome.driver","C:\\Users\\batuh\\Desktop\\chrome driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com.tr/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        WebElement cookieDestroyer = driver.findElement(By.xpath("//*[@id=\"sp-cc-accept\"]"));
        cookieDestroyer.click();
        WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
        searchBar.click();
        searchBar.sendKeys("iPhone");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
        WebElement product = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div/div[2]/div[2]/h2/a/span"));
        product.click();
        Thread.sleep(1000);

        WebElement teknik_detaylar = driver.findElement(By.xpath("//*[@id=\"content-grid-widget-v1.0\"]/div/div[1]/div/div/div/h2"));
        String teknik_detaylar_txt= teknik_detaylar.getText();
        Assert.assertTrue(teknik_detaylar_txt.contains("Teknik detaylar"));
        Thread.sleep(5000);
        driver.quit();

    }

    @Test
    public void ProductTestAddToCart() throws InterruptedException{

        //Sepete ürün ekleme
        System.setProperty("webdriver.chrome.driver","C:\\Users\\batuh\\Desktop\\chrome driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com.tr/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        WebElement cookieDestroyer = driver.findElement(By.xpath("//*[@id=\"sp-cc-accept\"]"));
        cookieDestroyer.click();
        WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
        searchBar.click();
        searchBar.sendKeys("iPhone");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
        WebElement product = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div/div[2]/div[2]/h2/a/span"));
        product.click();
        Thread.sleep(1000);
        WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]"));
        addToCart.click();
        Thread.sleep(2000);

        WebElement sepet = driver.findElement(By.xpath("//*[@id=\"attachDisplayAddBaseAlert\"]/div/h4"));
        String sepet_txt= sepet.getText();
        Assert.assertTrue(sepet_txt.contains("Sepete Eklendi"));
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void ProductTestCart() throws InterruptedException{

        //Ürün sepett mi (Login)
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


        WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
        searchBar.click();
        searchBar.sendKeys("iPhone");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
        WebElement product = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div/div[2]/div[2]/h2/a/span"));
        product.click();
        Thread.sleep(2000);
        WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]"));
        addToCart.click();
        Thread.sleep(2000);

        WebElement goToCart = driver.findElement(By.xpath("//*[@id=\"attach-sidesheet-view-cart-button\"]/span/input"));
        goToCart.click();
        Thread.sleep(1000);
        WebElement c_product = driver.findElement(By.xpath("//*[@id=\"sc-active-Cde00694b-a3ef-46b5-8e7a-696384a3a7e0\"]/div[4]/div/div[1]/div/div/div[2]/ul/li[1]/span/a/span[1]/span/span[2]"));
        String c_product_txt = c_product.getText();
        Assert.assertTrue(c_product_txt.contains("iPhone"));
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void ProductTestDeleteCart () throws InterruptedException{

        //Sepeti boşaltmak (Login)
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

        WebElement goToCart = driver.findElement(By.xpath("//*[@id=\"nav-cart\"]"));
        goToCart.click();
        WebElement delete = driver.findElement(By.xpath("//*//div[4]/div/div[1]/div/div/div[2]/div[1]/span[2]/span"));
        delete.click();
        Thread.sleep(5000);
        driver.quit();

    }

    @Test
    public void ProductTestStok() throws InterruptedException{

        //Ürünün stok durumu
        System.setProperty("webdriver.chrome.driver","C:\\Users\\batuh\\Desktop\\chrome driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com.tr/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        WebElement cookieDestroyer = driver.findElement(By.xpath("//*[@id=\"sp-cc-accept\"]"));
        cookieDestroyer.click();
        WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
        searchBar.click();
        searchBar.sendKeys("iPhone");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
        WebElement product = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div/div[2]/div[2]/h2/a/span"));
        product.click();
        Thread.sleep(1000);

        WebElement stok = driver.findElement(By.xpath("//*[@id=\"availability\"]/span"));
        String stok_txt= stok.getText();
        Assert.assertTrue(stok_txt.contains("Stokta var."));
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void ProductTestAdres() throws InterruptedException{

        //Adres ekleme (Login)
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

        WebElement hesapButton = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"));
        hesapButton.click();
        Thread.sleep(1000);
        WebElement adresButton = driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div/div[3]/div[1]/a/div/div/div/div[2]/h2"));
        adresButton.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"ya-myab-plus-address-icon\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressFullName\"]")).sendKeys("Batuhan Alatlı");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressPhoneNumber\"]")).sendKeys("5555555555");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressLine1\"]")).sendKeys("adres123");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressLine2\"]")).sendKeys("adres123");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressCity\"]")).sendKeys("İstanbul");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressFormContainer\"]/div[1]/div/div[12]/ul/li")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressStateOrRegion\"]")).sendKeys("Güngören");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressFormContainer\"]/div[1]/div/div[14]/ul/li")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressDistrictOrCounty\"]")).sendKeys("Haznedar Mh.");
        driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressFormContainer\"]/div[1]/div/div[16]/ul/li")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-form-submit-button\"]/span/input")).click();
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void ProductTestKategori() throws InterruptedException{

        //Kategorilerde arama yapar
        System.setProperty("webdriver.chrome.driver","C:\\Users\\batuh\\Desktop\\chrome driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com.tr/");
        driver.manage().window().maximize();
        WebElement cookieDestroyer = driver.findElement(By.xpath("//*[@id=\"sp-cc-accept\"]"));
        cookieDestroyer.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"nav-hamburger-menu\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[11]/a[1]/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/ul/li[2]/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[6]/li[3]/a")).click();
        Thread.sleep(1000);

        WebElement category = driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div[2]/div[1]/div[1]/div/h1"));
        String category_txt = category.getText();
        Assert.assertTrue(category_txt.contains("Bilgisayar"));
        Thread.sleep(5000);
        driver.quit();

    }

    @Test
    public void ProductTestCard() throws InterruptedException{

        //Kart ekleme sayfasına girmek
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

        WebElement hesapButton = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"));
        hesapButton.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div/div[3]/div[2]/a/div/div/div/div[2]/h2")).click();
        Thread.sleep(1000);
        WebElement kartButton = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[2]/div/div/div[2]/div[3]/div/div[1]/div[3]/div/div/div/div[1]/img"));
        kartButton.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div/div/div/div[2]/div/div/span/span[1]/span/input")).click();
        Thread.sleep(2000);

        WebElement card = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[2]/div/div/div[2]/div[2]/span"));
        String card_txt = card.getText();
        Assert.assertTrue(card_txt.contains("Cüzdan"));
        Thread.sleep(5000);
        driver.quit();


    }

}
