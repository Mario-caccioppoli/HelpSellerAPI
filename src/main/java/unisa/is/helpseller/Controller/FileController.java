package unisa.is.helpseller.Controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.*;
import java.nio.file.Path;
import static java.nio.file.Paths.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.core.io.*;
import org.springframework.http.HttpHeaders;
import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;
import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * classe di mappatura dei servizi relativi alla gestione dei file
 */
@RestController
@RequestMapping("/file")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FileController {
    private static final String DIRECTORY = "/home/daniele/IDE/Helpseller/HelpSellerAPI/file";

    /**
     * metodo per l'upload di un file
     * @param multipartFiles oggetto del file
     */
    @PostMapping("/upload")
    public ResponseEntity<List<String>> uploadFiles
        (@RequestParam("files")List<MultipartFile> multipartFiles) throws IOException{
        
            List<String> filenames = new ArrayList<>();
            for(MultipartFile file : multipartFiles) {
                String filename = StringUtils.cleanPath(file.getOriginalFilename());
                Path fileStorage = get(DIRECTORY, filename).toAbsolutePath().normalize();
                Files.copy(file.getInputStream(), fileStorage, REPLACE_EXISTING);
                filenames.add(filename);
            }
            
            return ResponseEntity.ok().body(filenames);            
    }

    /**
     * metodo per il download di un file
     * @param filename nome del file
     */
    @GetMapping("/download/{filename}")
    public ResponseEntity<Resource> downloadFiles
        (@PathVariable("filename") String filename) throws IOException {
        
            Path filePath = get(DIRECTORY).toAbsolutePath().normalize().resolve(filename);
            if(!Files.exists(filePath)) {
                throw new FileNotFoundException(filename + " was not found!");
            }
            Resource resource = new UrlResource(filePath.toUri());
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("File-Name", filename);
            httpHeaders.add(CONTENT_DISPOSITION, "attachment;File-Name=" + resource.getFilename());
            return ResponseEntity.ok().contentType(MediaType.parseMediaType
        (Files.probeContentType(filePath))).headers(httpHeaders).body(resource);
    }
}
