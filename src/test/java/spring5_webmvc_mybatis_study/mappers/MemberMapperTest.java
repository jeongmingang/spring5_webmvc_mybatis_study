package spring5_webmvc_mybatis_study.mappers;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import spring5_webmvc_mybatis_study.config.ContextRoot;
import spring5_webmvc_mybatis_study.dto.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ContextRoot.class} )
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
public class MemberMapperTest {
	private static final Log log = LogFactory.getLog(MemberMapperTest.class);
	
	@Autowired
	private MemberMapper mapper;

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01SelectMemberByEmail() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		String email = "test3@naver.com";
		
		Member member = mapper.selectMemberByEmail(email);
		log.debug(member.toString());
		
		Assert.assertNotNull(member);
	}
	
	@Test
	public void test02SelectMemberAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		List<Member> list = mapper.selectMemberAll();
		Assert.assertNotNull(list);
		
		list.forEach(s->log.debug(s.toString()));
	}
	
	@Test
	public void test03CountMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		int cnt = mapper.countMember();
		Assert.assertNotEquals(-1, cnt);
		
		log.debug("cnt >> " + cnt);
	}
	
	@Test
	public void test04InsertMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Member newMember = new Member("test20@test.co.kr", "1234", "test20");
		
		int res = mapper.insertMember(newMember);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test05updateMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Member upMember = new Member("test20@test.co.kr", "2222", "테스트20");
		
		int res = mapper.updateMember(upMember);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test06DeleteMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Member delMember = new Member("test20@test.co.kr", "2222", "테스트20");
		
		int res = mapper.deleteMember(delMember);
		Assert.assertEquals(1, res);
	}

}
