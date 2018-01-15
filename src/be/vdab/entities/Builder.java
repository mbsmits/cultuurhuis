package be.vdab.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

abstract class Builder<T extends Entiteit> {

	protected static long checkLong(long geheelGetal) {
		if (geheelGetal <= 0) {
			throw new IllegalArgumentException("ongeldig geheel getal (niet positief)");
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

	protected static LocalDateTime checkLocalDateTime(LocalDateTime localDateTime) {
		Objects.requireNonNull(localDateTime);
		return localDateTime;
	}

	protected static BigDecimal checkBigDecimal(BigDecimal bigDecimal) {
		Objects.requireNonNull(bigDecimal);
		return bigDecimal;
	}

	protected static Genre checkGenre(Genre genre) {
		Objects.requireNonNull(genre);
		return genre;
	}

	protected static Voorstelling checkVoorstelling(Voorstelling voorstelling) {
		Objects.requireNonNull(voorstelling);
		return voorstelling;
	}

	protected static Klant checkKlant(Klant klant) {
		Objects.requireNonNull(klant);
		return klant;
	}

	public abstract T build();

}
