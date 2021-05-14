package per.project.starbucks.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {

    @Temporal(TemporalType.DATE)
    @Column(name = "createdAt")
    protected LocalDateTime createdAt;

    @Temporal(TemporalType.DATE)
    @Column(name = "updatedAt")
    protected LocalDateTime updatedAt;

    @Temporal(TemporalType.DATE)
    @Column(name = "deletedAt")
    protected LocalDateTime deletedAt;
}
