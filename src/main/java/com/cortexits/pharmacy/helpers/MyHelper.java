package com.cortexits.pharmacy.helpers;

import com.cortexits.pharmacy.MainApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

public class MyHelper {

    public static void printFiles(String dir, String ext) {
//        File file = new File(Icons.class.getResource("com/cortexits/pharmacy/icons").getFile());
        File file = new File("/home/imran/Projects/IdeaProjects/PointOfSale/Pharmacy/src/main/resources/com/cortexits/pharmacy/" + dir);
        System.out.println("Icon: " + file.exists());
        if (file != null) {
            File[] files = file.listFiles();
            System.out.println(files);
//        assert files != null;
//        Arrays.sort(files);
//        assert files != null;
//        List<File> l = Arrays.stream(files).sorted(File::getName).collect(Collectors.toList());
            System.out.println("-------------------------------------------");
            for (File fileName : files) {
//            CHEVRON_LEFT = "icons/chevron-left.svg";
//            String name = fileName.getName().replace(".svg", "").replaceAll("-", "_").toUpperCase();
                String name = fileName.getName().replace("." + ext, "").replaceAll("-", "_").toUpperCase();
                System.out.println("public static String " + name + " = \"" + dir + "/" + fileName.getName() + "\";");
            }
            System.out.println("-------------------------------------------");
        } else {
            System.err.println("Empty Error");
        }
    }

//    public static void printIconFiles() {
////        try {
////            InputStream inputStream = MainApplication.class.getResourceAsStream("icons");
////            File file = new File(inputStream.);
////        } catch (FileNotFoundException e) {
////            e.printStackTrace();
////        }
//        File file = null;
//        try {
//            file = new File(new URI(MainApplication.class.getResourceAsStream("icons")));
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//        System.out.println("File: " + file);
//    }
    public static void printIconFilesClass() {
//        File file = new File(MainApplication.class.getResource("icons").getPath());
        File file = new File("/home/imran/Projects/IdeaProjects/PointOfSale/Pharmacy/src/main/resources/com/cortexits/pharmacy/icons");
        System.out.println("Icon: " + file.exists());
        if (file != null) {
            File[] files = file.listFiles();
            System.out.println(files);
//        assert files != null;
//        Arrays.sort(files);
//        assert files != null;
//        List<File> l = Arrays.stream(files).sorted(File::getName).collect(Collectors.toList());
            System.out.println("-------------------------------------------");
            for (File fileName : files) {
//            CHEVRON_LEFT = "icons/chevron-left.svg";
//            String name = fileName.getName().replace(".svg", "").replaceAll("-", "_").toUpperCase();
                String name = fileName.getName().replace(".png", "").replaceAll("-", "_").toUpperCase();
//                System.out.println("public static String " + name + " = \"icons/" + fileName.getName() + "\";");
                System.out.println("public static String " + name + " = \"com/cortexits/pharmacy/icons/" + fileName.getName() + "\";");
            }
            System.out.println("-------------------------------------------");
        } else {
            System.err.println("Empty Error");
        }
    }
    public static void printIconFiles() {
//        File file = new File(MainApplication.class.getResource("icons").getPath());
        File file = new File("/home/imran/Projects/IdeaProjects/PointOfSale/Pharmacy/src/main/resources/com/cortexits/pharmacy/icons");
        System.out.println("Icon: " + file.exists());
        if (file != null) {
            File[] files = file.listFiles();
            System.out.println(files);
//        assert files != null;
//        Arrays.sort(files);
//        assert files != null;
//        List<File> l = Arrays.stream(files).sorted(File::getName).collect(Collectors.toList());
            System.out.println("-------------------------------------------");
            for (File fileName : files) {
//            CHEVRON_LEFT = "icons/chevron-left.svg";
//            String name = fileName.getName().replace(".svg", "").replaceAll("-", "_").toUpperCase();
                String name = fileName.getName().replace(".png", "").replaceAll("-", "_").toUpperCase();
//                System.out.println("public static String " + name + " = \"icons/" + fileName.getName() + "\";");
//                System.out.println(name + " (\"com/cortexits/pharmacy/icons/" + fileName.getName() + "\"),");
                System.out.println(name + " (\"icons/" + fileName.getName() + "\"),");
            }
            System.out.println("-------------------------------------------");
        } else {
            System.err.println("Empty Error");
        }
    }

    public static void printFxmlFilesClass(String path) {
//        File file = new File(MainApplication.class.getResource("icons").getPath());
        String p = "/home/imran/Projects/IdeaProjects/PointOfSale/Pharmacy/src/main/resources/com/cortexits/pharmacy/views";
        if (path != null) {
            p += "/" + path;
        }
        File file = new File(p);
        System.out.println("View: " + file.exists());
        if (file != null) {
            File[] files = file.listFiles();
            System.out.println(files);
//        assert files != null;
//        Arrays.sort(files);
//        assert files != null;
//        List<File> l = Arrays.stream(files).sorted(File::getName).collect(Collectors.toList());
            System.out.println("-------------------------------------------");
            for (File fileName : files) {
//            CHEVRON_LEFT = "icons/chevron-left.svg";
//            String name = fileName.getName().replace(".svg", "").replaceAll("-", "_").toUpperCase();
                String name = fileName.getName().replace(".fxml", "").replaceAll("-", "_").toUpperCase();
//                System.out.println("public static String " + name + " = \"icons/" + fileName.getName() + "\";");
                if (path == null) {
                    System.out.println("public static String " + name + " = \"views/" + fileName.getName() + "\";");
                } else {
                    System.out.println("public static String " + path.toUpperCase() + "_" + name + " = \"views/" + path + "/" + fileName.getName() + "\";");
                }

            }
            System.out.println("-------------------------------------------");
        } else {
            System.err.println("Empty Error");
        }
    }

    public static void printFxmlFiles(String path) {
//        File file = new File(MainApplication.class.getResource("icons").getPath());
        String p = "/home/imran/Projects/IdeaProjects/PointOfSale/Pharmacy/src/main/resources/com/cortexits/pharmacy/views";
        if (path != null) {
            p += "/" + path;
        }
        File file = new File(p);
        System.out.println("View: " + file.exists());
        if (file != null) {
            File[] files = file.listFiles();
            System.out.println(files);
//        assert files != null;
//        Arrays.sort(files);
//        assert files != null;
//        List<File> l = Arrays.stream(files).sorted(File::getName).collect(Collectors.toList());
            System.out.println("-------------------------------------------");
            for (File fileName : files) {
//            CHEVRON_LEFT = "icons/chevron-left.svg";
//            String name = fileName.getName().replace(".svg", "").replaceAll("-", "_").toUpperCase();
                String name = fileName.getName().replace(".fxml", "").replaceAll("-", "_").toUpperCase();
//                System.out.println("public static String " + name + " = \"icons/" + fileName.getName() + "\";");
                if (path == null) {
                    System.out.println(name + " (\"views/" + fileName.getName() + "\"),");
                } else {
                    System.out.println(path.toUpperCase() + "_" + name + " (\"views/" + path + "/" + fileName.getName() + "\"),");
                }

            }
            System.out.println("-------------------------------------------");
        } else {
            System.err.println("Empty Error");
        }
    }
}
