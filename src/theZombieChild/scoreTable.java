package theZombieChild;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;


@Entity
@Table(name="scoretable") 
public class scoreTable implements Serializable{
    @Id
    @Column(name="partName")
    String partName;
    @Column(name="score")
    String score;

    
    public scoreTable() {
    }
    public scoreTable(String partName, String score) {
       
       this.partName= partName;
       this.score = score;
    }


    public String getPartName() {
        return partName;
    }

    public String getScore() {
        return score;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public void setPass(String score) {
        this.score= score;
    }

}
