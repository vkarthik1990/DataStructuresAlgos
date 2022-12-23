
import java.io.*;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


class SCB_Ticker {


    /**
     * A queue that stores price ticks from underlying transports so that they can be processed by worker threads.
     *
     * The queue should be unbounded but should block when an attempt is made to take while there are no items.
     *
     * Logically, there should either be zero or one items for each product available to dequeue at any time.
     * The order of items on the queue should be FIFO based on the arrival of products (rather than the ticks).
     *
     * For example, imagine if the following 3 ticks are added to the queue with no interleaved reads
     * 1. IBM -> 100
     * 2. APPL -> 95
     * 3. IBM -> 101
     *
     * We would read these off as follows
     * 1. IBM -> 101
     * 2. APPL -> 95
     * 3. Block
     *
     * We saw IBM with the first read because an IBM trade arrived before an APPL trade, but it's value has been superceded by the 101 tick.
     * We then read APPL and block because there are no entries left (only two products).
     *
     */
    public static void main (String[] args) {

        TickerQueue tq=new TickerQueue();
        tq.put(new Tick("IBM",100));
        tq.put(new Tick("apple",95));
        tq.put(new Tick("IBM",101));
        System.out.println(tq.take().getProduct());
        System.out.println(tq.take().getProduct());

        System.out.println(tq.take());

    }

    public static class TickerQueue implements LatestValueQueue{

        BlockingQueue<Tick> que=  new LinkedBlockingQueue();
        HashMap<String,Integer> s=new HashMap<String,Integer>();
        @Override
        public synchronized void put(Tick tick){

            if(s!=null && !s.containsKey(tick.getProduct())){
                // Insert into queue
                que.add(tick);
                s.put(tick.getProduct(),que.size());
            }else{
                int index=s.get(tick.getProduct());
                que.remove(index);
            }
        }

        @Override
        public synchronized Tick take(){
            return que.poll();
        }

    }



    private static class Tick {
        private final String product;
        private final double price;

        public Tick(String product,double price){
            this.product=product;
            this.price=price;
        }

        public String getProduct() {
            return product;
        }

        public double getPrice() {
            return price;
        }
    }



    public interface LatestValueQueue {
        public  void put(Tick tick);
        public Tick  take();
    }





}