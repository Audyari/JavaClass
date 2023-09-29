import java.io.IOException;
import java.net.InetAddress;

public class TestPing {
    private static final int TIMEOUT = 3000; // Timeout dalam milidetik

    public static void main(String[] args) {

        String ipAddress = "172.26.0.3"; // Ganti dengan alamat IP atau nama host yang ingin di-ping

        try {
            InetAddress inetAddress = InetAddress.getByName(ipAddress);

            System.out.println("Pinging " + ipAddress + " [" + inetAddress.getHostAddress() + "]...");

            if (inetAddress.isReachable(TIMEOUT)) {
                System.out.println(" Sukses Ping Ke " + ipAddress);
            } else {
                System.out.println(ipAddress + " is unreachable.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}
