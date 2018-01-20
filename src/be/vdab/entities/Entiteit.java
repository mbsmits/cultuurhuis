package be.vdab.entities;

import java.util.Objects;

public abstract class Entiteit {

	protected static long checkLong(long geheelGetal) {
		if (geheelGetal < 0) {
			throw new IllegalArgumentException("ongeldig geheel getal (negatief)");
		}
		if (geheelGetal > 99_999_999_999L) {
			throw new IllegalArgumentException("ongeldig geheel getal (te groot)");
		}
		return geheelGetal;
	}

	protected static String checkString(String string) {
		Objects.requireNonNull(string);
		if (string.length() > 45) {
			throw new IllegalArgumentException("ongeldige string (te lang)");
		}
		return string;
	}

}
