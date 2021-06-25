import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.avito.ru/");
        List<WebElement> list1 = driver.findElements(By.xpath("//select[@name]/option[contains(@data-marker,'opt')]"));
        for (WebElement webElement : list1) {
            System.out.println(webElement.getText().replaceAll("\s", "_") + "(\"" + webElement.getAttribute("value") + "\"),");
        }
        WebElement params = driver.findElement(By.xpath("//option[@value =99]"));
        params.click();
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

        List<WebElement> list = driver.findElements(By.xpath("//div[@data-marker='item']"));
        System.out.println(list.size());
        for (int i = 0; i < 3; i++) {
            String name = list.get(i).findElement(By.xpath(".//h3[@itemprop='name']")).getText();
            String price = list.get(i).findElement(By.xpath(".//span[contains(@class,'price-text-1Hr')]")).getText();
            System.out.println(name + " " + price);
        }

        driver.close();

    }

}
