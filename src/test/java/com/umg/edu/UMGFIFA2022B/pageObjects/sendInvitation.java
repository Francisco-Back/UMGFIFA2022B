package com.umg.edu.UMGFIFA2022B.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class sendInvitation {

    @Autowired
    WebDriver driver;

    public void writeEmail(String email){
        // Encontramos la dirección del boton
        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm']")).click();

        // ingresamos la información
        driver.findElement(By.name("correo")).sendKeys(email);

        // enviamos la invitación
        driver.findElement(By.xpath("//button[@class='btn btn-primary button1']")).click();
    }
}

