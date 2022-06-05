package com.sofkau.demoreactor.filter;

import com.sofkau.demoreactor.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Filtrado {

    private static final Logger log = LoggerFactory.getLogger(Filtrado.class);

    public void filtrar() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Uno", 11));
        persons.add(new Person(2, "Dos", 12));
        persons.add(new Person(3, "Tres", 13));

        Flux.fromIterable(persons)
                .filter(person -> person.getAge() > 12)
                .subscribe(p -> log.info(p.toString()));
    }

    public void distinto() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Uno", 11));
        persons.add(new Person(1, "Dos", 12));
        persons.add(new Person(3, "Tres", 13));

        Flux.fromIterable(persons)
                .distinct()
                .subscribe(p -> log.info(p.toString()));

    }

    public void tomar() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Uno", 11));
        persons.add(new Person(1, "Dos", 12));
        persons.add(new Person(3, "Tres", 13));

        Flux.fromIterable(persons)
                .take(1)
                .subscribe(p -> log.info(p.toString()));
    }

    public void tomarultimo() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Uno", 11));
        persons.add(new Person(1, "Dos", 12));
        persons.add(new Person(3, "Tres", 13));

        Flux.fromIterable(persons)
                .takeLast(1)
                .subscribe(p -> log.info(p.toString()));
    }

    public void saltar() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Uno", 11));
        persons.add(new Person(2, "Dos", 12));
        persons.add(new Person(3, "Tres", 13));

        Flux.fromIterable(persons)
                .skip(1)
                .subscribe(p -> log.info(p.toString()));
    }

    public void saltarultimo() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Uno", 11));
        persons.add(new Person(2, "Dos", 12));
        persons.add(new Person(3, "Tres", 13));

        Flux.fromIterable(persons)
                .skipLast(1)
                .subscribe(p -> log.info(p.toString()));
    }

}
