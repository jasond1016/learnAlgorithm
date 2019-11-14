class LRUBasedLinkedList<T> {

    private static Integer DEFAULT_CAPACITY = 10;

    private static Integer capacity;

    LRUBasedLinkedList() {
        this.capacity = DEFAULT_CAPACITY;
    }

    LRUBasedLinkedList(Integer capacity) {
        this.capacity = capacity;
    }


    class MyNode<T> {
        T element;
        MyNode next;

        MyNode() {

        }

        MyNode(T element) {
            this.element = element;
        }

        MyNode(T element, MyNode next) {
            this.element = element;
            this.next = next;
        }

        T getElement() {
            return this.element;
        }

        void setNext(MyNode next) {
            this.next = next;
        }

    }

    public static void main(String[] args) {
        System.out.println("nothing here.");
    }
}