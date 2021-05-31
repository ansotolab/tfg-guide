package es.ansotolab.customersservice.service;

import es.ansotolab.customersservice.exception.ImageIOError;
import es.ansotolab.customersservice.exception.ImageNotFound;
import es.ansotolab.customersservice.exception.ImageExceededSize;
import es.ansotolab.customersservice.exception.ImageInvalidType;
import es.ansotolab.customersservice.model.Image;
import es.ansotolab.customersservice.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public Image store(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        ArrayList<String> types = new ArrayList<>();
        types.add("image/jpeg");
        types.add("image/gif");
        types.add("image/png");

        if (file.getSize() >  3 * 1024 * 1024)
        {
            throw new ImageExceededSize();
        }
        else if (!types.contains(file.getContentType()))
        {
            throw new ImageInvalidType();
        }
        else
        {
            Image image;
            try {
                image = new Image(fileName, file.getContentType(), file.getBytes());
            } catch (IOException e) {
                throw new ImageIOError();
            }
            return imageRepository.save(image);
        }
    }

    public Image getFile(UUID id) {
        Optional<Image> imageSearched = imageRepository.findById(id);

        if (!imageSearched.isPresent())
        {
            throw new ImageNotFound(id.toString());
        }
        else
        {
            return imageSearched.get();
        }
    }
}
