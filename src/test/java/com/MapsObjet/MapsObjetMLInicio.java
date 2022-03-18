package com.MapsObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.testNG.ClaseBase;

public class MapsObjetMLInicio extends ClaseBase {

	// CONSTRUCTOR DE LA CLASE
	public MapsObjetMLInicio(WebDriver driver)

	{
		super(driver);
	}
	// ACEPTAR COOKIES	
	protected By btnAceptar = By.xpath("//button[normalize-space()='Entendido']");
	// RUTA BUSCADOR
	protected By txtBusquedaML = By.cssSelector("#cb1-edit");
	// RUTA BOTÓN LUPA
	protected By btnBuscarML = By.xpath("//div[@aria-label='Buscar']");
	//SELECCIONAR ARENA GATO
	protected By selecObjeto = By.xpath("//h2[contains(text(),'Arena Para Gatos Eco Cat 7.7 Kg')]");
	// NO SE PARA QUE SIRVE
	protected By resultadoML =By.xpath("//h1[normalize-space()='Arena ecocat']");
}