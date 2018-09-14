package javarush.test.modeldata;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "part")
public class Part implements Serializable {

    private static final long serialVersionUID = 35145646513L;

    @Id
    @Column(name = "Id")
    @GeneratedValue
    private Integer id=0;

    @Column(name = "Name")
    private String name;

    @Column(name = "Need")
    private boolean need;

    @Column(name = "Quant")
    private int quant;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNeed() {
        return need;
    }

    public void setNeed(boolean need) {
        this.need = need;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }
}

