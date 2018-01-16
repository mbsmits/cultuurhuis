package be.vdab.entities;

public final class GenreBuilder extends Builder<Genre> {
	
	private long id;
	private String naam;
	
	public long getId() {
		return id;
	}
	
	public String getNaam() {
		return naam;
	}
	
	public GenreBuilder setId(long id) {
		this.id = checkLong(id);
		return this;
	}
	
	public GenreBuilder setNaam(String naam) {
		this.naam = checkString(naam);
		return this;
	}
	
	@Override
	public Genre build() {
		return new Genre(id, naam);
	}
	
}
