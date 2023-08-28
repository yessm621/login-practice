package me.loginpractice.config;

import me.loginpractice.domain.Member;
import me.loginpractice.repository.MemberRepository;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@Import(SecurityConfig.class)
public class TestSecurityConfig {

    @MockBean
    private MemberRepository memberRepository;

    @BeforeTestMethod
    void securitySetUp() {
        given(memberRepository.findByEmail(anyString())).willReturn(Optional.of(Member.of(
                "test@gmail.com", "test"
        )));
    }
}
