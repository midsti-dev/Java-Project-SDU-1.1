import java.lang.Exception;
import java.lang.String;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
public class Pizeria{
    public static Scanner sc = new Scanner(System.in);
    public static List<Customer> customers1 = new ArrayList<Customer>();
    public static PizzaStore Dodo = new PizzaStore(0, null, null);

    public static void main(String[] args) {
        int choice;
        boolean exit = false;
        boolean exit2 = false;
        while (!exit2) {
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    while (!exit) {
                        choice = sc.nextInt();
                        switch (choice) {
                            case 1:
                                Customer Kamila = new Customer(null, choice, null, null, choice);
                                Dodo.addCustomer(Kamila);
                                break;
                            case 2:                                
                                exit = true;
                                break;
                        }
                    }
                    break;
                case 2:
                
                    break;
                case 3:
                    exit2 = true;
                    break;
            }
        }
        for(int i = 0; i < Dodo.getCustomers().size(); i++){
            System.out.println(Dodo.getCustomers().toString());
        }

    }
}
class PizzaNotFoundException extends Exception
{
    PizzaNotFoundException(String mes){super(mes);}
}
class PizzaBase{
    private String description, baseType, baseName;
    PizzaBase(String newDescription, String newType, String newName){
        this.description = newDescription;
        this.baseType = newType;
        this.baseName = newName;
    }
    // Getters
    String getBaseName(){return this.baseName;}
    String getDescription(){return this.description;}
    String getBaseType(){return this.baseType;}
    // Setters
    void setBaseName(String newBaseName){this.baseName = newBaseName;}
    void setDescription(String newDescription){this.description = newDescription;}
    void setBaseType(String newBaseType){this.baseType = newBaseType;}
    //toString method Override
    @Override
    public String toString(){
        return "Name: "+ this.baseName + "\nType: " + this.baseType + "\nDescription: " + this.description;
    }
}
class Topping{
    private String description, spiceLevel, toppingName;
    Topping(String newDescription, String newSpiceLevel, String newToppingName){
        this.description = newDescription;
        this.spiceLevel = newSpiceLevel;
        this.toppingName = newToppingName;
    }
    //Getters
    String getTopping(){return this.toppingName;}
    String getSpiceLevel(){return this.spiceLevel;}
    String getDescription(){return this.description;}
    //Setters
    void setTopping(String newToppingName){this.toppingName = newToppingName;}
    void setSpiceLevel(String newSpiceLevel){this.spiceLevel = newSpiceLevel;}
    void setDescription(String newDescription){this.description = newDescription;}
    //toString method Override
    @Override
    public String toString() {
        return "Topping Name: " + this.toppingName + "\nSpice Level: " + this.spiceLevel + "\nDescription: " + this.description;
    }
}
class Pizza{
    private PizzaBase pizzaBase;
    private Topping topping;
    private String size, pizzaName;
    private double price;
    private int pizzaID;
    Pizza(PizzaBase newPizzaBase, Topping newTopping, String newSize, String newPizzaName, double newPrice, int newPizzaID){
        this.pizzaBase = newPizzaBase;
        this.topping = newTopping;
        this.size = newSize;
        this.pizzaName = newPizzaName;
        this.price = newPrice;
        this.pizzaID = newPizzaID;
    }
    //Getters
    PizzaBase getPizzaBase(){return this.pizzaBase;}
    Topping getTopping(){return this.topping;}
    String getSize(){return this.size;}
    String getPizzaName(){return this.pizzaName;}
    double getPrice(){return this.price;}
    int getPizzaID(){return this.pizzaID;}
    //Setters
    void setPizzaBase(PizzaBase newPizzaBase){this.pizzaBase = newPizzaBase;}
    void setTopping(Topping newTopping){this.topping = newTopping;}
    void setSize(String newSize){this.size = newSize;}
    void setPizzaName(String newPizzaName){this.pizzaName = newPizzaName;}
    void setPrice(double newPrice){this.price = newPrice;}
    void setPizzaID(int newPizzaID){this.pizzaID = newPizzaID;}
    //toString mehtod Override
    @Override
    public String toString() {
        return this.pizzaBase.toString() + 
        "\n" + this.topping.toString() + 
        "\nSize: " + this.size + 
        "\nPizzaName: " + this.pizzaName + 
        "\nPrice: " + this.price + 
        "\nPizza ID: " + this.pizzaID;
    }
}
class Order{
    private List<Pizza> pizzas = new ArrayList<Pizza>();
    private String orderDescription, orderDate;
    private double payableBillAmount;
    private int orderID;
    Order(){}
    Order(String newOrderDescription, String newOrderDate, double newPayableBillAmount, int newOrderID){
        this.orderDescription = newOrderDescription;
        this.orderDate = newOrderDate;
        this.payableBillAmount = newPayableBillAmount;
        this.orderID = newOrderID;
    }
    void addPizza(Pizza newPizza){this.pizzas.add(newPizza);}
    // Getters
    public int getOrderID(){return this.orderID;}
    public String getOrderDescription() {return orderDescription;}
    public String getOrderDate(){return this.orderDate;}
    public double getPayableBillAmount(){return this.payableBillAmount;}
    public List<Pizza> getPizzas() {return this.pizzas;}
    //Setters 
    public void setOrderID(int newOrderID){this.orderID = newOrderID;}
    public void setOrderDescription(String newOrderDescription){this.orderDescription = newOrderDescription;}
    public void setOrderDate(String newOrderDate){this.orderDate = newOrderDate;}
    public void setPayableBillAmount(double newPayableBillAmount){this.payableBillAmount = newPayableBillAmount;}
    public void setPizzas(List<Pizza> newPizzas){this.pizzas = newPizzas;}
    //toString method Override
    @Override
    public String toString() {
        String Bill = new String();
        Bill += "Order: \n";
        Bill += "Order ID: " + this.orderID + "\t" + "Order Date: " + this.orderDate + "\n";
        for(int i = 0; i < this.pizzas.size(); i++){Bill += this.pizzas.get(i).getPizzaName() + "\n";}
        Bill += "Payable Amount: " + this.payableBillAmount + "\n";
        Bill += "Order Descrition: " + this.orderDescription + "\n";
        return Bill;
    }
}
class Address{
    private String state, district, city, street;
    private int doorNumber;
    Address(String newState, String newDistrict, String newCity, String newStreet, int newDoorNumber){
        this.state = newState;
        this.district = newDistrict;
        this.city = newCity;
        this.street = newStreet;
        this.doorNumber = newDoorNumber;
    }
    //Getters
    String getState(){return this.state;}
    String getDistrict(){return this.district;}
    String getCity(){return this.city;}
    String getStreet(){return this.street;}
    int getDoorNumber(){return this.doorNumber;}
    //Setters
    void setState(String newState){this.state = newState;}
    void setDisctrict(String newDistrict){this.district = newDistrict;}
    void setCity(String newCity){this.city = newCity;}
    void setStreet(String newStreet){this.street = newStreet;}
    void setDoorNumber(int newDoorNumber){this.doorNumber = newDoorNumber;}
    //toString method Override
    @Override
    public String toString() {
        return "Adress: " + this.getState() + ", " + this.getCity() + ", " + this.getDistrict() + ", " + this.getStreet() + " Door Number: " + this.getDoorNumber() + "\n";
    }
}
class Customer{
    private List<Order> orders = new ArrayList<Order>();
    private Address address;
    private long mobile;
    private String email, customerName;
    private int customerID;
    Customer(Address newAddres, long newMobile, String newEmail, String newCustomerName, int newCustomerID){
        this.address = newAddres;
        this.mobile = newMobile;
        this.email = newEmail;
        this.customerName = newCustomerName;
        this.customerID = newCustomerID;
    }
    void addOrder(Order order){this.orders.add(order);}
    //Getters
    double getPayableBillAmount(){
        double all_in = 0;
        for(int i = 0; i < this.orders.size(); i++){
            all_in += this.orders.get(i).getPayableBillAmount();
        }
        return all_in;
    }
    int getCustomerID(){return this.customerID;}
    String getCustomerName(){return this.customerName;}
    String getEmail(){return this.email;}
    long getMobile(){return this.mobile;}
    Address getAddress(){return this.address;}
    List<Order> getOrders(){return this.orders;}
    //Setters
    void setCustomerID(int newCustomerID){this.customerID = newCustomerID;}
    void setCustomerName(String newCustomreName){this.customerName = newCustomreName;}
    void setEmail(String newEmail){this.email = newEmail;}
    void setAddress(Address newAddress){this.address = newAddress;}
    void setMobile(long newMobile){this.mobile = newMobile;}
    void setOrders(List<Order> newOrders){this.orders = newOrders;}
    //toString method Override
    @Override
    public String toString() {
        String output = new String();
        output += "Customer Name: " + this.getCustomerName() + "\n" +
        "ID: " + this.getCustomerID() + "\n" + 
        "Adress: " + this.getAddress() + "\n" +
        "Email: " + this.getEmail() + "\n" +
        "Mobile: " + this.getMobile() + "\n" + 
        "Orders: " + "\n";
        for(int i = 0; i < this.getOrders().size(); i++){
            output += this.getOrders().get(i).toString() + "\n";
        }
        return output;
    }
}
class PizzaStore{
    private List<Customer> customers = new ArrayList<Customer>();
    private List<Pizza> pizzas = new ArrayList<Pizza>();
    private String location, storeName;
    private int storeID;
    PizzaStore(){}
    PizzaStore(int newStoreID, String newStoreName, String newLocation){
        this.storeID = newStoreID;
        this.storeName = newStoreName;
        this.location = newLocation;
    }
    void addPizza(Pizza pizza){this.pizzas.add(pizza);}
    void addCustomer(Customer customer){this.customers.add(customer);}
    void deletePizza(Pizza pizza){this.pizzas.remove(pizza);}
    //Getters
    int getStoreID(){return this.storeID;}
    String getLocation(){return this.location;}
    String getStoreName(){return this.storeName;}
    List<Pizza> getPizzas(){return this.pizzas;}
    List<Customer> getCustomers(){return this.customers;}
    //Setters 
    void setCustomers(List<Customer> newCustomers){this.customers = newCustomers;}
    void setPizzas(List<Pizza> newPizzas){this.pizzas = newPizzas;}
    void setLocation(String newLocation){this.location = newLocation;}
    void setStoreName(String newStoreName){this.storeName = newStoreName;}
    void setStoreID(int newStoreID){this.storeID = newStoreID;}
    //toString method Override
    @Override
    public String toString() {
        String output = new String();
        output += 
        "Store name: " + this.getStoreName() + "\n" +
        "Store ID: " + this.getStoreID() + "\n" +
        "Store Locatoin: " + this.getLocation() + "\n" +
        "Pizzas: \n";
        for(int i = 0; i < this.getPizzas().size(); i++){output += this.getPizzas().get(i).getPizzaName() + "\n";}
        output += "Customers: \n";
        for(int i = 0; i < this.getCustomers().size(); i++){output += this.getCustomers().get(i).getCustomerName() + "\n";}
        return output;
    }
}
class PizzaService{
    String PizzaNotFoundMessage;
    PizzaStore pizzaStore;

    PizzaService(PizzaStore newPizzaStore){this.pizzaStore = newPizzaStore;}

    void deletePizza(Pizza pizza){this.pizzaStore.deletePizza(pizza);}
    // Pizza updatePizza(Pizza pizza, double newPrice) throws PizzaNotFoundException{
    //     int j;
    //     for(int i = 0; i < this.pizzaStore.getPizzas().size(); i++){
    //         if(this.pizzaStore.getPizzas().get(i).getPizzaID() == pizza.getPizzaID()){
    //             this.pizzaStore.getPizzas().get(i).setPrice(newPrice);
    //             j = i;
    //         }
    //     }
    //     if(j != 0){return this.pizzaStore.getPizzas().get(j);}
        
    // }

    Pizza getPizzaByName(String pizzaName){
        Pizza found = new Pizza(null, null, pizzaName, pizzaName, 0, 0);
        for(int i = 0; i < this.pizzaStore.getPizzas().size(); i++){
            if(this.pizzaStore.getPizzas().get(i).getPizzaName().equals(pizzaName)){
                found = this.pizzaStore.getPizzas().get(i);
            }
        }
        return found;
    }
    Pizza getPizzaByID(int pizzaID){
        Pizza found = new Pizza(null, null, null, null, 0, 0);
        for(int i = 0; i < this.pizzaStore.getPizzas().size(); i++){
            if(this.pizzaStore.getPizzas().get(i).getPizzaID() == pizzaID){
                found = this.pizzaStore.getPizzas().get(i);
            }
        }
        return found;
    }
    Pizza getPizzaBySize(String pizzaSize){
        Pizza found = new Pizza(null, null, null, null, 0, 0);
        for(int i = 0; i < this.pizzaStore.getPizzas().size(); i++){
            if(this.pizzaStore.getPizzas().get(i).getSize().equals(pizzaSize)){
                found = this.pizzaStore.getPizzas().get(i);
            }
        }
        return found;
    }

}   