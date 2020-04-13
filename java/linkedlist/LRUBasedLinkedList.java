package linkedlist;

import java.util.Scanner;

/**
 * @author Jason
 */
public class LRUBasedLinkedList<T> {

    /**
     * 链表默认容量
     */
    private static Integer DEFAULT_CAPACITY = 10;

    /**
     * 链表容量
     */
    private Integer capacity;

    /**
     * 链表实际长度
     */
    private Integer length;

    /**
     * 头节点
     */
    private MyNode<T> headNode;

    public LRUBasedLinkedList() {
        this.headNode = new MyNode<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRUBasedLinkedList(Integer capacity) {
        this.headNode = new MyNode<>();
        this.capacity = capacity;
        this.length = 0;
    }

    public void add(T data) {
        // 查找含有对象数据的前一节点
        MyNode<T> preNode = findPreNode(data);
        // 存在前一节点
        if (preNode != null) {
            // 删除对象数据节点
            deleteAfter(preNode);
            // 在开头插入对象数据节点
            insertNodeAtBeginning(data);
        } else {
            // 链表已满
            if (this.length >= this.capacity) {
                // 删除尾节点
                deleteNodeAtLast();
            }
            // 在开头插入对象数据节点
            insertNodeAtBeginning(data);
        }
    }

    private MyNode<T> findPreNode(T data) {
        MyNode<T> node = headNode;
        while (node.getNext() != null) {
            if (data.equals(node.getNext().getData())) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    private void deleteAfter(MyNode<T> preNode) {
        MyNode<T> temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        temp = null;
        length--;
    }

    private void insertNodeAtBeginning(T data) {
        MyNode<T> temp = headNode.getNext();
        headNode.setNext(new MyNode<>(data, temp));
        length++;
    }

    private void deleteNodeAtLast() {
        MyNode<T> node = headNode;
        if (node.getNext() == null) {
            return;
        }
        while (node.getNext().getNext() != null) {
            node = node.getNext();
        }
        MyNode<T> temp = node.getNext();
        node.setNext(null);
        temp = null;
        length--;
    }

    private void printAll() {
        MyNode<T> node = headNode.getNext();
        while (node != null) {
            System.out.print(node.getData() + ",");
            node = node.getNext();
        }
        System.out.println();
    }

    private static class MyNode<T> {
        private T data;
        private MyNode<T> next;

        MyNode() {

        }

        MyNode(T data) {
            this.data = data;
        }

        MyNode(T data, MyNode<T> next) {
            this.data = data;
            this.next = next;
        }

        T getData() {
            return this.data;
        }

        void setNext(MyNode<T> next) {
            this.next = next;
        }

        MyNode<T> getNext() {
            return this.next;
        }

    }

    public static void main(String[] args) {
        LRUBasedLinkedList<Integer> list = new LRUBasedLinkedList<>(5);
        Scanner scan = new Scanner(System.in);
        while (true) {
            list.add(scan.nextInt());
            list.printAll();
        }
    }
}