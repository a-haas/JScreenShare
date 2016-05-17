package webservice;

import java.awt.Image;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.soap.MTOM; 

@MTOM
@WebService
@SOAPBinding(style = Style.RPC)
public interface RobotAPI {
    @WebMethod
    public Image screenshot();
    public void move(int x, int y);
    public void click(int buttons);
    public void unclick(int buttons);
    public void keyboard(int keycode);
    public void wheel(int mvt);
    public void shutdown();
}
