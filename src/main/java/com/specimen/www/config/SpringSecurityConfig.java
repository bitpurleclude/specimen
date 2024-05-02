package com.specimen.www.config;
import com.alibaba.fastjson.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.io.IOException;
import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class SpringSecurityConfig  {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(Arrays.asList("*")); // 使用allowedOriginPatterns替代allowedOrigins
        configuration.setAllowedMethods(Arrays.asList("GET","POST", "PUT", "DELETE", "OPTIONS")); // 允许所有HTTP方法
        configuration.setAllowCredentials(true); // 允许发送cookies
        configuration.setAllowedHeaders(Arrays.asList("*")); // 允许所有头部信息

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // 对所有URL应用这个CORS配置
        return source;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors.configurationSource(corsConfigurationSource())) // 使用新的方法替换http.cors()
                .addFilterBefore(loginFilter(authenticationManager(http.getSharedObject(AuthenticationConfiguration.class))), UsernamePasswordAuthenticationFilter.class)
                .csrf((csrf) -> csrf.disable())
                .formLogin(formLogin -> formLogin
                        .loginProcessingUrl("/user/authentication/login").permitAll()
                        .loginPage("/user/authentication/html/Login.html")
                        .permitAll()
                )
                .authorizeHttpRequests(authorize -> authorize
                        //.requestMatchers("/*").permitAll()
                        //.requestMatchers("/user/authentication/*").permitAll()
                        //.requestMatchers("/hello").permitAll()
                        //.requestMatchers("/html/SvgDraw.html").permitAll()
                        .anyRequest().permitAll()
                )
                ;

        return http.build();
    }
    CustomUsernamePasswordAuthenticationFilter loginFilter(AuthenticationManager authenticationManager) throws Exception {
        CustomUsernamePasswordAuthenticationFilter loginFilter = new CustomUsernamePasswordAuthenticationFilter(authenticationManager);
        loginFilter.setFilterProcessesUrl("/user/authentication/login");
        loginFilter.setUsernameParameter("email");
        loginFilter.setPasswordParameter("password");
//        loginFilter.setAuthenticationManager();
        return loginFilter;
    }
}
