package com.PagsObjet;

import java.io.File;
import org.openqa.selenium.WebDriver;
import com.MapsObjet.MapsObjetMLInicio;

public class PagsObjetMLInicio extends MapsObjetMLInicio

{
	public String url2;
	
	public void setUrl(String url2) {
		this.url2 = url2;
	}

	// CREAR CONSTRUCTOR DE LA CLASE
	public PagsObjetMLInicio(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
	}

	// METODO INICIAL
	public void urlAcceso()

	{
		driver.get(url2);
	}

	// METODO PRIMERA PRUEBA - BUSCAR OBJETO EN MERCADO LIBRE
	public void buscarObjeto(String Evidencia, String Producto, File rutaCarpeta) throws Exception {

		try {
			// ENVIAMOS EL VALOR DE BUSQUEDA AL NAVEGADOR
			tiempoEspera(3);
			click(btnAceptar, rutaCarpeta, Evidencia);
			sendkey(Producto, txtBusquedaML, rutaCarpeta, Evidencia);
			click(btnBuscarML, rutaCarpeta, Evidencia);
			click(selecObjeto, rutaCarpeta, Evidencia);
			tiempoEspera(1);
			}
		catch (Exception e) {
			System.out.println(e);
		}
		//String valor = capturarValorSelenium(resultadoML);
		//return valor;
	}
}
