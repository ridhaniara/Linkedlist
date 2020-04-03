public class Linkedlist {
    private Node head;
    private int size;

    public Linkedlist() {
        this.head = null;
        this.size = 0;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getHead() {
        return this.head;
    }

    public void incSize() {
        this.size++;
    }

    public void decSize() {
        this.size--;
    }

    public int getSize() {
        return this.size;
    }

    public Node searchData(String editor) {
        Node current = this.getHead();

        while (current != null) {
            if (current.getData().getName().equals(editor))
                return current;
            if (current.getNext() == null)
                break;
            current = current.getNext();
        }

        return null;
    }

    public String fetchData(String editor) {
        Node isFound = this.searchData(editor);

        if (isFound != null) {
            return "Data " + isFound.getData().getName() + " ditemukan dengan " + isFound.getData().getFreq()
                    + " artikel.";
        } else {
            return "Data " + editor + " tidak ditemukan.";
        }
    }

    public void add(String editor) {
        Node isFound = this.searchData(editor);

        if (isFound == null) {
            this.setHead(new Node(new Data(editor), this.getHead()));
        } else {
            isFound.getData().addFreq();
        }

    }

    public void display() {
        Node current = this.getHead();
        int i=1;

        while (current != null) {
            System.out.println(i+". " +current.getData().getName() + ", " + current.getData().getFreq() + " artikel");
            if (current.getNext() == null)
                break;
            current = current.getNext();
            i++;
        }
    }

    public void bubbleSort() {
        if (size > 1) {
            boolean wasChanged;

            do {
                Node current = head;
                Node previous = null;
                Node next = head.getNext();
                wasChanged = false;

                while (next != null) {
                    if (current.getData().getName().toLowerCase()
                            .compareTo(next.getData().getName().toLowerCase()) > 0) {
                        wasChanged = true;

                        if (previous != null) {
                            Node sig = next.getNext();

                            previous.setNext(next);
                            next.setNext(current);
                            current.setNext(sig);
                        } else {
                            Node sig = next.getNext();

                            head = next;
                            next.setNext(current);
                            current.setNext(sig);
                        }

                        previous = next;
                        next = current.getNext();
                    } else {
                        previous = current;
                        current = next;
                        next = next.getNext();
                    }
                }
            } while (wasChanged);
        }
    }

    public void menubaru(String editor) {
        Node isFound = this.searchData(editor);

        if (isFound != null) {
            System.out.println(isFound.getData().getName() + " mengedit " + isFound.getData().getFreq() + " artikel.");
            isFound.getData().getJudul();

        } else {
            System.out.println("Data " + editor + " tidak ditemukan.");
        }
    }

    public void searchContainsEditor(String editor) {
        Node current = this.getHead();

        while (current != null) {
            if (current.getData().getName().toLowerCase().contains(editor.toLowerCase())) {
                System.out.println(
                        current.getData().getName() + " ditemukan dengan " + current.getData().getFreq() + " artikel.");
            }
            if (current.getNext() == null) {
                break;
            }
            current = current.getNext();
        }
    }

}