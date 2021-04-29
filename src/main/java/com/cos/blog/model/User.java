package com.cos.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity //@DynamicInsert insert시 null값 제외해줌.
public class User {

    @Id //primary ket
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라감.
    private int id; // 시퀀스,auto_increment

    @Column(nullable = false, length = 30, unique = true)
    private String username; // 아이디

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    @ColumnDefault("'USER'")
    @Enumerated(EnumType.STRING) // database는 RoleType이란게 없기때문에 스트링이라고 말해줘야됌.
    private RoleType role; // Enum 도메인이정해졌다 == 범위가 정해졌다.

    @CreationTimestamp
    private Timestamp createDate;

}

