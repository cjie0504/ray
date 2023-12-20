package com.example.raymetrics.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditingAt implements Serializable {
    private static final long serialVersionUID = 1L;

    @CreatedDate
    @Column(name = "REG_DT", insertable = true, updatable = false)
    @JsonFormat(timezone = "GMT+09:00")
    protected Timestamp regDt;

    @LastModifiedDate
    @Column(name = "MOD_DT", insertable = true, updatable = true)
    @JsonFormat(timezone = "GMT+09:00")
    protected Timestamp  modDt;

    public AuditingAt() {
        regDt = new Timestamp(new Date().getTime());
        modDt = new Timestamp(new Date().getTime());
    }

}

