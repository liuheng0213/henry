package basic.knowledge.henry.enumTest;

import java.util.EnumSet;

public class EnumDemo {
    public static void main(String[] args) {
        //调用枚举中自定义方法
        Color.containval();


        System.out.println(EasyEnum.HAHA);
        System.out.println(EasyEnum.HAHA.name());
        System.out.println(EasyEnum.HAHA.toString());

        EnumSet<EasyEnum> easyEnums = EnumSet.allOf(EasyEnum.class);


        System.out.println(easyEnums.contains(EasyEnum.valueOf("FF")));
    }
}
