	package ui.Client;
	
	import java.awt.AWTEvent;
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
	

	import entities.Client;
import metier.ClientMetier;
	import metier.IClientMetier;


import java.awt.SystemColor;
	
	public class AjoutCli extends JFrame {
	
		private JPanel contentPane;
		private JTextField S_NomCli;
		private JTextField S_PrenomCli;
		private JTextField S_TelCli;
		private JTextField S_EmailCli;
		private JTable table_1;
		
		private IClientMetier clientmetier=new ClientMetier();

		/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutCli frame= new AjoutCli();
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
	public AjoutCli() throws Exception {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ajouter un client");
	lblNewLabel.setForeground(Color.WHITE);
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblNewLabel.setBounds(356, 11, 184, 34);
	getContentPane().add(lblNewLabel);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 878, 636);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JPanel panel = new JPanel();
	panel.setBackground(SystemColor.activeCaption);
	panel.setForeground(SystemColor.window);
	panel.setBounds(5, 5, 847, 564);
	contentPane.add(panel);
	panel.setLayout(null);
	
	JLabel NomCli = new JLabel("Nom");
	NomCli.setBounds(26, 69, 72, 14);
	NomCli.setFont(new Font("Tahoma", Font.BOLD, 14));
	panel.add(NomCli);
	
	S_NomCli = new JTextField();
	S_NomCli.setBounds(117, 68, 180, 20);
	panel.add(S_NomCli);
	S_NomCli.setColumns(10);
	
	JLabel PrenomCli = new JLabel("Prenom");
	PrenomCli.setBounds(548, 69, 72, 14);
	PrenomCli.setFont(new Font("Tahoma", Font.BOLD, 14));
	panel.add(PrenomCli);
	
	S_PrenomCli = new JTextField();
	S_PrenomCli.setBounds(641, 68, 180, 20);
	panel.add(S_PrenomCli);
	S_PrenomCli.setColumns(10);
	
	JLabel TeleCli = new JLabel("Telephone");
	TeleCli.setBounds(26, 100, 78, 14);
	TeleCli.setFont(new Font("Tahoma", Font.BOLD, 14));
	panel.add(TeleCli);
	
	S_TelCli = new JTextField();
	S_TelCli.setBounds(117, 99, 180, 20);
	panel.add(S_TelCli);
	S_TelCli.setColumns(10);
	
	JLabel EmailCli = new JLabel("Email");
	EmailCli.setBounds(548, 94, 72, 14);
	EmailCli.setFont(new Font("Tahoma", Font.BOLD, 14));
	panel.add(EmailCli);
	
	S_EmailCli = new JTextField();
	S_EmailCli.setBounds(641, 99, 180, 20);
	panel.add(S_EmailCli);
	S_EmailCli.setColumns(10);
	
	JLabel AjoutCli = new JLabel("Ajouter un Client");
	AjoutCli.setBounds(327, 11, 180, 32);
	AjoutCli.setFont(new Font("Tahoma", Font.BOLD, 20));
	AjoutCli.setForeground(SystemColor.window);
	panel.add(AjoutCli);
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	JButton AjouterCli = new JButton("Ajouter");
	AjouterCli.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	
	Long Id=null;

	//Long Id=Long.parseLong(S_IdCli.getText());
	String Nom =S_NomCli.getText();
	String Prenom=S_PrenomCli.getText();
	String Tel=S_TelCli.getText();
	String Email=S_EmailCli.getText();
	
	DefaultTableModel model=(DefaultTableModel) table_1.getModel();
	model.addRow(new Object[] {Id,Nom,Prenom,Tel,Email});				
	
	IClientMetier clientmetier=new ClientMetier();
	
	
	Client c =new Client(Id,Nom,Prenom,Tel,Email);
	try {
		clientmetier.AddClient(c);
	} catch (Exception e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	}
	
		});
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	AjouterCli.setBounds(363, 136, 116, 23);
		
	AjouterCli.setFont(new Font("Tahoma", Font.BOLD, 16));
	AjouterCli.setForeground(SystemColor.inactiveCaptionText);
	panel.add(AjouterCli);
	
	JScrollPane scrollPane_1 = new JScrollPane();
	scrollPane_1.setBounds(10, 183, 827, 381);
	panel.add(scrollPane_1);
	
	table_1 = new JTable();
	table_1.setModel(new DefaultTableModel(
		new Object[][] {},
		new String[] {
			"Id Client", "Nom", "Prenom", "Telephone", "Email"
				}
			));
			scrollPane_1.setViewportView(table_1);
			
			
/////////////////////////////// recover data from data base to jtable/////////////////////////////////			
			List<Client> clientss = clientmetier.getClients();
			DefaultTableModel m = (DefaultTableModel) table_1.getModel();
			for (Client client:clientss) {
				m.addRow(new Object[] {client.getIdCli(),client.getNomCli(),client.getPrenomCli(),client.getTelCli(),client.getEmailCli()});			
				}
			
			
		}
	}
