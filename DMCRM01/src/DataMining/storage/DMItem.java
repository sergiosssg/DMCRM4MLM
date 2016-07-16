/**
 * 
 */
package DataMining.storage;

/**
 * @author SSG
 *
 */
public interface DMItem {
	
	public long getId();
	
	public String getAddres();
	
	public String getDate(int how);
	
	public String getTime(int how);
	
	public boolean isProccessed();

}
