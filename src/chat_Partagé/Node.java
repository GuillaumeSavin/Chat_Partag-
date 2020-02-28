package chat_Partagé;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Node
{
    DatagramSocket udp;

    public Node(int port) throws SocketException
    {
        udp = new DatagramSocket(port);

        Thread serverThread = new Thread(() ->
        {
            try
            {
                while (true)
                {
                    byte[] buf = new byte[10000];
                    DatagramPacket p = new DatagramPacket(buf, buf.length);

                    udp.receive(p);

                    System.out.println(p);
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        });

        serverThread.start();
    }



    public void send(String line, String recipient) throws IOException
    {
        byte[] buf = line.getBytes();
        DatagramPacket p = new DatagramPacket(buf, buf.length);
        p.setAddress(InetAddress.getByName(recipient));
        p.setPort(1234);
        udp.send(p);
    }
    public  static void main(String[] args) throws IOException
    {
        Node node = new Node(1234);

        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            String line = scanner.nextLine();
            node.send(line, "134.59.143.110");
            node.send(line, "134.59.143.125");
            node.send(line, "134.59.143.110");
            node.send(line, "169.254.97.98");
        }
    }
}
