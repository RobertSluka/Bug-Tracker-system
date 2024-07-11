    package main.java.Bug.Entity;

    import jakarta.persistence.*;
    import lombok.*;

    import java.util.ArrayList;
    import java.util.Date;
    import java.util.List;


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Data
    @Table(name= "users")
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(name = "user_name", nullable = false, unique = true)
        private String userName;

        @Column(name = "password", nullable = false)
        private String password;

        @Column(name = "first_name", nullable = false)
        private String firstName;

        @Column(name = "last_name", nullable = false)
        private String lastName;

        @Column(name = "email", nullable = false)
        private String email;

        @Column(name = "date_of_birth", nullable = false)
        private Date dateOfBirth;

        @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
        @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
        private List<Role> roles = new ArrayList<>();
    }