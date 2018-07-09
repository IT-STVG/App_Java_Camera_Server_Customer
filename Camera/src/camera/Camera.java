/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camera;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javax.swing.table.JTableHeader;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
public class Camera extends javax.swing.JFrame {

    private JFrame mFrame;
    private JPanel pnHome;
    private JPanel pnLeftHome;
    private JPanel pnRightHome;
    private JPanel pnDownHome;
    private JPanel pnPlayback;
    private JPanel pnLeftPlayback;
    private JPanel pnLeftPlaybackTime;
    private JPanel pnLeftPlaybackTable;
    private JPanel pnRightPlayback;
    private JPanel pnRightPlaybackCam;
    private JPanel pnRightPlaybackButton;
    private JPanel pnDownPlayback;
    private JPanel pnSetting;
    private JPanel pnLeftSetting;
    private JPanel pnRightSetting;
    private JPanel pnRightSettingIP;
    private JPanel pnRightSettingDetect;
    private JPanel pnDownSetting;
    private JTabbedPane tabbedPane;
    private JTable tbCam;
    private JTable tbCamPlayBack;
    private JTable tbCamSetting;
    private JTable tbCamDownHome;
    private JTable tbCamDownPlayback;
    private JTable tbCamDownSetting;
    
    private JButton btnPlay;
    private JButton btnPause;
    private JButton btnStop;
    private JButton btnCamera;
    private JButton btnDownload;
    private JButton btnSearch;
    private JButton btnSave;
    
    private JLabel lblIP;
    private JLabel lblUser;
    private JLabel lblPass;
    private JLabel lblStartAt;
    private JLabel lblStopAt;
    private JLabel lblBegin;
    private JLabel lblEnd;
    
    private JTextField txtIP;
    private JTextField txtUser;
    private JTextField txtPass; 
    
    private JDateChooser dchooseBegin;
    private JDateChooser dchooseEnd;
    
    private JSpinner spinBegin;
    private JSpinner spinEnd;
    private JSpinner spinStartAt;
    private JSpinner spinStopAt;
    
    private JCheckBox cbAuto;
    private JCheckBox cbTurnOn;

    public Camera() {
        
        initComponents();
        setDisplay();
        XuLy();
    }
    
    public void XuLy(){
        mFrame=new JFrame();
        mFrame.setTitle("CAMERA");
        mFrame.setLayout(null);
        
        setTabbedPanel();
        mFrame.add(tabbedPane);
        mFrame.setBounds(10,10,800,600);
        mFrame.setResizable(true);
        mFrame.setVisible(true);
    }
    
    public void setTabbedPanel(){
        //set Tabbed Panel
        tabbedPane= new JTabbedPane();
        tabbedPane.setBounds(0, 0, 800, 600);
        pnHome=new JPanel();
        pnHome.setLayout(null);
        
        //setPanel home
        setPanelHome();
        //end set home
        pnPlayback=new JPanel();
        pnPlayback.setLayout(null);
        //setPanel playback
        setPanelPlayBack();
        //endpanel playback
        
        pnSetting=new JPanel();
        pnSetting.setLayout(null);
        setPanelSetting();
        
        tabbedPane.addTab("Home", null,pnHome,"Home");
        tabbedPane.addTab("Playback", null,pnPlayback,"Playback");
        tabbedPane.addTab("Setting", null,pnSetting,"Setting");
    }
    
    public void setPanelSetting(){
        //set Panel Setting
        //set Panel left setting
        pnLeftSetting=new JPanel();
        pnLeftSetting.setBackground(Color.green);
        pnLeftSetting.setBounds(0, 0, 500, 350);
        pnLeftSetting.setLayout(new BorderLayout());
        
        //add table in left setting
        TableValues tv=new TableValues();
        tbCamSetting=new JTable(tv);
        JScrollPane jsp=new JScrollPane(tbCamSetting);
        pnLeftSetting.add(jsp,BorderLayout.CENTER);
        
        
        //set font for column of table camera in playback
        JTableHeader Theader=tbCamSetting.getTableHeader();
        Theader.setBackground(Color.green);
        Theader.setForeground(Color.black);
        Theader.setFont(new Font("Tahome",Font.BOLD ,14));
        tbCamSetting.setFont(new Font("Tahome",Font.BOLD,10));
        
        //set Panel right setting
        pnRightSetting=new JPanel();
        pnRightSetting.setBounds(500, 0, 300, 350);
        pnRightSetting.setLayout(null);
        
        //set Panel right setting for ID
        pnRightSettingIP=new JPanel();
        pnRightSettingIP.setBorder(BorderFactory.createTitledBorder("Setting"));
        pnRightSettingIP.setBounds(0, 0, 300, 150);
        
        
        
        //set component for Panel right setting for IP
        lblIP=new JLabel("IP     :");
        lblUser=new JLabel("User:");
        lblPass=new JLabel("Pass:");
        txtIP=new JTextField(15);
        txtUser=new JTextField(15);
        txtPass=new JPasswordField(15);
        SpringLayout layout=new SpringLayout();
        pnRightSettingIP.setLayout(layout);
        pnRightSettingIP.add(lblIP);
        pnRightSettingIP.add(lblUser);
        pnRightSettingIP.add(lblPass);
        pnRightSettingIP.add(txtIP);
        pnRightSettingIP.add(txtUser);
        pnRightSettingIP.add(txtPass);
        
        //trinh bay lblIP
        layout.putConstraint(SpringLayout.WEST,lblIP,15,SpringLayout.WEST,pnRightSettingIP);
        layout.putConstraint(SpringLayout.NORTH,lblIP,15,SpringLayout.NORTH,pnRightSettingIP);
        
        //trinh bay txtIP
        layout.putConstraint(SpringLayout.WEST,txtIP,15,SpringLayout.EAST,lblIP);
        layout.putConstraint(SpringLayout.NORTH,txtIP,15,SpringLayout.NORTH,pnRightSettingIP);
        
        //trinh bay lblUsername
        layout.putConstraint(SpringLayout.WEST,lblUser,15,SpringLayout.WEST,pnRightSettingIP);
        layout.putConstraint(SpringLayout.NORTH,lblUser,15,SpringLayout.SOUTH,lblIP);
        
        //trinh bay txtUsername
        layout.putConstraint(SpringLayout.WEST,txtUser,15,SpringLayout.EAST,lblUser);
        layout.putConstraint(SpringLayout.NORTH,txtUser,15,SpringLayout.SOUTH,txtIP);
        
        //trinh bay lblPass
        layout.putConstraint(SpringLayout.WEST,lblPass,15,SpringLayout.WEST,pnRightSettingIP);
        layout.putConstraint(SpringLayout.NORTH,lblPass,15,SpringLayout.SOUTH,lblUser);
        
        //trinh bay txtPass
        layout.putConstraint(SpringLayout.WEST,txtPass,15,SpringLayout.EAST,lblPass);
        layout.putConstraint(SpringLayout.NORTH,txtPass,15,SpringLayout.SOUTH,txtUser);
        
        pnRightSetting.add(pnRightSettingIP);
        
        //set Panel right setting for Detect
        pnRightSettingDetect=new JPanel();
        pnRightSettingDetect.setBorder(BorderFactory.createTitledBorder("Setting detected person"));
        pnRightSettingDetect.setBounds(0, 150, 300, 150);
        SpringLayout layout1=new SpringLayout();
        pnRightSettingDetect.setLayout(layout1);
        
        //set spinner Begin
        Date date=new Date();
        SpinnerDateModel sm=new SpinnerDateModel(date,null,null,Calendar.HOUR_OF_DAY);
        spinStartAt=new JSpinner(sm);
        JSpinner.DateEditor deStart=new JSpinner.DateEditor(spinStartAt,"HH:mm:ss");
        spinStartAt.setEditor(deStart);
        
        //set spinner end
        spinStopAt=new JSpinner(sm);
        JSpinner.DateEditor deStop=new JSpinner.DateEditor(spinStopAt,"HH:mm:ss");
        spinStopAt.setEditor(deStop);
        
        btnSearch=new JButton();
        btnSearch.setIcon(new ImageIcon(getClass().getResource("/images/search.png")));
        
        
        //set component for panel right setting for detect
        cbAuto=new JCheckBox("Auto");
        cbTurnOn=new JCheckBox("Turn on now");
        lblStartAt=new JLabel("Start at:");
        lblStopAt= new JLabel("Stop at :");
        pnRightSettingDetect.add(cbAuto);
        pnRightSettingDetect.add(cbTurnOn);
        pnRightSettingDetect.add(lblStartAt);
        pnRightSettingDetect.add(lblStopAt);
        pnRightSettingDetect.add(spinStartAt);
        pnRightSettingDetect.add(spinStopAt);
        
        //trinh bay Auto
        layout1.putConstraint(SpringLayout.WEST,cbAuto,15,SpringLayout.WEST,pnRightSettingDetect);
        layout1.putConstraint(SpringLayout.NORTH,cbAuto,15,SpringLayout.NORTH,pnRightSettingDetect);
        
        //trinh bay Turn on
        layout1.putConstraint(SpringLayout.WEST,cbTurnOn,15,SpringLayout.EAST,cbAuto);
        layout1.putConstraint(SpringLayout.NORTH,cbTurnOn,15,SpringLayout.NORTH,pnRightSettingIP);
        
        //trinh bay lblStartAt
        layout1.putConstraint(SpringLayout.WEST,lblStartAt,15,SpringLayout.WEST,pnRightSettingIP);
        layout1.putConstraint(SpringLayout.NORTH,lblStartAt,15,SpringLayout.SOUTH,cbAuto);
        
        //trinh bay spinStartAt
        layout1.putConstraint(SpringLayout.WEST,spinStartAt,15,SpringLayout.EAST,lblStartAt);
        layout1.putConstraint(SpringLayout.NORTH,spinStartAt,15,SpringLayout.SOUTH,cbTurnOn);
        
        //trinh bay lblStopAt
        layout1.putConstraint(SpringLayout.WEST,lblStopAt,15,SpringLayout.WEST,pnRightSettingIP);
        layout1.putConstraint(SpringLayout.NORTH,lblStopAt,15,SpringLayout.SOUTH,lblStartAt);
        
        //trinh bay spinStopAt
        layout1.putConstraint(SpringLayout.WEST,spinStopAt,15,SpringLayout.EAST,lblStopAt);
        layout1.putConstraint(SpringLayout.NORTH,spinStopAt,15,SpringLayout.SOUTH,spinStartAt);
        
        pnRightSetting.add(pnRightSettingDetect);
        
        
        //set button right setting 
        btnSave=new JButton("SAVE");
        btnSave.setBounds(100,  310, 70, 25);
        pnRightSetting.add(btnSave);
        //set Panel down setting
        pnDownSetting=new JPanel();
        pnDownSetting.setBounds(0, 350, 800, 250);
        pnDownSetting.setLayout(new BorderLayout());
        
        //add table in down setting
        TableWarning tvWar=new TableWarning();
        tbCamDownSetting=new JTable(tvWar);
        JScrollPane jspWar=new JScrollPane(tbCamDownSetting);
        pnDownSetting.add(jspWar,BorderLayout.CENTER);
        
        //set font for column of table camera in playback
        JTableHeader TheaderWar=tbCamDownSetting.getTableHeader();
        TheaderWar.setBackground(Color.green);
        TheaderWar.setForeground(Color.black);
        TheaderWar.setFont(new Font("Tahome",Font.BOLD ,14));
        tbCamDownSetting.setFont(new Font("Tahome",Font.BOLD,10));
        
        pnSetting.add(pnLeftSetting);
        pnSetting.add(pnRightSetting);
        pnSetting.add(pnDownSetting);
    }
    
    public void setPanelPlayBack(){
        // set Panel playback
        //set Panel left playback
        pnLeftPlayback=new JPanel();
        pnLeftPlayback.setBackground(Color.GREEN);
        pnLeftPlayback.setLayout(null);
        pnLeftPlayback.setBounds(0 , 0,300, 350);
        
        //set Panel Left Time
        pnLeftPlaybackTime =new JPanel();
        pnLeftPlaybackTime.setBorder(BorderFactory.createTitledBorder("Time period"));
        pnLeftPlaybackTime.setBounds(0, 0, 300, 130);
        SpringLayout layoutTime=new SpringLayout();
        pnLeftPlaybackTime.setLayout(layoutTime);
        
        //set Jdatepicker for panel left
        lblBegin=new JLabel("Begin:");
        lblEnd=new JLabel("End    :");
        dchooseBegin=new JDateChooser();
        dchooseBegin.setDateFormatString("dd-MM-yyyy");
        
        //set spinner Begin
        Date date=new Date();
        SpinnerDateModel sm=new SpinnerDateModel(date,null,null,Calendar.HOUR_OF_DAY);
        spinBegin=new JSpinner(sm);
        JSpinner.DateEditor deBegin=new JSpinner.DateEditor(spinBegin,"HH:mm:ss");
        spinBegin.setEditor(deBegin);
        
        //set spinner end
        spinEnd=new JSpinner(sm);
        JSpinner.DateEditor deEnd=new JSpinner.DateEditor(spinEnd,"HH:mm:ss");
        spinEnd.setEditor(deEnd);
        
        btnSearch=new JButton();
        btnSearch.setIcon(new ImageIcon(getClass().getResource("/images/search.png")));
        
        dchooseEnd=new JDateChooser();
        dchooseEnd.setDateFormatString("dd-MM-yyyy");
        pnLeftPlaybackTime.add(lblBegin);
        pnLeftPlaybackTime.add(lblEnd);
        pnLeftPlaybackTime.add(dchooseBegin);
        pnLeftPlaybackTime.add(dchooseEnd);
        pnLeftPlaybackTime.add(spinBegin);
        pnLeftPlaybackTime.add(spinEnd);
        pnLeftPlaybackTime.add(btnSearch);
        
        //trinh bay lblBegin
        layoutTime.putConstraint(SpringLayout.WEST,lblBegin,10,SpringLayout.WEST,pnLeftPlaybackTime);
        layoutTime.putConstraint(SpringLayout.NORTH,lblBegin,10,SpringLayout.NORTH,pnLeftPlaybackTime);
       
        
        //trinh bay dchooeserBegin
        layoutTime.putConstraint(SpringLayout.WEST,dchooseBegin,10,SpringLayout.EAST,lblBegin);
        layoutTime.putConstraint(SpringLayout.NORTH,dchooseBegin,10,SpringLayout.NORTH,pnLeftPlaybackTime);
        
        //trinh bay lblEnd
        layoutTime.putConstraint(SpringLayout.WEST,lblEnd,10,SpringLayout.WEST,pnLeftPlaybackTime);
        layoutTime.putConstraint(SpringLayout.NORTH,lblEnd,10,SpringLayout.SOUTH,lblBegin);
        
        //trinh bay dchooseEnd
        layoutTime.putConstraint(SpringLayout.WEST,dchooseEnd,10,SpringLayout.EAST,lblEnd);
        layoutTime.putConstraint(SpringLayout.NORTH,dchooseEnd,10,SpringLayout.SOUTH,dchooseBegin);
        
        //trinh bay spinner begin
        layoutTime.putConstraint(SpringLayout.WEST,spinBegin,10,SpringLayout.EAST,dchooseBegin);
        layoutTime.putConstraint(SpringLayout.NORTH,spinBegin,10,SpringLayout.NORTH,pnLeftPlaybackTime);
        
        //trinh bay spinner end
        layoutTime.putConstraint(SpringLayout.WEST,spinEnd,10,SpringLayout.EAST,dchooseEnd);
        layoutTime.putConstraint(SpringLayout.NORTH,spinEnd,10,SpringLayout.SOUTH,dchooseBegin);
        
        //trinh bay spinner end
        layoutTime.putConstraint(SpringLayout.WEST,btnSearch,10,SpringLayout.EAST,spinEnd);
        layoutTime.putConstraint(SpringLayout.NORTH,btnSearch,10,SpringLayout.NORTH,pnLeftPlaybackTime);

        //pnLeftPlaybackTime.add(datePicker);
        
        //setPanel left table
        pnLeftPlaybackTable=new JPanel();
        pnLeftPlaybackTable.setBounds(0, 130, 300, 220);
        
        //set table in left playback
        pnLeftPlaybackTable.setLayout(new BorderLayout());
        
        TableValues tv= new TableValues();
        tbCamPlayBack=new JTable(tv);
        JScrollPane jsp= new JScrollPane(tbCamPlayBack);
        
        //set font for column of table camera in playback
        JTableHeader Theader=tbCamPlayBack.getTableHeader();
        Theader.setBackground(Color.green);
        Theader.setForeground(Color.black);
        Theader.setFont(new Font("Tahome",Font.BOLD ,14));
        tbCamPlayBack.setFont(new Font("Tahome",Font.BOLD,10));
        
        
        pnLeftPlaybackTable.add(jsp,BorderLayout.CENTER); 
        pnLeftPlayback.add(pnLeftPlaybackTime);
        pnLeftPlayback.add(pnLeftPlaybackTable);
        
        //set Panel right playback
        pnRightPlayback=new JPanel();
        pnRightPlayback.setBounds(300, 0, 500, 350);
        pnRightPlayback.setBackground(Color.pink);
        pnRightPlayback.setLayout(null);
        
        // set Panel Camera
        pnRightPlaybackCam=new JPanel();
        pnRightPlaybackCam.setBackground(Color.black);
        pnRightPlaybackCam.setBounds(0, 0, 500 , 300);
        
        
        //set Panel Button 
        pnRightPlaybackButton=new JPanel();
        pnRightPlaybackButton.setBounds(0, 300, 500, 50);
        pnRightPlaybackButton.setLayout(new FlowLayout());
        
        //set Button for panel button
        btnPlay=new JButton();
        //btnPlay.setBounds(0, 0, 20, 20);
        btnPlay.setIcon(new ImageIcon(getClass().getResource("/images/play.png")));
        
        btnPause=new JButton();
        //btnPause.setBounds(25, 0, 20, 20);
        btnPause.setIcon(new ImageIcon(getClass().getResource("/images/pause.png")));
        
        btnStop=new JButton();
        btnStop.setIcon(new ImageIcon(getClass().getResource("/images/stop.png")));
        
        btnCamera=new JButton();
        btnCamera.setIcon(new ImageIcon(getClass().getResource("/images/camera.png")));
        
        btnDownload=new JButton();
        btnDownload.setIcon(new ImageIcon(getClass().getResource("/images/download.png")));
        
        pnRightPlaybackButton.add(btnPlay,new FlowLayout(FlowLayout.CENTER));
        pnRightPlaybackButton.add(btnPause,new FlowLayout(FlowLayout.CENTER));
        pnRightPlaybackButton.add(btnStop,new FlowLayout(FlowLayout.CENTER));
        pnRightPlaybackButton.add(btnCamera,new FlowLayout(FlowLayout.CENTER));
        pnRightPlaybackButton.add(btnDownload,new FlowLayout(FlowLayout.CENTER));
        
        pnRightPlayback.add(pnRightPlaybackCam);
        pnRightPlayback.add(pnRightPlaybackButton);
        
        //set Panel down playback
        pnDownPlayback=new JPanel();
        pnDownPlayback.setBackground(Color.yellow);
        pnDownPlayback.setBounds(0, 350, 800, 250);
        
        //add table cam for down in playback
       pnDownPlayback.setLayout(new BorderLayout());
       TableWarning tvDown=new TableWarning();
       tbCamDownPlayback=new JTable(tvDown);
       JScrollPane jspDown = new JScrollPane(tbCamDownPlayback);
        pnDownPlayback.add(jspDown, BorderLayout.CENTER);
        
        //set font for column of table camera in down home
        JTableHeader TheaderDown=tbCamDownPlayback.getTableHeader();
        TheaderDown.setBackground(Color.green);
        TheaderDown.setForeground(Color.black);
        TheaderDown.setFont(new Font("Tahome",Font.BOLD ,14));
        tbCamDownPlayback.setFont(new Font("Tahome",Font.BOLD,12));
        
        pnPlayback.add(pnLeftPlayback);
        pnPlayback.add(pnRightPlayback);
        pnPlayback.add(pnDownPlayback);
    }
    
    public void setPanelHome(){
        //set Panel home
        //set Panel left
       pnLeftHome= new JPanel();
       pnLeftHome.setBounds(0, 0, 300, 350);
       
       //add table in left
       pnLeftHome.setLayout(new BorderLayout());
       pnLeftHome.setBorder(BorderFactory.createTitledBorder("Detected"));
       TableValues tv=new TableValues();
       tbCam=new JTable(tv);
       JScrollPane jsp = new JScrollPane(tbCam);
        pnLeftHome.add(jsp, BorderLayout.CENTER);
        
        //set font for column of table camera in home
        JTableHeader Theader=tbCam.getTableHeader();
        Theader.setBackground(Color.green);
        Theader.setForeground(Color.black);
        Theader.setFont(new Font("Tahome",Font.BOLD ,10));
        tbCam.setFont(new Font("Tahome",Font.BOLD,10));
        
        //set Panel right
       pnRightHome=new JPanel();
       pnRightHome.setBackground(Color.black);
       pnRightHome.setBounds(300, 0, 500, 350);
       
       //set Panel Down 
       pnDownHome=new JPanel();
       pnDownHome.setOpaque(true);
       pnDownHome.setBackground(Color.red);
       pnDownHome.setBounds(0, 350, 800, 250);
       
       //add table cam for down in home
       pnDownHome.setLayout(new BorderLayout());
       TableWarning tvDown=new TableWarning();
       tbCamDownHome=new JTable(tvDown);
       JScrollPane jspDown = new JScrollPane(tbCamDownHome);
        pnDownHome.add(jspDown, BorderLayout.CENTER);
        
        //set font for column of table camera in down home
        JTableHeader TheaderDown=tbCamDownHome.getTableHeader();
        TheaderDown.setBackground(Color.green);
        TheaderDown.setForeground(Color.black);
        TheaderDown.setFont(new Font("Tahome",Font.BOLD ,14));
        tbCamDownHome.setFont(new Font("Tahome",Font.BOLD,12));
       
       pnHome.add(pnLeftHome);
       pnHome.add(pnRightHome);
       pnHome.add(pnDownHome);
    }
    
    private void setDisplay() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        


    public static void main(String args[]) {
        Camera cam=new Camera();
    }
    
    

    // Variables declaration - do not modify                     
    // End of variables declaration                   
}
