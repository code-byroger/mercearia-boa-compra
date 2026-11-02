package system.pos.model;

public class Product {
    private long id;
    private String barcode;
    private String name;
    private String price;
    private String stok;
    private String weight;
    private int amount;
    private boolean available;

    //builder
    public Product(
            long id,String barcode, String name, String price,
            String stok, String weight, int amount, boolean available
    ){
        this.id = id;
        this.barcode = barcode;
        this.name = name;
        this.price = price;
        this.stok = stok;
        this.weight = stok;
        this.amount = amount;
        this.available = available;
    }
    public Product(){}

    @Override
    public String toString(){
        return "ID: "+ this.id + "| Código de barras: " + this.barcode + "| Nome: " + this.name + "| Preço: R$ " + this.price +
                "| Estoque: " + this.stok + "| Peso: " + this.weight + " kg" + "| Disponível: " + (this.available ? "Sim" : "Não") + "\n";
    }

    //get set

    public void setId(long id){
        this.id = id;
    }
    public long getId(){
        return this.id;
    }

    public void setBarcode(String barcode){
        this.barcode = barcode;
    }
    public String getBarcode(){
        return this.barcode;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setPrice(String price){
        this.price = price;
    }
    public String getPrice(){
        return this.price;
    }

    public void setStok(String stok){
        this.stok = stok;
    }
    public String getStok(){
        return this.stok;
    }


    public void setWeight(String weight){
        this.weight = weight;
    }
    public String getWeight(){
        return this.weight;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }
    public int getAmount(){
        return this.amount;
    }

    public void isAvalaible(boolean available){
        this.available = available;
    }
    public boolean getAvalaible(){
        return this.available;
    }


}
