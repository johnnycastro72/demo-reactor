package com.sofkau.demoreactor.operador;

import com.sofkau.demoreactor.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Maths {
    private static final Logger log = LoggerFactory.getLogger(Creacion.class);

    public void average() {
        List<Person> persons1 = new ArrayList<>();
        persons1.add(new Person(1, "Uno", 11));
        persons1.add(new Person(2, "Dos", 12));
        persons1.add(new Person(3, "Tres", 13));

        Flux.fromIterable(persons1)
                .collect(Collectors.averagingInt(Person::getAge))
                .subscribe(p -> log.info(p.toString()));

    }

    public void count() {
        List<Person> persons1 = new ArrayList<>();
        persons1.add(new Person(1, "Uno", 11));
        persons1.add(new Person(2, "Dos", 12));
        persons1.add(new Person(3, "Tres", 13));

        Flux.fromIterable(persons1)
                .count()
                .subscribe(p -> log.info(p.toString()));

    }

    public void min() {
        List<Person> persons1 = new ArrayList<>();
        persons1.add(new Person(1, "Uno", 11));
        persons1.add(new Person(2, "Dos", 12));
        persons1.add(new Person(3, "Tres", 13));

        Flux.fromIterable(persons1)
                .collect(Collectors.minBy(Comparator.comparing(Person::getAge)))
                .subscribe(p -> log.info(p.get().toString()));

    }

    public void sum() {
        List<Person> persons1 = new ArrayList<>();
        persons1.add(new Person(1, "Uno", 11));
        persons1.add(new Person(2, "Dos", 12));
        persons1.add(new Person(3, "Tres", 13));

        Flux.fromIterable(persons1)
                .collect(Collectors.summingInt(Person::getAge))
                .subscribe(p -> log.info(p.toString()));

    }

    public void summarizing() {
        List<Person> persons1 = new ArrayList<>();
        persons1.add(new Person(1, "Uno", 11));
        persons1.add(new Person(2, "Dos", 12));
        persons1.add(new Person(3, "Tres", 13));

        Flux.fromIterable(persons1)
                .collect(Collectors.summarizingInt(Person::getAge))
                .subscribe(p -> log.info(p.toString()));

    }
}
