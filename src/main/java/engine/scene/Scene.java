package engine.scene;
import java.util.Timer;
import java.util.TimerTask;

import engine.utils.Updatable;

public abstract class Scene implements Updatable {

    private int framesPerSecond;

    protected Scene(int framesPerSecond) {
        this.framesPerSecond = framesPerSecond;
    }

    public void start() {
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                update();
            }
        }, 0, (long)(1000.0 / framesPerSecond));
    }

}
