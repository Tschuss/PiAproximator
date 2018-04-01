import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MontecarloDrown extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final double SIZE= 400.0;
	int size;
	double pi;
	double circulo=0.0;
	double cuadrado=0.0;
	double x,y=0.0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MontecarloDrown md= new MontecarloDrown();
		md.init();
	}
	
	private void init() {
		
		size=(int) Math.round(SIZE);
		
		JFrame frame = new JFrame("Montecarlo PI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
		for(long i=0;i<=Long.MAX_VALUE;i++) {
			repaint();
			if (i%10000000==0){
				System.out.println("PI("+i+")>>"+4*circulo/cuadrado);
			}
		}
		System.out.println("PI>>"+4*circulo/Double.MAX_VALUE);

	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(size, size);
	}
	
	protected void paintComponent(Graphics g) {
		//dibujamos el circulo en negro
//		g.setColor(Color.WHITE);
//		g.fillRect(0, 0, size, size);
//		g.setColor(Color.BLACK);
//		g.drawArc(0,0, size, size, 0, 360);
		

		x=Math.random();
		y=Math.random();
		cuadrado++;
		if (Math.sqrt(Math.pow(x,2.0)+Math.pow(y,2.0))<=1.0) {
			circulo++;
			g.setColor(Color.RED);
		} else {
			g.setColor(Color.BLUE);
			
		}
		int xx=(int)Math.round(x*SIZE);
		int yy=(int)Math.round(y*SIZE);
		g.drawLine(xx, yy, xx, yy);
	//	System.out.println("("+xx+","+yy+") >> PI="+4*circulo/cuadrado);
	}
}
