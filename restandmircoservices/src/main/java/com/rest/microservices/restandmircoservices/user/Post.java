package com.rest.microservices.restandmircoservices.user;

import java.util.ArrayList;
import java.util.List;

public class Post {
	private Integer postId;
	private List<Integer> userIds= new ArrayList<>();
	private String description;
	private String img_url;
	
	public Post(){
		
	}
	
	public Post(Integer postId, List<Integer> userIds, String description, String img_url) {
		super();
		this.postId = postId;
		this.userIds = userIds;
		this.description = description;
		this.img_url = img_url;
	}
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public List<Integer> getUserIds() {
		return userIds;
	}
	public void setUserIds(List<Integer> userIds) {
		this.userIds = userIds;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	
	
	
}
