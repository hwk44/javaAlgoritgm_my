package programers.LV1;

public class _3진법뒤집기 {
    /*자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후,
    이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
    입출력 예
    n	result
    45	7
    125	229*/
    public static int solution(int n) {
        int answer = 0;

        // 받은 숫자를 3진법 (문자열) 으로 만들고 바로 뒤집기 (문자열)
        // n =" 10 이면 sb = "101
        // n = 45 이면 sb = "0021"
        StringBuilder sb = new StringBuilder();
        while(n >= 1) {
            int b = n % 3; // 나머지 저장 ????/
            n /= 3; // 몫 저장

            sb.append(b);
            if(n == 1) {
                sb.append(n);
                break;
            }
        }
        
        // 원래대로 돌려놔야함 앞에 0을 다 없애야함
        while( sb.charAt(0) == '0'){
                sb.replace(0,  1, ""); // sb 의 인덱스도 바뀜 for문 쓸 필요가 없음
            }

        // 다시 3진수를 10진수로
        int a = 0;
        int degree = 0; // 차수
        for (int i = sb.length() -1 ; i >= 0 ; i--) {
             a += (int)Character.getNumericValue(sb.charAt(i)) * (Math.pow(3,degree++));
        }


        return a;
    }
    public static int solution2(int n) {
        String a = ""; // 빈 문자열을 만듦

        while(n > 0){
            a = (n % 3) + a; // a 에 n의 나머지 값을 더함
            n /= 3; // n 은 몫을 저장
        }
        a = new StringBuilder(a).reverse().toString(); // 뒤집고 to String 해버리면 앞의 0은 사라짐

        return Integer.parseInt(a,3); // 3진수를 10진수로
    }

    public static void main(String[] args) {
        String a = "1010";
        int b = Integer.parseInt(a,2); // 2진수를 10진수로
        System.out.println(b);


//        System.out.println(solution(10));
//        System.out.println(solution(45));
//        System.out.println(solution(3));
//        System.out.println(solution(2));
//        System.out.println(solution(1));

//        System.out.println(10%3);
    }

}
