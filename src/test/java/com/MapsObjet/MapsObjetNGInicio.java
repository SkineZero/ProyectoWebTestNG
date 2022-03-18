package com.MapsObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.testNG.ClaseBase;



public class MapsObjetNGInicio extends ClaseBase

{
	// CONSTRUCTOR DE LA CLASE
	public MapsObjetNGInicio(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
	}
	// CLICK REGISTRAR
	protected By btnRegistrar = By.xpath("//a[normalize-space()='REGISTER']");
	// NO SE PARA QUE SIRVE
	protected By resultado =By.xpath("//font[contains(text(),'Contact')]");
	
}
