package com.util.admin.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass//jap entity 클래스들이 base time entity를 상속할 경우 필드들도 칼럼으로 인식
@EntityListeners(AuditingEntityListener.class)//클래스에 auditing 기능 포함
public abstract class BaseTimeEntity {

    @CreatedDate//entity가 생성되어 저장될 때 시간 자동저장
    private LocalDateTime createdDate;

    @LastModifiedDate//조회한 entity의 값을 변경할 때 시간 자동 저장
    private LocalDateTime modifiedDate;

}


