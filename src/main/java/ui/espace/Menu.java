package ui.espace;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.ScrollPane;
import javax.swing.table.DefaultTableModel;

import entities.Client;
import ui.Client.*;

import ui.Commande.*;

import ui.Repas.*;


import ui.Responsable.*;

import ui.Restaurant.*;

import java.awt.Canvas;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 878, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 862, 588);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setForeground(new Color(210, 105, 30));
		menuBar_1.setBackground(new Color(0, 0, 0));
		menuBar_1.setBounds(212, 0, 460, 34);
		panel.add(menuBar_1);
		
		JMenu espaceCli_1 = new JMenu("Client");
		espaceCli_1.setForeground(new Color(255, 255, 255));
		espaceCli_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		menuBar_1.add(espaceCli_1);
		
		JMenuItem AjouCli_1 = new JMenuItem("Ajouter ");
		AjouCli_1.setForeground(Color.BLACK);
		AjouCli_1.setBackground(Color.WHITE);
		AjouCli_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		AjouCli_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AjoutCli ac = null;
				try {
					ac = new AjoutCli();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ac.setVisible(true);
			}
		});
		
		espaceCli_1.add(AjouCli_1);
		
		JMenuItem SupCli_1 = new JMenuItem("Supprimer");
		SupCli_1.setForeground(Color.BLACK);
		SupCli_1.setBackground(Color.WHITE);
		SupCli_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		SupCli_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SupCli sc = null;
				try {
					sc = new SupCli();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				sc.setVisible(true);
			
			}});
		espaceCli_1.add(SupCli_1);
		
		JMenuItem RechCli_1 = new JMenuItem("Rechercher");
		RechCli_1.setForeground(Color.BLACK);
		RechCli_1.setBackground(Color.WHITE);
		RechCli_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		RechCli_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RechCli rc = null;
				try {
					rc = new RechCli();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				rc.setVisible(true);				
			}
		});
		espaceCli_1.add(RechCli_1);
		
		JMenuItem ModCli_1 = new JMenuItem("Modifier");
		ModCli_1.setForeground(Color.BLACK);
		ModCli_1.setBackground(Color.WHITE);
		ModCli_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		ModCli_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ModifCli mc = null;
				try {
					mc = new ModifCli();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				mc.setVisible(true);
			}
		});
		espaceCli_1.add(ModCli_1);
		
		JMenu espaceResp_1 = new JMenu("Responsable");
		espaceResp_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		espaceResp_1.setForeground(new Color(255, 255, 255));
		menuBar_1.add(espaceResp_1);
		
		JMenuItem AjouResp_1 = new JMenuItem("Ajouter ");
		AjouResp_1.setForeground(Color.BLACK);
		AjouResp_1.setBackground(Color.WHITE);
		AjouResp_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		AjouResp_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjoutResp ar = null;
				try {
					ar = new AjoutResp();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ar.setVisible(true);
			}
		});
		espaceResp_1.add(AjouResp_1);
		
		JMenuItem SupResp_1 = new JMenuItem("Supprimer");
		SupResp_1.setForeground(Color.BLACK);
		SupResp_1.setBackground(Color.WHITE);
		SupResp_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		SupResp_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupResp mr = null;
				try {
					mr = new SupResp();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				mr.setVisible(true);
			}
		});
		espaceResp_1.add(SupResp_1);
		
		JMenuItem RechResp_1 = new JMenuItem("Rechercher");
		RechResp_1.setForeground(Color.BLACK);
		RechResp_1.setBackground(Color.WHITE);
		RechResp_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		RechResp_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RechResp rr = null;
				try {
					rr = new RechResp();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				rr.setVisible(true);
			}
		});
		espaceResp_1.add(RechResp_1);
		
		JMenuItem ModResp_1 = new JMenuItem("Modifier");
		ModResp_1.setForeground(Color.BLACK);
		ModResp_1.setBackground(Color.WHITE);
		ModResp_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		ModResp_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifResp mr = null;
				try {
					mr = new ModifResp();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				mr.setVisible(true);
			}
		});
		
		
		
		espaceResp_1.add(ModResp_1);
		
		JMenu espaceRest_1 = new JMenu("Restaurant");
		espaceRest_1.setForeground(new Color(255, 255, 255));
		espaceRest_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		menuBar_1.add(espaceRest_1);
		
		JMenuItem AjouRest_1 = new JMenuItem("Ajouter ");
		AjouRest_1.setForeground(Color.BLACK);
		AjouRest_1.setBackground(Color.WHITE);
		AjouRest_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		AjouRest_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AjoutRest ar = null;
				try {
					ar = new AjoutRest();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ar.setVisible(true);
			}
		});
		espaceRest_1.add(AjouRest_1);
		
		JMenuItem SupRest_1 = new JMenuItem("Supprimer");
		SupRest_1.setForeground(Color.BLACK);
		SupRest_1.setBackground(Color.WHITE);
		SupRest_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		SupRest_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SupRest sr = null;
				try {
					sr = new SupRest();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				sr.setVisible(true);
			}
		});
		espaceRest_1.add(SupRest_1);
		
		JMenuItem RechRest_1 = new JMenuItem("Rechercher");
		RechRest_1.setForeground(Color.BLACK);
		RechRest_1.setBackground(Color.WHITE);
		RechRest_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		RechRest_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RechRest rr = null;
				try {
					rr = new RechRest();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				rr.setVisible(true);
			}
		});
		espaceRest_1.add(RechRest_1);
		
		JMenuItem ModRest_1 = new JMenuItem("Modifier");
		ModRest_1.setForeground(Color.BLACK);
		ModRest_1.setBackground(Color.WHITE);
		ModRest_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		ModRest_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifRest mr = null;
				try {
					mr = new ModifRest();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				mr.setVisible(true);
			}
		});
		espaceRest_1.add(ModRest_1);
		
		JMenu espaceCom_1 = new JMenu("Commande");
		espaceCom_1.setForeground(new Color(255, 255, 255));
		espaceCom_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		menuBar_1.add(espaceCom_1);
		
		JMenuItem AjouCom_1 = new JMenuItem("Ajouter ");
		AjouCom_1.setForeground(Color.BLACK);
		AjouCom_1.setBackground(Color.WHITE);
		AjouCom_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		AjouCom_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjoutCom ac = null;
				try {
					ac = new AjoutCom();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ac.setVisible(true);
			}
		});
		espaceCom_1.add(AjouCom_1);
		
		JMenuItem SupCom_1 = new JMenuItem("Supprimer");
		SupCom_1.setForeground(Color.BLACK);
		SupCom_1.setBackground(Color.WHITE);
		SupCom_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		SupCom_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupCom sc = null;
				try {
					sc = new SupCom();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				sc.setVisible(true);
			}
		});
		espaceCom_1.add(SupCom_1);
		
		JMenuItem RechCom_1 = new JMenuItem("Rechercher");
		RechCom_1.setForeground(Color.BLACK);
		RechCom_1.setBackground(Color.WHITE);
		RechCom_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		RechCom_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RechCom rc = null;
				try {
					rc = new RechCom();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				rc.setVisible(true);
			}
		});
		espaceCom_1.add(RechCom_1);
		
		JMenuItem ModCom_1 = new JMenuItem("Modifier");
		ModCom_1.setForeground(Color.BLACK);
		ModCom_1.setBackground(Color.WHITE);
		ModCom_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		ModCom_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifCom md = null;
				try {
					md = new ModifCom();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				md.setVisible(true);
			}
		});
		espaceCom_1.add(ModCom_1);
		
		JMenu espaceRepas_1 = new JMenu("Repas");
		espaceRepas_1.setForeground(new Color(255, 255, 255));
		espaceRepas_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		menuBar_1.add(espaceRepas_1);
		
		JMenuItem AjouRepas_1 = new JMenuItem("Ajouter ");
		AjouRepas_1.setForeground(Color.BLACK);
		AjouRepas_1.setBackground(Color.WHITE);
		AjouRepas_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		AjouRepas_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AjoutRepas ar = null;
				try {
					ar = new AjoutRepas();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ar.setVisible(true);
			}
		});
		espaceRepas_1.add(AjouRepas_1);
		
		JMenuItem SupRepas_1 = new JMenuItem("Supprimer");
		SupRepas_1.setForeground(Color.BLACK);
		SupRepas_1.setBackground(Color.WHITE);
		SupRepas_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		SupRepas_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupRepas sr=new SupRepas();
				sr.setVisible(true);
			}
		});
		espaceRepas_1.add(SupRepas_1);
		
		JMenuItem RechRepas_1 = new JMenuItem("Rechercher");
		RechRepas_1.setForeground(Color.BLACK);
		RechRepas_1.setBackground(Color.WHITE);
		RechRepas_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		RechRepas_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RechRepas rr=new RechRepas();
				rr.setVisible(true);
			}
		});
		espaceRepas_1.add(RechRepas_1);
		
		JMenuItem ModRepas_1 = new JMenuItem("Modifier");
		ModRepas_1.setForeground(Color.BLACK);
		ModRepas_1.setBackground(Color.WHITE);
		ModRepas_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		ModRepas_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifRepas mr = null;
				try {
					mr = new ModifRepas();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				mr.setVisible(true);
			}
		});
		espaceRepas_1.add(ModRepas_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ELABBASI\\Documents\\2-ANNEE\\PFA\\restaurant\\Image1.jpg"));
		lblNewLabel.setBounds(10, 11, 842, 602);
		panel.add(lblNewLabel);
	}
}
