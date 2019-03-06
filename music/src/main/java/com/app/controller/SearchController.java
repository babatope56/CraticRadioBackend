package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.UserMedia;
import com.app.repository.ArtRepo;
import com.app.repository.ImageRepo;

@RestController
@CrossOrigin
public class SearchController {
	
	@Autowired
	ImageRepo imageRepo;
	@Autowired
	ArtRepo artRepo;

	
	
/*	public List<UserMedia> findAll (@RequestParam String musicName) {
		return imageRepo.findByMusicName(musicName);
	}
*/
	@RequestMapping(value="/search", produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.GET)
	@ResponseBody
	private ResponseEntity< List <UserMedia>> findUserMedia(String music , String picture ){
		
		List <UserMedia> media = imageRepo.findMusicWithPartOfName(music);
		List <UserMedia> image = artRepo.findImageWithPartOfName(picture);
		
		return new ResponseEntity<>(media, HttpStatus.OK);

	}

}
