/**
 * 
 */
package DataMining;

/**
 * @author SSG
 *
 */


/**
 * 
 */

public class FoundOccurence {
	
	public String getValue() { return _strValue; }
	public void setValue (String s) { _strValue = s; _isEmpty = (_index > 0 && _beginPos > 0)? false : true ; _endPos = _beginPos + s.length();}
	public int getIndex () { return _index; }
	public void setIndex (int i) { _index = i; _isEmpty = (!_strValue.isEmpty() && _beginPos > 0)? false : true ; _endPos = _beginPos + _strValue.length(); }
	public int getBeginPos() { return _beginPos; }
	public void setBeginPos (int b) { _beginPos = b; _isEmpty = (!_strValue.isEmpty() && _index > 0)? false : true ; _endPos = _beginPos + _strValue.length(); }
	public int getEndPos () { return _endPos; }
	public void setEndPos (int e) { _endPos = e; _isEmpty = (!_strValue.isEmpty() && _index > 0)? false : true ; }
	public boolean isEmpty() { return _isEmpty; }
	
	
	public FoundOccurence() {
		_index = -1; 
		_beginPos = _endPos = -1;
		_isEmpty = true;
		_strValue = null;
	}
	public FoundOccurence (String s) {
		_index = 0;
		_beginPos = 0;
		_endPos = _beginPos + s.length();
		_isEmpty = false;
		_strValue = s;
	}
	public FoundOccurence (String s, int indx) {
		_index = indx;
		_beginPos = 0;
		_endPos = _beginPos + s.length();
		_isEmpty = false;
		_strValue = s;
	}
	public FoundOccurence (String s, int indx, int begin) {
		_index = indx;
		_beginPos = begin;
		_endPos = _beginPos + s.length();
		_isEmpty = false;
		_strValue = s;
	}
	public FoundOccurence (String s, int indx, int begin, int end) {
		_index = indx;
		_beginPos = begin;
		_endPos = end;
		_isEmpty = false;
		_strValue = s;
	}
	
	private int _index;
	private int _beginPos;
	private int _endPos;
	private String _strValue;
	boolean _isEmpty;


}
