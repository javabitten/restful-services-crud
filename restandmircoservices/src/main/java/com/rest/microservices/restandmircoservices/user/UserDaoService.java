package com.rest.microservices.restandmircoservices.user;

import java.util.ArrayList;
import java.util.Date;

import org.mockito.internal.matchers.Find;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@CrossOrigin("http://localhost:5100")
@Component
public class UserDaoService {

	
	private static List<User> users= new ArrayList<>();
	private static List<Post> posts= new ArrayList<>();
	private static int userId=4;
	private static int postId=5;
	
	@Override
	public String toString() {
		return "UserDaoService [findAllUsers()=" + findAllUsers() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	static {
		
		users.add(new User(1,"usman",new Date()));
		users.add(new User(2,"junaid",new Date()));
		users.add(new User(3,"farhan",new Date()));
		users.add(new User(4,"bilal",new Date()));
	}
	static {
		List<Integer> userIds= new ArrayList<>();
		userIds.add(1);
		userIds.add(3);
		
		List<Integer> userIds1= new ArrayList<>();
		userIds1.add(2);
		userIds1.add(4);
		
		List<Integer> userIds2= new ArrayList<>();
		userIds2.add(1);
		userIds2.add(3);
		
		List<Integer> userIds3= new ArrayList<>();
		userIds3.add(2);
		userIds3.add(4);
		
		List<Integer> userIds4= new ArrayList<>();
		userIds4.add(1);
		userIds4.add(3);
		
		
		posts.add(new Post(1,userIds,"this is the post 1","image source"));
		posts.add(new Post(2,userIds1,"this is the post 2","image source_1"));
		posts.add(new Post(3,userIds2,"this is the post 3","image source_2"));
		posts.add(new Post(4,userIds3,"this is the post 4","image source_3"));
		posts.add(new Post(5,userIds4,"this is the post 5","image source_4"));
		
		
	}
	//findAll
	public List<User> findAllUsers(){
		return users;
	}
	//saveUser
	public User saveUser(User user){
		if(user.getId()==null){
			user.setId(userId++);
		}
		users.add(user);
		return user;
	}
	//findOne
	public User findUser(int id){
		for(User user:users){
			if(id==user.getId()){
				return user;
			}
		}
		return null;
	}
	//deleteOne
	public List<User> deleteUser(int id){
		users.removeIf(u->u.getId()==id);
		return users;
	}
	//deleteAll
	//update user
	public User updateUser(User user){
		boolean userFound=false;
		for(User userItr:users){
			if(user.getId()==userItr.getId()){
				users.remove(userItr);
				users.add(user);
				userFound=true;
				break;
			}
		}
		if(userFound){
			return user;
		}
		else{
			return null;
		}
		
	}
	public List<Post> getPostsOfAUser(int id){
		List<Post> listOfPost=new ArrayList<>();
		for(Post post:posts){
			for(Integer userId:post.getUserIds()){
				if(userId==id){
					listOfPost.add(post);					
				}
			}
		}
		if(listOfPost.size()==0){
			return listOfPost=null;
		}
		else{
			return listOfPost;
		}
		
	}
	//create post
		public Post createPost(Post post){
			if(post.getPostId()==null){
				post.setPostId(++postId);
			}
			posts.add(post);
			return post;
		}
	
	//getdetailsOfPostOfAUser
		public Post getdetailsOfPostOfAUser(int id,int id_post){
			Post postScope=null;
			for(Post post:posts){
				if(post.getPostId().equals(id_post) && post.getUserIds().contains(id)){
					postScope=post;
					return postScope;
				}
			}
			return postScope;
			
		}
	
}
