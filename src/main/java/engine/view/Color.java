package engine.view;

public class Color {
    public float r;
    public float g;
    public float b;

    public Color(float r, float g, float b){
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public static Color random(){
        return new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
    }
}
