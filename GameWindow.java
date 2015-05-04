import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameWindow extends JFrame implements ActionListener{
	private Container contentPane = getContentPane();
	private Input input;
	private Mediator mediator;
	private Canvas canvas;
	
	public GameWindow(Mediator mediator){
		super("Catapilar Game");
		
		this.mediator = mediator;
		this.input = new Input(mediator);
		
		setSize(300, 200);
		this.contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		setLocationRelativeTo(null);	
		setTitleComponents();
	}
	
	public void setTitleComponents(){
		JLabel titleLabel = new JLabel("Catapilar Game");
		JButton startGameButton = new JButton("Start!");
		JButton quitGameButton = new JButton("Quit");
		JPanel titlePanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		startGameButton.addActionListener(this);
		quitGameButton.addActionListener(this);
		
		this.contentPane.removeAll();
		
		titlePanel.add(titleLabel, BorderLayout.CENTER);
		
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.add(startGameButton);
		buttonPanel.add(quitGameButton);
		
		this.contentPane.add(titlePanel);
		this.contentPane.add(buttonPanel);
		
		repaint();
	}
	
	public void setGameComponents(){
		Input input = new Input(this.mediator);
		this.canvas = new Canvas();
		
		contentPane.removeAll();
		contentPane.add(this.canvas);
		
		repaint();
	}
	
	public void setGameOverComponents(){
		JLabel titleLabel = new JLabel("Game Over");
		JButton restartGameButton = new JButton("Restart");
		JButton quitGameButton = new JButton("Quit");
		JPanel titlePanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		restartGameButton.addActionListener(this);
		quitGameButton.addActionListener(this);
		
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.removeAll();
		
		titlePanel.add(titleLabel, BorderLayout.CENTER);
		
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.add(restartGameButton);
		buttonPanel.add(quitGameButton);
		
		contentPane.add(titlePanel);
		contentPane.add(buttonPanel);
		
		repaint();
	}
	
	public Canvas getCanvas(){
		return this.canvas;
	}
	
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		JButton btn = (JButton)obj;
		String labelString = btn.getLabel();
		
		if("Start!".equals(labelString) || "Restart".equals(labelString)){
			setGameComponents();
		}
		else if("Quit".equals(labelString)){
			System.exit(0);
		}
	}
}
