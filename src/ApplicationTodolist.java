import java.util.Scanner;

/**
 * @author <a href="mailto:bagus.seno39@gmail.com>seno</a>
 * Created on 03/02/21
 * Project java-application-todolist
 */
public class ApplicationTodolist {

    public static String[] model = new String[10];

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodolist();
    }

    /**
     * Show Todolist
     */
    public static void showTodolist() {
        System.out.println("========================TODOLIST=======================");
        for (var i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;

            if (todo != null)
                System.out.println(no + ". " + todo);
        }
    }

    public static void testShowTodolist() {
        model[0] = "Belajar Java Dasar";
        model[1] = "Membuat Aplikasi Todolist";
        showTodolist();
    }

    /**
     * Add Todolist
     */
    public static void addTodolist(String todo) {
        var isFull = true;
        // Checking array null
        for (String s : model) {
            if (s == null) {
                isFull = false;
                break;
            }
        }

        // If null resize array 2x
        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];

            if (temp.length >= 0) System.arraycopy(temp, 0, model, 0, temp.length);
        }

        // Add to array null
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodolist() {
        for (var i = 0; i < 25; i++) {
            addTodolist("Todo Ke - " + i);
        }

        showTodolist();
    }

    /**
     * Remove Todolist
     */
    public static boolean removeTodolist(Integer number) {
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {
            for (var i = (number - 1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                }else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodolist() {
        addTodolist("Satu");
        addTodolist("Dua");
        addTodolist("Tiga");
        addTodolist("Empat");
        var result = removeTodolist(20);
        System.out.println(result);

        result = removeTodolist(2);
        System.out.println(result);

        showTodolist();
    }

    public static String input(String info){
        System.out.println(info + " : ");
        return scanner.nextLine();
    }

    public static void testInput(){
        var name = input("Nama");
        System.out.println("Hi " + name);
        var jon = input("Job");
        System.out.println("Pekerjaan " + jon);
    }

    /**
     * View Show Todolist
     */
    public static void viewShowTodolist() {
        while (true) {
            showTodolist();
            System.out.println("Action : ");
            System.out.println("1. Tambah ");
            System.out.println("2. Hapus ");
            System.out.println("X. Keluar ");

            var input = input("Pilih");
            if (input.equals("1")) {
                viewAddTodolist();
            } else if (input.equals("2")) {
                viewRemoveTodolist();
            } else if(input.equals("X")){
                break;
            } else {
                System.out.println("Pilihan Tidak Ada");
            }
        }
    }

    public static void testViewShowTodolist(){
        addTodolist("Front End Developer");
        addTodolist("Backend Developer");
        viewShowTodolist();
    }

    /**
     * View Add Todolist
     */
    public static void viewAddTodolist() {
        System.out.println("MENAMBAHKAN TODOLIST");

        addTodolist("Front End Developer");
        addTodolist("Backend Developer");
        var todo = input("Todo (x Jika Batal)");

        if (todo.equals("x")){

        }else {
           addTodolist(todo);
        }
    }

    public static void testViewAddTodoList(){
        viewAddTodolist();
        showTodolist();
    }

    /**
     * View Remove Todolist
     */
    public static void viewRemoveTodolist() {
        System.out.println("MENGHAPUS TODOLIST");
        showTodolist();
        var number = input("Masukkan nomor yang akan dihapus (x Jika Batal)");
        if (number.equals("x")){

        }else {
            boolean success = removeTodolist(Integer.valueOf(number));
            if (!success){
                System.out.println("Gagal menghapus todolist");
            }
        }
        showTodolist();
    }

    public static void testViewRemoveTodolist(){
        addTodolist("Front End Developer");
        addTodolist("Backend Developer");
        viewRemoveTodolist();
    }

}
