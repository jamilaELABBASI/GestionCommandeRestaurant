package ui.Restaurant;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import entities.Responsable;
import entities.Restaurant;
import metier.IRestaurantMetier;
import metier.RestaurantMetier;

public class SupRest extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	//private IRestaurantDao restdao=new RestaurantDao();
    private IRestaurantMetier restmetier=new RestaurantMetier();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupRest frame = new SupRest();
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
	public SupRest() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 878, 639);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel SupRest = new JLabel("Supprimer un restaurant");
		SupRest.setFont(new Font("Tahoma", Font.BOLD, 20));
		SupRest.setForeground(SystemColor.window);
		SupRest.setBounds(276, 11, 261, 20);
		panel.add(SupRest);

////////////////////////////////////////////////////////////////////////////////
				
				JButton SupprimerRest = new JButton("Supprimer");
				SupprimerRest.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
		    int index=table.getSelectedRow();
						
			Long id=(Long) table.getValueAt(index, 0);
			String nom=(String) table.getValueAt(index, 1);
		    String tel=(String) table.getValueAt(index, 2);
			String email=(String) table.getValueAt(index, 3);
			String adres=(String) table.getValueAt(index, 4);
			Responsable NomResp=(Responsable) table.getValueAt(index, 5);
		
			
			DefaultTableModel m1 = (DefaultTableModel) table.getModel();
			m1.removeRow(index);
			
		
			try {
				Restaurant r=new Restaurant(id,nom,tel,email,adres,NomResp);
				restmetier.deleteRestaurant(r);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
					}
				});
				
////////////////////////////////////////////////////////////////////////////////////
		SupprimerRest.setFont(new Font("Tahoma", Font.BOLD, 16));
		SupprimerRest.setForeground(SystemColor.inactiveCaptionText);
		SupprimerRest.setBounds(352, 556, 116, 23);
		panel.add(SupprimerRest);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 58, 832, 481);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id Restaurant", "Nom", "Telephone", "Email", "Adresse","Nom responsable"
			}
		));
		scrollPane.setViewportView(table);
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

		JButton Supprimer= new JButton("Supprimer");
		SupprimerRest.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			int index=table.getSelectedRow();
			
			Long id=(Long) table.getValueAt(index, 0);
			String nom=(String) table.getValueAt(index, 1);
			String tel=(String) table.getValueAt(index, 2);
			String email=(String) table.getValueAt(index, 3);
			String adres=(String) table.getValueAt(index, 4);
			Responsable NomResp=(Responsable) table.getValueAt(index,5);


			
			DefaultTableModel m = (DefaultTableModel) table.getModel();
			m.removeRow(index);
			

			IRestaurantMetier restaurantmetier=new RestaurantMetier();
			try {
				Restaurant r=new Restaurant(id,nom,tel,email,adres,NomResp);
				restaurantmetier.deleteRestaurant(r);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
});
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		List<Restaurant> restaurants = null;
		try {
			restaurants = restmetier.Restaurants();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DefaultTableModel m = (DefaultTableModel) table.getModel();
		for (Restaurant restaurant:restaurants) {
			//String NomResp=restaurant.getResponsable().getNomResp()+","+restaurant.getResponsable().getPrenomResp();
		m.addRow(new Object[] {restaurant.getIdRest(),restaurant.getNomRest(),restaurant.getTelRest(),
				restaurant.getEmailRest(),restaurant.getAdresseRest(),restaurant.getResponsable()});			
		}
		


	}}
