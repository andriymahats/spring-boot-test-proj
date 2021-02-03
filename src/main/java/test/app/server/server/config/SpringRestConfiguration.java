package test.app.server.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.core.mapping.ExposureConfiguration;
import org.springframework.data.rest.core.mapping.RepositoryDetectionStrategy;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import test.app.server.server.entity.A;
import test.app.server.server.entity.B;

@Component
public class SpringRestConfiguration implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.setRepositoryDetectionStrategy(RepositoryDetectionStrategy.RepositoryDetectionStrategies.ANNOTATED);
        config.setExposeRepositoryMethodsByDefault(false);
        config.exposeIdsFor(A.class);
        config.exposeIdsFor(B.class);
        ExposureConfiguration exposureConfiguration = config.getExposureConfiguration();
        exposureConfiguration.withItemExposure((metadata, httpMethods) -> httpMethods.disable(HttpMethod.PATCH));
    }

    @Autowired
    private Validator validator;

    @Override
    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
        validatingListener.addValidator("beforeCreate", validator);
        validatingListener.addValidator("beforeSave", validator);
    }

}