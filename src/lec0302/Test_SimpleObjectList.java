package src.lec0302;

import java.util.Comparator;
import java.util.Scanner;

class SimpleObject implements Comparable<SimpleObject> {
    static final int NO = 1; // 번호를 읽어 들일까요?
    static final int NAME = 2; // 이름을 읽어 들일까요?

    private String no; // 회원번호
    private String name; // 이름

    // --- 문자열 표현을 반환 ---//
    public String toString() {
        return "(" + no + ") " + name;
    }

    // --- 데이터를 읽어 들임 ---//
    public void scanData(String guide, int sw) {
        System.out.println(guide + "할 데이터를 입력하세요."+ sw);

        Scanner stdIn = new Scanner(System.in);
        if ((sw & NO) == NO) { //& 는 bit 연산자임
            System.out.print("번호: ");
            no = stdIn.next();
        }
        if ((sw & NAME) == NAME) {
            System.out.print("이름: ");
            name = stdIn.next();
        }
    }

    // --- 회원번호로 순서를 매기는 comparator ---//
    public static final Comparator<SimpleObject> NO_ORDER = new NoOrderComparator();

    private static class NoOrderComparator implements Comparator<SimpleObject> {
        public int compare(SimpleObject d1, SimpleObject d2) {
            return (d1.no.compareTo(d2.no)>0) ? 1 : (d1.no.compareTo(d2.no)<0) ? -1 : 0;
        }
    }

    // --- 이름으로 순서를 매기는 comparator ---//
    public static final Comparator<SimpleObject> NAME_ORDER = new NameOrderComparator();

    private static class NameOrderComparator implements Comparator<SimpleObject> {
        public int compare(SimpleObject d1, SimpleObject d2) {
            return d1.name.compareTo(d2.name);
        }
    }

    SimpleObject(String a, String b) {
        this.no = a;
        this.name = b;
    }

    public int compareTo(SimpleObject element) {
        if(this.no.compareTo(element.no) > 0) {
            return 1;
        }

        else if(this.no.compareTo(element.no) == 0) {
            return 0;
        }

        else {
            return -1;
        }
    }
}

class Node1 {
    SimpleObject data;
    Node1 link;

    public Node1(SimpleObject element) {
        link = null;
        data = element;
    }
}

class LinkedList1 {
    Node1 first;

    public LinkedList1() {
        first = null;
    }

    public boolean Delete(SimpleObject element) //delete the element
    {
        Node1 p = first, q = null;
        while (p!=null) {
            if (p.data.compareTo(element)==0) {
                if (q==null) {
                    first = p.link;
                } else {
                    q.link = p.link;
                } return true;
            }
            else {
                q = p;
                p = p.link;
                if (p==null && q.data.compareTo(element)==0) {
                    q.link = null;
                    return true;
                }
            }
        }
        return false;
    }

    public void Show() { // 전체 리스트를 순서대로 출력한다.
        Node1 p = first;
        while (p!=null) {
            System.out.println(p.data.toString());
            p = p.link;
        }
    }

    public void Add(SimpleObject element) //임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다
    {
        Node1 newNode = new Node1(element);
        Node1 p = first, q = null;
        if(p==null) {
            first = newNode;
            return;
        }
        while (p!=null) {
            if (p.data.compareTo(element)>0) {
                newNode.link = p;
                if (q == null) first = newNode;
                else q.link = newNode;
                break;
            } else {
                q = p;
                p = p.link;
                if (p==null) {
                    q.link = newNode;
                    break;
                }
            }
        }
    }

    public boolean Search(SimpleObject data) { // 전체 리스트를 순서대로 출력한다.
        Node1 p = first, q = null;
        while (p!=null) {
            if (p.data.compareTo(data)==0) {
                return true;
            }
            p = p.link;
        }
        return false;
    }
}

public class Test_SimpleObjectList {

    enum Menu {
        Add( "삽입"),
        Delete( "삭제"),
        Show( "인쇄"),
        Search( "검색"),
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
        } while (key < Menu.Add.ordinal() ||
                key > Menu.Exit.ordinal());
        return Menu.MenuAt(key);
    }

    public static void main(String[] args) {
        Menu menu;                                // 메뉴
        System.out.println("Linked List");
        LinkedList1 l = new LinkedList1();
        Scanner sc = new Scanner(System.in);
        SimpleObject data = null;
        System.out.println("inserted");
        l.Show();
        do {
            switch (menu = SelectMenu()) {
                case Add :                           // 머리노드 삽입
                    data = new SimpleObject(sc.next(), sc.next());
                    System.out.println("입력, 111을 적으시오.");
                    data.scanData(sc.next(), sc.nextInt());
                    l.Add(data);
                    break;
                case Delete :                          // 머리 노드 삭제
                    String num1 = sc.next();
                    String num2 = sc.next();
                    SimpleObject s = new SimpleObject(num1, num2);
                    l.Delete(s);
                    System.out.println("삭제된 데이터는 " + num1 + num2 );
                    break;
                case Show :                           // 꼬리 노드 삭제
                    l.Show();
                    break;
                case Search :                           // 회원 번호 검색
                    String n1 = sc.next();
                    String n2 = sc.next();
                    SimpleObject s1 = new SimpleObject(n1, n2);
                    boolean result = l.Search(s1);
                    if (result == false)
                        System.out.println("검색 값 = " + n1 + n2 + "데이터가 없습니다.");
                    else
                        System.out.println("검색 값 = " + n1 + n2 + "데이터가 존재합니다.");
                    break;
                case Exit :                           // 꼬리 노드 삭제
                    break;
            }
        } while (menu != Menu.Exit);
    }
}