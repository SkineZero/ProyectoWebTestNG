package com.MapsObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.testNG.ClaseBase;

public class MapsObjetDEAlerts extends ClaseBase

{
	// CONSTRUCTOR DE LA CLASE
	public MapsObjetDEAlerts(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
	}
	// INGRESAR ALERTAS
	protected By btnRecoWidget = By.xpath("//div[1]//div[1]//div[4]//span[1]//div[1]//div[2]//div[2]//*[name()='svg']");
	protected By btnFrame = By.xpath("//*[@class='left-pannel']/div/div[3]");
	protected By btnAlerts = By.xpath("//span[normalize-space()='Alerts']");

	// INGRESAR BOTONES
	protected By btnClic1 = By.xpath("//button[@id='alertButton']");
	protected By btnClic2 = By.xpath("//button[@id='timerAlertButton']");
	protected By btnClic3 = By.xpath("//button[@id='confirmButton']");
	protected By btnClic4 = By.xpath("//button[@id='promtButton']");
	
	// OPCIONAL
	protected By opcional = By.xpath("//div[@class='main-header']");

}
