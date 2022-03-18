package com.MapsObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.testNG.ClaseBase;

public class MapsObjetDEInicio extends ClaseBase {

	// CONSTRUCTOR DE LA CLASE
	public MapsObjetDEInicio(WebDriver driver)

	{
		super(driver);
	}

	// ELEMENTOS PAGINA INICIAL - CLICK ELEMENTS
	protected By btnelements = By.xpath("//h5[normalize-space()='Elements']");

}
