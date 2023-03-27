package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions) {


        Image image = new Image();
        image.setDescription(description);
        image.setDimensions(dimensions);

        Blog blog = blogRepository2.findById(blogId).get();

        image.setBlog(blog);

        List<Image> i = blog.getImageList();
        i.add(image);

        blogRepository2.save(blog);

        return image;
    }

    public void deleteImage(Integer id) {

        imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {

        Image image = imageRepository2.findById(id).get();
        String availableDimension = image.getDimensions();
        String[] arr = availableDimension.split("X");
        String[] brr = screenDimensions.split("X");

        int screenWidth = Integer.parseInt(brr[0]);
        int screenHeight = Integer.parseInt(brr[1]);
        int imageWidth = Integer.parseInt(arr[0]);
        int imageHeight = Integer.parseInt(arr[1]);

        int a = screenHeight/imageHeight;
        int b = screenWidth/imageWidth;

        return a*b;
    }
}