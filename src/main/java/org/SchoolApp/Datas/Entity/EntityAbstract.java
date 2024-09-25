package org.SchoolApp.Datas.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Where;
import org.springframework.data.repository.NoRepositoryBean;

import java.time.LocalDateTime;

@Data
@ToString
@NoRepositoryBean
@MappedSuperclass
@Where(clause = "deleted = false")
public abstract class EntityAbstract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    protected boolean deleted = false;

    protected LocalDateTime deletedAt;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
