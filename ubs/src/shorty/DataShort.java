package shorty;

public class DataShort {
	private String name;
	private String vorname;
	private Street adresse;
	
	public DataShort(String name, String vorname, Street adresse) {
		super();
		this.name = name;
		this.vorname = vorname;
		this.adresse = adresse;
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
	public Street getAdresse() {
		return adresse;
	}
	public void setAdresse(Street adresse) {
		this.adresse = adresse;
	}
	
	
	
	

}
