package Basic.AADesign;

import java.util.*;

enum Coin{
    PENNY(1),
    NICKLE(5),
    DIME(10),
    QUARTER(25);
    
    private final int value;
    private Coin(int value){
        this.value = value;
    }
    public int getValue(){
        return this.value;
    }
}

enum Item{
    COKE("Coke",25),
    PEPSI("Pepsi",35),
    SODA("Soda",45);
    
    private final String name;
    private final int price;
    private Item(String name, int price){
        this.name = name;
        this.price = price;
    }
    public String getName(){
        return this.name;
    }
    public int getPrice(){
        return this.price;
    }
}
//An Adapter over Map to create Inventory to hold cash and Items inside Vending Machine
class Inventory<T>{
    private Map<T,Integer> inventory = new HashMap<T,Integer>();
    
    public void add(T item){
        int value = inventory.getOrDefault(item,0);
        inventory.put(item,value+1);
    }
}

//A parameterized utility class to hold two objects.
class Bucket<E1,E2>{
    private E1 first;
    private E2 second;
    public Bucket(E1 first, E2 second){
        this.first = first;
        this.second = second;
    }
    public E1 getFirst(){
        return this.first;
    }
    public E2 getSecond(){
        return this.second;
    }
}

interface VendingMachine{
    public void insertCoin(Coin coin);
    public long selectItemAndGetPrice(Item item);
    public Bucket<Item,List<Coin>> collectItemAndChange();
}

class VendingMachineImp implements VendingMachine{
    private long currentBalance;
    public Item currentItem;
    private Inventory<Coin> cashInventory = new Inventory<Coin>();
    private Inventory<Item> itemInventory = new Inventory<Item>();
    
    @Override
    public void insertCoin(Coin coin){
        currentBalance = currentBalance + coin.getValue();
        cashInventory.add(coin);
    }
    @Override
    public long selectItemAndGetPrice(Item item){
        currentItem = item;
        return currentItem.getPrice();
    }
    @Override
    public Bucket<Item,List<Coin>> collectItemAndChange(){
        Item item = currentItem;
        
        long changeAmount = currentBalance - currentItem.getPrice();
        
        List<Coin> change = getChange(changeAmount);
        
        return new Bucket<Item,List<Coin>>(item,change); 
    }
    public List<Coin> getChange(long amount){
        List<Coin> changes = new ArrayList<Coin>();
        while (amount > 0){
            if (amount >= Coin.QUARTER.getValue()){
                changes.add(Coin.QUARTER);
                amount = amount - Coin.QUARTER.getValue();
                continue;
            }
            if (amount >= Coin.DIME.getValue()){
                changes.add(Coin.DIME);
                amount = amount - Coin.DIME.getValue();
                continue;
            }
            if (amount >= Coin.NICKLE.getValue()){
                changes.add(Coin.NICKLE);
                amount = amount - Coin.NICKLE.getValue();
                continue;
            }
            if (amount >= Coin.PENNY.getValue()){
                changes.add(Coin.PENNY);
                amount = amount - Coin.PENNY.getValue();
                continue;
            }
        }
        
        return changes;
    }
}

class VendingMachineFactory{
    public static VendingMachine createVendingMachine(){
        return new VendingMachineImp();
    }
}

public class SampleVendingMachineApp
{
    
	public static void main(String[] args) {
        
        VendingMachine vm = VendingMachineFactory.createVendingMachine();
        vm.insertCoin(Coin.QUARTER);
        vm.insertCoin(Coin.QUARTER);
        long price = vm.selectItemAndGetPrice(Item.SODA);
        System.out.println("Price is :" + price);
        Bucket<Item,List<Coin>> bucket = vm.collectItemAndChange();
        Item item = bucket.getFirst(); 
        List<Coin> change = bucket.getSecond();
	}

}

