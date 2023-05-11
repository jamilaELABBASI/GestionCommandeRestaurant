package entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class RepasRest {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long idRest ;
    private Long idRepas ;
    
    //@OneToMany
    //List<Repas> Repass;
    
	
    
}
