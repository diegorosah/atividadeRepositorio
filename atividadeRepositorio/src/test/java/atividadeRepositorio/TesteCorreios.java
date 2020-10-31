package atividadeRepositorio;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

	@When("^clicar em buscar$")
	public void clicar_em_buscar() throws Throwable {
		driver.findElement(By.id("acesso-busca")).submit();

	}

	@When("^digitar o \"([^\"]*)\"$")
	public void digitar_o(String arg1) throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.id("acesso-busca")).sendKeys(arg1);
	}

	@Then("^validar end\"([^\"]*)\"$")
	public void validar_end(String arg1) throws Throwable {
		ArrayList<String> abas = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(abas.get(1));
		Thread.sleep(6000);
		String msg = driver.findElement(By.xpath("//*[@id=\"resultado-DNEC\"]/tbody/tr/td[1]")).getText();
		assertEquals(msg, arg1);
		driver.quit();
	}

	@Then("^validar cep\"([^\"]*)\"$")
	public void validar_cep(String arg1) throws Throwable {
		ArrayList<String> abas = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(abas.get(1));
		Thread.sleep(6000);
		String msg = driver.findElement(By.xpath("//*[@id=\"resultado-DNEC\"]/tbody/tr[1]/td[4]")).getText();
		assertEquals(msg, arg1);
		driver.quit();
	}
}
