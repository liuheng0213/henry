package basic.knowledge.henry.netCode.ping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PingWebsite {
    public static void main(String[] args) {



        Runtime runtime =Runtime.getRuntime(); // 获取当前程序的运行进对象
        Process process = null; //声明处理类对象
        String line = null; //返回行信息
        InputStream is = null; //输入流
        InputStreamReader isr = null;// 字节流
        BufferedReader br = null;
        String ip = "www.163.com";
        boolean res = false;// 结果
        try {
            process =runtime.exec("ping " + ip); // PING

            is =process.getInputStream(); // 实例化输入流
            isr = new InputStreamReader(is);// 把输入流转换成字节流
            br = new BufferedReader(isr);// 从字节中读取文本
            while ((line= br.readLine()) != null) {
                if(line.contains("TTL")) {
                    res= true;
                    break;
                }
            }
            is.close();
            isr.close();
            br.close();
            if (res){
                System.out.println("ping通  ...");

            } else{
                System.out.println("ping不通...");
            }
        } catch (IOException e) {
            System.out.println(e);
            runtime.exit(1);
        }
    }
}
