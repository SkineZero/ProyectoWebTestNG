package com.PagsObjet;

import java.io.File;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import com.MapsObjet.MapsObjetDEAlerts;

public class PagsObjetDEAlerts extends MapsObjetDEAlerts

{
	// CREAR CONSTRUCTOR DE LA CLASE
	public PagsObjetDEAlerts(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
	}

	// METODO INICIAL
	public void urlAcceso(String url)

	{
		driver.get(url);
	}

	// METODO PRIMERA PRUEBA - INGRESAR A LA PAG WEB DE PRUEBA
	public void selecAlerts(String Evidencia, String FirstName, String LastName, String Email,
			String Age, String Salary, String Departament, String Remove, String DelBus, String IngFecha,
			String IngDate, String IngTime, String IngName, File rutaCarpeta)
			throws Exception {
		try {
			// ENVIAMOS EL VALOR DE BUSQUEDA AL NAVEGADOR - CLICK EN ALERTS
			scrollPage(0, 400);
			click(btnRecoWidget, rutaCarpeta, Evidencia);
			click(btnFrame, rutaCarpeta, Evidencia);
			click(btnAlerts, rutaCarpeta, Evidencia);

			// PRIMER CLICK
			clickAlerts(btnClic1, rutaCarpeta, Evidencia);
			driver.switchTo().alert().dismiss();
			tiempoEspera(1);

			// SEGUNDO CLICK
			clickAlerts(btnClic2, rutaCarpeta, Evidencia);
			tiempoEspera(7);
			driver.switchTo().alert().dismiss();
			tiempoEspera(1);

			// TERCER CLICK - ACEPTAR
			clickAlerts(btnClic3, rutaCarpeta, Evidencia);
			tiempoEspera(1);
			Alert alert = driver.switchTo().alert();
			alert.accept();
			tiempoEspera(1);

			// TERCER CLICK - CANCELAR
			clickAlerts(btnClic3, rutaCarpeta, Evidencia);
			tiempoEspera(1);
			driver.switchTo().alert().dismiss();
			tiempoEspera(1);

			// CUARTO CLICK
			clickAlerts(btnClic4, rutaCarpeta, Evidencia);
			driver.switchTo().alert().sendKeys(IngName);
			alert();
			captureScreen(rutaCarpeta, opcional, Evidencia);
			tiempoEspera(3);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		/*
		String valor = capturarValorSelenium(resultado);
		return valor;
		*/
	}
}
