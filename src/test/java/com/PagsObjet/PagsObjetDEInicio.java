package com.PagsObjet;

import java.io.File;
import org.openqa.selenium.WebDriver;
import com.MapsObjet.MapsObjetDEInicio;

public class PagsObjetDEInicio extends MapsObjetDEInicio

{
	public String url3;
	
	public void setUrl(String url3) 
	{
		this.url3 = url3;
	}

	// CREAR CONSTRUCTOR DE LA CLASE
	public PagsObjetDEInicio(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
	}

	// METODO INICIAL
	public void urlAcceso()

	{
		driver.get(url3);
	}
	// METODO PRIMERA PRUEBA - INGRESAR A LA PAG WEB DE PRUEBA
	public void pagDemon(File rutaCarpeta) throws Exception {
		
	try {
			// ENVIAMOS EL VALOR DE BUSQUEDA AL NAVEGADOR - BAJA EL NAVEGADOR
			scrollPage(0, 300);
			tiempoEspera(3);
			}
	catch (Exception e) 
	{
	System.out.println(e);
	}
	/*
	String valor = capturarValorSelenium(resultado);
	return valor;
	*/
	}
}