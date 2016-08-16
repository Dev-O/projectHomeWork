package com.ola;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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
	
	
	@RequestMapping(value = "/texts", method = RequestMethod.POST, 
            produces = "application/json")
    public Object sendAddress3(
       @RequestParam(value = "text", required = false, defaultValue = " Hello World") String text) {
	 
		try{
			  long time = System.currentTimeMillis();
			  Timestamp timestamp = new Timestamp(time);
		Text textService = new Text(text, timestamp);
		create(text,timestamp);
	    textService.add(linkTo(methodOn(TextServiceController.class).sendAddress(text)).withSelfRel());
            
        return new ResponseEntity<Text>(textService, HttpStatus.OK);}
		
		catch(Exception e){
			System.out.print(e.getMessage());
			
			return e.getMessage();
		}
    }
	
	// This method creates text object and persis it to the db using hibernate and spring data jpa
	
	
	public String create(String userPost, Timestamp timestamp) {
	   
	    try {
	        Text text = new Text(userPost, timestamp);
	        textdao.save(text);
	       //userId = String.valueOf(post.getId());
	    }
	    catch (Exception ex) {
	      return "Error storing text in db: " + ex.toString();
	    }
	    return "text is succesfully stored in db";
	  }
	 
}
