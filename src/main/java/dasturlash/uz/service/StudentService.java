package dasturlash.uz.service;

import dasturlash.uz.dto.StudentDTO;
import dasturlash.uz.entity.StudentEntity;
import dasturlash.uz.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentDTO create(StudentDTO dto) {
        StudentEntity entity = new StudentEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());

        studentRepository.save(entity);

        dto.setId(entity.getId());
        return dto;
    }

    public List<StudentDTO> getAll() {
        Iterable<StudentEntity> iterable = studentRepository.findAll();
        List<StudentDTO> list = new LinkedList<>();

        for (StudentEntity entity : iterable) {
            list.add(toDTO(entity));
        }
        return list;
    }

    public StudentDTO getById(Integer id) {
        Optional<StudentEntity> optional = studentRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        StudentEntity entity = optional.get();
        return toDTO(entity);
    }

    public StudentDTO update(Integer id, StudentDTO dto) {
        Optional<StudentEntity> optional = studentRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        StudentEntity entity = optional.get();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        studentRepository.save(entity);
        return dto;
    }

    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }

    public List<StudentDTO> getByName(String name) {
        List<StudentEntity> entityList = studentRepository.findByName(name);
        List<StudentDTO> list = new LinkedList<>();

        for (StudentEntity entity : entityList) {
            list.add(toDTO(entity));
        }
        return list;
    }

    public StudentDTO getBySurname(String surname) {
//        StudentEntity entity = studentRepository.findBySurname(surname);
//        if(entity==null){
//            return null;
//        }

        Optional<StudentEntity> optional = studentRepository.findBySurname(surname);
        if (optional.isEmpty()) {
            return null;
        }
        StudentEntity entity = optional.get();
        return toDTO(entity);
    }

    public List<StudentDTO> getByNameAndSurname(String name, String surname) {
        List<StudentEntity> entityList = studentRepository.findByNameAndSurname(name, surname);
        List<StudentDTO> list = new LinkedList<>();

        for (StudentEntity entity : entityList) {
            list.add(toDTO(entity));
        }
        return list;
    }

    public List<String> ageBetween(Integer fromAge, Integer toAge) {
        studentRepository.findByAgeBetween(fromAge, toAge);
        return null;
    }

    public List<String> likeTest(String name) {
        studentRepository.findByNameLike("%" + name + "%");
        return null;
    }

    public List<String> startWithTest(String name) {
        studentRepository.findByNameStartingWith(name);
        return null;
    }

    public List<String> inTest(List<Integer> ageList) {
        studentRepository.findByAgeIn(List.of(18, 21, 29));
        return null;
    }

    public List<String> ignoreCaseTest(String name) {
        studentRepository.findByNameLikeIgnoreCase("%" + name + " %");
        return null;
    }

    public Long countTest(String name, String surname) {
        studentRepository.countByNameLikeIgnoreCaseAndSurnameLikeIgnoreCase("%" + name + " %",
                "%" + surname + " %");
        return null;
    }

    public void deleteTest(String name){
        studentRepository.deleteByName(name);
    }

    public StudentDTO toDTO(StudentEntity entity) {
        StudentDTO dto = new StudentDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        return dto;
    }
}
