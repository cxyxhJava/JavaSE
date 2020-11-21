import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author franyang
 * @date 2020/11/21
 */
public class 判断一个链表是否为回文链表 {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(2);
        ListNode head4 = new ListNode(1);
        head.next = head2;
        head2.next = head3;
        head3.next = head4;

        System.out.println(isPalindrome(head));
        System.out.println(isPalindrome2(head));

    }



    public static boolean isPalindrome(ListNode head) {
        LinkedList linkedList = new LinkedList();
        while (head!=null){
            linkedList.add(head.val);
            head = head.next;
        }

        for (int i = 0; i < linkedList.size(); i++) {
            if (!linkedList.get(i).equals(linkedList.get(linkedList.size()-1-i))){
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(ListNode head) {
        List arrayList = new ArrayList();
        while (head!=null){
            arrayList.add(head.val);
            head = head.next;
        }

        for (int i = 0; i < arrayList.size(); i++) {
            if (!arrayList.get(i).equals(arrayList.get(arrayList.size()-1-i))){
                return false;
            }
        }
        return true;
    }




}
