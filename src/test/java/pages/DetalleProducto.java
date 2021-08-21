package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetalleProducto {
  
  public WebDriver driver;
  
  public DetalleProducto(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }
  
  @FindBy(xpath = "(//span[contains(text(),'$')])[1]")
  WebElement precioProductoLbl;
  
//  @FindBy(xpath = "//*[@class='fb-product-sets__product-code']")
//  WebElement codigoProductoLbl;
  
  @FindBy(xpath = "//button[contains(text(),'AGREGAR AL CARRO')]")
  WebElement agregarALaBolsaBtn;
  
  @FindBy(xpath = "(//*[contains(text(),'Ver Bolsa de Compras')])[2]")
  WebElement verBolsaCompraBtn;
  
  public String obtenerPrecioYContinuar() {
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.visibilityOf(precioProductoLbl));
    String precio = precioProductoLbl.getText();
    System.out.println("Precio1: "+precio);
    agregarALaBolsaBtn.click();
    return precio;
  }
  
  public void clickVerBolsaCompra() {
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.elementToBeClickable(verBolsaCompraBtn));
    verBolsaCompraBtn.click();
  }
  public void dasa() {
    String nombre = precioProductoLbl.getText();
    precioProductoLbl.sendKeys(nombre);
  }
}