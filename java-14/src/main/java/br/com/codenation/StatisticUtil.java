package br.com.codenation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StatisticUtil {

    private List<Integer> elementos = new ArrayList<Integer>();

	public static int average(int[] elements) {
	    int media = 0;
	    for(int i=0; i<elements.length; i++) {
	        media = media + elements[i];
        }
	    media = (int)media/elements.length;
		return media;
	}

	public static int mode(int[] elements) {

	    int aux = 0;
	    int cont = 0;
	    int contadores[] = new int[elements.length];

	    for(int i=0; i<elements.length; i++) {
	        cont = 0;
	        for(int j=0; j<elements.length; j++) {
				if (elements[j] == elements[i]) {
					cont++;
				}
			}
	        contadores[i] = cont;
        }

	    aux = 0;
	    int valorMax = 0;
	    for(int i=0; i<contadores.length; i++) {
	        if(aux < contadores[i]) {
	            aux = contadores[i];
	            valorMax = elements[i];
            }
	        aux = contadores[i];
        }

		return valorMax;
	}

	public static int median(int[] elements) {
        Arrays.sort(elements);
        int mediana = 0;
	    if(elements.length%2==0) {
            mediana = elements[(elements.length/2)] + elements[(elements.length/2)-1];
            mediana = mediana/2;
        } else {
	        mediana = elements[(int)(elements.length/2)];
        }
		return mediana;
	}
}