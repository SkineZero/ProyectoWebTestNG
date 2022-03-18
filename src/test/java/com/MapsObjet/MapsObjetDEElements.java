package com.MapsObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.testNG.ClaseBase;

public class MapsObjetDEElements extends ClaseBase

{
	// CONSTRUCTOR DE LA CLASE
	public MapsObjetDEElements(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
	}
	// BUSCA EL BOTON ELEMENTS Y WEB TABLES
	protected By btnElements = By.xpath("//h5[normalize-space()='Elements']");
	protected By btnWebTables = By.xpath("//span[contains(text(),'Web Tables')]");

	// INGRESA UN NUEVO REGISTRO
	protected By btnAdd = By.cssSelector("#addNewRecordButton");
	protected By txtFirstName = By.cssSelector("#firstName");
	protected By txtLastName = By.cssSelector("#lastName");
	protected By txtEmail = By.cssSelector("#userEmail");
	protected By numAge = By.cssSelector("#age");
	protected By numSalary = By.cssSelector("#salary");
	protected By txtDepartament = By.cssSelector("#department");
	protected By btnSubmit = By.cssSelector("#submit");

	// BOTONES OPCIONALES
	protected By txtSearch = By.xpath("//input[@id='searchBox']");
	protected By btnDeleted = By.xpath("//*[name()='path' and contains(@d,'M864 256H7')]");
}
