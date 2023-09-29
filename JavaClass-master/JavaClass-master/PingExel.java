import java.io.FileInputStream;
import java.io.IOException;

public class PingExel {

    public static void main(String[] args) {

        try {
            String filePath = "D:\\Belajar Web\\DEV NET\\New folder\\untitled1\\src\\main\\java\\org\\example\\data.xlsx";
            FileInputStream fileInputStream = new FileInputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

            Sheet sheet = workbook.getSheet("Sheet1");
            Row row = sheet.getRow(0);
            System.out.println(row.getCell(0));

            workbook.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
