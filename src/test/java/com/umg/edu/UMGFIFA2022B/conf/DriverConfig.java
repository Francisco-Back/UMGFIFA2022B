package com.umg.edu.UMGFIFA2022B.conf;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class DriverConfig {

    @SuppressWarnings("deprecation")
    @Bean
    public WebDriver driver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\marpe\\Desktop\\Tareas\\chromedriver.exe");
        // Creamos el driver
        WebDriver driver = new ChromeDriver();
        // controlamos el tiempo
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        return driver;
    }
}
