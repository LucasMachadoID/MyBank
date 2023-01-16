package my.bank.adapter.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "account")
@Getter
@Setter
@Builder
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Setter(AccessLevel.NONE)
    private final Long id = null;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name="id_type", nullable=false)
    private AccountType type;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name="id_user", nullable=false)
    private User user;

    @Column(name = "money")
    private BigDecimal money;

    @Column(name = "authorized")
    @Builder.Default
    @Setter(AccessLevel.NONE)
    private boolean authorized = false;

    @CreatedDate
    @Column(name = "created_date")
    @Setter(AccessLevel.NONE)
    private final LocalDateTime createdDate = LocalDateTime.now();
}
