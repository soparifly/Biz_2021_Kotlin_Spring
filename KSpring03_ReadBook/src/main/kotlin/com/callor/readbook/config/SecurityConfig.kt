package com.callor.readbook.config

import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.security.servlet.AntPathRequestMatcherProvider
import org.springframework.boot.autoconfigure.security.servlet.PathRequest
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

@SpringBootConfiguration
// spring Security 를 Custom 하겠다 라는 선언
@EnableWebSecurity
class SecurityConfig:WebSecurityConfigurerAdapter() {

    override fun configure(web: WebSecurity) {
        web.ignoring().antMatchers(
            "/static/**",
            "/static/css/**",
            "/static/js/**",
            "/static/images/**",
        "*.ico","*.txt"
        )
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations())
    }

    override fun configure(http: HttpSecurity) {

        http.authorizeRequests()
            .antMatchers("/member/**").permitAll()
            .mvcMatchers("/**") // 모든 request 에 대하여
            .anonymous()
            .mvcMatchers("/admin")
            .fullyAuthenticated()
            .antMatchers("/**").permitAll()
        http.formLogin().loginPage("/member/login").permitAll().loginProcessingUrl("/login")
        http.logout().logoutRequestMatcher(AntPathRequestMatcher("/logout"))


            .logoutSuccessUrl("/member/mypage")

    }
}