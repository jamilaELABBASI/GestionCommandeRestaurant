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
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.IResponsableDao;
import dao.ResponsableDao;
import entities.Client;
import entities.Responsable;
import metier.ClientMetier;
import metier.IClientMetier;
import metier.IResponsableMetier;
import metier.ResponsableMetier;

import javax.swing.JScrollPane;
import java.awt.SystemColor;

public class SupResp extends JFrame {

	private JPanel contentPane;
	private JTable table;

	private IResponsableMetier responsablemetier=new ResponsableMetier();
	private IResponsableDao responsabledao=new ResponsableDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupResp frame = new SupResp();
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
	public SupResp() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 941, 637);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setLayout(null);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel SupResp = new JLabel("Supprimer un Client");
		SupResp.setForeground(SystemColor.window);
		SupResp.setFont(new Font("Tahoma", Font.BOLD, 16));
		SupResp.setBounds(352, 11, 169, 20);
		panel.add(SupResp);

///////////////////////////////////////////////////////////////////////////////////////////
		
		JButton SupprimerResp = new JButton("Supprimer");
		SupprimerResp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index=table.getSelectedRow();
				
				Long id=(Long) table.getValueAt(index, 0);
				String nom=(String) table.getValueAt(index, 1);
				String prenom=(String) table.getValueAt(index, 2);
				String tel=(String) table.getValueAt(index, 3);
				String email=(String) table.getValueAt(index, 4);
				String adres=(String) table.getValueAt(index, 5);

				
				DefaultTableModel m = (DefaultTableModel) table.getModel();
				m.removeRow(index);
				

				IResponsableMetier responsablemetier=new ResponsableMetier();
				try {
					Responsable r=new Responsable(id,nom,prenom,tel,email,adres);
					responsablemetier.deleteResponsable(r);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		///////////////////////////////////////////////////////////////////////////////////
		
		SupprimerResp.setForeground(SystemColor.desktop);
		SupprimerResp.setFont(new Font("Tahoma", Font.BOLD, 16));
		SupprimerResp.setBounds(405, 554, 132, 23);
		panel.add(SupprimerResp);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 895, 474);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id Responsable", "Nom", "Prenom", "Telephone", "Email", "Adresse"
			}
		));
		
		
/////////////////////////////// recover data from data base to jtable/////////////////////////////////			
List<Responsable> responsables = responsabledao.Responsables();
DefaultTableModel m = (DefaultTableModel) table.getModel();
for (Responsable responsable:responsables) {
m.addRow(new Object[] {responsable.getIdResp(),responsable.getNomResp(),responsable.getPrenomResp(),responsable.getTelResp(),responsable.getEmailResp(),responsable.getAdresseResp()});			
}		

	}

}
