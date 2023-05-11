package ui.Commande;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import entities.Commande;
import metier.CommandeMetier;
import metier.ICommandeMetier;

import java.awt.SystemColor;

public class ModifCom extends JFrame {

	private JPanel contentPane;
	private JTextField S_ModIdRepasCom;
	private JTextField S_ModQuantiteCom;
	private JTextField S_ModIdCli;
	private JTextField S_ModTypeCom;
	private JTable table;
    private ICommandeMetier cmdmetier=new CommandeMetier();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifCom frame = new ModifCom();
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
	public ModifCom() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 875, 641);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel ModIdRepasCom = new JLabel("Nom repas");
		ModIdRepasCom.setFont(new Font("Tahoma", Font.BOLD, 14));
		ModIdRepasCom.setBounds(512, 459, 89, 19);
		panel.add(ModIdRepasCom);
		
		S_ModIdRepasCom = new JTextField();
		S_ModIdRepasCom.setBounds(639, 460, 180, 20);
		panel.add(S_ModIdRepasCom);
		S_ModIdRepasCom.setColumns(10);
		
		JLabel ModQuantiteCom = new JLabel("Quantite");
		ModQuantiteCom.setFont(new Font("Tahoma", Font.BOLD, 14));
		ModQuantiteCom.setBounds(63, 492, 72, 14);
		panel.add(ModQuantiteCom);
		
		S_ModQuantiteCom = new JTextField();
		S_ModQuantiteCom.setBounds(162, 491, 180, 20);
		panel.add(S_ModQuantiteCom);
		S_ModQuantiteCom.setColumns(10);
		
		JLabel ModIdClientCom = new JLabel("Nom client");
		ModIdClientCom.setFont(new Font("Tahoma", Font.BOLD, 14));
		ModIdClientCom.setBounds(63, 461, 89, 14);
		panel.add(ModIdClientCom);
		
		S_ModIdCli = new JTextField();
		S_ModIdCli.setBounds(162, 460, 180, 20);
		panel.add(S_ModIdCli);
		S_ModIdCli.setColumns(10);
		
		JLabel ModTypeCom = new JLabel("Type");
		ModTypeCom.setFont(new Font("Tahoma", Font.BOLD, 14));
		ModTypeCom.setBounds(512, 489, 78, 20);
		panel.add(ModTypeCom);
		
		S_ModTypeCom = new JTextField();
		S_ModTypeCom.setBounds(639, 491, 180, 20);
		panel.add(S_ModTypeCom);
		S_ModTypeCom.setColumns(10);
		
		JLabel ModCom = new JLabel("Modifier une commande");
		ModCom.setFont(new Font("Tahoma", Font.BOLD, 20));
		ModCom.setForeground(SystemColor.window);
		ModCom.setBounds(325, 11, 245, 20);
		panel.add(ModCom);
		
		JButton ModifierCom = new JButton("Modifier");
		ModifierCom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ModifierCom.setFont(new Font("Tahoma", Font.BOLD, 16));
		ModifierCom.setForeground(SystemColor.inactiveCaptionText);
		ModifierCom.setBounds(389, 545, 116, 23);
		panel.add(ModifierCom);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 829, 368);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id Commande", "Nom Client", "Nom Repas", "Date", "Quantite", "Prix unitaire ", "Montant"
			}
		));
		scrollPane.setViewportView(table);
		
		
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
