class Node {
    Integer value;
    Node next;

    Node(Integer value) {
        this.value = value;
        this.next = null;
    }
}

class LinkedList {

    private Node head;

    public void insertAtHead(Integer value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public void LinkedListInsertAfter(Node previous, Node newNode) {
        newNode.next = previous.next;
        previous.next = newNode;
    }

    public Node LinkedListLookUp(int elementNumber) {
        Node current = head;
        int count = 0;

        while (count < elementNumber && current != null) {
            current = current.next;
            count = count + 1;
        }

        return current;
    }

    public void LinkedListDelete(int index) {
        // Caso 1: lista vacía
        if (head == null) {
            return;
        }

        // Caso 2: eliminar el primer nodo
        if (index == 0) {
            Node new_head = head.next;
            head.next = null;
            head = new_head;
            return;
        }

        // Variables auxiliares
        Node current = head;
        Node previous = null;
        int count = 0;

        // Recorremos hasta llegar al índice
        while (count < index && current != null) {
            previous = current;
            current = current.next;
            count = count + 1;
        }

        // Caso 3: si el índice existe en la lista
        if (current != null) {
            previous.next = current.next;
            current.next = null;
        } else {
            System.out.println("Índice inválido");
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + "->");
            current = current.next;
        }
        System.out.print("/");
        System.out.println();
    }
}

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtHead(50);
        list.insertAtHead(40);
        list.insertAtHead(30);
        list.insertAtHead(20);
        list.insertAtHead(10);

        // Lista inicial: 10->20->30->40->50->/
        list.printList();

        // Insertamos un 71 después del nodo 30 (posición 2)
        Node previous = list.LinkedListLookUp(2);
        Node newNode = new Node(71);
        list.LinkedListInsertAfter(previous, newNode);

        // Lista después de insertar: 10->20->30->71->40->50->/
        list.printList();

        // Eliminamos el nodo en índice 3 (el 71)
        list.LinkedListDelete(3);

        // Lista después de eliminar: 10->20->30->40->50->/
        list.printList();
    }
}
















