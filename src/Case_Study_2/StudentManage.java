package Case_Study_2;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class StudentManage {
    static ArrayList<Student> hocSinhs = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public StudentManage() {
    }

    public static void showALL() {
        for (Student hocSinh : hocSinhs) {
            System.out.println(hocSinh.toString());
        }
    }

    public static void showHSG() {
        for (Student student : hocSinhs) {
            if (Integer.parseInt(student.getDiemTB()) >= 8) {
                System.out.println(student);
            }
        }
    }

    public static void showHSK() {
        for (Student student : hocSinhs) {
            if (Integer.parseInt(student.getDiemTB()) < 8 && Integer.parseInt(student.getDiemTB()) >= 5) {
                System.out.println(student);
            }
        }
    }

    public static void showHSTB() {
        for (Student student : hocSinhs) {
            if (Integer.parseInt(student.getDiemTB()) < 5 && Integer.parseInt(student.getDiemTB()) >= 1) {
                System.out.println(student);
            }
        }
    }

    public static void add() {
        String id = getId();
        String hoTen = getHoTen();
        String doTuoi = getDoTuoi();
        String gioiTinh = getGioiTinh();
        String soDT = getSoDT();
        String gmail = getGmail();
        String diaChi = getDiaChi();
        String diemTB = getDiemTB();
        hocSinhs.add(new Student(id, hoTen, doTuoi, gioiTinh, soDT, gmail, diaChi, diemTB));
        IOOFile.writeFile();

    }

    private static String getId() {
        while (true) {
            try {
                System.out.println("Nhập ID");
                String id = sc.nextLine();
                if (IDRegex.validate(id)) {
                    boolean check = true;
                    for (Student student : hocSinhs) {
                        if (student.getId().equals(id)) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        return id;
                    } else {
                        System.err.println("ID đã tồn tại nhập lại ID");
                    }
                } else throw new Exception();
            } catch (Exception e) {
                System.err.println("Mã học sinh phải bắt đầu 'HS' và theo sau là 6 số");
            }
        }

    }

    private static String getHoTen() {
        System.out.println("Nhập họ & tên");
        return sc.nextLine();
    }

    private static String getDoTuoi() {
        while (true) {
            try {
                System.out.println("Nhập tuổi");
                String age = sc.nextLine();
                if (AgeRegex.validate(age)) {
                    if (Integer.parseInt(age) < 18 || Integer.parseInt(age) > 70) {
                        throw new AgeException();
                    } else {
                        return age;
                    }
                } else {
                    throw new Exception();
                }
            } catch (AgeException age) {
                System.err.println("Người này quá già hoặc quá trẻ để đi học");
            } catch (Exception e) {
                System.err.println("Tuổi phải là số");
            }
        }
    }

    private static String getGioiTinh() {
        while (true) {
            try {
                System.out.println("Giới tính");
                String gender = sc.nextLine();
                if (GenderRegex.validate(gender)) {
                    return gender;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.err.println("Giới tính bắt buộc phải là nam hoặc nữ");
            }
        }
    }

    private static String getSoDT() {
        while (true) {
            try {
                System.out.println("Nhập số điện thoại");
                String number = sc.nextLine();
                if (PhoneNumberRegex.validate(number)) {
                    boolean check = true;
                    for (Student student : hocSinhs) {
                        if (student.getId().equals(number)) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        return number;
                    } else {
                        System.err.println("SĐT đã tồn tại. Nhập lại SĐT");
                    }
                } else throw new Exception();
            } catch (Exception e) {
                System.err.println("Số điện thoại phải bắt đầu từ số 0 và theo sau 9 số");
            }
        }
    }

    private static String getGmail() {
        while (true) {
            try {
                System.out.println("Nhập vào gmail");
                String gmail = sc.nextLine();
                if (GmailRegex.validate(gmail)) {
                    boolean check = true;
                    for (Student student : hocSinhs) {
                        if (student.getId().equals(gmail)) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        return gmail;
                    } else {
                        System.err.println("Gmail đã tồn tại. Nhập lại gmail");
                    }
                } else throw new Exception();
            } catch (Exception e) {
                System.err.println("Gmail bắt buộc phải là định dạng .....@gmail.com");
            }
        }
    }

    private static String getDiaChi() {
        System.out.println("Nhập địa chỉ");
        return sc.nextLine();
    }

    private static String getDiemTB() {
        while (true) {
            try {
                System.out.println("Nhập điểm trung bình");
                String diemTB = sc.nextLine();
                if (ScoreRegex.validate(diemTB)) {
                    if (Double.parseDouble(diemTB) < 0 || Double.parseDouble(diemTB) > 10) {
                        throw new ScoreException();
                    } else return diemTB;
                } else throw new Exception();
            } catch (ScoreException diemTB) {
                System.err.println("Điểm TB phải > 0 và <= 10");
            } catch (Exception e) {
                System.err.println("Sai định dạng");
            }
        }
    }

    public static void update() {
        System.out.println("Nhập ID học sinh cần thay đổi");
        String idChange = sc.nextLine();
        int index = -1;
        for (int i = 0; i < hocSinhs.size(); i++) {
            if (hocSinhs.get(i).getId().equals(idChange)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            String id = getId();
            String hoTen = getHoTen();
            String doTuoi = getDoTuoi();
            String gioiTinh = getGioiTinh();
            String soDT = getSoDT();
            String gmail = getGmail();
            String diaChi = getDiaChi();
            String diemTB = getDiemTB();
            hocSinhs.set(index, new Student(id, hoTen, doTuoi, gioiTinh, soDT, gmail, diaChi, diemTB));
            IOOFile.writeFile();
        }
    }

    public static void delete() {
        System.out.println("Nhập ID học sinh cần xóa ");
        String idDelete = sc.nextLine();
        System.err.println("Cảnh báo !!!!");
        System.out.println("Bạn có thật sự muốn xóa");
        System.out.println("1 . Có");
        System.out.println("2 . Không");
        int choice = Integer.parseInt(sc.nextLine());
        if (choice == 1) {
            hocSinhs.removeIf(hocSinh -> hocSinh.getId().equals(idDelete));
        }
    }

    public static void sortTheoTen() {
        hocSinhs.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getHoTen().compareTo(o2.getHoTen());
            }
        });
    }

    public static void sortTheoDiem() {
        hocSinhs.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (Double.parseDouble(o1.getDiemTB()) > Double.parseDouble(o2.getDiemTB())) return 1;
                else return -1;
            }
        });
    }

    public static void sortTheoTuoi() {
        hocSinhs.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (Integer.parseInt(o1.getDoTuoi()) > Integer.parseInt(o2.getDoTuoi())) return 1;
                else return -1;
            }
        });
    }

    public static void searchHS() {
        System.out.println("----Menu----");
        System.out.println("1. Tìm kiếm 1 học sinh");
        System.out.println("2. Tìm kiếm nhiều học sinh cùng Họ hoặc Tên hoặc ký tự liên quan");
        System.out.println("0. Thoát");
        int choice = Integer.parseInt(sc.nextLine());
        if (choice == 0) {
            return;
        }
        switch (choice) {
            case 1:
                System.out.println("Nhập vào tên :");
                String ten = sc.nextLine();
                for (Student nv : hocSinhs) {
                    if (nv.getHoTen().equals(ten)) {
                        System.out.println(nv);
                    }
                }
                break;
            case 2:
                System.out.println("Nhập vào tên :");
                String name = sc.nextLine();
                for (Student student : hocSinhs) {
                    if (student.getHoTen().contains(name)) {
                        System.out.println(student);
                    }
                }
                break;
            default:
                System.err.println("Vui lòng nhập đúng");
        }

    }

    public static void readFile() {
        hocSinhs = IOOFile.readFile();
    }

    public static void writeFile() {
        IOOFile.writeFile();
    }
}