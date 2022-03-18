package com.MapsObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.testNG.ClaseBase;

public class MapsObjetNGRegistro extends ClaseBase

{
	// CONSTRUCTOR DE LA CLASE
	public MapsObjetNGRegistro(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
	}
	// MAPEO DE DATOS DE CONTACT INFORMATION
	protected By txtingNombre = By.xpath("//input[@name='firstName']");
	protected By txtingApellido = By.xpath("//input[@name='lastName']");
	protected By numingTel = By.xpath("(//input[@name='phone'])[1]");
	protected By txtCorreo = By.cssSelector("#userName");

	// MAPEO DE DATOS DE MAILING INFORMATION
	protected By txtDireccion = By.xpath("//input[@name='address1']");
	protected By txtCiudad = By.xpath("//input[@name='city']");
	protected By txtDPTO = By.xpath("//input[@name='state']");
	protected By numCodPost = By.xpath("//input[@name='postalCode']");
	protected By scrollBarPais = By.xpath("//select[@name='country']");

	// MAPEO DE DATGOS DE USER INFORMATION
	protected By txtUsuario = By.xpath("(//input[@id='email'])[1]");
	protected By numPRIVATE1 = By.xpath("//input[@name='password']");
	protected By numPRIVATE2 = By.xpath("//input[@name='confirmPassword']");
	protected By btnSend = By.xpath("//input[@name='submit']");
	
	// NO SE PA QUE SIRVE
	protected By resultado =By.xpath("//b[normalize-space()='Note: Your user name is SkineZero.']");
	
}