package com.testNG;

import org.testng.annotations.Test;
import com.PagsObjet.PagsObjetDEAlerts;
import com.PagsObjet.PagsObjetDEElements;
import com.PagsObjet.PagsObjetDEInicio;
import com.PagsObjet.PagsObjetDEWidgets;
import com.PagsObjet.PagsObjetNGInicio;
import com.PagsObjet.PagsObjetMLRegistro;
import com.PagsObjet.PagsObjetMLInicio;
import com.PagsObjet.PagsObjetNGRegistro;
import com.Utilidades.ExcelUtilidades;
import com.Utilidades.GenerarReportePdf;
import com.Utilidades.MyScreenRecorder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.io.File;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class EjemploTestNG {

	private WebDriver driver;

	PagsObjetNGInicio pagsObjetNGInicio;
	PagsObjetNGRegistro pagsObjetRegistro;
	PagsObjetDEInicio pagsObjetDEInicio;
	PagsObjetDEElements elements;
	PagsObjetDEWidgets widgets;
	PagsObjetDEAlerts alerts;
	PagsObjetMLInicio pagsObjetMLInicio;
	PagsObjetMLRegistro merLibre;
	File rutaCarpeta = null;
	ClaseBase claseBase;
	String valor;
	GenerarReportePdf generarReportePdf;

	@BeforeClass
	@Parameters({ "url1", "url2", "url3", "rutaImagenReporte","rutaOutput"})
	public void beforeClass(
			@Optional("default") String url1, 
			@Optional("default") String url2,	
			@Optional("default") String url3, 
			@Optional("default") String rutaImagenReporte, 
			@Optional("default") String rutaOutput) 
	{
		
		// LLAMA EL DRIVER
		driver = ClaseBase.chromeDriverConection();
		
		// INSTANCIAR LA CLASE PAGEOBJET
		pagsObjetNGInicio = new PagsObjetNGInicio(driver);
		pagsObjetRegistro = new PagsObjetNGRegistro(driver);
		pagsObjetMLInicio = new PagsObjetMLInicio(driver);
		merLibre = new PagsObjetMLRegistro(driver);
		pagsObjetDEInicio = new PagsObjetDEInicio(driver);
		elements = new PagsObjetDEElements(driver);
		widgets = new PagsObjetDEWidgets(driver);
		alerts = new PagsObjetDEAlerts(driver);
		generarReportePdf = new GenerarReportePdf();
		claseBase = new ClaseBase(driver);
		
		// SETTTIAR LAS CLASES
		pagsObjetNGInicio.setUrl(url1);
		pagsObjetMLInicio.setUrl(url2);
		pagsObjetDEInicio.setUrl(url3);
		generarReportePdf.setRutaImagen(rutaImagenReporte);
		claseBase.setrutaOutput(rutaOutput);
	}

	@Test(dataProvider = "IngresoGuru", description = "INGRESO A GURU")
	public void Caso1_Ingreso_Guru(String Ejecutar, String Evidencia, String FirstName, String LastName, String Phone,
			String Email, String Addres, String City, String State, String PostalCode, String Country, String UserName,
			String Password, String ConfirmPass) throws Exception 
	{
		if (Ejecutar.equals("SI")) 
		{
			// OBTENER EL NOMBRE DEL MÉTODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			
			// INGRESAMOS A PAGINA - URL
			pagsObjetNGInicio.urlAcceso();
			
			if (Evidencia.contains("SI"))
			
			{
				// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
				rutaCarpeta = claseBase.crearCarpeta(nomTest);
				
				// INICIO GRABACIÓN
				MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
				
				// INICIA CREACIÓN DE REPORTE PDF
				generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
				
				// INICIO
				pagsObjetNGInicio.IngresoBusqueda(FirstName, rutaCarpeta, Evidencia);
				
				// REGISTRO
				pagsObjetRegistro.Registro(FirstName, LastName, Phone, Email, Addres, City, State, PostalCode, Country,
						UserName, Password, ConfirmPass, rutaCarpeta, Evidencia);
				
				// FIN GRABACIÓN
				MyScreenRecorder.stopRecording();
				
				// FINALIZA CREACIÓN DE REPORTE PDF
				generarReportePdf.cerrarPlantilla();
				
			} else {
				// INICIO
				pagsObjetNGInicio.IngresoBusqueda(FirstName, rutaCarpeta, Evidencia);
				// REGISTRO
				pagsObjetRegistro.Registro(FirstName, LastName, Phone, Email, Addres, City, State, PostalCode, Country,
						UserName, Password, ConfirmPass, rutaCarpeta, Evidencia);
			}
			//assert valor.contains(UserName);
		}
	}

	@Test(dataProvider = "IngresoML", description = "INGRESO MERCADO LIBRE")
	public void Caso2_Ingreso_MerLibre(String Ejecutar, String Evidencia, String Producto, String Correo, String Validacion1,
			String Validacion2, String Validacion3, String Validacion4) throws Exception {
		if (Ejecutar.equals("SI")) 
		{
			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			
			// INGRESAR A LA PAG
			pagsObjetMLInicio.urlAcceso();
			
			if (Evidencia.contains("SI")) 
			{
				// CREAR CARPETA
				rutaCarpeta = claseBase.crearCarpeta(nomTest);

				// INICIO GRABACIÓN
				MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
				
				// INICIA CREACIÓN DE REPORTE PDF
				generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
				
				// BUSCAR DENTRO DE MERCADO LIBRE
				pagsObjetMLInicio.buscarObjeto(Evidencia, Producto, rutaCarpeta);
				merLibre.crearCuenta2(Evidencia, Correo, Validacion1, Validacion2, Validacion3, Validacion4, rutaCarpeta);
				
				// FIN GRABACIÓN
				MyScreenRecorder.stopRecording();
				
				// FINALIZA CREACIÓN DE REPORTE PDF
				generarReportePdf.cerrarPlantilla();
				
			} 
			else 
			{
				// BUSCAR DENTRO DE MERCADO LIBRE
				pagsObjetMLInicio.buscarObjeto(Evidencia, Producto, rutaCarpeta);
				
				// CREAR CUENTA
				merLibre.crearCuenta2(Evidencia, Correo, Validacion1, Validacion2, Validacion3, Validacion4, rutaCarpeta);
			}
			//assert valor.contains(Producto);
		}
	}

	@Test(dataProvider = "IgresoToolsQA", description = "INGRESO TOOLSQA")
	public void Caso3_Ingreso_ToolsQA(String Ejecutar, String Evidencia, String FirstName, String LastName, String Email,
			String Age, String Salary, String Departament, String Remove, String DelBus, String IngFecha,
			String IngDate, String IngTime, String IngName) throws Exception 
	{
		if (Ejecutar.equals("SI")) 
		{
			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			
			// INGRESAR A LA PAG
			pagsObjetDEInicio.urlAcceso();
			if (Evidencia.contains("SI"))
			{
				// CREAR CARPETA
				rutaCarpeta = claseBase.crearCarpeta(nomTest);

				// INICIO GRABACIÓN
				MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
				
				// INICIA CREACIÓN DE REPORTE PDF
				generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
				
				// EJECIONES A DEMO QA
				pagsObjetDEInicio.pagDemon (rutaCarpeta);
				
				elements.selecElements(Evidencia, FirstName, LastName, Email, Age, Salary, Departament, Remove, DelBus, IngFecha,
						IngDate, IngTime, IngName, rutaCarpeta);
				
				widgets.selecWidgets(Ejecutar, Evidencia, FirstName, LastName, Email, Age, Salary, Departament, Remove,
						DelBus, IngFecha, IngDate, IngTime, IngName, rutaCarpeta);
				
				alerts.selecAlerts(Evidencia, FirstName, LastName, Email, Age, Salary, Departament, Remove, DelBus, IngFecha,
						IngDate, IngTime, IngName, rutaCarpeta);
				
				// FIN GRABACIÓN
				MyScreenRecorder.stopRecording();
				
				// FINALIZA CREACIÓN DE REPORTE PDF
				generarReportePdf.cerrarPlantilla();
				
			} 
			else 
			{
				// EJECIONES A DEMO QA
				pagsObjetDEInicio.pagDemon(rutaCarpeta);
				elements.selecElements(Evidencia, FirstName, LastName, Email, Age, Salary, Departament, Remove, DelBus, IngFecha,
						IngDate, IngTime, IngName, rutaCarpeta);
				
				widgets.selecWidgets(Ejecutar, Evidencia, FirstName, LastName, Email, Age, Salary, Departament, Remove,
						DelBus, IngFecha, IngDate, IngTime, IngName, rutaCarpeta);
				
				alerts.selecAlerts(Evidencia, FirstName, LastName, Email, Age, Salary, Departament, Remove, DelBus, IngFecha,
						IngDate, IngTime, IngName, rutaCarpeta);
			}
		}
	}

	@DataProvider(name = "IngresoGuru")
	public Object[][] datos() throws Exception {
		Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/PasosIniciales.xlsx", "GuruNG");
		return arreglo;
	}

	@DataProvider(name = "IngresoML")
	public Object[][] datos2() throws Exception {
		Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/PasosIniciales.xlsx", "IngresoML");
		return arreglo;
	}

	@DataProvider(name = "IgresoToolsQA")
	public Object[][] datos3() throws Exception {
		Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/PasosIniciales.xlsx", "ToolsQA");
		return arreglo;
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
