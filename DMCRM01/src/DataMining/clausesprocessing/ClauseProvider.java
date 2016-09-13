/**
 * 
 */
package DataMining.clausesprocessing;

import DataMining.BranchLevel;
import DataMining.DMConstants;
import DataMining.ResourceOfScraping;
import DataMining.TargetOfScraping;

/**
 * @author SSG
 *
 */
public class ClauseProvider implements DMConstants{
	
	public Clause pickupClause( 
			DMConstants where,
			DMConstants what,
			BranchLevel level,
			ResourceOfScraping resource,
			TargetOfScraping target
			)
	/**
	 * @param DMConstants where clause need to apply (in trunk or branch either in leaf)
	 * @param DMConstants what we have to find in this trunk, branch or leaf e.g. ( trunk, branch or leaf)
	 * @param BranchLevel level - how far from root same resource item ( from 0  is root)
	 * @param ResourceOfScraping resource Internet or other resource under which are clause would work
	 * @param TargetOfScraping target of scraping of this resource
	 * 
	 * @return found clause satisfied to upper conditions
	 * 
	 */
	{
		return null;
	};

}
