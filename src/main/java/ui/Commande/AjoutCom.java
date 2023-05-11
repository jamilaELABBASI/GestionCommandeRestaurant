package ui.Commande;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;



import dao.IRepasDao;
import dao.RepasDao;
import entities.Client;
import entities.Commande;
import entities.Repas;
import metier.ClientMetier;
import metier.CommandeMetier;
import metier.IClientMetier;
import metier.ICommandeMetier;

import java.awt.SystemColor;
import javax.swing.JComboBox;

public class AjoutCom extends JFrame {

	private JPanel contentPane;
	private JTextField S_QuantiteCom;
	private JTable table;
	
	private IClientMetier clientmetier=new ClientMetier();
	private ICommandeMetier cmdmetier=new CommandeMetier();


	private IRepasDao repasmetier=new RepasDao();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
					AjoutCom frame = null;
					try {
						frame = new AjoutCom();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					frame.setVisible(true);
				
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public AjoutCom() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 877, 635);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel NomRepasCom = new JLabel("Nom repas");
		NomRepasCom.setFont(new Font("Tahoma", Font.BOLD, 14));
		NomRepasCom.setBounds(534, 72, 89, 19);
		panel.add(NomRepasCom);
		
		JLabel QuantiteCom = new JLabel("Quantite");
		QuantiteCom.setFont(new Font("Tahoma", Font.BOLD, 14));
		QuantiteCom.setBounds(538, 105, 72, 14);
		panel.add(QuantiteCom);
		
		S_QuantiteCom = new JTextField();
		S_QuantiteCom.setBounds(643, 105, 180, 20);
		panel.add(S_QuantiteCom);
		S_QuantiteCom.setColumns(10);
		
		JLabel DateCom = new JLabel("Date");
		DateCom.setFont(new Font("Tahoma", Font.BOLD, 14));
		DateCom.setBounds(51, 74, 72, 14);
		panel.add(DateCom);
		
		JLabel AjoutCom = new JLabel("Ajouter une commande");
		AjoutCom.setFont(new Font("Tahoma", Font.BOLD, 20));
		AjoutCom.setForeground(SystemColor.window);
		AjoutCom.setBounds(317, 11, 236, 28);
		panel.add(AjoutCom);
		
		JComboBox<Repas> comboBox_1 = new JComboBox<Repas>();
		
		comboBox_1.setEditable(true);
		comboBox_1.setBounds(643, 72, 180, 22);
		panel.add(comboBox_1);
		
		JComboBox<String> comboBox_3 = new JComboBox<String>();
		comboBox_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_3.setBounds(202, 72, 224, 22);
		panel.add(comboBox_3);
	
		JComboBox<Client> comboBox_4 = new JComboBox<Client>();
		comboBox_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_4.setBounds(202, 105, 224, 22);
		panel.add(comboBox_4);
		//JComboBox<Repas> comboBox_2 = new JComboBox<Repas>();
		
		
///////////////////////////////////////////////////////////////////////////////////////////////
		
		JButton AjouterCli = new JButton("Ajouter");
		
//////////////////////////////////////////////////////////////////////////////////////////////////
		
		AjouterCli.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				//long IdCmd =0;
				//String NomCli =(String) comboBox.getSelectedItem().toString();
				Repas NomRepas=(Repas) comboBox_1.getSelectedItem();
				String Date=(String) comboBox_3.getSelectedItem();
				Double Qte=Double.parseDouble(S_QuantiteCom.getText());
				Client c=(Client) comboBox_4.getSelectedItem();
				
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				model.addRow(new Object[] {null,NomRepas,Date,Qte,c});				
				
				
				Commande commande =new Commande(null,NomRepas,Date,Qte,c);
				try {
					cmdmetier.addCommande(commande);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				}
			}
		);
//////////////////////////////////////////////////////////////////////////////////////////////
		AjouterCli.setBackground(Color.WHITE);
	
		AjouterCli.setFont(new Font("Tahoma", Font.BOLD, 16));
		AjouterCli.setForeground(SystemColor.inactiveCaptionText);
		AjouterCli.setBounds(371, 132, 116, 23);
		panel.add(AjouterCli);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 166, 831, 409);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id Commande", "Nom Repas", "Date", "Quantite", "Nom client"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel NomCom_1 = new JLabel("Nom client");
		NomCom_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		NomCom_1.setBounds(51, 107, 101, 14);
		panel.add(NomCom_1);
		
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		// remplir combobox  nom du repas	

		List<Repas> repass = repasmetier.getRepass();
		for(Repas repas:repass) {
			  comboBox_1.addItem(repas);
			
	    //System.out.println(repass.size());
		//System.out.println(repas.getNomRepas());
		       }
		// remplir combobox  date 
		String timeStamp = new SimpleDateFormat("yyyy-"+"MM"+"-dd"+"____"+"HH:"+"mm"+":ss").format(Calendar.getInstance().getTime());
		comboBox_3.addItem(timeStamp);
			
		// remplir combobox  nom complet clients	
		
				List<Client> cls = clientmetier.getClients();
				for(Client c:cls) {
					comboBox_4.addItem(c);;
				}
			
/////////////////////////////// recover data from data base to jtable/////////////////////////////////			
List<Commande> commandes = cmdmetier.getCommandes();
DefaultTableModel m = (DefaultTableModel) table.getModel();
for (Commande cmd:commandes) {
	     
	Repas NomRepas=(Repas) comboBox_1.getSelectedItem();
	String Date=(String) comboBox_3.getSelectedItem();
	Client NomCli= (Client) comboBox_4.getSelectedItem();
    //double x=cmd.getQte();
    m.addRow(new Object[] {cmd.getIdCmd(),NomRepas,Date,cmd.getQte(),NomCli});			
}

			
			
			
			
	}
}
