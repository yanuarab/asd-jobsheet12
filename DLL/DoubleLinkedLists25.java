package DLL;

public class DoubleLinkedLists25 {
    Node25 head;
    Node25 tail;

    public DoubleLinkedLists25() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(Mahasiswa25 data) {
        Node25 newNode = new Node25(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addLast(Mahasiswa25 data) {
        Node25 newNode = new Node25(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void insertAfter(String keyNim, Mahasiswa25 data) {
        Node25 current = head;

        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node dengan NIM " + keyNim + " tidak ditemukan.");
            return;
        }

        Node25 newNode = new Node25(data);

        if (current == tail) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }

        System.out.println("Node berhasil disisipkan setelah NIM " + keyNim);
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Linked List kosong.");
            return;
        }

        Node25 current = head;
        while (current != null) {
            current.data.tampil();
            current = current.next;
        }
    }

    public Node25 search(String nim) {
        Node25 current = head;
        while (current != null) {
            if (current.data.nim.equals(nim)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void removeFirst() {
    if (isEmpty()) {
        System.out.println("List kosong, tidak bisa dihapus.");
        return;
    }

    Mahasiswa25 tmp = head.data;
    if (head == tail) {
        head = tail = null;
    } else {
        head = head.next;
        head.prev = null;
    }
         System.out.println("Data sudah berhasil dihapus. Data yang terhapus adalah:");
        tmp.tampil();
}

public void removeLast() {
        if (isEmpty()) {
         System.out.println("List kosong, tidak bisa dihapus.");
        return;
     }

    Mahasiswa25 tmp = tail.data;
    if (head == tail) {
        head = tail = null;
    } else {
        tail = tail.prev;
        tail.next = null;
    }
    System.out.println("Data sudah berhasil dihapus. Data yang terhapus adalah:");
    tmp.tampil();
    }

}
