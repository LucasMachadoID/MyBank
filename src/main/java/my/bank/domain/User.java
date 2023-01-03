package my.bank.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "USER")
@Getter
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private final Long id = null;

    @Column(name = "NAME")
    private String name;

    @Column(name = "BIRTH_DATE")
    private LocalDateTime birthDate;

    @OneToMany(mappedBy = "user")
    private List<Account> accounts;

    @CreatedDate
    @Column(name = "CREATED_DATE")
    private final LocalDateTime createdDate = LocalDateTime.now();
}
