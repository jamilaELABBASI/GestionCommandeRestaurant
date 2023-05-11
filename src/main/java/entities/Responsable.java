package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor  @ToString
public class Responsable {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResp ;
    private String nomResp ;
    private String prenomResp ;
    private String telResp;
    private String emailResp ;
    private String adresseResp ;
    
    @Override
    public String toString() {return nomResp+" "+prenomResp;}

   
     
	

	

	
    
    
	
    
    
}
