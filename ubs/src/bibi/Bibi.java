package bibi;

import java.util.ArrayList;

public class Bibi {
	private String name;
	private ArrayList<Book> buecherList;
	private static Bibi instance;
	
	
	//Singleton pattern class --> instance of object
		public static Bibi getInstance(){
		    if (instance == null){
		        instance = new Bibi("Tenzin's Bibliothek",null);
		    }
		    return instance;
		}
	
	public Bibi(String name, ArrayList<Book> buecherList) {
		super();
		this.name = name;
		this.buecherList = buecherList;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public ArrayList<Book> getBuecherList() {
		return buecherList;
	}


	public void setBuecherList(ArrayList<Book> buecherList) {
		this.buecherList = buecherList;
	}


	@Override
	public String toString() {
		return "Bibliothek [name=" + name + ", buecherList=" + buecherList + "]";
	}
	
	
}
