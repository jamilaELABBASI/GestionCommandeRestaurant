package ui.Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import dao.ClientDao;
import dao.IClientDao;
import entities.Client;
import metier.ClientMetier;
import metier.IClientMetier;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RechCli extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField RechercherCli;
	IClientMetier clientmetier =new ClientMetier();
	IClientDao clientdao =new ClientDao();

	/**
 * Launch the application.
 */
public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				RechCli frame = new RechCli();
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
public RechCli() throws Exception {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 878, 637);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(new BorderLayout(0, 0));
	setContentPane(contentPane);
	
	JPanel panel = new JPanel();
	panel.setBackground(SystemColor.activeCaption);
	panel.setLayout(null);
	contentPane.add(panel, BorderLayout.CENTER);
	
	JLabel RechCli = new JLabel("Rechercher un Client");
RechCli.setForeground(SystemColor.window);
RechCli.setFont(new Font("Tahoma", Font.BOLD, 20));
RechCli.setBounds(306, 25, 222, 20);
panel.add(RechCli);
////////////////////////////////////////////////////////////////////////////////////////////////	
JButton Rechercher = new JButton("Rechercher");
Rechercher.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(model);
		table.setRowSorter(tr);
		tr.setRowFilter(RowFilter.regexFilter(RechercherCli.getText().trim()));
		
		
	}
});


/////////////////////////////////////////////////////////////////////////////////////////
Rechercher.setForeground(SystemColor.inactiveCaptionText);
Rechercher.setFont(new Font("Tahoma", Font.BOLD, 16));
Rechercher.setBounds(545, 74, 159, 23);
panel.add(Rechercher);

JScrollPane scrollPane_1 = new JScrollPane();
scrollPane_1.setBounds(10, 119, 832, 458);
panel.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setColumnHeaderView(scrollPane);
		scrollPane.addMouseListener(new MouseAdapter() {
			
		});
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"Id Client", "Nom", "Prenom", "Telephone", "Email"
			}
		));
		scrollPane.setViewportView(table);
		RechercherCli = new JTextField();
		
		
		RechercherCli.setBounds(161, 77, 125, 20);
		panel.add(RechercherCli);
		RechercherCli.setColumns(10);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		List<Client> clientss = clientmetier.getClients();
		DefaultTableModel m = (DefaultTableModel) table.getModel();
		for (Client client:clientss) {
			m.addRow(new Object[] {client.getIdCli(),client.getNomCli(),client.getPrenomCli(),client.getTelCli(),client.getEmailCli()});
		
			}
		
	
		
	}
}
