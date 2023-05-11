package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.*;

@Entity

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class Repas {
	
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long idRepas ;
    private String nomRepas  ;
    private float prixRepas ;
    private String typeRepas  ;
  //  private Long quantiteRepas  ;

    @ManyToOne
    private Commande commande;
    
    @ManyToOne
    private Restaurant restaurant;
    
 
	
    @Override
    public String toString() {return nomRepas;}


	public Repas(Long idRepas2, String nom, float prix, String type, Restaurant idRest) {
		// TODO Auto-generated constructor stub
	}


	public Repas(Long id, String nom, String type, String prix, Restaurant idRest) {
		// TODO Auto-generated constructor stub
	}



	







	

	

    
   
}
