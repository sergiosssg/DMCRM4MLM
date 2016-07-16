/**
 * 
 */
package GUIForms;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 * @author SSG
 *
 */
public class HTMLFileFilter extends FileFilter {

		
	public boolean accept(File fileArg) {
	
		if (fileArg.getName().endsWith(".html")) return true;
		if (fileArg.isDirectory()) return true;
				
		return false;
	}

	
	public String getDescription() {
		return "HTML files";
	}

}
