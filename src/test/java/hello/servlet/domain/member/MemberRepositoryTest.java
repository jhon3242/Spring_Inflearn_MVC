package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

	MemberRepository memberRepository = MemberRepository.getInstance();

	@AfterEach
	void afterEach() {
		memberRepository.clearStore();
	}

	@Test
	void save() {
		Member memberA = new Member("memberA", 20);

		memberRepository.save(memberA);

		assertThat(memberRepository.findById(memberA.getId())).isEqualTo(memberA);
	}


	@Test
	void findAll() {
		Member memberA = new Member("memberA", 20);
		Member memberB = new Member("memberB", 21);

		memberRepository.save(memberA);
		memberRepository.save(memberB);
		List<Member> result = memberRepository.findAll();

		assertThat(result.size()).isEqualTo(2);
		assertThat(result).contains(memberA, memberB);

	}
}