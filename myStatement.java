package project1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.text.DateFormatter;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;



public class myStatement extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new dbConnect();							//checking DB connection
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					myStatement frame = new myStatement();		//calling GUI constructor
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
	public myStatement() {
		setTitle("myStatement");

		//Desiging GUI
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 1070, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String col[] = { "ID", "SOURCE", "AMOUNT", "DESCRIPTION", "TRNX TYPE", "DATE", "PAYMENT TYPE" };
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		 		
		table = new JTable(tableModel);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);;
				
				JScrollBar scrollBar = new JScrollBar();
			
				contentPane.add(scrollBar);
				table.setBounds(366, 44, 678, 378);
					
		contentPane.add(table);
		
		textField = new JTextField();
		textField.setBounds(32, 24, 139, 20);
		textField.setText("Akshay Kelkar");
		textField.setEditable(false);
		contentPane.add(textField);
		textField.setColumns(10);
		String[] month = { "00","01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
		String[] Date = { "00","01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12","13","14","15",
				"16","17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28","29","30","31"};
		
		String [] year= {"0000","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010",
							"2011","2012","2013","2014","2015","2016","2017","2018","2019","2020"};
		
		
		String[] trnxType = { "SELECT","Credit", "Debit"};
		
		String[] payType = { "SELECT","Cash", "Debit Card", "Credit Card","Check","Online Transfer","Others"};
		
		JComboBox comboBox = new JComboBox(trnxType);
		comboBox.setBounds(32, 218, 139, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(payType);
		comboBox_1.setBounds(206, 218, 150, 20);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox(month);
		comboBox_2.setBounds(32, 402, 73, 20);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox(Date);
		comboBox_3.setBounds(122, 402, 73, 20);
		contentPane.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox(year);
		comboBox_4.setBounds(211, 402, 86, 20);
		contentPane.add(comboBox_4);
		
		JLabel label = new JLabel("START DATE");
		label.setBounds(32, 65, 86, 14);
		contentPane.add(label);
		
		JComboBox comboBox_5 = new JComboBox(month);
		comboBox_5.setBounds(32, 80, 73, 20);
		contentPane.add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox(Date);
		comboBox_6.setBounds(122, 80, 73, 20);
		contentPane.add(comboBox_6);
		
		JComboBox comboBox_7 = new JComboBox(year);
		comboBox_7.setBounds(211, 80, 86, 20);
		contentPane.add(comboBox_7);
		
		JComboBox comboBox_8 = new JComboBox(month);
		comboBox_8.setBounds(32, 130, 73, 20);
		contentPane.add(comboBox_8);
		
		JComboBox comboBox_9 = new JComboBox(Date);
		comboBox_9.setBounds(122, 130, 73, 20);
		contentPane.add(comboBox_9);
		
		JComboBox comboBox_10 = new JComboBox(year);
		comboBox_10.setBounds(211, 130, 86, 20);
		contentPane.add(comboBox_10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(247, 24, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setVisible(false);
		
		
		textField_3 = new JTextField();
		textField_3.setBounds(32, 260, 210, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(32, 309, 210, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(32, 344, 46, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("UPDATE");
		
				JButton btnNewButton = new JButton("SEARCH");
		//Adding action Listener for Search
				btnNewButton.addActionListener(e -> {
					String fromdate = (String) comboBox_6.getSelectedItem()  + (String) comboBox_5.getSelectedItem() + (String) comboBox_7.getSelectedItem();
					String todate = (String) comboBox_9.getSelectedItem()  + (String) comboBox_8.getSelectedItem() + (String) comboBox_10.getSelectedItem();
					int Y=Integer.parseInt(fromdate);
					int X= Integer.parseInt(todate);
				if (checkDatesearch((String)comboBox_5.getSelectedItem(),(String)comboBox_6.getSelectedItem(),(String)comboBox_7.getSelectedItem())==false)
				{
					        JOptionPane.showMessageDialog(null,"*PLEASE SELECT THE VALID START DATE");
				}
				else if (checkDatesearch((String)comboBox_8.getSelectedItem(),(String)comboBox_9.getSelectedItem(),(String)comboBox_10.getSelectedItem())==false)
				{
							JOptionPane.showMessageDialog(null,"*PLEASE SELECT THE VALID END DATE");
				}
				else if((X-Y)<0)
				{
					JOptionPane.showMessageDialog(null,"*PLEASE SELECT THE VALID DATE RANGE");
				}
				else
				{
					String from_date = (String) comboBox_7.getSelectedItem() + "-" + (String) comboBox_6.getSelectedItem()+ "-" + (String) comboBox_5.getSelectedItem();
				String to_date = (String) comboBox_10.getSelectedItem() + "-" + (String) comboBox_9.getSelectedItem()+ "-" + (String) comboBox_8.getSelectedItem();


					String query = "select * from transaction where trans_date between '" + from_date + "' AND '" + to_date + "';";
					
					//getUsersList(1,query);
					Connection con = null;
					Statement statement = null;
					ResultSet resultSet = null;
					
					transanction transss;
					//String query;
					String user = "ask86";
					String password = "7iQ4wZLa7";
					String url = "jdbc:mysql://sql2.njit.edu/ask86";
					
					try{
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(url, user, password);
					statement = con.createStatement();
					 ResultSet rs = statement.executeQuery(query);
					 DefaultTableModel model = (DefaultTableModel) table.getModel();
					 model.setRowCount(0);
					 ArrayList<transanction> transactionList = new ArrayList<transanction>();
						while (rs.next()) {
							

							transss = new transanction(rs.getInt("trans_id"), rs.getDouble("trans_amt"), rs.getString("trans_desc"),
									rs.getString("trans_source"), rs.getString("trans_type"), rs.getString("trans_date"),
									rs.getString("paymethod_id_fk"));
							transactionList.add(transss);
						}

					//	DefaultTableModel model = (DefaultTableModel) table.getModel();
						Object[] rowdata = new Object[7];
						for (int i = 0; i < transactionList.size(); i++) {

							//System.out.println(transactionList.get(i).getamt());

							rowdata[0] = transactionList.get(i).gettid();
							rowdata[1] = transactionList.get(i).getsource();
							rowdata[2] = transactionList.get(i).getamt();
							rowdata[3] = transactionList.get(i).getdesc();
							rowdata[4] = transactionList.get(i).gettype();
							rowdata[6] = transactionList.get(i).getpayType();

							rowdata[5] = transactionList.get(i).getdate();

							model.addRow(rowdata);
							}
				}
					
					catch(Exception e4)
					{
						e4.printStackTrace();
					}
				
				}
		});
	
		
//Adding mouse listener to table
				
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				int i = table.getSelectedRow();

				TableModel model = table.getModel();
				
				
				textField_1.setText(model.getValueAt(i, 0).toString());
				textField_5.setText(model.getValueAt(i, 2).toString());
				textField_3.setText(model.getValueAt(i, 1).toString());
				textField_4.setText(model.getValueAt(i, 3).toString());
				comboBox.setSelectedItem(model.getValueAt(i, 4));
				comboBox_1.setSelectedItem(model.getValueAt(i,6));
				
				String ddate=model.getValueAt(i, 5).toString();
				String[] parts = ddate.split("-");
				
				String y =parts[0];
				String m =parts[1];
				String d=parts[2];
				comboBox_2.setSelectedItem(m);
				comboBox_3.setSelectedItem(d);
				comboBox_4.setSelectedItem(y);
								
			}
		});

		
		btnNewButton.setBounds(109, 156, 99, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("DELETE");
		
		//Adding action listener for delete
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String query = "delete from  transaction where trans_id='" + Integer.parseInt(textField_1.getText()) + "';";
				delete(query);
			}
		});
		btnNewButton_1.setBounds(267, 327, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
		JButton btnNewButton_2 = new JButton("INSERT");
	//Adding action Listener  for Insert
		
		btnNewButton_2.addActionListener(e -> 
		{
			if(((String)comboBox.getSelectedItem()).equals("SELECT"))
							{
								JOptionPane.showMessageDialog(null,"*PLEASE SELECT THE TRANSACATION TYPE");
							}
			else if (((String)comboBox_1.getSelectedItem()).equals("SELECT"))
							{
								JOptionPane.showMessageDialog(null,"*PLEASE SELECT THE PAYMENT TYPE");
							}
			else if((textField_3.getText().equals("")) ||(textField_4.getText().equals("") )|| (textField_5.getText().equals("")))
							{
								
								JOptionPane.showMessageDialog(null,"*PLEASE FILL ALL THE DETAILS");
							}
			else if (checkString(textField_5.getText())==false)
							{
						
								JOptionPane.showMessageDialog(null,"*PLEASE FILL THE VALID AMOUNT");
							}
			else if (checkDate((String)comboBox_2.getSelectedItem(),(String)comboBox_3.getSelectedItem(),(String)comboBox_4.getSelectedItem())==false)
							{
								JOptionPane.showMessageDialog(null,"*PLEASE SELECT THE VALID DATE");
							}
			else
			{
				String Name=textField.getText();
				String Source= textField_3.getText();
				String Descpt= textField_4.getText();
				String x=(String)comboBox.getSelectedItem();
				String a= (String)comboBox_1.getSelectedItem();
				
				
				String m = (String)(comboBox_2.getSelectedItem());
				
				String d = (String)(comboBox_3.getSelectedItem());
				
				String y = (String)(comboBox_4.getSelectedItem());
				String SD = y+"-"+m+"-"+d;
	
				//int FD= Integer.parseInt(SD);
											
				
				double amt =Double.parseDouble(textField_5.getText());
				insQue(Descpt, SD, amt, Source, x, a, Name);
				
			
			}
		
			
		});
		btnNewButton_2.setBounds(267, 259, 89, 23);
		contentPane.add(btnNewButton_2);
		
		//Adding action Listener for Update
		
		btnNewButton_3.addActionListener(e -> 
		{
						if(textField_1.getText().equals(""))
						{
							JOptionPane.showMessageDialog(null,"*PLEASE SELECT A RECORD TO UPDATE");
						}
			else if(((String)comboBox.getSelectedItem()).equals("SELECT"))
							{
								JOptionPane.showMessageDialog(null,"*PLEASE SELECT THE TRANSACATION TYPE");
							}
			else if((textField_3.getText().equals("")) ||(textField_4.getText().equals("") )|| (textField_5.getText().equals("")))
							{
								
								JOptionPane.showMessageDialog(null,"*PLEASE FILL ALL THE DETAILS");
							}
			else if (checkString(textField_5.getText())==false)
							{
						
								JOptionPane.showMessageDialog(null,"*PLEASE FILL THE VALID AMOUNT");
							}
			else if (checkDate((String)comboBox_2.getSelectedItem(),(String)comboBox_3.getSelectedItem(),(String)comboBox_4.getSelectedItem())==false)
							{
								JOptionPane.showMessageDialog(null,"*PLEASE SELECT THE VALID DATE");
							}
			else {
				
				String Name=textField.getText();
				String Source= textField_3.getText();
				String Descpt= textField_4.getText();
				String x=(String)comboBox.getSelectedItem();				/// getting data for the updating purpose
				String a= (String)comboBox_1.getSelectedItem();				//
				int id=Integer.parseInt(textField_1.getText());
				
				String m = (String)(comboBox_2.getSelectedItem());
				
				String d = (String)(comboBox_3.getSelectedItem());
				
				String y = (String)(comboBox_4.getSelectedItem());
				String SD = y+"-"+m+"-"+d;
										
				double amt =Double.parseDouble(textField_5.getText());
				upQue(Descpt, SD, amt, Source, x, a, Name, id);
				
			}
		}); 
		btnNewButton_3.setBounds(267, 293, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblSource = new JLabel("SOURCE");
		lblSource.setBounds(32, 244, 62, 14);
		contentPane.add(lblSource);
		
		JLabel lblNewLabel = new JLabel("DESCRIPTION");
		lblNewLabel.setBounds(32, 291, 97, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblAmount = new JLabel("AMOUNT");
		lblAmount.setBounds(32, 329, 62, 14);
		contentPane.add(lblAmount);
		
		JLabel lblDate = new JLabel("DATE (MM/DD/YYYY)");
		lblDate.setBounds(32, 375, 120, 14);
		contentPane.add(lblDate);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setBounds(32, 11, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblEndDate = new JLabel("END DATE");
		lblEndDate.setBounds(32, 115, 68, 14);
		contentPane.add(lblEndDate);
		
		JLabel lblmmddyyyy = new JLabel("(MM/DD/YYYY)");
		lblmmddyyyy.setBounds(122, 65, 105, 14);
		contentPane.add(lblmmddyyyy);
		
		JLabel lblmmddyyyy_1 = new JLabel("(MM/DD/YYYY)");
		lblmmddyyyy_1.setBounds(122, 115, 86, 14);
		contentPane.add(lblmmddyyyy_1);
		
		JLabel lblPaymentType = new JLabel("PAYMENT TYPE");
		lblPaymentType.setBounds(207, 203, 90, 14);
		contentPane.add(lblPaymentType);
		
		JLabel lblTransactionType = new JLabel("TRANSACTION TYPE");
		lblTransactionType.setBounds(32, 203, 139, 14);
		contentPane.add(lblTransactionType);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(389, 27, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("SOURCE");
		lblNewLabel_2.setBounds(479, 27, 63, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("AMOUNT($)");
		lblNewLabel_3.setBounds(572, 27, 73, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("DESCRIPTION");
		lblNewLabel_4.setBounds(669, 27, 86, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("TRNX TYPE");
		lblNewLabel_5.setBounds(775, 27, 77, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("DATE");
		lblNewLabel_6.setBounds(875, 27, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("PAYEMENT TYPE");
		lblNewLabel_7.setBounds(949, 27, 95, 14);
		contentPane.add(lblNewLabel_7);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(25, 190, 336, 242);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(25, 55, 331, 136);
		contentPane.add(separator_1);
		
		
		
		Show_Transaction_In_JTable();
	}

		
	//Delete method definition
	
		protected void delete(String query) {
		// TODO Auto-generated method stub
			String user = "ask86";
			String password = "7iQ4wZLa7";
			String url = "jdbc:mysql://sql2.njit.edu/ask86";
			
		
			
			Connection conn = null;
			Statement st = null;
		
					
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url, user, password);
				st = conn.createStatement();
				st.executeUpdate(query);
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				Show_Transaction_In_JTable();
				JOptionPane.showMessageDialog(null, "Record Deleted Successfully.");
			}
			catch (Exception e){
				e.printStackTrace();
			}
	}

		//update method definition
		private void upQue(String descpt, String sD, double amt, String source, String x, String a, String name, int id) {
		// TODO Auto-generated method stub

			String U="update  transaction set trans_source='" + source + "',trans_amt='" + amt
					+ "',trans_desc='" + descpt + "',trans_date='" + sD + "',trans_type='" + x
					+ "',paymethod_id_fk='" + a + "' where trans_id='" + id + "'";
			
			String user = "ask86";
			String password = "7iQ4wZLa7";
			String url = "jdbc:mysql://sql2.njit.edu/ask86";
			
		
			
			Connection conn = null;
			Statement st = null;
		
					
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url, user, password);
				st = conn.createStatement();
				st.executeUpdate(U);
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				Show_Transaction_In_JTable();
				JOptionPane.showMessageDialog(null, "Record Updated Successfully.");
			}
			catch (Exception e){
				e.printStackTrace();
			}
			
	}

		//insert method definition
		private void insQue(String descpt, String fD, double amt, String source, String x, String a, String name) 
		{
		// TODO Auto-generated method stub
			//new dbConnect();
			
			
			String S="INSERT INTO `ask86`.`transaction` (`trans_desc`, `trans_date`, `trans_amt`, `trans_source`, `trans_type`, `paymethod_id_fk`, `first_name`) VALUES ('"+descpt+"', '"+ fD+"', '"+ amt+"', '"+ source+"', '"+ x+"', '"+ a+"', '"+ name+"');";
			
			String user = "ask86";
			String password = "7iQ4wZLa7";
			String url = "jdbc:mysql://sql2.njit.edu/ask86";
			
		
			
			Connection conn = null;
			Statement st = null;				
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url, user, password);
				st = conn.createStatement();
				st.executeUpdate(S);
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				Show_Transaction_In_JTable();
				JOptionPane.showMessageDialog(null, "Record Inserted Successfully.");
			}
			catch (Exception e){
				e.printStackTrace();
			}
			
		

	}
		//date validation

		private boolean checkDate(String selectedItem, String selectedItem2, String selectedItem3) 
	{
		// TODO Auto-generated method stub
			
			if((Integer.parseInt(selectedItem)==00) ||(Integer.parseInt(selectedItem2)==000)||(Integer.parseInt(selectedItem3)==0000))
			{
				return false;
			}
			else if(Integer.parseInt(selectedItem3)%4==0)
			{
				if(Integer.parseInt(selectedItem2)>29)
						{
							return false;
						}
				
			}
			else if (Integer.parseInt(selectedItem3)%4!=0)
			{
				if(Integer.parseInt(selectedItem2)>28)
				{
					return false;
				}
				
			} 
		return true;
			
	}
		

		private boolean checkDatesearch(String selectedItem, String selectedItem2, String selectedItem3) 
	{
		// TODO Auto-generated method stub
			
			if(Integer.parseInt(selectedItem3)%4==0)
			{
				if(Integer.parseInt(selectedItem2)>29)
						{
							return false;
						}
				
			}
			else if (Integer.parseInt(selectedItem3)%4!=0)
			{
				if(Integer.parseInt(selectedItem2)>28)
				{
					return false;
				}
				
			} 
		return true;
			
	}		
		
	//arraylist creation for 	
		public ArrayList<transanction> getUsersList() 
		{
			ArrayList<transanction> transactionList = new ArrayList<transanction>();

			String user = "ask86";
			String password = "7iQ4wZLa7";
			String url = "jdbc:mysql://sql2.njit.edu/ask86";

			Connection con = null;
			Statement statement = null;
			ResultSet resultSet = null;
			
			transanction transss;
			String query;
		
				query = "SELECT * FROM transaction;";
		
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
				statement = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
				
				ResultSet rs = statement.executeQuery(query);
			
				
				while (rs.next()) 
					{

					transss = new transanction(rs.getInt("trans_id"), rs.getDouble("trans_amt"), rs.getString("trans_desc"),
							rs.getString("trans_source"), rs.getString("trans_type"), rs.getString("trans_date"),
							rs.getString("paymethod_id_fk"));
					transactionList.add(transss);
					}

		
				} 
			catch (Exception e) 
					{
				e.printStackTrace();
					}

			return transactionList;

		}

		public void Show_Transaction_In_JTable() {
			ArrayList<transanction> list = getUsersList();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			Object[] rowdata = new Object[7];
			for (int i = 0; i < list.size(); i++) {
				
				rowdata[0] = list.get(i).gettid();
				rowdata[1] = list.get(i).getsource();
				rowdata[2] = list.get(i).getamt();
				rowdata[3] = list.get(i).getdesc();

				rowdata[4]=list.get(i).gettype();
				rowdata[5] = list.get(i).getdate();

				rowdata[6]=list.get(i).getpayType(); 
				
				model.addRow(rowdata);
			}
		}


		
		
		
//Amount string validation
		private boolean checkString(String str) 
	{
		try{
			double x;
			x= Double.parseDouble(str);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}
}

//dbconnect class

class dbConnect
{
	private static final String user = "ask86";
	private static final String password = "7iQ4wZLa7";
	private static final String url = "jdbc:mysql://sql2.njit.edu/ask86";
	
public dbConnect()
		{
	
	Connection con = null;
	Statement statement = null;
	ResultSet resultSet = null;
			
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, user, password);
	//	statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

	}
	catch (Exception e)
				{
		e.printStackTrace();
						}		
	
		}

}



//transaction instace

class transanction {

	private double amt;
	private String descrp;
	private String trans_source;
	private String type;
	private String trans_date;
	private int trans_id;
	private String paymethod_id_fk;
	
	public transanction(int tid,double amount ,String desc,String tran_source,String tran_type,String tra_date,String paytype_id) {
		
		this.trans_id=tid;
		this.amt=amount;
		this.descrp=desc;
		this.descrp=desc;
		this.trans_source=tran_source;
		this.type=tran_type;
		this.trans_date=tra_date;
		this.paymethod_id_fk=paytype_id;
		
		
		// TODO Auto-generated constructor stub
	}
	
	public double getamt()
	{
		return amt;
	}
	public String getdesc()
	{
		return descrp;
	}
	public String getsource()
	{
		return trans_source;
	}
	public String gettype()
	{
		return type;
	}
	public String getdate()
	{
		return trans_date;
	}
	public int gettid()
	{
		return trans_id;
	}
	public String getpayType()
	{
		return paymethod_id_fk;
	}

}


