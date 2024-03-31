package engine.component;

import engine.geometric.Transform;
import engine.geometric.Triangle;
import engine.geometric.Vector3;
import engine.geometric.Vertice;

public class PlaneMesh extends Mesh {

    public PlaneMesh(Transform transform) {
        this.vertices.add(new Vertice(transform, new Vector3(0, 0, 0)));
        this.vertices.add(new Vertice(transform, new Vector3(1, 0, 0)));
        this.vertices.add(new Vertice(transform, new Vector3(0, 0, 1)));
        this.vertices.add(new Vertice(transform, new Vector3(1, 0, 1)));

        this.triangles.add(new Triangle(vertices.get(0), vertices.get(1), vertices.get(2)));
        this.triangles.add(new Triangle(vertices.get(1), vertices.get(2), vertices.get(3)));
    }

}
