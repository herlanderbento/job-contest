package Infra.Tests;

import Domain.Entity.InternalContest;
import Domain.Entity.PublicContest;
import Infra.Repositories.ContestRepository;

import java.util.Scanner;
import java.util.UUID;

public class Tests {
    public static void main(String[] args){
        ContestRepository contestRepository = new ContestRepository();
        Scanner scanner = new Scanner(System.in);

        boolean run = true;
        while (run){
            System.out.println("=== Menu ===");
            System.out.println("1. Create Contest");
            System.out.println("2. Search Contest");
            System.out.println("3. Update Contest");
            System.out.println("4. Remove Contest");
            System.out.println("5. View the List of Contests");
            System.out.println("6. Count Public Contests");
            System.out.println("7. Count Internal Contests");
            System.out.println("8. View the List of Applicants");
            System.out.println("9. Make exam");
            System.out.println("10. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            String contestType = "";
            switch (option){
                case 1:
                    UUID uuid = UUID.randomUUID();
                    System.out.print("Name contest: ");
                    String contestName = scanner.nextLine();
                    System.out.print("Type of tender (Public Contest/Internal Contest): ");
                    contestType = scanner.nextLine();
                    System.out.print("Number of vacancies: ");
                    int quantityVacancies = scanner.nextInt();
                    scanner.nextLine();

                    if(contestType.equalsIgnoreCase("Public Contest")){
                        System.out.println("=== Public Contest ===");
                        System.out.print("Number of questions: ");
                        int numberQuestion = scanner.nextInt();
                        scanner.nextLine();

                        PublicContest publicContest = new PublicContest(uuid, contestName, contestType, quantityVacancies, numberQuestion);
                        contestRepository.create(publicContest);

                    }else if (contestType.equalsIgnoreCase("Internal Contest")){
                        System.out.println("=== Internal Contest ===");
                        System.out.print("Number of questions: ");
                        int numberQuestion = scanner.nextInt();
                        InternalContest internalContest = new InternalContest(uuid, contestName, contestType, quantityVacancies, numberQuestion);
                        contestRepository.create(internalContest);
                    }else {
                        System.out.println("Invalid contest type.");
                    }
                    break;
                case 2:
                    System.out.print("Name contest: ");
                    contestName = scanner.nextLine();
                    contestRepository.search(contestName);
                    break;
                case 3:
                    System.out.print("ID Contest: ");
                    UUID uuid1 = UUID.fromString(scanner.nextLine());
                    System.out.print("New contest name: ");
                    contestName = scanner.nextLine();
                    System.out.print("Type of tender (Public Contest/Internal Contest): ");
                    contestType = scanner.nextLine();
                    System.out.print("New Quantity of Vacancies: ");
                    quantityVacancies = scanner.nextInt();
                    scanner.nextLine();

                    if(contestType.equalsIgnoreCase("Public Contest")){
                        System.out.print("Number of questions: ");
                        int numberQuestion = scanner.nextInt();
                        scanner.nextLine();

                        PublicContest publicContest = new PublicContest(uuid1, contestName, contestType, quantityVacancies, numberQuestion);
                        contestRepository.update(uuid1, publicContest);
                        contestRepository.update(uuid1, publicContest);

                    }else if (contestType.equalsIgnoreCase("Internal Contest")){
                        System.out.print("Number of questions: ");
                        int numberQuestion = scanner.nextInt();

                        InternalContest internalContest = new InternalContest(uuid1, contestName, contestType, quantityVacancies, numberQuestion);
                        contestRepository.update(uuid1, internalContest);
                    }else {
                        System.out.println("Invalid contest type.");
                    }
                    break;
                case 4:
                    System.out.print("ID contest: ");
                    UUID id = UUID.fromString(scanner.nextLine());
                    contestRepository.delete(id);
                    break;
                case 5:
                    contestRepository.listAll();
                    break;
                case 6:
                    contestRepository.countContestsByType("Public Contest");
                    break;
                case 7:
                    contestRepository.countContestsByType("Internal Contest");
                    break;
                case 8:
                    System.out.print("Contest name: ");
                    contestName = scanner.nextLine();
                    contestRepository.viewApplicants(contestName);
                    break;
                case 9:
                    System.out.print("Contest name: ");
                    contestName = scanner.nextLine();
                    contestRepository.takeTheExam(contestName);
                    break;
                case 10:
                    run = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
            System.out.println();
        }
        System.out.println("Closed program.");
        scanner.close();
    }
}
