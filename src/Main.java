
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Users user = new Users("Aa1_1111111111111111", "aa_1234A", "aa_1234A");
        registrationUsers(user.getLogin(), user.getPassword(), user.getConfirmPassword());
    }

    public static void registrationUsers(String login, String password, String confirmPassword) {
        try {
            if (!Pattern.matches("[0-9a-zA-Z_]+", login) || login.length() > 20)
                throw new WrongLoginException("Логин содержит запрещенные символы или слишком длинный");
            if (!Pattern.matches("[0-9a-zA-Z_]+", password) || password.length() > 20 || !password.equals(confirmPassword))
                throw new WrongPasswordException("Пароли не равны или содержита запрещенные символы, или слишком длинные");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }
}