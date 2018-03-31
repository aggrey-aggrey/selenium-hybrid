package com.automation.pageobjects;

public class AffinyPay {
	private int finalHour;
	private String time;
	private int finalMinutes;
	private int hourToAdd, minutesToAdd;


	public String addTime(String stringTime, int minutes) {
		String splitHour, splitMinutes, splitAmPm;

		String delimiter = ":";
		String[] splitString = stringTime.split(delimiter);

		splitHour = splitString[0];
		splitMinutes = splitString[1];
		splitAmPm = splitString[2];

		if (minutes >= 60) {

			hourToAdd = minutes / 60;
			minutesToAdd = minutes % 60;

			finalHour = Integer.parseInt(splitHour) + hourToAdd;
			finalMinutes = Integer.parseInt(splitMinutes) + minutesToAdd;

			if (finalMinutes >= 60) {

				int anotherHourToAdd = finalMinutes / 60;
				int anotherminutesToAdd = minutes % 60;

				finalHour = finalHour + anotherHourToAdd;
				finalMinutes = anotherminutesToAdd;
			}

		} else {

			minutesToAdd = minutes;

			finalHour = Integer.parseInt(splitHour);
			finalMinutes = Integer.parseInt(splitMinutes) + minutesToAdd;

			if (finalMinutes >= 60) {

				int anotherHourToAdd = finalMinutes / 60;
				int anotherminutesToAdd = minutes % 60;

				finalHour = finalHour + anotherHourToAdd;
				finalMinutes = anotherminutesToAdd;
			}

		}

		String hr = Integer.toString(finalHour);
		String min = Integer.toString(finalMinutes);

		time = hr + " : " + min + splitAmPm;
		System.out.println(time);

		return this.time;

	}

}
