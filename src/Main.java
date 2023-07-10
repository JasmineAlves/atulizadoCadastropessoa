
import car.Car; //importação

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Person> students = new ArrayList<Person>();
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = true;
        while (exit) {

            System.out.println("\n\n====== SEJA BEM VINDO! ======");
            System.out.println("     O que você deseja?      ");
            System.out.println("\n(1) - Cadastrar um estudante");
            System.out.println("(2) - Buscar um estudante");
            System.out.println("(3) - Remover um estudante");
            System.out.println("(4) - Editar um estudante");
            System.out.println("(5) - Listar um estudante");
            System.out.println("(6) - Finalizar o sistema\n");
            System.out.print("Opção: ");

            int option = scan.nextInt();

            switch (option) {
                case 1:
                    addStudent(students);
                    break;

                case 2:
                    System.out.println("Qual o nome do estudante que deseja buscar?");
                    String nameToFind = scan.next();
                    findStudent(students, nameToFind);
                    break;

                case 3:
                    removeStudent();
                    break;

                case 4:
                    editStudent();
                    break;

                case 5:
                    listStudent();
                    break;

                case 6:
                    System.out.println("Sistema finalizado!");
                    exit = false;
                    break;

                default:
                    System.out.println("Essa opção não existe! Tente novamente...");
                    //exit = false;
                    break;
            }
        }
    }

    private static void addStudent(List<Person> students) {
        Person student = new Person();
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o nome completo do estudante:");
        student.name = scan.next();
        System.out.println("Qual é a idade de " + student.name +" ?");
        student.age = scan.nextInt();
        System.out.println("Qual é o genêro de " + student.name + "? (F ou M)");
        student.sex = scan.next();
        students.add(student);
        System.out.println("Agradeço pela resposta!"
                + " O estudante cadastrado foi: " + student.name + ", que possui "+ student.age + " anos de idade e pertence ao gênero: " + student.sex + "!");
    }

    private static Integer findStudent(List<Person> students, String studentName) {
        Integer position = null;

        for (int count = 0; count < students.size(); count++) {
            Person student = students.get(count);

            if (student.name.equals(studentName)) {
                position = count;
                System.out.println("O estudante foi localizado com sucesso: " + studentName);
            }
        }
        return position;
    }

    private static void listStudent() {
        int countmas = 0;
        int countfem = 0;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).sexo.equals("masculino")) {
                countmas++;
            } else {
                countfem++;
            }
        }

        System.out.println("Masculino: " + countmas + " Feminino: " + countfem + "\n\n");
        System.out.println("Os estudantes localizados foram:");

        for (int i = 0; i < students.size(); i++) {
            System.out.println("Nome: " + students.get(i).name + " - Idade: " + students.get(i).age + " - Sexo: " + students.get(i).sex + "!");
        }
    }

    private static void removeStudent() {
        System.out.println("Por favor, digite o nome do estudante que deseja remover:");
        String name = scan.next();
        Integer position = findStudent(students, name);
        if (position != null) {
            students.remove(position.intValue());
            System.out.print("O estudante foi removido com sucesso!");
        } else {
            System.out.println("O estudante não foi encontrado! Tente novamente!");
        }
    }

    private static void editStudent() {
        System.out.println("Por favor, digite o nome do estudante que deseja editar:");
        String name = scan.next();
        Integer position = findStudent(students, name);
        if (position != null) {
            Person p1 = students.get(position.intValue());
            System.out.println("Informe o novo nome do estudante: ");
            name = scan.next();
            p1.name = name;
            System.out.println("O nome do estudante foi editado com sucesso!");
        }
    }
}