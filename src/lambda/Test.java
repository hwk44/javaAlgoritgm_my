package src.lambda;

public class Test {

    /*
    FunctionalInterface 는 하나의 메서드만 가져야 한다.

    일반적으로 객체를 구현하는 방식은 여러개 인터페이스를 implements  하거나
    여러 메서드를 사용할 수 있다.

    * */
    public static void main(String[] args) {

        Mynumber max = (x,y) -> (x >= y) ? x: y;
        System.out.println(max.getMax(10,20));

        // 구현 객체를 생성하는 법
        StringConcat stringConcat = new StringConcatImpl();
        stringConcat.makeString("hello", "java");

        // 인터페이스에서 람다식으로 표현하는 법
        StringConcat concat = (s1, s2) -> System.out.println(s1+ " " + s2);
        concat.makeString("hello", "java");

        // 익명 내부 클래스로 사용하는 법
        // 람다식을 사용하면 이게 내부적으로 실행되는 거랑 같음
        StringConcat concat2 = new StringConcat() {
            @Override
            public void makeString(String s1, String s2) {
                System.out.println(s1 + " " + s2);
            }
        };
        concat2.makeString("hello", "java");
    }
}
