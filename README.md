# javaAlgoritgm_my
> doubleLinkedList<br>
> 4_5 int형 링크드리스트 구현(완성)<br>
> 4_6 SimpleObjectList 완성
## 프로그래머스

### Lv1. 이상한 문자열
    + String s = "return";
      char[] a = s.toCharArray(); // char 어레이를 만들고 s의 각 ch 를 받아옴
### Lv1. 푸드파이트대회 
    + reverse() 함수 일반 String 으로 안됨
### Lv1. 가장가까운같은글자
    + Map 으로 char을 키로 두고 밸류에 인덱스 값을 넣음
    + 인트 스트림
    + Array -> int[] 할때 primitive 타입이라 스트림을 써야함
      + 참고 : https://velog.io/@deannn/Java-int%ED%98%95-ArrayList-%EB%B0%B0%EC%97%B4-%EB%B3%80%ED%99%98
## 못 푼 문제들
### Lv1.문자열내마음대로정렬하기 - 4/7 완료
```java
public class 크기가작은부분문자열 {
     public static void main(String[] args) {
         
        String[] stirngs = {"abce", "abcd", "cdx"};
        int n = 1; // 정렬할 인덱스
        
        List<String> list1 = new ArrayList<>(); // ArrayList 로 받음
        for (String s : strings) {
            list1.add(s);
        }
        
        Collections.sort(list1, new Comparator<String>() {
          @Override
          public int compare(String o1, String o2) {
               if (o1.charAt(n) < o2.charAt(n)) return -1;
               else if (o1.charAt(n) > o2.charAt(n)) return 1;
               else return o1.compareTo(o2); // 인덱스 값이 같으면 사전 순으로
          }
        });
     }
}
```
### Lv1. 콜라문제
     + 재귀로 풀어야할듯
### Lv1.비밀지도
     + 감이 안옴

> int형 링크드리스트 구현(완성)<br>
>  SimpleObjectList 완성
 - simpleObject -> comparator --> LV1.실패율에서 연습


## 프로그래머스
### Lv1. 이상한 문자열
     String s = "return";
     char[] a = s.toCharArray(); // char 배열 만들고 s의 각 ch 를 받아옴
### Lv1. 푸드파이트대회 
     reverse() 함수 일반 String 으로 안됨 StringBuffer
### Lv1. 가장가까운같은글자
     Map 으로 char을 키로 두고 밸류에 인덱스 값을 넣음
### Integer Stream
     Array -> int[] 할때 primitive 타입이라 스트림을 써야함
      참고 : https://velog.io/@deannn/Java-int%ED%98%95-ArrayList-%EB%B0%B0%EC%97%B4-%EB%B3%80%ED%99%98
### LV1.명예의전당
    - for 문에서 특정 인덱스에서만 수행될 코드에는 continue; 넣어줘야함
```java

class test {
    public static void main(String[] args) {
        int[] score = {10, 100, 20, 150, 1, 100, 200};

        class 명예의전당 {
            public static void main(String[] args) {
                int[] score = {10, 100, 20, 150, 1, 100, 200};

                List answer = new ArrayList<>();
                List<Integer> list = new ArrayList();

                list.add(score[0]);
                answer.add(score[0]);

                for (
                        int i = 1;
                        i < score.length; i++) {

                    List answer = new ArrayList<>();
                    List<Integer> list = new ArrayList();

                    int k = 3;
                    list.add(score[0]);
                    answer.add(score[0]);

                    for (int i = 1; i < score.length; i++) {
                        if (list.size() < k) { // k < 3 일때 동안에는 그냥 add
                            list.add(score[i]);
                            Collections.sort(list);
                            answer.add(list.get(0));
                            continue;
                        }
                        if (list.size() == k && list.get(0) < score[i]) {
                            list.add(score[i]);
                            Collections.sort(list);
                            list.remove(list.get(0));
                        }
                    }
                }
            }
        }
    }
}
```

