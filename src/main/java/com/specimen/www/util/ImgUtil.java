package com.specimen.www.util;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

@Component
public class ImgUtil {
    @Value("${img.path}")
    private String path;

    public ImageReader getImgReader(String imgName) {
        try {
            File file = new File(path+imgName);
            ImageInputStream iis = ImageIO.createImageInputStream(file);
            Iterator<ImageReader> imageReaders = ImageIO.getImageReaders(iis);

            if (imageReaders.hasNext()) {
                ImageReader next = imageReaders.next();
                next.setInput(iis, true, true);
                return next;
            } else {
                throw new IllegalArgumentException("Cannot get ImageReader for the given file!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void saveImg(BufferedImage img,String imgName,String FormatName){
        try {
            ImageIO.write(img, FormatName, new File(path + imgName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public BufferedImage getBufferByFile(@NotNull MultipartFile file){
        try {
            return ImageIO.read(file.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
