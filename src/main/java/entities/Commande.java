package entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.*;

@Getter @Setter  @AllArgsConstructor @NoArgsConstructor @ToString
@Entity

public class Commande {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)	//private Long idCom;
	private Long idCmd ;
	private Date date;
	private double Qte;
   // private double Montant;
	

	@ManyToOne
    private Client client;
	@ManyToOne
	private Repas repas;
	

	
	public Commande(Object idCmd2, Repas nomRepas, String date2, Double qte2, Client c) {
		// TODO Auto-generated constructor stub
	}
	
	public Commande(Long id, String nom, String date2, java.util.Date qte2, String nomCli) {
		// TODO Auto-generated constructor stub
	}



   
   
}
