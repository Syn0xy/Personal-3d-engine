package engine.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import engine.component.Mesh;

public class FileTranslatorOBJ {

    public static Mesh load(String fileName) {
        return load(FileFinder.find(fileName));
    }

    public static Mesh load(File file) {
        if (!file.exists() || !file.isFile()) {
            return null;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (br.ready()) {
                 Scanner sc = new Scanner(br.readLine()).useDelimiter(" ");
                 while (sc.hasNext()) {
                    System.out.print(sc.next() + ";");
                 }
                 sc.close();
                 System.out.println();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        return null;
    }

    public static void main(String[] args) {
        load("low-poly-tree.obj");
    }

}
