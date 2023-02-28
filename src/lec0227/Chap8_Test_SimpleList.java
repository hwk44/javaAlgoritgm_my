package lec0227;

//단순한 linked list에서 insert, delete하는 알고리즘을 코딩: 1단계

// 노드가 다음 노드를 가리킴.
// 노드를 추가해서 정수형 링크드리스트 구현하기

import java.util.Scanner;

class Node {
	int data; // 값
	Node link; // 다음 노드를 가리키는 연결 link

	// 노드 생성자
	public Node(int element) {
		data = element;
		link = null;
	}
}

class LinkedList {

	Node first;

	public LinkedList() {
		first = null;
	}

	public int Delete(int element) // delete the element
	{

		return 0;
	}

	public void Show() { // 전체 리스트를 순서대로 출력한다.

	}

	public void Add(int element) // 임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다
	{
		Node newNode = new Node(element); // element 값을 가지는 노드를 생성
		Node p = first, q = null; // p는 처음 노드를 가리키고 q는 아무것도 없는 노드를 하나 생성
		while (p != null) { // p가 null 이 아닌동안(비어있지 않은 동안)
			if (element > p.data) {
				q = p;
				p = p.link;
				if (p.link == null) { // p의 다음 노드가 없을 때 q 가 p를 가리키도록
					q.link = p;
				}
			} else {
				newNode.link = p;
				q.link = newNode; 
				
				// element가 맨 앞으로 와야할 경우 q가 필요가 없음
				
			}
		}

	}

	public boolean Search(int d) { // 전체 리스트를 순서대로 출력한다.
		// 있으면 true 
		// 없으면 false
		
		Node sc = first;
		while(sc.link != null) { // 다음 노드가 없을 때까지
			if(sc.data == d) return true; // 찾으면 true 반환
			sc = sc.link;
		}
		return false;
	}
}

public class Chap8_Test_SimpleList {
	enum Menu {
		Add("삽입"), Delete("삭제"), Show("인쇄"), Search("검색"), Exit("종료");

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
		Scanner sc = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
				if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.Exit.ordinal())
					System.out.println();
			}
			System.out.print(" : ");
			key = sc.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());
		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu; // 메뉴
		System.out.println("Linked List");
		LinkedList l = new LinkedList();
		Scanner sc = new Scanner(System.in);
		int data = 0;
		System.out.println("inserted");
		l.Show();
		do {
			switch (menu = SelectMenu()) {
			case Add: // 머리노드 삽입
				double d = Math.random();
				data = (int) (d * 50);
				l.Add(data);
				break;
			case Delete: // 머리 노드 삭제
//            	 int num = l.Delete();
//            	 System.out.println("삭제된 데이터는 " + num);
				break;
			case Show: // 꼬리 노드 삭제
				l.Show();
				break;
			case Search: // 회원 번호 검색
				int n = sc.nextInt();
				boolean result = l.Search(n);
				if (result == false)
					System.out.println("검색 값 = " + n + "데이터가 없습니다.");
				else
					System.out.println("검색 값 = " + n + "데이터가 존재합니다.");
				break;
			case Exit: // 꼬리 노드 삭제
				break;
			}
		} while (menu != Menu.Exit);
	}
}
