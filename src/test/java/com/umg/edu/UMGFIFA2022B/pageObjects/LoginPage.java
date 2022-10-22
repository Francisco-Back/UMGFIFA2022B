package com.umg.edu.UMGFIFA2022B.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginPage {

    @Autowired
    WebDriver driver;

    @Autowired
    sendInvitation sendInvitation;

    @Autowired
    createLeague createLeague;

    public void writeUsername(String username, String contrasena) throws InterruptedException {
        // ingresamos al login
        driver.findElement(By.linkText("Login")).click();

        // ingresamos las credenciales
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(contrasena);

        driver.findElement(By.className("btn")).click();

        // Enviamos el correo de invitación
        //sendInvitation.writeEmail("mg32834@gmail.com");

        // Creamos la liga
        createLeague.createLeague();
        Thread.sleep(20000);
    }

    public void navigate() {
        driver.get("https://francisco-back.github.io/UMGFIFA2022");
    }
}

