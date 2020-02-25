package jpabook.merchandiseManagement.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
@Setter @Getter
public class Item {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private int price;

    private List<Category>


}
