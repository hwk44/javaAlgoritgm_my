package src._0405_SimpleObjectList;

import java.util.Comparator;
import java.util.Scanner;


class SimpleObject {
    public SimpleObject(String no, String name) {
        this.no = no;
        this.name = name;
    }

    static final int NO = 1; // 번호를 읽어 들일까요?
    static final int NAME = 2; // 이름을 읽어 들일까요?

    private String no; // 회원번호
    private String name; // 이름

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // --- 문자열 표현을 반환 ---//
    public String toString() {
        return "{" + no + " : " + name + "}";
    }

    //	@Override
    public int compareTo(SimpleObject o) {
        if (this.no.compareTo(o.no) < 0) { // 번호가 작으면
//			if(this.name.compareTo(o.name) < 0) //
            return -1;
        } else if (this.no.compareTo(o.no) > 0) { // 번호가 크면?
//			if(this.name.compareTo(o.name) < 0) { // 이름이 작은걸 먼저
//				return -1;
//			}else return 1;
            return 1;
        } else { // 번호가 같은 경우
            if (this.name.compareTo(o.name) < 0) { // 이름이 작으면
                return -1;
            } else return 1;
        }

    }

}

class Node {
    SimpleObject sb;
    Node link;

    public Node(SimpleObject sb) {
        this.sb = sb;
        link = null;
    }
}

class LinkedList {
    Node first;

    LinkedList() {
        first = null;
    }

    public int Delete(SimpleObject element) {//delete the element
        Node p = first;
        Node q = null;

        while (p != null) {
            if (p.sb.getNo().equals(element.getNo()) && p.sb.getName().equals(element.getName())) { //
                p = p.link;
                q.link = p;
                return 0;
            }
            q = p;
            p = p.link;
        }
        return -1;
    }

    public void Show() { // 전체 리스트를 순서대로 출력한다.

        Node p = first;
        Node q = null;
        if (p == null) {
            System.out.println("빈 링크드 리스트");
            return;
        }
        while (p != null) {
            System.out.println(p.sb.toString());
            q = p;
            p = p.link;
        }
    }

    public void Add(SimpleObject sb) {//임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다
        Node newnode = new Node(sb);
        Node p = first;
        Node q = null;
        if (first == null) {
            first = newnode; // 맨 처음 값
            return;
        }
        while (p != null) { // 처음 값이 있을 경우


            if (p.sb.compareTo(sb) > 0) {
                if(p == first){
                    newnode.link = p;
                    first = newnode;
                    return;
                }
                q.link = newnode;
                newnode.link = p;
                return;
            } else if (p.sb.compareTo(sb) == 0) {
                System.out.println("번호가 중복됩니다.");
                return;
            } else {
                if (p.link == null) {
                    p.link = newnode;
                    return;
                }
            }
            q = p;
            p = p.link;
        }
    }

    public boolean Search(SimpleObject data) { // 하나를 찾아서 true 리턴
        Node p = first;
        if (p == null) {
            System.out.println("리스트가 비었습니다.");
            return false;
        } else {
            while (p != null) {
                if (p.sb.getNo() == data.getNo()) {
//					System.out.println(p.sb.toString());
                    return true;
                }
                p = p.link;
            }
        }
        return false;
    }
}

public class Test8_Test_SimpleObjectList {

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
        } while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());
        return Menu.MenuAt(key);
    }

    public static void main(String[] args) {
        Menu menu;                                // 메뉴
        System.out.println("Linked List");
        LinkedList l = new LinkedList();
        Scanner sc = new Scanner(System.in);
//		SimpleObject data = new SimpleObject();
        System.out.println("inserted");
        l.Show();
        do {
            switch (menu = SelectMenu()) {
                case Add:                           // 머리노드 삽입

                    System.out.print("번호 : ");
                    String n = sc.next();
                    System.out.print("이름 : ");
                    String name = sc.next();
                    l.Add(new SimpleObject(n, name));
//	    	         l.Add(data);
                    break;
                case Delete:                          // 머리 노드 삭제
                    System.out.println("삭제할 데이터");
                    n = sc.next();
                    name = sc.next();
                    SimpleObject sb = new SimpleObject(n,name);
	            	 int num = l.Delete(sb);
                     if(num == 0) System.out.println("삭제된 데이터 " + sb.toString());
                     else System.out.println("삭제된 데이터가 없습니다.");
                    break;
                case Show:                           // 꼬리 노드 삭제
                    l.Show();
                    break;
                case Search:                           // 회원 번호 검색

//	                boolean result = l.search(n);
//	                    if (result == false)
//	                        System.out.println("검색 값 = " + n + "데이터가 없습니다.");
//	                    else
//	                        System.out.println("검색 값 = " + n + "데이터가 존재합니다.");
                    break;
                case Exit:                           // 꼬리 노드 삭제
                    break;
            }
        } while (menu != Menu.Exit);
    }
}


