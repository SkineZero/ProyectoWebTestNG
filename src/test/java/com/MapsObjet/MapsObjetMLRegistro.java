package com.MapsObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.testNG.ClaseBase;

public class MapsObjetMLRegistro extends ClaseBase {

	public MapsObjetMLRegistro(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
	}

	// ELEMENTOS PAGINA INICIAL
	// CREAR TU CUENTA
	protected By crearCuentaML = By.xpath("//nav[@id='nav-header-menu']//a[contains(text(),'Crea tu cuenta')]");
	// VALIDAR DATOS
	protected By validarDatosML = By.xpath("//span[@class='andes-button__content']");
	// BTNVALIDAR EMAIL
	protected By btnvalidarEmailML = By.xpath("//span[@class='andes-button__text']");
	// INGRESAR MAIL 
	protected By txtIngresarEmailML = By.xpath("//input[@name='email']");
	// BTN INGRESAR MAIL
	protected By btnIngresarEMailML = By.xpath("//span[@class='andes-button__content']");
	//BTN IR PG PRINCIPAL
	protected By btnIrPAG = By.xpath("//span[@class='andes-button__content']");
	// NUMERO 1 / DATO FALSO
	protected By num1FML = By.xpath("//body/main[@id='root-app']/div[@id='enter-code']/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/label[1]/div[2]/input[1]");
	// NUMERO 2 / DATO FALSO
	protected By num2FML = By.xpath("//body/main[@id='root-app']/div[@id='enter-code']/div[2]/div[1]/form[1]/div[1]/div[1]/div[2]/label[1]/div[2]/input[1]");	
	// NUMERO 3 / DATO FALSO
	protected By num3FML = By.xpath("//body/main[@id='root-app']/div[@id='enter-code']/div[2]/div[1]/form[1]/div[1]/div[1]/div[3]/label[1]/div[2]/input[1]");
	// NUMERO 4 / DATO FALSO
	protected By num4FML = By.xpath("//body/main[@id='root-app']/div[@id='enter-code']/div[2]/div[1]/form[1]/div[1]/div[1]/div[4]/label[1]/div[2]/input[1]");
	// BTN CONFIMAR
	protected By btnConfiEmailML = By.xpath("//span[contains(text(),'Confirmar código')]");	
	
	
	
	
	
	
	// COSO RARO
	protected By resultadoML2 = By.xpath("//nav[@id='nav-header-menu']//a[contains(text(),'Crea tu cuenta')]");	
}	