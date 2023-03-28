package enoca.enocaExample.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigInteger;

@Table(name = "cities")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class City {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "population")
    private BigInteger population;

    @Column(name = "region")
    private String region;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "country_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Country country;
}
