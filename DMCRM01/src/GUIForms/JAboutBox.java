package GUIForms;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JAboutBox extends JDialog implements ActionListener{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon image1 = new ImageIcon();
	JLabel imageLabel = new JLabel();
	
	
	JButton okButton = new JButton("OK");
	
	
    String product = "Data Mining Program for MLM Buisiness Needs";
    String version = "0.01";
    String copyright = "Copyright (c) 2016 SSG";
    String comments = "sergiosssg@google.com";
    
    
    JLabel lbl1 = new JLabel();
    JLabel lbl2 = new JLabel();
    JLabel lbl3 = new JLabel();
    JLabel lbl4 = new JLabel();
	
	

	private final JPanel contentPanel = new JPanel();
	private final JLabel label = new JLabel("");
	private final JLabel label_1 = new JLabel("");

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	
	public JAboutBox(Frame parent){
		super(parent);
		try {
	            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	            //jbInit();
	            
	            /*
	            image1 = new ImageIcon(GUIForms.FileReading.class.getResource(
	            		          "C:\\SSG-PRIVATE\\Projects\\DATAMINING-PROCESSING\\DMCRM4MLMBuisiness\\src\\GUIForms\\about.png"));        
	            imageLabel.setIcon(image1);
	            */
	            setTitle("About");
	   		 
	    		setBounds(100, 100, 450, 300);
	    		getContentPane().setLayout(new BorderLayout());
	    		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	    		getContentPane().add(contentPanel, BorderLayout.CENTER);
	    		{
	    			lbl1.setText(product);
	    			lbl2.setText(version);
	    			lbl3.setText(copyright);
	    			lbl4.setText(comments);
	    			contentPanel.setLayout(new GridLayout(5, 1, 10, 10));
	    			
	    			contentPanel.add(imageLabel);
	    			contentPanel.add(lbl1);
	    			contentPanel.add(lbl2);
	    			contentPanel.add(lbl3);
	    			contentPanel.add(lbl4);
	    		}
	    		
	    		contentPanel.add(label);
	    		
	    		contentPanel.add(label_1);
	    		{
	    			JPanel buttonPane = new JPanel();
	    			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
	    			getContentPane().add(buttonPane, BorderLayout.SOUTH);
	    			{
	    				
	    				okButton.setActionCommand("OK");
	    				buttonPane.add(okButton);
	    				getRootPane().setDefaultButton(okButton);
	    			}
	    		}
	    		 
	      } catch (Exception exception) {
	            exception.printStackTrace();
	    }
	}
	
	public JAboutBox() {
        this(null);
	}

	
	
	
	private void jbInit() throws Exception {
		
		
		image1 = new ImageIcon(GUIForms.FileReading.class.getResource("C:\\SSG-PRIVATE\\Projects\\DATAMINING-PROCESSING\\DMCRM4MLMBuisiness\\src\\GUIForms\\about.png"));
		imageLabel.setIcon(image1);

		
		
		 setTitle("About");
		 
		 
		 
		 
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lbl1.setText(product);
			lbl2.setText(version);
			lbl3.setText(copyright);
			lbl4.setText(comments);
			contentPanel.setLayout(new GridLayout(5, 1, 10, 10));
			
			contentPanel.add(imageLabel);
			contentPanel.add(lbl1);
			contentPanel.add(lbl2);
			contentPanel.add(lbl3);
			contentPanel.add(lbl4);
		}
		
		contentPanel.add(label);
		
		contentPanel.add(label_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		 
		 
		 
		 
		 
		
	}
	
	
	public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == okButton) {
            dispose();
        }
    }
	
	
}
