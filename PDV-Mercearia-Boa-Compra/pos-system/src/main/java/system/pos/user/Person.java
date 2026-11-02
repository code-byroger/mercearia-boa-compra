package system.pos.user;

public class Person {
    private String name;
    private int age;
    private String cpf;
    private char sex;

    //builder
    public Person(
            String name, int age, String cpf, char sex
    ){
        this.name = name;
        this.age = age;
        this.cpf = cpf;
        this.sex = sex;
    }
    public Person(){}


    //get set
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setAge(int  age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    public String getCpf(){
        return this.cpf;
    }

    public void setSex(char sex){
        this.sex = sex;
    }
    public char getSex(){
        return this.sex;
    }

}
