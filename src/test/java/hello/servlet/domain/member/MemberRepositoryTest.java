package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

	MemberRepository memberRepository = MemberRepository.getInstance();

	@AfterEach
	void afterEach(){
		memberRepository.clearStore();
	}

	@Test
	void save() {
		// given
		Member user1 = new Member("user1", 20);

		// when
		Member saveMember = memberRepository.save(user1);

		//then
		Member findMember = memberRepository.findById(saveMember.getId());
		assertThat(findMember).isEqualTo(saveMember);
	}

	@Test
	void getInstance() {
	}


	@Test
	void findById() {
	}

	@Test
	void finaAll() {
		// given
		Member user1 = new Member("user1", 20);
		Member user2 = new Member("user2", 22);

		memberRepository.save(user1);
		memberRepository.save(user2);

		// when
		List<Member> members = memberRepository.finaAll();

		// then
		assertThat(members.size()).isEqualTo(2);
		assertThat(members).contains(user1, user2);
	}

	@Test
	void clearStore() {
	}
}