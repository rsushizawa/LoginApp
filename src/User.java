import java.sql.Connection;

public class User {

    private int id;
    private String username;
    private String password;

    /*
        Para criar novos usuários não existentes no DB
     */
    public User(String new_username,String new_password){
        this.username = new_username;
        this.password = new_password;
    }

    /*
        Para criar usuários já existentes no DB
     */
    public User(int new_id,String new_username,String new_password){
        this.id = new_id;
        this.username = new_username;
        this.password = new_password;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
