
public class Aproximate {

	public static void main(String[] args) {
		double x,y,d,pi;
		double circulo=0.0;
		//StringBuffer trace=new StringBuffer();
		long start=System.currentTimeMillis();
		for(int cuadrado=0;cuadrado<=Double.MAX_VALUE;cuadrado++) {
			x=Math.random();
			y=Math.random();
			d=Math.sqrt(Math.pow(x,2.0)+Math.pow(y,2.0));
			if (d<=1.0) {
				circulo++;
			}

			if (cuadrado%10000000==1) {
				pi=4*circulo/cuadrado;
						
				/*
				trace.delete(0, trace.length());		
				trace.append(i);
				trace.append("\t");
				trace.append(x);
				trace.append("\t");
				trace.append(y);
				trace.append("\t");
				trace.append(d);
				trace.append("\t");
				trace.append(circulo);
				trace.append("\t");
				trace.append(cuadrado);
				trace.append("\t");
				trace.append(pi);	
				System.out.println(trace.toString());
*/				
				System.out.println(pi);
			} //if
		}//for
		long end=System.currentTimeMillis();

		System.out.println((end-start)/1000+"s>>"+4*circulo/Double.MAX_VALUE);
	}
}
