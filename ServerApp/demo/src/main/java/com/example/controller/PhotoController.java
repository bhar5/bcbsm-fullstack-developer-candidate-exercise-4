package com.example.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.model.Photo;

public class PhotoController {

    @PostMapping("/photos/add")
public String addPhoto(@RequestParam("title") String title, 
  @RequestParam("image") MultipartFile image, Model model) 
  throws IOException {
    String id = photoService.addPhoto(title, image);
    return "redirect:/photos/" + id;
}

@GetMapping("/photos/{id}")
public String getPhoto(@PathVariable String id, Model model) {
    Photo photo = photoService.getPhoto(id);
    model.addAttribute("title", photo.getTitle());
    model.addAttribute("image", 
      Base64.getEncoder().encodeToString(photo.getImage().getData()));
    return "photos";
}
    
}
