package com.se331.zomsantech.util;

import com.se331.zomsantech.entity.Student;
import com.se331.zomsantech.entity.StudentDTO;
import com.se331.zomsantech.entity.StudentTeacherDTO;
import com.se331.zomsantech.entity.Teacher;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-13T21:58:15+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
public class LabMapperImpl implements LabMapper {

    @Override
    public StudentDTO getStudentDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDTO.StudentDTOBuilder studentDTO = StudentDTO.builder();

        studentDTO.id( student.getId() );
        studentDTO.name( student.getName() );
        studentDTO.surname( student.getSurname() );
        List<String> list = student.getImages();
        if ( list != null ) {
            studentDTO.images( new ArrayList<String>( list ) );
        }
        studentDTO.department( student.getDepartment() );
        studentDTO.teacher( teacherToStudentTeacherDTO( student.getTeacher() ) );

        return studentDTO.build();
    }

    @Override
    public List<StudentDTO> getStudentDTO(List<Student> students) {
        if ( students == null ) {
            return null;
        }

        List<StudentDTO> list = new ArrayList<StudentDTO>( students.size() );
        for ( Student student : students ) {
            list.add( getStudentDTO( student ) );
        }

        return list;
    }

    protected StudentTeacherDTO teacherToStudentTeacherDTO(Teacher teacher) {
        if ( teacher == null ) {
            return null;
        }

        StudentTeacherDTO.StudentTeacherDTOBuilder studentTeacherDTO = StudentTeacherDTO.builder();

        studentTeacherDTO.id( teacher.getId() );
        studentTeacherDTO.name( teacher.getName() );

        return studentTeacherDTO.build();
    }
}
