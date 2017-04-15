import java.awt.*; //import awt for buttons, background
import java.awt.event.*; //import event for action on button

/*
 * The main class. It creates a Framegenerator object,
 * sets it to be visible and of size 400 x 400
*/
class ButtonOnFrame{
	public static void main(String[] args) {
		FrameGenerator f = new FrameGenerator("Black and Blue");
		f.setVisible(true);
		f.setSize(400,400);
	}
}

/*
 * The frame generator that extends Frame and implements ActionListener
*/
class FrameGenerator extends Frame implements ActionListener{
	FrameGenerator(String title){
		super(title); //must be the first line of the constructor

		setLayout(new FlowLayout()); //need to set a layout to make the buttons appear properly

		//creating two buttons
		Button blackButton = new Button("BLACK");
		Button blueButton = new Button("BLUE");

		//adding action listeners to each button
		blackButton.addActionListener(this);
		blueButton.addActionListener(this);

		//adding the buttons to the frame
		add(blackButton);
		add(blueButton);

		//window listener to close the frame when x button on the title bar is pressed.
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});
	}

	//handle the event when buttons are pressed
	public void actionPerformed(ActionEvent ae){
		
		/*
		 * get the name of the button which we used
		 * for example:
		 * Button blackButton = new Button("BLACK");
		 * the name we get is BLACK if the above button is pressed.
		*/
		String buttonStr = ae.getActionCommand();

		//compare the obtained string.
		if(buttonStr.equals("BLACK")){
			setBackground(Color.black); //set frame background to black
		} else {
			setBackground(Color.blue);//set frame background to blue
		}
	}
}