import java.time.Instant;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BofaSoln {
    /***
     *
     * Cake store which opens 24/7 and can deliver 5 types of cakes at same price: 2 SGD each.
     * Every customer needs to register with an address.
     * Once registered, a customer can start to order. He or she will send an order of qty for the cake types he or she wants to order with following rules:
     * -- cannot order more than 3 for each varieties of cake
     * -- he cannot order more than 6 for 1 time
     * -- cannot order again within the same hour (based on the time the order is received)
     * Once order accepted, will display the total price
     *
     * ****/
    static List<Customer> regCustLst=new ArrayList<Customer>();

    public static void main(String[] args){
        registerCustomer("A","addr1");
        registerCustomer("B","addr2");
        registerCustomer("C","addr3");

        executeTest();
        HashMap<String,Integer> order=new HashMap<>();
        order.put("cakeA",3);
        order.put("cakeB",2);
        orderStatus("A",order);
        order.put("cakeC",2);
        orderStatus("B",order);
    }

    public class cakefactory{
        public HashMap<String,Integer> cakeMap = new HashMap<>();

        cakefactory(String cake,int price){
            this.cakeMap.put(cake,price);
        }

        public int getPrice(String cake){
            return this.cakeMap.get(cake);
        }

    }

    public static class Customer{
        String name;
        String address;
        LocalTime pastOrderHr;
        HashMap<String,Integer> pastOrder;

        Customer(String userName,String address){
            this.name=userName;
            this.address=address;
        }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public LocalTime getPastOrderHr() {
            return pastOrderHr;
        }

        public void setPastOrderHr(LocalTime pastOrderHr) {
            this.pastOrderHr = pastOrderHr;
        }

        public HashMap<String, Integer> getPastOrder() {
            return pastOrder;
        }

        public void setPastOrder(HashMap<String, Integer> pastOrder) {
            this.pastOrder = pastOrder;
        }
    }

    public static boolean registerCustomer(String userName, String address){
        /**
         * 1. name is already exist
         * **/

        if(!AlreadyExist(userName)){
            regCustLst.add(new Customer(userName,address));
            System.out.println("[DEBUG]: Customer "+userName+" registered success ");
            return true;
        }

        return false;
    }

    private static boolean AlreadyExist(String userName) {
        for(Customer c:regCustLst){
           if(c.getName().equalsIgnoreCase(userName)){
                return true;
            }
        }
        return false;
    }
    private static Customer getCustomer(String userName) {
        for(Customer c:regCustLst) {
            if (c.getName().equalsIgnoreCase(userName)) {
                return c;
            }
        }
        return null;
    }

    public static boolean orderStatus(String uname,HashMap<String,Integer> order){
        int total_quantity=0;
        Customer c;
        if(!AlreadyExist(uname)) {
            System.out.println("[DEBUG]: uname Not Register");
            return false;
        }else{
             c = getCustomer(uname);
        }

        if(checkisSameHr(uname)){
            System.out.println("[DEBUG]:Previous order is happened on same hr !");
            return false;
        }

        for(Map.Entry o:order.entrySet())
        {
            int qty= (Integer) o.getValue();
            String cakeType=o.getKey().toString();

            if(qty > 3){
                System.out.println("[DEBUG]: INDIVIDIAL QTY CANNOT EXCEED 3");
                return false;
            }
            total_quantity+=qty;
            if(total_quantity>6){
                System.out.println("[DEBUG]: Overall QTY CANNOT EXCEED 6");
                return false;
            }

        }
        c.setPastOrderHr(LocalTime.now());
        c.setPastOrder(order);
        updateCustomer(c);
        System.out.println("[DEBUG]: Order is processed for the username "+c.getName());
        return true;
    }

    private static void updateCustomer(Customer c) {
        for(Customer ct:regCustLst) {
            if (ct.getName().equalsIgnoreCase(c.getName())) {
                ct.setPastOrder(c.getPastOrder());
                ct.setPastOrderHr(c.getPastOrderHr());
            }
        }
    }

    private static boolean checkisSameHr(String uname) {

        LocalTime currTm = LocalTime.now();
        LocalTime time2 = LocalTime.of(21, 22, 00);

        // Calculating the difference in Hours
        long hours = ChronoUnit.HOURS.between(currTm, currTm);
        //Instant currentHr= Instant.now().plus(1);
        for (Customer c : regCustLst) {
            if (c.getName().equalsIgnoreCase(uname)) {
                // return c.getPastOrderHr().equals(currentHr.toString());
                return false;
            }
        }
        return false;
    }

    public static void executeTest(){

        HashMap<String,Integer> order=new HashMap<>();
        order.put("cakeA",3);
        order.put("cakeB",2);
        if(orderStatus("A",order)){
            System.out.println("Passed test 1 ");
        }

        if(!orderStatus("X",order)){
            System.out.println("Passed test 2 , invalid customer ");
        }
    }

}
