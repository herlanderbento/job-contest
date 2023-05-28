package Infra.Repositories;

import Domain.Entity.Applicant;
import Domain.Entity.Contest;
import Domain.Entity.InternalContest;
import Domain.Entity.PublicContest;
import Domain.Repository.RepositoryInterface;
import Domain.ValueObject.Address;
import Domain.ValueObject.Contact;
import java.util.*;

public class ContestRepository implements RepositoryInterface<Contest> {

  List<Contest> contestRepository = new ArrayList<Contest>();

  @Override
  public void create(Contest entity) {
    contestRepository.add(entity);

    Scanner scanner = new Scanner(System.in);
    System.out.print(
      "Do you want to register candidates for the contest? (Y/N): "
    );
    String answer = scanner.nextLine();

    if (answer.equalsIgnoreCase("Y")) {
      do {
        Applicant applicant = getDetailsApplicant();
        entity.createApplicants(applicant);

        System.out.print("Do you want to register more candidates? (Y/N): ");
        answer = scanner.nextLine();
      } while (answer.equalsIgnoreCase("Y"));
    }

    System.out.println("Contest created successfully!");
  }

  @Override
  public void listAll() {
    if (contestRepository.isEmpty()) {
      System.out.println("There are no contests created.");
    }

    for (Contest contest : contestRepository) {
      System.out.println(
        "ID: " +
        contest.getId() +
        ", Name: " +
        contest.getName() +
        ", Type: " +
        contest.getType() +
        ", Number of vacancies:" +
        contest.getQuantityVacancies()
      );
      System.out.println("------------------------");
    }
  }

  @Override
  public void update(UUID id, Contest entity) {
    for (int index = 0; index < contestRepository.size(); index++) {
      Contest contest = contestRepository.get(index);
      if (contest.getId() == id) {
        contestRepository.set(index, entity);
        System.out.println("Contest updated successfully!");
      }
    }
    System.out.println("Contest not found." + id);
  }

  @Override
  public void search(String name) {
    for (Contest contest : contestRepository) {
      if (contest.getName().equals(name)) {
        System.out.println("ID: " + contest.getId());
        System.out.println("Name: " + contest.getName());
        System.out.println("Type: " + contest.getType());
        System.out.println(
          "Quantity of vacancies: " + contest.getQuantityVacancies()
        );

        if (contest instanceof PublicContest publicContest) {
          System.out.println(
            "Number of question: " + publicContest.getNumberOfQuestions()
          );
        } else if (contest instanceof InternalContest internalContest) {
          System.out.println(
            "Number of question: " + internalContest.getNumberOfQuestions()
          );
        }
        System.out.println("Contest not found!");
      }
    }
  }

  @Override
  public void delete(UUID id) {
    contestRepository.removeIf(entity -> Objects.equals(entity.getId(), id));
    System.out.println("Contest deleted successfully!");
  }

  public void countContestsByType(String type) {
    int count = 0;
    for (Contest contest : contestRepository) {
      if (contest.getType().equals(type)) {
        count++;
      }
    }
    System.out.println("Number of contests " + type + ": " + count);
  }

  public void viewApplicants(String contestName) {
    for (Contest contest : contestRepository) {
      if (contest.getName().equals(contestName)) {
        ArrayList<Applicant> applicants = (ArrayList<Applicant>) contest.getApplicants();
        if (applicants.isEmpty()) {
          System.out.println(
            "There are no registered candidates for the contest " +
            contestName +
            "."
          );
        } else {
          System.out.println("Contest Candidates " + contestName + ":");
          for (Applicant applicant : applicants) {
            System.out.println(
              ", Name: " +
              applicant.getName() +
              ", Age: " +
              applicant.getAge() +
              ", State: " +
              applicant.getAddress().getState() +
              ", Address: " +
              applicant.getAddress().getAddress() +
              ", Phone: " +
              applicant.getContact().getPhone() +
              ", Email: " +
              applicant.getContact().getEmail()
            );
            System.out.println("------------------------");
          }
        }
      }
    }
    System.out.println("Contest not found.");
  }

  private Applicant getDetailsApplicant() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("=== Menu Candidates ===");

    System.out.print("Name : ");
    String name = scanner.nextLine();

    System.out.print("Age : ");
    int age = scanner.nextInt();

    System.out.print("State: ");
    String state = scanner.nextLine();

    System.out.print("\nAddress: ");
    String _address = scanner.nextLine();

    System.out.print("Phone: ");
    int phone = scanner.nextInt();

    System.out.print("\nEmail: ");
    String email = scanner.nextLine();
    System.out.print("\n");

    Address address = new Address(state, _address);
    Contact contact = new Contact(phone, email);
    return new Applicant(name, age, address, contact);
  }
}
