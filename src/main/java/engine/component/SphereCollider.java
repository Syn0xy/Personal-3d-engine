package engine.component;

public class SphereCollider extends Collider {

    private double radius;

    public SphereCollider(double radius) {
        this.radius = radius;
    }

    @Override
    public void detectCollision(Collider collider) {
        if (collider.getClass().isAssignableFrom(getClass())) {
            detectSphereCollision((SphereCollider)collider);
        }
    }

    public void detectSphereCollision(SphereCollider sphereCollider) {
        double dist = sphereCollider.transform.position.distance(this.transform.position);
        if (dist < sphereCollider.radius + this.radius) {
            System.out.println("collision !");
        }
    }
    
}
