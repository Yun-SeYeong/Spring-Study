package japbook.jpashap;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testMember() throws  Exception {
        Member member = new Member();
        member.setUsername("memberA");

        Long savedId = memberRepository.save(member);
        Member findMemeber = memberRepository.find(savedId);

        Assertions.assertThat(findMemeber.getId()).isEqualTo(savedId);
        Assertions.assertThat(findMemeber.getUsername()).isEqualTo(member.getUsername());
        Assertions.assertThat(findMemeber).isEqualTo(member);
    }
}