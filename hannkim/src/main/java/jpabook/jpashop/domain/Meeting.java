package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.util.Date;

@Getter @Setter
@RedisHash("Meetings")
public class Meeting {
  @Id
  private String id;

  private String title;

  private Date startAt;

}
