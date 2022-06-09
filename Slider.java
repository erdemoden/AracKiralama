package Patika;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Slider {
	
	JPanel mPanel;
	JPanel fPanel;
	JButton btnFGiris;
	JButton btnMGiris;
	boolean clickonce = true;
	public Slider(JPanel mPanel, JPanel fPanel, JButton btnFGiris, JButton btnMGiris) {
		
		this.mPanel = mPanel;
		this.fPanel = fPanel;
		this.btnFGiris = btnFGiris;
		this.btnMGiris = btnMGiris;
	}


	public void slideMPanel() {
		if(mPanel.getBounds().x !=0 && clickonce == true) {
			clickonce = false;
			btnFGiris.setEnabled(false);
		final Timer timer = new Timer();
		
		TimerTask gorev = new TimerTask() {
			@Override
			public void run() {
				if(fPanel.getBounds().x!=-350) {
				fPanel.setBounds(fPanel.getBounds().x-10,fPanel.getBounds().y,fPanel.getBounds().width,fPanel.getBounds().height);
				}
				mPanel.setBounds(mPanel.getBounds().x+10,mPanel.getBounds().y,mPanel.getBounds().width,mPanel.getBounds().height);
				if(mPanel.getBounds().x ==0) {
					btnFGiris.setEnabled(true);
					timer.cancel();
					clickonce = true;
				}
			}
			
		};
		
		timer.schedule(gorev,0,45);
		
		}
		
	}
	public void slideFPanel() {
		if(fPanel.getBounds().x !=0 && clickonce == true) {
			clickonce = false;
			btnMGiris.setEnabled(false);
		final Timer timer = new Timer();
		
		TimerTask gorev = new TimerTask() {
			@Override
			public void run() {
				if(mPanel.getBounds().x!=-350) {
				mPanel.setBounds(mPanel.getBounds().x-10,mPanel.getBounds().y,mPanel.getBounds().width,mPanel.getBounds().height);
				}
				fPanel.setBounds(fPanel.getBounds().x+10,fPanel.getBounds().y,fPanel.getBounds().width,fPanel.getBounds().height);
				if(fPanel.getBounds().x ==0) {
					btnMGiris.setEnabled(true);
					timer.cancel();
					clickonce = true;
					
				}
			}
			
		};
		
		timer.schedule(gorev,0,45);
		
		}
	}
	}
	


