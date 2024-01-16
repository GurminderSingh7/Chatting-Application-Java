package chatting.application;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.border.*;
import java.util.*;
import java.text.*;
import java.net.*;
import java.io.*;
public class Client implements ActionListener {
	private Image third;
	private Image one;
	private Image video;
	private Image phone;
	private Image morevert;
	
	JTextField text;
	static JPanel a1;
	static Box vertical=Box.createVerticalBox();
	static JFrame f = new JFrame();
	static DataOutputStream dout;
	Client(){
		
		f.setLayout(null);
		
		JPanel p1= new JPanel();
		p1.setBackground(new Color(7,94,84));
		p1.setBounds(0,0,450,70);
		p1.setLayout(null);
		f.add(p1);
		
		
		 URL url3 = getClass().getResource("/icons/3.png");
//		    URL urlDot = getClass().getResource("/snake/icons/dot.png");
//		    URL urlHead = getClass().getResource("/snake/icons/head.png");

		    // Print the URLs for debugging
		    System.out.println("URL for 3.png: " + url3);
//		    System.out.println("URL for dot.png: " + urlDot);
//		    System.out.println("URL for head.png: " + urlHead);

		    ImageIcon i1 = new ImageIcon(url3);
//		    ImageIcon i2 = new ImageIcon(urlDot);
//		    ImageIcon i3 = new ImageIcon(urlHead);

		    third= (i1 != null) ? i1.getImage() : null;
//		    dot = (i2 != null) ? i2.getImage() : null;
//		    head = (i3 != null) ? i3.getImage() : null;
		    
		    
		    Image i2=i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
	ImageIcon i3 = new ImageIcon(i2);	    
		    
		JLabel back= new JLabel (i3);
		back.setBounds(5,20,25,25);
		p1.add(back);
		
		back.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ae) {
				System.exit(0);
				
			}
		});
		
		URL url1 = getClass().getResource("/icons/2.png");
		System.out.println("URL for 2.png: " + url1);
		ImageIcon i4 = new ImageIcon(url1);
		 one= (i4 != null) ? i4.getImage() : null;
		 Image i5=i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
			ImageIcon i6 = new ImageIcon(i5);	    
				    
				JLabel profile= new JLabel (i6);
				profile.setBounds(40,10,50,50);
				p1.add(profile);	 
		
				
		URL urlvideo = getClass().getResource("/icons/video.png");
		System.out.println("URL for 1.png: " + urlvideo);
		ImageIcon i7 = new ImageIcon(urlvideo);
		 video= (i7 != null) ? i7.getImage() : null;
		 Image i8=i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
			ImageIcon i9 = new ImageIcon(i8);	    
				    
				JLabel video= new JLabel (i9);
				video.setBounds(300,20,30,30);
				p1.add(video);	 
		 
				
			
				 
						URL urlphone = getClass().getResource("/icons/phone.png");
						System.out.println("URL for phone.png: " + urlphone);
						ImageIcon i10 = new ImageIcon(urlphone);
						 phone= (i10 != null) ? i10.getImage() : null;
						 Image i11=i10.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
							ImageIcon i12 = new ImageIcon(i11);	    
								    
								JLabel phone= new JLabel (i12);
								phone.setBounds(360,20,35,35);
								p1.add(phone);	 
						 
								URL urlmorevert = getClass().getResource("/icons/3icon.png");
								System.out.println("URL for 3icon.png: " + urlmorevert);
								ImageIcon i13 = new ImageIcon(urlmorevert);
								 morevert= (i13 != null) ? i13.getImage() : null;
								 Image i14=i13.getImage().getScaledInstance(10, 25, Image.SCALE_DEFAULT);
									ImageIcon i15 = new ImageIcon(i14);	    
										    
										JLabel morevert= new JLabel (i15);
										morevert.setBounds(420,20,10,25);
										p1.add(morevert);	
	
		JLabel name= new JLabel("Bunty")		;
		name.setBounds(110,15,100,18);
		name.setForeground(Color.WHITE);
		name.setFont((new Font("SAN SERIF", Font.BOLD,18)));
		p1.add(name);
		
		JLabel status= new JLabel("Acitve Now")		;
		status.setBounds(110,35,100,18);
		status.setForeground(Color.WHITE);
		status.setFont((new Font("SAN_SERIF", Font.BOLD,14)));
		p1.add(status);
			
		 a1 = new JPanel();
		a1.setBounds(5,75,440, 570);
		f.add(a1);
		
		 text= new JTextField();
		text.setBounds(5,655,310,40);
		text.setFont(new Font("SAN_SERIF", Font.PLAIN,16));
	f.add(text);
		
		JButton send =new JButton("Send");
		send.setBounds(320,655,123,40);
		send.setBackground(new Color(7,94,84));
		send.setForeground(Color.WHITE);
		send.addActionListener(this);
		send.setFont(new Font("SAN_SERIF", Font.PLAIN,16));
		f.add(send);
		
		
		f.setSize(450,700);
		
		f.setLocation(800, 50 );
		f.setUndecorated(true);
		f.getContentPane().setBackground(Color.WHITE);
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		try {
		String out= text.getText();
		
		JPanel p2 =formatLabel(out);
		
		a1.setLayout(new BorderLayout());
		JPanel right= new JPanel(new BorderLayout());
		right.add(p2, BorderLayout.LINE_END);
		vertical.add(right);
		vertical.add(Box.createVerticalStrut(15));
		a1.add(vertical, BorderLayout.PAGE_START);
		dout.writeUTF(out);
		text.setText("");
		
		f.repaint();
		f.invalidate();
		f.validate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public static JPanel formatLabel(String out) {
		JPanel panel=new JPanel();
	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));	
	JLabel output =new JLabel("<html><p style=\"width:150px\">"+out+"</p></html>");
	output.setFont(new Font("Tahoma", Font.PLAIN,16));
	output.setBackground(new Color(37,211,102));
	output.setOpaque(true);
	output.setBorder(new EmptyBorder(15,15,15,50));
	panel.add(output);
	Calendar cal= Calendar.getInstance();
	SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
			JLabel time =new JLabel();
			time.setText(sdf.format(cal.getTime()));
	panel.add(time)		;
	
	return panel;
		
	}
public static void main(String [] args) {
	new Client();
	try {
		Socket s= new Socket("127.0.0.1", 6002);
		DataInputStream din=new DataInputStream(s.getInputStream())	;
		dout=new DataOutputStream(s.getOutputStream());
		while(true) {
			a1.setLayout(new BorderLayout());
			
			String msg= din.readUTF();
			JPanel panel=formatLabel(msg);
			JPanel left =new JPanel (new BorderLayout());
			left.add(panel,BorderLayout.LINE_START);
		vertical.add(left);
		vertical.add(Box.createVerticalStrut(15));
		a1.add(vertical, BorderLayout.PAGE_START);
		
		f.validate();

			}
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	
}
}
