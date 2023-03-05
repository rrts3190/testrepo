package org.tutorial;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity(name = "student_details")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "student")
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "studentName")
    private String name;
    private String City;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "certiName", column = @Column(name = "CertificateName")),
            @AttributeOverride( name = "score", column = @Column(name = "test_score"))
    })
    private Certificate certi;

    public Certificate getCerti() {
        return certi;
    }

    public void setCerti(Certificate certi) {
        this.certi = certi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", City='" + City + '\'' +
                '}';
    }
}
