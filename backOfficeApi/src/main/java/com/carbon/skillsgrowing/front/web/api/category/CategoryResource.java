package com.carbon.skillsgrowing.front.web.api.category;

import com.carbon.skillsgrowing.front.web.model.Error;
import com.carbon.skillsgrowing.front.web.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@Controller()
@RequestMapping("/rest/categories")
public class CategoryResource {

    private static final Logger log = LoggerFactory.getLogger(CategoryResource.class);

    private CategoryService categoryService;

    @Inject
    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
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
        categoryService.createCategories(request.categories);
        return null;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<CategoryResponse> getAllCategories() {

        return null;
    }

    @RequestMapping(value = "/{id}/products", method = RequestMethod.POST, produces = {"application/json"})
    public ResponseEntity<CategoryResponse> createProductsByCategory(@RequestBody ProductRequest request) {

        return null;
    }

    @RequestMapping(value = "/{id}/products", method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<CategoryResponse> getAllProductsForCategory(@PathVariable Integer id) {

        return null;
    }

    private boolean isValidateCategories(CategoryRequest request) {
        return StringUtils.isEmpty(request.categories) ? false : true;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CategoryResponse> handleException(Exception e){
        log.error("Technical exception occured in category resource", e);
        CategoryResponse res = new CategoryResponse();
        res.setError(new Error());
        res.error.setMessage(e.getMessage());
        return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

