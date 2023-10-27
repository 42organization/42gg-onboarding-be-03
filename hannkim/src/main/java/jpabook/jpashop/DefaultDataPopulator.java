package jpabook.jpashop;

import jpabook.jpashop.domain.Meeting;
import jpabook.jpashop.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DefaultDataPopulator implements ApplicationRunner {
  @Autowired
  MeetingRepository meetingRepository;

  // spring data redis에서 template 알아보기
//  @Autowired
//  StringRedisTemplate redisTemplate;

  @Override
  public void run(ApplicationArguments args) throws Exception {

    Meeting meeting = new Meeting();
    meeting.setTitle("New Meeting");
    meeting.setStartAt(new Date());
    meetingRepository.save(meeting);

    meetingRepository.findAll().forEach(m -> {
      System.out.println("==============");
      System.out.println(m.getTitle() + " " + m.getStartAt());
    });
  }
}
