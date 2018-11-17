package gui;
import java.io.File;
import javax.swing.filechooser.FileFilter;

public class DeviceFileFilter extends FileFilter {
	
	
	public boolean accept(File file) {
		String name = file.getName();
		String extension = Utils.getFileExtension(name);
		
		if(extension == null) {
			return false;
		}
		else if(extension.equals("csv")) {
			return true;
		}
		else if(file.isDirectory()) {
			return true;
		}
		return false;
	}
	public String getDescription() {
		return "Comma Seperated Values (*.csv)";
	}
}
