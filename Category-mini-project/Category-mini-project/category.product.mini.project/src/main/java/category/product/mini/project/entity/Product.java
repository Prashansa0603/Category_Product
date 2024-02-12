package category.product.mini.project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue
    @Column(name="p_id")
    private  Integer product_Id;
    @Size(min=3,message = " Product Title should have at least 3 character")
    @Column(name="p_Title")
    private  String product_Title;
    @Column(name="p_Description")
    private  String product_Description;
    @NotNull
    @Column(name="p_Quantity")
    private String product_Quantity;
    @NotNull
    @Column(name="p_Price")
    private long product_Price;
    @Column(name="p_Brand")
    private String product_Brand;

}
