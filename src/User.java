import java.sql.Connection;

public class User {

    private int id;
    private String username;
    private String password_hash;

    /*
        Para criar novos usuários não existentes no DB
     */
    public User(String new_username,String new_password_hash){
        this.username = new_username;
        this.password_hash = new_password_hash;
    }

    /*
        Para criar usuários já existentes no DB
     */
    public User(int new_id,String new_username,String new_password_hash){
        this.id = new_id;
        this.username = new_username;
        this.password_hash = new_password_hash;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }


}
