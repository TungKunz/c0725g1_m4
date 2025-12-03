package org.example.san_pham.repository;


import org.example.san_pham.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository{
    static List<Product> listProduct=new ArrayList<>();
    static {
        listProduct.add(new Product(1,"Tùng",123,"Huế"));
        listProduct.add(new Product(2,"Tú",123,"Huế"));
        listProduct.add(new Product(3,"Lâm",123,"Huế"));
        listProduct.add(new Product(4,"Hoàng",123,"Đà Nẵng"));
        listProduct.add(new Product(5,"Khánh",123,"Quảng Nam"));
        listProduct.add(new Product(6,"Nguyên",123,"Quảng Nam"));
    }
    @Override
    public List<Product> getAllProduct() {
        return listProduct;
    }

    @Override
    public boolean addProduct(Product product) {
        return listProduct.add(product);
    }

    @Override
    public boolean deleteProduct(Product product) {
        List<Product> products=getAllProduct();
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getId() == product.getId()){
                products.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean editProduct(Product product) {
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getId() == product.getId()) {
                listProduct.set(i, product);
                return true;
            }
        }
        return false;
    }

    @Override
    public Product getById(int id) {
        List<Product> productList=getAllProduct();
        for (Product p:productList){
            if(p.getId()==id){
                return p;
            }
        }
        return null;
    }
}
