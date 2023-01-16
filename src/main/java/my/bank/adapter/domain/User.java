package my.bank.adapter.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Builder
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private final Long id = null;

    @Column(name = "name")
    private String name;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Account> accounts;

    @CreatedDate
    @Column(name = "created_date")
    private final LocalDateTime createdDate = LocalDateTime.now();
}
