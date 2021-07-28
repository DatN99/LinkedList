package com.company;

public class Main {

    public static void main(String[] args) {
	LinkedList LL = new LinkedList();

	LL.insert(0, 1);
	LL.insert(1, 2);
	LL.insert(2, 3);
	LL.add(9999);
	LL.insert(2, 4);
	LL.insert(4, 5);
	LL.add(6);
	LL.print();
    }
}
