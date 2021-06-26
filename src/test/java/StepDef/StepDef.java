package StepDef;

import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.ByteArrayInputStream;
import java.util.List;

public class StepDef {
    @Пусть("открыт ресурс авито")
    public void openAvito() {
        Hook.driver.get("https://www.avito.ru/");
        screenshot();
    }

    @ParameterType(".*")
    public Categories categories(String category) {
        return Categories.valueOf(category);
    }

    @И("в выпадающем списке категорий выбрана {categories}")
    public void chooseCategory(Categories category){

        WebElement params = Hook.driver.findElement(By.xpath("//option[@value =" + category.getValue() + "]"));
        params.click();
        screenshot();
    }

    @И("в поле поиска введено значение {word}")
    public void printItem(String word){
        Hook.driver.findElement(By.xpath("//input[@data-marker='search-form/suggest']")).sendKeys(word);
        screenshot();
    }

    @Тогда("кликнуть по выпадающему списку региона")
    public void ClickRegion(){
        Hook.driver.findElement(By.xpath("//div[@data-marker='search-form/region']")).click();
        screenshot();
    }

    @Тогда("в поле регион введено значение {word}")
    public void printRegion(String word) throws Exception {
        Thread.sleep(500);
        Hook.driver.findElement(By.xpath("//input[@data-marker='popup-location/region/input']")).click();
        Thread.sleep(500);
        Hook.driver.findElement(By.xpath("//input[@data-marker='popup-location/region/input']")).sendKeys(word);
        Thread.sleep(500);
        Hook.driver.findElement(By.xpath("//li[@data-marker='suggest(0)']")).click();
        screenshot();
    }

    @И("нажата кнопка показать объявления")
    public void clickShow() throws Exception {
        Thread.sleep(500);
        Hook.driver.findElement(By.xpath("//button[@data-marker='popup-location/save-button']")).click();
        Thread.sleep(500);
        screenshot();
    }

    @Тогда("открылась страница результата по запросу {word}")
    public void checkPage(String word){
        if (Hook.driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]")).getText().contains(word))
            System.out.println("Страница открылась");
        screenshot();
    }

    @И("активирован чекбокс С Авито Доставкой")
    public void checkboxActivate(){
        if (!Hook.driver.findElement(By.xpath("//label[@data-marker='delivery-filter']")).getAttribute("class").contains("checked"))
            Hook.driver.findElement(By.xpath("//label[@data-marker='delivery-filter']")).click();
        Hook.driver.findElement(By.xpath("//button[@data-marker='search-filters/submit-button']")).click();
        screenshot();
    }

    @ParameterType(".*")
    public Sorts sorts(String sort) {
        return Sorts.valueOf(sort);

    }

    @И("в выпадающей списке сортировка выбрано значение {sorts}")
    public void sortByHighPrice(Sorts sort){
        Hook.driver.findElement(By.xpath("//div[contains(@class,'sort')]//option[@data-marker='option(" + sort.getValue() + ")']")).click();
        screenshot();
    }

    @И("в консоль выведено значение назвния и цены {int} первых товаров")
    public void printTop(int N){
        List<WebElement> list = Hook.driver.findElements(By.xpath("//div[@data-marker='item']"));
        for (int i = 0; i < N; i++) {
            String name = list.get(i).findElement(By.xpath(".//h3[@itemprop='name']")).getText();
            String price = list.get(i).findElement(By.xpath(".//span[contains(@class,'price-text')]")).getText();
            System.out.println(name + " " + price);
        }
        screenshot();
    }

    public void screenshot() {
        Allure.addAttachment("Скришот", new ByteArrayInputStream(((TakesScreenshot) Hook.driver).getScreenshotAs(OutputType.BYTES)));
    }


}