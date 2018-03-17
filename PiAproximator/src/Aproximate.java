
public class Aproximate {

	public static void main(String[] args) {
		PiAproxByRiemannIntegration();
	}
	
	public static void Montecarlo() {
		double pi;
		double circulo=0.0;
		//StringBuffer trace=new StringBuffer();
		long start=System.currentTimeMillis();
		for(long cuadrado=0;cuadrado<=Long.MAX_VALUE;cuadrado++) {

			if (Math.sqrt(Math.pow(Math.random(),2.0)+Math.pow(Math.random(),2.0))<=1.0) {
				circulo++;
			}

			if (cuadrado%1000000==1) {
				pi=4*circulo/cuadrado;
								
				System.out.println(pi);
			} //if
		}//for
		long end=System.currentTimeMillis();

		System.out.println((end-start)/1000+"s>>"+4*circulo/Double.MAX_VALUE);
	}
	

	
	public static void aproximaAreaPoligoPorTriangulosRectangulos() {

		double lado=1;//Math.sqrt(2.0)/2.0;
		double area, area_ant=0, delta, base;
		for (long nl=4; nl<Long.MAX_VALUE;nl=nl*2 ) {

			area=nl*lado/2.0;
			delta=(area-area_ant)/nl;
			base=2*delta/lado;
			
			
			lado=Math.sqrt(Math.pow(base,2.0)+Math.pow(lado, 2.0))/2.0;
			
			area_ant=area;
			System.out.println("l="+lado+ "\t pi="+area);

		}
		
	}
	
	public static void cuadradosinversosLeibniz() {
		double picuartos=0.0;
		for (long n=0;n<Long.MAX_VALUE;n++) {
			picuartos=picuartos+(Math.pow(-1.0, n)/(1.0+2.0*n));
			System.out.println(picuartos*4);
		}
	}
	
		public static void PiAproxByLeibnizFormulaOptimized () {
			
			double pi=0.0;
			double D=0.0;
			double zoom=1.0;
			String Pi="";
			for (double n =0.0;n<Double.MAX_VALUE;n=n+1.0) {
				D=zoom*(4.0*Math.pow(-1.0,n)/(1+2.0*n));
				pi=pi+D;
			//	System.out.print("D="+D+"\tpi="+pi);
				if (Math.abs(D)<0.1) {
					Pi=Pi+String.valueOf(pi).substring(0,1);
					System.out.println("\tPi="+Pi);
					
					pi=(pi-Math.floor(pi))*10.0;
					zoom=zoom*10.0;
				} else {
					//System.out.println();
				}
				if (Pi.length()==1) Pi+=".";
			}
			
		}
		
		public static void PiAproxByBinPowPoligonsPerimeter() {
			
			double radio=1.0;
			double n=2.0;

			double H=2.0*radio;
			double Hn=H;
			double L=n*H;
			double D=0.0;

			double pi=L/(2.0*radio);
			
			double Ln=0.0;
			String pis="";
			double zoom=1.0;
			
			System.out.println("n="+n+"\tH="+H+"\tHn="+Hn+"\tD="+D+"\tL="+L+"\tpi="+pi);
			while (n<Double.MAX_VALUE) {
				n=n*2.0;
				//Hn=Math.sqrt(2.0-Math.sqrt(4.0-Math.pow(H, 2.0)));
				Hn=Math.sqrt(2.0*Math.pow(radio,2.0)-2.0*radio*Math.sqrt(Math.pow(radio,2.0)-(Math.pow(H,2.0)/4.0)));

				D=Hn-(H/2.0);
				Ln=L+D*n;
				pi=zoom*Ln/(2.0*radio);
				System.out.print("H="+H+"\tHn="+Hn+"\tD="+D+"\tLn="+Ln+"\tpi="+pi);
				
//				if(String.valueOf(L).substring(0,2).equals(String.valueOf(Ln).substring(0,2))){
				if(Hn<0.1) {
					pis=pis+String.valueOf(pi).substring(0,1);
					Hn=Hn*10.0;
					radio=radio*10.0;
					zoom=zoom*10.0;
					Ln=10.0*(Ln-Math.floor(Ln));
					System.out.println("\tpis="+pis);
				} else {
					System.out.println();
				}
				L=Ln;
				H=Hn;
				if (H==0) {
					System.out.println("H se hace cero, salimos por la fuerza.");
					break;
				}
				if (pis.length()==1) pis=pis+".";
			}
		}
		
		public static void PiAproxByBinPowPoligonsArea() {
			double n=2.0;
			double A=0.0;
			double An=0.0;
			double H=2.0;
			double Hn=0.0;
			String pi="";
			double radio=1.0;
			while (n<Double.MAX_VALUE) {
				n=n*2.0;
			
				An=A+(n/2.0)*(H/2.0)*(radio-Math.sqrt(Math.pow(radio,2.0)-(Math.pow(H,2.0)/4.0)));
				Hn=Math.sqrt(2.0*Math.pow(radio,2.0)-2.0*radio*Math.sqrt(Math.pow(radio,2.0)-(Math.pow(H,2)/4)));
				
				System.out.println("H="+H+"\tHn="+Hn+"\tA="+A+"\tAn="+An+"\tpi="+pi);

				if (Math.floor(A*10.0)==Math.floor(An*10.0)) {
					double valA=Math.floor(A);
					double valH=Math.floor(H);
					An=(An-valA)*10.0;
					Hn=(Hn-valH)*10.0;
					radio=radio*10.0;
					//Guardamos un nuevo caracter de pi	
					pi=pi+String.valueOf(A).substring(0,1);
				}		
				
				A=An;
				H=Hn;
				
				// condiciones de salida
				if (H==0) break;
				if (pi.length()==1) pi+=".";
			}
		}


		public static void PiAproxByBinPowPoligonsArea2() {
			double n=2.0;
			double A=0.0;
			double An=0.0;
			double Hn=0.0;
			double D=0.0;
			String pi="";
			double radio=1.0;
			double H=2.0;
			while (n<Double.MAX_VALUE) {
				n=n*2.0;
				D=(n/2.0)*(H/2.0)*(radio-Math.sqrt(Math.pow(radio,2.0)-(Math.pow(H,2.0)/4.0)));
				An=A+D;
				Hn=Math.sqrt(2.0*Math.pow(radio,2.0)-2.0*radio*Math.sqrt(Math.pow(radio,2.0)-(Math.pow(H,2.0)/4.0)));

				System.out.println("n="+n+"\tH="+H+"\tHn="+Hn+"\tA="+A+"\tD="+D+"\tAn="+An+"\tpi="+pi);
		
				if (Math.floor(A*10.0)==Math.floor(An*10.0)) {
					double valA=Math.floor(A);
					double valH=Math.floor(H);
					An=(An-valA)*100.0;
					Hn=(Hn-valH)*10.0;
					radio=radio*10.0;
					//Guardamos un nuevo caracter de pi	
					pi=pi+String.valueOf(A).substring(0,1);
				}
				
				A=An;
				H=Hn;
				
				if (pi.length()==1) pi+=".";
				// condiciones de salida
				if (H==0) {
					System.err.println("H se hace cero patatero!!!!");
					break;
				}
			
			}
		}




		public static void PiAproxByRiemannIntegration() {
			
			double pi_ant=0;
			for (double n=2.0;n<Double.MAX_VALUE;n=n*2) {
				
				double Ai=0.0;
				double As=0.0;
				long t0=System.currentTimeMillis();
				for (int i=0;i<=n;i++){
					if (i>0){
						Ai=Ai+(1.0/n)*Math.sqrt(1.0-Math.pow(((double)i)*(1.0/n),2.0));
					}
					if (i<n) {
						As=As+(1.0/n)*Math.sqrt(1.0-Math.pow(((double)i)*(1.0/n),2.0));
					}
				}
				double pi = 4.0*(Ai+As)/2.0;
				if (pi==pi_ant) {
					System.out.println("Alcanzada maxima precision");
					break;
				} else {
					pi_ant=pi;
				}			
				
				//pretty printing
				String timeF="";
				long time=System.currentTimeMillis()-t0;
				timeF=""+time%1000;
				time=time/1000;
				timeF=time%60+"."+timeF;
				time=time/60;
				timeF=time%60+":"+timeF;
				time=time/60;
				timeF=time%24+":"+timeF;
				time=time/24;
				
				
				
				System.out.println("pi("+n+")=\t"+pi+"\t en "+timeF);
				
			}
		}
	}


