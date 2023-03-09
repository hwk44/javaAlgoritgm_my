package src.lec0302;

import java.util.Comparator;
import java.util.Scanner;

//import Chap8_List.SimpleLinkedList.Menu;

class SimpleObject {

    private String no; // 회원번호
    private String name; // 이름

    public SimpleObject(String no, String name) {
        this.no = no;
        this.name = name;
    }
    // --- 문자열 표현을 반환 ---//
    public String toString() {
        return "(" + no + ") " + name;
    }


    // --- 회원번호로 순서를 매기는 comparator ---//
    public static final Comparator<SimpleObject> NO_ORDER = new NoOrderComparator();

    private static class NoOrderComparator implements Comparator<SimpleObject> {
        public int compare(SimpleObject d1, SimpleObject d2) {
            return (d1.no.compareTo(d2.no) > 0 ) ? 1 : (d1.no.compareTo(d2.no) < 0) ? -1 : 0;
        }
    }

    // --- 이름으로 순서를 매기는 comparator ---//
    public static final Comparator<SimpleObject> NAME_ORDER = new NameOrderComparator();

    private static class NameOrderComparator implements Comparator<SimpleObject> {
        public int compare(SimpleObject d1, SimpleObject d2) {
            return d1.name.compareTo(d2.name);
        }
    }
}
class Node {
    SimpleObject data;
    Node link;
    public Node(SimpleObject element) {
        data = element;
        link = null;
    }
}

class LinkedList {
    Node first;
    public LinkedList() {
        first = null;
    }
    public int Delete(SimpleObject element) //delete the element
    {
        return 0;
    }
    public void Show() { // 전체 리스트를 순서대로 출력한다.

    }
    public void Add(SimpleObject element, Comparator<? super SimpleObject> c ) //임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다
    {
        Node newNode = new Node(element);
        Node p = first, q = null;
        if (first == null){ // 비었으면
            first = newNode;
            return;
        }
        else { // 비어있지 않으면
            while (p != null) {

                if (NameOrderComparator) { // 10에 data / element 에 5

                    newNode.link = p;

                    // 제일 처음 데이터가 들어갈 경우
                    if(q == null) first = newNode;

                    else q.link = newNode;

                    break;
                }else  {
                    q = p;
                    p = p.link;
                }


            }
        }


    }
    public boolean Search(SimpleObject data) { // 전체 리스트를 순서대로 출력한다.
        return true;
    }
}
public class Test8_Test_SimpleObjectList {

    enum Menu {
        Add( "삽입"),
        Delete( "삭제"),
        Show( "인쇄"),
        Search( "검색"),
        Insert("삽입"),
        Exit( "종료");


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
        } while (key < Menu.Insert.ordinal() ||
                key > Menu.Exit.ordinal());
        return Menu.MenuAt(key);
    }

    public static void main(String[] args) {
        Menu menu;                                // 메뉴
        System.out.println("Linked List");
        LinkedList l = new LinkedList();
        Scanner sc = new Scanner(System.in);
        SimpleObject data = null;
        System.out.println("inserted");
        l.Show();
        do {
            switch (menu = SelectMenu()) {
                case Add :                           // 머리노드 삽입

                    // 입력 받는 부분
                    System.out.println("회원번호 : ");
                    String sn = sc.next();
                    System.out.println("회원이름 : ");
                    String sname = sc.next();
                    data = new SimpleObject(sn, sname);

                    l.Add(data, SimpleObject.NO_ORDER);

                    break;
                case Delete :                          // 머리 노드 삭제
                    //SimpleObject num = l.Delete();
                    //System.out.println("삭제된 데이터는 " + num);
                    break;
                case Show :                           // 꼬리 노드 삭제
                    l.Show();
                    break;
                case Search :                           // 회원 번호 검색

                   // boolean result = l.search(n);
                   // if (result == false)
                    //    System.out.println("검색 값 = " + n + "데이터가 없습니다.");
                    //else
                      //  System.out.println("검색 값 = " + n + "데이터가 존재합니다.");
                    break;
                case Exit :                           // 꼬리 노드 삭제
                    break;
            }
        } while (menu != Menu.Exit);
   }
}


