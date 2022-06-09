package io.beneta.member;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Builder
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String web_id;
    private String password;
    private String email;
    private LocalDateTime lastlogintime;

    @CreatedDate
    private LocalDateTime created_date = LocalDateTime.now();
    @LastModifiedDate
    private LocalDateTime modified_date = LocalDateTime.now();

}
