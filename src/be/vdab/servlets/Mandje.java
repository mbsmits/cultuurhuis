package be.vdab.servlets;

import java.math.BigDecimal;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import be.vdab.entities.Reservatie;
import be.vdab.entities.Voorstelling;
import be.vdab.repositories.VoorstellingRepository;

public final class Mandje extends AbstractList<Reservatie> {

	private final VoorstellingRepository voorstellingRepository = new VoorstellingRepository();
	private final Map<Long, Reservatie> reservaties = new LinkedHashMap<>();

	public void addOrReplace(Reservatie reservatie) {
		reservaties.put(reservatie.getVoorstellingId(), reservatie);
	}

	public void setKlantId(long klantId) {
		for (Reservatie reservatie : this) {
			reservatie.setKlantId(klantId);
		}
	}

	public BigDecimal getTotaal() {
		BigDecimal totaal = BigDecimal.ZERO;
		for (Reservatie reservatie : this) {
			long voorstellingId = reservatie.getVoorstellingId();
			Voorstelling voorstelling = voorstellingRepository.findById(voorstellingId);
			BigDecimal prijs = voorstelling.getPrijs();
			long plaatsen = reservatie.getPlaatsen();
			totaal = totaal.add(prijs.multiply(BigDecimal.valueOf(plaatsen)));
		}
		return totaal;
	}

	@Override
	public Iterator<Reservatie> iterator() {
		return reservaties.values().iterator();
	}

	@Override
	public Reservatie get(int index) {
		return reservaties.values().toArray(new Reservatie[0])[index];
	}

	@Override
	public int size() {
		return reservaties.values().size();
	}

}
