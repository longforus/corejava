package v2ch04.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * This program makes a socket connection to the atomic clock in Boulder, Colorado, and prints
 * the time that the server sends.
 *
 * @author Cay Horstmann
 * @version 1.21 2016-04-27
 */
public class SocketTest {
    public static void main(String[] args) throws IOException {
        //try (Socket s = new Socket("192.168.2.39", 8189)) {
        try (SocketChannel channel = SocketChannel.open(new InetSocketAddress("192.168.2.39", 8189))) {
            //s.connect(new InetSocketAddress("192.168.2.39", 8908), 10000);

            //InputStream is = s.getInputStream();
            PrintWriter pw = new PrintWriter(Channels.newOutputStream(channel), true);
            pw.println("start:");
            new Thread(() -> {
                boolean over = false;
                Scanner sin = new Scanner(System.in);
                while (!over && sin.hasNext()) {
                    String line = sin.next();
                    pw.println(line);
                    if (line.equals("BYE")) {
                        over = true;
                        pw.close();
                        sin.close();
                        System.out.println("sin close");
                    } else if (line.equals("SDO")) {
                        try {
                            channel.shutdownOutput();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
            Scanner in = new Scanner(channel, "UTF-8");
            boolean over1 = false;
            while (!over1 && in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
                if (line.equals("BYE")) {
                    over1 = true;
                    System.out.println("in close");
                }
            }
        }
        //ServerSocket serverSocket = new ServerSocket(8198);
        //Socket socket = serverSocket.accept();
        //InputStream inputStream = socket.getInputStream();
        //Scanner scanner = new Scanner(inputStream, "UTF-8");
        //while (scanner.hasNextLine()) {
        //    System.out.println(scanner.nextLine());
        //}
        //PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
        //printWriter.println("hello world!");
        //scanner.close();
        //printWriter.close();
    }
}
