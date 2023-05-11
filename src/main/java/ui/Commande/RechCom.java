package ui.Commande;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import entities.Commande;
import metier.CommandeMetier;
import metier.ICommandeMetier;

import java.awt.SystemColor;

public class RechCom extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField RechercherCom;
    private ICommandeMetier cmdmetier=new CommandeMetier();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RechCom frame = new RechCom();
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
	public RechCom() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 876, 636);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel AjoutCom = new JLabel("Rechercher une commande");
		AjoutCom.setFont(new Font("Tahoma", Font.BOLD, 20));
		AjoutCom.setForeground(SystemColor.window);
		AjoutCom.setBounds(291, 11, 287, 20);
		panel.add(AjoutCom);
		
		JButton Rechercher = new JButton("Rechercher");
		Rechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(model);
				table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(Rechercher.getText().trim()));
				
			}
		});
		Rechercher.setFont(new Font("Tahoma", Font.BOLD, 16));
		Rechercher.setForeground(SystemColor.inactiveCaptionText);
		Rechercher.setBounds(594, 65, 136, 23);
		panel.add(Rechercher);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 110, 830, 466);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id Client", "Id Repas", "Quantite", "Type", "Date"
			}
		));
		scrollPane.setViewportView(table);
		
		RechercherCom = new JTextField();
		RechercherCom.setBounds(171, 68, 86, 20);
		panel.add(RechercherCom);
		RechercherCom.setColumns(10);
		
		
		
/////////////////////////////// recover data from data base to jtable/////////////////////////////////			
		List<Commande> commandes = cmdmetier.getCommandes();
		DefaultTableModel m = (DefaultTableModel) table.getModel();
		for (Commande cmd:commandes) {
			     
			//Object NomRepas=(Repas) comboBox_1.getSelectedItem();
			//String Date=(String) comboBox_3.getSelectedItem();
			//Object NomCli= (Client) comboBox_4.getSelectedItem();
		  //  double x=cmd.getQte();
		    m.addRow(new Object[] {cmd.getIdCmd(),cmd.getRepas(),cmd.getDate(),cmd.getQte(),cmd.getClient()});			
		}	
		
	}
}
