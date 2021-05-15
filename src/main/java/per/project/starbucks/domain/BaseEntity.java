package per.project.starbucks.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {


    @Column(name = "createdAt")
    protected LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updatedAt")
    protected LocalDateTime updatedAt = LocalDateTime.now();

    @Column(name = "deletedAt")
    protected LocalDateTime deletedAt;
}
