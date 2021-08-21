package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import config.ConfiguracionBase;

public class HomePage extends ConfiguracionBase{
  
  public HomePage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }

  @FindBy(xpath = "//*[@id='testId-search-wrapper']/div/button")
  WebElement BtnSku;

  @FindBy(xpath = "//div[contains(@class, 'dy-lb-close')]")
  WebElement equisPop;

  @FindBy(id = "testId-SearchBar-Input")
  WebElement buscarProductoInpt;
  
  public void buscarSku(String sku) {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.visibilityOf(equisPop));
    equisPop.click();
    wait.until(ExpectedConditions.visibilityOf(buscarProductoInpt));
    buscarProductoInpt.sendKeys(sku);
    BtnSku.click();
  } 
}