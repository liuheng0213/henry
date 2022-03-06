package basic.knowledge.stephen.algorithm.test;

public class Test {
//    User a: createDesign(“abc”)
//    returns: XXX-XXX-XXXXX
//
//    User a: createDesign(“def”)
//    returns: YYY-YYY-YYYYY
//
//    User a: getDesign(“XXX-XXX-XXXXX”)
//    Expected return: “abc”
//    Actual return: ???


    public static void main(String[] args) {
        DesignService service = new DesignServiceImpl();
        AuthContext authContext = new AuthContext("1");
        String str1 = service.createDesign(authContext, "abc");
        String str2 = service.createDesign(authContext, "def");

        String design = service.getDesign(authContext, str1);

        System.out.println(design);
    }
}
