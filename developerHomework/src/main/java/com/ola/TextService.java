package com.ola;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;



public class TextService extends ResourceSupport {
	
    private final String text;

    @JsonCreator
    public TextService( @JsonProperty("text") String text) {   
        this.text = text ;
    }

    public String getText() {
        return text;
    }

}
