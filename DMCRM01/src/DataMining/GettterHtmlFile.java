/**
 * 
 */
package DataMining;

import java.io.*;
import java.net.*;


/**
 * @author SSG
 *
 *  http://docs.oracle.com/javase/tutorial/networking/urls/readingWriting.html
 *
 *
 *
 *Incapsulate all operations for fetching HTML via Network, storing HTML into file and reading early stored HTML file from disk.
 *
 */
public class GettterHtmlFile implements DMConstants {

	private String _fileName;
	private String _urlStr;
	private String _rawHTMLpage;
	private boolean _toEmployHTTPparamS;
	
	private boolean _isScriptFound; // maybe latter this variable will be removed
	
	/*******************************************************
	
	private String _storeHTML;
	private String _HTTPparameters;
	private boolean _toEmployHTTPparamS;
	*******************************************************/

	public void setURLString(String s) { _urlStr = s; }
	public String getURLString() { return _urlStr; }
	
	public void setFileName(String s) { _fileName = s; }
	public String getFileName () { return _fileName; }
	
	public String getRawHTMLpage() { return _rawHTMLpage; }
	
	       
	
	/**
	 *
	 * gets HTML file from Internet, by means of correct URL and saves it on the file
	 * 
	 * @return true if HTML properly stored in file
	 * 
	 * 
	 * @throws IOException
	 */
	
    public boolean doSavingHTML2File() throws IOException {
    	
  
    	PrintWriter pw = new PrintWriter(new FileWriter(_fileName));
    	
    	StringBuilder strBld = new StringBuilder (524288);
    	
    	;
    	URL workingURL = new URL(_urlStr);
        URLConnection uc = workingURL.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                                    uc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            pw.println(inputLine);
            strBld.append(inputLine);
        }
        
        _rawHTMLpage = strBld.toString();
        in.close();
        pw.close();
    	
      	
        FinderTest ftext = new FinderTest(_rawHTMLpage); 
        
        _isScriptFound = ftext.isFound();
        		
        if (_isScriptFound) return true;
        
    	return false;
    }
	
    

    /**
     * 
     * reads early stored on disk HTML file in specified string
     * 
     * 
     * @return true if stored HTML file is read correctly
     * 
     * 
     * @throws IOException
     */
    
    public boolean doFromSavedHTML2File() throws IOException {
    	
    	StringBuilder strBld = new StringBuilder (524288);
    	;
        BufferedReader in = new BufferedReader(new FileReader(_fileName));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            strBld.append(inputLine);
        }
        _rawHTMLpage = strBld.toString();
        in.close();

    	
      	
        FinderTest ftext = new FinderTest(_rawHTMLpage); 
        
        _isScriptFound = ftext.isFound();
        		
        if (_isScriptFound) return true;
        
    	return false;
    }
	

	
	
	/**
	 * 
	 */
	public GettterHtmlFile() {
		// TODO Auto-generated constructor stub
		_toEmployHTTPparamS = false;
		_isScriptFound = false;
	}

}
