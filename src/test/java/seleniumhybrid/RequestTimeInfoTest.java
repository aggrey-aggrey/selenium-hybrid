package seleniumhybrid;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.pageobjects.AffinyPay;
import com.automation.testBase.TestBase;

public class RequestTimeInfoTest extends TestBase {
	AffinyPay affinypay;
	Scanner scanner;
	String stringTime;
	int minutes;
	String result;

	@BeforeMethod
	public void setUp() {
		driver = getDriver();

	}

	@SuppressWarnings("resource")
	@Test
	public void requestTime() throws IOException {

		scanner = new Scanner(System.in);
		System.out.println("Enter the time in the following format: HH:MM {AM|PM} example, 12:12:AM");

		try {
			stringTime = scanner.nextLine();

			System.out.println("Enter the time in the minutes");
			minutes = scanner.nextInt();

		} catch (InputMismatchException e) {
			System.out.println("Invalid input, please try again");

		}

		affinypay = new AffinyPay();

		result = affinypay.addTime(stringTime, minutes);

		if (result instanceof String) {
			System.out.println("Test PASSED");
		} else {
			System.out.println("Test FAILED");
		}

	}

	@Test
	public void verifyFunction_addTime_DateFormat() {
		scanner = new Scanner(System.in);
		System.out.println("Enter the time in the following format: HH:MM {AM|PM} example, 12:12:AM");

		try {
			stringTime = scanner.nextLine();

			System.out.println("Enter the time in the minutes");
			minutes = scanner.nextInt();

		} catch (InputMismatchException e) {
			System.out.println("Invalid input, please try again");

		}
		affinypay = new AffinyPay();
		result = affinypay.addTime(stringTime, minutes);

		String rel = "(12:30PM)";
		Pattern pattern = Pattern.compile(rel, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		Matcher match = pattern.matcher(result);

		if (match.find()) {
			String time = match.group(1);
			System.out.println("(" + time.toString() + ")" + "\n");
			System.out.println("Date format Test PASSED");

		} else {
			System.out.println("Date format Test FAILED");

		}

	}


	}


