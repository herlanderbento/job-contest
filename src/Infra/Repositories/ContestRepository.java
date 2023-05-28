package Infra.Repositories;

import Domain.Entity.Contest;
import Domain.Entity.InternalContest;
import Domain.Entity.PublicContest;
import Domain.Repository.RepositoryInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContestRepository implements RepositoryInterface<Contest> {

  List<Contest> contestRepository = new ArrayList<Contest>();

  @Override
  public void create(Contest entity) {
    contestRepository.add(entity);
    System.out.println("Contest created successfully!");
  }

  @Override
  public List<Contest> listAll() {
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

    return contestRepository;
  }

  @Override
  public void update(Contest entity) {
    for (int index = 0; index < contestRepository.size(); index++) {
      Contest contest = contestRepository.get(index);
      if (contest.getName().equals(entity.getName())) {
        contestRepository.set(index, entity);
        System.out.println("Contest updated successfully!");
      }
    }
  }

  @Override
  public void search(String name) {
    for (Contest contest : contestRepository) {
      if (contest.getName().equals(name)) {
        System.out.println("ID: " + contest.getId());
        System.out.println("Name: " + contest.getName());
        System.out.println("Type: " + contest.getType());
        System.out.println("Quantity of vacancies: " + contest.getQuantityVacancies());

        if (contest instanceof PublicContest publicContest){
          System.out.println("Number of question: " + publicContest.getNumberOfQuestions());
        }else if (contest instanceof InternalContest internalContest){
          System.out.println("Number of question: " + internalContest.getNumberOfQuestions());
        }
        System.out.println("Contest not found!");
      }
    }
  }
  @Override
  public void delete(String name) {
    contestRepository.removeIf(entity -> Objects.equals(entity.getName(), name));
    System.out.println("Contest deleted successfully!");
  }

  public void countContestsByType(String type){
    int count = 0;
    for (Contest contest : contestRepository){
      if (contest.getType().equals(type)){
        count++;
      }
    }
    System.out.println("Number of contests" + type + ": " + count);
  }
}
