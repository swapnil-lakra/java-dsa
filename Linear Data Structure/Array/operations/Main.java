class ArrayDemo {
    private int arr[];
    private int size;
    private int capacity;

    ArrayDemo(int cap){
        arr = new int[cap];
        capacity = cap;
        size = 0;
    }

    // ===== traverse / display array ======
    void display(){
        if(size == 0){
            System.out.println("[] (empty)");
            return;
        }
        System.out.print("[");
        for(int i = 0;i < size;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("]");
    }

    // ===== Insert Operations =====

    // Insert at the end - 0(1)
    void insertAtEnd(int val){
        if(size == capacity){
            System.out.println("Array full! "+val+" has not inserted.");
            return;
        }
        arr[size] = val;
        size++;
        System.out.println(val + " inserted (in the end)");
    }

    // Insert at index - 0(n)
    void insertAt(int index, int val){
        if(size == capacity){
            System.out.println("Array full!");
            return;
        }

        if(index < 0 || index > size){
            System.out.println("Invalid index!");
            return;
        }

        // shift right
        for(int i = size;i > index;i--){
            arr[i] = arr[i -1];
        }

        arr[index] = val;
        size++;
        System.out.println(val + " inserted (in index " + index+")");
    }
    
    // insert at start - 0(n)
    void insertAtStart(int val){
        insertAt(0, val);
    }

    // ===== delete operation =====

    // delete at index
    int deleteAt(int index){
        if(size < 1){
            System.out.println("Array is empty!");
            return -1;
        }

        if(index < 0 || index >= size){
            System.out.println("Invalid index!");
            return -1;
        }
        
        int val = arr[index];
        for(int i = index;i < size;i++){
            arr[i] = arr[i + 1];
        }
        size--;
        return val;
    }

    //delete by value
    boolean deleteByValue(int val){
        int idx = linearSearch(val);
        if(idx == -1) return false;
        deleteAt(idx);
        return true;
    }

    // ===== Search Operation =====

    // Linear Search
    int linearSearch(int val){
        for(int i = 0;i < size;i++){
            if(arr[i] == val){
                return i;
            }
        }
        return -1;
    }

    // Binary Search

    int binarySearch(){
        return -1;
    }

    // ===== Sort Operations =====

    // bubble sort

    // ===== Update Operation =====

    void update(int index, int val){
        if (size < 1){
            System.out.println("Array is empty.");
            return;
        }

        if (index < 0 || index >= size){
            System.out.println("Invalid index");
            return;
        }

        arr[index] = val;
    }

    // ===== Access Operation =====
    int get(int index){
        if(size < 1){
            System.out.println("Array is empty.");
            return -1;
        }

        if (index < 0 || index >= size){
            System.out.println("Invalid index.");
            return -1;
        }

        return arr[index];
    }

}

public class Main {
    public static void main(String[] args) {
        ArrayDemo a = new ArrayDemo(5);
        a.insertAtEnd(2);
        a.insertAtEnd(4);
        a.insertAt(1, 3);
        a.insertAtStart(1);
        a.deleteByValue(3);
        a.display();
    }    
}
