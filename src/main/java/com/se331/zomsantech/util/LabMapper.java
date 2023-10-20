package com.se331.zomsantech.util;

import com.se331.zomsantech.entity.*;
import com.se331.zomsantech.security.user.Comment;
import com.se331.zomsantech.security.user.CommentDTO;
import com.se331.zomsantech.security.user.User;
import com.se331.zomsantech.security.user.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    List<StudentDTO> getStudentDTO(List<Student> students);
    TeacherDTO getTeacherDTO(Teacher teacher);
    List<TeacherDTO> getTeacherDTO(List<Teacher> teachers);
    UserDTO getUserDTO(User user);
    List<UserDTO> getUserDTO(List<User> users);

    @Mapping(source = "user.id", target = "id")
    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "user.firstname", target = "firstname")
    @Mapping(source = "user.lastname", target = "lastname")
    @Mapping(source = "user.email", target = "email")
    @Mapping(source = "user.roles", target = "roles")
    @Mapping(source = "user.image", target = "image")
    @Mapping(source = "ownStudent", target = "ownStudent")
    DetailedTeacherDTO getDetailedTeacherDTO(Teacher teacher);

    @Mapping(source = "user.firstname", target = "name")
    @Mapping(source = "user.lastname", target = "surname")
    @Mapping(source = "user.image", target = "image")
    TeacherOwnStudentDTO getTeacherOwnStudentDTO(Student student);

    @Mapping(source = "user.id", target = "id")
    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "user.firstname", target = "firstname")
    @Mapping(source = "user.lastname", target = "lastname")
    @Mapping(source = "user.image", target = "image")
    TeacherBriefDTO getTeacherBriefDTO(Teacher teacher);

    @Mapping(source = "teacher", target = "teacher")
    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "user.firstname", target = "firstname")
    @Mapping(source = "user.lastname", target = "lastname")
    @Mapping(source = "user.image", target = "image")
    StudentDTO getStudentDTO(Student student);


    CommentDTO getCommentDTO(Comment comment);

    List<CommentDTO> getCommentDTO(List<Comment> comments);
}
