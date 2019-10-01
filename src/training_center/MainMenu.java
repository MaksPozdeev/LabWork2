package training_center;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MainMenu {
    public static void main(String[] args) {
        CreateData.generate();
        BufferedReader reader;

        while (true) {
            System.out.print("Выберете номер операции:\n" +
                    "1. Вывести студентов отсортированных по среднему баллу \n" +
                    "2. Вывести студентов отсортированных по оставшемуся времени \n" +
                    "3. Отфильтровать студентов по категории \"Имеет шанс на продолжение\" \n" +
                    "4. Вывести данные о состоянии студентов \n" +
                    "5. Выход \n" +
                    "> ");

            try {
                reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
                String stringParams = reader.readLine();
                if (stringParams == null) {
                    System.out.println("Неверная комманда!");
                    continue;
                }

                String[] params = stringParams.trim().toLowerCase().split(" ");
                if (params.length < 1 || params.length > 2) {
                    System.out.println("Неверная команда.");
                    System.out.println();
                    continue;
                }

                switch (params[0]) {
                    case "1": //"list students sorted by average mark":
                        System.out.println("Студенты отсортированны по среднему баллу:");
                        CreateData.listStudentsSortedByAverageMarks();
                        break;
                    case "2": //"list students sorted by time left":
                        System.out.println("Студенты отсортированны по оставшемуся времени:");
                        CreateData.listStudentsSortedByTimeLeft();
                        break;
                    case "3": //"Filter students by category \"Have a chance\"":
                        System.out.println("Шанс есть у всех!");
                        break;
                    case "4": //"List info about students":
                        System.out.println("Информация о состоянии студентов");
                        CreateData.listStatusStudents();
                        break;
                    case "5": //"exit":
                        return;
                    default:
                        System.out.println("Неверная команда.");
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
