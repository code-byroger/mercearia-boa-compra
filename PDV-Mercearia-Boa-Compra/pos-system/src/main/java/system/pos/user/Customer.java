package system.pos.user;


public class Customer extends Person{
    private int points;


    public Customer(String name, int age, String cpf, char sex){
        super(name, age, cpf, sex);
    }

    public int getPoints(){
        return points;
    }


}

