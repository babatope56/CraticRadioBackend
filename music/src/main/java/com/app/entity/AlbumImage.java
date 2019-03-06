package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="albumArt")
public class AlbumImage {

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
	
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public AlbumImage() {
		super();
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public AlbumImage(long id, String imageName, String imageType, String image, String userEmail) {
		super();
		this.id = id;
		this.userEmail = userEmail;
		this.imageName = imageName;
		this.imageType = imageType;
		this.image = image;
	}

	@Override
	public String toString() {
		return "AlbumImage [id=" + id + ", imageName=" + imageName + ", imageType=" + imageType + ", image=" + image
				+ ", userEmail=" + userEmail + "]";
	}
	
	
	
}
