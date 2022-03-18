package com.PagsObjet;

import java.io.File;
import org.openqa.selenium.WebDriver;
import com.MapsObjet.MapsObjetMLRegistro;

public class PagsObjetMLRegistro extends MapsObjetMLRegistro

{
	// CREAR CONSTRUCTOR DE LA CLASE
	public PagsObjetMLRegistro(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
	}

	// METODO INICIAL
	public void urlAcceso(String url)

	{
		driver.get(url);
	}

	public void crearCuenta2(String Evidencia, String Correo, String Validacion1, String Validacion2, String Validacion3,
			String Validacion4, File rutaCarpeta) throws Exception {
		try {
			click(crearCuentaML, rutaCarpeta, Evidencia);
			click(validarDatosML, rutaCarpeta, Evidencia);
			click(btnvalidarEmailML, rutaCarpeta, Evidencia);
			tiempoEspera(2);
			sendkey(Correo, txtIngresarEmailML, rutaCarpeta, Evidencia);
			click(btnIngresarEMailML, rutaCarpeta, Evidencia);
			click(btnIrPAG, rutaCarpeta, Evidencia);
			tiempoEspera(3);
			}
		catch (Exception e) {
			System.out.println(e);
		}
		/*
		String valor = capturarValorSelenium(resultadoML2);
		return valor;
		*/
	}

}
