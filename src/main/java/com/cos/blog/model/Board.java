package com.cos.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob //  대용량 데이터
    private String content; //

    @ColumnDefault("0")
    private int count;

    @ManyToOne(fetch = FetchType.EAGER) // Many == board, User = One 연간관계. EAGER 무조건
    @JoinColumn(name="userId") //
    private User user; // DB는 오브젝트를 저장할 수 없다. 자바는 오브젝트를 저장할수있음.

    //DB에 컬럼 만들지마.
    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER) // mappedBy 연관관계의 주인이 아니다. (난 FK가 아님)
    private List<Reply> reply;

    @CreationTimestamp
    private Timestamp createDate;

}
