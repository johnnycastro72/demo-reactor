package com.sofkau.demoreactor.operador;

import com.sofkau.demoreactor.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Condicional {

    private static final Logger log = LoggerFactory.getLogger(Creacion.class);

    public void defaultIfEmpty() {
        //Mono.empty()
        //Flux.empty()
        Mono.just(new Person(1, "J2c", 50))
                .defaultIfEmpty(new Person(0, "DEFAULT", 99))
                .subscribe(x -> log.info(x.toString()));
    }

    public void takeUntil() {
        List<Person> persons1 = new ArrayList<>();
        persons1.add(new Person(1, "Uno", 11));
        persons1.add(new Person(2, "Dos", 12));
        persons1.add(new Person(3, "Tres", 13));

        Flux.fromIterable(persons1)
                .takeUntil(p -> p.getAge() > 11)
                .subscribe(x -> log.info(x.toString()));
    }

    public void timeOut() throws InterruptedException {
        List<Person> persons1 = new ArrayList<>();
        persons1.add(new Person(1, "Uno", 11));
        persons1.add(new Person(2, "Dos", 12));
        persons1.add(new Person(3, "Tres", 13));

        Flux.fromIterable(persons1)
                .delayElements(Duration.ofSeconds(1))
                .timeout(Duration.ofSeconds(2))
                .subscribe(x -> log.info(x.toString()));

        Thread.sleep(10000);
    }
}
