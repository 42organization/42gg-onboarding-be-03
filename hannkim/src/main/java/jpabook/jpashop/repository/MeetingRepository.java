package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Meeting;
import org.springframework.data.repository.CrudRepository;

public interface MeetingRepository extends CrudRepository<Meeting, String> {
}
