package com.util.admin.domain.posts;

import com.util.admin.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor//기본 생성자 자동 추가
@Entity//테이블과 링크될 클래스
//entity에서는 setter 만들면 안됨
public class Posts extends BaseTimeEntity {
    @Id//pk
    //auto increment
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    //기본값 외에 추가로 변경이 필요할 때 사용
    //기본 문자열길이가255 임으로 500으로 늘릴때 사용
    @Column(length=500, nullable=false)
    private String title;

    //기본값 외에 추가로 변경이 필요할 때 사용
    //타입을 text로 변경하고 싶을 때 사용
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title=title;
        this.content=content;
        this.author=author;
    }

    public void update(String title, String content){
        this.title=title;
        this.content=content;
    }
}
