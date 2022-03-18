package com.testNG;

import java.io.File;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utilidades.GenerarReportePdf;

public class ClaseBase {

	protected WebDriver driver;

	String rutaOutput;
	
	// CONSTRUCTOR DE CLASE
	public ClaseBase(WebDriver driver)

	{

		super();
	}

	// METODO DE SCROLL BUENO

	public void scrollPage(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")", "");
	}

	// METODO ALERTA

	public void alert() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.accept();
			tiempoEspera(3);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// METODO DE NAVEGADOR
	public static WebDriver chromeDriverConection()

	{
		WebDriver _driver = null;
		try {
			// SETEAR LAS OPCIONES DE NAVEGADOR
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

			// SETEAR LAS PROPIEDADES DEL NAVEGADOR
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			_driver = new ChromeDriver();

			// MAXIMIZAR NAVEGADOR
			_driver.manage().window().maximize();
			return _driver;
		} catch (Exception e) {
			System.out.println(e);
		}
		return _driver;
	}

	// METODO CLICK
	public void click(By locator, File rutaCarpeta, String Evidencia) throws Exception 
	{
		try
		{
		driver.findElement(locator).click();
		tiempoEspera(1);
		captureScreen(rutaCarpeta,locator, Evidencia);
		}
		catch (Exception e) 
		{
			captureScreenError(rutaCarpeta, locator, Evidencia,e.toString());
			throw new InterruptedException();
		}
	}
	// METODO CLICK ALERTAS
	public void clickAlerts(By locator, File rutaCarpeta, String Evidencia) throws Exception 
	{
		try {
			driver.findElement(locator).click();
			tiempoEspera(1);
			}
		catch (Exception e) {
			captureScreenError(rutaCarpeta, locator, Evidencia,e.toString());
			throw new InterruptedException();
		}	
	}

	// METODO BORRAR
	public void borrar(By locator, File rutaCarpeta, String Evidencia) throws Exception {
		try {
			driver.findElement(locator).clear();
			captureScreen(rutaCarpeta,locator, Evidencia);
		}
		catch (Exception e) {
			captureScreenError(rutaCarpeta, locator, Evidencia,e.toString());
			throw new InterruptedException();
		}
	}

	// METODO ENVIAR TEXTO
	public void sendkey(String inputText, By locator, File rutaCarpeta, String Evidencia) throws Exception {
		try {
			driver.findElement(locator).sendKeys(inputText);
			captureScreen(rutaCarpeta,locator, Evidencia);
		}
		catch (Exception e) {
			captureScreenError(rutaCarpeta, locator, Evidencia,e.toString());
			throw new InterruptedException();
		}
		
	}
	
	public String capturarValorSelenium(By locator)throws Exception 
	{
		String valor = driver.findElement(locator).getText();
		return valor;
	}

	// METODO ENTER SUBMIN
	public void submit(By locator, File rutaCarpeta, String Evidencia) throws Exception {
		try {
		driver.findElement(locator).submit();
		captureScreen(rutaCarpeta,locator, Evidencia);
		}
	catch (Exception e) {
		captureScreenError(rutaCarpeta, locator, Evidencia,e.toString());
		throw new InterruptedException();
		}
	}

	// METODO CONTROL + A
	public void comando(By locator, File rutaCarpeta, String Evidencia) throws Exception {
		try {
			driver.findElement(locator).sendKeys(Keys.CONTROL, "a");
			captureScreen(rutaCarpeta,locator, Evidencia);
		}
		catch (Exception e) {
			captureScreenError(rutaCarpeta, locator, Evidencia,e.toString());
			throw new InterruptedException();
		}
	}

	// METODO ELIMINAR, RETROCESO
	public void bspace(By locator, File rutaCarpeta, String Evidencia) throws Exception {
		try {
			driver.findElement(locator).sendKeys(Keys.BACK_SPACE);
			captureScreen(rutaCarpeta,locator, Evidencia);
		}
		catch (Exception e) {
			captureScreenError(rutaCarpeta, locator, Evidencia,e.toString());
			throw new InterruptedException();
		}
	}

	// METODO ENTER
	public void intro(By locator, File rutaCarpeta, String Evidencia) throws Exception {
		
		try {
		driver.findElement(locator).sendKeys(Keys.ENTER);
		captureScreen(rutaCarpeta,locator, Evidencia);
		}
		catch (Exception e) {
			captureScreenError(rutaCarpeta, locator, Evidencia,e.toString());
			throw new InterruptedException();
		}
	}

	// METODO TIEMPO DE ESPERA
	public void tiempoEspera(long tiempo) throws InterruptedException {
		Thread.sleep(tiempo*1000);
	}

	public static String fechaHora() {
		// TOMAMOS LA FECHA DEL SISTEMA
		LocalDateTime fechaSistema = LocalDateTime.now();

		// DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmmss");

		// DAR FORMATO A LA FECHA DEL SISTEMA
		String formatFecha = fecha.format(fechaSistema);
		return formatFecha;
	}
	
	public static String fechaHora2() {
		// TOMAMOS LA FECHA DEL SISTEMA
		LocalDateTime fechaSistema = LocalDateTime.now();

		// DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		// DAR FORMATO A LA FECHA DEL SISTEMA
		String formatFecha = fecha.format(fechaSistema);
		return formatFecha;
	}

	public String HoraSistema() {
		// TOMAMOS LA FECHA DEL SISTEMA
		LocalTime horaSistema = LocalTime.now();

		// DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("HHmmss");

		// DAR FORMATO A LA FECHA DEL SISTEMA
		String hora = fecha.format(horaSistema);
		return hora;
	}
	
	public void setrutaOutput(String rutaOutput) 
	{
		this.rutaOutput = rutaOutput;
	}
	
	// CAPTURA DE PANTALLA ANTIGUO
	public void captureScreen2(File rutaCarpeta) throws Exception {
		String hora = HoraSistema();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(rutaCarpeta + "\\" + hora + ".png"));

	}

	// CAPTURAS DE PANTALLA
	public void captureScreen(File rutaCarpeta, By locator, String Evidencia) throws Exception {
		
		if (Evidencia.equals("SI"))
		{
			String hora = HoraSistema();
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(rutaCarpeta+"\\"+hora+".png"));
			String rutaImagen = new File(rutaCarpeta+"\\"+hora+".png").toString();
			
			// INSTANCIAMOS LA CLASE GENERAR PDF
			GenerarReportePdf informePdf = new GenerarReportePdf();
			
			// SE PROCEDE A INSERTAR LOCALIZADOR E IMAGEN EN EL PDF
			informePdf.crearbody(locator, rutaImagen);
			
			// ELIMINAR IMAGEN CREADA
			eliminarArchivo(rutaImagen);
		}
		
	}
	
	// CAPTURAS DE PANTALLA
	public void captureScreenError(File rutaCarpeta, By locator, String Evidencia, String msnError) throws Exception {
		
		if (Evidencia.equals("SI"))
		{
			String hora = HoraSistema();
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(rutaCarpeta+"\\"+hora+".png"));
			String rutaImagen = new File(rutaCarpeta+"\\"+hora+".png").toString();
			
			// INSTANCIAMOS LA CLASE GENERAR PDF
			GenerarReportePdf informePdf = new GenerarReportePdf();
			
			// SE PROCEDE A INSERTAR LOCALIZADOR E IMAGEN EN EL PDF
			informePdf.crearbodyError(locator, rutaImagen, msnError);
			
			// ELIMINAR IMAGEN CREADA
			eliminarArchivo(rutaImagen);
		}
		
	}
	
	public void eliminarArchivo(String rutaImagen) 
	{
		File fichero = new File(rutaImagen);
		fichero.delete();
	}
	
	public File crearCarpeta(String nomTest) {
		// ALMACENAMOS LA FECHA DEL SISTEMA
		String fecha = fechaHora();

		// CREAMOS EL NOMBRE DE LA CARPETA
		String nomCarpeta = nomTest + "-" + fecha;

		// OBTENEMOS LA RUTA DE ALOJAMIENTO DE SALIDA Y EL NOMBRE DE TEST A EJECUTAR
		File directorio = new File("./Output/" + nomCarpeta);

		// CREAMOS LA CARPETA
		directorio.mkdir();
		return directorio;
	}

	// METODO INICIAL
	public void urlAcceso(String url)

	{
		driver.get(url);
	}

}
