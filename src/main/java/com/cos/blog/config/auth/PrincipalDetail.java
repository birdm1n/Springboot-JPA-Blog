package com.cos.blog.config.auth;

import com.cos.blog.model.User;
import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Getter
// 스프링 시큐리티가 로그인 요청을 가로채서 로그인을 진행하고 완료가되면 UserDetails 타입의 오브젝트를
// 스프링 시큐리티의 고유한 세션저장소에 저장을 해준다.
public class PrincipalDetail implements UserDetails {
    private User user; //콤포지션

    public PrincipalDetail(User user){
        this.user = user;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    // 계정이 만료되지 않았는지 리턴한다. (true : 만료 안됨)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정이 잠겨있진 않았는지 리턴한다. (true : 잠기지 않음)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }


    // 비밀번호가 만료되지 않았는지 리턴한다. (true : 만료안됨)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정활성화가 되어있는지 리턴한다. (true : 활성화)
    @Override
    public boolean isEnabled() {
        return true;
    }


    // 계정의 권한을 리턴해준다.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collectors = new ArrayList<>();
        /*collectors.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "ROLE_"+user.getRole(); // ROLE_USER 꼭 ROLE_ 넣어줘야함.
            }
        }); */// java는 오브젝트를 넘겨줄순있어도 method를 넘겨줄수 없으므로 이렇게 표현하고
        // 람다식으로 표현가능.

        collectors.add(() -> {

            return "ROLE_" + user.getRole();
        });


        return collectors;
    }

}
