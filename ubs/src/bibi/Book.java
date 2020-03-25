package bibi;

import java.util.ArrayList;

public class Book {
	private int id;
	private String titel;
	private int seiten;
	private String kategorie;
	private ArrayList<Author> author;
	private ArrayList<Book> arrayList;
	private static Book instance;
	
	private Book(){
	    arrayList = new ArrayList<Book>();
	}
	//Singleton pattern class --> instance of object
	public static Book getInstance(){
	    if (instance == null){
	        instance = new Book();
	    }
	    return instance;
	}
	//ArrayList Buch
	public ArrayList<Book> getArrayList() {
	    return arrayList;
	}

	public Book(int id, String titel, int seiten, String kategorie, ArrayList<Author> author) {
		super();
		this.id = id;
		this.titel = titel;
		this.seiten = seiten;
		this.kategorie = kategorie;
		this.author = author;
	}
	
	public Book(String titel, int seiten, String kategorie, ArrayList<Author> author) {
		super();
		this.titel = titel;
		this.seiten = seiten;
		this.kategorie = kategorie;
		this.author = author;
	}
	 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public int getSeiten() {
		return seiten;
	}

	public void setSeiten(int seiten) {
		this.seiten = seiten;
	}

	public String getKategorie() {
		return kategorie;
	}

	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}

	public ArrayList<Author> getAuthor() {
		return author;
	}

	public void setAuthor(ArrayList<Author> author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Buch [titel=" + titel + ", seiten=" + seiten + ", kategorie=" + kategorie + ", author=" + author + "]";
	}

}
