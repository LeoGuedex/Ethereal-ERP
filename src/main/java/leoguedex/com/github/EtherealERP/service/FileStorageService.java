package leoguedex.com.github.EtherealERP.service;

import leoguedex.com.github.EtherealERP.config.FileStorageConfig;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

}
