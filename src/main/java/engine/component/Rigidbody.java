package engine.component;

import engine.geometric.Vector3;

public class Rigidbody extends Component {

    private static final double DECELERATION = 9.81 / 10;

    private Vector3 inertie;

    public Rigidbody() {
        this.inertie = new Vector3();
    }

    @Override
    public void update() {
        transform.position.add(new Vector3(
            inertie.x * Math.cos(Math.toRadians(transform.rotation.y)) + inertie.z * Math.sin(Math.toRadians(transform.rotation.y)),
            inertie.z * Math.sin(Math.toRadians(transform.rotation.x)),
            inertie.z * Math.cos(Math.toRadians(transform.rotation.y)) - inertie.x * Math.sin(Math.toRadians(transform.rotation.y))
        ));
        inertie.multiply(DECELERATION);
        stopInertie();
    }

    public void addForce(Vector3 force) {
        inertie.add(force);
    }
    
    private void stopInertie() {
        if (Math.abs(inertie.x) < 0.001) {
            inertie.x = 0;
        }
        if (Math.abs(inertie.y) < 0.001) {
            inertie.y = 0;
        }
        if (Math.abs(inertie.z) < 0.001) {
            inertie.z = 0;
        }
    }

    

}
