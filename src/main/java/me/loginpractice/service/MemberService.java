package me.loginpractice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.loginpractice.controller.request.JoinRequest;
import me.loginpractice.domain.Member;
import me.loginpractice.repository.MemberRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public Long save(JoinRequest dto) {
        Member member = memberRepository.save(Member.of(dto.getEmail(), bCryptPasswordEncoder.encode(dto.getPassword())));
        return member.getId();
    }
}
