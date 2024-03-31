package engine.component;

import engine.geometric.Transform;
import engine.geometric.Triangle;
import engine.geometric.Vector3;
import engine.geometric.Vertice;
import engine.scene.GameObject;

public class Simple extends GameObject {

    public Simple(Transform transform) {
        super(transform);
        Mesh mesh = new Mesh();
        mesh.vertices.add(new Vertice(transform, new Vector3(0, 0, 1)));
        mesh.vertices.add(new Vertice(transform, new Vector3(0, 1, 1)));
        mesh.vertices.add(new Vertice(transform, new Vector3(1, 0, 1)));

        mesh.triangles.add(new Triangle(
            mesh.vertices.get(0),
            mesh.vertices.get(1),
            mesh.vertices.get(2)
        ));
        addComponent(mesh);
    }

}
