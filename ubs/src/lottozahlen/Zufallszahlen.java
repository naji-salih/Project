package lottozahlen;

import java.util.Random;
public class Zufallszahlen {

    public int[] getZufallzahl(){
        int[] gewinnerzahlen = new int[6]; 
        int i;

        for(i = 0; i < gewinnerzahlen.length; i++ ){
                int zufallzahl = new Random().nextInt(49);
                gewinnerzahlen[i] =  zufallzahl;   
                System.out.println(zufallzahl);
        }
        
        
        return gewinnerzahlen; 
    } 
}
