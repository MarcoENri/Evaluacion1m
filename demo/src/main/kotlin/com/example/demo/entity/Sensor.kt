package com.example.demo.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "sensor")
class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensor_id", updatable = false, nullable = false)
    var id: Long? = null

    @Column(name = "sensor_name", nullable = false)
    var sensorName: String = ""

    @Column(name = "description")
    var description: String? = null

    @Column(name = "brand")
    var brand: String? = null

    @Column(name = "price", nullable = false)
    var price: Double = 0.0

}
