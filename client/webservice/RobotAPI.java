
package webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Action;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "RobotAPI", targetNamespace = "http://webservice/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface RobotAPI {


    /**
     * 
     */
    @WebMethod
    @Action(input = "http://webservice/RobotAPI/shutdownRequest", output = "http://webservice/RobotAPI/shutdownResponse")
    public void shutdown();

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://webservice/RobotAPI/wheelRequest", output = "http://webservice/RobotAPI/wheelResponse")
    public void wheel(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://webservice/RobotAPI/moveRequest", output = "http://webservice/RobotAPI/moveResponse")
    public void move(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0,
        @WebParam(name = "arg1", partName = "arg1")
        int arg1);

    /**
     * 
     * @return
     *     returns byte[]
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservice/RobotAPI/screenshotRequest", output = "http://webservice/RobotAPI/screenshotResponse")
    public byte[] screenshot();

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://webservice/RobotAPI/clickRequest", output = "http://webservice/RobotAPI/clickResponse")
    public void click(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://webservice/RobotAPI/unclickRequest", output = "http://webservice/RobotAPI/unclickResponse")
    public void unclick(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://webservice/RobotAPI/keyboardRequest", output = "http://webservice/RobotAPI/keyboardResponse")
    public void keyboard(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0);

}
