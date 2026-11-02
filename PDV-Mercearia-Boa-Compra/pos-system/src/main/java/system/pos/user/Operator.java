package system.pos.user;
import system.pos.user.Person;

public class Operator extends Person {
    private String login;
    private String password;

    public Operator(String login ){
        this.login = login;
    }

    public Operator(){}

    public void setLogin(String login){
        this.login = login;
    }
    public String getLogin(){
        return this.login;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }

}
