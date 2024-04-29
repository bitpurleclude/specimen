package com.specimen.www.util;

import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GetImgMD5 {
    public static String getMD5(BufferedImage image) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(image, "png", outputStream);
            byte[] data = outputStream.toByteArray();

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(data);

            StringBuilder sb = new StringBuilder(2*hash.length);
            for(byte b : hash){
                sb.append(String.format("%02x", b&0xff));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException("Could not calculate MD5", e);
        }
    }

    public static BufferedImage  multipartFileToBufferedImage(MultipartFile file) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(file.getBytes());
        return ImageIO.read(bais);
    }
}