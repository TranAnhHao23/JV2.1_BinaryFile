package product_manage;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Manage implements Serializable {
    ArrayList<Product> products = readProduct("src/product_manage/save.csv");
    Scanner sc = new Scanner(System.in);

    public Manage() {
    }

    public Product creatProduct() {
        System.out.println("Nhập tên sản phẩm: ");
        String name = sc.nextLine();
        System.out.println("Nhập hãng sản xuất: ");
        String brand = sc.nextLine();
        System.out.println("Nhập giá thành sản phẩm: ");
        double price = sc.nextDouble();
        sc.nextLine();
        return new Product(name, brand, price);
    }

    public void addProduct() {
        products.add(creatProduct());
    }

    public void editProduct(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.set(i, creatProduct());
                products.get(i).setId(id);
                Product.ID--;
            }
        }
    }

    public void deleteProduct(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);
            }
        }
    }

    public void displayProductByID(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                System.out.println(products.get(i));
            }
        }
    }

    public ArrayList<Product> displayProducts() {
        return products;
    }

    public void writeProduct(ArrayList<Product> productsNew, String pathName) {
//        ArrayList<Product> productsExist = readProduct(pathName);
//        productsExist.add(new Product("6","6",6));
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(pathName));
            objectOutputStream.writeObject(productsNew);
            objectOutputStream.close();
            System.out.println("Ghi thành công!!!");
        } catch (IOException e) {
            System.err.println(e.getMessage() + "Ghi thất bại");
        }
    }

    public ArrayList<Product> readProduct(String pathName) {
        ArrayList<Product> products1 = new ArrayList<>();
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(pathName));
//            objectInputStream.readObject();
            products1 = (ArrayList<Product>) objectInputStream.readObject();
        } catch (IOException | ClassCastException e) {
            System.err.println();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return products1;
    }
}
