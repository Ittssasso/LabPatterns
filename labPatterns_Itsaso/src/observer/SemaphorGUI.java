package observer;

import java.awt.Color;
import java.awt.Frame;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import domain.Covid19Pacient;


public class SemaphorGUI extends JFrame implements Observer{

	public SemaphorGUI(Observable obs) {
		setSize(100, 100);
		setLocation(350,10);
		Color c=Color.green;
		getContentPane().setBackground(c);
		repaint();
		setVisible(true);
		obs.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		Covid19Pacient p=(Covid19Pacient)o;		
		int farenheit = (int) p.covidImpact();
		Color c;
		if(farenheit < 5) {
			 c= Color.green;
			getContentPane().setBackground(c);
		}else if (5 <= farenheit && farenheit< 10) {
			c=Color.yellow;
			getContentPane().setBackground(c);	
		}else if(farenheit >10) {
			c=Color.red;
			getContentPane().setBackground(c);
		}
	}
	
}     

