package miscCodingQuestions;
import linkedLists.LinkedList;
import linkedLists.Node;
public class FindSubListPosition {

static int find(Node list, Node sublist) {
    String listString = asString(list);
    String sublistString = asString(sublist);
        return listString.indexOf(sublistString);
    }

    static String asString(Node l){
        String s ="";
        while (l !=null){
            s+= l.getData();
            l = l.getNext();
        }
        return s;
    }
	public static void main(String[] args) {
	Node l1 = new Node(1);
	Node n2l1 = new Node(2);
	Node n311 = new Node(3);
	l1.setNext(n2l1);
	n2l1.setNext(n311);
	
	Node l2 = new Node(4);
	Node n2l2 = new Node(5);
	l2.setNext(n2l2);	
	
	System.out.println(find(l1,l2));
	}

}
