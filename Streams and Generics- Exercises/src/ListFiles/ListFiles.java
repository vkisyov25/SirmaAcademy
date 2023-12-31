package ListFiles;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        String folderPath = "D:\\4-ти семестър\\ОМТ\\курсова работа";
        File folder = new File(folderPath);
        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String fileName = file.getName();
                        long fileSize = file.length();
                        System.out.println("File Name: " + fileName);
                        System.out.println("File Size (bytes): " + fileSize);
                        System.out.println();
                    }

                }

            }

        } else {
            System.err.println("The provided path is not a directory.");
        }

    }
}
