// replace this with your name
// Section 10
// Quiz 2

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class quiz2 extends JApplet {

    public void init() {

	// setup the applet window
	Container window = getContentPane();
	window.setLayout(new FlowLayout());

	// create the interactive buttons and text field
	JButton left = new JButton("left");
	left.setBackground(Color.green);
	JButton right = new JButton("right");
	right.setBackground(Color.red);
	JLabel msg = new JLabel("Push the Green Button");
	msg.setOpaque(true);

	// add the buttons to the applet window
	window.add(left);
	window.add(msg);
	window.add(right);

	// create tracker
	Tracker tr = new Tracker(msg);

	// create listeners
	Listener leftList = new Listener(1,tr,left,right);
	Listener rightList = new Listener(2,tr,right,left);
	
	// add listeners to the buttons
	left.addActionListener (leftList);
	right.addActionListener (rightList);

	
        } // end of init method

    } // end of quiz2 class

class Listener implements ActionListener {

    // properties
    private final int which;
    private final Tracker theTracker;
    private final JButton myButton;
    private final JButton otherButton;

    public Listener (int w, Tracker t, JButton b, JButton c) {
	which = w;
	myButton = b;
	otherButton = c;
	theTracker = t;

	} // end of constructor

    public void actionPerformed (ActionEvent event) {
	theTracker.buttonPushed(which, myButton, otherButton);

	} // end of actionPerformed method
    
    } // end of listener class
    
class Tracker {

    // properties
    private final JLabel msg;
    private boolean leftClicked = false;
    private boolean rightClicked = true;

    public Tracker(JLabel m) {
	msg = m;
	} // end of constructor

    public void buttonPushed (int whichOne, JButton theButton, JButton
	    otherButton) {

	if (whichOne == 1 && rightClicked == true) {
	    leftClicked = true;
	    rightClicked = false;
	    theButton.setBackground(Color.red);
	    otherButton.setBackground(Color.green);	
	    msg.setText("great, push the green button again");

	    }
	else if (whichOne == 1 && leftClicked == true) {
	    msg.setText("oops, push the GREEN button!");

	    }
	else if (whichOne == 2 && leftClicked == true) {
	    leftClicked = false; 
	    rightClicked = true;
	    theButton.setBackground(Color.red);
	    otherButton.setBackground(Color.green);
	    msg.setText("great, push the green button again");

	    }
	else {
	    msg.setText("oops, push the GREEN buttion!");

	    }

	} // end buttonPushed method

    } // end tracker Class
