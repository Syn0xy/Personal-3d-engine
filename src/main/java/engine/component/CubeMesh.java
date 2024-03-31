package engine.component;

import engine.geometric.Transform;
import engine.geometric.Triangle;
import engine.geometric.Vector3;
import engine.geometric.Vertice;

public class CubeMesh extends Mesh {

    public CubeMesh(Transform transform) {
        this.vertices.add(new Vertice(transform, new Vector3(0, 0, 0)));
        this.vertices.add(new Vertice(transform, new Vector3(1, 0, 0)));
        this.vertices.add(new Vertice(transform, new Vector3(0, 1, 0)));
        this.vertices.add(new Vertice(transform, new Vector3(1, 1, 0)));
        this.vertices.add(new Vertice(transform, new Vector3(0, 0, 1)));
        this.vertices.add(new Vertice(transform, new Vector3(1, 0, 1)));
        this.vertices.add(new Vertice(transform, new Vector3(0, 1, 1)));
        this.vertices.add(new Vertice(transform, new Vector3(1, 1, 1)));

        this.vertices.forEach(vertice -> {
            vertice.getPosition().x -= 0.5;
            vertice.getPosition().y -= 0.5;
            vertice.getPosition().z -= 0.5;
        });

        this.triangles.add(new Triangle(vertices.get(0), vertices.get(1), vertices.get(2)));
        this.triangles.add(new Triangle(vertices.get(1), vertices.get(2), vertices.get(3)));
        this.triangles.add(new Triangle(vertices.get(0), vertices.get(2), vertices.get(4)));
        this.triangles.add(new Triangle(vertices.get(2), vertices.get(4), vertices.get(6)));
        this.triangles.add(new Triangle(vertices.get(2), vertices.get(6), vertices.get(7)));
        this.triangles.add(new Triangle(vertices.get(2), vertices.get(3), vertices.get(7)));
        this.triangles.add(new Triangle(vertices.get(0), vertices.get(1), vertices.get(4)));
        this.triangles.add(new Triangle(vertices.get(1), vertices.get(4), vertices.get(5)));
        this.triangles.add(new Triangle(vertices.get(1), vertices.get(4), vertices.get(5)));
        this.triangles.add(new Triangle(vertices.get(4), vertices.get(6), vertices.get(7)));
        this.triangles.add(new Triangle(vertices.get(4), vertices.get(5), vertices.get(7)));
        this.triangles.add(new Triangle(vertices.get(1), vertices.get(5), vertices.get(7)));
        this.triangles.add(new Triangle(vertices.get(1), vertices.get(3), vertices.get(7)));
    }

    @Override
    public void update() {
        super.update();
    }

}
