package category.product.mini.project.services;

import category.product.mini.project.entity.Product;
import category.product.mini.project.exception.ProductNotFoundException;
import category.product.mini.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public List<Product> retrieveAllProduct(int page)
    {
        PageRequest pageRequest=PageRequest.ofSize(page);
        Page<Product> productPage=productRepository.findAll(pageRequest);
        List<Product> products=productPage.getContent();
        return products;
    }

    public Optional<Product> retrieveOneProduct(int id)
    {
        Optional<Product> product=productRepository.findById(id);
        if(product.isEmpty())
            throw  new ProductNotFoundException("id : " +id);
        return product;
    }

    public  Product saveProduct(Product product)
    {
        Product p= productRepository.save(product);
        return  product;
    }

    public Product updateProduct(int id , Product product)
    {
        Optional<Product> findProduct=productRepository.findById(id);
        if(findProduct.isEmpty())
            throw  new ProductNotFoundException("id ="+ id);
        product.setProduct_Id(id);
        Product updateProduct =productRepository.save(product);
        return updateProduct;
    }

    public  void deleteProduct(int id)
    {
        productRepository.deleteById(id);
    }

}
