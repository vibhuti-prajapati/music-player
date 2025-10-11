package com.example.MusicPlayer.Controller;

import jakarta.annotation.PostConstruct;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/music")
public class FileRestController {
    private final Path root = Paths.get("uploads");
    private final File folder = new File("uploads");
    @PostConstruct
    public void init(){
        try{
            Files.createDirectories(root);
        }catch(Exception e){
            throw new RuntimeException("could not create folder");
        }
    }
    // upload
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
       try {
           // check if file already exists
           if(Files.exists(root) && Files.isDirectory(root)){
               Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
               return ResponseEntity.status(HttpStatus.CREATED).body("File uploaded successfully");
           }
           return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("something went wrong");
       }catch(Exception e){
           return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("couldn't upload file");
       }
    }

    // list
    @GetMapping("/list")
    public ResponseEntity<List<String>> listFiles(){
        if(folder.exists() && folder.isDirectory()){
            List<String> fileNames = Arrays.stream(folder.listFiles())
                    .filter(File::isFile)
                    .map(File::getName)
                    .toList();
            return ResponseEntity.status(HttpStatus.OK).body(fileNames);
        }
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
    }

    // playing
    @GetMapping("/play/{song}")
    public ResponseEntity<Resource> playSong(@PathVariable String song)throws MalformedURLException{
        Path file = root.resolve(song);
            Resource resource = new UrlResource(file.toUri());
        if (!resource.exists() || !resource.isReadable()) {
            throw new RuntimeException("Could not read song: " + song);
        }
        return ResponseEntity.ok().body(resource);
    }
}
