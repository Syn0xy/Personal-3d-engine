package engine.component;

import java.util.ArrayList;
import java.util.List;

public abstract class Collider extends Component {

    private static final List<Collider> COLLIDERS = new ArrayList<>();

    protected Collider() {
        COLLIDERS.add(this);
    }
    
    @Override
    public void update() {
        COLLIDERS.forEach(collider -> {
            if (collider != this) {
                detectCollision(collider);
            }
        });
    }
    
    public abstract void detectCollision(Collider collider);

}
