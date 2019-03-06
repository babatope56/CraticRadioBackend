package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entity.AlbumImage;
import com.app.entity.UserMedia;

@Repository
public interface ArtRepo extends JpaRepository <AlbumImage, Long>{
	
	
	@Query(value="SELECT m FROM UserMedia m where m.musicName =image or m.userEmail like %?1%")
	List<UserMedia> findImageWithPartOfName(String picture);


}
