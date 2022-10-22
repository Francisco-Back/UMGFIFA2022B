package com.umg.edu.UMGFIFA2022B.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class createLeague {

    By nombreLiga = By.id("NombreLiga");
    By fechaInicio = By.id("Fecha_Inicio");
    By fechaFin = By.id("Fecha_Final");
    By cantEquipos = By.id("Cant_Equipos");
    By button = By.xpath("//button[@class='button']");

    @Autowired
    WebDriver driver;

    public void createLeague() throws InterruptedException {

        // Validamos si se encuentra el boton que nos dirige a la creación de la lifa
        if(driver.findElement(By.xpath("//button[@tabindex='0']")).isDisplayed()){

            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[@tabindex='0']")).click();

            // ingresamos los datos necesarios para crear la liga
            driver.findElement(nombreLiga).sendKeys("yo y los saramambiches");
            Thread.sleep(1000);
            driver.findElement(fechaInicio).sendKeys("12/02/2022");
            Thread.sleep(1000);
            driver.findElement(fechaFin).sendKeys("16/02/2022");
            Thread.sleep(1000);
            driver.findElement(cantEquipos).sendKeys("5");
            Thread.sleep(1000);

            // mandamos la información
            driver.findElement(button).click();
        }
        else
        {
            System.out.println("Page not found 404");
        }

    }
}
