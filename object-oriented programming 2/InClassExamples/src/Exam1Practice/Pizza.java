package Exam1Practice;

/**
 * Keep track of pizzas and their toppings.
 * @author thomas.szymczak
 */
public class Pizza {
    private int diameter;
    private double price;
    private String toppings;
    private static int pizzaCount;
    
    public Pizza(int size, String description) {
        setDiameter(size);
        setToppings(description);
        price = calculatePrice(diameter, toppings);
        pizzaCount++;
    }
    
    public void setDiameter(int amt) {
        if ( amt == 9 || amt == 12 || amt == 16 )
            diameter = amt;
        else
            diameter = 0;
    }
    
    public int getDiameter() {
        return diameter;
    }
    
    public void setPrice(double amt) {
        if ( amt >= 5.95 && amt <= 10.95 )
            price = amt;
        else
            price = 0;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setToppings(String str) {
        String[] validToppings = {"Green Pepper", "Mushroom", "Sausage",
            "Pepperoni", "Plain" };
        boolean valid = false;
        for (int i = 0; i < validToppings.length; i++) {
            if (str.equals(validToppings[i]))
                    valid = true;
        }
        
        if ( valid ) {
            toppings = str;
        } else {
            System.err.println("Topping \"" + str + "\" is not a valid topping.");
            toppings = "Plain";
        }
    }
    
    public String getToppings() {
        return toppings;
    }
    
    public static int getPizzaCount() {
        return pizzaCount;
    }
    
    private static double calculatePrice(int size, String top) {
        if ( size == 9 ) {
            if ( top.equals("Plain") ) {
                return 5.95;
            } else {
                return 6.95;
            }
        } else if (size == 12) {
            if (top.equals("Plain") ) {
                return 7.95;
            } else {
                return 8.95;
            }
        } else if (size == 16) {
            if (top.equals("Plain") ) {
                return 9.95;
            } else {
                return 10.95;
            }
        } else {
            return 0;
        }
    }
    
    public String toString() {
        String output = "You have ordered a " + diameter +
                " inch pizza with " + toppings + " topping and a price of $ " +
                price;
        return output;
    }
    
}
