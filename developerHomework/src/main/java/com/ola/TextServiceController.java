package com.ola;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TextServiceController {
	
	@RequestMapping(value = "/texts", method = RequestMethod.GET, 
            produces = "application/json")
    public HttpEntity<TextService> sendAddress(
       @RequestParam(value = "postText", required = false, defaultValue = " Hello World") String postText) {
	 TextService textService = new TextService(postText);
        
	 textService.add(linkTo(methodOn(TextServiceController.class).sendAddress(postText)).withSelfRel());
            
        return new ResponseEntity<TextService>(textService, HttpStatus.OK);
    }
	@RequestMapping(value = "/texts", method = RequestMethod.POST, 
            produces = "application/json")
    public HttpEntity<TextService> sendAddress2(
       @RequestParam(value = "postText", required = false, defaultValue = " Hello World") String postText) {
	 TextService textService = new TextService(postText);
        
	 textService.add(linkTo(methodOn(TextServiceController.class).sendAddress(postText)).withSelfRel());
            
        return new ResponseEntity<TextService>(textService, HttpStatus.OK);
    }
	
	 
}
