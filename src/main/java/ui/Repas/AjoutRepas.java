package ui.Repas;

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
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;


import entities.Repas;
import entities.Restaurant;
import metier.IRepasMetier;
import metier.IRestaurantMetier;
import metier.RepasMetier;
import metier.RestaurantMetier;

import java.awt.SystemColor;
import javax.swing.JComboBox;

public class AjoutRepas extends JFrame {

	private JPanel contentPane;
	private JTextField S_NomRepas;
	private JTextField S_TypeRepas;
	private JTextField S_PrixRepas;
	private JTable table;
	
	private IRepasMetier repasmetier= new RepasMetier();
	private IRestaurantMetier restaurantmetier= new RestaurantMetier();

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutRepas frame = new AjoutRepas();
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
	public AjoutRepas() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 931, 637);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
			
		
		JLabel NomRepas = new JLabel("Nom");
		NomRepas.setFont(new Font("Tahoma", Font.BOLD, 14));
		NomRepas.setBounds(54, 43, 72, 14);
		panel.add(NomRepas);
		
		S_NomRepas = new JTextField();
		S_NomRepas.setBounds(203, 42, 180, 20);
		panel.add(S_NomRepas);
		S_NomRepas.setColumns(10);
		
		JLabel TypeRepas = new JLabel("Type");
		TypeRepas.setFont(new Font("Tahoma", Font.BOLD, 14));
		TypeRepas.setBounds(526, 42, 78, 20);
		panel.add(TypeRepas);
		
		S_TypeRepas = new JTextField();
		S_TypeRepas.setBounds(667, 44, 180, 20);
		panel.add(S_TypeRepas);
		S_TypeRepas.setColumns(10);
		
		JLabel PrixRepas = new JLabel("Prix");
		PrixRepas.setFont(new Font("Tahoma", Font.BOLD, 14));
		PrixRepas.setBounds(54, 78, 72, 14);
		panel.add(PrixRepas);
		
		S_PrixRepas = new JTextField();
		S_PrixRepas.setBounds(203, 77, 180, 20);
		panel.add(S_PrixRepas);
		S_PrixRepas.setColumns(10);
		
		JLabel AjoutRepas = new JLabel("Ajouter un repas");
		AjoutRepas.setFont(new Font("Tahoma", Font.BOLD, 16));
		AjoutRepas.setForeground(Color.WHITE);
		AjoutRepas.setBounds(376, 11, 148, 20);
		panel.add(AjoutRepas);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(667, 75, 180, 22);
		panel.add(comboBox);
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		
JButton AjouterRepas = new JButton("Ajouter");
AjouterRepas.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		
		Long IdRepas=null;
		//Long Id=Long.parseLong(S_IdRepas.getText());
		String Nom=S_NomRepas.getText();
		String P=S_PrixRepas.getText();
		float Prix=Float.parseFloat(P);
		
		String Type=S_TypeRepas.getText();
		//Long Qte=Long.parseLong(S_QteRepas.getText());
		Restaurant IdRest=  (Restaurant) comboBox.getSelectedItem();
		//Long IdRest=Long.parseLong(Id1);
		
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		model.addRow(new Object[] {IdRepas,Nom,Prix,Type,IdRest});				
		Repas R1=new Repas(IdRepas,Nom,Prix,Type,IdRest);
		IRepasMetier repasmetier=new RepasMetier();
		
		try {
			repasmetier.addRepas(R1);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}});
		
				
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		
		AjouterRepas.setFont(new Font("Tahoma", Font.BOLD, 16));
		AjouterRepas.setForeground(Color.BLUE);
		AjouterRepas.setBounds(395, 118, 116, 23);
		panel.add(AjouterRepas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 157, 871, 420);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id repas", "Nom", "Prix", "Type", "Id Restaurant"
			}
		));
		scrollPane.setViewportView(table);
		
	
		JLabel lblIdRestaurant = new JLabel("Id Restaurant");
		lblIdRestaurant.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdRestaurant.setBounds(526, 80, 131, 20);
		panel.add(lblIdRestaurant);
		
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		List<Restaurant> restaurants = restaurantmetier.Restaurants();
		for(Restaurant rest:restaurants) {
			comboBox.addItem(rest); }
			
			Restaurant IdRest= (Restaurant) comboBox.getSelectedItem();
	        //Long IdRest=Long.parseLong(Id);
	        //String IdRest = repas1.getRestaurant().getIdRest();
	       
			List<Repas> repass = null;
			try {
				repass = repasmetier.getRepass();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			DefaultTableModel m = (DefaultTableModel) table.getModel();
			for (Repas repas1:repass) {				
			//	Repas Nom=new Repas();
			//	String R=Nom.getRestaurant().getNomRest().toString();
				m.addRow(new Object[] {repas1.getIdRepas(),repas1.getNomRepas(),repas1.getPrixRepas(),repas1.getTypeRepas(),IdRest});			
				}

	
};}

