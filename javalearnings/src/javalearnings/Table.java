package javalearnings;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Table {
	public static void main(String args[]) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://datatables.net/examples/data_sources/dom");

		System.out.println("choose the categorey:single , all , range");
		Scanner sc = new Scanner(System.in);
		String categorey = sc.nextLine();
		if (categorey.equalsIgnoreCase("single")) {
			single(driver);
		} else if (categorey.equalsIgnoreCase("all")) {
			all(driver);
		} else {
			range(driver);
		}
	}

	public static void Table(WebDriver driver) {
		HashMap<String, String> map = new HashMap<>();
		HashMap<String, HashMap<String, String>> map1 = new HashMap<>();

		// Table Head
		List<WebElement> Tablehead = driver.findElements(By.xpath("//table[@id='example']//thead//th"));
		String Headfirst = "//table[@id='example']//thead//th[";
		String Headlast = "]//td";
		String head;

		List<WebElement> Tableheads;
		for (int k = 0; k < Tablehead.size(); k++) {
			System.out.print(Tablehead.get(k).getText() + "\t");
		}
		for (int h = 0; h <= Tablehead.size() - 1; h++) {
			head = Headfirst + h + Headlast;
			Tableheads = driver.findElements(By.xpath(head));

		}

		// Table Data

		List<WebElement> Tablerows = driver.findElements(By.xpath("//table[@id='example']//tr"));
		String columnFirst = "//table[@id='example']//tr[";
		String columnLast = "]//td";
		String column;

		List<WebElement> tableColumns;
		for (int i = 0; i <= Tablerows.size(); i++) {
			column = columnFirst + i + columnLast;
			tableColumns = driver.findElements(By.xpath(column));

			for (int j = 0; j < tableColumns.size(); j++) {
				System.out.print(tableColumns.get(j).getText() + "\t");
			}
			System.out.println();
		}

	}

	public static void single(WebDriver driver) {
		System.out.println("Enter the page number which one you want?");
		Scanner sc = new Scanner(System.in);
		int page = sc.nextInt();
		List<WebElement> pageNo = driver.findElements(By.xpath("//div[@id='example_paginate']//span//a"));
		pageNo.get(page).click();

		Table(driver);

	}

	public static void all(WebDriver driver) {

		List<WebElement> pageNo = driver.findElements(By.xpath("//div[@id='example_paginate']//span//a"));
		int z = 1;
		for (int k = 0; k < pageNo.size(); k++) {
			pageNo = driver.findElements(By.xpath("//div[@id='example_paginate']//span//a"));
			pageNo.get(k).click();
			System.out.println();
			System.out.println(" Page No : " + z++);
			Table(driver);

		}
	}

	public static void range(WebDriver driver) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the starting page:");
		int page1 = sc.nextInt();
		System.out.println("Enter the end page:");
		int page2 = sc.nextInt();
		for (int k = page1 - 1; k <= page2 - 1; k++) {
			List<WebElement> pageNo = driver.findElements(By.xpath("//div[@id='example_paginate']//span//a"));
			pageNo.get(k).click();
			System.out.println();
			System.out.println(" Page No : " + (k + 1));
			Table(driver);
		}
	}

	public static void pageno(WebDriver driver) {
		List<WebElement> pageNo = driver.findElements(By.xpath("//div[@id='example_paginate']//span//a"));
		int z = 1;
		for (int k = 0; k < pageNo.size(); k++) {
			pageNo = driver.findElements(By.xpath("//div[@id='example_paginate']//span//a"));
			pageNo.get(k).click();
			System.out.println();
			System.out.println(" Page No : " + z++);

		}
	}
}
