package de.gothaer.glsla.oniondemo.application.services;

import de.gothaer.glsla.oniondemo.domain.services.BerechnungsRepository;
import de.gothaer.glsla.oniondemo.domain.services.BerechnungsService;
import de.gothaer.glsla.oniondemo.domain.services.internal.BerechnungsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BerechnungsServiceConfiguration {

    private final BerechnungsRepository repository;
    // Wirkt hier völlig verloren, aber auf der Ebene würde sich chaching, transactionsmanagement etc. abspielen.
    @Bean
    public BerechnungsService createBerechnungsservice(){
        return new BerechnungsServiceImpl(repository);
    }

}
