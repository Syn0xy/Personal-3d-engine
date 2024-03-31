package engine.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileTranslatorCSV {

    private static final String DEFAULT_CSV_DELIMITER = ";";

    public static List<List<String>> readValues(File file, String delimiter) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            List<List<String>> datas = new ArrayList<>();
            while (br.ready()) {
                List<String> crntData = new ArrayList<>();
                Scanner sc = new Scanner(br.readLine()).useDelimiter(delimiter);
                while (sc.hasNext()) {
                    crntData.add(sc.next());
                }
                sc.close();
                datas.add(crntData);
            }
            return datas;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static List<List<String>> readValues(File file) {
        return readValues(file, DEFAULT_CSV_DELIMITER);
    }

}
