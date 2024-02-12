package onboarding03.be03.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity  //  User 객체와 DB 테이블을 매핑
public class Delivery {
    @Id // 변수 PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 값이 없어도 자동으로 할당
    @Column(name = "delivery_id")
    private Long deliveryId;
    @Embedded
    private Address deliveryAddress;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member", referencedColumnName = "order")
    private Order order;
}
