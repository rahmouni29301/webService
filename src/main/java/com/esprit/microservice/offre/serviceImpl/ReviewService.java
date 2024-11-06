package com.esprit.microservice.offre.serviceImpl;

import com.esprit.microservice.offre.entity.Review;
import com.esprit.microservice.offre.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class ReviewService implements ReviewRepository {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void flush() {
        reviewRepository.flush();
    }

    @Override
    public <S extends Review> S saveAndFlush(S entity) {
        return reviewRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends Review> List<S> saveAllAndFlush(Iterable<S> entities) {
        return reviewRepository.saveAllAndFlush(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Review> entities) {
        reviewRepository.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> ids) {
        reviewRepository.deleteAllByIdInBatch(ids);
    }

    @Override
    public void deleteAllInBatch() {
        reviewRepository.deleteAllInBatch();
    }

    @Override
    public Review getOne(Long id) {
        return reviewRepository.getOne(id);
    }

    @Override
    public Review getById(Long id) {
        return reviewRepository.getById(id);
    }

    @Override
    public Review getReferenceById(Long id) {
        return reviewRepository.getReferenceById(id);
    }

    @Override
    public <S extends Review> Optional<S> findOne(Example<S> example) {
        return reviewRepository.findOne(example);
    }

    @Override
    public <S extends Review> List<S> findAll(Example<S> example) {
        return reviewRepository.findAll(example);
    }

    @Override
    public <S extends Review> List<S> findAll(Example<S> example, Sort sort) {
        return reviewRepository.findAll(example, sort);
    }

    @Override
    public <S extends Review> Page<S> findAll(Example<S> example, Pageable pageable) {
        return reviewRepository.findAll(example, pageable);
    }

    @Override
    public <S extends Review> long count(Example<S> example) {
        return reviewRepository.count(example);
    }

    @Override
    public <S extends Review> boolean exists(Example<S> example) {
        return reviewRepository.exists(example);
    }

    @Override
    public <S extends Review, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return reviewRepository.findBy(example, queryFunction);
    }

    @Override
    public <S extends Review> S save(S entity) {
        return reviewRepository.save(entity);
    }

    @Override
    public <S extends Review> List<S> saveAll(Iterable<S> entities) {
        return reviewRepository.saveAll(entities);
    }

    @Override
    public Optional<Review> findById(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return reviewRepository.existsById(id);
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public List<Review> findAllById(Iterable<Long> ids) {
        return reviewRepository.findAllById(ids);
    }

    @Override
    public long count() {
        return reviewRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public void delete(Review entity) {
        reviewRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        reviewRepository.deleteAllById(ids);
    }

    @Override
    public void deleteAll(Iterable<? extends Review> entities) {
        reviewRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        reviewRepository.deleteAll();
    }

    @Override
    public List<Review> findAll(Sort sort) {
        return reviewRepository.findAll(sort);
    }

    @Override
    public Page<Review> findAll(Pageable pageable) {
        return reviewRepository.findAll(pageable);
    }
}
