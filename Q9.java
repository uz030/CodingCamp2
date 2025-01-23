import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class CoffeeApp extends JFrame{
	private NorthPanel nPanel = new NorthPanel();
	private SouthPanel sPanel = new SouthPanel();
	private CenterPanel cPanel;
	private int cup = 10;
	private int coffee = 10;
	private int water = 10;
	private int sugar = 10;
	private int cream = 10;
		
	
	public CoffeeApp() {
		setTitle("Open challenge 14");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.add(nPanel, BorderLayout.NORTH);
		c.add(sPanel, BorderLayout.SOUTH);
		cPanel = new CenterPanel(cup,coffee, water, sugar, cream);
		c.add(cPanel, BorderLayout.CENTER);
		setSize(500, 400);
		setVisible(true);
	}
	class NorthPanel extends JPanel{
		JLabel me = new JLabel("Welcome, Hot Coffee !!");
		public NorthPanel() {
			setBackground(Color.MAGENTA);
			me.setSize(10, 100);
			add(me);
		}
	}
	class SouthPanel extends JPanel{ 
		private JButton black = new JButton("Black Coffee");
		private JButton sugarc = new JButton("Sugar Coffee");
		private JButton dabang = new JButton("Dabang Coffee");
		private JButton reset = new JButton("Reset");
		
		public SouthPanel() {
			black.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	if(cPanel.cup == 0 || coffee == 0 || water == 0) {
                		JOptionPane.showMessageDialog(null, "부족한 것이 있습니다. 채워주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                	}
                	else {
                		bc();
                		cPanel.rProgressBars(cup, coffee, water, sugar, cream);
                    
                	}
                }
            });
            add(black);
            
            sugarc.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	if(cup == 0 || coffee == 0 || water ==0 || sugar==0) {
                		JOptionPane.showMessageDialog(null, "부족한 것이 있습니다. 채워주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                	}
                	else {
                		sc();
                		cPanel.rProgressBars(cup, coffee, water, sugar, cream);
                	}
                }
            });
            add(sugarc);
            
            dabang.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	if(cup == 0 || coffee == 0 || cream ==0) {
                		JOptionPane.showMessageDialog(null, "부족한 것이 있습니다. 채워주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                	}
                	else {
                		dc();
                		cPanel.rProgressBars(cup, coffee, water, sugar, cream);
                	}
                }
            });
            add(dabang);
            
            reset.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	r();
                	cPanel.rProgressBars(cup, coffee, water, sugar, cream);
                }
            });
            add(reset);
		}
		
	}
	class CenterPanel extends JPanel{
		private JProgressBar[] jpb = new JProgressBar[5];
		private int cup;
		private int coffee;
		private int water;
		private int sugar;
		private int cream;
		JLabel[]men = new JLabel[5];
		
		 public void rProgressBars(int cup, int coffee, int water, int sugar, int cream) {
		        jpb[0].setValue(cup);
		        jpb[1].setValue(coffee);
		        jpb[2].setValue(water);
		        jpb[3].setValue(sugar);
		        jpb[4].setValue(cream);
		 }
		 
		public CenterPanel(int cup, int coffee, int water, int sugar, int cream) {
			this.cup = cup;
			this.coffee = coffee;
			this.water = water;
			this.sugar = sugar;
			this.cream = cream;
		
			setLayout(null);
			
			men[0] = new JLabel("Cup");
			men[1] = new JLabel("Coffee");
			men[2] = new JLabel("Water");
			men[3] = new JLabel("Sugar");
			men[4] = new JLabel("Cream");
			
			for(int i =0; i<jpb.length; i++) {
				jpb[i] = new JProgressBar(JProgressBar.VERTICAL, 0, 10);
				jpb[i].setSize(55, 120);
				jpb[i].setLocation(50+i*80,15);
				men[i].setSize(100, 20); // 레이블 크기 설정
	            men[i].setLocation(60 + i * 80, 140);
				
			}
			jpb[0].setValue(cup);
			jpb[1].setValue(coffee);
			jpb[2].setValue(water);
			jpb[3].setValue(sugar);
			jpb[4].setValue(cream);
			
			for(int i =0; i<jpb.length; i++) {
				add(jpb[i]);
				add(men[i]);
			}
		}
	}
	public void bc() {
		--cup;
		--coffee;
		--water;
	}
	public void sc() {
		--cup;
		--sugar;
		--coffee;
		--water;
	}
	public void dc() {
		--cup;
		--coffee;
		--cream;
	}
	public void r() {
		cup = 10;
		coffee = 10;
		cream=10;
		sugar = 10;
		water = 10;
	}
	
	public static void main(String[] agrs) {
		CoffeeApp coffeeapp = new CoffeeApp();
	}
}
