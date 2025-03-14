import controller.UserController;
import entity.Users;

import java.util.Scanner;

public class Program {
    private static Scanner scanner = new Scanner(System.in);
    private static UserController userController = new UserController();
    public static void main(String[] args) {
        run();
    }

    public static void run(){
        Users user;
        System.out.println("Chào mừng bạn đã đến với Phần mềm!!!");
        System.out.println("====================================");
        System.out.println("Hãy đăng nhập để được vào hệ thống nhé");

        while (true){

            String email = check_email();

            String password = check_password();
            user = userController.login(email, password);
            if(user != null){
                System.out.println("Đăng nhập thành công. " );
                return;
            }
            else {
                System.out.flush();
                System.err.println("Lỗi đăng nhập!");
                System.err.println("Sai Email hặc Mật khẩu.");
            }

        }
    }
    private static String check_password() {

        while (true){
            System.out.println("Nhập password:");
            String password = scanner.nextLine().trim();
            if (password == null || password.length()<6 || password.length()>12 ){
                System.out.println("Hãy nhập lại password");
            } else  {
                return password;
            }
        }
    }

    public static String check_email() {
        while (true) {
            System.out.println("Nhập email:");
            String email = scanner.nextLine().trim();
            // Kiểm tra định dạng email hợp lệ
            if (email == null || email.isEmpty()) {
                System.out.println("Email không được để trống. Hãy nhập lại.");
                continue;
            }

            // Kiểm tra có chứa đúng một dấu '@'
            if (!email.contains("@") || email.indexOf("@") != email.lastIndexOf("@")) {
                System.out.println("Email phải chứa đúng một ký tự '@'. Hãy nhập lại.");
                continue;
            }

            // Kiểm tra không chứa khoảng trắng
            if (email.contains(" ")) {
                System.out.println("Email không được chứa khoảng trắng. Hãy nhập lại.");
                continue;
            }

            // Kiểm tra phần tên đăng nhập
            String[] parts = email.split("@");
            String username = parts[0];
            String domain = parts[1];

            if (username.length() < 6 || username.length() > 64) {
                System.out.println("Tên đăng nhập phải có từ 6 đến 64 ký tự. Hãy nhập lại.");
                continue;
            }

            if (!username.matches("^[a-zA-Z0-9._-]+$")) {
                System.out.println("Tên đăng nhập chỉ được chứa chữ cái, số, '.', '-', '_'. Hãy nhập lại.");
                continue;
            }

            if (username.startsWith(".") || username.endsWith(".") || username.contains("..")
                    || username.startsWith("_") || username.endsWith("_") || username.contains("__")
                    || username.startsWith("-") || username.endsWith("-") || username.contains("--")) {
                System.out.println("Tên đăng nhập không được bắt đầu/kết thúc bằng dấu '.', '-', '_' hoặc chứa hai dấu đặc biệt liên tiếp. Hãy nhập lại.");
                continue;
            }

            return email;
        }
    }



}
