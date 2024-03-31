package application.component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import engine.component.Component;
import engine.geometric.Vector2;
import engine.geometric.Vector3;

public class EndlessTerrain extends Component {

    public static final int CHUNK_SIZE = 16;

    public static final int MAX_VIEW_DISTANCE = 64;

    private static final int CHUNKS_VISIBLE_IN_VIEW_DISTANCE = Math.round(MAX_VIEW_DISTANCE / CHUNK_SIZE) + 1;

    private static final int VIEWER_MOVE_DISTANCE = MAX_VIEW_DISTANCE / 4;

    private Map<Vector2, TerrainChunk> terrainChunks;

    private List<TerrainChunk> visibleTerrainChunks;

    private Vector3 viewerPosition;

    private Vector3 oldViewerPosition;

    public EndlessTerrain(Vector3 viewerPosition){
        this.terrainChunks = new HashMap<>();
        this.visibleTerrainChunks = new CopyOnWriteArrayList<>();
        this.viewerPosition = viewerPosition;
        this.oldViewerPosition = viewerPosition.copy();
        updateVisibleChunks();
    }

    public List<TerrainChunk> getVisibleTerrainChunks() {
        return visibleTerrainChunks;
    }

    public TerrainChunk getChunk(Vector2 vec2){
        return terrainChunks.getOrDefault(
            new Vector2(
                (int)Math.floor(vec2.x / CHUNK_SIZE),
                (int)Math.floor(vec2.y / CHUNK_SIZE)
            ),
        null);
    }

    @Override
    public void update() {
        if (oldViewerPosition.distanceHorizontal(viewerPosition) > VIEWER_MOVE_DISTANCE) {
            oldViewerPosition = viewerPosition.copy();
            updateVisibleChunks();
        }
    }

    private void updateVisibleChunks(){
        unvisibleAllTerrainChunk();
        
        long currentChunkCoordX = Math.round(viewerPosition.x / CHUNK_SIZE);
        long currentChunkCoordY = Math.round(viewerPosition.z / CHUNK_SIZE);
        
        for (int yOffset = -CHUNKS_VISIBLE_IN_VIEW_DISTANCE; yOffset <= CHUNKS_VISIBLE_IN_VIEW_DISTANCE; yOffset++){
            for (int xOffset = -CHUNKS_VISIBLE_IN_VIEW_DISTANCE; xOffset <= CHUNKS_VISIBLE_IN_VIEW_DISTANCE; xOffset++){
                Vector2 viewedChunkCoord = new Vector2(currentChunkCoordX + xOffset, currentChunkCoordY + yOffset);
                
                if(!terrainChunks.containsKey(viewedChunkCoord)){
                    Vector2 viewedChunkPosition = new Vector2(viewedChunkCoord.x * CHUNK_SIZE, viewedChunkCoord.y * CHUNK_SIZE);
                    terrainChunks.put(viewedChunkCoord, new TerrainChunk(viewedChunkPosition));
                }
                
                TerrainChunk chunk = terrainChunks.get(viewedChunkCoord);
                if(chunk.isVisible(new Vector2(viewerPosition.x, viewerPosition.z))){
                    visibleTerrainChunks.add(chunk);
                    chunk.setVisible(true);
                }
            }
        }
    }
    
    private void unvisibleAllTerrainChunk(){
        visibleTerrainChunks.forEach(chunk -> {
            chunk.setVisible(false);
        });
        visibleTerrainChunks.clear();
    }

}
