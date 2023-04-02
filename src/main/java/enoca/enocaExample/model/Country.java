package enoca.enocaExample.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;

@Table(name = "countries")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Country {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "continent")
    private String continent;

    @Column(name = "population")
    private BigInteger population;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    List<City> cities;
}
