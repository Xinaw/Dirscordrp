package be.xinaw.DRCP;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.theshark34.swinger.Swinger;
import fr.theshark34.swinger.event.SwingerEvent;
import fr.theshark34.swinger.event.SwingerEventListener;
import fr.theshark34.swinger.textured.STexturedButton;

public class Panele extends JPanel implements SwingerEventListener {
	
	private JTextField FL = new JTextField();
	private JTextField SL = new JTextField();
	private JTextField AID = new JTextField();
	private JTextField NI = new JTextField();
	
	private STexturedButton LB = new STexturedButton(Swinger.getResource("launchbutton.png"));
	private STexturedButton PB = new STexturedButton(Swinger.getResource("pauseButton.png"));
	private STexturedButton RB = new STexturedButton(Swinger.getResource("reloadButton.png"));
	private STexturedButton SB = new STexturedButton(Swinger.getResource("StopButton.png"));
	private STexturedButton QB = new STexturedButton(Swinger.getResource("minimize.png"));
	private STexturedButton MB = new STexturedButton(Swinger.getResource("close.png"));
	
	private Image background = Swinger.getResource("RPC2.png");
	
	public Panele() {
		this.setLayout(null);
		
		FL.setForeground(Color.WHITE);
		FL.setFont(FL.getFont().deriveFont(20F));
		FL.setCaretColor(Color.WHITE);
		FL.setOpaque(false);
		FL.setBorder(null);
		FL.setBounds(202, 146, 210, 24);
		this.add(FL);
		
		SL.setForeground(Color.WHITE);
		SL.setFont(FL.getFont().deriveFont(20F));
		SL.setCaretColor(Color.WHITE);
		SL.setOpaque(false);
		SL.setBorder(null);
		SL.setBounds(202, 199, 210, 24);
		this.add(SL);
		
		AID.setForeground(Color.WHITE);
		AID.setFont(FL.getFont().deriveFont(20F));
		AID.setCaretColor(Color.WHITE);
		AID.setOpaque(false);
		AID.setBorder(null);
		AID.setBounds(202, 234, 210, 24);
		this.add(AID);
		
		NI.setForeground(Color.WHITE);
		NI.setFont(FL.getFont().deriveFont(20F));
		NI.setCaretColor(Color.WHITE);
		NI.setOpaque(false);
		NI.setBorder(null);
		NI.setBounds(203, 269, 210, 24);
		this.add(NI);
		
		LB.setBounds(213, 304, 27, 27);
		LB.addEventListener(this);
		this.add(LB);
		
		PB.setBounds(240, 304, 27, 27);
		PB.addEventListener(this);
		this.add(PB);
		
		RB.setBounds(272, 304, 27, 27);
		RB.addEventListener(this);
		this.add(RB);
		
		SB.setBounds(304, 304, 27, 27);
		SB.addEventListener(this);
		this.add(SB);
		
		MB.setBounds(920, 0);
		MB.addEventListener(this);
		this.add(MB);
		
		QB.setBounds(883, 0);
		QB.addEventListener(this);
		this.add(QB);
		
	}
	
	@Override
	public void onEvent(SwingerEvent e) {
		if(e.getSource() == LB) {
			Client.getInstancee().init();
			Client.getInstancee().getDiscordRP().update(FL.getText(), SL.getText());
		} else if(e.getSource() == QB) {
			Main.getInsstance().setState(JFrame.ICONIFIED);
		} else if(e.getSource() == MB) {
			Client.getInstancee().shutdown();
			System.exit(0);
		} else if(e.getSource() == SB) {
			Client.getInstancee().shutdown();
		} else if(e.getSource() == PB) {
			Client.getInstancee().shutdown();
		} else if(e.getSource() == RB) {
			Client.getInstancee().getDiscordRP().update(FL.getText(), SL.getText());
		}
		
		
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
	public String getID() {
		return AID.getText();
	}
	
	public String getNameOfImage() {
		return NI.getText();
	}
	
	public String getFirstLine() {
		return FL.getText();
	}
	
	public String getSecondLine() {
		return SL.getText();
	}


}
