package webservice;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;

@WebService(endpointInterface = "webservice.RobotAPI")
public class RobotAPIImpl implements RobotAPI { 

    Robot robot;
    Rectangle screenSize;
    
    public RobotAPIImpl(){
        //create the robot
        try {
            this.robot = new Robot();
        } catch (AWTException ex) {
            Logger.getLogger(RobotAPIImpl.class.getName()).log(Level.SEVERE, null, ex);
        }   
        this.screenSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
    }
    
    @Override
    public Image screenshot() {
        BufferedImage image = null;
        //take the screenshot
        image = this.robot.createScreenCapture(this.screenSize);
        //send it
        return image;
    }

    @Override
    public void move(int x, int y) {
        this.robot.mouseMove(x, y);
    }
    
    @Override
    public void click(int buttons){
        this.robot.mousePress(buttons);
    }
    
    @Override
    public void unclick(int buttons){
        this.robot.mouseRelease(buttons);
    }
    
    @Override
    public void keyboard(int keycode){
        this.robot.keyPress(keycode);
        this.robot.keyRelease(keycode);
    }
    
    @Override
    public void wheel(int mvt){
        this.robot.mouseWheel(mvt);
    }
    
    public void shutdown(){
        System.exit(0);
    }
}
