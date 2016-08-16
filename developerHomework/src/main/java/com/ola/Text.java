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
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "id", updatable = false, nullable = false)
    private long id;
    
	
	@NotNull
	@Column(name="TIME_CREATED", nullable=false,updatable=false)
	private Timestamp timePosted;
	

    @JsonCreator
    public Text( @JsonProperty("text") String text, @JsonProperty("timePosted") Timestamp timePosted) {   
        this.text= text ;
    }
    
    public String getPostedText(){
    	
    	return text;
    }
public long getPostId(){
    	
    	return id;
    }


    public String getText() {
        return text;
    }

}
