package be.vdab.entities;

abstract class Builder<T extends Entiteit> {
	
	protected static long checkGeheelGetal(long geheelGetal) {
		if (geheelGetal <= 0) {
			throw new IllegalArgumentException("ongeldig geheel getal (niet positief)");
		}
		if (geheelGetal > 99_999_999_999L) {
			throw new IllegalArgumentException("ongeldig geheel getal (te groot)");
		}
		return geheelGetal;
	}
	
	protected static String checkVerplichteString(String string) {
		if (string == null) {
			throw new IllegalArgumentException("ongeldige string (null)");
		}
		return checkOptioneleString(string);
	}
	
	protected static String checkOptioneleString(String string) {
		if (string != null) {
			if (string.length() > 45) {
				throw new IllegalArgumentException("ongeldige string (te lang)");
			}
		}
		return string;
	}
	
	public abstract T build();
	
}
