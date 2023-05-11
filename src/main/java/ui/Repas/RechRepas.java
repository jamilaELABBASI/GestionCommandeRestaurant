package ui.Repas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import entities.Repas;
import metier.IRepasMetier;
import metier.RepasMetier;

import java.awt.SystemColor;
import javax.swing.UIManager;

public class RechRepas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField RechercherRepas;
	private IRepasMetier repasmetier= new RepasMetier();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RechRepas frame = new RechRepas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RechRepas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 941, 637);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(153, 180, 209));
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel AjoutRepas = new JLabel("Rechercher un Repas");
		AjoutRepas.setFont(new Font("Tahoma", Font.BOLD, 16));
		AjoutRepas.setForeground(Color.WHITE);
		AjoutRepas.setBounds(363, 26, 185, 20);
		panel.add(AjoutRepas);

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JButton Rechercher = new JButton("Rechercher");
		Rechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(model);
				table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(RechercherRepas.getText().trim()));
				
			}
		});
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		Rechercher.setFont(new Font("Tahoma", Font.BOLD, 16));
		Rechercher.setForeground(Color.BLUE);
		Rechercher.setBounds(598, 74, 126, 23);
		panel.add(Rechercher);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 120, 883, 457);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id repas", "Nom repas", "Prix repas", "Type repas", "Id restaurant"
			}
		));
		scrollPane.setViewportView(table);
		
		RechercherRepas = new JTextField();
		RechercherRepas.setBounds(203, 77, 116, 20);
		panel.add(RechercherRepas);
		RechercherRepas.setColumns(10);
		
		List<Repas> repass = null;
		try {
			repass = repasmetier.getRepass();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DefaultTableModel m = (DefaultTableModel) table.getModel();
		for (Repas repas:repass) {
			m.addRow(new Object[] {repas.getIdRepas(),repas.getNomRepas(),repas.getPrixRepas(),repas.getTypeRepas(),repas.getRestaurant()});			
			}
		
	}
}
