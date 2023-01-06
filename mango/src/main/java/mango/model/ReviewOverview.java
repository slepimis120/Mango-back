package mango.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ReviewOverview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "VEHICLEREVIEW",  referencedColumnName = "id")
    private Review vehicleReview;

    @OneToOne
    @JoinColumn(name = "DRIVERREVIEW",  referencedColumnName = "id")
    private Review driverReview;

    @ManyToOne
    @JoinColumn(name = "RIDEID",  referencedColumnName = "id")
    private Ride ride;
}
