package com.rest.microservices.restandmircoservices.user;

import java.net.URI;
import java.util.List;


import javax.validation.Valid;

import org.aspectj.weaver.AjAttribute.MethodDeclarationLineNumberAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;

import static org.springframework.hateoas.server.mvc.ControllerLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@CrossOrigin("http://localhost:5100")
@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService service;
	
//	retrieve user
	@GetMapping("/getuser/{id}")
	public EntityModel<User> getUser(@PathVariable int id){
		User user = service.findUser(id);
		
		if(user==null)
			throw new UserNotFoundException("id-"+ id);
		EntityModel<User> resource= new EntityModel<User>(user);
		ControllerLinkBuilder linkTo1 = linkTo(methodOn(this.getClass()).getAllUsers());
        resource.add(linkTo1.withRel("all-users"));
		return resource;
	}
	
//	retrieve all users
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return service.findAllUsers();
	}
//	delete user
	@GetMapping("/deleteuser/{id}")
	public  List<User> deleteUser(@PathVariable int id){
		return service.deleteUser(id);
	}
//	save user
	//input = details of user
	//output = Status CREATED & Return the created URI
	@PostMapping("/saveuser")
	public User saveUser(@RequestBody User user){
		return service.saveUser(user);
	}
//	save user
	//input = details of user
	//output = Status CREATED & Return the created URI
	@PostMapping("/createuser")
	public ResponseEntity<Object> createser(@Valid @RequestBody User user){
		User savedUser =service.saveUser(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	//update
	@PostMapping("/updateUser")
	public ResponseEntity<Object> updateUser(@RequestBody User user){
		User updateUser =service.updateUser(user);
		if(updateUser==null){
			throw new UserNotFoundException("id-"+ user.getId());
		}
		else{
			URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(updateUser.getId()).toUri();
			
			return ResponseEntity.created(location).build();
		}
			
		
	}
	//********************Posts*****************************
//	retrieve post of a specific user
	@GetMapping("/getpostsofuser/{id}")
	public List<Post> getPostsOfAUser(@PathVariable int id){
		List<Post> postsOfAUser = service.getPostsOfAUser(id);
		
		if(postsOfAUser==null)
			throw new UserNotFoundException("id-"+ id);
		
		return postsOfAUser;
	}
//	create a post for user
	@PostMapping("/createpost")
	public ResponseEntity<Object> createPost(@RequestBody Post post){
		Post createdPost =service.createPost(post);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(createdPost.getPostId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
//	retrieve details of a post of a user
	@GetMapping("/getdetailsofpostofuser/{id}/post/{id_post}")
	public Post getdetailsOfPostOfAUser(@PathVariable int id,@PathVariable int id_post){
		Post post=service.getdetailsOfPostOfAUser(id, id_post);
		if(post==null)
			throw new UserNotFoundException("id-"+ id);
		
		return post;
		
	}
	
}
