package vn.example.properties_configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class PropertiesConfigurationApplication {
	@Value("${khoahoc.ten}")
	private String tenKhoaHoc;
	@Value("${khoahoc.giangvien}")
	private String tenGiangVien;
	@Value("${khoahoc.giatien}")
	private String giaTien;
	public static void main(String[] args) {
		SpringApplication.run(PropertiesConfigurationApplication.class, args);
	}
	@GetMapping("/")
	public String index(){
		return "Hello World";
	}
	@GetMapping("/info")
	public String info(){
		return "Tên khóa học: " + tenKhoaHoc +
				"Nguoi huong dan: "+tenGiangVien +
				"Gia tien: "+ giaTien +"đ";
	}
}
