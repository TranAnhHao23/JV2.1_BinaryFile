package product_manage;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Manage manage = new Manage();
        final String PATH_NAME = "src/product_manage/save.csv";
        int choice;
        do {
            System.out.println("Menu");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa sản phẩm theo ID");
            System.out.println("3. Xóa sản phẩm theo ID");
            System.out.println("4. Hiển thị sản phẩm theo ID");
            System.out.println("5. Hiển thị toàn bộ sản phẩm");
            System.out.println("6. Ghi vào file CSV");
            System.out.println("7. Đọc ra file CSV");
            System.out.println("0. Thoát chương trình");
            System.out.println("Nhập lựa chọn");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    manage.addProduct();
                    break;
                case 2:
                    System.out.println("Nhập ID cần sửa: ");
                    int idEdit = sc.nextInt();
                    manage.editProduct(idEdit);
                    break;
                case 3:
                    System.out.println("Nhập ID cần xóa: ");
                    int idDelete = sc.nextInt();
                    manage.deleteProduct(idDelete);
                    break;
                case 4:
                    System.out.println("Nhập ID cần hiển thị: ");
                    int idDisplay = sc.nextInt();
                    manage.displayProductByID(idDisplay);
                    break;
                case 5:
                    for (Product product : manage.displayProducts()) {
                        System.out.println(product);
                    }
                    manage.displayProducts();
                    break;
                case 6:
                    manage.writeProduct(manage.displayProducts(), PATH_NAME);
                    break;
                case 7:
                    ArrayList<Product> products = manage.readProduct(PATH_NAME);
                    for (Product product : products) {
                        System.out.println(product);
                    }
                    break;
                case 0:
                    System.out.println("Hẹn gặp lại lần sau <3");
                    break;
                default:
                    System.out.println("Sai lựa chọn, nhập lại!!!");
                    break;
            }
        } while (choice != 0);
    }
}
