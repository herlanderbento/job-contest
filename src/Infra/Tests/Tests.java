package Infra.Tests;

import Domain.Entity.InternalContest;
import Domain.Entity.PublicContest;
import Infra.Repositories.ContestRepository;

import java.util.Scanner;

public class Tests {
    public static void main(String[] args){
        ContestRepository contestRepository = new ContestRepository();
        Scanner scanner = new Scanner(System.in);

        boolean run = true;
        while (run){
            System.out.println("=== Menu ===");
            System.out.println("1. Registrar Concurso");
            System.out.println("2. Consultar Concurso");
            System.out.println("3. Atualizar Concurso");
            System.out.println("4. Remover Concurso");
            System.out.println("5. Ver Lista de Concursos");
            System.out.println("6. Contar Concursos Públicos");
            System.out.println("7. Contar Concursos Internos");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            String contestType = "";
            switch (option){
                case 1:
                    System.out.print("Nome do concurso: ");
                    String contestName = scanner.nextLine();
                    System.out.print("Tipo do concurso (Concurso Público/Concurso Interno): ");
                    contestType = scanner.nextLine();
                    System.out.print("Quantidade de vagas: ");
                    int quantityVacancies = scanner.nextInt();
                    scanner.nextLine();

                    if(contestType.equalsIgnoreCase("Concurso Público")){
                        System.out.print("Número de questões: ");
                        int numberQuestion = scanner.nextInt();
                        scanner.nextLine();

                        PublicContest publicContest = new PublicContest(contestName, contestType, quantityVacancies, numberQuestion);
                        contestRepository.create(publicContest);

                    }else if (contestType.equalsIgnoreCase("Concurso Interno")){
                        System.out.print("Número de questões: ");
                        int numberQuestion = scanner.nextInt();
                        InternalContest internalContest = new InternalContest(contestName, contestType, quantityVacancies, numberQuestion);
                        contestRepository.create(internalContest);
                    }else {
                        System.out.println("Tipo de concurso inválido.");
                    }
                    break;
                case 2:
                    System.out.print("Nome do concurso: ");
                    contestName = scanner.nextLine();
                    contestRepository.search(contestName);
                    break;
                case 3:
                    System.out.print("Novo nome do concurso: ");
                    String newContestName = scanner.nextLine();
                    System.out.print("Nova quantidade de vagas: ");
                    int newQuantityVacancies = scanner.nextInt();
                    scanner.nextLine();

                    if(contestType.equalsIgnoreCase("Concurso Público")){
                        System.out.print("Número de questões: ");
                        int numberQuestion = scanner.nextInt();
                        scanner.nextLine();

                        PublicContest publicContest1 = new PublicContest(newContestName, contestType, newQuantityVacancies, numberQuestion);
                        contestRepository.update(publicContest1);

                    }else if (contestType.equalsIgnoreCase("Concurso Interno")){
                        int numberQuestion = scanner.nextInt();

                        InternalContest internalContest = new InternalContest(newContestName, contestType, newQuantityVacancies, numberQuestion);
                        contestRepository.update(internalContest);
                    }else {
                        System.out.println("Tipo de concurso inválido.");
                    }
                    break;
                case 4:
                    System.out.print("Nome do concurso: ");
                    contestName = scanner.nextLine();
                    contestRepository.delete(contestName);
                    break;
                case 5:
                    contestRepository.listAll();
                    break;
                case 6:
                    contestRepository.countContestsByType("Concurso Público");
                    break;
                case 7:
                    contestRepository.countContestsByType("Concurso Interno");
                    break;
                case 8:
                    run = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            System.out.println();
        }
        System.out.println("Programa encerrado.");
        scanner.close();
    }
}
