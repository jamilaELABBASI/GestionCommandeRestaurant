package ui.Commande;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import entities.Client;
import entities.Commande;
import entities.Repas;
import metier.ClientMetier;
import metier.CommandeMetier;
import metier.IClientMetier;
import metier.ICommandeMetier;

import java.awt.SystemColor;

public class SupCom extends JFrame {

	private JPanel contentPane;
	private JTable table;
    private ICommandeMetier cmdmetier=new CommandeMetier();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			
					SupCom frame = null;
					try {
						frame = new SupCom();
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
	public SupCom() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 876, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel AjoutCom = new JLabel("Supprimer une commande");
		AjoutCom.setFont(new Font("Tahoma", Font.BOLD, 20));
		AjoutCom.setForeground(SystemColor.window);
		AjoutCom.setBounds(319, 11, 275, 32);
		panel.add(AjoutCom);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		JButton SupprimerCom = new JButton("Supprimer");
		SupprimerCom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index=table.getSelectedRow();
				Long id=(Long) table.getValueAt(index, 0);
				String nom=(String) table.getValueAt(index, 1);
				String date=(String) table.getValueAt(index, 2);
				Date qte=(Date) table.getValueAt(index, 3);
				String NomCli=(String) table.getValueAt(index, 4);
				
				
				DefaultTableModel m = (DefaultTableModel) table.getModel();
				m.removeRow(index);
				

				ICommandeMetier cmdmetier=new CommandeMetier();
				try {
					cmdmetier.deleteCommande(new Commande(id,nom,date,qte,NomCli));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		SupprimerCom.setFont(new Font("Tahoma", Font.BOLD, 16));
		SupprimerCom.setForeground(SystemColor.inactiveCaptionText);
		SupprimerCom.setBounds(370, 555, 154, 23);
		panel.add(SupprimerCom);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 72, 830, 470);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id Commande", "Nom repas","Date", "Quantite", "Nom client"
			}
		));
		scrollPane.setViewportView(table);
		
/////////////////////////////// recover data from data base to jtable/////////////////////////////////			
		List<Commande> commandes = cmdmetier.getCommandes();
		DefaultTableModel m = (DefaultTableModel) table.getModel();
		for (Commande cmd:commandes) {
			        m.addRow(new Object[] {cmd.getIdCmd(),cmd.getRepas(),cmd.getDate(),cmd.getQte(),cmd.getClient()});			
		}
	}
}
