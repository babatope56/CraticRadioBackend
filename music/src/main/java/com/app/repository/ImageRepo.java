package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entity.UserMedia;

@Repository
public interface ImageRepo extends JpaRepository <UserMedia, Long> {
	
	//	List<UserMedia> findByMusicName(String musicName);
	
	@Query(value="SELECT m FROM UserMedia m where m.musicName like %?1% or m.userEmail like %?1%")
	List<UserMedia> findMusicWithPartOfName(String music );

}
