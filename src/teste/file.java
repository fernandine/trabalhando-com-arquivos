package teste;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class file {

	public static void main(String[] args) {
		
		/*********Lendo arquivo de texto com Scanner e File***********/
		
		File file = new File("c:\\teste\\in.txt");
		Scanner sc = null;	
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		}
		catch (IOException e) {
			System.out.println("Erro!" + e.getMessage());
		}
		
		finally {
			if (sc != null)
			sc.close();
		}
		
		/**********FileReader e BufferedReader**********/
		
		String path = "C:\\teste\\in.txt";
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
		}
			
			
			/********Bloco try-with-resources***********/
			
			
		String path1 = "C:\\teste\\in.txt";
		try (BufferedReader br1 = new BufferedReader(new FileReader(path1))) {
			String line = br1.readLine();
			while (line != null) {
				System.out.println(line);
				line = br1.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
	  }	
		
		//***********FileWriter e BufferedWriter************/
		
		String[] lines = new String[] { "Good morning", "Good afternoon", "Good night" };
		String path2 = "C:\\teste\\in.txt";
		// Somente path -> recria o arquivo.
		// Somente (path, true) -> Acrescenta ao arquivo existente.
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path2, true))) {
			for (String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//**********Manipulando pastas***************/
		
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter a folder path: ");
			String strPath = sc1.nextLine();
			File path3 = new File(strPath);
			File[] folders = path3.listFiles(File::isDirectory);
		System.out.println("FOLDERS:");
			for (File folder : folders) {
			System.out.println(folder);
		}
		File[] files = path3.listFiles(File::isFile);
		System.out.println("FILES:");
			for (File file1 : files) {
			System.out.println(file1);
		}
			boolean success = new File(strPath + "\\subdir").mkdir();
		System.out.println("Directory created successfully: " + success);
		sc1.close();
		
		//********Informações do caminho do arquivo**********/
		
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Entre com o caminho do arquivo: ");
		String strPath1 = sc2.nextLine();
		File path4 = new File(strPath1);
		System.out.println("getPath: " + path4.getPath());
		System.out.println("getParent: " + path4.getParent());
		System.out.println("getName: " + path4.getName());
		sc2.close();
		
    }
  }	
}

