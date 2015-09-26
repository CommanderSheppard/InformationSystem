package DAO;

import logic.Product;

import java.util.List;

/**
 * Created by Michael R. on 26.09.2015.
 * Feel free to contact me via misharj1993@gmail.com
 */

public interface ProductDAO {
    public void AddProduct(Product product);

    public void updateProduct(Product product);

    public Product getProductById(int id);

    public List getAllProducts();

    public void deleteProduct(Product product);
}
