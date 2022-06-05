package com.sofkau.demoreactor.operador;

import com.sofkau.demoreactor.model.Person;
import com.sofkau.demoreactor.model.Sale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Combinacion {

    private static final Logger log = LoggerFactory.getLogger(Creacion.class);

    public void merge() {
        List<Person> persons1 = new ArrayList<>();
        persons1.add(new Person(1, "Uno", 11));
        persons1.add(new Person(2, "Dos", 12));
        persons1.add(new Person(3, "Tres", 13));

        List<Person> persons2 = new ArrayList<>();
        persons2.add(new Person(4, "Uno", 11));
        persons2.add(new Person(5, "Dos", 12));
        persons2.add(new Person(6, "Tres", 13));

        List<Sale> sales = new ArrayList<>();
        sales.add(new Sale(1, LocalDateTime.now()));

        Flux<Person> fx1 = Flux.fromIterable(persons1);
        Flux<Person> fx2 = Flux.fromIterable(persons2);
        Flux<Sale> fx3 = Flux.fromIterable(sales);

        Flux.merge(fx1, fx2, fx3)
                .subscribe(p -> log.info(p.toString()));
    }

    public void zip() {
        List<Person> persons1 = new ArrayList<>();
        persons1.add(new Person(1, "Uno", 11));
        persons1.add(new Person(2, "Dos", 12));
        persons1.add(new Person(3, "Tres", 13));

        List<Person> persons2 = new ArrayList<>();
        persons2.add(new Person(4, "Uno", 11));
        persons2.add(new Person(5, "Dos", 12));
        persons2.add(new Person(6, "Tres", 13));

        List<Sale> sales = new ArrayList<>();
        sales.add(new Sale(1, LocalDateTime.now()));

        Flux<Person> fx1 = Flux.fromIterable(persons1);
        Flux<Person> fx2 = Flux.fromIterable(persons2);
        Flux<Sale> fx3 = Flux.fromIterable(sales);

/*        Flux.zip(fx1, fx2, (p1,p2) -> String.format("Flux1: %s, Flux2: %s", p1,p2))
                .subscribe(x -> log.info(x));*/

        Flux.zip(fx1, fx2, fx3)
                .subscribe(x -> log.info(x.toString()));
    }

    public void zipWith() {
        List<Person> persons1 = new ArrayList<>();
        persons1.add(new Person(1, "Uno", 11));
        persons1.add(new Person(2, "Dos", 12));
        persons1.add(new Person(3, "Tres", 13));

        List<Person> persons2 = new ArrayList<>();
        persons2.add(new Person(4, "Uno", 11));
        persons2.add(new Person(5, "Dos", 12));
        persons2.add(new Person(6, "Tres", 13));

        List<Sale> sales = new ArrayList<>();
        sales.add(new Sale(1, LocalDateTime.now()));

        Flux<Person> fx1 = Flux.fromIterable(persons1);
        Flux<Person> fx2 = Flux.fromIterable(persons2);
        Flux<Sale> fx3 = Flux.fromIterable(sales);

        fx1.zipWith(fx2, (pe1, pe2) -> String.format("Flux1: %s, Flux2: %s", pe1,pe2))
                .subscribe(x -> log.info(x.toString()));

    }
}
