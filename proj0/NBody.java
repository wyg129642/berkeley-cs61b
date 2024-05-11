public class NBody {
    public static double readRadius(String address){
        In in = new In(address);
        int number = in.readInt();
        double radius = in.readDouble();
        return radius;

    }
    public static Planet[] readPlanets(String address){
        In in = new In(address);
        int number = in.readInt();
        double radius = in.readDouble();
        Planet[] planets = new Planet[number];
        for (int i=0;i<number;i++){
            planets[i] =new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
        
        }
        return planets;
    }
    public static void main(String[] args) {
        double T =Double.parseDouble(args[0]);
        double dt= Double.parseDouble(args[1]);
        String filename = args[2];
        readPlanets(filename);
        double radius=readRadius(filename);
        StdDraw.setScale(-radius, radius);

        StdDraw.picture(-10,10,"images/starfield.jpg");
        Planet[] allPlanets= readPlanets(filename);
        int number = allPlanets.length;
        for (int i=0; i<number; i++){
            allPlanets[i].draw();
        }
        double t=0;
        while (t< T){
            StdDraw.enableDoubleBuffering();
            double[] xForces =new double[number];
            for (int i=0; i< number; i++ ){
                xForces[i]= allPlanets[i].calcNetForceExertedByX(allPlanets);

            }
            double[] yForces =new double[number];
            for (int i=0; i< number; i++ ){
                yForces[i]= allPlanets[i].calcNetForceExertedByY(allPlanets);

            }
            for (int i =0; i< number; i++){
                allPlanets[i].update(dt, xForces[i], yForces[i]);
                
                

            }
            StdDraw.setScale(-radius, radius);

            StdDraw.picture(-10,10,"images/starfield.jpg");
            for (int i =0; i< number; i++){
                allPlanets[i].draw();

            }
            StdDraw.show();
            StdDraw.pause(10);
            
            

            t+=dt;


        }
        StdOut.printf("%d\n", allPlanets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < allPlanets.length; i++) {
        StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
        allPlanets[i].xxPos, allPlanets[i].yyPos, allPlanets[i].xxVel,
        allPlanets[i].yyVel, allPlanets[i].mass, allPlanets[i].imgFileName);   
}
    }
}
