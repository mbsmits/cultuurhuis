package be.vdab.entities;

public final class GenreBuilder extends Builder<Genre> {
	
	private long	id;
	private String	naam;
	
	public GenreBuilder setId(long id) {
		this.id = id;
		return this;
	}
	
	public GenreBuilder setNaam(String naam) {
		this.naam = naam;
		return this;
	}
	
	@Override
	public Genre build() {
		return new Genre(id, naam);
	}
}
