import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ImageViewer //implements ActionListener
{

	private JFrame frame;

	public ImageViewer()
	{
		makeFrame();
	}

	private void makeFrame()
	{
		frame = new JFrame("ImageViewer");

    Container contentPane = frame.getContentPane();

		JLabel label = new JLabel("I am a label");
		contentPane.add(label);

		makeMenuBar();

		frame.pack();
		frame.setVisible(true);
	}

	private void makeMenuBar()
	{
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		JMenu fileHelp = new JMenu("Help");
		menuBar.add(fileHelp);

		JMenuItem openItem = new JMenuItem("Open");
		fileMenu.add(openItem);
		openItem.addActionListener(new OpenActionListener());
																		//tells this particular button about
																		//what object it's listening for this event.

		JMenuItem saveItem = new JMenuItem("Save");
		fileMenu.add(saveItem);
		saveItem.addActionListener(new SaveActionListener());

		JMenuItem quitItem = new JMenuItem("Quit");
		fileMenu.add(quitItem);
		quitItem.addActionListener(new ActionListener() //anonymous class
															{
																public void actionPerformed(ActionEvent event)
																{
																	quitFile();
																}
															} );
	}
/*
	public void actionPerformed(ActionEvent event)
	{
		String command = event.getActionCommand();

		//System.out.println("Item: " + command);
		if(command.equals("Open"))
		{
			openFile();
		}
		else if(command.equals("Save"))
		{
			saveFile();
		}
		else if(command.equals("Quit"))
		{
			quitFile();
		}
		else
		{
			System.out.println("I don't know what to do with this command.");
		}
	}
*/
	private void openFile()
	{
		System.out.println("The file is being opened.");
	}

	private void saveFile()
	{
		System.out.println("The file is being saved.");
	}

	private void quitFile()
	{
		System.out.println("The file is being closed.");
		System.exit(0);
	}

	public static void main(String[] args)
	{
		ImageViewer mine = new ImageViewer();
	}

	class OpenActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			openFile();
		}
	}

	class SaveActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			saveFile();
		}
	}

	//inner class that executes quit

}
