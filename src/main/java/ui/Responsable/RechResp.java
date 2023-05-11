package ui.Responsable;

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
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import dao.IResponsableDao;
import dao.ResponsableDao;
import entities.Responsable;
import metier.IResponsableMetier;
import metier.ResponsableMetier;

import java.awt.SystemColor;

public class RechResp extends JFrame {

	private JPanel contentPane;
	private JTextField S_Resp;
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
					RechResp frame = new RechResp();
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
	public RechResp() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 944, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 918, 601);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel RechCli = new JLabel("Chercher un Responsable");
		RechCli.setForeground(SystemColor.window);
		RechCli.setFont(new Font("Tahoma", Font.BOLD, 16));
		RechCli.setBounds(365, 11, 213, 20);
		panel.add(RechCli);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		JButton RechercherResp = new JButton("Rechercher");
		RechercherResp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(model);
				table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(S_Resp.getText().trim()));
				
				
			}
		});
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		RechercherResp.setForeground(SystemColor.desktop);
		RechercherResp.setFont(new Font("Tahoma", Font.BOLD, 16));
		RechercherResp.setBounds(623, 49, 136, 23);
		panel.add(RechercherResp);
		
		S_Resp = new JTextField();
		S_Resp.setBounds(149, 52, 142, 20);
		panel.add(S_Resp);
		S_Resp.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 133, 898, 457);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				,
			},
			new String[] {
				"Id Responsable", "Nom", "Prenom", "Telephone", "Email"
			}
		));
		scrollPane.setViewportView(table);
		
/////////////////////////////// recover data from data base to jtable/////////////////////////////////			
List<Responsable> responsables = responsablemetier.getResponsables();
DefaultTableModel m = (DefaultTableModel) table.getModel();
for (Responsable responsable:responsables) {
m.addRow(new Object[] {responsable.getIdResp(),responsable.getNomResp(),responsable.getPrenomResp(),responsable.getTelResp(),responsable.getEmailResp()});			
}		

		
		
		
	}
	
	

}
