
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;

public class newlogin extends JFrame {

    private JLabel routeNo,  routeName,  From,  To,  Distance,  Amount;
    private JTextField txtRouteNo,  txtRouteName,   txtDistance,  txtAmount;
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    private JButton AddNew;
    private JPasswordField  txtFrom,  txtTo;
    private JButton Cancel;
    private JButton Clear;
    private JButton Next;
    private JPanel jPanel1;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private static JTextArea txtInfo = new JTextArea(15, 40);
    private Connection dbconn;
    private static String info;

    public newlogin() {
        //super("Add New Route", false, true, false, true);
        setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
        this.setSize(370, 350);
        routeNo = new JLabel("Name ");
        routeName = new JLabel("Username ");
        From = new JLabel("Password");
        To = new JLabel("cnf pass");
        Distance = new JLabel("Category");
        //Amount = new JLabel("Fare_Charged");
        txtRouteNo = new JTextField(10);
        txtRouteName = new JTextField(10);
        txtFrom = new JPasswordField(10);
        txtTo = new JPasswordField(10);
       // txtAmount = new JTextField(10);
        txtDistance = new JTextField(15);
        txtDistance.setText("User");
        txtDistance.setEditable(false);
        AddNew = new JButton("Signup", new ImageIcon(ClassLoader.getSystemResource("Images/addnew.png")));
        Cancel = new JButton("Cancel", new ImageIcon(ClassLoader.getSystemResource("Images/exit.png")));
        Clear = new JButton("Clear", new ImageIcon(ClassLoader.getSystemResource("Images/clear.png")));

        txtRouteNo.setFont(new Font("monospaced", Font.BOLD, 18));
        txtRouteName.setFont(new Font("monospaced", Font.BOLD, 18));
        txtFrom.setFont(new Font("monospaced", Font.BOLD, 18));
        txtTo.setFont(new Font("monospaced", Font.BOLD, 18)); 
        //txtAmount.setFont(new Font("monospaced", Font.BOLD, 18));
        txtDistance.setFont(new Font("monospaced", Font.BOLD, 18));
        
        Cancel.setBackground(new Color(4, 1, 8));
        Cancel.setFont(new Font("monospaced", Font.BOLD, 18));
        Cancel.setForeground(Color.white);
        
        AddNew.setBackground(new Color(4, 1, 8));
        AddNew.setFont(new Font("monospaced", Font.BOLD, 18));
       AddNew.setForeground(Color.white);
       
        Clear.setBackground(new Color(4, 1, 8));
        Clear.setFont(new Font("monospaced", Font.BOLD, 18));
        Clear.setForeground(Color.white);
        
        routeNo.setFont(new Font("monospaced", Font.BOLD, 20));
        routeName.setFont(new Font("monospaced", Font.BOLD, 20));
        From.setFont(new Font("monospaced", Font.BOLD, 20));
        To.setFont(new Font("monospaced", Font.BOLD, 20));
       Distance.setFont(new Font("monospaced", Font.BOLD, 20));
        //Amount.setFont(new Font("monospaced", Font.BOLD, 20));
        
        
        jPanel1 = new JPanel(new java.awt.GridLayout(5, 2));

        jPanel1.add(routeNo);
        jPanel1.add(txtRouteNo);
        jPanel1.add(routeName);
        jPanel1.add(txtRouteName);
        jPanel1.add(From);
        jPanel1.add(txtFrom);
        jPanel1.add(To);
        jPanel1.add(txtTo);
        jPanel1.add(Distance);
        jPanel1.add(txtDistance);
       // jPanel1.add(Amount);
       // jPanel1.add(txtAmount);
        jPanel3 = new javax.swing.JPanel(new FlowLayout());

        jPanel3.add(jPanel1);


        jPanel4 = new javax.swing.JPanel(new FlowLayout());
        

        jPanel4.add(AddNew);
        jPanel4.add(Cancel);
        jPanel4.add(Clear);
        setLocation((screen.width - 500) / 2, ((screen.height - 350) / 2));
        setResizable(false);

        try {

            Statement s = DBConnection.getDBConnection().createStatement();
        } catch (Exception excp) {
            excp.printStackTrace();
        }


       // generator();
        /*txtRouteName.addKeyListener(new KeyAdapter() {

            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isLetter(c) ||
                        (c == KeyEvent.VK_BACK_SPACE) ||
                        (c == KeyEvent.VK_SPACE) ||
                        (c == KeyEvent.VK_DELETE))) {

                    getToolkit().beep();
                    JOptionPane.showMessageDialog(null, "This Field Only acept text", "ERROR",
                            JOptionPane.DEFAULT_OPTION);
                    e.consume();
                }
            }
        });*/
       /* txtTo.addKeyListener(new KeyAdapter() {

            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isLetter(c) ||
                        (c == KeyEvent.VK_BACK_SPACE) ||
                        (c == KeyEvent.VK_SPACE) ||
                        (c == KeyEvent.VK_DELETE))) {

                    getToolkit().beep();
                    JOptionPane.showMessageDialog(null, "This Field Only acept text", "ERROR",
                            JOptionPane.DEFAULT_OPTION);
                    e.consume();
                }
            }
        });
        txtFrom.addKeyListener(new KeyAdapter() {

            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isLetter(c) ||
                        (c == KeyEvent.VK_BACK_SPACE) ||
                        (c == KeyEvent.VK_SPACE) ||
                        (c == KeyEvent.VK_DELETE))) {

                    getToolkit().beep();
                    JOptionPane.showMessageDialog(null, "This Field Only acept text", "ERROR",
                            JOptionPane.DEFAULT_OPTION);
                    e.consume();
                }
            }
        });*/
       /* txtAmount.addKeyListener(new KeyAdapter() {

            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) ||
                        (c == KeyEvent.VK_BACK_SPACE) ||
                        (c == KeyEvent.VK_SPACE) ||
                        (c == KeyEvent.VK_DELETE))) {

                    getToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Amount is in Digit", "ERROR",
                            JOptionPane.DEFAULT_OPTION);
                    e.consume();
                }
            }
        });*/
       /* txtDistance.addKeyListener(new KeyAdapter() {

            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) ||
                        (c == KeyEvent.VK_BACK_SPACE) ||
                        (c == KeyEvent.VK_SPACE) ||
                        (c == KeyEvent.VK_DELETE))) {

                    getToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Distance in digit", "ERROR",
                            JOptionPane.DEFAULT_OPTION);
                    e.consume();
                }
            }
        });
*/

        AddNew.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                 
                if (txtRouteNo.getText() == null ||
                        txtRouteNo.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter route number", "ERROR",
                            JOptionPane.DEFAULT_OPTION);
                    txtRouteNo.requestFocus();
                    return;
                }
                if (txtRouteName.getText() == null ||
                        txtRouteName.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Enter route name", "ERROR",
                            JOptionPane.DEFAULT_OPTION);
                    txtRouteName.requestFocus();
                    return;
                }
                if (txtFrom.getText() == null ||
                        txtFrom.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter From", "ERROR",
                            JOptionPane.DEFAULT_OPTION);
                    txtFrom.requestFocus();
                    return;
                }
                if (txtTo.getText() == null ||
                        txtTo.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter To", "ERROR",
                            JOptionPane.DEFAULT_OPTION);
                    txtTo.requestFocus();
                    return;
                }
               
                
                try {
                    Statement statement = DBConnection.getDBConnection().createStatement();
                    {
                        String temp = "INSERT INTO Users (Name, Category, Username, Password) VALUES ('" +
                                txtRouteNo.getText() + "', '" +
                                txtDistance.getText() + "', '" +
                                txtRouteName.getText() + "', '" +
                                txtFrom.getText() + "')";
                                
                                    int result = statement.executeUpdate(temp);
                                    
                                    
                                    new MDIWindow().LoginUser();
                                    
                        //String ObjButtons[] = {"Yes", "No"};
                        //int PromptResult = JOptionPane.showOptionDialog(null, "Record succesfully added.Do you want to add another?",
                          //      "tobiluoch", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[1]);
                       /* if (PromptResult == 0) {
                            //txtRouteNo.setText("");
                            //generator();
                            txtRouteName.setText("");
                            txtFrom.setText("");
                            txtTo.setText("");
                            txtDistance.setText("");


                        } else {
                            setVisible(false);
                        }*/
                    }

                } catch (SQLException sqlex) {
                    sqlex.printStackTrace();

                }
            }
        });

        Cancel.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent e) {
                setVisible(true);
                dispose();
            }
        });

        Clear.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent e) {

                txtRouteNo.setText("");
                txtRouteName.setText("");
                txtFrom.setText("");
                txtTo.setText("");
                txtDistance.setText("");
                txtAmount.setText("");
            }
        });

        jPanel5 = new javax.swing.JPanel(new java.awt.BorderLayout());

        jPanel5.add(jPanel3, BorderLayout.CENTER);
        jPanel5.add(jPanel4, BorderLayout.SOUTH);
        
        jPanel1.setBackground(new Color(243, 225, 193));
        jPanel3.setBackground(new Color(243, 225, 193));
        jPanel4.setBackground(new Color(243, 225, 193));
        jPanel5.setBackground(new Color(243, 225, 193));
        
        getContentPane().add(jPanel5);
        this.getContentPane().setBackground(new Color(243, 225, 193));
        pack();
        setVisible(true);
    }



   /* private void generator() {

        try {
            ResultSet rst = DBConnection.getDBConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeQuery("SELECT Route_No FROM Route");
            while (rst.next()) {
                String s;
                int number = rst.getInt(1);
                number = number + 1;

                s = "" + number;
                txtRouteNo.setText(s);

            }
        } catch (Exception n) {
            n.printStackTrace();
        }


    }*/
}
