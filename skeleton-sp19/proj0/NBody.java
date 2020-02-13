public class NBody{
	public static int readNumber(String name){
			In in = new In(name);
			int number = in.readInt();
			return number;
	}


	public static double readRadius(String name){
			In in = new In(name);
			int number = in.readInt();
			double radius = in.readDouble();
			return radius;
	}

	public static Body[] readBodies(String name){
		In in = new In(name);
		int number = in.readInt();
		double radius = in.readDouble();
		Body[] bodys = new Body[number];
		for (int i = 0; i<number; i++){
			double xP = in.readDouble();
			double yP = in.readDouble();
			double xV = in.readDouble();
			double yV = in.readDouble();
			double m = in.readDouble();
			String img = in.readString();
			bodys[i] = new Body(xP, yP, xV, yV, m, img);
			}
		return bodys;
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename =  args[2];
		int number = readNumber(filename);
		double radius = readRadius(filename);
		Body[] bodys = readBodies(filename);
		StdDraw.setScale(-radius*2, radius*2);
		StdDraw.clear();
		StdDraw.picture(0, 0,"images/starfield.jpg");
		for (int i=0; i<bodys.length; i++){
			bodys[i].draw();
		}
		StdDraw.enableDoubleBuffering();
		double[] xForces = new double[number];
		double[] yForces = new double[number];
		for (double t=0; t<=T; t=t+dt ){
			for (int i=0; i<number ;i++ ) {
			xForces[i] = bodys[i].calcNetForceExertedByX(bodys);
			yForces[i] = bodys[i].calcNetForceExertedByY(bodys);
			bodys[i].update(dt, xForces[i], yForces[i]);
			StdDraw.picture(0, 0,"images/starfield.jpg");
			for (int j=0; j<number; j++ ){
				bodys[j].draw();
			}
			StdDraw.show();
			StdDraw.pause(10);	
			}			
		}
		StdOut.printf("%d\n", bodys.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < bodys.length; i++) {
        StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            bodys[i].xxPos, bodys[i].yyPos, bodys[i].xxVel,
				bodys[i].yyVel, bodys[i].mass, bodys[i].imgFileName);
        }
	}
}