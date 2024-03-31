package engine.component;

public class Camera extends Component {

    public static Camera mainCamera;
    
    private int fieldOfView;

    private double screenProportion;

    public Camera(int fieldOfView) {
        this.fieldOfView = fieldOfView;
        Camera.mainCamera = this;
    }

    public int getFieldOfView() {
        return fieldOfView;
    }

    public double getScreenProportion() {
        return screenProportion;
    }
    
    @Override
    public void update() {
        this.screenProportion = StrictMath.tan(Math.toRadians(fieldOfView / 2));
    }

}
