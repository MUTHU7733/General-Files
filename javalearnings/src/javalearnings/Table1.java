package javalearnings;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Table1 {
	public static void main(String args[]) throws InterruptedException {
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

		// Table Head
		List<WebElement> Tablehead = driver.findElements(By.xpath("//table[@id='example']//thead//th"));
		String Headfirst = "//table[@id='example']//thead//th[";
		String Headlast = "]//td";
		String head;

		List<WebElement> Tableheads = null;

		for (int k = 0; k < Tablehead.size() - 1; k++) {
			System.out.print(Tablehead.get(k + 1).getText() + "\t");
		}
		System.out.println();
		for (int h = 0; h <= Tablehead.size() - 1; h++) {
			head = Headfirst +h+ Headlast;
			Tableheads = driver.findElements(By.xpath(head));

		}

		// Table Data

		List<WebElement> Tablerows = driver.findElements(By.xpath("//table[@id='example']//tr"));
		String columnFirst = "//table[@id='example']//tr[";
		String columnLast = "]//td";
		String column;
		int z = 1;
		List<WebElement> tableColumns;
		for (int i = 0; i <= Tablerows.size() - 3; i++) {
			column = columnFirst + (i + 1) + columnLast;
			tableColumns = driver.findElements(By.xpath(column));

			for (int j = 0; j < tableColumns.size() - 1; j++) {
				System.out.print(tableColumns.get(j).getText() + "\t");
			}
			System.out.println("");
			inner(driver, tableColumns, Tablehead, z);
			z += 1;

		}

	}

	public static void single(WebDriver driver) throws InterruptedException {
		System.out.println("Enter the page number which one you want?");
		Scanner sc = new Scanner(System.in);
		int page = sc.nextInt();
		List<WebElement> pageNo = driver.findElements(By.xpath("//div[@id='example_paginate']//span//a"));
		pageNo.get(page - 1).click();

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

	public static void inner(WebDriver driver, List<WebElement> tableColumns, List<WebElement> Tablehead, int z) {

		HashMap<String, String> Inner = new HashMap<String, String>();

		for (int i = 0; i <= tableColumns.size() - 1; i++) {
			Inner.put(Tablehead.get(i).getText(), tableColumns.get(i).getText());

		}
		// System.out.println(Inner);

		outer(Inner, z);

	}

	public static void outer(HashMap<String, String> Inner, int j) {
		HashMap<Integer, HashMap<String, String>> Outer = new HashMap<Integer, HashMap<String, String>>();
		Outer.put(j, Inner);
		System.out.println(Outer);
	}

}
