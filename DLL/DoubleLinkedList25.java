package DLL;

public class DoubleLinkedList25 {
    Node25 head;
    Node25 tail;

    public DoubleLinkedList25(){
        head = null;
        tail = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void addFirst(Mahasiswa25 data){
        Node25 newNode = new Node25(data);
        if(isEmpty()){
            head = tail = newNode;
        }else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addLast(Mahasiswa25 data){
        Node25 newNode = new Node25(data);
        if(isEmpty()){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void insertAfter(String keyNim, Mahasiswa25 data){
        Node25 current = head;

        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }

        if(current == null){
            System.out.println("Node dengan NIM " + keyNim + "tidak ditemukan.");
        }

        Node25 newNode = new Node25(data);

        if(current == tail){
            current.next = newNode;
            newNode.prev = current;
            tail = newNode; 
        }else{
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }

        System.out.println("Node berhasil disisipkan setelah NIM "+ keyNim);
    }

    public void print(){
        if (head == null) {
            System.out.println("Linked list masih kosong.");
            return;
        }
        Node25 current = head;
        System.out.println("Isi data dalam linked list:");
        while (current != null) {
            current.data.tampil();
            current = current.next;
        }
    }

    public void removeFirst(){
        if(isEmpty()){
            System.out.println("List kosong, tidak bisa dihapus.");
            return;
        }else{
            System.out.println("Data berhasil dihapus.");
            System.out.println();
            System.out.println("Data yang terhapus adalah:");
            System.out.println("NIM: " + head.data.nim);
            System.out.println("Nama: " + head.data.nama);
            System.out.println("Nama: " + head.data.kelas);
            System.out.println("IPK: " + head.data.ipk);
        }

        if(head == tail){
            head = tail = null;
        }else{
            head = head.next;
            head.prev = null;
        }
    }

    public void removeLast(){
        if(isEmpty()){
            System.out.println("List kosong, tidak bisa dihapus.");
            return;
        }else{
            System.out.println("Data berhasil dihapus.");
            System.out.println();
            System.out.println("Data yang terhapus adalah:");
            System.out.println("NIM: " + tail.data.nim);
            System.out.println("Nama: " + tail.data.nama);
            System.out.println("Nama: " + tail.data.kelas);
            System.out.println("IPK: " + tail.data.ipk);
        }

        if(head == tail){
            head = tail = null;
        }else{
            tail = tail.prev;
            tail.next = null;
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

    public void add(int index, Mahasiswa25 data) { //tugas no 1
        if (index < 0) {
            System.out.println("Indeks tidak valid. Indeks harus >= 0.");
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        }

        Node25 current = head;
        int i = 0;

        while (current != null && i < index) {
            current = current.next;
            i++;
        }

        if (current == null) {
            addLast(data);
        } else {
            Node25 newNode = new Node25(data);
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
        }
        System.out.println("Node berhasil ditambahkan pada indeks ke-" + index);
    }

    public void remove(int index) { //tugas no 3
        if (isEmpty()) {
            System.out.println("List kosong, tidak bisa menghapus.");
            return;
        }

        if (index < 0) {
            System.out.println("Indeks tidak valid. Indeks harus >= 0.");
            return;
        }

        Node25 current = head;
        int i = 0;

        while (current != null && i < index) {
            current = current.next;
            i++;
        }

        if (current == null) {
            System.out.println("Indeks melebihi jumlah elemen dalam list.");
            return;
        }

        System.out.println("Node pada indeks ke-" + index + " yang dihapus:");
        current.data.tampil();

        if (current == head) {
            removeFirst();
        } else if (current == tail) {
            removeLast();
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
            System.out.println("Node berhasil dihapus.");
        }
    }

    public void removeAfter(String keyNim) { //tugas no 2
        Node25 current = head;

        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }

        if (current == null || current.next == null) {
            System.out.println("Node setelah NIM " + keyNim + " tidak ditemukan atau tidak ada.");
            return;
        }

        Node25 toDelete = current.next;
        System.out.println("Data yang dihapus setelah NIM " + keyNim + ":");
        toDelete.data.tampil();

        if (toDelete == tail) {
            tail = current;
            current.next = null;
        } else {
            current.next = toDelete.next;
            toDelete.next.prev = current;
        }

        System.out.println("Node berhasil dihapus setelah NIM " + keyNim);
    }

    public void getFirst() { //tugas no 4
        if (isEmpty()) {
            System.out.println("List kosong.");
        } else {
            System.out.println("Data pada node pertama (head):");
            head.data.tampil();
        }
    }

    public void getLast() {
        if (isEmpty()) {
            System.out.println("List kosong.");
        } else {
            System.out.println("Data pada node terakhir (tail):");
            tail.data.tampil();
        }
    }

    public void getIndex(int index) {
        if (isEmpty()) {
            System.out.println("List kosong.");
            return;
        }

        if (index < 0) {
            System.out.println("Indeks tidak valid.");
            return;
        }

        Node25 current = head;
        int i = 0;
        while (current != null && i < index) {
            current = current.next;
            i++;
        }

        if (current == null) {
            System.out.println("Indeks melebihi jumlah elemen.");
        } else {
            System.out.println("Data pada indeks ke-" + index + ":");
            current.data.tampil();
        }
    }

    public int size() { // tugas no 5
        int count = 0;
        Node25 current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}
