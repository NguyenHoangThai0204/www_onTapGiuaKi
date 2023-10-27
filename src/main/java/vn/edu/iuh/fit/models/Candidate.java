package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.models.Experience;

import java.util.List;

@Entity
@Table(name = "candidate")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "can_id", length = 20)
    private long id;
    @Column(name = "full_name", nullable = false, length = 255)
    private String fullName;
    @Column(name = "phone", nullable = false, length = 15)
    private String phone;
    @Column(name = "email", length = 255, unique = true)
    private String email;
    @OneToMany(mappedBy = "candidate", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Experience> experiences;

    public Candidate() {
    }

    public Candidate(long id, String fullName, String phone, String email, List<Experience> experiences) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.experiences = experiences;
    }

    public Candidate(String fullName, String phone, String email, List<Experience> experiences) {
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.experiences = experiences;
    }

    public Candidate(String fullName, String phone) {
        this.fullName = fullName;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", experiences=" + experiences +
                '}';
    }
}
