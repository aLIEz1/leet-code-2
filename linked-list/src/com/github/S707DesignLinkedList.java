package com.github;

/**
 * 设计链表
 * 双向链表
 *
 * @author ZhangFuQi
 * @date 2021/8/2 16:39
 */
public class S707DesignLinkedList {
    static class MyLinkedList {
        static class Node {
            int val;
            Node next;
            Node prev;

            public Node() {
            }

            public Node(int val, Node next, Node prev) {
                this.val = val;
                this.next = next;
                this.prev = prev;
            }

            public Node(int val) {
                this.val = val;
            }
        }

        private Node head = new Node();
        private Node tail = new Node();
        private int size;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
            head.next = tail;
            tail.prev = head;
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            //从前面开始找
            if (index >= size / 2) {
                int count = 0;
                Node cur = head.next;
                while (cur != null) {
                    if (count == index) {
                        return cur.val;
                    }
                    count++;
                    cur = cur.next;
                }
                //从后面开始找
            } else {
                int count = 0;
                Node cur = tail.prev;
                while (cur != null) {
                    if (count == size - index - 1) {
                        return cur.val;
                    }
                    count++;
                    cur = cur.prev;
                }

            }
            return -1;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            Node node = new Node(val);
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
            size++;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            Node node = new Node(val);
            node.prev = tail.prev;
            tail.prev.next = node;
            tail.prev = node;
            node.next = tail;
            size++;
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) {
                return;
            }
            if (index == size) {
                addAtTail(val);
            } else if (index == 0) {
                addAtHead(val);
            } else {
                Node node = getNode(index);
                if (node != null) {
                    Node insert = new Node(val);
                    insert.prev = node.prev;
                    node.prev.next = insert;
                    node.prev = insert;
                    insert.next = node;
                    size++;
                }
            }

        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (index < 0 && index >= size) {
                return;
            }
            Node node = getNode(index);
            if (node != null) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                size--;
            }

        }

        private Node getNode(int index) {
            if (index < 0 || index >= size) {
                return null;
            }
            //从前面开始找
            if (index >= size / 2) {
                int count = 0;
                Node cur = head.next;
                while (cur != null) {
                    if (count == index) {
                        return cur;
                    }
                    count++;
                    cur = cur.next;
                }
                //从后面开始找
            } else {
                int count = 0;
                Node cur = tail.prev;
                while (cur != null) {
                    if (count == size - index - 1) {
                        return cur;
                    }
                    count++;
                    cur = cur.prev;
                }

            }
            return null;
        }
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtIndex(0, 10);
        list.addAtIndex(0, 20);
        list.addAtIndex(1, 30);
        System.out.println(list.get(0));
    }
}
