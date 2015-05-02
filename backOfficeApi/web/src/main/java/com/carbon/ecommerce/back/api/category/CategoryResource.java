package com.carbon.ecommerce.back.api.category;

import com.carbon.ecommerce.back.service.CategoryService;
import com.carbon.ecommerce.back.service.ProductService;
import com.carbon.ecommerce.backoffice.api.*;
import com.carbon.ecommerce.domain.Team;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
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

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = {"application/json"}, consumes = {"application/json", "application/xml"})
    public ResponseEntity<TeamResponse> getAllCategories() {
        TeamResponse response = new TeamResponse();
        List<com.carbon.ecommerce.backoffice.api.Team> categories = categoryService.getCategories();
        if (categories == null || categories.size() <= 0) {
            response.setError(new BackOfficeError());
            response.getError().setMessage("No categories found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        response.getCategories().addAll(categories);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<TeamResponse> createCategories(@RequestBody TeamRequest request) {
        TeamResponse response = new TeamResponse();
        response.setRequest(request);
        if (!isValidateCategories(request)) {
            response.setError(new BackOfficeError());
            response.getError().setMessage("There are no categories to create !");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        List<com.carbon.ecommerce.backoffice.api.Team> categories = categoryService.createCategories(CategoryRequestBuilder.newBuilder().withCategories(request.getCategories()).build());
        response.getCategories().addAll(categories);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/products", method = RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<ProductResponse> createProductsByTeam(@PathVariable long id,
                                                                @RequestBody ProductRequest request) {
        ProductResponse response = new ProductResponse();
        response.setRequest(request);
        Team team = categoryService.searchTeam(id);
        if (!isValidateItems(request, team)) {
            response.setError(new BackOfficeError());
            response.getError().setMessage("There are no products to create for the team " + id);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        List<Product> products = productService.createProducts(ProductBuilder.newBuilder().withProducts(request.getProducts()).build(), team);
        response.getProducts().addAll(products);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/products", method = RequestMethod.GET, produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<ProductResponse> getAllProductsForTeam(@PathVariable Integer id) {
        ProductResponse response = new ProductResponse();
        Mapper mapper = new DozerBeanMapper();
        Team team = categoryService.searchTeam(id);
        if (team == null) {
            response.setError(new BackOfficeError());
            response.getError().setMessage("There are no products to search for the team " + id);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        for (com.carbon.ecommerce.domain.Item item : team.getItems()) {
            response.getProducts().add(mapper.map(item, com.carbon.ecommerce.backoffice.api.Product.class));
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private boolean isValidateCategories(TeamRequest request) {
        return !StringUtils.isEmpty(request.getCategories());
    }

    private boolean isValidateItems(ProductRequest request, Team team) {
        return !(StringUtils.isEmpty(request.getProducts()) || team == null);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<TeamResponse> handleTeamException(Exception e) {
        log.error("Technical exception occurred in team resource", e);
        TeamResponse res = new TeamResponse();
        res.setError(new BackOfficeError());
        res.getError().setMessage(e.getMessage());
        return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

