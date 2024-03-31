package engine.view;

import static org.lwjgl.opengl.GL11.GL_POLYGON;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;

import java.util.List;

import engine.component.Mesh;
import engine.scene.GameScene;
import engine.utils.Updatable;

public class Canvas implements Updatable {
    
    public static int width;

    public static int height;
    
    private List<Mesh> meshs;

    protected Canvas(GameScene gameScene) {
        this.meshs = Mesh.MESHS;
    }
    
    @Override
    public void update() {
        draw();
    }
    
    private void draw() {
        meshs.forEach(mesh -> {
            if (mesh.isActive()) {
                mesh.triangles.forEach(triangle -> {
                    triangle.paint();
                });
            }
        });
    }
}
