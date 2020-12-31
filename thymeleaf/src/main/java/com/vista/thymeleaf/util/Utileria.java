package com.vista.thymeleaf.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class Utileria {
    public static String guardarArchivo(MultipartFile multiPart, String ruta) {
        // Obtenemos el nombre original del archivo.
        String nombreOriginal = multiPart.getOriginalFilename();
        nombreOriginal=nombreOriginal.replace(" ", "-");
        String nombreFinal = randomAlphaNimeric(8)+nombreOriginal;
        try {
            // Formamos el nombre del archivo para guardarlo en el disco duro.
            File imageFile = new File(ruta + nombreFinal);
            System.out.println("Archivo: " + imageFile.getAbsolutePath());
            //Guardamos fisicamente el archivo en HD.
            multiPart.transferTo(imageFile);
            return nombreFinal;
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
            return null;
        }
    }


    public static  String randomAlphaNimeric(int count){
        String CARACTER ="abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder stringBuilder = new StringBuilder();
        while(count-- !=0){
            int character =(int) (Math.random()*CARACTER.length());
            stringBuilder.append(CARACTER.charAt(character));
        }
        return  stringBuilder.toString();
    }
}
