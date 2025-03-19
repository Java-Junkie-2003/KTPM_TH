package StockMarket;

public interface Observer {
    void update(String stockSymbol, double price);
}
