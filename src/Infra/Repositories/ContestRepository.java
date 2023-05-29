package Infra.Repositories;

import Domain.Entity.*;
import Domain.Repository.RepositoryInterface;
import Domain.ValueObject.Address;
import Domain.ValueObject.Contact;
import java.util.*;

public class ContestRepository implements RepositoryInterface<Contest> {

  Scanner scanner = new Scanner(System.in);
  List<Contest> contestRepository = new ArrayList<Contest>();

  @Override
  public void create(Contest entity) {
    contestRepository.add(entity);

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
      }else {
        System.out.println("Contest not found." + id);
      }
    }
   ;
  }

  @Override
  public void search(String name) {
    if (name.isEmpty()){
      System.out.println("Contest name required");
    }
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

  @Override
  public void takeTheExam(String contestName) {
    if (contestName.isEmpty()){
      System.out.println("Contest name required.");
    }
    for (Contest contest : contestRepository) {
      if (contest.getName().equals(contestName)) {
        Exam exam = contest.getExam();
        if (exam != null) {
          System.out.println(
            "Taking the exam for the contest " + contestName + ":"
          );
          System.out.println("Date: " + exam.getDate());
          System.out.println("Duration: " + exam.getDuration() + " minutes");
          System.out.println("Description: " + exam.getDescription());

          // ArrayList<String> applicantsAnswers = new ArrayList<>();

          // for (int i = 0; i < exam.getNumberOfQuestions(); i++) {
          //   System.out.print("Answer to the question " + (i + 1) + ": ");
          //   String answer = scanner.nextLine();
          //   applicantsAnswers.add(answer);
          // }

          // // Check correct answers and calculate score
          // ArrayList<String> correctAnswers = new ArrayList<>();
          // int score = 0;
          // for (int i = 0; i < exam.getNumberOfQuestions(); i++) {
          //   String applicantsAnswer = applicantsAnswers.get(i);
          //   String correctAnswer = correctAnswers.get(i);
          //   if (applicantsAnswer.equals(correctAnswer)) {
          //     score++;
          //   }
          // }

          // if (score >= 10) {
          //   System.out.println(
          //     "Congratulations! You are eligible for the contest" +
          //     contestName +
          //     "."
          //   );
          // } else {
          //   System.out.println(
          //     "Unfortunately, you did not reach the minimum score to be considered eligible for the contest " +
          //     contestName +
          //     "."
          //   );
          // }
        } else {
          System.out.println(
            "The contest " + contestName + " does not have an event registered"
          );
          return;
        }
      }
    }
    System.out.println("Contest not found.");
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

    if (contestName.isEmpty()){
      System.out.println("Contest not found.");
    }

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
  }

  private Applicant getDetailsApplicant() {
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
