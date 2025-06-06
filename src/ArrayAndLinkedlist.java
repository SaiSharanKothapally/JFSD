import java.util.*;

public class ArrayAndLinkedlist {
    public static void main(String[] args) {
       ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);

        System.out.println("Array List: " + arrayList);

        arrayList.remove(2);
        System.out.println("Array List after removing index 2: " + arrayList);
        arrayList.set(2, 10);
        System.out.println("Array List after setting index 2 to 10: " + arrayList);
        System.out.println("Array List size: " + arrayList.size());

        arrayList.remove(Integer.valueOf(5));
        System.out.println("Array List after removing value 5: " + arrayList);

        arrayList.addFirst(20);
        arrayList.addLast(30);
        System.out.println("Array List after adding 20 at first and 30 at last: " + arrayList);





        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);

        System.out.println("Linked List: " + linkedList);
    }

}
