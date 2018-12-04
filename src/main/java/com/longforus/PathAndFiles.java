package com.longforus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author longforus
 * @describe
 * @date 11/22/2018  10:26 AM
 */
public class PathAndFiles {
   public static void main(String[] args) {
       Path path = Paths.get("z:/");
       try {
           Files.copy(path, path, StandardCopyOption.COPY_ATTRIBUTES);

       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}
