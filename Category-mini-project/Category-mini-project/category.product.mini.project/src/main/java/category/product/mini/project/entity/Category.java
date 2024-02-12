package category.product.mini.project.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue
    @Column(name="c_id")
    private Integer category_id;
    @Size(min=2,message = "name should have at least 2 character")
    @Column(name="c_name")
    private String category_name;
    @Column(name="c_description")
    private  String category_description;
    @URL
    @Column(name="c_url")
    private String category_url;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="c_id",referencedColumnName ="c_id")
    private List<Product> products;
}
