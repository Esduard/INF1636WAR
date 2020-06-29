package savestate;

import controller.GameController;

import controller.TurnController;
import model.GameExecution;

import java.io.*;

public class WAR_IO {
	
	public static void SalvarJogo(String path, SaveFile s) {
		
		
		try {
			FileOutputStream f = new FileOutputStream(new File(path));
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(s);
			o.close();
			f.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void CarregarJogo(File inputFile) {
		FileInputStream f;
		try {
			f = new FileInputStream(inputFile);
			ObjectInputStream o = new ObjectInputStream(f);
			SaveFile ctrl = (SaveFile) o.readObject();
			ctrl.loadSaveFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
