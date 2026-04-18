/**
 * Project: Lab5
 * Purpose Details: Solo Lab5 Database Assignment
 * Course: IST242
 * Author: zizhou xiang
 * Date Developed: 2026/4/17
 * Last Date Changed: 2026/4/17
 * Rev: 1.0
 */
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class HMACTest {
    public static String getHMAC(String key, String message) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "HmacSHA256");
        mac.init(keySpec);

        byte[] rawHmac = mac.doFinal(message.getBytes());
        return Base64.getEncoder().encodeToString(rawHmac);
    }
}