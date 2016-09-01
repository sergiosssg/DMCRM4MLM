/**
 * 
 */
package DataMining.storage;

/**
 * @author SSG
 *
 */
public interface ResourceItem {
	
	public long getId();
	
	public String getAddres();
	
	public String getDate(int how);
	
	public String getTime(int how);
	
	public boolean isProccessed();

}
