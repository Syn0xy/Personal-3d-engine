package application.models;

import engine.component.BoxCollider;
import engine.component.CubeMesh;
import engine.geometric.Transform;
import engine.geometric.Vector3;
import engine.scene.GameObject;

public class CubeGO extends GameObject {

    private Vector3 rotation;

    private double current;

    private boolean back;

    public CubeGO(Transform transform) {
        super(transform);
        this.addComponent(new CubeMesh(transform));
        this.addComponent(new BoxCollider(new Vector3(1, 1, 1)));
        this.rotation = transform.rotation;
    }

    @Override
    public void update() {
        transform.position.y = 10 + Math.sin(current);
        double toAdd = 0.02;
        if (back && current > 0) {
            toAdd = -toAdd;
            back = !back;
        }
        current += toAdd;
        rotation.y += 5;
        super.update();
    }

}
