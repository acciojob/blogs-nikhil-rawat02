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

    public Image addImage(Integer blogId, String description, String dimensions) throws Exception {
        //add an image to the blog
        Blog blog = blogRepository2.findById(blogId).get();
        if (blog == null) throw new Exception("Blog id not found");
        Image image = new Image();
        image.setDescription(description);
        image.setDimension(dimensions);

//        imageRepository2.save(image);

        blog.getImageList().add(image);
        image.setBlog(blog);
        blogRepository2.save(blog);

        return image;
    }

    public void deleteImage(Integer id) {
        imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) throws Exception {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        Image image = imageRepository2.findById(id).get();
        if (image == null) throw new Exception("image not found");

        String dimension = image.getDimension();
        String[] screen = screenDimensions.split("X");
        String[] givenSize = dimension.split("X");

        int vertical = Integer.parseInt(screen[0]) / Integer.parseInt(givenSize[0]);
        int horizontal = Integer.parseInt(screen[1]) / Integer.parseInt(givenSize[1]);

        return vertical + horizontal;

    }
}