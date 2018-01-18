package be.vdab.entities;

import java.util.Objects;

public abstract class Entiteit {
	
	private final long id;
	
	public Entiteit() {
		this.id = -1;
	}
	
	public Entiteit(long id) {
		this.id = checkLong(id);
	}
	
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
	
	public long getId() {
		return id;
	}
	
}
