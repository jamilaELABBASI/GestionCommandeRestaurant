package entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.*;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor  //@ToString
public class Restaurant {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	
    private Long idRest ;
    private String nomRest ;
    private String  telRest;
    private String emailRest ;
    private String adresseRest ;
    
    @ManyToOne
     Responsable responsable;
	
    @Override
    public String toString() {return idRest+"";}

	

	public Restaurant(Long id, String nom, String tel, String email, String adres, String nomResp) {
		// TODO Auto-generated constructor stub
	}

	

	
   
   //public String toString1() {return nomRest+"";}








    
    
    
}
