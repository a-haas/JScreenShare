package client;

import java.awt.Color;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.Timer;
import webservice.RobotAPI;
import webservice.RobotAPIImplService;

public class ClientFrame extends JFrame {
    
    ImagePanel serverScreen;
    
    public ClientFrame(String title, int width, int height){
        super();
        
        //set gui
        super.setTitle(title);
        super.setSize(width, height);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.serverScreen = new ImagePanel();
        super.setContentPane(serverScreen);
        super.setVisible(true);
        
        //catch when the frame is exited
//        addWindowListener(new java.awt.event.WindowAdapter() {
//            public void windowClosing(WindowEvent winEvt) {
//                serverScreen.disconnectGUI();
//                System.exit(0);
//            }
//        });
        
        serverScreen.connectGUI();
    }
    
    
}
