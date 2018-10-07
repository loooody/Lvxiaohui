package date1007;

public class ReverseList {
    static class Node{
        int val;
        Node next = null;

        Node(int val) {
            this.val = val;
        }
    }

    private static Node head = null;

    private static Node last = null;

    public static void addNode(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
        }
        else{
            last.next = node;
        }
        last = node;
    }


    public static void display(Node pHead) throws Exception {
        if (head == null) {
            throw new Exception("empty");
        }

        Node temp =pHead;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node reverseList(Node pHead) {
        Node pReverseHead = null;
        Node pNode = head;
        Node pPre = null;
        while (pNode != null) {
            Node pNext = pNode.next;
            if (pNext == null) {
                pReverseHead = pNode;
            }
            pNode.next = pPre;
            pPre = pNode;
            pNode = pNext;
        }
        return pReverseHead;
    }


    public static void main(String[] args) throws Exception {
        addNode(1);
        addNode(2);
        addNode(3);
        addNode(8);
        display(head);
        Node temp = reverseList(head);
        display(temp);
    }
}
