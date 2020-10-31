package atividadeRepositorio;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TesteCorreios {

	WebDriver driver;

	@Given("^abrir site dos correios$")
	public void abrir_site_dos_correios() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.correios.com.br");
	}

	@When("^digitar o cep$")
	public void digitar_o_cep() throws Throwable {
		Thread.sleep(5000);
		driver.findElement(By.id("acesso-busca")).sendKeys("04141-001");
	}

	@When("^clicar em buscar$")
	public void clicar_em_buscar() throws Throwable {
		driver.findElement(By.id("acesso-busca")).submit();

	}

	@Then("^validar endereco$")
	public void validar_endere_o() throws Throwable {
		ArrayList<String> abas = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(abas.get(1));
		Thread.sleep(6000);
		String msg = driver.findElement(By.xpath("//*[@id=\"resultado-DNEC\"]/tbody/tr/td[1]")).getText();
		assertEquals(msg, "Rua Guiratinga - de 611/612 ao fim");
	}

}
