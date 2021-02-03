package test.app.server.server.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import test.app.server.server.entity.B;

import java.util.Optional;


@RepositoryRestResource
public interface JpaBRepository extends JpaRepository<B, Long> {

    @Override
    @RestResource
    Page<B> findAll(Pageable pageable);

    @RestResource
    @Override
    Optional<B> findById(Long aLong);

    @Override
    @RestResource
    B save(B entity);

}
