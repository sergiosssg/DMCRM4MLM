/**
 * 
 */
package DataMining.storage;

import java.util.Vector;

/**
 * @author SSG
 *
 */
public class ResourceItemsList {
	
	
	public ResourceItemsList() {
		_vector = new Vector<ResourceItem> (255, 1024);
	}
	
	
	private 
		Vector<ResourceItem> _vector;

}
