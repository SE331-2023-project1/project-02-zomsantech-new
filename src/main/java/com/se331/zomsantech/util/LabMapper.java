package com.se331.zomsantech.util;

import com.se331.zomsantech.entity.*;
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
//    @Mapping(source = "user.id", target = "id")
    TeacherDTO getTeacherDTO(Teacher teacher);
    List<TeacherDTO> getTeacherDTO(List<Teacher> teachers);
    UserDTO getUserDTO(User user);
    List<UserDTO> getUserDTO(List<User> users);

    AnnouncementDTO getAnnouncementDTO(User user);

    List<AnnouncementDTO> getAnnouncementDTO(List<Announcement> announcements);

//    @Mapping(source = "user.id", target = "id")
    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "user.firstname", target = "firstname")
    @Mapping(source = "user.lastname", target = "lastname")
    @Mapping(source = "user.email", target = "email")
    @Mapping(source = "user.roles", target = "roles")
    @Mapping(source = "user.image", target = "image")
    @Mapping(source = "ownStudent", target = "ownStudent")
    DetailedTeacherDTO getDetailedTeacherDTO(Teacher teacher);

    @Mapping(source = "user.firstname", target = "name")
    @Mapping(source = "student.id", target = "id")
    @Mapping(source = "user.lastname", target = "surname")
    @Mapping(source = "user.image", target = "image")
    @Mapping(source = "user.email", target = "email")
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
//    @Mapping(source = "user.id", target = "id")
    @Mapping(source = "user.image", target = "image")
    @Mapping(source = "user.email", target = "email")
    StudentDTO getStudentDTO(Student student);

    @Mapping(source = "teacher.user.firstname", target = "firstname")
    @Mapping(source = "teacher.user.lastname", target = "lastname")
    @Mapping(source = "teacher.user.username", target = "username")
    @Mapping(source = "teacher.user.image", target = "image")
    AnnouncementDTO getAnnouncementDTO(Announcement announcement);

    @Mapping(source = "student.id", target = "studentId")
    @Mapping(source = "student.user.firstname", target = "studentFirstName")
    @Mapping(source = "student.user.image", target = "studentImage")
    @Mapping(source = "teacher.id", target = "teacherId")
    @Mapping(source = "teacher.user.firstname", target = "teacherFirstName")
    @Mapping(source = "teacher.user.image", target = "teacherImage")
    CommentDTO commentToCommentDTO(Comment comment);
//    CommentDTO commentToCommentDTO(Comment comment);

    default CommentDTO replyToCommentDTO(Comment comment) {
        if (comment == null) return null;
        return CommentDTO.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .studentId(comment.getStudent().getId())
                .teacherId(comment.getTeacher() != null ? comment.getTeacher().getId() : null)
                .build();
    }


}
