package basic.knowledge.henry.algorithm.InterviewExperience.canva;

//fifo
public class CircularBuffer {
    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(5);
        buffer.add(1);
        buffer.add(2);
        buffer.add(3);
        buffer.display(); // Output: Circular Buffer: 1 2 3 0 0
        System.out.println("===" + buffer.size());
        int dequeuedItem = buffer.poll();
        System.out.println("Dequeued item: " + dequeuedItem); // Output: Dequeued item: 1

        int dequeuedItem2 = buffer.poll();
        System.out.println("Dequeued item 2: " + dequeuedItem2); //Output: Dequeued item: 2
        buffer.display(); // Output: Circular Buffer: 0 2 3 0 0
        System.out.println("===" + buffer.size());
        buffer.add(4);
        buffer.add(5);
        buffer.add(6); // Buffer is full. Cannot enqueue item.
        buffer.display(); // Output: Circular Buffer: 0 2 3 4 5
        System.out.println("===" + buffer.size());

        int dequeuedItem3 = buffer.poll();
        System.out.println("Dequeued item 3: " + dequeuedItem3); //Output: Dequeued item: 3


        int dequeuedItem4 = buffer.poll();
        System.out.println("Dequeued item 4: " + dequeuedItem4); //Output: Dequeued item: 4


        int dequeuedItem5 = buffer.poll();
        System.out.println("Dequeued item 5: " + dequeuedItem5); //Output: Dequeued item: 5


        int dequeuedItem6 = buffer.poll();
        System.out.println("Dequeued item 6: " + dequeuedItem6); //Output: Dequeued item: 2

        System.out.println("===" + buffer.size());

        buffer.display(); //
    }

    int[] buffer;
    int head;
    int tail;

    int capacity;

    int size;

    public CircularBuffer(int n) {
        this.capacity = n;
        buffer = new int[this.capacity];
        head = 0;
        tail = -1;
    }

    public void display() {
        System.out.print("Circular Buffer: ");
        for (int i = 0; i < capacity; i++) {
            System.out.print(buffer[i] + " ");
        }
        System.out.println();
    }

    public int size() {
        return size;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public boolean add(int val) {
        if (isFull()) {
            return false;
        }
        tail = (tail + 1) % capacity;
        buffer[tail] = val;
        size++;
        return true;
    }


    public Integer poll() {
        if (isEmpty()) {
            return null;
        }
        int res = buffer[head];
        buffer[head] = 0;
        head = (head + 1) % capacity;
        size--;
        return res;
    }
}

