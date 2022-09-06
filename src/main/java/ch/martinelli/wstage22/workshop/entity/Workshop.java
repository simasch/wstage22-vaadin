package ch.martinelli.wstage22.workshop.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.time.LocalDate;

@Entity
public class Workshop {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "workshop_seq")
    @SequenceGenerator(name = "workshop_seq", sequenceName = "workshop_seq")
    private Integer id;

    private String title;

    @Enumerated(EnumType.STRING)
    private Topic topic;
    private String instructor;
    @Enumerated(EnumType.STRING)
    private Status status = Status.OPEN;
    private LocalDate executionDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public ch.martinelli.wstage22.workshop.entity.Status getStatus() {
        return status;
    }

    public void setStatus(ch.martinelli.wstage22.workshop.entity.Status status) {
        this.status = status;
    }

    public LocalDate getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(LocalDate executionDate) {
        this.executionDate = executionDate;
    }
}
