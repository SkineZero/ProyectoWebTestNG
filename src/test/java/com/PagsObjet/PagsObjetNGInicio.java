package com.PagsObjet;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import com.MapsObjet.MapsObjetNGInicio;

public class PagsObjetNGInicio extends MapsObjetNGInicio

{
	public String url1;

	// CREAR CONSTRUCTOR DE LA CLASE
	public PagsObjetNGInicio(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
	}
	
	public void setUrl(String url1) {
		this.url1 = url1;
	}

	// METODO INICIAL
	public void urlAcceso()

	{
		driver.get(url1);
	}

	// METODO PRIMERA PRUEBA
	public void IngresoBusqueda(String FirstName, File rutaCarpeta, String Evidencia) throws Exception 
	{
		try {
			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			tiempoEspera(3);
			click(btnRegistrar, rutaCarpeta, Evidencia);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		//String valor = capturarValorSelenium(resultado);
		//return valor;
	}
	

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}