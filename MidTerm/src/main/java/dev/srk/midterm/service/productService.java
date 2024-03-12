package dev.srk.midterm.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class productService {
    RestTemplate rt = new RestTemplate();
    String url = "https://fakestoreapi.com";

    public Object getCarts(){
        return rt.getForObject(url+"/carts" , Object.class);
    }
    public Object getCartByID(long id){
        return rt.getForObject(url+"/carts/"+id, Object.class);
    }
    public Object getUserByID(long id){
        return rt.getForObject(url+"/carts/user/"+id , Object.class);
    }

    public Object getByEndDate(String enddate) {
        return rt.getForObject(url+"/carts?enddate="+enddate, Object.class);
    }
    public Object getByStartDate(String startdate){
        return rt.getForObject(url+"/carts?startdate="+startdate, Object.class);
    }

    public Object getByStartAndEndDates(String startdate, String enddate) {
        return rt.getForObject(url+"/carts?startdate="+startdate+"&enddate="+enddate, Object.class);
    }
    public Object addCart(Object product) {
        return rt.postForObject(url+"/carts", product, Object.class);
    }
    public Object updateCart(Long id, Object product) {
        rt.put(url+"/carts/"+id, product);
        return getCartByID(id);
    }
    public void deleteCart(Long id) {

        rt.delete(url+"/carts/"+id);
    }
//    public Object getSortedCarts(String sort){
//        System.out.println(sort);
//        if(sort.equals("desc")){
//            return rt.getForObject(url+"/carts?sort=desc", Object.class);
//        }
//        else{
//            return getCarts();
//        }
//    }
}
