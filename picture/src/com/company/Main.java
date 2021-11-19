package com.company;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
public class Main {
    private static final String PATH_TO_MUSIC = "src\\ru\\demo\\downloadpik\\picture.jpg";
    public static void main(String[] args) throws IOException {
        InputStream url = new URL("http://www.avajava.com/images/avajavalogo.jpg").openStream();
        Files.copy(url, Path.of(PATH_TO_MUSIC), StandardCopyOption.REPLACE_EXISTING);
    }}