@Configuration
@EnableWebSecurity
public class BasicAuthConfiguration {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withUsername("user")
            .password("{noop}password")
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf()
            .disable()
            .authorizeRequests()
            .antMatchers(HttpMethod.OPTIONS, "/**")
            .permitAll()
            .antMatchers("/login")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic();
        return http.build();
    }
}