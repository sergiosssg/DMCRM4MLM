/**
 * 
 */
package GUIForms;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import java.awt.Window.Type;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author SSG
 *
 */
public class Dialog4Url extends JFrame {
	private final JPanel pnlStatusURLdialog = new JPanel();
	private JTextField tfld4URLvalue;
	public String stringURLvalue;

	
	private int JInitForm(String urlStr) throws HeadlessException
	{
		
/////////////////////////////

		stringURLvalue = urlStr;
		setType(Type.POPUP);
		setTitle("Internet URL");
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel pnlURLdialog = new JPanel();
		getContentPane().add(pnlURLdialog, BorderLayout.CENTER);
		
		JLabel lblUrl = new JLabel("URL");
		pnlURLdialog.add(lblUrl);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		pnlURLdialog.add(horizontalStrut);
		
		tfld4URLvalue = new JTextField();
		pnlURLdialog.add(tfld4URLvalue);
		tfld4URLvalue.setColumns(10);
		
		tfld4URLvalue.setText(urlStr);
		
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		pnlURLdialog.add(horizontalStrut_1);
		
		JButton btn4URLvalue = new JButton("Ok");
		btn4URLvalue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				stringURLvalue = tfld4URLvalue.getText();
				setVisible(false);
				
			}
		});
		pnlURLdialog.add(btn4URLvalue);
		getContentPane().add(pnlStatusURLdialog, BorderLayout.SOUTH);
		
		pack();
		
		return 1;
		
		// TODO Auto-generated constructor stub
		
		
////////////////////////////		
		
	}
	
	
	/**
	 * @throws HeadlessException
	 */
	public Dialog4Url() throws HeadlessException {
		
		
		JInitForm("");
		

	}

	/**
	 * @param arg0
	 */
	public Dialog4Url(GraphicsConfiguration arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @throws HeadlessException
	 */
	public Dialog4Url(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public Dialog4Url(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}
	
	
	public String getStringURLvalue()  {
		return stringURLvalue;
	}
	
	
	
}
