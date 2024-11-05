package dasturlash.uz.repository;

import dasturlash.uz.entity.StudentEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {

    // select * from student where name=?
    List<StudentEntity> findByName(String name);

    List<StudentEntity> getByName(String name);

    List<StudentEntity> readByName(String name);

    List<StudentEntity> queryByName(String name);

    List<StudentEntity> findAllByName(String name);


    // select * from student where id=?
    Optional<StudentEntity> findById(Integer id);

    // select * from student where name=?
//    StudentEntity findBySurname(String surname);
    Optional<StudentEntity> findBySurname(String surname);

    // select * from student where name=? and surname=?
    List<StudentEntity> findByNameAndSurname(String name, String surname);

    // select * from student where name=? and surname=? and email=? and age=?
    List<StudentEntity> findByNameAndSurnameAndEmailAndAge(String name, String surname,
                                                           String email, int age);

    // select * from student where name=? or surname=?
    List<StudentEntity> findByNameOrSurname(String name, String surname);

    // select * from student where name=? or age=?
    List<StudentEntity> findByNameOrAge(String name, Integer age);

    // select * from student where name=? and surname=? or age=?
    List<StudentEntity> findByNameAndSurnameOrAge(String name, String surname, Integer age);

    // select distinct * from student
    List<StudentEntity> findDistinctBy();

    // select distinct * from student where name=?
    List<StudentEntity> findDistinctByName(String name);

    // select * from student where name=? and surname=?
    List<StudentEntity> findByNameIsAndSurnameIs(String name, String surname);

    // select * from student where name=? and surname=?
    List<StudentEntity> findByNameEqualsAndSurnameEquals(String name, String surname);

    // select * from student where age between ? and ?
    List<StudentEntity> findByAgeBetween(Integer fromAge, Integer toAge);

    // select * from student where name=? and age between ? and ?
    List<StudentEntity> findByNameAndAgeBetween(String name,
                                                Integer fromAge,
                                                Integer toAge);

    // select * from student where birth_day between ? and ?
    List<StudentEntity> findByBirthDayBetween(LocalDate fromDate, LocalDate toDate);

    // select * from student where age<?
    List<StudentEntity> findByAgeLessThan(Integer age);

    // select * from student where name=? and age<?
    List<StudentEntity> findByNameAndAgeLessThan(String name, Integer age);

    // select * from student where age<=?
    List<StudentEntity> findByAgeLessThanEqual(Integer age);

    // select * from student where age > ?
    List<StudentEntity> findByAgeGreaterThan(Integer age);

    // select * from student where age >= ?
    List<StudentEntity> findByAgeGreaterThanEqual(Integer age);

    // select * from student where birth_day > '2010-01-01'
    List<StudentEntity> findByBirthDayAfter(LocalDate formDate);

    // select * from student where birth_day > '2010-01-01'
    List<StudentEntity> findByBirthDayBefore(LocalDate formDate);

    // select * from student where email is null
    List<StudentEntity> findByEmailIsNull();

    // select * from student where email is not null
    List<StudentEntity> findByEmailIsNotNull();

    // select * from student where name like '%Ali%'
    List<StudentEntity> findByNameLike(String name);

    // select * from student where name like 'Ali%'
    List<StudentEntity> findByNameStartingWith(String name);

    // select * from student where name like '%yev'
    List<StudentEntity> findByNameEndingWith(String name);

    // select * from student where name like '%Ali%'
    List<StudentEntity> findByNameContains(String name);

    // select * from student order by age asc
    List<StudentEntity> findByOrderByAgeAsc();

    // select * from student order by desc
    List<StudentEntity> findByOrderByAgeDesc();

    // select * from student where name = ? order by desc
    List<StudentEntity> findByNameOrderByAgeDesc(String name);

    // select * from student where age=10 order by name
    List<StudentEntity> findByAgeOrderByName(Integer age);

    // select * from student where age <> ? order by name desc
    List<StudentEntity> findByAgeNotOrderByNameDesc(Integer age);

    // select * from student where name <> ? and surname = ? order by age asc
    List<StudentEntity> findByNameNotAndSurnameOrderByAgeAsc(String name,
                                                             String surname);

    // select * from student where age in(18,21,29)
    List<StudentEntity> findByAgeIn(List<Integer> ageList);

    // select * from student where age not in(18,21,29)
    List<StudentEntity> findByAgeNotIn(List<Integer> ageList);

    // select * from student where visible = ?
    List<StudentEntity> findByVisible(Boolean visible);

    // select * from student where visible = true
    List<StudentEntity> findByVisibleIsTrue();

    // select * from student where visible = false
    List<StudentEntity> findByVisibleIsFalse();

    // select * from student where visible = true
    List<StudentEntity> findByVisibleTrue();

    // select * from student where visible = false
    List<StudentEntity> findByVisibleFalse();

    // select * from student where upper(name) like upper('%ali%')
    List<StudentEntity> findByNameLikeIgnoreCase(String name);

    // select * from student where upper(name) like upper('%ali%')
    List<StudentEntity> findByNameContainsIgnoreCase(String name);

    // select count(*) from student
    Long countBy();

    // select count(*) from student where name= ?
    Long countByName(String name);

    // select count(*) from student where upper(name) like upper(?) and upper(surname) like upper(?)
    Long countByNameLikeIgnoreCaseAndSurnameLikeIgnoreCase(String name, String surname);

    // select * from student where name = ? limit 1
    StudentEntity findFirstByName(String name);

    // select * from student where name = ? and surname = ? order by age asc limit 1
    StudentEntity findTopByNameAndSurnameOrderByAgeAsc(String name, String surname);

    // select * from student where name = ? limit 5
    List<StudentEntity> findTop5ByName(String name);

    // select * from student where name=?
    // for each: delete from student where id=?
    @Transactional
    @Modifying
    void deleteByName(String name);
}
