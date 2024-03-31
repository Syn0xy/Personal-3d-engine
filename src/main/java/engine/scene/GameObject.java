package engine.scene;

import java.util.ArrayList;
import java.util.List;

import engine.component.Component;
import engine.geometric.Transform;
import engine.utils.Updatable;

public class GameObject implements Updatable {

    public Transform transform;

    private List<Component> components;

    private boolean active;

    public GameObject(Transform transform) {
        this.transform = transform;
        this.components = new ArrayList<>();
        this.active = true;
    }

    public GameObject() {
        this(new Transform());
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
        components.forEach(component -> {
            component.setActive(active);
        });
    }
    
    public boolean addComponent(Component component) {
        component.transform = this.transform;
        return this.components.add(component);
    }

    @Override
    public void update() {
        if (active) {
            this.components.forEach(component -> {
                component.update();
            });
        }
    }

    @Override
    public String toString() {
        return "GameObject [transform=" + transform + ", components=" + components + "]";
    }

}
