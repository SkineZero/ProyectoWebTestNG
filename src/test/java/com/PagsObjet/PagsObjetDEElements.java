package com.PagsObjet;

import java.io.File;
import org.openqa.selenium.WebDriver;
import com.MapsObjet.MapsObjetDEElements;

public class PagsObjetDEElements extends MapsObjetDEElements

{
	// CREAR CONSTRUCTOR DE LA CLASE
	public PagsObjetDEElements(WebDriver driver)

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
	public void selecElements(String Evidencia, String FirstName, String LastName, String Email,
			String Age, String Salary, String Departament, String Remove, String DelBus, String IngFecha,
			String IngDate, String IngTime, String IngName, File rutaCarpeta) throws Exception {
		try	
		{
			// ENVIAMOS EL VALOR DE BUSQUEDA AL NAVEGADOR - ELEMENTS
			click(btnElements, rutaCarpeta, Evidencia);
			scrollPage(0, 300);
			click(btnWebTables, rutaCarpeta, Evidencia);
			
			//AGREGA UN NUEVO REGISTRO
			click(btnAdd, rutaCarpeta, Evidencia);
			sendkey(FirstName, txtFirstName, rutaCarpeta, Evidencia);
			sendkey(LastName, txtLastName,	rutaCarpeta, Evidencia);
			sendkey(Email, txtEmail, rutaCarpeta, Evidencia);
			sendkey(Age, numAge, rutaCarpeta, Evidencia);
			sendkey(Salary, numSalary, rutaCarpeta, Evidencia);
			sendkey(Departament, txtDepartament, rutaCarpeta, Evidencia);
			click(btnSubmit, rutaCarpeta, Evidencia);

			// ELIMINAR CUALQUIER REGISTRO
			sendkey(Remove, txtSearch, rutaCarpeta, Evidencia); 
			tiempoEspera(1);
			click(btnDeleted, rutaCarpeta, Evidencia);
			
			// BORRA EL TEXTO ESCRITO Y COLOCA UN DATO PARA VERIFICAR QUIENES SE HAN ELIMINADO
			borrar(txtSearch, rutaCarpeta, Evidencia);
			sendkey(DelBus, txtSearch, rutaCarpeta, Evidencia); 
			tiempoEspera(1);
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
