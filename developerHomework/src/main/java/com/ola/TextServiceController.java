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
	
	@RequestMapping(value = "/texts",  method = RequestMethod.GET, 
            produces = "application/json")
    public HttpEntity<TextService> sendAddress(
       @RequestParam(value = "text", required = false, defaultValue = " Hello World") String text) {
	 TextService textService = new TextService(text);
        
	 textService.add(linkTo(methodOn(TextServiceController.class).sendAddress(text)).withSelfRel());
            
        return new ResponseEntity<TextService>(textService, HttpStatus.OK);
    }
	
	 
}
