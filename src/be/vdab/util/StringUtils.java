package be.vdab.util;

public class StringUtils {
	
	public static boolean isLong(String string) {
		try {
			Long.parseLong(string);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}
	
}
