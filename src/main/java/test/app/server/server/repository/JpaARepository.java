package test.app.server.server.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import test.app.server.server.entity.A;

import java.util.Optional;


@RepositoryRestResource
public interface JpaARepository extends JpaRepository<A, Long> {

    @Override
    @RestResource
    Page<A> findAll(Pageable pageable);

    @RestResource
    @Override
    Optional<A> findById(Long aLong);

    @Override
    @RestResource
    A save(A entity);

}