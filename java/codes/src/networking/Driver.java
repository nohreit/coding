package networking;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Driver {

    public static void main(String [] args) {
        Socket mysocket = new Socket(64500, false);
        InetAddress receiversAddress = null;
        int receiverPortNumber = mysocket.getMyPortNumber();
        String myComputerIP = "10.44.0.22";
        String receiverComputerIP = "192.168.1.147";

        try {
            receiversAddress = InetAddress.getByName(receiverComputerIP); //192.168.1.147
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        mysocket.send("Hello Hello professor, did you get the message?", receiversAddress, receiverPortNumber);


        pln("sending is done but we don't know if the message has been received.");

        DatagramPacket inComingPacket = null;

        do{
            inComingPacket = mysocket.receive();
            byte [] inComingBuffer = inComingPacket.getData();

            String message = new String (inComingBuffer);

            pln("This is the message we have received: "+message);

            mysocket.close();

        }while(true);

    }

    public static void p(Object o) {
        System.out.print(o);
    }

    public static void pln(Object o) {
        System.out.println(o);
    }
}
