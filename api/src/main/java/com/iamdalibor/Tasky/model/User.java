package com.iamdalibor.Tasky.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String fName;
    private String lName;
    private String avatar;
    private LocalDateTime regDate;
    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id")
    private List<Group> groupsList;
    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id")
    private List<Board> boardsList;

    public User(String email, String fName, String lName, String avatar, LocalDateTime regDate, List<Group> groupsList, List<Board> boardsList) {
        this.email = email;
        this.fName = fName;
        this.lName = lName;
        this.avatar = avatar;
        this.regDate = LocalDateTime.now();
        this.groupsList = new ArrayList<>();
        this.boardsList = new ArrayList<>();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
