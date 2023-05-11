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

import dao.IRepasDao;
import dao.RepasDao;
import entities.Repas;
import entities.Restaurant;
import metier.IRepasMetier;
import metier.RepasMetier;
import java.awt.SystemColor;

public class SupRepas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	private IRepasDao repasdao= new RepasDao();
	private IRepasMetier repasmetier= new RepasMetier();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupRepas frame = new SupRepas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SupRepas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 962, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel AjoutCom = new JLabel("Supprimer un repas");
		AjoutCom.setFont(new Font("Tahoma", Font.BOLD, 16));
		AjoutCom.setForeground(Color.WHITE);
		AjoutCom.setBounds(370, 11, 187, 20);
		panel.add(AjoutCom);

////////////////////////////////////////////////////////////////////////////////////////////
JButton SupRepas = new JButton("Supprimer");
SupRepas.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		
		int index=table.getSelectedRow();
		Long id=(Long) table.getValueAt(index, 0);
		String Nom=(String) table.getValueAt(index, 1);
		float Prix= (float) table.getValueAt(index, 2);
		String Type=(String) table.getValueAt(index, 3);
		Restaurant IdRest= (Restaurant) table.getValueAt(index, 4);
		//Long Qte=(Long) table.getValueAt(index, 4);
		
		
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		model.removeRow(index);
		
		IRepasMetier repasmetier=new RepasMetier();
				
			try {
				repasmetier.deleteRepas(new Repas(id,Nom,Prix,Type,IdRest));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	}
});
/////////////////////////////////////////////////////////////////////////////////////////////
		SupRepas.setFont(new Font("Tahoma", Font.BOLD, 16));
		SupRepas.setForeground(Color.BLUE);
		SupRepas.setBounds(420, 559, 137, 23);
		panel.add(SupRepas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 76, 916, 469);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id Repas", "Nom", "Prix", "Type", "Id restaurant"
			}
		));
		scrollPane.setViewportView(table);
		
////////////////////////////// recover data from DB to JTable ///////////////////////////////////////////////////////////////
		

		List<Repas> repass = null;
		try {
			repass = repasmetier.getRepass();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DefaultTableModel m = (DefaultTableModel) table.getModel();
		for (Repas repas:repass) {
			m.addRow(new Object[] {repas.getIdRepas(),repas.getNomRepas(),repas.getPrixRepas(),repas.getTypeRepas(),repas.getRestaurant()});			
			}
		
	}
}
