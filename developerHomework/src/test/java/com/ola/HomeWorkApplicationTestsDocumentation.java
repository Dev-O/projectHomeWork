package com.ola;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class HomeWorkApplicationTestsDocumentation extends DeveloperHomeworkApplicationTests {
	
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
    }
   
@Test
 
    public void validate_get_address() throws Exception {
    	String toput = "?text" + "=How are you" ;
    	mockMvc.perform(get("/texts/" + toput))
        .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.street").value("12345 Horton Ave"))
      //  .andDo(document("address", links( 	
        	//	halLinks(), linkWithRel("Link to the bravo resource"))))
    			.andDo(document("texts", responseFields( 
    					fieldWithPath("street").description("The user's contact details"), 
    					fieldWithPath("state").description("The user's email address"),
    					//fieldWithPath("_links").description("Link to the address resource"),
    					//fieldWithPath("_links.self").description("Link to the self"),
    					fieldWithPath("_links.self.href").description("Link href"),
    					fieldWithPath("email")
						.type(JsonFieldType.STRING) 
						.description("The user's email address"),
    					fieldWithPath("pmb").description("The user's email address")),
    					requestParameters( 
								parameterWithName("name").description("The page to retrieve"))));
    									
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
    /
	
    
    
    */
}

}