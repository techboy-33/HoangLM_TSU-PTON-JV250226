package Session_12.bai_1.business;

import Session_12.bai_1.exception.ProductNotFoundException;

import java.util.Scanner;

public interface IProductBusiness {
    void addProduct (Scanner scanner);
    void displayProduct ();
    void findProductById (String id) throws ProductNotFoundException;
}
