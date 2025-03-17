import controller.TeacherController;
import controller.UserController;
import controller.VocabularyController;
import entity.Teachers;
import entity.Users;
import entity.Vocabulary;

import java.util.List;
import java.util.Scanner;

public class Program {
    private static Scanner scanner = new Scanner(System.in);
    private static UserController userController = new UserController();
    private static TeacherController teacherController = new TeacherController();
    private static VocabularyController vocabularyController = new VocabularyController();
    private static List<Vocabulary> vocabularyList = vocabularyController.getAllVocabulary();

    public static void main(String[] args) {
        run();
    }

    public static void run(){
        Users user;
        Teachers teacher ;
        System.out.println("単語管理ソフトへようこそ！");
        System.out.println("たんごかんりソフトへようこそ！");
        System.out.println("====================================");
        System.out.println("ソフトに入るためにログインしてください");

        while (true){

            String email = check_email();

            String password = check_password();
            user = userController.login(email, password);

            if(user != null){
                System.out.println("Đăng nhập thành công. " );
                teacher = teacherController.checkTeacher(email, password);
                if(teacher != null)
                {
                    menuTeacher(teacher);
                }
                else {
                    System.out.println("Không phải giáo viên");
                }
            }
            else {
                System.out.flush();
                System.err.println("Lỗi đăng nhập!");
                System.err.println("Sai Email hặc Mật khẩu.");
            }
        }
    }

    private static void menuTeacher(Teachers teacher) {
        System.out.println("Xin chào giáo viên " + teacher.getFullName());
        while (true) {
            System.out.println("=====Chọn chức năng bạn muốn sử dụng===== ");
            System.out.println("1. Hiển thị tất cả từ mới");
            System.out.println("2. Thêm từ mới");
            System.out.println("3. Sửa từ");
            System.out.println("4. Xóa từ");
            System.out.println("5. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    getAllVocabularies();
                    break;
                case 2:
                    addVocabulary();
                    break;
//                case 3:
//                    updateVocabulary();
//                    break;
//                case 4:
//                    deleteVocabulary();
//                    break;
                case 5:
                    System.out.println("Thoát menu giáo viên.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại.");
            }
        }
    }

    private static void getAllVocabularies() {
        if (vocabularyList.isEmpty()) {
            System.out.println("Danh sách từ trống.");
            return;
        }
        System.out.println("Từ vựng giáo viên:");
        System.out.printf("%-5s | %-15s | %-10s | %-10s%n", "ID", "Word", "Speak", "Level");
        System.out.println("------------------------------------------------------");

        // In dữ liệu từ danh sách
        for (Vocabulary t : vocabularyList) {
            System.out.printf("%-5s | %-15s | %-10s | %-10s%n", t.getId(), t.getWord(), t.getSpeak(), t.getLevel());
        }
    }


    private static void addVocabulary() {
        System.out.print("Nhập từ: ");
        String word = scanner.nextLine();

        System.out.print("Nhập âm Nhật: ");
        String speak = scanner.nextLine();

        System.out.print("Nhập cấp bậc: ");
        int level = scanner.nextInt();
        scanner.nextLine();

        vocabularyList.add(new Vocabulary(word, speak, level));
        System.out.println("Đã thêm giáo viên thành công.");
    }
//
//    private static void updateTeacher() {
//        System.out.print("Nhập tên giáo viên cần sửa: ");
//        String name = scanner.nextLine();
//        for (Teachers t : vocabularyList) {
//            if (t.getFullName().equals(name)) {
//                System.out.print("Nhập tên mới: ");
//                t.setFullName(scanner.nextLine());
//                System.out.println("Cập nhật thành công.");
//                return;
//            }
//        }
//        System.out.println("Không tìm thấy giáo viên.");
//    }
//
//    private static void deleteTeacher() {
//        System.out.print("Nhập tên giáo viên cần xóa: ");
//        String name = scanner.nextLine();
//        vocabularyList.removeIf(t -> vocabularyList.getFullName().equals(name));
//        System.out.println("Xóa giáo viên thành công.");
//    }

    private static String check_password() {

        while (true){
            System.out.println("パスワードを入力してください:");
            String password = scanner.nextLine().trim();
            if (password == null || password.length()<6 || password.length()>12 ){
                System.out.println("パスワードを入力してください");
            } else  {
                return password;
            }
        }
    }

    public static String check_email() {
        while (true) {
            System.out.println("メールアドレスを入力: ");
            String email = scanner.nextLine().trim();
            // Kiểm tra định dạng email hợp lệ
            if (email == null || email.isEmpty()) {
                System.out.println("Email không được để trống. メールアドレスを入力.");
                continue;
            }
            // Kiểm tra có chứa đúng một dấu '@'
            if (!email.contains("@") || email.indexOf("@") != email.lastIndexOf("@")) {
                System.out.println("Email phải chứa đúng một ký tự '@'. メールアドレスを入力.");
                continue;
            }
            // Kiểm tra không chứa khoảng trắng
            if (email.contains(" ")) {
                System.out.println("Email không được chứa khoảng trắng. メールアドレスを入力.");
                continue;
            }
            // Kiểm tra phần tên đăng nhập
            String[] parts = email.split("@");
            String username = parts[0];
            String domain = parts[1];
            if (username.length() < 6 || username.length() > 64) {
                System.out.println("Tên đăng nhập phải có từ 6 đến 64 ký tự. メールアドレスを入力.");
                continue;
            }

            if (!username.matches("^[a-zA-Z0-9._-]+$")) {
                System.out.println("Tên đăng nhập chỉ được chứa chữ cái, số, '.', '-', '_'. メールアドレスを入力.");
                continue;
            }

            if (username.startsWith(".") || username.endsWith(".") || username.contains("..")
                    || username.startsWith("_") || username.endsWith("_") || username.contains("__")
                    || username.startsWith("-") || username.endsWith("-") || username.contains("--")) {
                System.out.println("Tên đăng nhập không được bắt đầu/kết thúc bằng dấu '.', '-', '_' hoặc chứa hai dấu đặc biệt liên tiếp. メールアドレスを入力.");
                continue;
            }

            return email;
        }
    }



}
