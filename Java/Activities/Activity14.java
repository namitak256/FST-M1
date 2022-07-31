package activities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Activity14 {

	public static void main(String[] args) {
		try {
		File f1= new File("C:\\Namita\\Workspace\\FST_java\\src\\Test1.txt");
		boolean fileStatus= f1.createNewFile();
		
		File fileutil= FileUtils.getFile("C:\\Namita\\Workspace\\FST_java\\src\\Test1.txt");
		FileUtils.write(fileutil, "Hello world", "UTF8");
		String fileContent= FileUtils.readFileToString(fileutil, "UTF8");
		
		File f2= new File("C:\\Namita\\Workspace\\FST_java\\dst");
		FileUtils.copyFileToDirectory(f1, f2);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
