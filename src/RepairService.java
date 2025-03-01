class RepairService extends Item {
    private int numberOfHours;

    public RepairService(String name, double price, int numberOfHours) {
        super(name, price);
        this.numberOfHours = numberOfHours;
    }

    @Override
    public double calculateTotalSales() {
        return getPrice() * numberOfHours;
    }
}