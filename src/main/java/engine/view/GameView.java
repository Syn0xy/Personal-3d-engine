package engine.view;

import engine.scene.GameScene;

public class GameView extends View {

    private static final int WIDTH = (int)(SCREEN_WIDTH * (2.0 / 3.0));

    private static final int HEIGHT = (int)(SCREEN_HEIGHT * (2.0 / 3.0));

    private static final String TITLE = "3D";

    private GameScene gameScene;
    
    private Canvas canvas;

    public GameView(GameScene gameScene) {
        super(WIDTH, HEIGHT);
        this.gameScene = gameScene;
        this.canvas = new Canvas(gameScene);
    }

    @Override
    public String title() {
        return TITLE;
    }

    @Override
    public void draw() {
        this.gameScene.update();
        this.canvas.update();
    }
    
}
