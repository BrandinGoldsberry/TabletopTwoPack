package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Writer {
	public static void Write(String location, SaveGame Save) {
		
		File newSave = new File(location);

		FileOutputStream FOS = null;
		ObjectOutputStream OOS = null;

		try {
			if (newSave.createNewFile()) {
				System.out.println("Created new save file");
			}

			FOS = new FileOutputStream(location);
			OOS = new ObjectOutputStream(FOS);

			OOS.writeObject(Save);
		} catch (IOException e) {
			System.out.println("Error creating save, check path");
		} finally {
			try {
				if(FOS != null && OOS != null) {
					OOS.close();
					FOS.close();					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(newSave.exists()) {
			System.out.println("Saved Campaign!");			
		}
	}
	
	public static SaveGame Load(String location) {
		File campaignToLoad = new File(location);
		SaveGame ret = null;
		FileInputStream FIS = null; 
        ObjectInputStream OIS = null;
        
		try {
		FIS = new FileInputStream(campaignToLoad); 
        OIS = new ObjectInputStream(FIS);
        ret = (SaveGame)OIS.readObject();
		} catch(IOException e) {
			System.out.println("Error reading file, check path");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(OIS != null && FIS != null) {
					OIS.close();
					FIS.close();											
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        return ret;
	}
}
