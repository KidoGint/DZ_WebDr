import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.http.WebSocket;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main{
    public static void main(String[] args) throws Exception{
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.avito.ru/");
        WebElement params = driver.findElement(By.xpath("//option[@value =99]"));
        params.click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(3,TimeUnit.SECONDS);
            driver.findElement(By.xpath("//input[@data-marker='search-form/suggest']")).sendKeys("Принтер");
        driver.findElement(By.xpath("//div[@data-marker='search-form/region']")).click();
        driver.findElement(By.xpath("//input[@data-marker='popup-location/region/input']")).click();
        driver.findElement(By.xpath("//input[@data-marker='popup-location/region/input']")).sendKeys("Владивосток");
        Thread.sleep(500);
        driver.findElement(By.xpath("//li[@data-marker='suggest(0)']")).click();
            driver.findElement(By.xpath("//button[@data-marker='popup-location/save-button']")).click();
        if (!driver.findElement(By.xpath("//label[@data-marker='delivery-filter']")).getAttribute("class").contains("checked"))
            driver.findElement(By.xpath("//label[@data-marker='delivery-filter']")).click();
        driver.findElement(By.xpath("//button[@data-marker='search-filters/submit-button']")).click();
        driver.findElement(By.xpath("//option[text()='Дороже']")).click();
        System.out.println(driver.findElement(By.xpath("//div[@data-marker='item']//h3[@itemprop='name']")).getText());
        System.out.println(driver.findElement(By.xpath("//div[@data-marker='item']//span[contains(@class,'price-text-1Hr')]")).getText());
        System.out.println(driver.findElement(By.xpath("//div[@data-marker='item']/following::div[1]//h3[@itemprop='name']")).getText());
        System.out.println(driver.findElement(By.xpath("//div[@data-marker='item']/following::div[1]//span[contains(@class,'price-text-1Hr')]")).getText());

        System.out.println(driver.findElement(By.xpath("//div[3][@data-marker='item']/following::div[1]//h3[@itemprop='name']")).getText());
        System.out.println(driver.findElement(By.xpath("//div[3][@data-marker='item']/following::div[1]//span[contains(@class,'price-text-1Hr')]")).getText());
        driver.close();
    }

}
