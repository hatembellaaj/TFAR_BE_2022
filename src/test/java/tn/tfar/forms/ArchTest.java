package tn.tfar.forms;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("tn.tfar.forms");

        noClasses()
            .that()
            .resideInAnyPackage("tn.tfar.forms.service..")
            .or()
            .resideInAnyPackage("tn.tfar.forms.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..tn.tfar.forms.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
