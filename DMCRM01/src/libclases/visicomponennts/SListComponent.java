package libclases.visicomponennts;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * 
 */

/**
 * @author SSG
 *
 */
public class SListComponent extends JPanel {

	protected boolean  _isSelected;
	protected String[] _strSelected;
	protected int[] _indexesSelected;
	protected JList _jlst;
	protected JScrollPane _scrllPne;
	protected DefaultListModel<String> _lstModel;
	protected JPanel _pnlSouth;
	private Box hBox1;
	private JLabel lbl;
	private Component rigidArea2;
	protected JTextField _tFld;
	private Component rigidArea3;
	protected JButton _btnAdd;
	private Box hBox4;
	

	
	private void InitializeMe() {
		
        _isSelected = false;
		_indexesSelected = null;
		_strSelected = null;
		setLayout(new BorderLayout());
		_lstModel = new DefaultListModel<String>();
		_jlst = new JList(_lstModel);
		_jlst.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				_indexesSelected = _jlst.getSelectedIndices();
				List ll = _jlst.getSelectedValuesList();
				Iterator it = ll.iterator();
				_strSelected = new String[_indexesSelected.length];  // пока так, временно
				for( int i = 0;it.hasNext(); i++){
					String strElement = (String)it.next();
					_strSelected[i] = strElement;
				}
				_isSelected = true;
			}
		});
		_scrllPne = new JScrollPane(_jlst);
		_pnlSouth = new JPanel();
		
		add(_scrllPne, BorderLayout.CENTER);
		add(_pnlSouth, BorderLayout.SOUTH);
		
		
		hBox1 = Box.createHorizontalBox();
		_pnlSouth.add(hBox1);
		
		lbl = new JLabel("Enter new value :");
		_pnlSouth.add(lbl);
		
		rigidArea2 = Box.createRigidArea(new Dimension(20, 20));
		_pnlSouth.add(rigidArea2);
		
		_tFld = new JTextField();
		_pnlSouth.add(_tFld);
		_tFld.setColumns(10);
		
		rigidArea3 = Box.createRigidArea(new Dimension(20, 20));
		_pnlSouth.add(rigidArea3);
		
		_btnAdd = new JButton("Add");
		_btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				_lstModel  = (DefaultListModel<String>)_jlst.getModel();
				String sValue = _tFld.getText(); 
				_lstModel.addElement(sValue);
			}
		});
		_pnlSouth.add(_btnAdd);

		hBox4 = Box.createHorizontalBox();
		_pnlSouth.add(hBox4);
	}// InitializeMe
	
	
	
	/**
	 * 
	 */
	public SListComponent() {
		// TODO Auto-generated constructor stub
        InitializeMe();		
	}

	/**
	 * @param arg0
	 */
	public SListComponent(LayoutManager arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public SListComponent(boolean arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public SListComponent(LayoutManager arg0, boolean arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public String[] getAllElements(){
		Enumeration<String>  en =_lstModel.elements();
		String[] _strArr = new String[_lstModel.size()];
		
		for(int i=0; en.hasMoreElements();) {
			_strArr[i++] = en.nextElement();
		}
		return _strArr;
	}
	
	
	public int getSizeOfModel(){
		return _lstModel.getSize();
	}
	
	
	

    public  String[] getSelectedStringsInJList(boolean flashAll){
   		_isSelected = !flashAll;
    	return _strSelected;
    }
    
    
    public  int[] getSelectedIndicesInJList(boolean flashAll){
   		_isSelected = !flashAll;
    	return _indexesSelected;
    }
    
    
    public void flashMe(){
    	_isSelected = false;
    	_strSelected = null;
    	_indexesSelected = null;
    }
    

}

