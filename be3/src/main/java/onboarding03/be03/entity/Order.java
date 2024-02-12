package onboarding03.be03.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity  //  User 객체와 DB 테이블을 매핑
public class Order {
    @Id // 변수 PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 값이 없어도 자동으로 할당
    private Long orderId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    @OneToOne(mappedBy = "order")
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;
    private Date orderDate;
    @Enumerated(EnumType.STRING)
    private Status orderStatus;
    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    private List<OrderItem> orderItem = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        this.orderDate = new Date();
    }
}
