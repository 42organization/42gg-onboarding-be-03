package sgo.on3th.entity.items;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sgo.on3th.entity.Item;


@Entity @Getter
@DiscriminatorValue("I")
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@AllArgsConstructor
public class Album extends Item {

    private String artist;
    private String etc;
}