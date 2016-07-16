package DataMining;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * @author SSG
 *
 *
 *A list of all found segments in given HTML
 *
 *
 */


public class FoundSegmentsInString {

	public FoundSegmentsInString() {
		_list = new ArrayList<FoundOccurence>(255);
		_numberOfElements = 0;
	}
	
	public void addOcurence(FoundOccurence el) {_list.add(el); ++_numberOfElements;}
	
	public boolean removeOccurence (int index) {
		;
		
		FoundOccurence found = null;
		Iterator<FoundOccurence> it = _list.iterator();
		while (it.hasNext()){
			found = it.next();
			if(!found.isEmpty() && found.getIndex() == index) {
				_list.remove(index);
				--_numberOfElements;
				return true;
			}
			
		}
		return false;
	}
	
	public FoundOccurence getOccurence(int index){
		FoundOccurence found = null;
		Iterator<FoundOccurence> it = _list.iterator();
		while (it.hasNext()){
			found = it.next();
			if(!found.isEmpty() && found.getIndex() == index) return found;
		}
		return null;
	}
	
	public int countSegments() { return _numberOfElements;}
	
	
	private ArrayList<FoundOccurence> _list;
	private int _numberOfElements;

}
