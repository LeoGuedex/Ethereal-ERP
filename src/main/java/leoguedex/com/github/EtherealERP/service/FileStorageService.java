package leoguedex.com.github.EtherealERP.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import leoguedex.com.github.EtherealERP.config.FileStorageConfig;

@Service
public class FileStorageService {

    private final Path profilePicDir;

    public FileStorageService(FileStorageConfig fileStorageConfig) throws IOException {
        String profilePictureLocation = fileStorageConfig.getProfilePic();
        profilePicDir = Paths.get(profilePictureLocation).toAbsolutePath().normalize();

        try {

            Files.createDirectories(profilePicDir);

        } catch (Exception ex) {
            throw new IOException("The directory [" + profilePictureLocation + "] cannot be created.", ex);
        }
    }

    public String getProfilePicDirectory(String profilePicName) {
        return profilePicDir.resolve(profilePicName).toString();
    }

    public void updatePhoto(MultipartFile profilePic, String pictureName) throws IllegalStateException, IOException {

        Path targetLocation = profilePicDir.resolve(pictureName);
        profilePic.transferTo(targetLocation);
    }

    public byte[] getProfilePicByName(String pictureName) throws IOException {

        Path filePath = profilePicDir.resolve(pictureName).normalize();
        Resource resource = new UrlResource(filePath.toUri());

        return Files.readAllBytes(resource.getFile().toPath());
    }
}
