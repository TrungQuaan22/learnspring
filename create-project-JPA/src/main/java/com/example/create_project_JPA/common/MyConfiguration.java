package com.example.create_project_JPA.common;

import com.example.create_project_JPA.dao.SinhVienDAOimpl;
import com.example.create_project_JPA.entity.SinhVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

@Configuration
public class MyConfiguration {
    @Bean
    @Autowired
    public CommandLineRunner getRunner(SinhVienDAOimpl sinhVienDAOimpl ) {
        return runner -> {
            Scanner scanner = new Scanner(System.in);
            while(true){
                printMenu();
                int option = scanner.nextInt();
                scanner.nextLine();
                if(option == 1){
                    System.out.println("Bạn đã chọn chức năng thêm sinh viên mới");
                    themSinhVien(sinhVienDAOimpl);
                } else if (option ==2) {
                    System.out.println("Bạn đã chọn chức năng tìm sinh viên theo id");
                    SinhVien sv = timSinhVienTheoId(sinhVienDAOimpl);
                    if (sv != null) {
                        System.out.println(sv);
                    } else {
                        System.out.println("Không tìm thấy sinh viên");
                    }
                } else if (option == 3) {
                    System.out.println("Bạn đã chọn tìm kiếm sinh viên theo tên:");
                    List<SinhVien> sv =  timSinhVienTheoTen(sinhVienDAOimpl);
                    if (sv != null) {
                        System.out.println(sv);
                    } else {
                        System.out.println("Không tìm thấy sinh viên");
                    }
                } else if (option == 4) {
                    System.out.println("Danh sách sinh viên: ");
                    System.out.println(sinhVienDAOimpl.getAll());
                } else if (option == 5) {
                    System.out.println("Bạn đã chọn chức năng cập nhật sinh viên dựa trên id");
                    capNhatTheoId(sinhVienDAOimpl);
                } else if (option == 6) {
                    System.out.println("Bạn đã chọn chức năng xóa sinh viên");
                    System.out.println("Nhập điều kiện: ");
                    Scanner sc = new Scanner(System.in);
                    String condition = sc.nextLine();
                    sinhVienDAOimpl.deleteByCondition(condition);
                }

            }
        };
    }

    private List<SinhVien> timSinhVienTheoTen(SinhVienDAOimpl sinhVienDAOimpl) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        List<SinhVien> sv = sinhVienDAOimpl.getByName(name);
        return sv;
    }
    private SinhVien nhapThongTinSinhVien() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập họ đệm: ");     String ho_dem = scanner.nextLine();
        System.out.println("Nhập tên: ");    String ten = scanner.nextLine();
        System.out.println("Nhập email: ");    String email = scanner.nextLine();
        SinhVien sv = new SinhVien(ho_dem, ten, email);
        return sv;
    }

    private void themSinhVien(SinhVienDAOimpl sinhVienDAOimpl) {

        SinhVien sv = nhapThongTinSinhVien();
        sinhVienDAOimpl.save(sv);
    }

    private void capNhatTheoId(SinhVienDAOimpl sinhVienDAOimpl) {
        SinhVien sv = timSinhVienTheoId(sinhVienDAOimpl);
        if (sv != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập họ đệm: ");     String ho_dem = scanner.nextLine();
            System.out.println("Nhập tên: ");    String ten = scanner.nextLine();
            System.out.println("Nhập email: ");    String email = scanner.nextLine();
            sv.setEmail(email);
            sv.setHoDem(ho_dem);
            sv.setTen(ten);
            sinhVienDAOimpl.update(sv);
        }
        else {
            System.out.println("Không tìm thấy sinh viên");
        }
    }


    private SinhVien timSinhVienTheoId(SinhVienDAOimpl sinhVienDAOimpl) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vui lòng nhập mã số sinh viên: ");
        int idSV = scanner.nextInt();
        SinhVien sv = sinhVienDAOimpl.getById(idSV);
        return sv;
    }

    public void printMenu(){
        System.out.println("--------- Menu-------");
        System.out.println(" 1. Thêm sinh viên");
        System.out.println(" 2. Tìm kiếm sinh viên theo id: ");
        System.out.println(" 3. Tìm kiếm sinh viên theo tên");
        System.out.println(" 4. Hiển thị tất cả sinh viên");
        System.out.println(" 5. Cập nhật sinh viên dựa trên id");
        System.out.println(" 6. Xóa sinh viên");
        System.out.println(" 7. Thoát");
        System.out.println(" Lựa chọn của bạn là: ");
    }
}
