package programers.LV0;

/*정수가 들어 있는 배열 num_list 가 매개변수로 주어집니다.
num_list 의 원소의 순서를 거꾸로 뒤집은 배열을
return 하도록 solution 함수를 완성해주세요.*/
public class reverseArray {
    public static int[] solution(int[] num_list){
        int[] answer = new int[num_list.length];
        for (int i = num_list.length-1; i >= 0; i--) {
            answer[num_list.length-1 -i] = num_list[i];
        }
        return answer;
    }
}
