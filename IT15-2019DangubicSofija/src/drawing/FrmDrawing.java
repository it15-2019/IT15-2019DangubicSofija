package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.Font;
import net.miginfocom.swing.MigLayout;
import geometry.Shape;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class FrmDrawing extends JFrame {

	private JPanel contentPane;
	int state = 0;
	public DefaultListModel<Shape> dlm = new DefaultListModel<Shape>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDrawing frame = new FrmDrawing();
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
	public FrmDrawing() {
		setTitle("Dangubic Sofija IT15-2019");
		PnlDrawing pnlDrawing = new PnlDrawing(this);
		pnlDrawing.setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		ButtonGroup group = new ButtonGroup();
		
//____________________________ North ___________________________________
		
		JPanel pnlNorth = new JPanel();
		pnlNorth.setForeground(new Color(0, 0, 0));
		pnlNorth.setBackground(new Color(0, 255, 102));
		contentPane.add(pnlNorth, BorderLayout.NORTH);
		
		JLabel lblDrawing = new JLabel("Drawing");
		lblDrawing.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDrawing.setBackground(new Color(0, 255, 102));
		lblDrawing.setHorizontalAlignment(SwingConstants.CENTER);
		pnlNorth.add(lblDrawing);
		
//_____________________________ West ___________________________________
		
		JPanel pnlWest = new JPanel();
		pnlWest.setBackground(new Color(0, 0, 0));
		contentPane.add(pnlWest, BorderLayout.WEST);
		//----------------
		JRadioButton rdbPoint = new JRadioButton("Point");
		rdbPoint.setForeground(new Color(0, 255, 102));
		rdbPoint.setFont(new Font("Times New Roman", Font.BOLD, 12));
		rdbPoint.setBackground(new Color(0, 0, 0));
		group.add(rdbPoint);
		rdbPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				state = 1;
			}
		});
		pnlWest.setLayout(new MigLayout("", "[126px,grow]", "[22px][23px][23px][23px][23px][23px,grow][23px][23px][][][][][][][]"));
		pnlWest.add(rdbPoint, "cell 0 0,alignx left,aligny center");
		//----------------
		JRadioButton rdbLine = new JRadioButton("Line");
		rdbLine.setForeground(new Color(0, 255, 102));
		rdbLine.setFont(new Font("Times New Roman", Font.BOLD, 12));
		rdbLine.setBackground(new Color(0, 0, 0));
		group.add(rdbLine);
		rdbLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				state = 2;
			}
		});
		pnlWest.add(rdbLine, "cell 0 1,alignx left,aligny center");
		//----------------
		JRadioButton rdbRectangle = new JRadioButton("Rectangle");
		rdbRectangle.setForeground(new Color(0, 255, 102));
		rdbRectangle.setFont(new Font("Times New Roman", Font.BOLD, 12));
		rdbRectangle.setBackground(new Color(0, 0, 0));
		group.add(rdbRectangle);
		rdbRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				state = 3;
			}
		});
		pnlWest.add(rdbRectangle, "cell 0 2,alignx left,aligny center");
		//----------------
		JRadioButton rdbCircle = new JRadioButton("Circle");
		rdbCircle.setForeground(new Color(0, 255, 102));
		rdbCircle.setFont(new Font("Times New Roman", Font.BOLD, 12));
		rdbCircle.setBackground(new Color(0, 0, 0));
		group.add(rdbCircle);
		rdbCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				state = 4;
			}
		});
		pnlWest.add(rdbCircle, "cell 0 3,alignx left,aligny center");
		//----------------
		JRadioButton rdbDonut = new JRadioButton("Donut");
		rdbDonut.setForeground(new Color(0, 255, 102));
		rdbDonut.setFont(new Font("Times New Roman", Font.BOLD, 12));
		rdbDonut.setBackground(new Color(0, 0, 0));
		group.add(rdbDonut);
		rdbDonut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				state = 5;
			}
		});
		pnlWest.add(rdbDonut, "cell 0 4,alignx left,aligny center");
		//----------------
		JScrollPane scrlListShape = new JScrollPane();
		pnlWest.add(scrlListShape, "cell 0 5 1 7,grow");

		JList listShapes = new JList();
		listShapes.setBackground(new Color(0, 255, 102));
		listShapes.setForeground(new Color(0, 0, 0));
		listShapes.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		listShapes.setModel(dlm);
		scrlListShape.setViewportView(listShapes);
		//----------------
		JToggleButton tglSelect = new JToggleButton("Select");
		tglSelect.setFont(new Font("Times New Roman", Font.BOLD, 12));
		tglSelect.setBackground(new Color(0, 255, 102));
		tglSelect.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, new Color(0, 0, 0)));
		group.add(tglSelect);
		tglSelect.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				state = 6;
			}
		});
		pnlWest.add(tglSelect, "cell 0 13,growx,aligny center");
		//----------------
		JToggleButton tglModify = new JToggleButton("Modify");
		tglModify.setFont(new Font("Times New Roman", Font.BOLD, 12));
		tglModify.setBackground(new Color(0, 255, 102));
		tglModify.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, new Color(0, 0, 0)));
		group.add(tglModify);
		tglModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				pnlDrawing.modifyShape();
			}
		});
		pnlWest.add(tglModify, "flowy,cell 0 14,growx,aligny center");
		//-----------------
		JToggleButton tglDelete = new JToggleButton("Delete");
		tglDelete.setFont(new Font("Times New Roman", Font.BOLD, 12));
		tglDelete.setBackground(new Color(0, 255, 102));
		tglDelete.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, new Color(0, 0, 0)));
		group.add(tglDelete);
		tglDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state = 0;
				pnlDrawing.delete();
			}
		});
		pnlWest.add(tglDelete, "cell 0 14,growx");
		
//____________________________ Center ___________________________________
		
		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		
		pnlDrawing.setSize(new Dimension(20,40));
		pnlDrawing.setPreferredSize(new Dimension(200,400));
		contentPane.add(pnlDrawing);
	}

//______________________ Getters and Setters ______________________________
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public DefaultListModel<Shape> getDlm() {
		return dlm;
	}

	public void setDlm(DefaultListModel<Shape> dlm) {
		this.dlm = dlm;
	}

}
