package sgo.on3th.entity.items;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sgo.on3th.entity.Item;

@Entity @Getter
@DiscriminatorValue("M")
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@AllArgsConstructor
public class Movie extends Item {

    private String director;
    private String actor;
}
