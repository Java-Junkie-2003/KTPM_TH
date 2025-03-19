package StockMarket;

public class StockObserverDemo {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        Stock stockApple = new Stock("AAPL", 100.0);
        Stock stockGG = new Stock("GOOGL", 200.0);
        stockMarket.addStock(stockApple);
        stockMarket.addStock(stockGG);

        Investor investor1 = new Investor("Investor1");
        Investor investor2 = new Investor("Investor2");
        Investor investor3 = new Investor("Investor3");

        stockApple.registerObserver(investor1);
        stockApple.registerObserver(investor2);
        stockGG.registerObserver(investor2);
        stockGG.registerObserver(investor3);

        stockMarket.updateStockPrice("AAPL", 101.0);
        stockMarket.updateStockPrice("GOOGL", 201.0);
    }
}
