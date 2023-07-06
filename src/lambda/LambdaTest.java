package src.lambda;

interface PrintString{
    void showString(String str);
}
public class LambdaTest {
    public static void main(String[] args) {
        // 변수로 만들어서 구현하는 법
        PrintString lambdaPrint = str -> System.out.println(str);
        lambdaPrint.showString("test");

        // 구현된 내용을 매개변수로 넘기고 static 메서드로 실행하는 법
        PrintString lambdaPrint2 = str -> System.out.println(str);
        showMyString(lambdaPrint2);

        // 구현 내용 자체를 반환값으로 넘기는 법
        PrintString lambdaPrint3 = returnPrint();
        lambdaPrint3.showString("Hello");
    }
    public  static void showMyString(PrintString lambda){
        lambda.showString("test2");
    }

    public static PrintString returnPrint(){
        return s -> System.out.println(s + "world");
    }
}
