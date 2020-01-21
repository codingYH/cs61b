public class Body{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	String imgFileName;
	private static double G = 6.67*Math.pow(0.1, 11);

	public Body(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	
    public Body(Body b){
    	xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
    }

    public double calcDistance(Body b){
    	double dx_2 = Math.pow(xxPos-b.xxPos, 2);
    	double dy_2 = Math.pow(yyPos-b.yyPos, 2);
    	double r = Math.sqrt(dx_2+dy_2);
    	return r;
    }
    public double calcForceExertedBy(Body b){
    	double r_2 = Math.pow(calcDistance(b), 2);
    	double force = G*mass*b.mass/r_2;
    	return force;
    }
    public double calcForceExertedByX(Body b){
    	double dx = b.xxPos-xxPos;
    	double forceX = calcForceExertedBy(b)*dx/calcDistance(b);
    	return forceX;
    }
    public double calcForceExertedByY(Body b){
    	double dy = b.yyPos-yyPos;
    	double forceY = calcForceExertedBy(b)*dy/calcDistance(b);
    	return forceY;
    }
    public double calcNetForceExertedByX(Body[] bodys){
    	double netForceX = 0;
    	for(int i =0; i < bodys.length; i++){
    		if(this.equals(bodys[i])){
    			continue;
    		}
    			netForceX = netForceX+calcForceExertedByX(bodys[i]);
    		}
    	return netForceX;
    	}
    	

    public double calcNetForceExertedByY(Body[] bodys){
    	double netForceY = 0;
    	for(int i =0; i < bodys.length; i++){
    		if(this.equals(bodys[i])){
    			continue;
    		}
    		netForceY = netForceY+calcForceExertedByY(bodys[i]);
    	}
    	return netForceY;
    }
    public void update(double period, double fx, double fy){
    	double ax = fx/mass;
    	double ay = fy/mass;
    	double xVelNew = xxVel+ax*period;
    	double yVelNew = yyVel+ay*period;
    	xxPos = xxPos+xVelNew*period;
    	yyPos = yyPos+yVelNew*period;
    	xxVel = xVelNew;
    	yyVel = yVelNew;
    }
    public void draw(){
    	// StdDraw.setScale(xxPos,yyPos);
    	// StdDraw.clear();
    	StdDraw.picture(xxPos,yyPos,"images/"+imgFileName);
    }
}
