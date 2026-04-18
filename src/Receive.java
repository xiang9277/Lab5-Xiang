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

public class Receive {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8888);
            System.out.println("Waiting for Client...");

            Socket s = ss.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

            String line = in.readLine();
            String[] parts = line.split("\\|");
            String receivedMsg = parts[0];
            String receivedHmac = parts[1];

            String key = "secret_key";
            String generatedHmac = HMACTest.getHMAC(key, receivedMsg);

            System.out.println("Received Message: " + receivedMsg);
            System.out.println("Received HMAC: " + receivedHmac);
            System.out.println("Generated HMAC: " + generatedHmac);

            if (generatedHmac.equals(receivedHmac)) {
                System.out.println("Integrity Verified: MATCH");
            } else {
                System.out.println("Integrity Failed: NOT MATCH");
            }

            s.close();
            ss.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}