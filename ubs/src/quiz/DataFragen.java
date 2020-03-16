package quiz;

public class DataFragen {
	
	private String frage;
	private String antwort;
	
	public DataFragen(String frage, String antwort) {
		super();
		this.frage = frage;
		this.antwort = antwort;
	}

	
	@Override
	public String toString() {
		return "DataFragen [frage=" + frage + ", antwort=" + antwort + "]";
	}

	public String getFrage() {
		return frage;
	}
	
	public void setFrage(String frage) {
		this.frage = frage;
	}
	
	public String getAntwort() {
		return antwort;
	}
	public void setAntwort(String antwort) {
		this.antwort = antwort;
	}
	
}
