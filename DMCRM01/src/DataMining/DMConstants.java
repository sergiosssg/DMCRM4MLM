/**
 * 
 */
package DataMining;

/**
 * @author SSG
 *
 */
public interface DMConstants {
	
	public static final int WEBPAGETOBELOADED = 1;
	public static final int WEBPAGETLOADEDSUCCESSFUL = 2;
	public static final int WEBPAGELOADEDFAILED = 4;
	public static final int WEBPAGESTORED = 8;
	
	public static final int WEBRESOURSETOBEPROCESSED = 256;
	public static final int WEBRESOURSEPROCESSEDSUCCESSFUL = 512;
	public static final int WEBRESOURSEPROCESSEDFAILED = 1024;
	public static final int WEBRESOURSETOBEPREPROCESSED = 2048;
	
	public static final int WEBRESOURSEPREPROCESSEDSUCCESSFUL = 4096;
	
	public static final int MASKTYPEOFRESOURSE = 240;
	public static final int MASKTYPEOFDMRESOURSE = 112;
	public static final int MASKTYPEOFMIME = 57344;
	public static final int RESOURCEISTRUNK = 16;
	public static final int RESOURCEISBRANCH = 32;
	public static final int RESOURCEISLEAF = 48;
	public static final int RESOURCEISSEED = 64;
	public static final int MIMEHTMLPAGE = 8192;

}
