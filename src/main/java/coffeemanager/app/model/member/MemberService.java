package coffeemanager.app.model.member;

import coffeemanager.app.controller.member.form.UpdateForm;
import coffeemanager.app.model.auth.code.Role;
import coffeemanager.app.model.member.dto.Member;
import coffeemanager.app.model.member.dto.Principal;
import coffeemanager.infra.error.exceptions.CommonException;
import coffeemanager.infra.response.ResponseCode;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService{
    
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;
    private Member member;
    
    @Transactional
    public void signup(Member dto) {
        if(memberRepository.existsMember(dto.getEmail()))
            throw new CommonException(ResponseCode.BAD_REQUEST);
        
        String encodedPassword = passwordEncoder.encode(dto.getPassword());
        dto.setPassword(encodedPassword);

        memberRepository.insert(dto);
    }
    
    public Principal signin(String email, String password) {
        
        Optional<Member> optional = memberRepository.selectByEmail(email);

        Member member = optional.get();

        return new Principal(email, List.of(Role.ROLE_USER), LocalDateTime.now());
    }
    
    public Boolean isDuplicatedId(String email) {
        return memberRepository.existsMember(email);
    }
    
    public Member findByEmail(String email) {
        return memberRepository.selectByEmail(email)
                            .orElseThrow(() -> new CommonException(ResponseCode.BAD_REQUEST));
    }

    public void update(UpdateForm dto) {
        String encodedPassword = passwordEncoder.encode(dto.getPassword());
        dto.setPassword(encodedPassword);

        memberRepository.update(dto);
    }

    public void delete(String email, String password) {
        Member member = memberRepository.findByEmail(email)
            .orElseThrow(() -> new CommonException(ResponseCode.BAD_REQUEST));

        if (!passwordEncoder.matches(password, member.getPassword())) {
            throw new CommonException(ResponseCode.BAD_REQUEST);
        }

        memberRepository.delete(member.getEmail());
    }
}
