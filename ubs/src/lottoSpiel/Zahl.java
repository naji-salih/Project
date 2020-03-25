
package lottoSpiel;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random; 


public class Zahl {
	int zahl1;
	int zahl2;
	int zahl3;
	int zahl4;
	int zahl5;
	int zahl6;

	public Zahl(int zahl1, int zahl2, int zahl3, int zahl4, int zahl5, int zahl6) {
		super();
		this.zahl1 = zahl1;
		this.zahl2 = zahl2;
		this.zahl3 = zahl3;
		this.zahl4 = zahl4;
		this.zahl5 = zahl5;
		this.zahl6 = zahl6;
	}
	
	//public ZufallZahl() {};
	
	public static ArrayList<Integer> getInstance() {
		
			Random rand = new Random();
			rand.setSeed(new Date().getTime());
	        ArrayList<Integer> random = new ArrayList<Integer>();
	        for( int i = 0; i < 5; i++) {
	        	int zahl = rand.nextInt(49);
	        	if(!random.contains(zahl)) {
	        		random.add(zahl);
	        	}
	        	
	        }
	    return random;
	}

	public int getZahl1() {
		return zahl1;
	}

	public void setZahl1(int zahl1) {
		this.zahl1 = zahl1;
	}

	public int getZahl2() {
		return zahl2;
	}

	public void setZahl2(int zahl2) {
		this.zahl2 = zahl2;
	}

	public int getZahl3() {
		return zahl3;
	}

	public void setZahl3(int zahl3) {
		this.zahl3 = zahl3;
	}

	public int getZahl4() {
		return zahl4;
	}

	public void setZahl4(int zahl4) {
		this.zahl4 = zahl4;
	}

	public int getZahl5() {
		return zahl5;
	}

	public void setZahl5(int zahl5) {
		this.zahl5 = zahl5;
	}

	public int getZahl6() {
		return zahl6;
	}

	public void setZahl6(int zahl6) {
		this.zahl6 = zahl6;
	}

	@Override
	public String toString() {
		return "ZufallZahl [zahl1=" + zahl1 + ", zahl2=" + zahl2 + ", zahl3=" + zahl3 + ", zahl4=" + zahl4 + ", zahl5="
				+ zahl5 + ", zahl6=" + zahl6 + "]";
	}

}
