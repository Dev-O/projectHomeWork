package com.ola;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TextServiceController {
	
	// data access object for crude operation against the db
	@Autowired
	public TextRepository textdao;
	
	/*
	 * ***
	
	@RequestMapping(value = "/texts", method = RequestMethod.GET, 
            produces = "application/json")
    public Object sendAddress(
       @RequestParam(value = "text", required = false, defaultValue = " Hello World") String text) {
		
		try{
			long time = System.currentTimeMillis();
			  Timestamp timestamp = new Timestamp(time);
		Text textService = new Text(text, timestamp);
        
	 textService.add(linkTo(methodOn(TextServiceController.class).sendAddress(text)).withSelfRel());
            
        return new ResponseEntity<Text>(textService, HttpStatus.OK);}
    
	
	catch(Exception e){
		System.out.print(e.getMessage());
		
		return e.getMessage();
	}}
	@RequestMapping(value = "/text", method = RequestMethod.POST, 
            produces = "application/json")
    public Object sendAddress2(
       @RequestParam(value = "text", required = false, defaultValue = " Hello World") String text) {
	 
		try{
			  long time = System.currentTimeMillis();
			  Timestamp timestamp = new Timestamp(time);
		Text textService = new Text(text, timestamp);
	    
		textService.add(linkTo(methodOn(TextServiceController.class).sendAddress(text)).withSelfRel());
            
        return new ResponseEntity<Text>(textService, HttpStatus.OK);}
		
		catch(Exception e){
			System.out.print(e.getMessage());
			
			return e.getMessage();
		}
    }
    
     */
	
	// return user sent texts
	@RequestMapping(value = "/texts", method = RequestMethod.POST, 
            produces = "application/json")
    public Object sendAddress3(
       @RequestParam(value = "text", required = false, defaultValue = " Hello World") String text, 
       @RequestParam(value = "userName", required = true) String userName) {
	 
		try{
			  long time = System.currentTimeMillis();
			  Timestamp timestamp = new Timestamp(time);
		Text textService = new Text(userName, text, timestamp);
		create(userName, text,timestamp);
	    textService.add(linkTo(methodOn(TextServiceController.class).sendAddress3(text, userName)).withSelfRel());
            
        return new ResponseEntity<Text>(textService, HttpStatus.OK);}
		
		catch(Exception e){
			System.out.print(e.getMessage());
			
			return e.getMessage();
		}
    }
	
	// this method gets all posted texts
	
	@RequestMapping(value = "/texts", method = RequestMethod.GET, 
            produces = "application/json")
    public Object getAllText(
       @RequestParam(value = "text", required = false, defaultValue = " Hello World") String text) {
	   
		try{
			 
			  Iterable<Text> listOfAlltexts = textdao.findAll();
			   List<String> containers = new ArrayList<>();
			   for(Text texts : listOfAlltexts){
				   containers.add(texts.getText());   
			   }
	            
       // return new ResponseEntity<List<String>>(containers, HttpStatus.OK);}
			   HttpHeaders responseHeaders = new HttpHeaders();
			   responseHeaders.set("origin", "localhost:/"); 
			   
			   return new ResponseEntity<List<String>>(containers, responseHeaders, HttpStatus.OK);
		}		   		   
		catch(Exception e){
			System.out.print(e.getMessage());
			
			return e.getMessage();
		}
    }
	
	// Endpoint to retrieve all user texts
	@RequestMapping(value = "/texts", method = RequestMethod.GET, 
            produces = "application/json")
    public Object getAllUserTexts(
       @RequestParam(value = "text", required = false, defaultValue = " Hello World") String userName) {
		List<String> listOfUsers = new ArrayList<>(); 
		List<Text> listOfUsersList = new ArrayList<>();
		try{		 
	
			listOfUsers = new ArrayList<>();
			
			listOfUsersList= textdao.findByUserName(userName);
			
			 List<String> containers = new ArrayList<>();
			   for(Text texts : listOfUsersList){
				   listOfUsers.add(texts.getText());   
			   }		
			
		}
		catch(Exception e){
			System.out.print(e.getMessage());
			
			return e.getMessage();
		}
		  if(listOfUsers.size()!= 0){
		        return new ResponseEntity<List<String>>(listOfUsers, HttpStatus.OK);}
			    
			    else 	
			    	return "failure";    
    }
	
	
	
	
	
	// This method creates text object and persist it to the db using hibernate and spring data jpa
	
	
	public String create(String userName , String userPost, Timestamp timestamp) {
	   
	    try {
	        Text text = new Text(userName, userPost, timestamp);
	        textdao.save(text);
	       //userId = String.valueOf(post.getId());
	    }
	    catch (Exception ex) {
	      return "Error storing text in db: " + ex.toString();
	    }
	    return "success";
	  }
	 
}
