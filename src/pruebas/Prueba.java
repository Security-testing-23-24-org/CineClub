package pruebas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Prueba {
	private List<String> l;
	private int[][] matriz;
	public Prueba() {
		l=new ArrayList<String>();
		matriz=new int[5][5];
	}
	
	public void unMetodo() throws FileNotFoundException, IOException {
		Iterator<String> it=l.iterator();
		boolean encontrado=false;
		while(it.hasNext() && !encontrado) {
			String s=it.next();
		}
		
		for (int[] f : matriz) {
			for(int v : f) {
				
			}
		}
		
		ObjectInputStream ois =new ObjectInputStream(new FileInputStream(""));
	}

}
