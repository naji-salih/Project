package bibi;

import java.time.LocalDate;

public class Author {
	private int id;
	private String name;
	private String vorname;
	private LocalDate geburtsdatum;
	
	
	public Author(int id, String name, String vorname, LocalDate geburtsdatum) {
		super();
		this.id = id;
		this.name = name;
		this.vorname = vorname;
		this.geburtsdatum = geburtsdatum;
	}
	
	public Author(String name, String vorname, LocalDate geburtsdatum) {
		super();
		this.name = name;
		this.vorname = vorname;
		this.geburtsdatum = geburtsdatum;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getVorname() {
		return vorname;
	}


	public void setVorname(String vorname) {
		this.vorname = vorname;
	}


	public LocalDate getGeburtsdatum() {
		return geburtsdatum;
	}


	public void setGeburtsdatum(LocalDate geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}


	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", vorname=" + vorname + ", geburtsdatum=" + geburtsdatum + "]";
	}
	
	
}
	