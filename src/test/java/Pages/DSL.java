package Pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DSL {
	public WebDriver driver;
	
	public void inicializar() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public void direcionamento() {
		driver.get("https://www.booking.com/");
	}
	
	public void clicar(String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void clicar(By by) {
		driver.findElement(by).click();
	}
	
	public void escrever(String id, String texto) {
		driver.findElement(By.id(id)).sendKeys(texto);
	}
	
	public void escrever(By by, String texto) {
		driver.findElement(by).sendKeys(texto);
	}
	
	public String obterTexto(By by) {
		return driver.findElement(by).getText();
	}
	
	public void trocarJanela() {
		Set<String> janelas = driver.getWindowHandles();

		for (String janela : janelas) {
		     driver.switchTo().window(janela);
		     if(driver.getCurrentUrl().equals("URL DO BROWSER")) {
		        break;
		     }
		}
	}
	public void quit() {
		driver.quit();
	}
}
