			package ui.Repas;
			
			import java.awt.BorderLayout;
			import java.awt.EventQueue;
			
			import javax.swing.JFrame;
			import javax.swing.JPanel;
			import javax.swing.border.EmptyBorder;
			import javax.swing.JLabel;
		import javax.swing.JOptionPane;
		
		import java.awt.Font;
			import javax.swing.JTable;
			import javax.swing.JScrollPane;
			import javax.swing.table.DefaultTableModel;
		
		import dao.IRepasDao;
		import dao.RepasDao;
		import entities.Client;
		import entities.Repas;
		import entities.Responsable;
		import entities.Restaurant;
		import metier.ClientMetier;
		import metier.IClientMetier;
		import metier.IRepasMetier;
		import metier.IRestaurantMetier;
		import metier.RepasMetier;
		import metier.RestaurantMetier;
		import ui.Client.AjoutCli;
		
		import javax.swing.JTextField;
			import java.awt.SystemColor;
			import javax.swing.JButton;
			import java.awt.event.MouseAdapter;
			import java.awt.event.MouseEvent;
		import java.util.List;
		import java.awt.event.ActionListener;
			import java.awt.event.ActionEvent;
		import javax.swing.JComboBox;
			
			public class Modif extends JFrame {
			
				private JPanel contentPane;
				private JTable table;
				private JTextField S_Mod_Nom;
				private JTextField S_Mod_Prix;
				private JTextField S_Mod_Type;
				private JTextField S_Mod_Quantite;
				
				private IRepasDao repasdao= new RepasDao();
				private IRepasMetier repasmetier= new RepasMetier();
				private JTable table_1;
				private IRestaurantMetier restmetier= new RestaurantMetier();
		
			
				/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						ModifRepas frame = new ModifRepas();
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
		public Modif() throws Exception {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 938, 638);
			contentPane = new JPanel();
			contentPane.setBackground(SystemColor.activeCaption);
			contentPane.setForeground(SystemColor.activeCaption);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel ModRepas = new JLabel("Modifier Repas");
		ModRepas.setForeground(SystemColor.window);
		ModRepas.setFont(new Font("Tahoma", Font.BOLD, 18));
		ModRepas.setBounds(353, 11, 148, 27);
		contentPane.add(ModRepas);
		
		
		
		JLabel lblNewLabel = new JLabel("Nouveau Nom");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(71, 455, 105, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNouveauPrix = new JLabel("Nouveau Prix");
		lblNouveauPrix.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNouveauPrix.setBounds(71, 509, 110, 14);
		contentPane.add(lblNouveauPrix);
		
		JLabel lblNouveauType = new JLabel("Nouveau Type");
		lblNouveauType.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNouveauType.setBounds(566, 449, 105, 27);
		contentPane.add(lblNouveauType);
			
		S_Mod_Nom = new JTextField();
		S_Mod_Nom.setBounds(236, 452, 128, 20);
		contentPane.add(S_Mod_Nom);
		S_Mod_Nom.setColumns(10);
		
		S_Mod_Prix = new JTextField();
		S_Mod_Prix.setColumns(10);
		S_Mod_Prix.setBounds(236, 506, 128, 20);
		contentPane.add(S_Mod_Prix);
		
		S_Mod_Type = new JTextField();
		S_Mod_Type.setColumns(10);
		S_Mod_Type.setBounds(704, 452, 128, 20);
		contentPane.add(S_Mod_Type);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(709, 507, 123, 22);
		contentPane.add(comboBox);
		JLabel lblIdRestaurant = new JLabel("Id Restaurant");
		lblIdRestaurant.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdRestaurant.setBounds(566, 511, 105, 27);
		contentPane.add(lblIdRestaurant);
		
		
		
		////////////////////////////////////////////////////////////////////////////
		JButton Modifier_Repas = new JButton("Modifier");
		
		Modifier_Repas.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		
		int i=table_1.getSelectedRow();
		DefaultTableModel model=(DefaultTableModel)	table_1.getModel();
		
		int index=table_1.getSelectedRow();
		Long Id=Long.parseLong( table_1.getValueAt(index, 0).toString());
		
		String Nom =S_Mod_Nom.getText();
		String Prix= S_Mod_Prix.getText();
		String Type=S_Mod_Type.getText();
		Restaurant IdRest=(Restaurant)comboBox.getSelectedItem();
		
		Repas R1=new Repas(Id,Nom,Type,Prix,IdRest);
		
		try {
		repasmetier.updateRepas(R1);
		} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		}
		
		
		if(i>=0){
		model.setValueAt(Id,i,0);
		model.setValueAt(Nom,i,1);
		model.setValueAt(Prix,i,2);
		model.setValueAt(Type ,i,3);
		model.setValueAt(IdRest,i,4);
		//model.setValueAt(S_Mod_Quantite.getText(),i,4);
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
		
			/////////////////////////////////////////////////////////////////////////////////////////
				
		
		
		Modifier_Repas.setFont(new Font("Tahoma", Font.BOLD, 14));
		Modifier_Repas.setBounds(412, 538, 89, 23);
		contentPane.add(Modifier_Repas);
		JScrollPane scrollPane = new JScrollPane();
		////////////////////////////////////////////////////////////////////////////////
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			private int selectedRow;

			@Override
			public void mouseClicked(MouseEvent e) {
		    int selectedRow=table.getSelectedRow();
		    DefaultTableModel model1=(DefaultTableModel)table.getModel();
			model1.fireTableRowsUpdated(selectedRow, selectedRow);
			
			S_Mod_Nom.setText(model1.getValueAt(selectedRow, 1).toString());
			S_Mod_Prix.setText(model1.getValueAt(selectedRow, 3).toString());		
			S_Mod_Type.setText(model1.getValueAt(selectedRow, 2).toString());
			comboBox.setSelectedItem(model1.getValueAt(selectedRow, 4).toString());

			
			}
		});
		
		//////////////////////////////////////////////////////////////////////////////////////////

		scrollPane.setBounds(10, 43, 885, 401);
		contentPane.add(scrollPane);
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id Repas", "Prix", "Nom", "Type", "Id Restaurant"
			}
		));
		
		scrollPane.setViewportView(table_1);
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		List<Restaurant> resps= restmetier.Restaurants();
		for(Restaurant resp:resps) {
		comboBox.addItem(resp);
		}
		
		
		//////////////////////////////recover data from DB to JTable ///////////////////////////////////////////////////////////////
		
		Object  IdRest= comboBox.getSelectedItem();
		
		List<Repas> repass = repasmetier.getRepass();
		DefaultTableModel m = (DefaultTableModel) table_1.getModel();
		for (Repas repas:repass) {
		
		m.addRow(new Object[] {repas.getIdRepas(),repas.getNomRepas(),repas.getPrixRepas(),repas.getTypeRepas(),IdRest});			
		}
				
			}
		}
