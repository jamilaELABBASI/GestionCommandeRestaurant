package ui.Client;

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
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dao.ClientDao;
import dao.IClientDao;
import entities.Client;
import metier.ClientMetier;
import metier.IClientMetier;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;


public class SupCli extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	
	private IClientMetier clientmetier=new ClientMetier();
	private IClientDao clientdao=new ClientDao();

	
	
	/**
 * Launch the application.
 */
public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				SupCli frame = new SupCli();
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
public SupCli() throws Exception {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 875, 638);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(new BorderLayout(0, 0));
	setContentPane(contentPane);
	
	JPanel panel = new JPanel();
	panel.setBackground(SystemColor.activeCaption);
	panel.setLayout(null);
	contentPane.add(panel, BorderLayout.CENTER);
	
	JLabel SupCli = new JLabel("Supprimer un Client");
SupCli.setForeground(SystemColor.window);
SupCli.setFont(new Font("Tahoma", Font.BOLD, 20));
SupCli.setBounds(294, 27, 215, 20);
panel.add(SupCli);

////////////////////////////////////////////////////////////////////////////////////////////////////////////

JButton SupprimerCli = new JButton("Supprimer");
SupprimerCli.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent e) {

		int index=table.getSelectedRow();
		Long id=(Long) table.getValueAt(index, 0);
		String nom=(String) table.getValueAt(index, 1);
		String prenom=(String) table.getValueAt(index, 2);
		String tel=(String) table.getValueAt(index, 3);
		String email=(String) table.getValueAt(index, 4);
		
		
		DefaultTableModel m = (DefaultTableModel) table.getModel();
		m.removeRow(index);
		

		IClientMetier clientmetier=new ClientMetier();
		try {
			clientmetier.DeleteClient(new Client(id,nom,prenom,tel,email));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
		});
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
		SupprimerCli.setForeground(SystemColor.inactiveCaptionText);
		SupprimerCli.setFont(new Font("Tahoma", Font.BOLD, 16));
		SupprimerCli.setBounds(381, 555, 139, 23);
		panel.add(SupprimerCli);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 79, 826, 465);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id Client", "Nom", "Prenom", "Telephone", "Email"
			}
			
		));
		
		List<Client> clientss = clientmetier.getClients();
		DefaultTableModel m = (DefaultTableModel) table.getModel();
		for (Client client:clientss) {
			m.addRow(new Object[] {client.getIdCli(),client.getNomCli(),client.getPrenomCli(),client.getTelCli(),client.getEmailCli()});			
			}
		
		
		
		
		
		}}
