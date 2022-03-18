package com.MapsObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.testNG.ClaseBase;

public class MapsObjetDEWidgets extends ClaseBase

{
	// CONSTRUCTOR DE LA CLASE
	public MapsObjetDEWidgets(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
	}
	// INGRESAR A WIDGETS
	protected By btnRecoger = By.xpath("//div[contains(@class,'accordion')]//div[1]//span[1]//div[1]//div[2]//div[2]//*[name()='svg']//*[name()='g']//*[name()='path' and contains(@d,'M3 19h18v2')]");
	protected By btnWidgets = By.xpath("//*[@class='left-pannel']/div/div[4]");
	protected By btnDatePïcker = By.xpath("//span[contains(text(),'Date Picker')]");

	// INGRESAR DATOS DE DATE
	protected By numDateSelect = By.cssSelector("#datePickerMonthYearInput");

	// DATE AND TIME PENDIENTE
	protected By btnDT = By.xpath("//input[@id='dateAndTimePickerInput']");

}
