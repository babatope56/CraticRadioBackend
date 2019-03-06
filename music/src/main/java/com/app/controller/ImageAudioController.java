package com.app.controller;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.entity.AlbumImage;
import com.app.entity.UserMedia;
import com.app.repository.ArtRepo;
import com.app.repository.ImageRepo;

@RestController
@CrossOrigin
public class ImageAudioController {
	
	@Autowired
	ImageRepo imageRepo;
	
	@Autowired
	ArtRepo artRepo;
	
	@RequestMapping(value="/upload-audio/{alias}", consumes= MediaType.MULTIPART_FORM_DATA_VALUE, method=RequestMethod.POST)
	public void saveUserMedia(@RequestParam("filepond") MultipartFile multiPartFile, @PathVariable("alias") String alias ) {
		 
		UserMedia media = new UserMedia();
		
	
		
		media.setUserEmail(alias);
		media.setMusicName(multiPartFile.getOriginalFilename());
		media.setMusicFormat(multiPartFile.getContentType());
		
		AlbumImage image = new AlbumImage();
		
		image.setUserEmail(alias);
		image.setImageName(multiPartFile.getOriginalFilename());
		image.setImageType(multiPartFile.getContentType());
		
		try {
			
			
			
			String base64Music = Base64.getEncoder().encodeToString(multiPartFile.getBytes());
			media.setMusic(base64Music);
			
			String base64Image = Base64.getEncoder().encodeToString(multiPartFile.getBytes());
			image.setImage(base64Image);
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		 	
		 	
		imageRepo.save(media);
		artRepo.save(image);
	}
	
}
