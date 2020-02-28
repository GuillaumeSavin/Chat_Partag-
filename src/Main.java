import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        DatagramSocket s;
        DatagramPacket p;

        s = new DatagramSocket(port);
        p = new DatagramPacket();

        while (true)
        {
            s.receive(p);
        }
    }
}
