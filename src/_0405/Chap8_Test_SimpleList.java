package src._0405;
//단순한 linked list에서 insert, delete하는 알고리즘을 코딩: 1단계

import java.util.Scanner;


 class Node {
    int data;
    Node next;

    @Override
    public String toString() {

        if (next == null){
            return "Node{" +
                    "data = " + data +
                    ", next =  null }";
        }
        return "Node{" +
                "data = " + data + '}';
    }

    public Node(int element) {
        this.data = element;
        next = null;
    }

    public Node() {
        data = 0;
        next = null;
    }
}

class LinkedList {
    Node first;

    public LinkedList() { // 빈 생성자
        first = null;
    }

    public int Delete(int element) { //delete the element
        Node p = first;
        Node q = null;
//        Node q = null;
//        q.next = p;

        while(p != null) {
            if(p.data == element) {
            // 일치하는 노드 삭제해야함
                if (p == first) { // 맨 앞 노드 삭제할 경우
                    first = first.next;
                    p.next = null;
                    return 0; 
                }
                p = p.next;
                q.next = p;
                return 0;
            }
            q= p;
            p = p.next;
        }
        return -1;
    }

    public void Show() { // 전체 리스트를 순서대로 출력한다.

            Node p = first;
            Node q = p;
            if(p == null) System.out.println("빈 링크드리스트");
            while (p != null) {
                System.out.println(p);
                p = p.next;
                if(p == null) return;
            }

        
    }

    public void Add(int element) { //임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다
        Node p = first;
        Node q = first;

        Node newNode = new Node(element); // 새로운 노드를 만듦 앞 노드랑 연결해야함

        // 일단 뒤로 붙여보자
        if(first == null) {
            first = newNode;
            return;
        }

        // 맨 앞에 올 경우

        while (p != null) { // 중간 삽입 일반적인 경우

            if(p.equals(first) && p.data > element) { // 맨 앞 삽입 노드
                newNode.next = p;
                first = newNode;
                return;
            }
            if(p.data < element) { // 삽입 값이 p 보다 크면 ? 다음
                if(p.next == null) {
                    p.next =newNode;
                    return;
                }
                q = p;
                p = p.next;

            } else if (p.data == element) {
                System.out.println("같은 값이 있습니다.");
                return;
            } else{ // 삽입 값이 p 보다 작으면?
                q.next = newNode;
                newNode.next = p;
                return;
            }
        }
    }


    public boolean Search(int data) { // 데이터를 찾는다.
        Node p = first;
        while (p.next != null) {

            if (p.data == data) {
                System.out.println("데이터가 있습니다.");
                return true;
            }
            p = p.next;
        }
        return false; // 데이터 없음
    }
}

    public class Chap8_Test_SimpleList {
        enum Menu {
            Add("삽입"),
            Delete("삭제"),
            Show("인쇄"),
            Search("검색"),
            Exit("종료");

            private final String message;                // 표시할 문자열

            static Menu MenuAt(int idx) {                // 순서가 idx번째인 열거를 반환
                for (Menu m : Menu.values())
                    if (m.ordinal() == idx)
                        return m;
                return null;
            }

            Menu(String string) {                        // 생성자(constructor)
                message = string;
            }

            String getMessage() {                        // 표시할 문자열을 반환
                return message;
            }
        }

        //--- 메뉴 선택 ---//
        static Menu SelectMenu() {
            Scanner sc = new Scanner(System.in);
            int key;
            do {
                for (Menu m : Menu.values()) {
                    System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
                    if ((m.ordinal() % 3) == 2 &&
                            m.ordinal() != Menu.Exit.ordinal())
                        System.out.println();
                }
                System.out.print(" : ");
                key = sc.nextInt();
            } while (key < Menu.Add.ordinal() || // ??????
                    key > Menu.Exit.ordinal());
            return Menu.MenuAt(key);
        }


        public static void main(String[] args) {
            Menu menu;                                // 메뉴
            System.out.println("Linked List");
            LinkedList l = new LinkedList();
            Scanner sc = new Scanner(System.in);
            int data = 0;
            System.out.println("inserted");
            l.Show();
            do {
                switch (menu = SelectMenu()) {
                    case Add:                           // 머리노드 삽입
//                        double d = Math.random();
//                        data = (int) (d * 50);
                        System.out.println("데이터 입력");
                        data = sc.nextInt();
                        l.Add(data);
                        break;
                    case Delete:                          // 머리 노드 삭제
                        System.out.println("삭제할 데이터를 입력하세요.");
                    int i = sc.nextInt();
                    int num = l.Delete(i);
                    if( num ==0) {
                        System.out.println("삭제된 데이터는 " + i  +"입니다");
                    } else {
                        System.out.println("삭제할 데이터가 없습니다.");
                    }
                        break;
                    case Show:                           // 꼬리 노드 삭제
                        l.Show();
                        break;
                    case Search:                           // 회원 번호 검색
                     System.out.println("검색할 데이터");
                    int n = sc.nextInt();
                    boolean result = l.Search(n);
                    if (result == false)
                        System.out.println("검색 값 = " + n + "데이터가 없습니다.");
                    else
                        System.out.println("검색 값 = " + n + "데이터가 존재합니다.");
                        break;
                    case Exit:                           // 꼬리 노드 삭제
                        break;
                }
            } while (menu != Menu.Exit);
        }
    }
