/**
 * 
 */
package DataMining;

import java.util.regex.*;

/**
 * @author SSG
 *
 */
public class HTMLProcessor implements DMConstants{

	/**
	 * 
	 */
	public HTMLProcessor() {
		// TODO Auto-generated constructor stub
	}
	
	
	

	/**
	 * @param strSource - in which we must find pattern string
	 * 
	 * @param strPatterns - an array of string, that we must find in previous argument
	 * 
	 * @param segment - array of found segments in processed string
	 * 
	 * 
	 * 
	 * @return  total amount of found segments
	 * 
	 */
	
	public static int findSegments2Delete(String strSource,String strPatterns[], Segment2Replace segment[][], String foundStrSegments[][]) {
		
		
		
		segment = new Segment2Replace[32][];
		foundStrSegments = new String [32][];
		int i = 0;
		
		int total = 0;
		
		for(String strPatternValue : strPatterns){
			;
			Pattern p = Pattern.compile(strPatternValue);
			Matcher m = p.matcher(strSource);
			boolean found = m.find();
			if (!found) continue;
			int j = 0;
			segment[i++] = new Segment2Replace[32];
			foundStrSegments[i] = new String[32];
			do {
				
				int start = m.start();
				int end = m.end();
				String str = strSource.substring(start, end);
				
				segment[i][j++] = new Segment2Replace(start, end);
				foundStrSegments[i][j] = str;
				total++;
				found = m.find();
				
			} while (found);
		}
		
		
		
		return total;
	}

}
