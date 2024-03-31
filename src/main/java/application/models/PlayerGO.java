package application.models;

import application.component.PlayerController;
import engine.component.BoxCollider;
import engine.component.Camera;
import engine.component.Rigidbody;
import engine.geometric.Transform;
import engine.geometric.Vector3;
import engine.scene.GameObject;

public class PlayerGO extends GameObject {
    
    public PlayerGO(Transform transform) {
        super(transform);
        this.addComponent(new Camera(90));
        Rigidbody rigidbody = new Rigidbody();
        this.addComponent(rigidbody);
        this.addComponent(new PlayerController(rigidbody));
        this.addComponent(new BoxCollider(new Vector3(1, 1, 1)));
    }

}
