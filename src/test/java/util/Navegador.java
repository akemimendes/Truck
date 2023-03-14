package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Navegador {
    public static WebDriver retornarNavegador() throws IOException, InterruptedException {

        String folderUser = System.getProperty("user.name");
        System.setProperty("webdriver.chrome.driver", "/home/"+folderUser+"/drivers/chromedriver");
        ChromeDriver driver = new ChromeDriver();

        System.out.println("iniciar o abrir");

        driver.get("https://autotruck.org.br/cotacao/");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;


    }
}
