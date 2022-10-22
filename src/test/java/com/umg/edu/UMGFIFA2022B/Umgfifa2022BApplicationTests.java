package com.umg.edu.UMGFIFA2022B;

import com.umg.edu.UMGFIFA2022B.pageObjects.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Umgfifa2022BApplicationTests {

	@Autowired
	WebDriver driver;

	@Autowired
	LoginPage loginPage;

	@Test
	void navigateHomePage() throws InterruptedException {

		// Enviar Intitación
		//loginPage.navigate();
		//loginPage.writeUsername("aarochem@miumg.edu.gt","Umg123");

	}

}
