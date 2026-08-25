package mx.dgtic.service;

import mx.dgtic.dao.StudentDao;
import mx.dgtic.dto.StudentByCityDto;
import mx.dgtic.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getStudents();

    StudentDto getStudent(Integer id);

    List<StudentByCityDto> getCountStudentsByCity();
}
