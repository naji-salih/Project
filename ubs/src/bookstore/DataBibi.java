package bookstore;

import java.util.ArrayList;

public class DataBibi {
	
	private String name;
	private ArrayList<DataBuch> buch;
	
	
	@Override
	public String toString() {
		return "DataBibi [name=" + name + ", buch=" + buch + "]";
	}
	
	
	
	public DataBibi(String name, ArrayList<DataBuch> buch) {
		super();
		this.name = name;
		this.buch = buch;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<DataBuch> getBuch() {
		return buch;
	}
	public void setBuch(ArrayList<DataBuch> buch) {
		this.buch = buch;
	}
	
	
	


}
