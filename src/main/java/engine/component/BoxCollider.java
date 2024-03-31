package engine.component;

import engine.geometric.Vector3;

public class BoxCollider extends Collider {

    private Vector3 size;

    public BoxCollider(Vector3 size) {
        this.size = size;
    }

    @Override
    public void detectCollision(Collider collider) {
        if (collider.getClass().isAssignableFrom(getClass())) {
            if (isCollision((BoxCollider)collider)) {
                System.out.println("box collision !");
            }
        }
    }

    private boolean isCollision(BoxCollider boxCollider) {
        Vector3 p = transform.position;
        Vector3 cp = boxCollider.transform.position;
        Vector3 cs = boxCollider.size;
        return
            p.x - this.size.x / 2 <= cp.x + cs.x / 2 && p.x + this.size.x / 2 >= cp.x - cs.x / 2 &&
            p.y - this.size.y / 2 <= cp.y + cs.y / 2 && p.y + this.size.y / 2 >= cp.y - cs.y / 2 &&
            p.z - this.size.z / 2 <= cp.z + cs.z / 2 && p.z + this.size.z / 2 >= cp.z - cs.z / 2;
    }

}
