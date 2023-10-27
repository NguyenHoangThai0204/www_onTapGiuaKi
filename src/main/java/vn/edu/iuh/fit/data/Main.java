package vn.edu.iuh.fit.data;

import vn.edu.iuh.fit.models.Candidate;
import vn.edu.iuh.fit.models.Experience;
import vn.edu.iuh.fit.models.Roles;
import vn.edu.iuh.fit.repositories.CandidateRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        //ConnectionDb.getInstance().getSessionFactory();

        CandidateRepository repository = new CandidateRepository();

//        Candidate candidate = new Candidate("nsgsad", "456132", "saet@gmail.com", null);
//        repository.insertCan(candidate);

//        Candidate can1 = new Candidate("Thai 1", "456132", "saet1@gmail.com",null);
//        Experience ex1 = new Experience(can1,"A","Nghi", LocalDate.now(), LocalDate.now(), Roles.ADMINISTRATION);
//        Experience ex2 = new Experience(can1,"A","Nghi", LocalDate.now(), LocalDate.now(), Roles.ADMINISTRATION);
//        Experience ex3 = new Experience(can1,"A","Nghi", LocalDate.now(), LocalDate.now(), Roles.ADMINISTRATION);
//        List<Experience> experiences1 = List.of(ex1,ex2,ex3);
//        can1.setExperiences(experiences1);
//        repository.insertCan(can1);
//        Candidate can2 = new Candidate("Thai 2", "456132", "saet2@gmail.com",null);
//        Experience ex4 = new Experience(can2,"A","Nghi", LocalDate.now(), LocalDate.now(), Roles.ADMINISTRATION);
//        Experience ex5 = new Experience(can2,"A","Nghi", LocalDate.now(), LocalDate.now(), Roles.ADMINISTRATION);
//        Experience ex6 = new Experience(can2,"A","Nghi", LocalDate.now(), LocalDate.now(), Roles.ADMINISTRATION);
//        List<Experience> experiences2 = List.of(ex4,ex5,ex6);
//        can2.setExperiences(experiences2);
//        repository.insertCan(can2);
//        Candidate can3 = new Candidate("Thai 3", "456132", "saet3@gmail.com",null);
//        Experience ex7 = new Experience(can3,"A","Nghi", LocalDate.now(), LocalDate.now(), Roles.MANAGER);
//        Experience ex8 = new Experience(can3,"A","Nghi", LocalDate.now(), LocalDate.now(), Roles.MANAGER);
//        Experience ex9 = new Experience(can3,"A","Nghi", LocalDate.now(), LocalDate.now(), Roles.MANAGER);
//        List<Experience> experiences3 = List.of(ex7,ex8,ex9);
//        can3.setExperiences(experiences3);
//        repository.insertCan(can3);

//        Optional<Candidate> c = repository.getCanById(2);
//        System.out.println(c);

        // Câu 5
//        List<Candidate> list = repository.getAllCanByRole(Roles.ADMINISTRATION);
//        for (Candidate can : list){
//            System.out.println(can);
//        }
        // Câu 6
        List<Candidate> list = repository.getAllCanHaveEmail();
        for (Candidate can : list){
            System.out.println(can);
        }
    }
}
