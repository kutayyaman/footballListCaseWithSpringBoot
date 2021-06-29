package com.kutayyaman.footballListCase.domain;

import com.kutayyaman.footballListCase.model.RowStatus;
import com.kutayyaman.footballListCase.util.CurrentDateCreator;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Data
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date createdDate = CurrentDateCreator.currentDateAsDate();
    @Temporal(TemporalType.DATE)
    private Date modifiedDate;
    private String createdBy;
    private String modifiedBy;
    @Enumerated(EnumType.STRING)
    private RowStatus rowStatus = RowStatus.ACTIVE;
}
