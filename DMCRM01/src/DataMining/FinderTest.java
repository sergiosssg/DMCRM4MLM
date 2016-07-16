/**
 * 
 */
package DataMining;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author SSG
 *
 */
public class FinderTest {
	
	private String _pattern = "<div";

	private String _source;
	
	
	
	/**
	 * 
	 */
	public FinderTest() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * 
	 */
	public FinderTest(String s){
		_source = s;
	}

	
	boolean isFound() {

		int pStart, pEnd;
		Pattern p = Pattern.compile(_pattern);
		Matcher m = p.matcher(_source);
		int countRes = m.groupCount();
		boolean res; res = m.find();
		pStart = m.start();
		pEnd = m.end();
		;
		return res;
	};
	
	
	String getSource(){ return _source;}
	
}
