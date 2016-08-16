package com.ola;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TextServiceController {
	
	@RequestMapping("/texts")
    public TextService getTextService(@RequestParam(value="text", defaultValue="Hello world") String text) {
        return new TextService(text);
    }
}
