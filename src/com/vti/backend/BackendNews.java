package com.vti.backend;
import com.vti.entity.News;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BackendNews {
    // Thuộc tính:
    List<News> news;
    Scanner scanner;

    // Hàm khởi tạo của class BackendNews
    public BackendNews(){
        news = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Phương thức in menu ra màn hình:
    private void displayMenu(){
        System.out.println("\n========== Please Choose =========");
        System.out.println("1 - Insert News");
        System.out.println("2 - View List News");
        System.out.println("3 - Average Rate Calculate");
        System.out.println("4 - Exit");
        System.out.println("==================================\n");
    }

    // Hàm run chính của chương trình:
    public void runProgram(){
        while(true){
            displayMenu();
            int choose = scanner.nextInt();
            switch (choose){
                case 1:
                    // Thực hiện chức năng Insert News
                    insertNews();
                    break;
                case 2:
                    // Thực hiện chức năng View List News
                    printListNews();
                    break;
                case 3:
                    // Thực hiện chức năng Average Rate
                    calculateAverageRates();
                    break;
                case 4:
                    // Thực hiện thoát khỏi chương trình
                    System.out.println("Program exit ! Bye Bye");
                    return;
                default:
                    System.out.println("Vui lòng chọn từ 1 -> 4");
            }
        }
    }

    // Hàm thực hiện chức năng insert News vào danh sách:
    private void insertNews(){
        System.out.println("Mời nhập Title: ");
        scanner.nextLine();
        String inputTitle = scanner.nextLine();
        System.out.println("Mời nhập Publish Date: ");
        String inputPublishDate = scanner.nextLine();
        System.out.println("Mời nhập Author: ");
        String inputAuthor = scanner.nextLine();
        System.out.println("Mời nhập Content: ");
        String inputContent = scanner.nextLine();

        System.out.println("Mời nhập đánh giá thứ nhất: ");
        int rate1 = scanner.nextInt();
        System.out.println("Mời nhập đánh giá thứ hai: ");
        int rate2 = scanner.nextInt();
        System.out.println("Mời nhập đánh giá thứ ba: ");
        int rate3 = scanner.nextInt();
        int[] rates = {rate1, rate2, rate3};

        // Tạo đối tượng News:
        News tempNews = new News(inputTitle, inputPublishDate, inputAuthor, inputContent, rates);
        // Gán đối tượng News vừa tạo vào danh sách:
        news.add(tempNews);
    }

    // Hàm thực hiện chức năng in danh sách các News:
    private void printListNews(){
        for (News n : news){
            n.display();
            System.out.println("-----------------------\n");
        }
    }

    // Hàm thực hiện chức năng tính đánh giá trung bình Average Rates:
    private void calculateAverageRates(){
        for (News n : news){
            n.calculate();
        }
        System.out.println("Calculate Done For List News");
    }

}