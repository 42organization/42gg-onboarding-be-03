package onboarding03.be03.entity.items;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import onboarding03.be03.entity.Item;


@Entity
@DiscriminatorValue("A")
@Getter
@Setter
public class Book extends Item {

    private String author;
    private String isbn;
}