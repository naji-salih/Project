package bookstore;

import java.time.LocalDate;

public class DataAutor {
	
	private String vorname;
	private String name;
	private LocalDate geburtsdatum;
	
	@Override
	public String toString() {
		return "DataAutor [vorname=" + vorname + ", name=" + name + ", geburtsdatum=" + geburtsdatum + "]";
	}

	public DataAutor(String vorname, String name, LocalDate geburtsdatum) {
		super();
		this.vorname = vorname;
		this.name = name;
		this.geburtsdatum = geburtsdatum;
	}
	
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getGeburtsdatum() {
		return geburtsdatum;
	}
	public void setGeburtsdatum(LocalDate geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}
	
	

}
