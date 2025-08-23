import java.util.Optional;
import java.util.Scanner;

public class LoginApp {

    public final Scanner scanner;
    public final AuthService authService;

    public LoginApp(AuthService authService){
        this.authService = authService;
        this.scanner = new Scanner(System.in);
    }

    public void start(){
        int choice;
        do{
            displayMenu();
            System.out.println("Escolha uma opção: ");
            while (!scanner.hasNextInt()){
                System.out.println("Input Inválido.");
                scanner.next();
                System.out.println("Escolha uma opção: ");
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    handleRegister();
                    break;
                case 2:
                    handleLogin();
                case 3:
                    System.out.println("Goob bye");
                    break;
                default:
                    System.out.println("Opção Inválida.");
            }
        }while (choice!=3);
        scanner.close();
    }

    private void displayMenu(){
        System.out.println("--- Main Menu ---");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
    }
    private void handleRegister() {
        System.out.print("Enter desired username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (authService.register(username, password)) {
            System.out.println("Registration successful! You can now log in.");
        } else {
            System.out.println("Registration failed. Please try again.");
        }
    }
    private void handleLogin() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Optional<User> loggedInUser = authService.login(username, password);

        if (loggedInUser.isPresent()) {
            System.out.println("Login successful! Welcome, " + loggedInUser.get().getUsername() + "!");
        } else {
            System.out.println("Login failed: Invalid username or password.");
        }
    }
}
