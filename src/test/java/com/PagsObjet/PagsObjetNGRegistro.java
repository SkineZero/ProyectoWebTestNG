package com.PagsObjet;

import java.io.File;
import org.openqa.selenium.WebDriver;
import com.MapsObjet.MapsObjetNGRegistro;

public class PagsObjetNGRegistro extends MapsObjetNGRegistro

{
	// CREAR CONSTRUCTOR DE LA CLASE
	public PagsObjetNGRegistro(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
	}

	// METODO INICIAL
	public void urlAcceso(String url)

	{
		driver.get(url);
	}

	// METODO PRIMERA PRUEBA
	public void Registro(String FirstName, String LastName, String Phone,
			String Email, String Addres, String City, String State, String PostalCode,
			String Country, String UserName, String Password, String ConfirmPass, File rutaCarpeta, String Evidencia) throws Exception {

		
			try
			{
		//CONTACT INFORMATION
		tiempoEspera(1);
		sendkey(FirstName, txtingNombre, rutaCarpeta, Evidencia);
		sendkey(LastName, txtingApellido, rutaCarpeta, Evidencia);
		sendkey(Phone, numingTel, rutaCarpeta, Evidencia);
		sendkey(Email, txtCorreo, rutaCarpeta, Evidencia);
		tiempoEspera(1);
		//MAILLING INFORMATION
		sendkey(Addres, txtDireccion, rutaCarpeta, Evidencia);
		sendkey(City, txtCiudad, rutaCarpeta, Evidencia);
		sendkey(State, txtDPTO, rutaCarpeta, Evidencia);
		sendkey(PostalCode, numCodPost, rutaCarpeta, Evidencia);
		click(scrollBarPais, rutaCarpeta, Evidencia);
		sendkey(Country, scrollBarPais, rutaCarpeta, Evidencia);
		tiempoEspera(1);
		//USER INFORMATION
		sendkey(UserName, txtUsuario, rutaCarpeta, Evidencia);
		sendkey(Password, numPRIVATE1, rutaCarpeta, Evidencia);
		sendkey(ConfirmPass, numPRIVATE2, rutaCarpeta, Evidencia);
		tiempoEspera(1);
		click(btnSend, rutaCarpeta, Evidencia);
		tiempoEspera(1);
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		//String valor = capturarValorSelenium(resultado);
		//return valor;
	}
}