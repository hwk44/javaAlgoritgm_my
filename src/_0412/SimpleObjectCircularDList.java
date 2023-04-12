package src._0412;


import java.util.Scanner;

class SimpleObject implements Comparable<SimpleObject> {

    String sno; // 회원번호
    String sname; // 이름

    public SimpleObject(String sno, String sname) {
        this.sno = sno;
        this.sname = sname;
    }

    // --- 문자열 표현을 반환 ---//
    public String toString() {
        return "(" + sno + ") " + sname;
    }

    @Override
    public int compareTo(SimpleObject o) {
        if (this.sname.equals(o.sname)) {
            return this.sno.compareTo(o.sno);
        }
        return this.sname.compareTo(o.sname);
//		return 0;
    }

    // --- 회원번호로 순서를 매기는 comparator ---//
//	public static final Comparator<SimpleObject> NO_ORDER = new NoOrderComparator();
//
////	private static class NoOrderComparator implements Comparator<SimpleObject> {
//
//	}

    // --- 이름으로 순서를 매기는 comparator ---//
//	public static final Comparator<SimpleObject> NAME_ORDER = new NameOrderComparator();
//
//	private static class NameOrderComparator implements Comparator<SimpleObject> {
//
//		@Override
//		public int compare(SimpleObject o1, SimpleObject o2) {
//			return 0;
//		}
//	}

}

class Node2 {
    SimpleObject data; // 데이터
    Node2 llink; // 좌측포인터(앞쪽 노드에 대한 참조)
    Node2 rlink; // 우측포인터(뒤쪽 노드에 대한 참조)

    // --- 생성자(constructor) ---//
    Node2(SimpleObject so) {
        this.data = so;
        llink = rlink = this;
    }

    Node2() {
        this.data = null;
        llink = rlink = this;
    }

    Node2(String sno, String sname) {
        data = new SimpleObject(sno, sname);
        llink = rlink = this;
    }

    @Override
    public String toString() {
        return data.toString();
    }
    //	public int compareNode(Node2 n2) {
//		SimpleObject so1 = this.data;
//		if (SimpleObject.NO_ORDER.compare(so1, n2.data) < 0) return -1;
//		else if (SimpleObject.NO_ORDER.compare(so1, n2.data) > 0)return 1;
//		else return 0;
//	}
}

class DoubledLinkedList2 {
    private Node2 first; // 머리 포인터(참조하는 곳은 더미노드)

    // --- 생성자(constructor) ---//
    public DoubledLinkedList2() {
        first = new Node2(); // dummy(first) 노드를 생성
    }

    // --- 리스트가 비어있는가? ---//
    public boolean isEmpty() {
        return first.rlink == first;
    }

// --- 노드를 검색 ---//
	public  int search(SimpleObject obj) {
		Node2 ptr = first.rlink; // 현재 스캔 중인 노드
        Node2 q = first.llink;
        if(ptr == ptr.rlink & ptr.data.equals(obj)) {
            return 0;
        }
        while(ptr.rlink != first){
            if(ptr.data.equals(obj)) return 0;
            ptr = ptr.rlink;
            q = q.rlink;
            if(ptr == first) break;
        }
        return  -1;
	}

    // --- 전체 노드 표시 ---//
    public void show() {
        Node2 ptr = first;
        if (ptr.data == null) {
            System.out.println("리스트가 비었습니다");
            return;
        }
        if (ptr == ptr.rlink & ptr == ptr.llink) { // 값 하나만 있을 경우
            System.out.println(ptr.toString());
            return;
        }
        while (ptr.rlink != null) {
            int cnt = 0;
            System.out.println(ptr.toString());
//            System.out.println("cnt : " + cnt);
            ptr = ptr.rlink;
            if (ptr == first) break;
        }
        return;
    }

    // --- 올림차순으로 정렬이 되도록 insert ---//
    public void add(SimpleObject ob) {
        Node2 newNode = new Node2(ob);
        Node2 ptr = first;
		Node2 q = first.llink;

        if (ptr.data == null) { // 처음 값일 때
            first = newNode;

            return;
        }
        if (ptr.llink == ptr && ptr.rlink == ptr) {
            if (ptr.data.sno.equals(ob.sno)) {
                System.out.println("해당 회원번호가 존재합니다.");
                return;
            }
            if (ptr.data.compareTo(ob) < 0) { // 기존 데이턱라 작은 경우
                // 뒤로 와야함
                ptr.rlink = newNode;
                newNode.rlink = ptr;
                ptr.llink = newNode;
                newNode.llink=ptr;
                return;
            }
            if (ptr.data.compareTo(ob) > 0) {// 기존데이터가 더 큰 경우
                // 앞으로 와야함
                first = newNode;
                newNode.rlink = ptr;
                ptr.rlink = first;
                first.llink = ptr;
                ptr.llink = first;
                return;
            }
        }
        while (ptr != null) {
            if (ptr.data.sno.equals(ob.sno)) {
                System.out.println("해당 회원번호가 존재합니다.");
                return;
            }
            // 맨 뒤에 추가될 때
            if (ptr.rlink == first && ptr.data.compareTo(ob) < 0) { // 맨 뒤에 노드이고, ob가 제일 마지막일때
//				first = ptr;
                ptr.rlink = newNode;
                newNode.rlink = first;
                first.llink = newNode;
                newNode.llink = ptr;
                return;
            }
            // 일반적인 경우
            if(q.data.compareTo(ob) < 0 && ptr.data.compareTo(ob) >0){
                q.rlink = newNode;
                newNode.rlink = ptr;
                ptr.llink = newNode;
                newNode.llink = q;
                return;
            }
            // 맨 앞에 추가될 때
			if(ptr == first & ptr.data.compareTo(ob) > 0 ){
                first = newNode;
                q.rlink = first;
                newNode.rlink = ptr;
                ptr.llink = first;
                first.llink = q;
                return;
            }

            q= ptr;
            ptr = ptr.rlink;
            
        }
    }

// --- list에 삭제할 데이터가 있으면 해당 노드를 삭제 ---//
        public void delete (SimpleObject obj){

        }
        public DoubledLinkedList2 merge (DoubledLinkedList2 lst2){
            DoubledLinkedList2 lst3 = new DoubledLinkedList2();
            Node2 ai = this.first.rlink, bi = lst2.first.rlink;
            return lst3;
        }
    }

    public class SimpleObjectCircularDList {
        enum Menu {
            Add("삽입"),
            Delete("삭제"),
            Show("인쇄"),
            Search("검색"),
            Merge("병합"),
            Exit("종료");

            private final String message; // 표시할 문자열

            static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
                for (Menu m : Menu.values())
                    if (m.ordinal() == idx)
                        return m;
                return null;
            }

            Menu(String string) { // 생성자(constructor)
                message = string;
            }

            String getMessage() { // 표시할 문자열을 반환
                return message;
            }
        }

        // --- 메뉴 선택 ---//
        static Menu SelectMenu() {
            Scanner sc1 = new Scanner(System.in);
            int key;
            do {
                for (Menu m : Menu.values()) {
                    System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
                    if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.Exit.ordinal())
                        System.out.println();
                }
                System.out.print(" : ");
                key = sc1.nextInt();
            } while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());
            return Menu.MenuAt(key);
        }

        public static void main(String[] args) {
            Menu menu; // 메뉴
            System.out.println("Linked List");
            DoubledLinkedList2 lst1 = new DoubledLinkedList2();
            String sno1 = null, sname1 = null;
            do {
                switch (menu = SelectMenu()) {
                    case Add: // 머리노드 삽입
                        Scanner sc = new Scanner(System.in);
                        System.out.println(" 회원번호: ");
                        sno1 = sc.next();
                        System.out.println(" 회원이름: ");
                        sname1 = sc.next();
                        SimpleObject so = new SimpleObject(sno1, sname1);
                        lst1.add(so);
//				lst1.add(so, SimpleObject.NO_ORDER);
                        break;
                    case Delete: // 머리 노드 삭제
                        Scanner sc2 = new Scanner(System.in);
                        System.out.println(" 회원번호: ");
                        sno1 = sc2.next();
                        System.out.println(" 회원이름: ");
                        sname1 = sc2.next();
                        SimpleObject so2 = new SimpleObject(sno1, sname1);
				        lst1.delete(so2);

                        break;
                    case Show: // 꼬리 노드 삭제
                        lst1.show();
                        break;
                    case Search: // 회원 번호 검색

                        Scanner sc3 = new Scanner(System.in);
                        String sno3 = sc3.next();
                        String sname3 = sc3.next();
                        SimpleObject so3 = new SimpleObject(sno3, sname3);
				int result = lst1.search(so3);
				if (result == 0) // 있으면 0 없으면 -1
					System.out.println("검색 값 = " + so3 + "데이터가 없습니다.");
				else
					System.out.println("검색 값 = " + so3 + "데이터가 존재합니다.");
				break;

                    case Exit: // 꼬리 노드 삭제
                        break;
                }
            } while (menu != Menu.Exit);
        }
    }
