
package entities;


import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
@Entity 

public class LigneCom {
	
	private Long idLigneCmd ;
	//private double qte;
	private Long idCmd ;
    private Long idRepas ;
    
    
    @ManyToOne
    private Commande cmd;
    
    
    
   

}
