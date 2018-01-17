package be.vdab.entities;

import java.io.Serializable;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Stream;

public final class ReservatieMandje implements Serializable, Iterable<ReservatieBuilder> {
	
	private static final long serialVersionUID = 1L;
	private final SortedSet<ReservatieBuilder> set = new TreeSet<>();
	
	public void add(ReservatieBuilder reservatie) {
		set.add(reservatie);
	}
	
	public void clear() {
		set.clear();
	}
	
	@Override
	public String toString() {
		return set.toString();
	}
	
	public Stream<ReservatieBuilder> stream() {
		return set.stream();
	}
	
	@Override
	public Iterator<ReservatieBuilder> iterator() {
		return set.iterator();
	}
}
