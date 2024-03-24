package basic.knowledge.henry.algorithm.InterviewExperience.canva.pq;

import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.List;



public class TradeMatchingSystem {
    PriorityQueue<TradeOrder> buyOrders; // Priority queue for buy orders
    PriorityQueue<TradeOrder> sellOrders; // Priority queue for sell orders
    List<String> trades; // List to store matched trades

    // Constructor
    public TradeMatchingSystem() {
        // Initialize data structures
        buyOrders = new PriorityQueue<TradeOrder>((o1, o2) -> Double.compare(o2.price, o1.price)); // Max heap for buy orders
        sellOrders = new PriorityQueue<TradeOrder>((o1, o2) -> Double.compare(o1.price, o2.price)); // Min heap for sell orders
        trades = new ArrayList<>();
    }

    // Method to submit a new order
    public void submitOrder(String orderId, String type, double price, int quantity) {
        // Create a new trade order and add it to the appropriate priority queue
        TradeOrder order = new TradeOrder(orderId, type, price, quantity);
        if (type.equals("buy")) {
            buyOrders.offer(order);
        } else if (type.equals("sell")) {
            sellOrders.offer(order);
        }
    }

    // Method to match orders
    public void matchOrders() {
        // Implement order matching logic
        while (!buyOrders.isEmpty() && !sellOrders.isEmpty()) {
            TradeOrder buyOrder = buyOrders.peek();
            TradeOrder sellOrder = sellOrders.peek();
            if (buyOrder.price >= sellOrder.price) {
                // Match found
                int tradeQuantity = Math.min(buyOrder.quantity, sellOrder.quantity);
                buyOrder.quantity -= tradeQuantity;
                sellOrder.quantity -= tradeQuantity;
                trades.add("Trade: Buy Order ID - " + buyOrder.orderId + ", Sell Order ID - " + sellOrder.orderId + ", Quantity - " + tradeQuantity);
                if (buyOrder.quantity == 0) {
                    buyOrders.poll();
                }
                if (sellOrder.quantity == 0) {
                    sellOrders.poll();
                }
            } else {
                // No more matches possible
                break;
            }
        }
    }

    // Method to print trades
    public void printTrades() {
        // Implement logic to print matched trades
        if (trades.isEmpty()) {
            System.out.println("No trades executed.");
        } else {
            System.out.println("Trades executed:");
            for (String trade : trades) {
                System.out.println(trade);
            }
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Test the trade matching system
        TradeMatchingSystem system = new TradeMatchingSystem();
        // Submit some test orders
        system.submitOrder("1", "buy", 100.0, 10);
        system.submitOrder("2", "buy", 105.0, 15);
        system.submitOrder("3", "sell", 102.0, 12);
        system.submitOrder("4", "sell", 110.0, 8);
        // Match orders and print trades
        system.matchOrders();
        system.printTrades();
    }


}

class TradeOrder {
    String orderId;
    String type;
    double price;
    int quantity;

    // Constructor
    public TradeOrder(String orderId, String type, double price, int quantity) {
        this.orderId = orderId;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }
}

