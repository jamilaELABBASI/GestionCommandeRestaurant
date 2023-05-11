package ui.Responsable;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;

import dao.IResponsableDao;
import dao.ResponsableDao;
import entities.Responsable;
import metier.IResponsableMetier;
import metier.ResponsableMetier;
import ui.Client.AjoutCli;

import java.awt.SystemColor;
import java.util.List;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModifResp extends JFrame {

	private JPanel contentPane;
	private JTextField NouvNomResp;
	private JTextField NouvPrenomResp;
	private JTextField NouvTelResp;
	private JTextField NouvEmailResp;
	private JTable table;
	
	private IResponsableMetier responsablemetier=new ResponsableMetier();
	private IResponsableDao responsabledao=new ResponsableDao();
	private JTextField NouvAdresseResp;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifResp frame = new ModifResp();
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
	public ModifResp() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 944, 638);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Modif_Responsable = new JLabel("Modifier un Responsable");
		Modif_Responsable.setForeground(SystemColor.window);
		Modif_Responsable.setFont(new Font("Tahoma", Font.BOLD, 18));
		Modif_Responsable.setBounds(348, 26, 234, 23);
		contentPane.add(Modif_Responsable);
		
		JLabel lblNewLabel = new JLabel("Nouveau Nom");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(55, 446, 99, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNouveauPrenom = new JLabel("Nouveau Prenom");
		lblNouveauPrenom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNouveauPrenom.setBounds(55, 484, 127, 14);
		contentPane.add(lblNouveauPrenom);
		
		JLabel lblNouveauTelehone = new JLabel("Nouveau Telephone");
		lblNouveauTelehone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNouveauTelehone.setBounds(525, 446, 143, 14);
		contentPane.add(lblNouveauTelehone);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nouveau Email");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(525, 484, 127, 14);
		contentPane.add(lblNewLabel_2_1);
		
		NouvNomResp = new JTextField();
		NouvNomResp.setBounds(223, 445, 127, 20);
		contentPane.add(NouvNomResp);
		NouvNomResp.setColumns(10);
		
		NouvPrenomResp = new JTextField();
		NouvPrenomResp.setColumns(10);
		NouvPrenomResp.setBounds(223, 483, 127, 20);
		contentPane.add(NouvPrenomResp);
		
		NouvTelResp = new JTextField();
		NouvTelResp.setColumns(10);
		NouvTelResp.setBounds(719, 445, 127, 20);
		contentPane.add(NouvTelResp);
		
		NouvEmailResp = new JTextField();
		NouvEmailResp.setColumns(10);
		NouvEmailResp.setBounds(719, 483, 127, 20);
		contentPane.add(NouvEmailResp);
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		
		JButton ModifierResp = new JButton("Modifier");
		
		ModifierResp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	int i=table.getSelectedRow();
	DefaultTableModel model=(DefaultTableModel)	table.getModel();

	
	int index=table.getSelectedRow();
	Long Id=Long.parseLong( table.getValueAt(index, 0).toString());
	
	
	if(i>=0){
		//model.setValueAt(NouvIdCli.getText(),i,0);
		model.setValueAt(NouvNomResp.getText(),i,1);
		model.setValueAt(NouvPrenomResp.getText(),i,2);
		model.setValueAt(NouvTelResp.getText(),i,3);
		model.setValueAt(NouvEmailResp.getText(),i,4);
		model.setValueAt(NouvAdresseResp.getText(),i,5);

	       }
	else   {
		JOptionPane.showMessageDialog(null, "ERROR");
	       }
	
	

	IResponsableMetier responsablemetier=new ResponsableMetier();
	
	
	Responsable c =new Responsable(Id,NouvNomResp.getText(),NouvPrenomResp.getText(),
			NouvTelResp.getText(),NouvEmailResp.getText(),NouvAdresseResp.getText());
	try {
		responsablemetier.updateResponsable(c);
	} catch (Exception e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}	
}


public void AddRowToJTable(Object[] dataRow) throws Exception 
{
	DefaultTableModel model=(DefaultTableModel) table.getModel();
	model.addRow(dataRow);
	

	AjoutCli  FrameText=new AjoutCli();
	FrameText.setVisible(true);
	FrameText.pack();
	FrameText.setLocationRelativeTo(null);
	FrameText.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
}		

}
		);
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////		

		ModifierResp.setForeground(SystemColor.desktop);
		ModifierResp.setBackground(SystemColor.window);
		ModifierResp.setFont(new Font("Tahoma", Font.BOLD, 14));
		ModifierResp.setBounds(403, 552, 89, 23);
		contentPane.add(ModifierResp);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 908, 360);
		contentPane.add(scrollPane);

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 int selectedRow=table.getSelectedRow();
				    DefaultTableModel model1=(DefaultTableModel)table.getModel();
					model1.fireTableRowsUpdated(selectedRow, selectedRow);
					
					NouvNomResp.setText(model1.getValueAt(selectedRow, 1).toString());
					NouvPrenomResp.setText(model1.getValueAt(selectedRow, 2).toString());
					NouvTelResp.setText(model1.getValueAt(selectedRow, 3).toString());
					NouvEmailResp.setText(model1.getValueAt(selectedRow, 4).toString());
					NouvAdresseResp.setText(model1.getValueAt(selectedRow, 5).toString());		

			}
		});
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id Responsable", "Nom", "Prenom", "Telephone", "Email", "Adresse"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNouveauAdresse = new JLabel("Nouveau Adresse");
		lblNouveauAdresse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNouveauAdresse.setBounds(55, 519, 127, 14);
		contentPane.add(lblNouveauAdresse);
		
		NouvAdresseResp = new JTextField();
		NouvAdresseResp.setColumns(10);
		NouvAdresseResp.setBounds(223, 518, 127, 20);
		contentPane.add(NouvAdresseResp);
		
/////////////////////////////// recover data from data base to jtable/////////////////////////////////			
List<Responsable> responsables = responsabledao.Responsables();
DefaultTableModel m = (DefaultTableModel) table.getModel();
for (Responsable responsable:responsables) {
m.addRow(new Object[] {responsable.getIdResp(),responsable.getNomResp(),responsable.getPrenomResp(),responsable.getTelResp(),responsable.getEmailResp(),responsable.getAdresseResp()});			
}		

		
	}
}
