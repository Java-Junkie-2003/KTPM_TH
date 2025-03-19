package StockMarket;

import java.util.ArrayList;
import java.util.List;

public class Stock implements Subject {
    private String symbol;
    private double Price;
    private List<Observer> observers;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.Price = price;
        this.observers = new ArrayList<>();
    }
    public void setPrice(double price){
        if(this.Price != price){
            this.Price = price;
            notifyObservers();
        }
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return Price;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers){
            observer.update(symbol, Price);
        }
    }
}
