package engine.component;

import engine.geometric.Transform;
import engine.utils.Updatable;

public abstract class Component implements Updatable {

    public Transform transform;

    protected boolean active;

    public Component() {
        this.active = true;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
