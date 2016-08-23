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

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name="OID")
	private Long oid;
	
	@Column(name="TEXT_POSTED", nullable=false,updatable=false)
	private  String text;
	
	@Column(name="USER_NAME", nullable=false,updatable=false)
	private  String userName;
	
	@NotNull
	@Column(name="TIME_CREATED", nullable=false,updatable=false)
	private Timestamp timePosted;
	

    @JsonCreator
    public Text(@JsonProperty("userName") String userName, @JsonProperty("text") String text, @JsonProperty("timePosted") Timestamp timePosted) {   
        this.text= text ;
        this.userName = userName;
        this.timePosted = timePosted;
    }
    
   
    public Long getOid() {
		return oid;
	}

    public void setOid (Long oid) {
		this.oid = oid;
	}
    public Text(){
    	
    }
    
    public String getText(){
    	
    	return text;
    }
    
public void setText(String txt){
    	
    	text =txt;
    }
    
    public Timestamp getTimePosted(){
    	
    	return timePosted;
    }
    
    
 public void getTimePosted(Timestamp tmp){
    	
    	timePosted = tmp;
    }
   
 
public String getUserName(){
 	
 	return userName;
 }

public void setUserName(String tmp){
 	userName = tmp;
 	
 }

 

@Override
public String toString() {
	return "Text [oid=" + oid + ", userName=" + userName + ", text=" + text + ", timePosted=" + timePosted + "]";
}

}
