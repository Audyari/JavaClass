package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;

public class TestPingExel {

    public static void main(String[] args) {

        String filePath = "D:\\Belajar Web\\DEV NET\\Java Class\\data.xlsx";

        Workbook workbook;
        Sheet sheet;

        try {
            FileInputStream fis = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet("Ping Results");

            // Menghitung jumlah baris dalam sheet
            int rowCount = sheet.getLastRowNum();

            // Melakukan tes ping untuk setiap host
            for (int i = 1; i <= rowCount; i++) {
                Row row = sheet.getRow(i);
                String host = row.getCell(0).getStringCellValue();

                try {
                    InetAddress[] inetAddresses = InetAddress.getAllByName(host);

                    StringBuilder ipAddresses = new StringBuilder();
                    for (InetAddress inetAddress : inetAddresses) {
                        ipAddresses.append(inetAddress.getHostAddress()).append(", ");
                    }

                    if (ipAddresses.length() > 0) {
                        ipAddresses.setLength(ipAddresses.length() - 2);
                    }

                    row.createCell(1).setCellValue(ipAddresses.toString());

                    boolean isReachable = inetAddresses[0].isReachable(5000); // Timeout 5 detik
                    row.createCell(2).setCellValue(isReachable ? "Reachable" : "Unreachable");
                } catch (IOException e) {
                    row.createCell(1).setCellValue("N/A");
                    row.createCell(2).setCellValue("Error");
                }
            }

            fis.close();

            // Menyimpan hasil ke dalam file Excel
            FileOutputStream fos = new FileOutputStream(filePath);
            workbook.write(fos);
            workbook.close();
            fos.close();

            System.out.println("Ping results saved to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}