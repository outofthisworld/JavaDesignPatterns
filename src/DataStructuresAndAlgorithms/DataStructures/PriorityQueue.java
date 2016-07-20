package DataStructuresAndAlgorithms.DataStructures;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Dale on 18/07/16.
 */
public class PriorityQueue<T extends Priority> {
    private final TreeMap<Integer,ArrayList<T>> treeMap = new TreeMap<>();
    private  CountDownLatch countDownLatch;

    public void insert(T item){
        ArrayList<T> ar;
        if((ar = treeMap.get(item.getPriority())) != null){
            ar.add(item);
        }else{
            ar = new ArrayList<>();
            ar.add(item);
            treeMap.put(item.getPriority(),ar);
        }
        if(countDownLatch != null)
            countDownLatch.countDown();
    }

    public T blockingNext(){
        T item;
        if((item = getNext()) == null){
            try {
                countDownLatch = new CountDownLatch(1);
                countDownLatch.await();
                item = getNext();
                countDownLatch = null;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return item;
    }

    public T getNext(){
        Map.Entry<Integer, ArrayList<T>> en = treeMap.firstEntry();
        if(en != null) {
            T obj = en.getValue().get(0);
            en.getValue().remove(0);
            if (en.getValue().size() == 0) {
                treeMap.remove(en.getKey());
            }
            return obj;
        }else{
            System.out.println("en null");
            return null;
        }
    }


    static class Item implements Priority{
        private int prior;
        private String itemName;

        public Item(String itemName,int priority){
            this.itemName = itemName;
            this.prior = priority;
        }

        @Override
        public int getPriority() {
            return prior;
        }
    }


    public static void main(String[] args) {
        PriorityQueue<Item> pQueue = new PriorityQueue<>();

        pQueue.insert(new Item("Item Prior 10",10));
        pQueue.insert(new Item("Item Prior One",1));
        pQueue.insert(new Item("Item Prior 15",15));

        System.out.println(pQueue.getNext().itemName);
        System.out.println(pQueue.getNext().itemName);
        System.out.println(pQueue.getNext().itemName);

        pQueue.blockingNext();

    }

}
