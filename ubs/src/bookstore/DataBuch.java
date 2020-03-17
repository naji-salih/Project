package bookstore;

public class DataBuch {
	
	
	private String name;
	private DataAutor autor;
	private int seiten;
	private String genre;
	
	@Override
	public String toString() {
		return "DataBuch [name=" + name + ", autor=" + autor + ", seiten=" + seiten + ", genre=" + genre + "]";
	}
	public DataBuch(String name, DataAutor autor, int seiten, String genre) {
		super();
		this.name = name;
		this.autor = autor;
		this.seiten = seiten;
		this.genre = genre;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public DataAutor getAutor() {
		return autor;
	}
	public void setAutor(DataAutor autor) {
		this.autor = autor;
	}
	public int getSeiten() {
		return seiten;
	}
	public void setSeiten(int seiten) {
		this.seiten = seiten;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	

	
	
}
