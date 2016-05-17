package client;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import static java.awt.event.MouseEvent.BUTTON2;
import static java.awt.event.MouseEvent.BUTTON3;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import webservice.RobotAPI;
import webservice.RobotAPIImplService;

public class ImagePanel extends JPanel 
    implements MouseListener, MouseMotionListener, KeyListener, MouseWheelListener {
    BufferedImage image;
    RobotAPIImplService service;
    RobotAPI robot;
    
    public ImagePanel(){
        this.startListener();
        super.setFocusable(true);
        super.requestFocusInWindow();
    }
    
    public void connectGUI(){
        //set robot
        this.service = new RobotAPIImplService();
        this.robot = service.getRobotAPIImplPort();
        this.updateServerScreen();
    }
    public void disconnectGUI(){
        this.robot.shutdown();
    }
    
    public void startListener(){
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
        this.addMouseWheelListener(this);
    }
    
    public void updateServerScreen(){
        byte[] data = this.robot.screenshot();
        InputStream in = new ByteArrayInputStream(data);
        BufferedImage screen = null;
        try {
            screen = ImageIO.read(in);
        } catch (IOException ex) {
            Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setImagePanel(screen);
        //update forever
        this.updateServerScreen();
    }
    
    public void setImagePanel(BufferedImage pic){
        this.image = pic;
        super.repaint();
    }
    
    protected int selectMouseButton(int mb){
        int res;
        if(mb == BUTTON2)
            res = InputEvent.BUTTON2_DOWN_MASK;
        else if(mb == BUTTON3)
            res = InputEvent.BUTTON3_DOWN_MASK;
        else
            res = InputEvent.BUTTON1_DOWN_MASK;
        return res;
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(this.image != null)
            g.drawImage(this.image, 0, 0, null); 
    }
    
    //MOUSE LISTENER 
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
        int b = this.selectMouseButton(e.getButton());   
        this.robot.click(b);
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        int b = this.selectMouseButton(e.getButton());   
        this.robot.unclick(b);
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }

    //MOUSE MOTION LISTENER
    @Override
    public void mouseDragged(MouseEvent e) {
        Point pos = e.getPoint();
        this.robot.move(pos.x, pos.y); 
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        Point pos = e.getPoint();
        this.robot.move(pos.x, pos.y); 
    }
    
    //KEYBOARD LISTENER
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        //the only one to be used
        this.robot.keyboard(e.getKeyCode());
    }
    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    //WHEEL LISTENER
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        this.robot.wheel(e.getWheelRotation());
    }
}
