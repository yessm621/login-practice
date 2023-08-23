package me.loginpractice.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Objects;

@Entity
@Getter
@Table(indexes = {
        @Index(columnList = "email", unique = true)
})
@SQLDelete(sql = "UPDATE \"member\" SET deleted_at = NOW() where id=?")
@Where(clause = "deleted_at is NULL")
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false, length = 100)
    private String nickname;

    @Column(nullable = false, length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    private MemberRole role = MemberRole.USER;

    protected Member() {
    }

    private Member(Long id, String email, String password, String nickname, String name, MemberRole role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.name = name;
        this.role = role;
    }

    // dto to Entity
    public static Member of(Long id, String email, String password, String nickname, String name, MemberRole role) {
        return new Member(id, email, password, nickname, name, role);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member member)) return false;
        return id != null && Objects.equals(id, member.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
