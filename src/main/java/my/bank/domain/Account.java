package my.bank.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private final Long id = null;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private AccountType type;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private User user;

    @Column(name = "MONEY")
    private BigDecimal money;

    @Column(name = "AUTHORIZED")
    private boolean authorized = false;

    @CreatedDate
    @Column(name = "CREATED_DATE")
    private final LocalDateTime createdDate = LocalDateTime.now();
}
