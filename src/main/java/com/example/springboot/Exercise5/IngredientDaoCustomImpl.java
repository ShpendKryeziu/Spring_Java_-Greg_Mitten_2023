package com.example.springboot.Exercise5;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Component
public class IngredientDaoCustomImpl implements IngredientDaoCustom {
    @Override
    public void updateById(Ingredient ingredient, Long ingredientId) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/main", "root", "Zx3?21FbGa47!+S5x9k");
        Statement stmt = con.createStatement();
        String query = "update main.ingredient set name = '" + ingredient.getName() + "', is_vegeterian = "
                + ingredient.isVegetarian() + ", is_vegan = " + ingredient.isVegan() + ", is_gluten_free = "
                + ingredient.isGlutenFree() + ", is_lactose_free = " + ingredient.isLactoseFree()
                + " where id = " + ingredientId;

        stmt.executeUpdate(query);
        con.close();
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Ingredient> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Ingredient> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Ingredient> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Ingredient getOne(Long aLong) {
        return null;
    }

    @Override
    public Ingredient getById(Long aLong) {
        return null;
    }

    @Override
    public Ingredient getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Ingredient> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Ingredient> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Ingredient> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Ingredient> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Ingredient> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Ingredient> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Ingredient, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Ingredient> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Ingredient> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Ingredient> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Ingredient> findAll() {
        return null;
    }

    @Override
    public List<Ingredient> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Ingredient entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Ingredient> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Ingredient> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Ingredient> findAll(Pageable pageable) {
        return null;
    }
}
