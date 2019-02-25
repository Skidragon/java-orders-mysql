package com.lambdaschool.ordersmysql.controllers;

import com.lambdaschool.ordersmysql.models.Customer;
import com.lambdaschool.ordersmysql.repositories.CustomerRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path={"/customers"}, produces= MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {
    @Autowired
    CustomerRepository custRepo;

    @ApiOperation(value = "List All Customers", response = List.class)
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Successfully retrieves list"),
            @ApiResponse(code = 401, message = "You are not authorized to the view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("")
    public List<Customer> allCustomers() {
        return custRepo.findAll();
    }

    @GetMapping("custcode/{customercode}")
    public Customer findCustomerByCode(@PathVariable long customercode) {
        return custRepo.findCustomerByCode(customercode);
    }

    @GetMapping("order")
    public List<Object[]> allCustomersWithOrders() {
        return custRepo.findAllCustomersWithOrders();
    }
    @GetMapping("name/{name}")
    public List<Object[]> getCustomerByName(@PathVariable String name) {
        return custRepo.findCustomerByNameWithOrders(name);
    }
    @GetMapping("order/{name}")
    public List<Object[]> getCustomerByNameWithAllOrders(@PathVariable String name) {
        return custRepo.findCustomerByNameWithOrders(name);
    }
    @PutMapping("custcode/{customercode}")
    public Customer updateCustomer(@RequestBody Customer updatedCustomer, @PathVariable long customercode) throws URISyntaxException {
        Optional<Customer> foundCustomer = custRepo.findById(customercode);
        if(foundCustomer.isPresent()) {
            updatedCustomer.setCustomercode(customercode);
            custRepo.save(updatedCustomer);
            return updatedCustomer;
        }
        return null;
    }

    @DeleteMapping("custcode/{customercode}")
    public Customer deleteCustomer(@PathVariable long customercode) {
        Customer foundCustomer = custRepo.findCustomerByCode(customercode);
        if (foundCustomer != null) {
            custRepo.deleteById(customercode);
            return foundCustomer;
        }
        return null;
    }
}
