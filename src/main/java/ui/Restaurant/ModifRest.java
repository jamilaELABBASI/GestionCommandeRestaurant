package ui.Restaurant;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import entities.Responsable;
import entities.Restaurant;
import metier.IResponsableMetier;
import metier.IRestaurantMetier;
import metier.ResponsableMetier;
import metier.RestaurantMetier;
import ui.Client.AjoutCli;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JComboBox;

public class ModifRest extends JFrame {

	private JPanel contentPane;
	private JTextField S_ModNomRest;
	private JTextField S_ModAdresRest;
	private JTextField S_ModTelRest;
	private JTextField S_ModEmailRest;
	private JTable table;

	//private IRestaurantDao restdao=new RestaurantDao();
    private IRestaurantMetier restmetier=new RestaurantMetier();
    private IResponsableMetier respmetier=new ResponsableMetier();

	/**
 * Launch the application.
 */
public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				ModifRest frame = new ModifRest();
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
public ModifRest() throws Exception {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 877, 640);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(new BorderLayout(0, 0));
	setContentPane(contentPane);
	
	JPanel panel = new JPanel();
	panel.setBackground(SystemColor.activeCaption);
	contentPane.add(panel, BorderLayout.CENTER);
	panel.setLayout(null);
	
	JLabel ModNomRest = new JLabel("Nom");
ModNomRest.setFont(new Font("Tahoma", Font.BOLD, 14));
ModNomRest.setBounds(41, 482, 116, 19);
panel.add(ModNomRest);

S_ModNomRest = new JTextField();
S_ModNomRest.setBounds(190, 481, 180, 20);
panel.add(S_ModNomRest);
S_ModNomRest.setColumns(10);

JLabel ModAdresRest = new JLabel(" Adresse");
ModAdresRest.setFont(new Font("Tahoma", Font.BOLD, 14));
ModAdresRest.setBounds(460, 482, 139, 14);
panel.add(ModAdresRest);

S_ModAdresRest = new JTextField();
S_ModAdresRest.setBounds(614, 483, 180, 20);
panel.add(S_ModAdresRest);
S_ModAdresRest.setColumns(10);

JLabel ModTelRest = new JLabel("Telephone");
ModTelRest.setFont(new Font("Tahoma", Font.BOLD, 14));
ModTelRest.setBounds(41, 508, 139, 20);
panel.add(ModTelRest);

S_ModTelRest = new JTextField();
S_ModTelRest.setBounds(190, 507, 180, 20);
panel.add(S_ModTelRest);
S_ModTelRest.setColumns(10);

JLabel ModEmailRest = new JLabel(" Email");
ModEmailRest.setFont(new Font("Tahoma", Font.BOLD, 14));
ModEmailRest.setBounds(460, 510, 139, 14);
panel.add(ModEmailRest);

S_ModEmailRest = new JTextField();
S_ModEmailRest.setBounds(614, 508, 180, 20);
panel.add(S_ModEmailRest);
S_ModEmailRest.setColumns(10);

JLabel ModRest = new JLabel("Modifier un restaurant");
ModRest.setFont(new Font("Tahoma", Font.BOLD, 20));
ModRest.setForeground(SystemColor.window);
ModRest.setBounds(304, 11, 248, 20);
panel.add(ModRest);


JComboBox comboBox = new JComboBox();
comboBox.setBounds(190, 540, 180, 22);
panel.add(comboBox);

List<Responsable> resps= respmetier.getResponsables();
for(Responsable resp:resps) {
	comboBox.addItem(resp);
       }

///////////////////////////////////////////////////////////////////////////////////////////////		
JButton ModifierRest = new JButton("Modifier");
ModifierRest.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		
		
		int i=table.getSelectedRow();
		DefaultTableModel model=(DefaultTableModel)	table.getModel();
		
		int index=table.getSelectedRow();
		Long Id=Long.parseLong( table.getValueAt(index, 0).toString());
			
		String Nom =S_ModNomRest.getText();
		String Tel=S_ModTelRest.getText();
		String Email=S_ModEmailRest.getText();
		String Adres=S_ModAdresRest.getText();
		Responsable NomResp= (Responsable) comboBox.getSelectedItem();


		Restaurant c =new Restaurant(Id,Nom,Tel,Email,Adres,NomResp);
		try {
			restmetier.updateRestaurant(c);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		if(i>=0){
		model.setValueAt(Id,i,0);
		model.setValueAt(Nom,i,1);
		model.setValueAt(Tel,i,2);
		model.setValueAt(Email,i,3);
		model.setValueAt(Adres,i,4);
		model.setValueAt(NomResp,i,5);

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

///////////////////////////////////////////////////////////////////////////////////////////////
ModifierRest.setFont(new Font("Tahoma", Font.BOLD, 16));
ModifierRest.setForeground(SystemColor.inactiveCaptionText);
ModifierRest.setBounds(498, 557, 116, 23);
panel.add(ModifierRest);

JScrollPane scrollPane = new JScrollPane();
scrollPane.setBounds(10, 62, 831, 408);
panel.add(scrollPane);



///////////////////////////////////////////////////////////////////////////////////////////////////////		
table = new JTable();
table.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
		
	    int selectedRow=table.getSelectedRow();
	    DefaultTableModel model1=(DefaultTableModel)table.getModel();
		model1.fireTableRowsUpdated(selectedRow, selectedRow);
		
		S_ModNomRest.setText(model1.getValueAt(selectedRow, 1).toString());
		S_ModTelRest.setText(model1.getValueAt(selectedRow, 2).toString());
		S_ModEmailRest.setText(model1.getValueAt(selectedRow, 3).toString());		
		S_ModAdresRest.setText(model1.getValueAt(selectedRow, 4).toString());
		comboBox.setSelectedItem(model1.getValueAt(selectedRow, 5).toString());

		
	}
});

////////////////////////////////////////////////////////////////////////////////////////////////

table.setModel(new DefaultTableModel(
	new Object[][] {
	},
	new String[] {
		"Id Restaurant", "Nom", "Telephone", "Email", "Adresse","Nom Responsable"
	}
));
		scrollPane.setViewportView(table);
		
		JLabel lblNomResponsable = new JLabel("Nom Responsable");
		lblNomResponsable.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNomResponsable.setBounds(41, 540, 139, 19);
		panel.add(lblNomResponsable);
		
		
///////////////////////////////////////////////////////////////////////////////////////////		
		 


		Object  NomResp= comboBox.getSelectedItem();

		List<Restaurant> restaurants = restmetier.Restaurants();
		DefaultTableModel m = (DefaultTableModel) table.getModel();
		for (Restaurant restaurant:restaurants) {

		m.addRow(new Object[] {restaurant.getIdRest(),restaurant.getNomRest(),restaurant.getTelRest(),restaurant.getEmailRest(),
				restaurant.getAdresseRest(),NomResp});			
		}	

			
	}
}
