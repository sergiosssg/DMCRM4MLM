/**
 * 
 */
package DataMining;

/**
 * @author SSG
 *
 */
public class DMTask implements DMConstants{
	
	private String _urlAddress;
	private long _ID;
	private int _state;
	private int _whoI;
	
	public String getUrlAddress() { return _urlAddress; }
	public void setUrlAddress ( String urlAddress) { _urlAddress = urlAddress; }
	public long getID() { return _ID; }
	public int  getState() { return _state; }
	public int  getWhoI() { return _whoI; }

}
