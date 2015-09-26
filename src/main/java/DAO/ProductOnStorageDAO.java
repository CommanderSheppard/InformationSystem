package DAO;

import logic.ProductOnStorage;

import java.util.List;

/**
 * Created by Michael R. on 26.09.2015.
 * Feel free to contact me via misharj1993@gmail.com
 */

public interface ProductOnStorageDAO {
    public void AddProductToStorage(ProductOnStorage product);

    public void updateProductOnStorage(ProductOnStorage product);

    public ProductOnStorage getProductById(int id);

    public List getAllProducts();

    public void deleteProductFromStorage(ProductOnStorage product);
}
