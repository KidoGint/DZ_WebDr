package StepDef;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class hook {
    public static WebDriver driver;
    @Before
    public void before(){
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @After
    public void after(){
        driver.close();
    }
}
