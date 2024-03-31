package engine.geometric;

import engine.utils.Updatable;

public class Triangle extends engine.view.Triangle implements Updatable {

    private Vertice[] vertices;

    private Vector3 center;

    private boolean visible;

    public Triangle(Vertice v1, Vertice v2, Vertice v3) {
        super(new float[3], new float[3]);
        this.vertices = new Vertice[]{
            v1,
            v2,
            v3
        };
        this.center = new Vector3();
        this.visible = false;
    }

    public boolean isVisible() {
        return visible;
    }

    public Vector3 getCenter() {
        return center;
    }

    @Override
    public void paint() {
        if (visible) {
            super.paint();
        }
    }
    
    @Override
    public void update() {
        for (int i = 0; i < 3; i++) {
            this.xpoints[i] = (float)vertices[i].xscreen;
            this.ypoints[i] = (float)vertices[i].yscreen;
        }
        reloadVisibility();
    }

    private void reloadVisibility() {
        this.visible = vertices[0].visible || vertices[1].visible || vertices[2].visible;
    }

}
