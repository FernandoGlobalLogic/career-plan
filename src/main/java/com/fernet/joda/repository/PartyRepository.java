package com.fernet.joda.repository;

import generated.Party;
import generated.Person;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import static generated.PartyType.ELECTRONIC;
import static generated.PartyType.ROCK_FESTIVAL;


/**
 * Repository to partialy get party data.
 * This could extend from Spring-CrudRepositry and could have a DB connection configuration.
 */
@Component
public class PartyRepository {
    private static final Map<String, Party> parties = new HashMap<>();

    @PostConstruct
    public void initData() {
        Person electronicManager = new Person();
        electronicManager.setName("Juan Carlos Electronica");
        Party electronic = new Party();
        electronic.setName("Bombastic electronic party");
        electronic.setPerson(electronicManager);
        electronic.setType(ELECTRONIC);

        parties.put(electronic.getName(), electronic);

        Party rockFestival = new Party();
        Person rockManager = new Person();
        electronicManager.setName("Rock & Roll Nena");
        rockFestival.setName("Cosquin Rock");
        rockFestival.setPerson(rockManager);
        rockFestival.setType(ROCK_FESTIVAL);

        parties.put(rockFestival.getName(), rockFestival);

    }

    public Party findParty(String name) {
        Assert.notNull(name, "The country's name must not be null");
        return parties.get(name);
    }
}
