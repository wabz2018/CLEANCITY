/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cleancity;
import Settings.BincodeGen;
import Settings.DigitalClock;
import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Black-ish
 */
public class MAIN_DASHBOARD extends javax.swing.JFrame {
Connection main_dashboard;
PreparedStatement pst;
ResultSet rs;
DBconnection db= new DBconnection();
public String sql="";
public String dbstatus="";
String ename, edesc, eward;
String bcode, bdesc, btype;
String tname, tdriver, troute;
String rname, rdesc, rtruck;
String dfname, demail, dphone, d_othernames,pass;
     String dest, routename, routedesc;
     String m_message, m_sender, m_sender_group, m_receiver, m_receiver_grp;
    BincodeGen newcod=new BincodeGen();
    Main_Login login= new Main_Login();
    /**
     * Creates new form MAIN_DASHBOARD
     */
    public MAIN_DASHBOARD() {
      initComponents();
//        String choice="";
//        dbstatus=adminlabel.getText().toString();
//        if(dbstatus.equalsIgnoreCase(""))
//        {
//           JOptionPane.showMessageDialog(this, "Login to access the functionalities");
////            choice=JOptionPane.showInputDialog(this, "Select 1.Login \n 2. Cancel to 3.exit");
////            if(choice.equalsIgnoreCase("Login"))
////            {
////             
////                Main_Login login= new Main_Login();
////                login.setVisible(true);
////                   this.minimumSize();
////            }
////            else if(choice.equalsIgnoreCase("Cancel") ||choice.equalsIgnoreCase("Exit"))
////            {
////                JOptionPane.showMessageDialog(this, "Thank you for Visting CCMS: Sign up for more");
////          
////                DigitalClock clock= new DigitalClock();
////                
////            }
////            
//        }
//        else{
        // initComponents();
        main_dashboard=db.MainConn();
        loadEstates();
        loadSubs();
        loadWards();
        LoadAllEstates();
        AddSub();
        LoadAllBins();
        LoadAllDrivers();
        LoadAllRoutes();
        loadDrivers();
        LoadRoutes();
        LoadTrucks();
        LoadEsttoRoute();
        EstDestBIn();
        EstBinPlacement();
        LoadPlacedBins();
       LoadEstateOfficers();
      LoadOfficerPlacment();
       InboxMessages();
      sentMessages();
   
       //bcode=newcod.getType(3);
     //  System.out.println("Random bumber"+bcode);
       // }
        //secure the login fast 
    }
    public void LoadTrucks()
    {
        dbstatus=adminlabel.getText().toString();
        String n=login.GetEmail(demail).toString();
        if(!dbstatus.equalsIgnoreCase(n))
        {
            main_dashboard=null;
            JOptionPane.showMessageDialog(this, "Access denied");
        }
        else{
    sql= "select reg_number as 'REG NUMBER', driver_name as DRIVER, router_name as ROUTE from trucks";
    try{pst=main_dashboard.prepareStatement(sql);
    rs= pst.executeQuery();
    tableTrucks.setModel(DbUtils.resultSetToTableModel(rs));
    }
    catch(Exception e)
    {
    JOptionPane.showMessageDialog(null, e.getMessage());
    }     }
    }
    
 public void LoadOfficerPlacment()
    {
        dbstatus=adminlabel.getText().toString();
        String n=login.GetEmail(demail).toString();
        if(!dbstatus.equalsIgnoreCase(n))
        {
            main_dashboard=null;
            JOptionPane.showMessageDialog(this, "Access denied");
        }
        else{
    sql="select * from placement";
    try{pst=main_dashboard.prepareStatement(sql);
    rs=pst.executeQuery();
    officerplacement.setModel(DbUtils.resultSetToTableModel(rs));
    }
    catch(Exception e)
    {
    JOptionPane.showMessageDialog(this, e.getMessage());
    }
        }
    }
  public void LoadEsttoRoute()
    { 
      dbstatus=adminlabel.getText().toString();
        String n=login.GetEmail(demail).toString();
        if(!dbstatus.equalsIgnoreCase(n))
        {
            main_dashboard=null;
            JOptionPane.showMessageDialog(this, "Access denied");
        }
        else{
        sql="select estate_name as NAME from estate ";
        try{pst=main_dashboard.prepareStatement(sql);
        rs= pst.executeQuery();
        while(rs.next())
        {
          rname= rs.getString("name");
          comboEstates.addItem(rname);
        }
        }
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(this, e.getMessage());
        }}
    }
public void LoadAllEstates()
{    dbstatus=adminlabel.getText().toString();
        String n=login.GetEmail(demail).toString();
        if(!dbstatus.equalsIgnoreCase(n))
        {
            main_dashboard=null;
            JOptionPane.showMessageDialog(this, "Access denied");
        }
        else{
    sql="select estate_name as NAME, description as DETAILS, ward_name as WARD from estate";
   try{pst=main_dashboard.prepareStatement(sql);
   rs= pst.executeQuery();
   tableEst.setModel(DbUtils.resultSetToTableModel(rs));
   rs.close();
   pst.close();
   }
   catch(Exception e)
   {JOptionPane.showMessageDialog(this, e.getMessage());
   }}
}
public void LoadAllBins()
{    dbstatus=adminlabel.getText().toString();
        String n=login.GetEmail(demail).toString();
        if(!dbstatus.equalsIgnoreCase(n))
        {
            main_dashboard=null;
            JOptionPane.showMessageDialog(this, "Access denied");
        }
        else
        {
    sql="select bin_code as NAME, description as DETAILS, type as TYPE , status as STATUS from bin_category";
   try{pst=main_dashboard.prepareStatement(sql);
   rs= pst.executeQuery();
   tableEst1.setModel(DbUtils.resultSetToTableModel(rs));
   rs.close();
   pst.close();
   }
   catch(Exception e)
   {JOptionPane.showMessageDialog(this, e.getMessage());
   }}
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablewards = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablesubcounties = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableEstates = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        btnEUp3 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        officerplacement = new javax.swing.JTable();
        jLabel42 = new javax.swing.JLabel();
        userEstates = new javax.swing.JComboBox<>();
        SAVEUSER = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnEUp1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tableTrucks = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        combodirvers = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        comboroutes = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jButton20 = new javax.swing.JButton();
        jTextField12 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        btnEUp2 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tableEst1 = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        bintype = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtcode = new javax.swing.JTextField();
        jButton16 = new javax.swing.JButton();
        jTextField9 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tableRoutes = new javax.swing.JTable();
        jButton17 = new javax.swing.JButton();
        btnEUp5 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        comboEstates = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jButton25 = new javax.swing.JButton();
        jTextField20 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        btnEUp4 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        tableDrivers = new javax.swing.JTable();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jButton21 = new javax.swing.JButton();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tableRoutes1 = new javax.swing.JTable();
        jButton22 = new javax.swing.JButton();
        btnEUp6 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        comboEstatesbin = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        combobins = new javax.swing.JComboBox<>();
        jButton26 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        combowards = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        combosubs = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableEst = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        btnESave = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        btnEUp = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField25 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel48 = new javax.swing.JLabel();
        btnSent = new javax.swing.JButton();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        btnRead = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jTextField27 = new javax.swing.JTextField();
        txtsenderemail = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tableSMSent = new javax.swing.JTable();
        jScrollPane16 = new javax.swing.JScrollPane();
        tableSMBox = new javax.swing.JTable();
        adminlabel = new javax.swing.JLabel();
        jButton27 = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        lbgrp = new javax.swing.JLabel();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CCMS || ADMIN");
        setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        setForeground(new java.awt.Color(153, 153, 255));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setName("Admin"); // NOI18N
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jTabbedPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        tablewards.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 102, 255), 2, true));
        tablewards.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablewards);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("WARDS ", jPanel1);

        tablesubcounties.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 2, true));
        tablesubcounties.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tablesubcounties);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("SUB COUNTIES", jPanel2);

        tableEstates.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 102, 255), 2, true));
        tableEstates.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tableEstates);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ESTATES", jPanel3);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("CCMS ||  ADD OFFICER");
        jLabel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("CCMS ||  UPDATE|VIEW ");
        jLabel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel18.setText("Registered");

        jButton10.setText("VIEW");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("EDIT");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        btnEUp3.setForeground(new java.awt.Color(102, 102, 255));
        btnEUp3.setText("UPDATE");
        btnEUp3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEUp3ActionPerformed(evt);
            }
        });

        jButton12.setForeground(new java.awt.Color(255, 51, 51));
        jButton12.setText("DELETE");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        officerplacement.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        officerplacement.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        officerplacement.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        officerplacement.setGridColor(new java.awt.Color(0, 0, 255));
        jScrollPane9.setViewportView(officerplacement);

        jLabel42.setText("EStates");

        userEstates.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        SAVEUSER.setText("SAVE");
        SAVEUSER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SAVEUSERActionPerformed(evt);
            }
        });

        jLabel43.setText("First Name");

        jLabel44.setText("Other Names");

        jLabel45.setText("Phone");

        jLabel46.setText("Email Address");

        jTextField21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextField22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextField23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel46)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField24))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel42)
                                        .addGap(30, 30, 30)
                                        .addComponent(userEstates, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel43)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField21)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(SAVEUSER))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel44)
                                    .addComponent(jLabel45))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField22)
                                    .addComponent(jTextField23))))))
                .addGap(273, 273, 273)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel18)
                            .addGap(34, 34, 34)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jButton11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnEUp3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66))
            .addComponent(jScrollPane9)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42)
                    .addComponent(userEstates, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43)
                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10)
                    .addComponent(jLabel44)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEUp3)
                    .addComponent(jButton11)
                    .addComponent(jLabel45)
                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton12)
                            .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                        .addComponent(SAVEUSER)))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Officers", jPanel5);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CCMS ||  ADD TRUCK");
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CCMS ||  UPDATE|VIEW ");
        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel16.setText("Registered");

        jButton4.setText("VIEW");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("EDIT");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btnEUp1.setForeground(new java.awt.Color(102, 102, 255));
        btnEUp1.setText("UPDATE");
        btnEUp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEUp1ActionPerformed(evt);
            }
        });

        jButton6.setForeground(new java.awt.Color(255, 51, 51));
        jButton6.setText("DELETE");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        tableTrucks.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        tableTrucks.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableTrucks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableTrucks.setGridColor(new java.awt.Color(0, 0, 255));
        jScrollPane8.setViewportView(tableTrucks);

        jLabel23.setText("Drivers");

        combodirvers.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        combodirvers.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                combodirversPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel24.setText("Route");

        comboroutes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel28.setText("Reg NO. ");

        jButton20.setText("SAVE");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jTextField12.setEditable(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel16)
                                .addGap(82, 82, 82)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton20, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(combodirvers, javax.swing.GroupLayout.Alignment.LEADING, 0, 256, Short.MAX_VALUE)
                                        .addComponent(comboroutes, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 202, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEUp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(66, 66, 66))
            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEUp1)
                            .addComponent(jButton5))
                        .addGap(12, 12, 12)
                        .addComponent(jButton6))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel24)
                                    .addComponent(comboroutes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(combodirvers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton20)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 254, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("MANAGE TRUCKS", jPanel8);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("CCMS ||  ADD BIN ");
        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("CCMS ||  UPDATE|VIEW ");
        jLabel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel17.setText("Registered");

        jButton7.setText("VIEW");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("EDIT");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        btnEUp2.setForeground(new java.awt.Color(102, 102, 255));
        btnEUp2.setText("UPDATE");
        btnEUp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEUp2ActionPerformed(evt);
            }
        });

        jButton9.setForeground(new java.awt.Color(255, 51, 51));
        jButton9.setText("DELETE");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        tableEst1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        tableEst1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableEst1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableEst1.setGridColor(new java.awt.Color(0, 0, 255));
        jScrollPane7.setViewportView(tableEst1);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("TYPE");

        bintype.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bintype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--select--", "Recyclable", "BioDegradable", "UnRecyclable" }));
        bintype.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                bintypePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Description");

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Bin Code");

        txtcode.setEditable(false);
        txtcode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton16.setForeground(new java.awt.Color(102, 102, 255));
        jButton16.setText("SAVE");
        jButton16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(42, 42, 42)
                                .addComponent(txtcode, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel17)
                                    .addGap(34, 34, 34)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jButton8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnEUp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(bintype, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(402, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(bintype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jButton7)
                                .addGap(16, 16, 16))))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22)
                        .addComponent(txtcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEUp2)
                    .addComponent(jButton8))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jButton9))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jButton16)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("MANAGE BINS", jPanel6);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("CCMS ||  UPDATE|VIEW ");
        jLabel25.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("CCMS ||  ADD ROUTE");
        jLabel26.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        tableRoutes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        tableRoutes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableRoutes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableRoutes.setGridColor(new java.awt.Color(0, 0, 255));
        jScrollPane11.setViewportView(tableRoutes);

        jButton17.setForeground(new java.awt.Color(255, 51, 51));
        jButton17.setText("DELETE");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        btnEUp5.setForeground(new java.awt.Color(102, 102, 255));
        btnEUp5.setText("UPDATE");
        btnEUp5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEUp5ActionPerformed(evt);
            }
        });

        jButton18.setText("VIEW");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setText("EDIT");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jLabel27.setText("Registered");

        jLabel33.setText("DEstination Estate");

        comboEstates.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel39.setText("Route Name");

        jLabel40.setText("Description ");

        jButton25.setText("SAVE");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jTextField20.setEditable(false);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane11)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40)
                            .addComponent(jLabel39))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jButton25))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboEstates, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addComponent(jLabel27)
                            .addGap(34, 34, 34)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addComponent(jButton19)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnEUp5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboEstates, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33)
                            .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton18)
                    .addComponent(jLabel40)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEUp5)
                    .addComponent(jButton19))
                .addGap(12, 12, 12)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton17)
                    .addComponent(jButton25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("MANAGE ROUTES", jPanel9);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("CCMS ||  ADD DRIVER ");
        jLabel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("CCMS ||  UPDATE|VIEW ");
        jLabel10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel19.setText("Registered");

        jButton13.setText("VIEW");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("EDIT");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        btnEUp4.setForeground(new java.awt.Color(102, 102, 255));
        btnEUp4.setText("UPDATE");
        btnEUp4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEUp4ActionPerformed(evt);
            }
        });

        jButton15.setForeground(new java.awt.Color(255, 51, 51));
        jButton15.setText("DELETE");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        tableDrivers.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        tableDrivers.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableDrivers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableDrivers.setGridColor(new java.awt.Color(0, 0, 255));
        jScrollPane10.setViewportView(tableDrivers);

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setText("First Name");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setText("Email");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setText("Phone");

        jButton21.setText("SAVE");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jTextField13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField13.setToolTipText("main name");

        jTextField14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField14.setToolTipText("johnydoe@gmail.com");

        jTextField15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField15.setToolTipText("0700000000 0r +254700000000 ");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setText("Other Names");

        jTextField16.setToolTipText("surname or middlename");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField16, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                        .addGap(422, 422, 422)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel29)
                                            .addComponent(jLabel31)
                                            .addComponent(jLabel30))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextField14, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                            .addComponent(jTextField15))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jButton21)))
                                .addGap(265, 265, 265))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel19)
                                    .addGap(34, 34, 34)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEUp4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1))
                            .addComponent(jButton15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(54, 54, 54))
            .addComponent(jScrollPane10)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton13)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEUp4)
                            .addComponent(jButton14))
                        .addGap(12, 12, 12)
                        .addComponent(jButton15))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jButton21)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Drivers", jPanel4);

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("CCMS ||  UPDATE|VIEW ");
        jLabel34.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("CCMS ||  BIN PLACEMENT");
        jLabel35.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        tableRoutes1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        tableRoutes1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableRoutes1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableRoutes1.setGridColor(new java.awt.Color(0, 0, 255));
        jScrollPane12.setViewportView(tableRoutes1);

        jButton22.setForeground(new java.awt.Color(255, 51, 51));
        jButton22.setText("DELETE");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        btnEUp6.setForeground(new java.awt.Color(102, 102, 255));
        btnEUp6.setText("UPDATE");
        btnEUp6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEUp6ActionPerformed(evt);
            }
        });

        jButton23.setText("VIEW");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton24.setText("EDIT");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jLabel36.setText("Registered");

        jLabel37.setText("DEstination Estate");

        comboEstatesbin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel38.setText("BINS");

        jButton26.setText("PLACEMENT");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane12)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel37)
                                .addComponent(jLabel38))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(comboEstatesbin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(combobins, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jButton26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 233, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addComponent(jLabel36)
                            .addGap(34, 34, 34)
                            .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addComponent(jButton24)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnEUp6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(comboEstatesbin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(combobins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEUp6)
                    .addComponent(jButton24)
                    .addComponent(jButton26))
                .addGap(12, 12, 12)
                .addComponent(jButton22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(0, 10, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 10, Short.MAX_VALUE)))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(0, 92, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 92, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("BIN PLACEMENT", jPanel10);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CCMS ||  ADD ESTATE ");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CCMS ||  UPDATE|VIEW ");
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("WARD");

        combowards.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Sub_County");

        combosubs.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        combosubs.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                combosubsPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        tableEst.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        tableEst.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableEst.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableEst.setGridColor(new java.awt.Color(0, 0, 255));
        jScrollPane5.setViewportView(tableEst);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("NAME");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("Short Description");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane6.setViewportView(jTextArea1);

        btnESave.setForeground(new java.awt.Color(0, 51, 255));
        btnESave.setText("SAVE");
        btnESave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnESaveActionPerformed(evt);
            }
        });

        jLabel15.setText("Registered");

        btnEUp.setForeground(new java.awt.Color(102, 102, 255));
        btnEUp.setText("UPDATE");
        btnEUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEUpActionPerformed(evt);
            }
        });

        jButton3.setForeground(new java.awt.Color(255, 51, 51));
        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setText("VIEW");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("EDIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel14))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnESave)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(combosubs, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(combowards, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(382, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 273, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addGap(34, 34, 34)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jButton2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnEUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(66, 66, 66))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(combosubs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combowards, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEUp)
                            .addComponent(jButton2))
                        .addGap(12, 12, 12)
                        .addComponent(jButton3))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(btnESave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("MANAGE ESTATES", jPanel7);

        jLabel47.setText("User Group");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Drivers", "Officers" }));
        jComboBox2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox2PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane13.setViewportView(jTextArea2);

        jLabel48.setText("Message");

        btnSent.setForeground(new java.awt.Color(102, 0, 255));
        btnSent.setText("SEND");
        btnSent.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        btnSent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSentActionPerformed(evt);
            }
        });

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ".....", "ALL", "Admin", "Drivers", "Officers" }));
        jComboBox4.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox4PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jComboBox5.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox5PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel49.setText("Username");

        jLabel50.setText("User Group");

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane14.setViewportView(jTextArea3);

        btnRead.setForeground(new java.awt.Color(255, 102, 102));
        btnRead.setText("READ ");
        btnRead.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });

        jComboBox3.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox3PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel51.setText("User ");

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(51, 51, 255));
        jLabel52.setText("CCMS|| CREATE SEND");
        jLabel52.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(51, 51, 255));
        jLabel53.setText("CCMS|| READ VIEW ");
        jLabel53.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jTextField27.setEditable(false);

        txtsenderemail.setEditable(false);

        jLabel54.setForeground(new java.awt.Color(102, 102, 255));
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("INBOX");
        jLabel54.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel55.setForeground(new java.awt.Color(255, 51, 0));
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("SENT");
        jLabel55.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        tableSMSent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane15.setViewportView(tableSMSent);

        tableSMBox.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane16.setViewportView(tableSMBox);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRead, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(54, 54, 54)
                                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel48)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addGap(235, 235, 235)
                                        .addComponent(btnSent, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(jScrollPane13)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28)
                                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsenderemail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addComponent(jLabel52, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel47)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel50)))
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51)
                            .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtsenderemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel48)
                                .addGap(83, 83, 83))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSent))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRead)
                .addGap(10, 10, 10)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("NOTICE BOARD", jPanel12);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipady = -12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        getContentPane().add(jTabbedPane1, gridBagConstraints);

        adminlabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        adminlabel.setForeground(new java.awt.Color(51, 51, 255));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 198;
        gridBagConstraints.ipady = 31;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(adminlabel, gridBagConstraints);

        jButton27.setText("LOGOUT");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 131, 0, 0);
        getContentPane().add(jButton27, gridBagConstraints);

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 51, 51));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("CCMS || ADMINISTRATOR DASHBOARD");
        jLabel41.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jLabel41.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 33;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 77, 0, 0);
        getContentPane().add(jLabel41, gridBagConstraints);
        getContentPane().add(lbgrp, new java.awt.GridBagConstraints());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combosubsPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_combosubsPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        
        combowards.removeAllItems();
        String sname=combosubs.getSelectedItem().toString();
        sql="select ward_name from ward where sub_county_name ='"+sname+"'";
        try{pst=main_dashboard.prepareStatement(sql);
        rs= pst.executeQuery();
        while(rs.next())
        {
        String ward=rs.getString("ward_name");
        combowards.addItem(ward);
        }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,  e.getMessage());
        }
    }//GEN-LAST:event_combosubsPopupMenuWillBecomeInvisible

    private void btnESaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnESaveActionPerformed
        // TODO add your handling code here:
      
        ename=jTextField1.getText().toString().trim();
        edesc= jTextArea1.getText().toString().trim();
        eward=combowards.getSelectedItem().toString().trim();
        
        sql="Insert into estate(estate_name, description, ward_name)VALUES(?,?,?)";
        if(ename.isEmpty()&&edesc.isEmpty()&&eward.isEmpty())
        {
         JOptionPane.showMessageDialog(null, "Please Enter values for the fields");
        }
        else{
        try{pst=main_dashboard.prepareStatement(sql);
        pst.setString(1, ename);
        pst.setString(2, edesc);
        pst.setString(3, eward);
        pst.execute();
        JOptionPane.showMessageDialog(null,"Added successfully"+ename);
        combowards.removeAllItems();
        jTextArea1.setText("");
        jTextField1.setText("");
        comboEstates.removeAllItems();
        LoadAllEstates();
        loadEstates();
       LoadEsttoRoute();
        }
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnESaveActionPerformed
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        ename=jTextField2.getText().toString();
        sql="delete from estate where estate_name='"+ename+"'";
        try{pst=main_dashboard.prepareStatement(sql);
        pst.execute();
          jTextField2.setText("");
          JOptionPane.showMessageDialog(null,ename +"deleted successfully");
        LoadAllEstates();
        loadEstates();
      
        
        }
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnEUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEUpActionPerformed
        // TODO add your handling code here:
         ename= jTextField2.getText().toString();
          edesc= jTextArea1.getText().toString();
        sql= "Update estate set description='"+edesc+"' where estate_name='"+ename+"'";
   
    if(edesc.isEmpty())
    {
        JOptionPane.showMessageDialog(null, "Provide description for that ");
    }
    else{
        try{pst=main_dashboard.prepareStatement(sql);
        pst.execute();
        JOptionPane.showMessageDialog(this, ename + "Updated Successfully");
        jTextArea1.setText("");
        jTextField2.setText("");
        jTextField1.setText("");
        LoadAllEstates();
        loadEstates();
        combowards.removeAllItems();
        }catch(Exception e)
        {
        JOptionPane.showMessageDialog(null, e.getMessage());
        }
    
    
    }
    }//GEN-LAST:event_btnEUpActionPerformed
public void sentMessages()
{
    String user=adminlabel.getText().toString();
 
    sql="select receiver_group as 'GROUP SMS',timesent as AT, sms as SMS from message where sender_email='"+user+"'";
    try{
        pst=main_dashboard.prepareStatement(sql);
        rs=pst.executeQuery();
        tableSMSent.setModel(DbUtils.resultSetToTableModel(rs));
    }
    catch(Exception e)
    {
    JOptionPane.showMessageDialog(this, e.getMessage());
    }
    
    
}
public void InboxMessages()
{
    String g= "Admin";
  String user=adminlabel.getText().toString();
  
    sql="select sender_email as SENDER,timesent as AT, sms as SMS from message where receiver_email='"+user+"' or receiver_group='"+g+"'";
    try{
        pst=main_dashboard.prepareStatement(sql);
        rs=pst.executeQuery();
        tableSMBox.setModel(DbUtils.resultSetToTableModel(rs));
    }
    catch(Exception e)
    {
    JOptionPane.showMessageDialog(this, e.getMessage());
    }
}

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        combowards.removeAllItems();
        jTextField1.setEditable(false);
        jTextArea1.setEditable(false);
        
        ename= jTextField2.getText().toString();
        sql="select * from estate where estate_name='"+ename+"'";
        try{pst=main_dashboard.prepareStatement(sql);
        rs= pst.executeQuery();
        if(rs.next())
        {
        String e= rs.getString("estate_name"), w= rs.getString("ward_name"), d=rs.getString("description");
        jTextField1.setText(e);
        jTextArea1.setText(d);
        combowards.addItem(w);
        }
        }
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jTextArea1.setEditable(true);
        jTextField1.setEditable(true);
        combowards.removeAllItems();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnEUp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEUp1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEUp1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
       // sql="delete from ";
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        txtcode.setEditable(false);
                jTextField7.setEditable(false);
                jTextField9.setEditable(false);
        String id= jTextField4.getText().toString();
        sql= "select * from bin_category where id='"+id+"'";
        try{pst=main_dashboard.prepareStatement(sql);
        rs= pst.executeQuery();
        if(rs.next())
        {
        bcode=rs.getString("bin_code");
        txtcode.setText(bcode);
        bdesc=rs.getString("description");
        jTextField7.setText(bdesc);
        btype=rs.getString("type");
        jTextField9.setText(btype);
        }
        else{JOptionPane.showMessageDialog(null,"No bin  with " +id+ " is registered");}
        }
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        jTextField7.setEditable(true);  txtcode.setEditable(true);   jTextField9.setEditable(true);
                
    }//GEN-LAST:event_jButton8ActionPerformed

    private void btnEUp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEUp2ActionPerformed
        // TODO add your handling code here:
        String id= jTextField4.getText();
        bcode= txtcode.getText().toString();
        btype= jTextField9.getText().toString();
        bdesc= jTextField7.getText().toString();
        sql="update bin_category set type='"+btype+"', description='"+bdesc+"' where id='"+id+"'" ;
        if( btype.isEmpty()&& bdesc.isEmpty())
        {
          JOptionPane.showMessageDialog(null, "Fill the changes to update");
        }
            else{
        try{pst=main_dashboard.prepareStatement(sql);
        pst.execute();
       JOptionPane.showMessageDialog(null, "Updated successfully"+id);
        LoadAllBins();
       jTextField7.setText("");  txtcode.setText("");   jTextField9.setText("");jTextField4.setText("");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
        }
    }//GEN-LAST:event_btnEUp2ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        String id=jTextField4.getText().toString();
        txtcode.setText("");
        jTextField7.setText("");
        jTextField9.setText("");
        sql= "Delete from bin_category where id ='"+id+"'";
        if(id.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please Enter Id to delete");
                    
        }
        else{
        try{pst=main_dashboard.prepareStatement(sql);
        pst.execute();
        JOptionPane.showMessageDialog(this, "Deleted bin with "+ id + "Successfully");
        LoadAllBins();
         jTextField4.setText("");
        }
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(null, e.getMessage());
        }
        }
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void btnEUp3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEUp3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEUp3ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void btnEUp4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEUp4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEUp4ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:]
        sql="Insert into bin_category(type, description, bin_code)VALUES(?,?,?)";
        bcode=txtcode.getText().toString();
        btype=bintype.getSelectedItem().toString();
        bdesc=jTextField7.getText().toString();
        if(bcode.isEmpty() && btype.isEmpty() && bdesc.isEmpty())
        {
        JOptionPane.showMessageDialog(this, "Fill and select type");
        }
        else{
        try{pst=main_dashboard.prepareStatement(sql);
        pst.setString(1, btype);
        pst.setString(2, bdesc);
         pst.setString(3, bcode);
         pst.execute();
         LoadAllBins();
         JOptionPane.showMessageDialog(null, "Successfully added");
         jTextField7.setText("");
         txtcode.setText("");
         
         
        }
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(this, e.getMessage());
        }
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        routename=jTextField10.getText();
        sql="delete from route where id='"+routename+"'";
        if(routename.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Enter Id of the route to delete");
        }
        else{
        try{pst=main_dashboard.prepareStatement(sql);
        pst.execute();
        JOptionPane.showMessageDialog(this, "Deleted successfully");
            jTextField10.setText("");
            LoadAllRoutes();
            LoadRoutes();
        }catch(Exception e)
        {
        JOptionPane.showMessageDialog(null, e.getMessage());
        }
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void btnEUp5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEUp5ActionPerformed
        // TODO add your handling code here:
//        jTextField18.setEditable(false);
//        jTextField19.setEditable(false);
String id= jTextField10.getText();
routename=jTextField19.getText();routedesc=jTextField18.getText(); dest=comboEstates.getSelectedItem().toString();
        sql="Update route set route_name='"+routename+"',description='"+routedesc+"', dest_est='"+dest+"' where id='"+id+"'";
        if(routename.isEmpty() && routedesc.isEmpty() && dest.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Fill the fields");
        }
        else{
            try
            {pst=main_dashboard.prepareStatement(sql);
        pst.execute();
        JOptionPane.showMessageDialog(this, "Updated successfully");
        LoadAllRoutes();
        jTextField10.setText("");
        jTextField19.setText("");
        jTextField18.setText("");
        jTextField20.setText("");
          
            }
            catch(Exception e)
            {
            
            JOptionPane.showMessageDialog(this, e.getMessage());
            }
        
        }
    }//GEN-LAST:event_btnEUp5ActionPerformed
public void LoadEstateOfficers()        
{   dbstatus=adminlabel.getText().toString();
        String n=login.GetEmail(demail).toString();
        if(!dbstatus.equalsIgnoreCase(n))
        {
            main_dashboard=null;
            JOptionPane.showMessageDialog(this, "Access denied");
        }
        else {
    sql= "select estate_name as name from estate where officer='not yet'";
try{pst=main_dashboard.prepareStatement(sql);
rs= pst.executeQuery();
while(rs.next())
{
rname=rs.getString("name");
userEstates.addItem(rname);
}
}
catch(Exception e)
{
JOptionPane.showMessageDialog(this, e.getMessage());
}
        }
}
    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        jTextField18.setEditable(false);
        jTextField19.setEditable(false);
        routename=jTextField10.getText();
        sql="select * from route where id='"+routename+"'";
        if(routename.isEmpty())
        {
        JOptionPane.showMessageDialog(this, "Please input the id to view details");
        }
        else{
        try{pst= main_dashboard.prepareStatement(sql);
        rs= pst.executeQuery();
        if(rs.next())
        {
        rname=rs.getString("route_name");
        jTextField19.setText(rname);
        dest=rs.getString("dest_est");
        jTextField20.setText(dest);
        routedesc=rs.getString("description");
        jTextField18.setText(routedesc);
        rs.close();
        pst.close();
        LoadRoutes();
        LoadAllRoutes();
        }
        else{
            JOptionPane.showMessageDialog(this, "No data found");
        }
        }
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(this, e.getMessage());
        }
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Editing enabled");
                
        jTextField18.setEditable(true);
        jTextField19.setEditable(true);
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        tname=jTextField11.getText().toString().trim();
        tdriver=combodirvers.getSelectedItem().toString();
        troute=comboroutes.getSelectedItem().toString();
        sql= "Insert into trucks(reg_number, driver_name, router_name)VALUES(?,?,?)";
        if(tname.length()<5 && tdriver.isEmpty() && troute.isEmpty())
        {
        JOptionPane.showMessageDialog(null, "Input correct truck Reg Number");
        }
        else{
        try{pst=main_dashboard.prepareStatement(sql);
        pst.setString(1, tname);
        pst.setString(2, tdriver);
        pst.setString(3, troute);
        pst.execute();
        JOptionPane.showMessageDialog(null, "Truck added  :"+tname);
        UPdateDriver();
        UpdateRoute();
        LoadTrucks();
        jTextField12.setText("");
        jTextField11.setText("");
        }
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        }
      LoadAllDrivers();
      LoadAllRoutes();
    }//GEN-LAST:event_jButton20ActionPerformed

    private void combodirversPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_combodirversPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        int id=combodirvers.getSelectedIndex();
        int new_id = id+1;
        sql="select email from driver where id='"+new_id+"'";
        try{pst=main_dashboard.prepareStatement(sql);
        rs= pst.executeQuery();
        if(rs.next())
        {
        String demail=rs.getString("email");
        jTextField12.setText(demail);
        rs.close();
        pst.close();
        }
        
        }
        catch(Exception e)
        {JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_combodirversPopupMenuWillBecomeInvisible

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        //String dfname, demail, dphone, d_othernames,pass;
        pass="12345";
        sql="insert into driver(email, phone_number,firstname, other_names, password)VALUES(?,?,?,?,?)";
        demail=jTextField14.getText();
        dphone=jTextField15.getText();
        dfname=jTextField13.getText();
        d_othernames=jTextField16.getText();
        if(demail.length()<16 && dphone.length()<10 &&dphone.length()>13)
        {
        JOptionPane.showMessageDialog(this, "Check your emial or phone number to be valid");
        }
        else if(dfname.length()<5 &&d_othernames.length()<5)
        {
       JOptionPane.showMessageDialog(null, "Please provide firstname and other names");
        }
        else{
            try{pst= main_dashboard.prepareStatement(sql);
            pst.setString(1,demail);
            pst.setString(2,dphone);
            pst.setString(3, dfname);
            pst.setString(4,d_othernames);
            pst.setString(5, pass);
            
            pst.execute();
            jTextField14.setText("");jTextField15.setText("");jTextField16.setText("");jTextField13.setText("");
            LoadAllDrivers();
            loadDrivers();
            }
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        }
        
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton22ActionPerformed

    private void btnEUp6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEUp6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEUp6ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        // TODO add your handling code here:
        sql="Insert into route(dest_est, route_name, description)VALUES(?,?,?)";
        dest=comboEstates.getSelectedItem().toString();
        routename=jTextField19.getText().toString();
        routedesc= jTextField18.getText().toString();
        if(dest.isEmpty() && routename.length()<5 && routedesc.isEmpty())
        {
        JOptionPane.showMessageDialog(null, "PLease fill in the details and select the destination");
        }
        else {
    try{pst= main_dashboard.prepareStatement(sql);
    pst.setString(1,dest);
    pst.setString(2,routename);
    pst.setString(3,routedesc);
    pst.execute();
    JOptionPane.showMessageDialog(null, "Route added successfully");
    LoadAllRoutes();
    LoadRoutes();
    jTextField19.setText("");jTextField18.setText("");
    
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    }
   
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
        String bplace, bname, bstatus;
        bname=combobins.getSelectedItem().toString();
        bplace=comboEstatesbin.getSelectedItem().toString();
        bstatus="Empty";
        sql= "Insert into bin_placement(bin_code, estate_name, status)VALUES(?,?,?)";
        if(bname.isEmpty() &&bplace.isEmpty())
        {
        JOptionPane.showMessageDialog(this, "Please select the bin and estate to allocate");
        }
        else{
        try{pst=main_dashboard.prepareStatement(sql);
        pst.setString(1, bname);
         pst.setString(2, bplace);
          pst.setString(3, bstatus);
          pst.execute();
           UpdateBIn();
        JOptionPane.showMessageDialog(this, "Bin placed successfully");
    
        }
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(this, e.getMessage());
        }
     }
        LoadAllBins();
        LoadEsttoRoute();
        LoadPlacedBins();
       
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:
 String option;
       option= JOptionPane.showInputDialog( "Please press Yes or Y to log out No  or Nto stay connected ");
        if(option.equalsIgnoreCase("Yes") || option.equalsIgnoreCase("Y"))
        {
             this.dispose();
             Main_Login l= new Main_Login();
             l.setVisible(true);
        }
        else if(option.equalsIgnoreCase("No")||option.equalsIgnoreCase("N")){
        JOptionPane.showMessageDialog(this, "Stay Logged in");
        }
        else{JOptionPane.showMessageDialog(this, "Wrong choice");
         option= JOptionPane.showInputDialog( "Please press Yes or Y to log out No  or Nto stay connected ");
        }
    }//GEN-LAST:event_jButton27ActionPerformed

    private void SAVEUSERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SAVEUSERActionPerformed
        // TODO add your handling code here:
     
        String st="active", pass="12345";
        dest=userEstates.getSelectedItem().toString();
        dfname=jTextField21.getText();
        d_othernames=jTextField22.getText();
        demail=jTextField24.getText();
        dphone=jTextField23.getText();
        sql="Insert into users(email, phone_number, firstname, other_names,password, status, estate_name)VALUES(?,?,?,?,?,?,?)";
        if(dest.isEmpty() && dfname.isEmpty() && d_othernames.isEmpty() && dphone.isEmpty())
        {
        JOptionPane.showMessageDialog(this, "Input appropriate values to save the user");
        }
        else{
        try{pst=main_dashboard.prepareStatement(sql);
        pst.setString(1, demail);
        pst.setString(2, dphone);
        pst.setString(3, dfname);
        pst.setString(4, d_othernames);
        pst.setString(5, pass);
        pst.setString(6, st);
        pst.setString(7, dest);
        pst.execute();
        UpdateEstate();
        JOptionPane.showMessageDialog(this, "User added successfully");
        userEstates.removeAllItems();
       LoadEstateOfficers();
       LoadOfficerPlacment();
     jTextField21.setText("");  jTextField22.setText("");  jTextField23.setText("");  jTextField24.setText("");
        }
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(this, e.getMessage());
        }
        }
    }//GEN-LAST:event_SAVEUSERActionPerformed

    private void btnSentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSentActionPerformed
        // TODO add your handling code here:
        sql="Insert into message(sender_email, receiver_group, receiver_email,sender_grp,sms, timesent,type)VALUES(?,?,?,?,?,now(),?)";
        String sender=adminlabel.getText().toString();
        String mtype="";
        String group=jComboBox2.getSelectedItem().toString();
        String re_email=jTextField27.getText().toString();
        String sgrp="Admin";
        String sms=jTextArea2.getText().toString().trim();
        if(!sms.isEmpty() &&!sender.isEmpty() &&(group.isEmpty()||re_email.isEmpty()))
        {
        JOptionPane.showMessageDialog(this, "You are about to send a group notification");
        re_email="All";
        group="All";
        mtype="Gen";
        }
        else if(!sms.isEmpty() &&!sender.isEmpty()&&(!group.isEmpty()||!re_email.isEmpty()))
        {
        mtype="spec";
        group=jComboBox2.getSelectedItem().toString();
   
        }
         else if(sms.isEmpty() &&sender.isEmpty() &&(group.isEmpty()||re_email.isEmpty()))
        {
         JOptionPane.showMessageDialog(this, "Please provide the information");
        }
        try{ pst=main_dashboard.prepareStatement(sql);
        pst.setString(1, sender);
        pst.setString(2, group);
        pst.setString(3, re_email);
        pst.setString(4, sgrp);
        pst.setString(5, sms);
        pst.setString(6, mtype);
        pst.execute();
        jTextField27.setText("");
        jComboBox3.removeAllItems();
        jTextArea2.setText("");
        JOptionPane.showMessageDialog(this, "Message sent");
        sentMessages();
        InboxMessages();
        }
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnSentActionPerformed

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
m_sender=txtsenderemail.getText();
m_receiver=adminlabel.getText();
String sms="";
        // TODO add your handling code here:
        sql= "select * from message where sender_email='"+m_sender+"' and receiver_email='"+m_receiver+"'";
        try{
        pst= main_dashboard.prepareStatement(sql);
        rs= pst.executeQuery();
        while(rs.next())
        {
        sms=rs.getString("sms");
        jTextArea3.setText(sms);
        } 
        }
        catch(Exception e)
        {
       JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
        
    }//GEN-LAST:event_btnReadActionPerformed

    private void jComboBox2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox2PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        jTextField27.setText("");
        jComboBox3.removeAllItems();
        String lbale="", email="";//driver, users
        String choice=jComboBox2.getSelectedItem().toString();
        if(choice.equalsIgnoreCase("Drivers"))
        {
       sql="select email from driver";
        lbale="Drivers";
        
        }
        else if(choice.equalsIgnoreCase("Officers"))
        {
      sql="select email from users";
        lbale="Officers";
        }
       try{pst=main_dashboard.prepareStatement(sql);
       rs= pst.executeQuery();
       while(rs.next())
       {
       email=rs.getString("email");
       jComboBox3.addItem(email);
       jLabel51.setText(lbale);
       }
       }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(this, e.getMessage());
       }
    }//GEN-LAST:event_jComboBox2PopupMenuWillBecomeInvisible

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox3PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        String u=jComboBox3.getSelectedItem().toString();
        jTextField27.setText(u);
        
    }//GEN-LAST:event_jComboBox3PopupMenuWillBecomeInvisible

    private void jComboBox4PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox4PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        jTextArea3.setText("");
        String receiver=adminlabel.getText().toString();
        String user=jComboBox4.getSelectedItem().toString();
        String choice="",sms="",sender="",label="";
        if(user.equalsIgnoreCase("Admin"))
        {
            label="Admins";
            jLabel49.setText(label);
         choice="Admin";
        sql="select * from message where sender_grp='"+choice+"' and receiver_email='"+receiver+"'";
        }
        else if(user.equalsIgnoreCase("Drivers"))
        {
            label="Drivers";
            jLabel49.setText(label);
          choice="Drivers";
        sql="select * from message where sender_grp='"+choice+"' and receiver_email='"+receiver+"'";
        }
        else if(user.equalsIgnoreCase("Officers"))
        {
          choice="Officers";
          label="Officers";
          jLabel49.setText(label);
        sql="select * from message where sender_grp='"+choice+"' and receiver_email='"+receiver+"'";
        }
        else if(user.equalsIgnoreCase("All"))
        {
          label="ALL";
          jLabel49.setText(label);
        sql="select  sender_email as EMAIL , sms as SMS from message where receiver_email='"+receiver+"' order by timesent DESC";
        }
        else{
        sql="null";
        jLabel49.setText("select");
        }
        try{pst=main_dashboard.prepareStatement(sql);
        rs= pst.executeQuery();
        tableSMBox.setModel(DbUtils.resultSetToTableModel(rs));
        
        }
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(this, e.getMessage());
        
        }
//        try{pst= main_dashboard.prepareStatement(sql);
//        rs= pst.executeQuery();
//        while(rs.next())
//        {
//        sms= rs.getString("sms");
//        sender=rs.getString("sender_email");
//        jComboBox5.addItem(sender);
//        }
//        }
//        catch(Exception e)
//        {
//        JOptionPane.showMessageDialog(this, e.getMessage());
//        }
    }//GEN-LAST:event_jComboBox4PopupMenuWillBecomeInvisible

    private void jComboBox5PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox5PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        String sms="";
        String sender=jComboBox5.getSelectedItem().toString(), receiver=adminlabel.getText().toString();
       
        
        sql="select * from message where sender_email='"+sender+"' and receiver_email='"+receiver+"'";
        try{
            pst=main_dashboard.prepareStatement(sql);
        rs= pst.executeQuery();
        while(rs.next())
        {
        sms=rs.getString("sms");
        jTextArea3.setText(sms);
        txtsenderemail.setText(sender);
        }
        }
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jComboBox5PopupMenuWillBecomeInvisible

    private void bintypePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_bintypePopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        String t="";
        bcode="";
        String type=bintype.getSelectedItem().toString();
        if(type.equalsIgnoreCase("Recyclable"))
        {
        t= "RE";
        bcode=t+newcod.getType(2);
        
        }
        else if(type.equalsIgnoreCase("unrecyclable"))
        {
        t= "UR";
        bcode=t+newcod.getType(2);  
        }
        else if(type.equalsIgnoreCase("biodegradable"))
        {
          t= "BD";
        bcode=t+newcod.getType(2);
        }
        else{
            bcode="";
            JOptionPane.showMessageDialog(this, "PLease select type");
        }
        txtcode.setText(bcode);
    }//GEN-LAST:event_bintypePopupMenuWillBecomeInvisible
 public void UpdateEstate()
 {demail=jTextField24.getText();
     sql="update estate set officer=? where estate_name='"+dest+"'";
  dest= userEstates.getSelectedItem().toString();
  if(dest.isEmpty() && demail.isEmpty())
  {
  JOptionPane.showMessageDialog(this, "Error Updating Estate");
  }
  else{
  try{pst=main_dashboard.prepareStatement(sql);
  pst.setString(1, demail);
  pst.execute();
  JOptionPane.showMessageDialog(this, "Updated successfully");
  }
  catch(Exception e)
  {
  JOptionPane.showMessageDialog(this, e.getMessage());
  }
  }
 
 }
    public void LoadPlacedBins()
 {sql="select bin_code as 'BIN NAME', estate_name as 'ESTATE NAME' , status as STATUS from bin_placement";
 try{
 pst=main_dashboard.prepareStatement(sql);
 rs= pst.executeQuery();
 tableRoutes1.setModel(DbUtils.resultSetToTableModel(rs));
 }
 catch(Exception e)
 {
 JOptionPane.showMessageDialog(this, e.getMessage());
 }
 
 }
    public void UpdateBIn()
  {
  String bname, bstatus;
  bname=combobins.getSelectedItem().toString();
  bstatus="placed";
  sql="Update bin_category set status='"+bstatus+"' where bin_code='"+bname+"'";
  if(bname.isEmpty() &&bstatus.isEmpty())
  {
  JOptionPane.showMessageDialog(this, "Bin placed successfully");
  }
  else{
  try{
      pst=main_dashboard.prepareStatement(sql);
      pst.execute();
  }
  catch(Exception e)
  {
  JOptionPane.showMessageDialog(this, e.getMessage());
  }
  }
  }
    public void UPdateDriver()
   {
     tname=jTextField11.getText().toString().trim();
    tdriver= jTextField12.getText().toString().trim();
   sql="Update driver set status='active',truck_allocated ='"+tname+"' where email='"+tdriver+"'";
   try{pst=main_dashboard.prepareStatement(sql);
   pst.execute();
   JOptionPane.showMessageDialog(null, "Driver Profile Updated" +tdriver);
   
   }
   catch(Exception e)
   {
   JOptionPane.showMessageDialog(this, e.getMessage());
   }
   }
   public void UpdateRoute()
   {
   rname= comboroutes.getSelectedItem().toString();
   rtruck=jTextField11.getText().toString();
   sql= "Update route set status='allocated', truck_added='"+rtruck+"' where route_name='"+rname+"'";
   try{pst=main_dashboard.prepareStatement(sql);
   pst.execute();
   JOptionPane.showMessageDialog(null, "Route updated "+rtruck);
   }
   catch(Exception e)
   {
   JOptionPane.showMessageDialog(null, e.getMessage());
           
   }
       }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MAIN_DASHBOARD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MAIN_DASHBOARD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MAIN_DASHBOARD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MAIN_DASHBOARD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MAIN_DASHBOARD().setVisible(true);
            }
        });
    }
public void LoadAllDrivers()
    {
    sql="select email as EMAIL,firstname as FIRSTNAME, phone_number as 'PHONE NUMBER', "
            + "other_names as 'OTHER NAMES', status as STATUS, truck_allocated as TRUCK from driver";
    try{pst=main_dashboard.prepareStatement(sql);
    rs= pst.executeQuery();
    //display to the table
   tableDrivers.setModel(DbUtils.resultSetToTableModel(rs));
    
    }
    catch(Exception e)
    {JOptionPane.showMessageDialog(null, e.getMessage());}
    }
public void loadDrivers()
{
sql="select email as EMAIL,firstname as FIRSTNAME, phone_number as 'PHONE NUMBER',"
        + " other_names as 'OTHER NAMES', status as STATUS from driver ";
//where truck_allocated='not yet'
    try{pst=main_dashboard.prepareStatement(sql);
    rs= pst.executeQuery();
    //display to the table
   while(rs.next())
   {
   String dname=rs.getString("firstname");
   String dphone=rs.getString("phone number");
   String add= dname +" "+dphone;
   combodirvers.addItem(add);
   }
    }
    catch(Exception e)
    {JOptionPane.showMessageDialog(null, e.getMessage());}
    }

public void LoadRoutes()
{
sql="select route_name as 'ROUTE NAME', description as 'ROUTE DETAILS' from route where status='unallocatted'";
    try{pst=main_dashboard.prepareStatement(sql);
    rs= pst.executeQuery();
    //display to the table
   while(rs.next())
   {
String add= rs.getString("route name");
   comboroutes.addItem(add);
   }
    }
    catch(Exception e)
    {JOptionPane.showMessageDialog(null, e.getMessage());
    }
}
public void LoadAllRoutes(){
sql="select route_name as 'ROUTE NAME', description as 'ROUTE DETAILS', truck_added as TRUCK, dest_est as DESTINATION, status as STATUS from route";
    try{pst=main_dashboard.prepareStatement(sql);
    rs= pst.executeQuery();
    //display to the table
  tableRoutes.setModel(DbUtils.resultSetToTableModel(rs));
    }
    catch(Exception e)
    {JOptionPane.showMessageDialog(null, e.getMessage());
    }
    }
public void loadEstates()
{    dbstatus=adminlabel.getText().toString();
        String n=login.GetEmail(demail).toString();
        if(!dbstatus.equalsIgnoreCase(n))
        {
            main_dashboard=null;
            JOptionPane.showMessageDialog(this, "Access denied");
        }
        else {
    sql="select * from estate";
try{
pst=main_dashboard.prepareStatement(sql);
rs=pst.executeQuery();
tableEstates.setModel(DbUtils.resultSetToTableModel(rs));
}
catch(Exception e)
{
JOptionPane.showMessageDialog(null, e.getMessage()+"Error at estate");
}
        }
}
public void loadWards()
{
      dbstatus=adminlabel.getText().toString();
        String n=login.GetEmail(demail).toString();
        if(!dbstatus.equalsIgnoreCase(n))
        {
            main_dashboard=null;
            JOptionPane.showMessageDialog(this, "Access denied");
        }
        else{
    sql="select ward_name as WARD, description as DETAILS,population as POPULATION, area as 'AREA in KM2', sub_county_name as CONSTITUENCY from ward";
    try{
      pst=main_dashboard.prepareStatement(sql);
rs=pst.executeQuery();
tablewards.setModel(DbUtils.resultSetToTableModel(rs));
    }
    catch(Exception e)
    {
    JOptionPane.showMessageDialog(this, "Error at ward");
    }}
}
public void loadSubs()
{
      dbstatus=adminlabel.getText().toString();
        String n=login.GetEmail(demail).toString();
        if(!dbstatus.equalsIgnoreCase(n))
        {
            main_dashboard=null;
            JOptionPane.showMessageDialog(this, "Access denied");
        }
        else{
    sql="select sub_name as 'CONST NAME', description as DETAILS from subcounty";
try{
    pst=main_dashboard.prepareStatement(sql);
rs=pst.executeQuery();
tablesubcounties.setModel(DbUtils.resultSetToTableModel(rs));
rs.close();
pst.close();
}
catch(Exception e)
{
    JOptionPane.showMessageDialog(this, e.getMessage());
}
        }
}
public void AddSub()
{
        dbstatus=adminlabel.getText().toString();
        String n=login.GetEmail(demail).toString();
        if(!dbstatus.equalsIgnoreCase(n))
        {
            main_dashboard=null;
            JOptionPane.showMessageDialog(this, "Access denied");
        }
        else{
    sql="select * from subcounty";
    try{pst=main_dashboard.prepareStatement(sql);
    rs=pst.executeQuery();
    
    
while(rs.next())
{
    String subname=rs.getString("sub_name");
    combosubs.addItem(subname);
   
    
}}
catch(Exception e)
        {
        JOptionPane.showMessageDialog(this, e.getMessage());
        }}
}
public void EstBinPlacement()
{
  dbstatus=adminlabel.getText().toString();
        String n=login.GetEmail(demail).toString();
        if(!dbstatus.equalsIgnoreCase(n))
        {
            main_dashboard=null;
            JOptionPane.showMessageDialog(this, "Access denied");
        }
        else{
sql="select * from bin_category where status='available'";
try{pst= main_dashboard.prepareStatement(sql);
rs= pst.executeQuery();
while(rs.next())
{
String bincode;
bincode=rs.getString("bin_code");
combobins.addItem(bincode);
}
}
catch(Exception e)
{
JOptionPane.showMessageDialog(this, e.getMessage());
}}
}
public void EstDestBIn()
{
       dbstatus=adminlabel.getText().toString();
        String n=login.GetEmail(demail).toString();
        if(!dbstatus.equalsIgnoreCase(n))
        {
            main_dashboard=null;
            JOptionPane.showMessageDialog(this, "Access denied");
        }
        else{
sql= "select * from estate ";
try{pst=main_dashboard.prepareStatement(sql);
rs= pst.executeQuery();
while(rs.next())
{
    String name, wname, add;
    name=rs.getString("estate_name");
   // wname=rs.getString("ward_name");
   // add=name+" "+wname;
    comboEstatesbin.addItem(name);  
}
}
catch(Exception e)
{
JOptionPane.showMessageDialog(this, e.getMessage());
}
  }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SAVEUSER;
    public static javax.swing.JLabel adminlabel;
    private javax.swing.JComboBox<String> bintype;
    private javax.swing.JButton btnESave;
    private javax.swing.JButton btnEUp;
    private javax.swing.JButton btnEUp1;
    private javax.swing.JButton btnEUp2;
    private javax.swing.JButton btnEUp3;
    private javax.swing.JButton btnEUp4;
    private javax.swing.JButton btnEUp5;
    private javax.swing.JButton btnEUp6;
    private javax.swing.JButton btnRead;
    private javax.swing.JButton btnSent;
    private javax.swing.JComboBox<String> comboEstates;
    private javax.swing.JComboBox<String> comboEstatesbin;
    private javax.swing.JComboBox<String> combobins;
    private javax.swing.JComboBox<String> combodirvers;
    private javax.swing.JComboBox<String> comboroutes;
    private javax.swing.JComboBox<String> combosubs;
    private javax.swing.JComboBox<String> combowards;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    public static javax.swing.JLabel lbgrp;
    private javax.swing.JTable officerplacement;
    private javax.swing.JTable tableDrivers;
    private javax.swing.JTable tableEst;
    private javax.swing.JTable tableEst1;
    private javax.swing.JTable tableEstates;
    private javax.swing.JTable tableRoutes;
    private javax.swing.JTable tableRoutes1;
    private javax.swing.JTable tableSMBox;
    private javax.swing.JTable tableSMSent;
    private javax.swing.JTable tableTrucks;
    private javax.swing.JTable tablesubcounties;
    private javax.swing.JTable tablewards;
    private javax.swing.JTextField txtcode;
    private javax.swing.JTextField txtsenderemail;
    private javax.swing.JComboBox<String> userEstates;
    // End of variables declaration//GEN-END:variables
}
