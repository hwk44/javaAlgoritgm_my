package src.generic;

// 타입을 지정하지 않고 객체 생성 시에 원하는대로 바꾸어 사용 가능
public class ResponseDTO<E,K> {
    private String error;
    private E element1;
    private K element2;

    public String getError() {
        return error;
    }

    public E getElement1() {
        return element1;
    }

    public K getElement2() {
        return element2;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "error='" + error + '\'' +
                ", element1=" + element1 +
                ", element2=" + element2 +
                '}';
    }

    public void set(String error, E element1, K element2 ){
        this.error = error;
        this.element1 =  element1;
        this.element2 = element2;
    }

    public static void main(String[] args) {
        ResponseDTO<Integer, String> dto = new ResponseDTO<>();
        // String, Integer, String
        dto.set("error", 404,"you need to check your request" );
        System.out.println("dto error = " + dto.getError());
        System.out.println("dto element1= " + dto.getElement1());
        System.out.println("dto element2 = " + dto.getElement2());
        System.out.println(dto.toString());

        System.out.println();

        // String, String, Integer
        ResponseDTO<String, Integer> dto2 = new ResponseDTO<>();
        dto2.set("", "success",200 );
        System.out.println("dto2 error = " + dto2.getError());
        System.out.println("dto2 element1= " + dto2.getElement1());
        System.out.println("dto2 element2 = " + dto2.getElement2());
        System.out.println(dto2.toString());

    }


}
