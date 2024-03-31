package engine.file;

import java.io.File;

public class FileFinder {

    private static final String PATH_SEPARATOR = File.separator;

    private static final String DEFAULT_PATH_BASE = "res" + PATH_SEPARATOR;

    public static final File find(String fileName) {
        return research(new File(DEFAULT_PATH_BASE), fileName);
    }

    private static final File research(File file, String fileName) {
        if (file.exists()) {
            if (file.isFile()) {
                if (file.getName().equals(fileName)) {
                    return file;
                }
            } else if (file.isDirectory()) {
                File[] files = file.listFiles();
                File crntFile;
                for (int i = 0; i < files.length; i++) {
                    crntFile = research(files[i], fileName);
                    if (crntFile != null) {
                        return crntFile;
                    }
                }
            }
        }
        return null;
    }

}
