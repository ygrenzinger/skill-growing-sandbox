package com.carbon.skillsgrowing.front.web.api.category;

import com.carbon.ecommerce.domain.Category;
import com.carbon.ecommerce.domain.Item;
import com.carbon.skillsgrowing.front.web.model.Error;
import com.carbon.skillsgrowing.front.web.service.CategoryService;
import com.carbon.skillsgrowing.front.web.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@Controller()
@RequestMapping("/rest/categories")
public class CategoryResource {

    private static final Logger log = LoggerFactory.getLogger(CategoryResource.class);

    private CategoryService categoryService;
    private ProductService productService;

    @Inject
    public CategoryResource(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = {"application/json"})
    public ResponseEntity<CategoryResponse> createCategories(@RequestBody CategoryRequest request) {
        CategoryResponse response = new CategoryResponse();
        response.setCategoryRequest(request);
        if (!isValidateCategories(request)) {
            response.setError(new com.carbon.skillsgrowing.front.web.model.Error());
            response.error.setMessage("There are no categories to create !");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        List<Category> categories = categoryService.createCategories(request.categories);
        response.setCategories(categories);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<CategoryResponse> getAllCategories() {
        CategoryResponse response = new CategoryResponse();
        response.setCategories(categoryService.getCategories());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/products", method = RequestMethod.POST, produces = {"application/json"})
    public ResponseEntity<ProductResponse> createProductsByCategory(@PathVariable long id,
                                                                    @RequestBody ProductRequest request) {
        ProductResponse response = new ProductResponse();
        response.setProductRequest(request);
        Category category = categoryService.searchCategory(id);
        if (!isValidateItems(request, category)) {
            response.setError(new com.carbon.skillsgrowing.front.web.model.Error());
            response.error.setMessage("There are no products to create for the category " + id);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        List<Item> products = productService.createProducts(request.products, category);
        response.setProducts(products);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/products", method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<ProductResponse> getAllProductsForCategory(@PathVariable Integer id) {
        ProductResponse response = new ProductResponse();
        Category category = categoryService.searchCategory(id);
        if (category == null) {
            response.setError(new com.carbon.skillsgrowing.front.web.model.Error());
            response.error.setMessage("There are no products to search for the category " + id);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        response.setProducts(productService.getProducts());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private boolean isValidateCategories(CategoryRequest request) {
        return StringUtils.isEmpty(request.categories) ? false : true;
    }

    private boolean isValidateItems(ProductRequest request, Category category) {
        return StringUtils.isEmpty(request.products) || category == null  ? false : true;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CategoryResponse> handleCategoryException(Exception e){
        log.error("Technical exception occurred in category resource", e);
        CategoryResponse res = new CategoryResponse();
        res.setError(new Error());
        res.error.setMessage(e.getMessage());
        return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ProductResponse> handleProductException(Exception e) {
        log.error("Technical exception occurred in product resource", e);
        ProductResponse res = new ProductResponse();
        res.setError(new Error());
        res.error.setMessage(e.getMessage());
        return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

