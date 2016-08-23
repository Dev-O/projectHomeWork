package com.ola;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class HomeWorkApplicationTestsDocumentation extends DeveloperHomeworkApplicationTests {
	
	@Autowired
	public TextRepository textDao;
	
	@Rule
	public JUnitRestDocumentation restDocumentation =
			new JUnitRestDocumentation("target/generated-snippets");
	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext webApplicationContext;

   
    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext)
                .apply(documentationConfiguration(this.restDocumentation))
                .build();
        long time = System.currentTimeMillis();
	    Timestamp timestamp = new Timestamp(time);
        Text textEntry = new Text("bode", "well lets see", timestamp);
        textDao.save(textEntry);
        long time2 = System.currentTimeMillis();
	    Timestamp timestamp2 = new Timestamp(time2);
        Text textEntry2 = new Text("Alex", "can i come", timestamp2);
        textDao.save(textEntry2);
        long time3 = System.currentTimeMillis();
	    Timestamp timestamp3 = new Timestamp(time3);
        Text textEntry3 = new Text("ibro", "hello there", timestamp3);
        textDao.save(textEntry3);
        long time4 = System.currentTimeMillis();
	    Timestamp timestamp4 = new Timestamp(time4);
        Text textEntry4 = new Text("lola", "hi i am ", timestamp4);
        textDao.save(textEntry4);
        //Iterable<Text> listOfAlltexts = null;
		 List<Text> listOfTexts = new ArrayList<Text>();
		 listOfTexts  = textDao.findAllTexts();
	   	   
		   
		  // responseHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		  
		for(Text text : listOfTexts){
			// listOfTexts.add(text);
			 System.out.println(text);	 
		 }
		   
   
    System.out.println(listOfTexts);
    }
    
    
@Test
 
    public void validate_get_text() throws Exception {
    	String toput = "?text" + "=How are you" +"&" + "userName" + "=olammon";
    	
    	
    	//"/texts/?text=How are you&";
    	mockMvc.perform(post("/texts/" + toput))
        .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
               .andExpect(jsonPath("$.text").value("How are you"))
               .andExpect(jsonPath("$.userName").value("olammon"))
    			.andDo(document("texts", responseFields( 
    					fieldWithPath("text").description("The user's texts"), 
    					fieldWithPath("userName").description("The user's handle"),
    					fieldWithPath("timePosted").description("The user's handle"),
    					fieldWithPath("_links.self.href").description("Link href"),
    					fieldWithPath("oid").ignored()),
    					requestParameters( 
								parameterWithName("text").description("The text to return")
								,parameterWithName("userName").description("The handle of the user"))));
    	
    	
    	
    									
        /*
    									.andDo(document("locations", pathParameters( 
    											parameterWithName("latitude").description("The location's latitude"), 
    											parameterWithName("longitude").description("The location's longitude") 
    									)))
    									.andDo(document("headers",
    											requestHeaders( 
    													headerWithName("Authorization").description(
    															"Basic auth credentials")), 
    											responseHeaders( 
    													headerWithName("X-RateLimit-Limit").description(
    															"The total number of requests permitted per period"),
    													headerWithName("X-RateLimit-Remaining").description(
    															"Remaining requests permitted in current period"),
    													headerWithName("X-RateLimit-Reset").description(
    															"Time at which the rate limit period will reset"))));
    */
	
    
    
    
}


    
    

@Test
public void getAlltext() throws Exception {
	
	mockMvc.perform(get("/texts/{alltext}" , "alltexton" ))
    .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			.andDo(document("texts", responseFields( 
					 
					fieldWithPath("[].userName").description("The user's handle"),
					fieldWithPath("[].text").description("The user's handle"),
					fieldWithPath("[].timePosted").description("The user's handle"),
					fieldWithPath("[].oid").description("The user's texts"),
					fieldWithPath("[].links").ignored()),
					pathParameters( 
							parameterWithName("alltext").description("The handle of the user"))));									
}
  }
	




