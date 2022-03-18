package com.PagsObjet;

import java.io.File;
import org.openqa.selenium.WebDriver;
import com.MapsObjet.MapsObjetDEWidgets;

public class PagsObjetDEWidgets extends MapsObjetDEWidgets

{
	// CREAR CONSTRUCTOR DE LA CLASE
	public PagsObjetDEWidgets(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
	}

	// METODO PRIMERA PRUEBA - INGRESAR A LA PAG WEB DE PRUEBA
	public void selecWidgets(String Ejecutar, String Evidencia, String FirstName, String LastName, String Email,
			String Age, String Salary, String Departament, String Remove, String DelBus, String IngFecha,
			String IngDate, String IngTime, String IngName, File rutaCarpeta) throws Exception {
		try
		{
			// INGRESAR FECHA
			scrollPage(0, 300);
			click(btnRecoger, rutaCarpeta, Evidencia);
			click(btnWidgets, rutaCarpeta, Evidencia);
			click(btnDatePïcker, rutaCarpeta, Evidencia);
			comando(numDateSelect, rutaCarpeta, Evidencia);
			bspace(numDateSelect, rutaCarpeta, Evidencia);
			sendkey(IngFecha, numDateSelect, rutaCarpeta, Evidencia);
			intro(numDateSelect, rutaCarpeta, Evidencia);
			tiempoEspera(1);


			// INFRESAR FECHA Y HORA	
			comando(btnDT, rutaCarpeta, Evidencia);
			bspace(btnDT, rutaCarpeta, Evidencia);
			tiempoEspera(5);		
			sendkey(IngDate+" "+IngTime,btnDT, rutaCarpeta, Evidencia);
			intro(btnDT, rutaCarpeta, Evidencia);
			tiempoEspera(5);	
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