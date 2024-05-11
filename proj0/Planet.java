public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static double gravitational_constant=6.67e-11;
    public Object draw;
    public Planet(double xP, double yP, double xV,
              double yV, double m, String img){
                this.xxPos=xP;
                this.yyPos=yP;
                this.xxVel= xV;
                this.yyVel=yV;
                this.mass=m;
                this.imgFileName=img;

              }
    public Planet(Planet p){
        this.xxPos=p.xxPos;
        this.yyPos=p.yyPos;
        this.xxVel=p.xxVel;
        this.yyVel=p.yyVel;
        this.mass=p.mass;
        this.imgFileName=p.imgFileName;
        
    }
    public double calcDistance(Planet p){
        return Math.sqrt((this.xxPos-p.xxPos)*(this.xxPos-p.xxPos)+(this.yyPos-p.yyPos)*(this.yyPos-p.yyPos));
    }
    public double calcForceExertedBy(Planet p){
        return gravitational_constant*p.mass*this.mass/(calcDistance(p)*calcDistance(p)); 

    }
    public double calcForceExertedByX(Planet p){
        return this.calcForceExertedBy(p)*(p.xxPos-this.xxPos)/calcDistance(p);
    }
    public double calcForceExertedByY(Planet p){
        return this.calcForceExertedBy(p)*(p.yyPos-this.yyPos)/calcDistance(p);
    }
    public double calcNetForceExertedByX(Planet[] allPlanets){
        double x=0;
        for (int i=0; i<allPlanets.length;i++){
            if (this.equals(allPlanets[i])){
                continue;
            }else{
                x=x+this.calcForceExertedByX(allPlanets[i]);

            }
        }
        return x;
    }
    public double calcNetForceExertedByY(Planet[] allPlanets){
        double y=0;
        for (int i=0; i<allPlanets.length;i++){
            if (this.equals(allPlanets[i])){
                continue;
            }else{
                y=y+this.calcForceExertedByY(allPlanets[i]);

            }
        }
        return y;
    }
    
    public void update(double dt, double fX, double fY){
     this.xxVel=this.xxVel+dt*fX/this.mass;
     this.xxPos=this.xxPos+this.xxVel*dt;
     this.yyVel=this.yyVel+dt*fY/this.mass;
     this.yyPos=this.yyPos+this.yyVel*dt;
    }
    private void draw(){
        StdDraw.picture(this.xxPos,this.yyPos, "images/"+this.imgFileName);
    }
    public void publicdraw(){
        draw();
    }
}
