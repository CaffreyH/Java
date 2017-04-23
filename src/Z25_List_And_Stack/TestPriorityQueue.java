package Z25_List_And_Stack;

/**
 * Created by Caffrey on 2017/4/22.
 */
public class TestPriorityQueue<E extends Comparable> {

    public static void main(String[] args)
    {
        Patient patient1 = new Patient("John", 4);
        Patient patient2 = new Patient("Michal", 5);
        Patient patient3 = new Patient("Tim", 2);
        Patient patient4 = new Patient("Cindy", 1);

        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.enqueue(patient1);
        priorityQueue.enqueue(patient2);
        priorityQueue.enqueue(patient3);
        priorityQueue.enqueue(patient4);

        while(priorityQueue.getSize() >0)
        {
            System.out.print(priorityQueue.dequeue());
        }
    }
    public static class Patient implements Comparable
    {
        private String name;
        private int priority;
        public Patient(String name,int priority)
        {
            this.name = name;
            this.priority = priority;
        }
        @Override
        public String toString()
        {
            return name+"("+priority+")";
        }


        @Override
        public int compareTo(Object o) {
            return this.priority-((Patient)o).priority;
        }
    }
}
