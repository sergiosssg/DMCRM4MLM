/**
 * 
 */
package DataMining;

import java.io.*;
import java.net.*;


/**
 * @author SSG
 *
 *<BR>
 *<BR>
 *
 *@see http://docs.oracle.com/javase/tutorial/networking/urls/readingWriting.html
 *
 *<BR>
 *<BR>
 *<BR>
 *
 *Incapsulate all operations for fetching HTML via Network, storing HTML into file and reading early stored HTML file from disk.
 *
 */
public class HtmlProcesingHelper implements DMConstants {

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
	
    public boolean doFromURLHTML2File() throws IOException {
    	if(_fileName.isEmpty() || _urlStr.isEmpty()) return false;
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
	
/////////////////////


    public String doFromURLHTML2String() throws IOException {
    	if(_fileName.isEmpty() || _urlStr.isEmpty()) return null;

    	StringBuilder strBld = new StringBuilder (524288);
    	;
    	URL workingURL = new URL(_urlStr);
        URLConnection uc = workingURL.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                                    uc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            strBld.append(inputLine);
        }
        _rawHTMLpage = strBld.toString();
        in.close();
    	return _rawHTMLpage;
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
    
    public boolean doFromFileHTML2String() throws IOException {
    	
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
	

	public boolean doFromStringHTML2File() throws IOException {
		if (_fileName.isEmpty() || _rawHTMLpage.isEmpty()) return false;
		
	    File  file = new File (_fileName);  
        if(!file.exists()) file.createNewFile();
    	
        FileWriter w = new FileWriter(file.getAbsoluteFile());
        BufferedWriter writer = new BufferedWriter(w);
        writer.write(_rawHTMLpage);    
        writer.close();
        return true;
	}
    
	
////	doFromFileHTML2String
	

	public String tmpFromFileHTML2String() {
		
		/*  *** may be don't use this code at all  
    	
    	StringBuilder strBld = new StringBuilder (524288);
    	;
    	URL workingURL = new URL(_urlStr);
        URLConnection uc = workingURL.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                                    uc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);

            strBld.append(inputLine);
        }
        
        _rawHTMLpage = strBld.toString();
        in.close();
    	*/
      	
        //FinderTest ftext = new FinderTest(_rawHTMLpage); 
        //_isScriptFound = ftext.isFound();
        //if (_isScriptFound) return true;
    	//return false;
		
		return null;
	}
    
	

	
	
	
	
	/**
	 * 
	 */
	public HtmlProcesingHelper() {
		// TODO Auto-generated constructor stub
		_toEmployHTTPparamS = false;
		_isScriptFound = false;
		_rawHTMLpage = null;
		_fileName = null;
		_urlStr = null;
	}

}
