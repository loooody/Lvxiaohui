package date1007;

public class MergeList {

    static class Node{
        int val;
        Node next = null;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node MergeList(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        Node tempNode = new Node(-1);
        Node node = tempNode;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                node.next = head1;
                head1 = head1.next;
            }
            else{
                node.next = head2;
                head2 = head2.next;
            }
            node = node.next;
        }

        if (head1 != null) {
            node.next = head1;
        }

        if (head2 != null) {
            node.next = head2;
        }
        return tempNode.next;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node1.next = node3;
        node3.next = node4;
        node4.next = node7;
        node7.next = null;

        node2.next = node5;
        node5.next = node6;
        node6.next = null;

        Node node = node1;
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println();

        node = node2;
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }

        System.out.println();
        Node mergeNode = MergeList(node1, node2);

        while (mergeNode != null) {
            System.out.print(mergeNode.val + "->");
            mergeNode = mergeNode.next;
        }

    }
}
