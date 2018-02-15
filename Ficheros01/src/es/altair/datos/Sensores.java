package es.altair.datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Sensores {

	public static void main(String[] args) {
		
		String linea;
		
		File fichero = new File("mediciones.txt");
		
		if(fichero.exists()) {
			LeerArchivo(fichero);
			System.out.println("Fichero Creado");
		} else {
			System.out.println("Fichero no existente");
		}
	}

	private static void LeerArchivo(File fichero) {
		File fichero2 = new File("medicionesMin.txt");
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(fichero2);
			bw = new BufferedWriter(fw);
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
		}
		
		
		
		
		FileReader fr = null;
		BufferedReader br = null;
		String linea;
		
		try {
			fr = new FileReader(fichero);
			br = new BufferedReader(fr);
			while((linea=br.readLine())!= null) {
				String [] tablaTemp = linea.split(" ");
				EscribirArchivo(tablaTemp,fw,bw,fichero2);
			}
		
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				fr.close();
				br.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
		}
		
	}

	private static void EscribirArchivo(String[] tablaTemp,FileWriter fw,BufferedWriter bw,File fichero2) {
		
		
		
		if(!fichero2.exists()) {
			try {
				fichero2.createNewFile();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		if (tablaTemp.length>1) {
			int menor = Integer.parseInt(tablaTemp[1]);
				for (int i = 1; i < tablaTemp.length; i++) {
					if(Integer.parseInt(tablaTemp[i])< menor){
						menor = Integer.parseInt(tablaTemp[i]);
					}
				}
				try {
				bw.write(tablaTemp[0]+" "+ menor);
				bw.newLine();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
}
