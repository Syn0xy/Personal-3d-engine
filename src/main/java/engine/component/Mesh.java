package engine.component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import engine.file.FileTranslatorOBJ;
import engine.geometric.Triangle;
import engine.geometric.Vertice;

public class Mesh extends Component {

    public static final List<Mesh> MESHS = new CopyOnWriteArrayList<>();

    public List<Vertice> vertices;

    public List<Triangle> triangles;

    public Mesh(List<Vertice> vertices, List<Triangle> triangles) {
        this.vertices = vertices;
        this.triangles = triangles;

        Mesh.MESHS.add(this);
    }

    public Mesh() {
        this(new ArrayList<>(), new ArrayList<>());
    }
    
    @Override
    public void update() {
        if (active) {
            vertices.forEach(vertice -> {
                vertice.update(Camera.mainCamera);
            });
            triangles.forEach(triangle -> {
                triangle.update();
            });
        }
    }

    public static Mesh load(String fileName) {
        return FileTranslatorOBJ.load(fileName);
    }

}
