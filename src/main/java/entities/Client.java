package entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
  
 @Getter @Setter @NoArgsConstructor @AllArgsConstructor 
 @Entity
public class Client {
	 
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCli ;
    private String nomCli ;
    private String prenomCli;
    private String telCli;
    private String emailCli ;
    
    /////
    @Override
    public String toString() {return nomCli+" "+prenomCli;}

	
	
   
    
   


	
    
    
   
    



}

