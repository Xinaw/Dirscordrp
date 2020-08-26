package be.xinaw.DRCP;

import java.awt.Color;

import javax.swing.JFrame;

import fr.theshark34.swinger.Swinger;
import fr.theshark34.swinger.util.WindowMover;

public class Main extends JFrame {
	
	private static Main instance;
	private Panele panele;
	
	public Main() {
		this.setTitle("Rich presence perso");
		this.setSize(957, 718);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setBackground(new Color(0, 0, 0));
		this.setUndecorated(true);
		this.setContentPane(panele = new Panele());
		WindowMover mover = new WindowMover(this);
		this.addMouseListener(mover);
		this.addMouseMotionListener(mover);
		
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		Swinger.setSystemLookNFeel();
        Swinger.setResourcePath("/be/xinaw/DRCP/resources/");
		System.out.println("run");
		instance = new Main();
	}
	public static Main getInsstance() {
		return instance;
		}
	public Panele getPanele() {
		return panele;
	}
}
