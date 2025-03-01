class Phone extends Item {
    private int quantitySold;

    public Phone(String name, double price, int quantitySold) {
        super(name, price);
        this.quantitySold = quantitySold;
    }

    @Override
    public double calculateTotalSales() {
        return getPrice() * quantitySold;
    }
}