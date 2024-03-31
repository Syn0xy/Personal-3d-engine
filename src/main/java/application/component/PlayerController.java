package application.component;

import java.awt.MouseInfo;
import java.awt.Point;

import engine.component.Component;
import engine.component.Rigidbody;
import engine.geometric.Vector2;
import engine.geometric.Vector3;
import engine.input.Input;
import engine.input.KeyCode;

public class PlayerController extends Component {

    private static final double SPEED = 4.0 / 1000.0;

    private Rigidbody rigidbody;

    private Vector2 mousePosition;
    
    private Vector2 oldMousePosition;

    public PlayerController(Rigidbody rigidbody) {
        this.rigidbody = rigidbody;
    }

    @Override
    public void update() {
        Point p = MouseInfo.getPointerInfo().getLocation(); 
        mousePosition = new Vector2(p.x / 10.0, p.y / 10.0);

        if (oldMousePosition == null) {
            oldMousePosition = mousePosition;
        }
        
        Vector2 changePosition = new Vector2(mousePosition.x - oldMousePosition.x, oldMousePosition.y - mousePosition.y);
        oldMousePosition = mousePosition;
        
        if (Input.getKey(KeyCode.MOUSE_RIGHT)) {
            transform.rotation.y += changePosition.x;
            transform.rotation.x += changePosition.y;
        }
        move();
    }

    private void move() {
        Vector3 direction = new Vector3();
        if (Input.getKey(KeyCode.Z)) {
            direction.z += 1;
        }
        if (Input.getKey(KeyCode.S)) {
            direction.z -= 1;
        }
        if (Input.getKey(KeyCode.D)) {
            direction.x += 1;
        }
        if (Input.getKey(KeyCode.Q)) {
            direction.x -= 1;
        }
        if (Input.getKey(KeyCode.SPACE)) {
            transform.position.y += SPEED * 25;
        }
        if (Input.getKey(KeyCode.CTRL_LEFT)) {
            transform.position.y -= SPEED * 25;
        }
        rigidbody.addForce(direction.multiplyCopy(SPEED));
    }

}
