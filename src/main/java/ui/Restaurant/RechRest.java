package ui.Restaurant;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import entities.Restaurant;
import metier.IRestaurantMetier;
import metier.RestaurantMetier;

public class RechRest extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField RechercherRest;
	IRestaurantMetier restmetier = new RestaurantMetier();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RechRest frame = new RechRest();
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
	public RechRest() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 877, 639);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel RechRest = new JLabel("Rechercher une commande");
		RechRest.setFont(new Font("Tahoma", Font.BOLD, 20));
		RechRest.setForeground(SystemColor.window);
		RechRest.setBounds(257, 24, 286, 20);
		panel.add(RechRest);

////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JButton Rechercher = new JButton("Rechercher");
		Rechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				DefaultTableModel model=(DefaultTableModel)table.getModel();
				TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(model);
				table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(RechercherRest.getText().trim()));
				
			}
		});
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		Rechercher.setFont(new Font("Tahoma", Font.BOLD, 16));
		Rechercher.setForeground(SystemColor.inactiveCaptionText);
		Rechercher.setBounds(572, 53, 132, 23);
		panel.add(Rechercher);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 107, 831, 439);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id Restaurant", "Nom", "Adresse", "Telephone", "Email", "Nom Responsable"
			}
		));
		scrollPane.setViewportView(table);
		
		RechercherRest = new JTextField();
		RechercherRest.setBounds(108, 56, 116, 20);
		panel.add(RechercherRest);
		RechercherRest.setColumns(10);
		
		


		List<Restaurant> restaurants = restmetier.Restaurants();
		DefaultTableModel m = (DefaultTableModel) table.getModel();
		for (Restaurant restaurant:restaurants) {
		
			//Object  NomResp= AjoutRest.comboBox.getSelectedItem();

        String NomResp = null;
		m.addRow(new Object[] {restaurant.getIdRest(),restaurant.getNomRest(),restaurant.getTelRest(),restaurant.getEmailRest(),
				restaurant.getAdresseRest(),NomResp});			
		}	

		
		
		
		
		
	}
}
