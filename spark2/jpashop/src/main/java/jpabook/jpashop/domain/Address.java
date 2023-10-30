package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable //어딘가에 내장될 수 있음 (JPA의 내장 타입)
@Getter
public class Address { //값은 생성할 때만 세팅하고 Setter 제공하지 않음

    private String city;
    private String street;
    private String zipcode;

    protected Address() { //기본 생성자
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
