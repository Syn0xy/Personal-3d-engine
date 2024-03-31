package application.models;

import engine.component.PlaneMesh;
import engine.geometric.Transform;
import engine.geometric.Vector3;
import engine.scene.GameObject;

public class PlaneGO extends GameObject {

    private static final double DEFAULT_SCALE = 10;
    
    public PlaneGO(Transform transform) {
        super(transform);
        this.addComponent(new PlaneMesh(transform));
        this.transform.scale = new Vector3(DEFAULT_SCALE, DEFAULT_SCALE, DEFAULT_SCALE);
        this.transform.position.x -= DEFAULT_SCALE / 2;
        this.transform.position.z -= DEFAULT_SCALE / 2;
    }

}
