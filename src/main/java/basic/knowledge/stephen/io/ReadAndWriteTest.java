package basic.knowledge.stephen.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class ReadAndWriteTest {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\工作常用工具\\java_web_test\\stephen\\src\\main\\java\\basic\\knowledge\\stephen\\io\\routes.txt");
        FileInputStream fis = new FileInputStream(file);
        Scanner scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");


        File outFile = new File("D:\\工作常用工具\\java_web_test\\stephen\\src\\main\\java\\basic\\knowledge\\stephen\\io\\Out.txt");
        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outFile));
        while(scanner.hasNextLine()){
            String str = scanner.nextLine();
            outputStream.write(str.getBytes());
            outputStream.write('\n');
        }
        outputStream.close();
        fis.close();


    }
}
