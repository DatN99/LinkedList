package com.company;


 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }

	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		 if (l1 == null){
			 return l2;
		 }

		 else if (l2 == null){
			 return l1;
		 }


		 ListNode curr_s = null;
		 ListNode iter1 = l1;
		 ListNode iter2 = l2;

		 while (iter1.next != null && iter2.next != null){



			 if (iter1.val <= iter2.val){

				 if (curr_s != null){
					 curr_s.next = iter1;
				 }

				 curr_s = iter1;
				 iter1 = iter1.next;

			 }

			 else{

				 if (curr_s != null){

					 curr_s.next = iter2;
				 }

				 curr_s = iter2;
				 iter2 = iter2.next;
			 }
		 }

		 System.out.println(iter1.val);

		 if (iter1 == null){
			 curr_s.next = iter2;
		 }

		 else {curr_s.next = iter1;}



		 return curr_s;
	 }
 }





public class Main {

    public static void main(String[] args) {

    }
}
