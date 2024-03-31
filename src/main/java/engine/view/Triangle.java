package engine.view;

public class Triangle extends Polygon {

    public Triangle(float[] xpoints, float[] ypoints){
        super(xpoints, ypoints, 3);
    }

    public Triangle(){
        this(new float[3], new float[3]);
    }
}
