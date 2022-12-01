package theZombieChild;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;


@Entity
@Table(name="nametable") 
public class nameTable implements Serializable{
    @Id
    @Column(name="name")
    String name;
    @Column(name="password")
    String password;

    
    public nameTable() {
    }
    public nameTable(String name, String password) {
       
       this.name= name;
       this.password = password;
    }


    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPass(String password) {
        this.password= password;
    }

}
