import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.utils.InsertTodoUtils;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ToDoMvcTest {

    WebDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait;

    @BeforeAll
    static void setupClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void prepareDriver() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver,10);
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(1));

        driver.get("https://todomvc.com/");
    }

    @ParameterizedTest
    @ValueSource(strings = {"backbone","angularjs",
            "emberjs","knockoutjs",
            "dojo","knockback",
            "canjs","polymer/index.html",
            "react","mithril",
            "vue"})
    public void addElements(String technology) throws InterruptedException {

        driver.findElement(By.xpath("//a[@href='examples/"+technology+"']")).click();

        //adding a predifined list of todos
        WebElement addTodoInput;
        if (technology.equals("emberjs"))
            addTodoInput= driver.findElement(By.id("new-todo"));
        else
            addTodoInput= driver.findElement(By.className("new-todo"));
        InsertTodoUtils todoUtils = new InsertTodoUtils(addTodoInput);
        todoUtils.insertDefaultTodos();

        //Selecting the completed Elements
        List<WebElement> toDoElements = driver.findElements(By.className("toggle"));
        toDoElements.get(0).click();
        toDoElements.get(2).click();
        toDoElements.get(5).click();
        Thread.sleep(2000);

        //Comparing the left item counter to 3
        WebElement itemsLeftCount = driver.findElement(By.xpath("//footer/*/span/strong | //footer/span/strong"));

        //On peut utiliser assert
        //assertEquals(itemsLeftCount.getText(),"3");

         wait.until(ExpectedConditions.textToBePresentInElement(itemsLeftCount,"3"));
    }

    @AfterEach
    public void quitDriver() {
        if(driver != null){
            driver.quit();
        }
    }
}
