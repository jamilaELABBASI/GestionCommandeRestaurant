package ui.Restaurant;

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

import dao.IResponsableDao;
import dao.IRestaurantDao;
import dao.ResponsableDao;
import dao.RestaurantDao;
import entities.Client;
import entities.Responsable;
import entities.Restaurant;
import metier.IResponsableMetier;
import metier.IRestaurantMetier;
import metier.ResponsableMetier;
import metier.RestaurantMetier;

import java.awt.SystemColor;
import javax.swing.JComboBox;

public class AjoutRest extends JFrame {

	private JPanel contentPane;
	private JTextField S_NomRest;
	private JTextField S_AdresRest;
	private JTextField S_TelRest;
	private JTextField S_EmailRest;
	private JTable table;
	

	private IRestaurantMetier restaurantmetier=new RestaurantMetier();
	private IRestaurantDao restaurantdao=new RestaurantDao();
	private IResponsableMetier respmetier=new ResponsableMetier();
	private IResponsableMetier respdao=new ResponsableMetier();

	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutRest frame = new AjoutRest();
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
	public AjoutRest() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 877, 637);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel NomRest = new JLabel("Nom");
		NomRest.setFont(new Font("Tahoma", Font.BOLD, 14));
		NomRest.setBounds(460, 52, 72, 19);
		panel.add(NomRest);
		
		S_NomRest = new JTextField();
		S_NomRest.setBounds(609, 51, 180, 20);
		panel.add(S_NomRest);
		S_NomRest.setColumns(10);
		
		JLabel TelRest = new JLabel("Telephone");
		TelRest.setFont(new Font("Tahoma", Font.BOLD, 14));
		TelRest.setBounds(460, 83, 78, 20);
		panel.add(TelRest);
		
		S_TelRest = new JTextField();
		S_TelRest.setBounds(609, 82, 180, 20);
		panel.add(S_TelRest);
		S_TelRest.setColumns(10);
		
		JLabel EmailRest = new JLabel("Email");
		EmailRest.setFont(new Font("Tahoma", Font.BOLD, 14));
		EmailRest.setBounds(52, 86, 72, 14);
		panel.add(EmailRest);
		
		S_EmailRest = new JTextField();
		S_EmailRest.setBounds(201, 83, 180, 20);
		panel.add(S_EmailRest);
		S_EmailRest.setColumns(10);
		
		JLabel AdresseRest = new JLabel("Adresse");
		AdresseRest.setFont(new Font("Tahoma", Font.BOLD, 14));
		AdresseRest.setBounds(52, 58, 72, 14);
		panel.add(AdresseRest);
		
		S_AdresRest = new JTextField();
		S_AdresRest.setBounds(201, 57, 180, 20);
		panel.add(S_AdresRest);
		S_AdresRest.setColumns(10);
		
	
		JLabel AjoutRest = new JLabel("Ajouter un restaurant");
		AjoutRest.setBackground(SystemColor.window);
		AjoutRest.setFont(new Font("Tahoma", Font.BOLD, 20));
		AjoutRest.setForeground(SystemColor.window);
		AjoutRest.setBounds(308, 11, 239, 20);
		panel.add(AjoutRest);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(201, 109, 180, 22);
		panel.add(comboBox);
		
		
/////////////////////////////////////////////////////////////////////////////
JButton AjouterRest = new JButton("Ajouter");
AjouterRest.setBackground(Color.WHITE);

AjouterRest.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		
		Long Id=null;
		String Nom =S_NomRest.getText();
		String Tel=S_TelRest.getText();
		String Email=S_EmailRest.getText();
		String Adres=S_AdresRest.getText();
		Responsable r =(Responsable) comboBox.getSelectedItem();
		
		

		DefaultTableModel model=(DefaultTableModel) table.getModel();
		model.addRow(new Object[] {Id,Nom,Tel,Email,Adres,r});				

		
		Restaurant c =new Restaurant(Id,Nom,Tel,Email,Adres,r);
		System.out.println(c.getNomRest());
		
			try {
				restaurantmetier.addRestaurant(c);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
	}
});
		
//////////////////////////////////////////////////////////////////////////////
		AjouterRest.setFont(new Font("Tahoma", Font.BOLD, 16));
		AjouterRest.setForeground(SystemColor.inactiveCaptionText);
		AjouterRest.setBounds(381, 144, 116, 23);
		panel.add(AjouterRest);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 178, 831, 399);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBackground(SystemColor.window);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id Restaurant", "Nom", "Telephone", "Email", "Adresse","Nom Responsable"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNomResponsable = new JLabel("Nom Responsable");
		lblNomResponsable.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNomResponsable.setBounds(52, 113, 124, 14);
		panel.add(lblNomResponsable);
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		
		List<Responsable> resps= respdao.getResponsables();
		for(Responsable resp:resps) {
			comboBox.addItem(resp);
		       }
/////////////////////////////// recover data from data base to jtable/////////////////////////////////		
		
		Object  NomResp= comboBox.getSelectedItem();

		List<Restaurant> restaurants = restaurantmetier.Restaurants();
		DefaultTableModel m = (DefaultTableModel) table.getModel();
		for (Restaurant restaurant:restaurants) {

		m.addRow(new Object[] {restaurant.getIdRest(),restaurant.getNomRest(),restaurant.getTelRest(),restaurant.getEmailRest(),
				restaurant.getAdresseRest(),NomResp});			
		}	


	}
}
