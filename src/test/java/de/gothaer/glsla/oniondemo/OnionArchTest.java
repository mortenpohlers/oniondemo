package de.gothaer.glsla.oniondemo;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.Test;
import static com.tngtech.archunit.library.Architectures.onionArchitecture;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

public class OnionArchTest {

    @Test
    public void onionArchitectureTest(){
        JavaClasses jc = new ClassFileImporter().importPackages("de.gothaer.glsla.oniondemo");

        var onionArchitecture = onionArchitecture()
                .domainModels("de.gothaer.glsla.oniondemo.domain.aggregates")
                .domainServices("de.gothaer.glsla.oniondemo.domain.services")
                .applicationServices("de.gothaer.glsla.oniondemo.application.services")
                .adapter("rest","de.gothaer.glsla.oniondemo.adapter.rest")
                .adapter("persistence","de.gothaer.glsla.oniondemo.adapter.persistence");
        onionArchitecture.check(jc);
    }

    @Test
    public void domainTechnicFree(){
        JavaClasses jc = new ClassFileImporter().importPackages("de.gothaer.glsla.oniondemo.domain");
        var domainTechnicFree = noClasses().that().resideInAnyPackage("..domain..")
                .should().dependOnClassesThat()
                .resideInAnyPackage("..springframework..")
                .orShould().dependOnClassesThat().resideInAnyPackage("jakarta.persistence..");
        domainTechnicFree.check(jc);

    }
}
