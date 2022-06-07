package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {
	private static Map<Long, Member> store = new HashMap<>();
	private static long sequece = 0L;

	private static final MemberRepository instance = new MemberRepository();

	public static MemberRepository getInstance(){
		return instance;
	}

	private MemberRepository() { // 생성자를 막아야함
	}

	public Member save(Member member){
		member.setId(++sequece);
		store.put(member.getId(), member);
		return member;
	}

	public Member findById(Long id){
		return store.get(id);
	}

	public List<Member> finaAll() {
		return new ArrayList<>(store.values());  // 이렇게 하면 store 에 있는 모든 value 들을 가지고 새로운 리스트를 만들어서 반환
	}

	public void clearStore(){
		store.clear();
	}
}
