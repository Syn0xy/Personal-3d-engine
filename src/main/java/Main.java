import application.component.EndlessTerrain;
import application.models.CubeGO;
import application.models.PlaneGO;
import application.models.PlayerGO;
import engine.geometric.Transform;
import engine.geometric.Vector3;
import engine.scene.GameObject;
import engine.scene.GameScene;

public class Main {

    public static void main(String[] args) {
        GameScene.init();

        
        GameObject player = new PlayerGO(new Transform(new Vector3(0, 0, -5)));
        GameObject endlessTerrain = new GameObject();
        endlessTerrain.addComponent(new EndlessTerrain(player.transform.position));
        
        GameScene.instantiate(player);
        GameScene.instantiate(new PlaneGO(new Transform(new Vector3(0, 8, 0))));
        GameScene.instantiate(new CubeGO(new Transform(new Vector3(0, 10, 0))));
        GameScene.instantiate(endlessTerrain);
        
        // int range = (int)Math.sqrt(100);
        // float distance = 1;
        // for (int x = 0; x < range; x++) {
        //     for (int y = 0; y < range; y++) {
        //         for (int z = 0; z < range; z++) {
        //             GameScene.instantiate(new CubeGO(new Transform(new Vector3(x * distance, y * distance, z * distance + 10))));
        //         }
        //     }
        // }
        
        GameScene.launch();
    }

}
