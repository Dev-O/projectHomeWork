package com.ola;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;



public class TextService extends ResourceSupport {
	
    private final String postText;

    @JsonCreator
    public TextService( @JsonProperty("postText") String postText) {   
        this.postText= postText ;
    }

    public String getText() {
        return postText;
    }

}
