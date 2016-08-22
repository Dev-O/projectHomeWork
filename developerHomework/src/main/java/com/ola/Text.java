package com.ola;
import java.sql.Timestamp;
import javax.validation.constraints.NotNull;
import org.springframework.hateoas.ResourceSupport;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "Posts")
public class Text extends ResourceSupport {

	@Column(name="TEXT_POSTED", nullable=false,updatable=false)
	private final String text;
	
	@Column(name="USER _ NAME", nullable=false,updatable=false)
	private final String userName;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "id", updatable = false, nullable = false)
    private long id;
    
	
	@NotNull
	@Column(name="TIME_CREATED", nullable=false,updatable=false)
	private Timestamp timePosted;
	

    @JsonCreator
    public Text(@JsonProperty("userName") String userName, @JsonProperty("text") String text, @JsonProperty("timePosted") Timestamp timePosted) {   
        this.text= text ;
        this.userName = userName;
    }
    
    public String getText(){
    	
    	return text;
    }
  
 public Timestamp getTimePosted(){
    	
    	return timePosted;
    }
 
 public String getUserName(){
 	
 	return userName;
 }
 



}
