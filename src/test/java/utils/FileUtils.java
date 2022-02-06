package utils;

import java.io.File;
import java.io.FileOutputStream;

public class FileUtils {

    public static void saveBytesToFile(byte[] bytes, String fileName) {
        File screenshot = new File(fileName);
        try (FileOutputStream outputStream = new FileOutputStream(screenshot)) {
            outputStream.write(bytes);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
