package engine.scene;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import engine.input.Input;
import engine.view.GameView;

public class GameScene extends Scene {
    
    private static final int FRAMES_PER_SECOND = 120;

    private static GameScene singleton;

    private List<GameObject> gameObjects;

    private GameScene() {
        super(FRAMES_PER_SECOND);
        this.gameObjects = new CopyOnWriteArrayList<>();
    }
    
    public List<GameObject> getGameObjects() {
        return gameObjects;
    }
    
    @Override
    public void start() {
        // super.start();
        new GameView(this).start();
    }
    
    @Override
    public void update() {
        gameObjects.forEach(gameObject -> {
            gameObject.update();
        });
        Input.update();
    }

    private boolean add(GameObject gameObject) {
        return this.gameObjects.add(gameObject);
    }

    public static void init() {
        if (singleton == null) {
            singleton = new GameScene();
        }
    }

    public static void launch() {
        singleton.start();
    }

    public static boolean instantiate(GameObject gameObject) {
        return singleton.add(gameObject);
    }

}
