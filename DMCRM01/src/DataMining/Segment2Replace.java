package DataMining;

/**
 *
 * Segment of code (tags) in HTML page to be deleted
 * 
 * @author SSG
 *
 *
 *
 */

public class Segment2Replace {

	public Segment2Replace() {

		_startBefore = _endBefore = _startAfter = _endAfter = -1;
		_isProccessed = false;
		_isEmpty = true;
		_strSubstitutor = _strOriginal = null;
	}

	public Segment2Replace(int start, int end) {
		_startBefore = start;
		_endBefore = end;
		_startAfter = _endAfter = -1;
		_isEmpty = false;
		_isProccessed = false;
		_strSubstitutor = _strOriginal = null;
	}
	
	
	public Segment2Replace(int start, int end, String original, String substitutor) {
		_startBefore = start;
		_endBefore = end;
		_startAfter = _endAfter = -1;
		_isEmpty = false;
		_isProccessed = false;
		_strSubstitutor = substitutor;
		_strOriginal = original;
	}
	
	
	public void setStart(int start) {
		_startBefore = start;
		_startAfter = _endAfter = -1;
		_isProccessed = false;
		_isEmpty = false;
	}

	public int getStartBefore() {
		return _startBefore;
	}

	public void setEnd(int end) {
		_endBefore = end;
		_startAfter = _endAfter = -1;
		_isProccessed = false;
		_isEmpty = false;
	}

	public int getEndBefore() {
		return _endBefore;
	}

	
	public void SetSubstitutor (String str) {
		_strSubstitutor = str;
	}
	
	
	public int doShift(int distance) {
		_startAfter = _startBefore + distance;
		_endAfter = (_strSubstitutor.isEmpty())?_endBefore + distance : _endBefore + distance + _strSubstitutor.length();
		
		
		if(_strSubstitutor.isEmpty()) return distance;
		else                          return distance + _strSubstitutor.length();
	}
	
	
	

	public void proccessMe() {
		_isProccessed = true;
		_isEmpty = true;
	}

	public boolean isEmpty() { return _isEmpty; }
	public boolean isProccessed() { return _isProccessed; }
	
	private int _startBefore;
	private int _endBefore;
	private int _startAfter;
	private int _endAfter;
	private String _strSubstitutor;
	private String _strOriginal;
	private boolean _isProccessed;
	private boolean _isEmpty;
}
