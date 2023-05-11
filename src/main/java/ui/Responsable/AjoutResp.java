package ui.Responsable;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import dao.ClientDao;
import dao.IClientDao;
import dao.IResponsableDao;
import dao.ResponsableDao;
import entities.Client;
import entities.Responsable;
import metier.ClientMetier;
import metier.IClientMetier;
import metier.IResponsableMetier;
import metier.ResponsableMetier;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AjoutResp extends JFrame {

	private JPanel contentPane;
	private JTextField S_NomResp;
	private JTextField S_PrenomResp;
	private JTextField S_TelResp;
	private JTextField S_EmailResp;
	private JTable table;
	
	private IResponsableMetier responsablemetier=new ResponsableMetier();
	private IResponsableDao responsabledao=new ResponsableDao();
	
	private JTextField S_AdresseResp;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutResp frame = new AjoutResp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public AjoutResp() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 941, 635);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setForeground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel NomResp = new JLabel("Nom");
		NomResp.setFont(new Font("Tahoma", Font.BOLD, 14));
		NomResp.setBounds(41, 53, 72, 14);
		panel.add(NomResp);
		
		JLabel PrenomResp = new JLabel("Prenom");
		PrenomResp.setFont(new Font("Tahoma", Font.BOLD, 14));
		PrenomResp.setBounds(41, 85, 72, 14);
		panel.add(PrenomResp);
		
		S_NomResp = new JTextField();
		S_NomResp.setColumns(10);
		S_NomResp.setBounds(190, 52, 180, 20);
		panel.add(S_NomResp);
		
		S_PrenomResp = new JTextField();
		S_PrenomResp.setColumns(10);
		S_PrenomResp.setBounds(190, 84, 180, 20);
		panel.add(S_PrenomResp);
		
		JLabel TeleResp = new JLabel("Telephone");
		TeleResp.setFont(new Font("Tahoma", Font.BOLD, 14));
		TeleResp.setBounds(526, 54, 78, 14);
		panel.add(TeleResp);
		
		S_TelResp = new JTextField();
		S_TelResp.setColumns(10);
		S_TelResp.setBounds(675, 53, 180, 20);
		panel.add(S_TelResp);
		
		JLabel EmailResp = new JLabel("Email");
		EmailResp.setFont(new Font("Tahoma", Font.BOLD, 14));
		EmailResp.setBounds(526, 95, 72, 14);
		panel.add(EmailResp);
		
		S_EmailResp = new JTextField();
		S_EmailResp.setColumns(10);
		S_EmailResp.setBounds(675, 92, 180, 20);
		panel.add(S_EmailResp);
		
		JLabel AjoutResp = new JLabel("Ajouter un Reponsable");
		AjoutResp.setForeground(SystemColor.window);
		AjoutResp.setFont(new Font("Tahoma", Font.BOLD, 16));
		AjoutResp.setBounds(351, 21, 187, 20);
		panel.add(AjoutResp);
		
////////////////////////////////////////////////////////////////////////////////
		
		JButton AjouterResp = new JButton("Ajouter");
		AjouterResp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Nom =S_NomResp.getText();
				String Prenom=S_PrenomResp.getText();
				String Tel=S_TelResp.getText();
				String Email=S_EmailResp.getText();
				String Adres=S_AdresseResp.getText();

				
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				model.addRow(new Object[] {null,Nom,Prenom,Tel,Email,Adres});				
				
				IResponsableMetier responsablemetier=new ResponsableMetier();
				
				
				Responsable c =new Responsable(null,Nom,Prenom,Tel,Email,Adres);
				try {
					responsablemetier.addResponsable(c);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}	
				
			}
		});
	
//////////////////////////////////////////////////////////////////////////////////
		AjouterResp.setForeground(SystemColor.desktop);
		AjouterResp.setFont(new Font("Tahoma", Font.BOLD, 16));
		AjouterResp.setBounds(383, 166, 116, 23);
		panel.add(AjouterResp);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 216, 895, 359);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id Responsable", "Nom", "Prenom", "Telephone", "Email", "Adresse"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel Adresse = new JLabel("Adresse");
		Adresse.setFont(new Font("Tahoma", Font.BOLD, 14));
		Adresse.setBounds(41, 116, 72, 14);
		panel.add(Adresse);
		
		S_AdresseResp = new JTextField();
		S_AdresseResp.setColumns(10);
		S_AdresseResp.setBounds(190, 115, 180, 20);
		panel.add(S_AdresseResp);
		
		
/////////////////////////////// recover data from data base to jtable/////////////////////////////////			
		List<Responsable> responsables = responsabledao.Responsables();
		DefaultTableModel m = (DefaultTableModel) table.getModel();
		for (Responsable responsable:responsables) {
		m.addRow(new Object[] {responsable.getIdResp(),responsable.getNomResp(),responsable.getPrenomResp(),responsable.getTelResp(),responsable.getEmailResp(),responsable.getAdresseResp()});			
		}	
		
			}
		}
