package com.se331.zomsantech.util;

import com.se331.zomsantech.entity.Student;
import com.se331.zomsantech.entity.StudentDTO;
import com.se331.zomsantech.entity.StudentTeacherDTO;
import com.se331.zomsantech.entity.Teacher;
import com.se331.zomsantech.entity.TeacherDTO;
import com.se331.zomsantech.entity.TeacherOwnStudentDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-15T12:07:32+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
public class LabMapperImpl implements LabMapper {

    @Override
    public StudentDTO getStudentDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDTO.StudentDTOBuilder studentDTO = StudentDTO.builder();

        studentDTO.department( student.getDepartment() );
        studentDTO.id( student.getId() );
        List<String> list = student.getImages();
        if ( list != null ) {
            studentDTO.images( new ArrayList<String>( list ) );
        }
        studentDTO.name( student.getName() );
        studentDTO.surname( student.getSurname() );
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

    @Override
    public TeacherDTO getTeacherDTO(Teacher teacher) {
        if ( teacher == null ) {
            return null;
        }

        TeacherDTO.TeacherDTOBuilder teacherDTO = TeacherDTO.builder();

        teacherDTO.department( teacher.getDepartment() );
        teacherDTO.id( teacher.getId() );
        List<String> list = teacher.getImages();
        if ( list != null ) {
            teacherDTO.images( new ArrayList<String>( list ) );
        }
        teacherDTO.name( teacher.getName() );
        teacherDTO.ownStudent( studentListToTeacherOwnStudentDTOList( teacher.getOwnStudent() ) );
        teacherDTO.surname( teacher.getSurname() );

        return teacherDTO.build();
    }

    @Override
    public List<TeacherDTO> getTeacherDTO(List<Teacher> teachers) {
        if ( teachers == null ) {
            return null;
        }

        List<TeacherDTO> list = new ArrayList<TeacherDTO>( teachers.size() );
        for ( Teacher teacher : teachers ) {
            list.add( getTeacherDTO( teacher ) );
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

    protected TeacherOwnStudentDTO studentToTeacherOwnStudentDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        TeacherOwnStudentDTO.TeacherOwnStudentDTOBuilder teacherOwnStudentDTO = TeacherOwnStudentDTO.builder();

        teacherOwnStudentDTO.id( student.getId() );
        teacherOwnStudentDTO.name( student.getName() );
        teacherOwnStudentDTO.surname( student.getSurname() );

        return teacherOwnStudentDTO.build();
    }

    protected List<TeacherOwnStudentDTO> studentListToTeacherOwnStudentDTOList(List<Student> list) {
        if ( list == null ) {
            return null;
        }

        List<TeacherOwnStudentDTO> list1 = new ArrayList<TeacherOwnStudentDTO>( list.size() );
        for ( Student student : list ) {
            list1.add( studentToTeacherOwnStudentDTO( student ) );
        }

        return list1;
    }
}
