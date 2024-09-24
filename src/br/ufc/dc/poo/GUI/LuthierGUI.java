package br.ufc.dc.poo.GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class LuthierGUI extends JFrame implements ActionListener {
	JButton button;
	LuthierGUI(){
		ImageIcon music = new ImageIcon("instrumentos.png");
		button = new JButton();
		button.setIcon(music);

		button.setBounds(200, 100, 200, 100);
		button.setText("Testando");
		this.setTitle("Lutheria Gengar");
		this.setVisible(true);
		this.setLayout(null);
		this.setSize(450,450);
		this.getContentPane().setBackground(Color.magenta);
		this.add(button);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			
		}
		
	}
}
