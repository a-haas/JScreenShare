package webservice;

import javax.xml.ws.Endpoint;

public class WSPublisher {
    public static void main(String[] args){
        //listen all ips
        Endpoint.publish("http://0.0.0.0:8080/WS/RobotAPI", new RobotAPIImpl());
    }
}