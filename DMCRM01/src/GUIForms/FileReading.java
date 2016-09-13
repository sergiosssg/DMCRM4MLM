package GUIForms;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;










import javax.swing.ListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JSplitPane;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JList;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractListModel;

public class FileReading extends JFrame {

	private static final long serialVersionUID = 1L;
	
	JPanel _contentPane;
	Frame _thisClass;
	private DataMining.HtmlProcesingHelper _htmlGetter;
	private Dialog4Url _frm4URLstring;
	private JFileChooser _fileCh4Save;
	private JFileChooser _fileCh4Open;
	private File _fileHTMLfetched;
	private String _fileNamePrepared;
	private DefaultListModel<String> _lstModel4RegExp;
	private String _htmlFetchedStr;
	
	
	JAboutBox dlgAbout;
	private final Action action = new SwingAction();
	private JTable _table4BrowsingHTMLSegments2Delete;
	private JTextField txtFld4NP4Brows2DelSegmnts;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileReading frame = new FileReading();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FileReading() {
		
		_thisClass = this;
		
		_fileNamePrepared = null;
		_htmlFetchedStr = null;
		
		_htmlGetter = new DataMining.HtmlProcesingHelper();
		_frm4URLstring = new Dialog4Url();
		
		_fileCh4Save = new JFileChooser();
		_fileCh4Save.setFileFilter(new HTMLFileFilter());
		
		_fileCh4Open = new JFileChooser();
		_fileCh4Open.setFileFilter(new HTMLFileFilter());
		
		String _strCurrentStatusURLInfo;
		String _strCurrentStatusFileInfo;
		
		//++++++++++++++++++++++++++++++
		
		
		JPanel pnlStatusBar = new JPanel();
		final JLabel lblStatusBar = new JLabel("not found");
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmChoseFile = new JMenuItem("Save in  File");
		mntmChoseFile.setEnabled(false);
		mntmChoseFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fname;
				int responseIsNoReplaceFile;
				int result = _fileCh4Save.showSaveDialog(_thisClass);
				if( result == JFileChooser.APPROVE_OPTION){
					;
					File fileApproved = _fileCh4Save.getSelectedFile();
					if (!fileApproved.isDirectory()) {
						; 
					     if (fileApproved.exists()) {
					    	 responseIsNoReplaceFile = JOptionPane.showConfirmDialog(
					    			 _thisClass, "Replace this file?",
					    			 "Do You want replace file?", JOptionPane.YES_NO_OPTION);
					    	 switch (responseIsNoReplaceFile) {
					    	 	case JOptionPane.YES_OPTION :
					    	 		_fileHTMLfetched = fileApproved;
					    	 		break;
					    	 	case JOptionPane.NO_OPTION :
					    	 		; // file value doesn't changed
					    	 		break;
					    	 	case JOptionPane.CLOSED_OPTION :
					    	 		;  // file value doesn't changed
					    	 		break;
					    	 }
					     }else _fileHTMLfetched = fileApproved;
					}
				}
			}
		});
		mnFile.add(mntmChoseFile);
		
		
		
		JMenuItem mntmOpenFile = new JMenuItem("Open File");
		mntmOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			/**
			 *
			 *
			 * 
			 * 
			 * insert here JFileChooser object
			 * 
			 * 	
			 */
				
				
				
				
				
				
			}
		});
		
		mnFile.add(mntmOpenFile);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenu mnInternet = new JMenu("Internet");
		menuBar.add(mnInternet);
		
		JMenuItem mntmGeturladdres = new JMenuItem("GetUrlAddres");
		mntmGeturladdres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				        
						String _str;
						
						
						
						_str = JOptionPane.showInputDialog(_thisClass, "Enter addres of Web page resourse");
						_htmlGetter.setURLString(_str);
			            //lblStatusBar.setText(_htmlGetter.getURLString());
				}
				catch (HeadlessException ex){
					System.out.println("Headless Exception occured");
					
				}
			}
		});
		mnInternet.add(mntmGeturladdres);
		
		JMenu mnSave = new JMenu("Save");
		menuBar.add(mnSave);
		
		JMenuItem mntmDestination = new JMenuItem("Destination");
		mntmDestination.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg) {
				
				String responce = JOptionPane.showInputDialog("Get File Name","");
				_htmlGetter.setFileName(responce);
				lblStatusBar.setText(_htmlGetter.getFileName());
			}
		});
		mnSave.add(mntmDestination);
		
		JMenu mnWork = new JMenu("Work");
		menuBar.add(mnWork);
		
		JMenuItem mntmDo = new JMenuItem("Do ...");
		mntmDo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//_htmlGetter.setFileName("stored.html");
				//_htmlGetter.setURLString("http://olx.ua/sumy/?page=493");

				String strURL = _htmlGetter.getURLString();
				
				boolean resIsScriptExists = false;

				JOptionPane.showMessageDialog(_thisClass, strURL);
				
				
				
				try {
					resIsScriptExists = _htmlGetter.doFromURLHTML2File();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				//if (resIsScriptExists) lblStatusBar.setText("script found");
				; 
			}
			
		});
		mnWork.add(mntmDo);
		
		JMenuItem mntmAddNewRegExpression = new JMenuItem("Add new Reg Expr");
		mntmAddNewRegExpression.setEnabled(false);
		mnWork.add(mntmAddNewRegExpression);
		
		JMenuItem mntmDelRegExpression = new JMenuItem("Delete Reg Expr");
		mntmDelRegExpression.setEnabled(false);
		mnWork.add(mntmDelRegExpression);
		
		JMenu mnOptions = new JMenu("Options");
		menuBar.add(mnOptions);
		
		JMenuItem mntmMainOptions = new JMenuItem("Main Options");
		mnOptions.add(mntmMainOptions);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dlgAbout = new JAboutBox(_thisClass);
				
				Dimension dlgSize = dlgAbout.getPreferredSize();
		        Dimension frmSize = getSize();
		        Point loc = getLocation();
		        dlgAbout.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x,
		                        (frmSize.height - dlgSize.height) / 2 + loc.y);
		        dlgAbout.setModal(true);
		        dlgAbout.pack();
		        dlgAbout.setVisible(true);
				
			}
		});
		mnHelp.add(mntmAbout);
		_contentPane = new JPanel();
		_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		_contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(_contentPane);
		
		_contentPane.add(pnlStatusBar, BorderLayout.SOUTH);
		

		pnlStatusBar.add(lblStatusBar);
		
		JTabbedPane tpnlMainPane = new JTabbedPane(JTabbedPane.BOTTOM);
		_contentPane.add(tpnlMainPane, BorderLayout.CENTER);
		
		JPanel pnlWebPage = new JPanel();
		tpnlMainPane.addTab("Web Page", null, pnlWebPage, null);
		pnlWebPage.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlTable4Browsing2DelSegments = new JPanel();
		
		pnlTable4Browsing2DelSegments.setLayout(new BorderLayout(0, 0));
		
		
		
		

		
		JScrollPane scrollPane4Table = new JScrollPane();
		_table4BrowsingHTMLSegments2Delete = new JTable(); // on the left of split panel is displayed
		scrollPane4Table.add(_table4BrowsingHTMLSegments2Delete);
		Panel4InputRegExp4Browsing2DelSegments pnl4InputRegExpressions4Browsing2DelSegments = new Panel4InputRegExp4Browsing2DelSegments();
		
		JSplitPane splitpnl4Browsing2DelSegments = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane4Table, pnl4InputRegExpressions4Browsing2DelSegments);
		
		pnlTable4Browsing2DelSegments.add(splitpnl4Browsing2DelSegments, BorderLayout.CENTER);
		
		
		
		JPanel pnlNavigating4Browsing2DelSegments = new JPanel(); // panel for navigating buttons
		pnlTable4Browsing2DelSegments.add(pnlNavigating4Browsing2DelSegments, BorderLayout.NORTH);
		
		Component hStrut41 = Box.createHorizontalStrut(20);
		pnlNavigating4Browsing2DelSegments.add(hStrut41);
		
		JLabel lbl4NP4Brows2DelSegmnts = new JLabel("Enter New Reg Expression");
		pnlNavigating4Browsing2DelSegments.add(lbl4NP4Brows2DelSegmnts);
		
		Component hStrut42 = Box.createHorizontalStrut(20);
		pnlNavigating4Browsing2DelSegments.add(hStrut42);
		
		txtFld4NP4Brows2DelSegmnts = new JTextField();
		pnlNavigating4Browsing2DelSegments.add(txtFld4NP4Brows2DelSegmnts);
		txtFld4NP4Brows2DelSegmnts.setColumns(10);
		
		Component hStrut43 = Box.createHorizontalStrut(20);
		pnlNavigating4Browsing2DelSegments.add(hStrut43);
		
		JButton btnAddNew4NP4Brows2DelSegmnts = new JButton("Add");
		btnAddNew4NP4Brows2DelSegmnts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 *  Here You can add new regular expressions to the JList
				 *    
				 */
				
				
				

				
				
				
				
				
				//_lstModel4RegExp.addElement(txtFld4NP4Brows2DelSegmnts.getText());
				//_lstModel4RegExp.addElement("+++++");
				//_lstModel4RegExp.notify();
			}
		});
		pnlNavigating4Browsing2DelSegments.add(btnAddNew4NP4Brows2DelSegmnts);
		
		Component hStrut44 = Box.createHorizontalStrut(20);
		pnlNavigating4Browsing2DelSegments.add(hStrut44);
		
		JPanel pnlInfo4Browsing2DelSegments = new JPanel(); // panel for displaying additional information
		pnlTable4Browsing2DelSegments.add(pnlInfo4Browsing2DelSegments, BorderLayout.SOUTH);
		
		
		tpnlMainPane.addTab("found strings", null, pnlTable4Browsing2DelSegments, null); // in initially panel of browsing of 
		tpnlMainPane.setEnabledAt(1, true);
		                                                                                // reg expressions results isn't displayed
		
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
