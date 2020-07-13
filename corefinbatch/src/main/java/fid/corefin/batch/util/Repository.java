package fid.corefin.batch.util;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Stereotype;

import org.apache.deltaspike.jpa.api.transaction.Transactional;

@Retention(RUNTIME)
@ApplicationScoped
@Stereotype
@Transactional
@Target(ElementType.TYPE)
public @interface Repository {

}
