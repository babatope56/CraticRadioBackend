package com.app.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="usermedia")
public class UserMedia {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="image_name")
	private String imageName;
	
	@Column(name="image_type")
	private String imageType;
	
	
	@Lob
	@Column(name="image_file")
	private String image;
	
	@Column
	private String userEmail;
	
	@Lob
	@Column(name="music_file")
	private String music;
	
	@Column(name="music_name")
	private String musicName;
	
	@Column(name="music_format")
	private String musicFormat;
	
	public UserMedia() {
		super();
	}
	
	

	public UserMedia(long id, String imageName, String imageType, String image, String userEmail, String music,
			String musicName, String musicFormat) {
		super();
		this.id = id;
		this.imageName = imageName;
		this.imageType = imageType;
		this.image = image;
		this.userEmail = userEmail;
		this.music = music;
		this.musicName = musicName;
		this.musicFormat = musicFormat;
	}


	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getImageType() {
		return imageType;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public String getMusic() {
		return music;
	}

	public void setMusic(String music) {
		this.music = music;
	}

	public String getMusicName() {
		return musicName;
	}


	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}


	public String getMusicFormat() {
		return musicFormat;
	}


	public void setMusicFormat(String musicFormat) {
		this.musicFormat = musicFormat;
	}


	@Override
	public String toString() {
		return "UserMedia [id=" + id + ", imageName=" + imageName + ", imageType=" + imageType + ", image="
				+ ", userEmail=" + userEmail + ", music=" + ", musicName=" + musicName + ", musicFormat=" + musicFormat + "]";
	}


}
