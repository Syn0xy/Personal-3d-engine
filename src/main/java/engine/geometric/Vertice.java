package engine.geometric;

import engine.component.Camera;
import engine.utils.MutableNumber;

public class Vertice {

    private Transform transform;

    private Vector3 position;

    private Vector3 positionSpace;

    protected double xscreen;

    protected double yscreen;

    protected boolean visible;

    public Vertice(Transform transform, Vector3 position) {
        this.transform = transform;
        this.position = position;
        this.positionSpace = new Vector3();
    }

    public Vector3 getPosition() {
        return position;
    }

    public void update(Camera camera) {
        reloadPositionSpace();
        reloadLocationInScreen(camera);
    }

    public void reloadPositionSpace() {
        positionSpace = rotate(new Vector3(
            position.x * transform.scale.x,
            position.y * transform.scale.y,
            position.z * transform.scale.z
        ), transform.rotation);
        positionSpace.x += transform.position.x;
        positionSpace.y += transform.position.y;
        positionSpace.z += transform.position.z;
        // positionSpace.x = position.x * transform.scale.x + transform.position.x;
        // positionSpace.y = position.y * transform.scale.y + transform.position.y;
        // positionSpace.z = position.z * transform.scale.z + transform.position.z;
    }
    
    public void reloadLocationInScreen(Camera camera) {
        Vector3 cp = camera.transform.position;
        Vector3 cr = camera.transform.rotation;
        
        MutableNumber<Double>
            px = new MutableNumber<Double>(positionSpace.x - cp.x),
            py = new MutableNumber<Double>(positionSpace.y - cp.y),
            pz = new MutableNumber<Double>(positionSpace.z - cp.z);

        rotation(px, pz, - cr.y);
        rotation(py, px, cr.z);
        rotation(py, pz, - cr.x);
        
        visible = pz.getValue() >= 0;
        
        if (visible) {
            double proportion = camera.getScreenProportion() * pz.getValue();
            double xprop = 1 / proportion;
            double yprop = 1.77 / proportion;
            xscreen = px.getValue() * xprop;
            yscreen = py.getValue() * yprop;

            visible = xscreen >= -1 && xscreen <= 1 && yscreen >= -1 && yscreen <= 1;
        }
    }

    private static void rotation(MutableNumber<Double> a, MutableNumber<Double> b, double rotation) {
        double rotRadian = StrictMath.atan2(a.getValue(), b.getValue()) + Math.toRadians(rotation);
        double distance = Math.sqrt(Math.pow(a.getValue(), 2) + Math.pow(b.getValue(), 2));

        a.setValue(distance * StrictMath.sin(rotRadian));
        b.setValue(distance * StrictMath.cos(rotRadian));
    }

    private static Vector3 rotate(Vector3 positionBase, Vector3 rotation) {
        MutableNumber<Double>
            verticeX = new MutableNumber<Double>(positionBase.x),
            verticeY = new MutableNumber<Double>(positionBase.y),
            verticeZ = new MutableNumber<Double>(positionBase.z);

        rotation(verticeY, verticeZ, rotation.x);
        rotation(verticeY, verticeX, rotation.z);
        rotation(verticeX, verticeZ, rotation.y);

        return new Vector3(verticeX.getValue(), verticeY.getValue(), verticeZ.getValue());
    }

}
