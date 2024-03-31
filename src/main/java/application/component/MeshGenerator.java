package application.component;

import java.util.ArrayList;
import java.util.List;

import engine.component.Mesh;
import engine.geometric.Transform;
import engine.geometric.Triangle;
import engine.geometric.Vector3;
import engine.geometric.Vertice;

public class MeshGenerator {
    
    public static Mesh generateTerrainMesh(Transform transform, double[][] heightMap, double heightMultiplier, boolean flatShading) {
        List<Vertice> vertices = new ArrayList<>();
        List<Triangle> triangles = new ArrayList<>();

        int[][] vertexIndicesMap = new int[heightMap.length][];
        int vertexIndex = 0;
        
        for (int i = 0; i < heightMap.length; i++) {
            vertexIndicesMap[i] = new int[heightMap[i].length];
            for (int j = 0; j < heightMap[i].length; j++) {
                double crntHeight = heightMap[i][j] * heightMultiplier;

                if (flatShading) {
                    crntHeight = Math.round(crntHeight);
                }

                Vertice crntVertice = new Vertice(transform, new Vector3(i, crntHeight, j));
                vertices.add(crntVertice);
                vertexIndicesMap[i][j] = vertexIndex++;
            }
        }
        
        for (int i = 0; i < vertexIndicesMap.length; i++) {
            for (int j = 0; j < vertexIndicesMap[i].length; j++) {
                if (i < heightMap.length - 1 && j < heightMap[i].length - 1) {
                    Vertice a = vertices.get(vertexIndicesMap[i][j]);
                    Vertice b = vertices.get(vertexIndicesMap[i + 1][j]);
                    Vertice c = vertices.get(vertexIndicesMap[i][j + 1]);
                    Vertice d = vertices.get(vertexIndicesMap[i + 1][j + 1]);
                    triangles.add(new Triangle(a, d, c));
                    triangles.add(new Triangle(d, a, b));
                }
            }
        }
        
        return new Mesh(vertices, triangles);
    }

}
