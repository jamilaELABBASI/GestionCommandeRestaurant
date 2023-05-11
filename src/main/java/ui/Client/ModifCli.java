package ui.Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import dao.ClientDao;
import dao.IClientDao;
import entities.Client;
import metier.ClientMetier;
import metier.IClientMetier;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import ui.Client.AjoutCli;


public class ModifCli extends JFrame {

	private JPanel contentPane;
	private JTextField NouvNomCli;
	private JTextField NouvTelCli;
	private JTextField NouvEmailCli;
	private JTextField NouvPrenomCli;
	private JTable table;
	private JTextField NouvIdCli;
	
    private IClientDao clientdao=new ClientDao();
    private IClientMetier clientmetier=new ClientMetier();

	/**
 * Launch the application.
 */
public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				ModifCli frame = new ModifCli();
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
public ModifCli() throws Exception {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 880, 635);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(new BorderLayout(0, 0));
	setContentPane(contentPane);
	
	JPanel panel = new JPanel();
	panel.setBackground(SystemColor.activeCaption);
	panel.setLayout(null);
	contentPane.add(panel, BorderLayout.CENTER);
	
	JLabel ModNomCli = new JLabel("Nouveau Nom");
ModNomCli.setFont(new Font("Tahoma", Font.BOLD, 14));
ModNomCli.setBounds(27, 476, 139, 14);
panel.add(ModNomCli);

NouvNomCli = new JTextField();
NouvNomCli.setColumns(10);
NouvNomCli.setBounds(176, 475, 180, 20);
panel.add(NouvNomCli);

JLabel ModTeleCli = new JLabel("Nouveau Telephone");
ModTeleCli.setFont(new Font("Tahoma", Font.BOLD, 14));
ModTeleCli.setBounds(27, 501, 139, 14);
panel.add(ModTeleCli);

NouvTelCli = new JTextField();
NouvTelCli.setColumns(10);
NouvTelCli.setBounds(176, 500, 180, 20);
panel.add(NouvTelCli);

JLabel ModEmailCli = new JLabel("Nouveau Email");
ModEmailCli.setFont(new Font("Tahoma", Font.BOLD, 14));
ModEmailCli.setBounds(477, 501, 139, 14);
panel.add(ModEmailCli);

NouvEmailCli = new JTextField();
NouvEmailCli.setColumns(10);
NouvEmailCli.setBounds(640, 500, 181, 20);
panel.add(NouvEmailCli);

JLabel ModCli = new JLabel("Modifier un Client");
ModCli.setForeground(SystemColor.window);
ModCli.setFont(new Font("Tahoma", Font.BOLD, 20));
ModCli.setBounds(338, 21, 190, 20);
panel.add(ModCli);

/////////////////////////////////////////////////////////////////////////	
JButton modifier = new JButton("Modifier");
modifier.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		
		int i=table.getSelectedRow();
		DefaultTableModel model=(DefaultTableModel)	table.getModel();
		
		//Long Id=Long.parseLong(NouvIdCli.getText());
		String Nom =NouvNomCli.getText();
		String Prenom=NouvPrenomCli.getText();
		String Tel=NouvTelCli.getText();
		String Email=NouvEmailCli.getText();
		
		int index=table.getSelectedRow();
		Long Id=Long.parseLong( table.getValueAt(index, 0).toString());
		
		
		
		Client c =new Client(Id,Nom,Prenom,Tel,Email);
		try {
			clientmetier.UpdateClient(c);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if(i>=0){
			model.setValueAt(Id,i,0);
			model.setValueAt(Nom,i,1);
			model.setValueAt(Prenom,i,2);
			model.setValueAt(Tel,i,3);
			model.setValueAt(Email,i,4);
		       }
		else   {
			JOptionPane.showMessageDialog(null, "ERROR");
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
	
	
});

////////////////////////////////////////////////////////////////////////////////
modifier.setForeground(SystemColor.inactiveCaptionText);
modifier.setFont(new Font("Tahoma", Font.BOLD, 16));
modifier.setBounds(358, 538, 116, 23);
panel.add(modifier);

JLabel ModPrenomCli = new JLabel("Nouveau Prenom");
ModPrenomCli.setFont(new Font("Tahoma", Font.BOLD, 14));
ModPrenomCli.setBounds(477, 476, 139, 14);
panel.add(ModPrenomCli);

NouvPrenomCli = new JTextField();
NouvPrenomCli.setColumns(10);
NouvPrenomCli.setBounds(640, 475, 180, 20);
panel.add(NouvPrenomCli);

JScrollPane scrollPane = new JScrollPane();
scrollPane.setBounds(10, 52, 834, 336);
panel.add(scrollPane);

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


table = new JTable();
table.addMouseListener(new MouseAdapter() {
	private int selectedRow;

	@Override
	public void mouseClicked(MouseEvent e) {
		
    int selectedRow=table.getSelectedRow();
    
	DefaultTableModel model1=(DefaultTableModel)table.getModel();
	model1.fireTableRowsUpdated(selectedRow, selectedRow);
	
	//NouvIdCli.setText(model1.getValueAt(selectedRow, 0).toString());
	NouvNomCli.setText(model1.getValueAt(selectedRow, 1).toString());
	NouvPrenomCli.setText(model1.getValueAt(selectedRow, 2).toString());
	NouvTelCli.setText(model1.getValueAt(selectedRow, 3).toString());
	NouvEmailCli.setText(model1.getValueAt(selectedRow, 4).toString());		
	
}});

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

table.setModel(new DefaultTableModel(
	new Object[][] {
	},
	new String[] {
		"Id Client", "Nom", "Prenom", "Telephone", "Email"
	}
));
	scrollPane.setViewportView(table);
	
		
	List<Client> clientss = clientmetier.getClients();
	DefaultTableModel m = (DefaultTableModel) table.getModel();
	for (Client client:clientss) {
		m.addRow(new Object[] {client.getIdCli(),client.getNomCli(),client.getPrenomCli(),client.getTelCli(),client.getEmailCli()});
	
		}
	
	
		
		
	}}











