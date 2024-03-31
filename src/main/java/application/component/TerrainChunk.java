package application.component;

import static application.component.EndlessTerrain.CHUNK_SIZE;
import static application.component.EndlessTerrain.MAX_VIEW_DISTANCE;

import engine.component.Mesh;
import engine.geometric.Transform;
import engine.geometric.Vector2;
import engine.geometric.Vector3;
import engine.scene.GameObject;
import engine.scene.GameScene;

public class TerrainChunk extends GameObject {

    private static final double HEIGHT_MULTIPLIER = 5;

    private static final boolean FLAT_SHADING = true;
    
    private Vector2 position;

    private MapData data;
    
    protected TerrainChunk(Vector2 position){
        super(new Transform(new Vector3(position.x, 0, position.y)));
        this.position = position;
        this.data = new MapData(CHUNK_SIZE + 1, position);
        this.addComponent(generateMesh(transform));
        this.setVisible(false);
        GameScene.instantiate(this);
    }

    public boolean isVisible(Vector2 viewerPosition) {
        return position.distance(viewerPosition) <= MAX_VIEW_DISTANCE;
    }
    
    public void setVisible(boolean active) {
        super.setActive(active);
    }
    
    private Mesh generateMesh(Transform transform) {
        return MeshGenerator.generateTerrainMesh(transform, data.getNoisemap(), HEIGHT_MULTIPLIER, FLAT_SHADING);
    }

}
