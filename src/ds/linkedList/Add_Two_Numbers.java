package ds.linkedList;

public class Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root1 = l1;
        ListNode root2 = l2;

        int count1=0;
        int count2=0;
        while(root1!=null){
            count1++;
            root1=root1.next;
        }
        while(root2!=null){
            count2++;
            root2=root2.next;
        }

        ListNode temp1=l1;
        ListNode temp2=l2;
        if(count1>=count2){
            int carry=0;
            ListNode lastNode=null;
            while(l2!=null){
                l1.val = l1.val+l2.val+carry;
                if(l1.val>=10){
                    l1.val=l1.val%10;
                    carry=1;
                }else{
                    carry=0;
                }
                lastNode=l1;
                l2=l2.next;
                l1=l1.next;
            }


            if(carry==1){
                while(l1!=null){
                    l1.val=l1.val+carry;
                    if(l1.val>=10){
                        l1.val=l1.val%10;
                        carry=1;
                    }else{
                        carry=0;
                    }
                    lastNode=l1;
                    l1=l1.next;
                }
            }
            if(carry==1){
                ListNode newNode = new ListNode(1);
                lastNode.next=newNode;
            }
            return temp1;
        }
        else {
            int carry=0;
            ListNode lastNode=null;
            while(l1!=null){
                l2.val = l2.val+l1.val+carry;
                if(l2.val>=10){
                    l2.val=l2.val%10;
                    carry=1;
                }else{
                    carry=0;
                }
                lastNode =l2;
                l1=l1.next;
                l2=l2.next;
            }

            if(carry==1){
                while(l2!=null){
                    l2.val=l2.val+carry;
                    if(l2.val>=10){
                        l2.val=l2.val%10;
                        carry=1;
                    }else{
                        carry=0;
                    }
                    lastNode=l2;
                    l2=l2.next;
                }
            }
            if(carry==1){
                ListNode newNode = new ListNode(1);
                lastNode.next=newNode;
            }
            return temp2;
        }

    }
}
