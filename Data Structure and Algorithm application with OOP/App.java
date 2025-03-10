import java.util.*;

public class App {

    public static void main(String[] args) {

        System.out.println("\nArrayList: \n");
        ArrayListDemo();

        System.out.println("\n\nLinkedList: \n");
        LinkedListDemo();

        System.out.println("\n\nVector: \n");
        VectorDemo();

        System.out.println("\n\n\nStack: \n");
        StackDemo();

        System.out.println("\n\nHashSet: \n");
        HashSetDemo();

        System.out.println("\n\nLinkedHashSet: \n");
        LinkedHashSetDemo();

        System.out.println("\n\nTreeSet: \n");
        TreeSetDemo();

        System.out.println(
                "\n\nOverrides the equals() and hashCode() method: \n");
        EqualsAndHashDemo();

        System.out.println("\n\nCompareTo: \n");
        CompareToDemo();

        System.out.println("\n\nHashMap: \n");
        HashMapDemo();

        System.out.println("\n\nEnumeration Cursor: \n");
        EnumerationCursorDemo();

        System.out.println("\n\nIterator Cursor: \n");
        IteratorCursorDemo();

        System.out.println("\n\nListIterator Cursor: \n");
        ListIteratorCursorDemo();

        System.out.println("\n\nImplements Comparator Interface: \n");
        ComparatorInterfaceDemo();

        System.out.println("\n\nUsing Utility Methods: \n");
        UtilityMethodsDemo();
    }

    public static void ArrayListDemo() {
        ArrayList<Person> al = new ArrayList<>();

        al.add(new Person("Jose Rizal", 'M'));
        Person p = new Person("Teodora Alonzo", 'F');
        p.setAge(60);

        al.add(p);
        al.add(1, new Person("Juan Luna", 'M'));

        al.forEach((x) -> {
            System.out.println(x);
        });

        p = al.get(1);
        p.setAge(30);
        al.set(0, p);

        System.out.println();
        al.forEach((x) -> {
            System.out.println(x);
        });
    }

    public static void LinkedListDemo() {
        LinkedList<Person> ll = new LinkedList<>();

        System.out.println("Sample FIFO/Queue: ");
        ll.add(new Person("Jose Rizal", 'M'));
        Person p1 = new Person("Teodora Alonzo", 'F');
        p1.setAge(60);

        ll.add(p1);
        ll.add(1, new Person("Juan Luna", 'M'));

        ll.forEach((x) -> {
            System.out.println(x);
        });

        while (!ll.isEmpty()) {
            System.out.println(ll.removeFirst());
        }

        System.out.println("\nSampleLIFO/Stack: ");
        ll.add(new Person("Jose Rizal", 'M'));
        Person p2 = new Person("Teodora Alonzo", 'F');
        p2.setAge(60);

        ll.add(p2);
        ll.add(1, new Person("Juan Luna", 'M'));

        ll.forEach((x) -> {
            System.out.println(x);
        });

        while (!ll.isEmpty()) {
            System.out.println(ll.removeLast());
        }
    }

    public static void VectorDemo() {
        Vector<Person> vPerson = new Vector<>();
        vPerson.addElement(new Person("Jose Rizal", 'M'));
        Person p = new Person("Teodora Alonzo", 'F');
        p.setAge(60);

        vPerson.addElement(p);
        vPerson.add(0, new Person("Juan Luna", 'M'));
        vPerson.set(2, new Person("Andres Bonifacio", 'M'));

        vPerson.forEach((x) -> {
            System.out.println(x);
        });
    }

    public static void StackDemo() {
        Stack<Person> sPerson = new Stack<>();
        sPerson.push(new Person("Jose Rizal", 'M'));

        Person p = new Person("Teodora Alonzo", 'F');
        p.setAge(60);

        sPerson.push(p);
        sPerson.push(new Person("Juan Luna", 'M'));

        while (!sPerson.isEmpty()) {
            System.out.println(sPerson.pop());
        }
    }

    public static void HashSetDemo() {
        HashSet<String> hsNames = new HashSet<>();
        hsNames.add("Willard");
        hsNames.add("Marc");
        hsNames.add("John");
        hsNames.add("Jylle");
        hsNames.add(null);
        hsNames.add("Bryan");

        System.out.println(hsNames);
    }

    public static void LinkedHashSetDemo() {
        LinkedHashSet<String> hsNames = new LinkedHashSet<>();
        hsNames.add("Willard");
        hsNames.add("Marc");
        hsNames.add("John");
        hsNames.add("Jylle");
        hsNames.add(null);
        hsNames.add("Bryan");

        System.out.println(hsNames);
    }

    public static void TreeSetDemo() {
        TreeSet<String> tsNames = new TreeSet<>();
        tsNames.add("Willard");
        tsNames.add("Marc");
        tsNames.add("John");
        tsNames.add("Jylle");
        tsNames.add("John");
        tsNames.add("Bryan");

        System.out.println(tsNames);
    }

    public static void EqualsAndHashDemo() {
        LinkedHashSet<Person> hsPerson = new LinkedHashSet<>();

        hsPerson.add(new Person("DE LOS SANTOS, WILLARD KENT", 'M'));
        hsPerson.add(new Person("RABANO, ARVIN JAMES", 'M'));
        hsPerson.add(new Person("CLEOFE, CHRISTINE JOY", 'F'));
        hsPerson.add(new Person("RABANO, ARVIN JAMES", 'M'));

        hsPerson.forEach((p) -> {
            System.out.println(p);
        });
    }

    public static void CompareToDemo() {
        TreeSet<Person> tsPerson = new TreeSet<>();

        tsPerson.add(new Person("DE LOS SANTOS, WILLARD KENT", 'M'));
        tsPerson.add(new Person("RABANO, ARVIN JAMES", 'M'));
        tsPerson.add(new Person("CLEOFE, CHRISTINE JOY", 'F'));
        tsPerson.add(new Person("RABANO, ARVIN JAMES", 'M'));

        tsPerson.forEach((x) -> {
            System.out.println(x);
        });
    }

    public static void HashMapDemo() {
        HashMap<String, Student> hmStudents = new HashMap<>();

        hmStudents.put("001", new Student("001", "Rizal, Jose", 'M'));
        hmStudents.put("002", new Student("002", "Bonifacio, Andres", 'M'));
        hmStudents.put("003", new Student("003", "Luna, Juan", 'M'));
        hmStudents.put("003", new Student("003", "Luna, Antonio", 'M'));

        Set<String> sStudentNos = hmStudents.keySet();
        System.out.println("Student Nos: " + sStudentNos);

        Collection<Student> cStudents = hmStudents.values();
        System.out.println("\nStudents:");
        cStudents.forEach((s) -> {
            System.out.println(s);
        });

        Set sStudents = hmStudents.entrySet();

        Iterator s_itr = sStudents.iterator();

        while (s_itr.hasNext()) {
            Map.Entry<String, Student> me = (Map.Entry<String, Student>) s_itr.next();

            if (me.getKey().equals("003")) {
                me.setValue(new Student("003", "Luna, Juan", 'M'));
            }
        }

        s_itr = sStudents.iterator();
        System.out.println("\nStudent List:");

        while (s_itr.hasNext()) {
            Map.Entry<String, Student> me = (Map.Entry<String, Student>) s_itr.next();
            System.out.println(me.getKey() + " | " + me.getValue());
        }
    }

    public static void EnumerationCursorDemo() {
        Vector<Integer> v = new Vector<>();
        v.add(1);
        v.add(2);
        v.add(3);
        v.add(4);

        Enumeration e = v.elements();

        while (e.hasMoreElements()) {
            int i = (Integer) e.nextElement();
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }

        System.out.println(" : " + v);
    }

    public static void IteratorCursorDemo() {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);

        Iterator itr = al.iterator();

        while (itr.hasNext()) {
            int i = (Integer) itr.next();
            if (i % 2 == 0) {
                System.out.print(i + " ");
                itr.remove();
            }
        }
        System.out.println(" : " + al);
    }

    public static void ListIteratorCursorDemo() {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);

        ListIterator l_itr = ll.listIterator();

        while (l_itr.hasNext()) {
            int i = (Integer) l_itr.next();
            if (i % 2 == 0) {
                System.out.print(i + " ");
                l_itr.set(0);
            }
        }
        System.out.println(" : " + ll);

        System.out.println("\nList Iterator Forward and Backward:");
        ll.set(1, 2);
        ll.set(3, 4);
        l_itr = ll.listIterator();
        while (l_itr.hasNext()) {
            int i = (Integer) l_itr.next();
            System.out.print(i + " ");
        }
        System.out.print(" : ");
        while (l_itr.hasPrevious()) {
            int i = (Integer) l_itr.previous();
            System.out.print(i + " ");
        }

        System.out.println("\n\nList Iterator Add:");
        while (l_itr.hasNext()) {
            l_itr.next();
            l_itr.add(0);
        }
        System.out.println(ll);
    }

    static class NumberDescendingOrder implements Comparator {
        public int compare(Object o1, Object o2) {
            double num1 = Double.parseDouble(o1.toString());
            double num2 = Double.parseDouble(o2.toString());

            if (num1 > num2) {
                return -1;
            }

            else if (num1 < num2) {
                return 1;
            }

            else {
                return 0;
            }
        }
    }

    public static void ComparatorInterfaceDemo() {
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(3);
        ts.add(6);
        ts.add(5);
        ts.add(1);
        ts.add(2);
        ts.add(4);

        System.out.println("ASCENDING ORDER: " + ts);

        ts = new TreeSet<>(new NumberDescendingOrder());
        ts.add(3);
        ts.add(6);
        ts.add(5);
        ts.add(1);
        ts.add(2);
        ts.add(4);

        System.out.println("DESCENDING ORDER: " + ts);
    }

    public static void UtilityMethodsDemo() {
        ArrayList<Integer> orig_al = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < 10; i++) {
            orig_al.add(r.nextInt(75) + 1);
        }

        System.out.println("Original: " + orig_al);

        ArrayList<Integer> rev_al = new ArrayList<>(orig_al);

        Collections.reverse(rev_al);
        System.out.println("Reversed: " + rev_al);

        ArrayList<Integer> aso_al = new ArrayList<>(orig_al);

        Collections.sort(aso_al);
        System.out.println("A-Sorted: " + aso_al);

        int num = 25;
        int i = Collections.binarySearch(aso_al, num);

        if (i >= 0) {
            System.out.println(num + " is located at index " + i);
        } else {
            i = Math.abs(i + 1);
            System.out.println(num + " can be inserted at index " + i);
        }

        num = 25;
        i = Collections.binarySearch(aso_al, num);

        if (i >= 0) {
            System.out.println(num + " is located at index " + i);
        } else {
            Collections.sort(aso_al, new NumberDescendingOrder());
            System.out.println("D-Sorted: " + aso_al);
        }
    }
}