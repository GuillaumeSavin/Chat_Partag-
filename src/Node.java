import java.net.Inet4Address;
import java.net.UnknownHostException;

public class Node
{
    private Inet4Address IP;
    private int port;

    public Node() throws UnknownHostException {
        this.getIP();
        this.getPort();
    }
    public Inet4Address getIP() throws UnknownHostException
    {
        return (Inet4Address) IP.getLocalHost();
    }

    public int getPort()
    {
        return port;
    }
}
