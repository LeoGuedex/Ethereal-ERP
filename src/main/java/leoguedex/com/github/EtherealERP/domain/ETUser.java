package leoguedex.com.github.EtherealERP.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ETUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String personFunction;

    @Column(unique = true)
    private String email;

    private String password;
    private Boolean admin;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_data", referencedColumnName = "id")
    private ETUserData userData;

    public String generateFullName() {
        return new StringBuilder()
                .append(userData.getFirstName())
                .append(" ")
                .append(userData.getLastName())
                .toString();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.admin) {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER"));
        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
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
