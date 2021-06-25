import io.cucumber.java.ru.Пусть;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Cucumber/features",
        glue = "src/test/java/StepDef",
        tags = "@1"
)

public class Test {
    @org.junit.Test
    public static void run(String[] args){
    }
}
