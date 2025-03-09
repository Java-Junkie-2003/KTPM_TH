package TaxSystemForProduct;

interface Product {
    double getPrice();
    String getDescription();
}

class ProductImpl implements Product{

    private String name;
    private double price;

    public ProductImpl(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getDescription() {
        return this.name;
    }
}

abstract class TaxDecorator implements Product {
    protected Product product;

    public TaxDecorator(Product product) {
        this.product = product;
    }

    @Override
    public String getDescription() {
        return product.getDescription();
    }
}

class ConsumptionTaxDecorator extends TaxDecorator {

    public ConsumptionTaxDecorator(Product product) {
        super(product);
    }

    @Override
    public double getPrice() {
        return product.getPrice() + (product.getPrice() * 0.1);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with Consumption Tax (10%)";
    }
}

class VATDecorator extends TaxDecorator {

    public VATDecorator(Product product) {
        super(product);
    }

    @Override
    public double getPrice() {
        return product.getPrice() + (product.getPrice() * 0.02);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with VAT (2%)";
    }
}

class LuxuryTaxDecorator extends TaxDecorator {

    public LuxuryTaxDecorator(Product product) {
        super(product);
    }

    @Override
    public double getPrice() {
        return product.getPrice() + (product.getPrice() * 0.2);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with Luxury Tax (20%)";
    }
}

class Client {
    public static void main(String [] arg){
        Product laptop = new ProductImpl("Laptop", 1000);
        Product laptopWithVAT = new VATDecorator(laptop);
        Product laptopWithVATAndLuxuryTax = new LuxuryTaxDecorator(laptopWithVAT);
        Product laptopWithVATAndLuxuryTaxAndConsumptionTax = new ConsumptionTaxDecorator(laptopWithVATAndLuxuryTax);
        System.out.println(laptopWithVATAndLuxuryTaxAndConsumptionTax.getDescription());
        System.out.println("Giá cuối: "+laptopWithVATAndLuxuryTaxAndConsumptionTax.getPrice());
    }
}