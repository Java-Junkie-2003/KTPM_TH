package StockMarket;

import java.util.HashMap;
import java.util.Map;

public class StockMarket {
    private Map<String, Stock> stocks;

    public StockMarket(){
        this.stocks = new HashMap<String, Stock>();
    }

    public void addStock(Stock stock){
        stocks.put(stock.getSymbol(), stock);
    }
    public Stock getStock(String symbol){
        return stocks.get(symbol);
    }

    public void updateStockPrice(String symbol, double price){
        Stock stock = stocks.get(symbol);
        if(stock != null) {
            stock.setPrice(price);
        }else{
            System.out.println("Stock not found: " + symbol );
        }
    }
}
