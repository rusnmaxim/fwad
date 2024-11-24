package com.example.demo.models.entities;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class RouteStops {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

    @ManyToOne
    @JoinColumn(name = "stops_id", nullable = false)
    private Stops stop;

}