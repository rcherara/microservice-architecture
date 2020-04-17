package ca.rcherara.services.vehicle.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;





@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {
  //@NotNull
  //@Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at", updatable =false)
  private LocalDateTime createdAt = LocalDateTime.now();
  
  //@NotNull
  @Column(name = "created_by",length = 50, updatable = false)
  private String createdBy;
  
  //@NotNull
  //@Temporal(TemporalType.TIMESTAMP)
  @Column(name = "updated_at", insertable = false)
  private LocalDateTime updatedAt = LocalDateTime.now();
  
  //@NotNull
  @Column(name = "updated_by",length = 50, insertable = false)
  private String updatedBy;

  //@NotNull
  @Column(name = "published",length = 50, insertable = false)
  private boolean published;

}