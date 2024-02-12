package category.product.mini.project.Cotroller;

import category.product.mini.project.entity.Category;
import category.product.mini.project.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getAllCategory(@RequestParam int page)
    {
        return  categoryService.retrieveAllCategory(page);
    }

    @GetMapping("/categories/{id}")
    public Optional<Category> getCategory(@PathVariable int id)
    {
        return  categoryService.retrieveOneCategory(id);
    }

    @PostMapping("/categories")
    public Category saveCategory(@RequestBody Category category)
    {
        return  categoryService.saveCategory(category);
    }

    @PutMapping("/categories/{id}")
    public Category updateCategory(@PathVariable int id , @RequestBody Category category)
    {
        return  categoryService.updateCategory(id,category);
    }

    @DeleteMapping("categories/{id}")
    public void deleteCategory(@PathVariable  int id)
    {
        categoryService.deleteCategory(id);
    }

}
