package engine.view;

import static org.lwjgl.opengl.GL11.GL_POLYGON;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

public class Polygon {
    protected float[] xpoints;
    protected float[] ypoints;
    protected int npoints;
    protected Color[] cpoints;

    public Polygon(float[] xpoints, float[] ypoints, int npoints){
        this.xpoints = xpoints;
        this.ypoints = ypoints;
        this.npoints = npoints;

        this.cpoints = new Color[npoints];
        for(int i = 0; i < cpoints.length; cpoints[i++] = Color.random());
    }

    public void paint(){
        glBegin(GL_POLYGON);
        for(int i = 0; i < npoints; i++){
            setColor(cpoints[i]);
            glVertex2f(xpoints[i], ypoints[i]);
        }
        glEnd();
    }

    public void setColor(Color color){
        glColor3f(color.r, color.g, color.b);
    }
}
