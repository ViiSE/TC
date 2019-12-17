package test.util;

import java.io.File;

public class TestUtils {

    public static String getTestResourcesPath() {
        return System.getProperty("user.dir") +
                File.separator + "src" +
                File.separator + "test" +
                File.separator + "resources" +
                File.separator;
    }

    public static String getTestResourcesFile(String filename) {
        return getTestResourcesPath() + filename;
    }
}
