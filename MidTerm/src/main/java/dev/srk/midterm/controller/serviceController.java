package dev.srk.midterm.controller;

import dev.srk.midterm.service.productService;
import org.springframework.web.bind.annotation.*;

@RestController
public class serviceController {

    productService ps;
    public serviceController(productService ps) {
        this.ps = ps;
    }

    @GetMapping()
    public String foo(){
        return "Welcome";
    }
//    @GetMapping("/carts")
//    public Object getCarts(){
////        return "hello";
//        return ps.getCarts();
//    }
    @GetMapping("/carts/{id}")
    public Object getCartById(@PathVariable long id){
        return ps.getCartByID(id);
    }
    @GetMapping("/carts/user/{id}")
    public Object getUserByID(@PathVariable long id){
        return ps.getUserByID(id);
    }
    @GetMapping("/carts")
    public Object getSortedProducts(@RequestParam(required = false) String startdate,@RequestParam(required = false) String enddate){
        if(startdate == null && enddate == null){
            return ps.getCarts();
        }
        else if(startdate == null){
            return ps.getByEndDate(enddate);
        }
        else if(enddate == null){
            return ps.getByStartDate(startdate);
        }
        else{
            return ps.getCarts();
        }


    }
    @PostMapping("/carts")
    public Object addCart(@RequestBody Object cart) {
        return ps.addCart(cart);
    }
    @PutMapping("/carts/{id}")
    public Object updateCart(@PathVariable Long id, @RequestBody Object cart) {
        return ps.updateCart(id, cart);
    }
    @DeleteMapping("/carts/{id}")
    public String deleteCart(@PathVariable Long id) {
        ps.deleteCart(id);
        return "Deleted SuccessFully";
    }

}