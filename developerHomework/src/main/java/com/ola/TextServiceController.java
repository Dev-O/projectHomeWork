package com.ola;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("texts")
public class TextServiceController {
	
	// data access object for crude operation against the db
	@Autowired
	public TextRepository textdao;
	

	// return user sent texts
	
	@RequestMapping(method = RequestMethod.POST, 
            produces = "application/json")
    public Object sendAddress3(
       @RequestParam(value = "text", required = false) String text, 
       @RequestParam(value = "userName", required = false) String userName) {
	 
		try{
	    
		long time = System.currentTimeMillis();
	    Timestamp timestamp = new Timestamp(time);
		Text textService = new Text(userName, text, timestamp);
		String xy = create(userName, text,timestamp);
		System.out.println(xy);
	    textService.add(linkTo(methodOn(TextServiceController.class).sendAddress3(text, userName)).withSelfRel());
            
        return new ResponseEntity<Text>(textService, HttpStatus.OK);}
		
		catch(Exception e){
			System.out.print(e.getMessage());
			return e.getMessage();
		}
    }
	
	// this method gets all posted texts
	
	@RequestMapping(value = "{alltext}", method = RequestMethod.GET, 
            produces = "application/json")
    public Object getAllText(
    		@PathVariable("alltext") String alltext) {
		//Iterable<Text> listOfAlltexts = null;
		 List<Text> listOfTexts = new ArrayList<Text>();
		//HttpHeaders responseHeaders = new HttpHeaders();
	   if(alltext != null){
		try{
			 
			
			
			listOfTexts = textdao.findAllTexts();
		
			   
			  // responseHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
			  

			
			   
			   return new ResponseEntity<Iterable<Text>>( listOfTexts, HttpStatus.OK);
			  
		}		   		   
		catch(Exception e){
			return "Exception Encountered";	
		}
		
	   }
	   
	   else {
		   
		   return "URL missing parameter";
	   }
    }
	
	// Endpoint to retrieve all user texts
	
	///employees/234/messages?  texts/olammon/usertexts
	@RequestMapping(value = "{userName}/usertexts", method = RequestMethod.GET, 
            produces = "application/json")
    public Object getAllUserTexts(
    		@PathVariable("userName")  String userName) {
		HttpHeaders responseHeaders = new HttpHeaders();
		if(userName !=null){
		
		List<Text> listOfUsersTexts = new ArrayList<>();
		try{	
	     	// responseHeaders.set("origin", "localhost:/");   
			 listOfUsersTexts= textdao.findByUserName(userName);
			 return new ResponseEntity<List<Text>>(listOfUsersTexts, responseHeaders, HttpStatus.OK);
			  // return listOfUsersTexts; 
		}
		
		catch(Exception ex){
			System.out.print(ex.getMessage());
			return "Exception Encountered";
		}
		
		}
		else   return "URL missing parameter"; 
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
