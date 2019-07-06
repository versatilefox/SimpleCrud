package firstapp.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user")
public class User implements UserDetails {
    @Column(name="login")
    private String login;

    @Column(name="password")
    private String password;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Role.class)
    @JoinTable(name = "role_user",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> role;




    public User() {
    }


    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String login, String password, Long id) {
        this.login = login;
        this.password = password;
        this.id = id;
    }


    public User(String login, String password, Long id, String name) {
        this.login = login;
        this.password = password;
        this.id = id;
        this.name = name;
    }
    public User(String login, String password, Long id, String name, Set<Role> role) {
        this.login = login;
        this.password = password;
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public User(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public User(String login, String password, String name, Set<Role> role) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return role;
    }

    public String getUserOrAdmin(Set<Role> role){
        if (role.contains(new Role("admin"))){
            return "admin";
        }else{
            return "user";
        }
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    } //аккаунт актуален

    @Override
    public boolean isAccountNonLocked() {
        return true;
    } //не заблокирован

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    } //учетные данные актуальны

    @Override
    public boolean isEnabled() {
        return true;
    } //включен


    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(name, user.name) &&
                Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, id, name, role);
    }
}