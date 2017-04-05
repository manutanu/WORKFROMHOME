import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

class DemoAction extends JFrame {

	Container c;
	//JButton red;
	//JButton black;
	//JButton blue;
	JLabel jl;
        
public	DemoAction(String mssg){
	c=this.getContentPane();
        jl=new JLabel(mssg);
	c.setLayout(null);
        c.add(jl);
        c.setBackground(Color.RED);
        jl.setBounds(100,20,200,50);
        /*red=new JButton("RED");
	black=new JButton("BLACK");
	blue=new JButton("BLUE");
	
	c.add(red);
	c.add(black);
	c.add(blue);
	
	red.setBounds(100,170,100,50);
	blue.setBounds(220,170,100,50);
	black.setBounds(340,170,100,50);
	
	red.addActionListener(this);
	black.addActionListener(this);
	blue.addActionListener(this);
	
	}
public void actionPerformed(ActionEvent e) {
	
	if(e.getSource()==red){
		c.setBackground(Color.RED);
	}
	if(e.getSource()==blue){
		c.setBackground(Color.BLUE);
	}
	if(e.getSource()==black){
		c.setBackground(Color.BLACK);
	}
         * 
         */
}
}

public class ColorChange {

	public static void main(String[] args) {
	//	  DemoAction da=new DemoAction("hellow");
	//	da.setVisible(true);
	//	da.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	da.setBounds(900,620,500,150);
	}
}
