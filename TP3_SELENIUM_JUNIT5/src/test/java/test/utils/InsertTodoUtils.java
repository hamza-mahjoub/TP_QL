package test.utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class InsertTodoUtils {

    WebElement element;
    String[] todos = {"Meet a Friend","Buy Meat","Clean the car","Finish HomeWork","Watch a Movie","Finish reading my favorite book"};

    public InsertTodoUtils(WebElement element){
        this.element=element;
    }

    public void insertTodo(String todo) throws InterruptedException {
        this.element.sendKeys(todo);
        this.element.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }

    public void insertDefaultTodos() throws InterruptedException {
        for (String todo : this.todos) {
            this.insertTodo(todo);
        }
    }
}
