package Temp;

import java.util.Date;

public class GenarateEmailDemo {
	public static void main(String[] args) {
		Date date = new Date();
		String datestring = date.toString();
		String noSpaceDateString = datestring.replaceAll(" ", "");
		String noColonDateString = noSpaceDateString.replaceAll(":", "");
		String emailWithTimeStamp = noColonDateString+"@gmail.com";
		System.out.println(emailWithTimeStamp);
	}
}
