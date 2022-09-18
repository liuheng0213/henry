package basic.knowledge.henry.io;

import java.io.File;

public class FileUtils {
    public static void main(String[] args) {
        FileUtils.createDir();
    }

    public static void createDir(){
        System.out.println("hahaha");
        String dir = "D:" + File.separator + "工作常用工具" + File.separator + "haha" + File.separator;
        File file = new File(dir);
        file.delete();
//        System.out.println(file.exists());
//        boolean mkdir = file.mkdir();
//        System.out.println(mkdir);
//        System.out.println(file.exists());
    }
}
