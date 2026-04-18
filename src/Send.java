/**
 * Project: Lab5
 * Purpose Details: Solo Lab5 Database Assignment
 * Course: IST242
 * Author: zizhou xiang
 * Date Developed: 2026/4/17
 * Last Date Changed: 2026/4/17
 * Rev: 1.0
 */
import java.io.*;
import java.net.*;

public class Send {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 8888);
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter Message: ");
            String msg = br.readLine();
            String key = "secret_key";


            String hmac = HMACTest.getHMAC(key, msg);

            System.out.println("Message Sent: " + msg);
            System.out.println("HMAC Sent: " + hmac);

            out.println(msg + "|" + hmac);

            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}