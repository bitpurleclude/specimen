package com.specimen.www.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
@Component
public class GetImg {
    @Value("${img.path}")
    private  String path;

    public  BufferedImage getImg(String imgName) {
        try {
            System.out.println(path + imgName);
            File file = new File(path+imgName);
            BufferedImage image = ImageIO.read(file);
            return image;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
