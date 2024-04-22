package com.specimen.www.controller;

import com.specimen.www.bean.ImageWithSignPath;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class MarkingController {
    @RequestMapping("/marking")
    public static void markingPhoto(@RequestParam("svgPath")String svgPath,
                                    @RequestParam("svgName") String svgName,
                                    @RequestParam("file") MultipartFile file ) {
        System.out.println(file);

    }
}
