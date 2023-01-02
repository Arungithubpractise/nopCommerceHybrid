package com.nopCommerce.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class checkingorders {

	static WebDriver Idriver;

	//static WaitHelper waitHelper;

	public checkingorders(WebDriver rdriver) {
		Idriver = rdriver;
		PageFactory.initElements(Idriver, this);
		//waitHelper = new WaitHelper(Idriver);
	}
	

	@FindBy(xpath = "//i[@class='nav-icon fas fa-shopping-cart']")
	WebElement sales;

	@FindBy(xpath = "//p[text()=' Orders']")
	WebElement orders;

	@FindBy(xpath = "//div[5]//div[@class='k-multiselect-wrap k-floatwrap']")
	public WebElement Orderstatus;

	@FindBy(xpath = "//ul[@id=\"OrderStatusIds_listbox\"]/li")
	public List<WebElement> Orderstatus1;

	@FindBy(xpath = "//div[6]//div[@class='k-multiselect-wrap k-floatwrap']")
	public WebElement Paymentstatuses;

	@FindBy(xpath = "//ul[@id=\"PaymentStatusIds_listbox\"]/li")
	public List<WebElement> Paymentstatuses1;

	@FindBy(xpath = "//ul[@id=\"ShippingStatusIds_listbox\"]/li")
	public List<WebElement> Shippingstatuses1;

	@FindBy(xpath = "//div[7]//div[@class='k-multiselect-wrap k-floatwrap']")
	public WebElement Shippingstatuses;

	@FindBy(id = "WarehouseId")
	WebElement Warehouse;

	@FindBy(id = "BillingCountryId")
	public WebElement Billingcountry;

	@FindBy(id = "PaymentMethodSystemName")
	public WebElement Paymentmethod;

	@FindBy(id = "search-orders")
	WebElement search;

	@FindBy(xpath = "//tbody")
	WebElement table;

	@FindBy(xpath = "//table[@id='orders-grid']//tr/td")
	List<WebElement> tableRows;

	@FindBy(xpath = "//tbody/tr/td")
	List<WebElement> tableColumns;

	@FindBy(xpath = "//span[@aria-controls='StartDate_dateview']")
	WebElement datepicker;

	@FindBy(xpath = "//div[@id='StartDate_dateview']//span[@class='k-icon k-i-arrow-60-left']")
	WebElement datemover;

	@FindBy(xpath = "//div[@id='StartDate_dateview']//a[@aria-live='assertive']")
	WebElement monthdatetext;

	@FindBy(xpath = "//a[@title='Monday, March 13, 2017']")
	WebElement date13;

	@FindBy(xpath = "//*[@id=\\\"orders-grid\\\"]/tbody/tr[1]/td[6]/a")
	WebElement ord;
	
	

	public void sales() {
		sales.click();
	}

	public void orders() {
		orders.click();
	}

	public void Warehouse() {
		Warehouse.click();
		
	}

	public void Billingcountry() {
		Billingcountry.click();
	}

	public void Paymentmethod() {
		Paymentmethod.click();
	}

	public void Orderstatus() {
		Orderstatus.click();
	}

	public void Paymentstatuses() {
		Paymentstatuses.click();
	}

	public void Shippingstatuses() {
		Shippingstatuses.click();
	}

	public static void selectdropdown1(WebElement ele, String value) {

		//waitHelper.WaitForElement(ele, 30);
		Select drp = new Select(ele);
		List<WebElement> alloptions = drp.getOptions();

		for (WebElement option : alloptions) {
			if (option.getText().equals(value)) {
				option.click();
				break;
			}
		}
	}

	public void selectdropdown2(List<WebElement> options, String value) {

		for (WebElement option : options) {
			if (option.getText().equals(value)) {
				option.click();
				break;
			}
		}

	}

	public void datepicker() {
		String monthyear = "March 2017";
		String date = "13";

		datepicker.click();

		while (true) {
			String text = monthdatetext.getText();
			if (text.equals(monthyear)) {
				break;
			}

			else {
				//waitHelper.WaitForElement(Duration.ofSeconds(30));

				datemover.click();
			}

		}
		date13.click();

	}

	public void search() {
		//waitHelper.WaitForElement(search, 15);
		search.click();
	}

	public int getnoofrows() {
		return (tableRows.size());
	}

	public int getnoofcolumns() {
		return (tableColumns.size());
	}

	public boolean searchOrders(String email) {

		boolean flag = false;

		for (int i = 1; i <= getnoofrows(); i++) {

			String emailid = table.findElement(By.xpath("//*[@id=\"orders-grid\"]/tbody/tr[1]/td[6]/a")).getText();
			

			//waitHelper.WaitForElement(Duration.ofSeconds(30));

			if (emailid.equals(email)) {
				flag = true;
			}
		}

		return flag;
	}
}
