package com.se331.zomsantech.config;

import com.se331.zomsantech.entity.Student;
import com.se331.zomsantech.entity.Teacher;
import com.se331.zomsantech.repository.StudentRepository;
import com.se331.zomsantech.repository.TeacherRepository;
import com.se331.zomsantech.security.user.Role;
import com.se331.zomsantech.security.user.User;
import com.se331.zomsantech.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final StudentRepository studentRepository;
    final TeacherRepository teacherRepository;
    final UserRepository userRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {

        User userT1 = new User();
        userT1.setUsername("MM");
        userT1.setFirstname("Mr. Mock");
        userT1.setLastname("Kingbird");
        userT1.setPassword("password");
        userT1.setRoles(List.of(Role.ROLE_TEACHER));
        userT1.setImage("https://storage.googleapis.com/download/storage/v1/b/" +
                "se-lab-331-imageuplaod.appspot.com/o/2023-10-20%20132021191-379663637_630804189042392_265397635741634822_n.jpg?" +
                "generation=1697782821940462&alt=media");
        userRepository.save(userT1);


        User userT2 = new User();
        userT2.setUsername("SS");
        userT2.setFirstname("Solid State");
        userT2.setLastname("Of America");
        userT2.setPassword("passasdword");
        userT2.setRoles(List.of(Role.ROLE_TEACHER));
        userT2.setImage("https://storage.googleapis.com/download/storage/v1/b/" +
                "se-lab-331-imageuplaod.appspot.com/o/2023-10-20%20132021191-379663637_630804189042392_265397635741634822_n.jpg?" +
                "generation=1697782821940462&alt=media");
        userRepository.save(userT2);

        User userT3 = new User();
        userT3.setUsername("KaoPoon");
        userT3.setFirstname("Khemjira");
        userT3.setLastname("Riabroy");
        userT3.setPassword("Kriabroy");
        userT3.setRoles(List.of(Role.ROLE_TEACHER));
        userT3.setImage("https://storage.googleapis.com/download/storage/v1/b/" +
                "se-lab-331-imageuplaod.appspot.com/o/2023-10-20%20132021191-379663637_630804189042392_265397635741634822_n.jpg?" +
                "generation=1697782821940462&alt=media");
        userRepository.save(userT3);

        User userT4 = new User();
        userT4.setUsername("AJToey");
        userT4.setFirstname("Pathathai");
        userT4.setLastname("Nalumpoon");
        userT4.setPassword("Toey321");
        userT4.setRoles(List.of(Role.ROLE_TEACHER));
        userT4.setImage("https://storage.googleapis.com/download/storage/v1/b/" +
                "se-lab-331-imageuplaod.appspot.com/o/2023-10-20%20132021191-379663637_630804189042392_265397635741634822_n.jpg?" +
                "generation=1697782821940462&alt=media");
        userRepository.save(userT4);

        User userT5 = new User();
        userT5.setUsername("Charles");
        userT5.setFirstname("Charlie");
        userT5.setLastname("Chaplin");
        userT5.setPassword("Chaplin132");
        userT5.setRoles(List.of(Role.ROLE_TEACHER));
        userT5.setImage("https://storage.googleapis.com/download/storage/v1/b/" +
                "se-lab-331-imageuplaod.appspot.com/o/2023-10-20%20132021191-379663637_630804189042392_265397635741634822_n.jpg?" +
                "generation=1697782821940462&alt=media");
        userRepository.save(userT5);

        User userS1 = new User();
        userS1.setUsername("Thiwakon");
        userS1.setFirstname("Solid State");
        userS1.setLastname("Of America");
        userS1.setPassword("passwasdord");
        userS1.setRoles(List.of(Role.ROLE_STUDENT));
        userS1.setImage("https://scontent.fcnx4-1.fna.fbcdn.net/v/t39.30808-6/291835562_2105836552922182_2431088402003081743_n.jpg?" +
                "_nc_cat=111&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeFOR0VBiRt3Ko0FS8vVfzArJ9QtBjb3BnEn1C0GNvcGcUu5vibA-sbZNGEFiZrEvOsFx5HQtAUowWr7dBfjFbWP&_nc_ohc" +
                "=8d3MxE6EJjoAX8XHFfJ&_nc_ht=scontent.fcnx4-1.fna&cb_e2o_trans=q&oh=00_AfBXZbpx_3BQQ1IF2cHybczx_1iZ4BTTyAlYEjCF2_Gjcg&oe=65370DD2");
        userRepository.save(userS1);

        User userS2 = new User();
        userS2.setUsername("Pat");
        userS2.setFirstname("Pattana");
        userS2.setLastname("Pattana");
        userS2.setPassword("passwasdord");
        userS2.setRoles(List.of(Role.ROLE_STUDENT));
        userS2.setImage("https://scontent.fcnx4-1.fna.fbcdn.net/v/t39.30808-6/291835562_2105836552922182_2431088402003081743_n.jpg?" +
                "_nc_cat=111&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeFOR0VBiRt3Ko0FS8vVfzArJ9QtBjb3BnEn1C0GNvcGcUu5vibA-sbZNGEFiZrEvOsFx5HQtAUowWr7dBfjFbWP&_nc_ohc" +
                "=8d3MxE6EJjoAX8XHFfJ&_nc_ht=scontent.fcnx4-1.fna&cb_e2o_trans=q&oh=00_AfBXZbpx_3BQQ1IF2cHybczx_1iZ4BTTyAlYEjCF2_Gjcg&oe=65370DD2");
        userRepository.save(userS2);

        User userS3 = new User();
        userS3.setUsername("Tygre");
        userS3.setFirstname("Ratchapon");
        userS3.setLastname("Nuchrungruang");
        userS3.setPassword("HoiLodZ");
        userS3.setRoles(List.of(Role.ROLE_STUDENT));
        userS3.setImage("https://scontent.fcnx4-1.fna.fbcdn.net/v/t39.30808-6/291835562_2105836552922182_2431088402003081743_n.jpg?" +
                "_nc_cat=111&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeFOR0VBiRt3Ko0FS8vVfzArJ9QtBjb3BnEn1C0GNvcGcUu5vibA-sbZNGEFiZrEvOsFx5HQtAUowWr7dBfjFbWP&_nc_ohc" +
                "=8d3MxE6EJjoAX8XHFfJ&_nc_ht=scontent.fcnx4-1.fna&cb_e2o_trans=q&oh=00_AfBXZbpx_3BQQ1IF2cHybczx_1iZ4BTTyAlYEjCF2_Gjcg&oe=65370DD2");
        userRepository.save(userS3);

        User userS4 = new User();
        userS4.setUsername("BukHumZ");
        userS4.setFirstname("Kiminoto");
        userS4.setLastname("Bankai");
        userS4.setPassword("HelloWorld");
        userS4.setRoles(List.of(Role.ROLE_STUDENT));
        userS4.setImage("https://scontent.fcnx4-1.fna.fbcdn.net/v/t39.30808-6/291835562_2105836552922182_2431088402003081743_n.jpg?" +
                "_nc_cat=111&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeFOR0VBiRt3Ko0FS8vVfzArJ9QtBjb3BnEn1C0GNvcGcUu5vibA-sbZNGEFiZrEvOsFx5HQtAUowWr7dBfjFbWP&_nc_ohc" +
                "=8d3MxE6EJjoAX8XHFfJ&_nc_ht=scontent.fcnx4-1.fna&cb_e2o_trans=q&oh=00_AfBXZbpx_3BQQ1IF2cHybczx_1iZ4BTTyAlYEjCF2_Gjcg&oe=65370DD2");
        userRepository.save(userS4);

        User userS5 = new User();
        userS5.setUsername("Patchranun");
        userS5.setFirstname("MamMam");
        userS5.setLastname("ThumJaiKul");
        userS5.setPassword("EiEi");
        userS5.setRoles(List.of(Role.ROLE_STUDENT));
        userS5.setImage("https://scontent.fcnx4-1.fna.fbcdn.net/v/t39.30808-6/291835562_2105836552922182_2431088402003081743_n.jpg?" +
                "_nc_cat=111&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeFOR0VBiRt3Ko0FS8vVfzArJ9QtBjb3BnEn1C0GNvcGcUu5vibA-sbZNGEFiZrEvOsFx5HQtAUowWr7dBfjFbWP&_nc_ohc" +
                "=8d3MxE6EJjoAX8XHFfJ&_nc_ht=scontent.fcnx4-1.fna&cb_e2o_trans=q&oh=00_AfBXZbpx_3BQQ1IF2cHybczx_1iZ4BTTyAlYEjCF2_Gjcg&oe=65370DD2");
        userRepository.save(userS5);

        User userS6 = new User();
        userS6.setUsername("Phudinan");
        userS6.setFirstname("Singkumfu");
        userS6.setLastname("Django");
        userS6.setPassword("Fullfilling");
        userS6.setRoles(List.of(Role.ROLE_STUDENT));
        userS6.setImage("https://scontent.fcnx4-1.fna.fbcdn.net/v/t39.30808-6/291835562_2105836552922182_2431088402003081743_n.jpg?" +
                "_nc_cat=111&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeFOR0VBiRt3Ko0FS8vVfzArJ9QtBjb3BnEn1C0GNvcGcUu5vibA-sbZNGEFiZrEvOsFx5HQtAUowWr7dBfjFbWP&_nc_ohc" +
                "=8d3MxE6EJjoAX8XHFfJ&_nc_ht=scontent.fcnx4-1.fna&cb_e2o_trans=q&oh=00_AfBXZbpx_3BQQ1IF2cHybczx_1iZ4BTTyAlYEjCF2_Gjcg&oe=65370DD2");
        userRepository.save(userS6);

        User userS7 = new User();
        userS7.setUsername("Thor");
        userS7.setFirstname("Son of Odin");
        userS7.setLastname("Ruler of Asgard");
        userS7.setPassword("Ragnarok");
        userS7.setRoles(List.of(Role.ROLE_STUDENT));
        userS7.setImage("https://scontent.fcnx4-1.fna.fbcdn.net/v/t39.30808-6/291835562_2105836552922182_2431088402003081743_n.jpg?" +
                "_nc_cat=111&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeFOR0VBiRt3Ko0FS8vVfzArJ9QtBjb3BnEn1C0GNvcGcUu5vibA-sbZNGEFiZrEvOsFx5HQtAUowWr7dBfjFbWP&_nc_ohc" +
                "=8d3MxE6EJjoAX8XHFfJ&_nc_ht=scontent.fcnx4-1.fna&cb_e2o_trans=q&oh=00_AfBXZbpx_3BQQ1IF2cHybczx_1iZ4BTTyAlYEjCF2_Gjcg&oe=65370DD2");
        userRepository.save(userS7);

        User userS8 = new User();
        userS8.setUsername("Odin");
        userS8.setFirstname("Father of Thor");
        userS8.setLastname("Former Ruler of Asgard");
        userS8.setPassword("Odin123");
        userS8.setRoles(List.of(Role.ROLE_STUDENT));
        userS8.setImage("https://scontent.fcnx4-1.fna.fbcdn.net/v/t39.30808-6/291835562_2105836552922182_2431088402003081743_n.jpg?" +
                "_nc_cat=111&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeFOR0VBiRt3Ko0FS8vVfzArJ9QtBjb3BnEn1C0GNvcGcUu5vibA-sbZNGEFiZrEvOsFx5HQtAUowWr7dBfjFbWP&_nc_ohc" +
                "=8d3MxE6EJjoAX8XHFfJ&_nc_ht=scontent.fcnx4-1.fna&cb_e2o_trans=q&oh=00_AfBXZbpx_3BQQ1IF2cHybczx_1iZ4BTTyAlYEjCF2_Gjcg&oe=65370DD2");
        userRepository.save(userS8);

        User userS9 = new User();
        userS9.setUsername("Loki");
        userS9.setFirstname("Thor hater");
        userS9.setLastname("Odin hater");
        userS9.setPassword("IHATEASGARD");
        userS9.setRoles(List.of(Role.ROLE_STUDENT));
        userS9.setImage("https://scontent.fcnx4-1.fna.fbcdn.net/v/t39.30808-6/291835562_2105836552922182_2431088402003081743_n.jpg?" +
                "_nc_cat=111&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeFOR0VBiRt3Ko0FS8vVfzArJ9QtBjb3BnEn1C0GNvcGcUu5vibA-sbZNGEFiZrEvOsFx5HQtAUowWr7dBfjFbWP&_nc_ohc" +
                "=8d3MxE6EJjoAX8XHFfJ&_nc_ht=scontent.fcnx4-1.fna&cb_e2o_trans=q&oh=00_AfBXZbpx_3BQQ1IF2cHybczx_1iZ4BTTyAlYEjCF2_Gjcg&oe=65370DD2");
        userRepository.save(userS9);

        User userS10 = new User();
        userS10.setUsername("Spider-Man");
        userS10.setFirstname("Peter");
        userS10.setLastname("Parker");
        userS10.setPassword("ILOVEMJ");
        userS10.setRoles(List.of(Role.ROLE_STUDENT));
        userS10.setImage("https://scontent.fcnx4-1.fna.fbcdn.net/v/t39.30808-6/291835562_2105836552922182_2431088402003081743_n.jpg?" +
                "_nc_cat=111&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeFOR0VBiRt3Ko0FS8vVfzArJ9QtBjb3BnEn1C0GNvcGcUu5vibA-sbZNGEFiZrEvOsFx5HQtAUowWr7dBfjFbWP&_nc_ohc" +
                "=8d3MxE6EJjoAX8XHFfJ&_nc_ht=scontent.fcnx4-1.fna&cb_e2o_trans=q&oh=00_AfBXZbpx_3BQQ1IF2cHybczx_1iZ4BTTyAlYEjCF2_Gjcg&oe=65370DD2");
        userRepository.save(userS10);

        User userS11 = new User();
        userS11.setUsername("Mai");
        userS11.setFirstname("Jiratchaya");
        userS11.setLastname("FanJa");
        userS11.setPassword("ILOVEFANJA");
        userS11.setRoles(List.of(Role.ROLE_STUDENT));
        userS11.setImage("https://scontent.fcnx4-1.fna.fbcdn.net/v/t39.30808-6/291835562_2105836552922182_2431088402003081743_n.jpg?" +
                "_nc_cat=111&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeFOR0VBiRt3Ko0FS8vVfzArJ9QtBjb3BnEn1C0GNvcGcUu5vibA-sbZNGEFiZrEvOsFx5HQtAUowWr7dBfjFbWP&_nc_ohc" +
                "=8d3MxE6EJjoAX8XHFfJ&_nc_ht=scontent.fcnx4-1.fna&cb_e2o_trans=q&oh=00_AfBXZbpx_3BQQ1IF2cHybczx_1iZ4BTTyAlYEjCF2_Gjcg&oe=65370DD2");
        userRepository.save(userS11);

        User userS12 = new User();
        userS12.setUsername("Jaa");
        userS12.setFirstname("Kongpop");
        userS12.setLastname("Inyeo");
        userS12.setPassword("Yeager");
        userS12.setRoles(List.of(Role.ROLE_STUDENT));
        userS12.setImage("https://scontent.fcnx4-1.fna.fbcdn.net/v/t39.30808-6/291835562_2105836552922182_2431088402003081743_n.jpg?" +
                "_nc_cat=111&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeFOR0VBiRt3Ko0FS8vVfzArJ9QtBjb3BnEn1C0GNvcGcUu5vibA-sbZNGEFiZrEvOsFx5HQtAUowWr7dBfjFbWP&_nc_ohc" +
                "=8d3MxE6EJjoAX8XHFfJ&_nc_ht=scontent.fcnx4-1.fna&cb_e2o_trans=q&oh=00_AfBXZbpx_3BQQ1IF2cHybczx_1iZ4BTTyAlYEjCF2_Gjcg&oe=65370DD2");
        userRepository.save(userS12);


        Teacher t1 = new Teacher();
        t1.setUser(userT1);
        teacherRepository.save(t1);



        Student s1 = new Student();
        s1.setUser(userS1);
        s1.setTeacher(t1);
        studentRepository.save(s1);

        Teacher t4 = new Teacher();
        t4.setUser(userT4);
        t4.getOwnStudent().add(s1);
        s1.setTeacher(t4);
        teacherRepository.save(t4);
        studentRepository.save(s1);

        Teacher t5 = new Teacher();
        t5.setUser(userT5);

        Student s11 = new Student();
        s11.setUser(userS11);
        s11.setTeacher(t5);
        studentRepository.save(s11);
        t5.getOwnStudent().add(s11);
        teacherRepository.save(t5);

        Student s12 = new Student();
        s12.setUser(userS12);
        s12.setTeacher(t5);
        studentRepository.save(s12);
        t5.getOwnStudent().add(s12);
        teacherRepository.save(t5);

        Student s8 = new Student();
        s8.setUser(userS8);
        s8.setTeacher(t5);
        studentRepository.save(s8);
        t5.setUser(userT5);
        t5.getOwnStudent().add(s8);
        teacherRepository.save(t5);

        Student s9 = new Student();
        s9.setUser(userS9);
        s9.setTeacher(t4);
        studentRepository.save(s9);
        t4.getOwnStudent().add(s9);
        teacherRepository.save(t4);

        Student s10 = new Student();
        s10.setUser(userS10);
        s10.setTeacher(t5);
        studentRepository.save(s10);
        t5.getOwnStudent().add(s10);
        teacherRepository.save(t5);


        Teacher t2 = new Teacher();

        Student s2 = new Student();
        s2.setUser(userS2);
        s2.setTeacher(t2);
        studentRepository.save(s2);

        t2.setUser(userT2);
        t2.getOwnStudent().add(s2);
        s2.setTeacher(t2);
        teacherRepository.save(t2);
        studentRepository.save(s2);

        Teacher t3 = new Teacher();
        t3.setUser(userT3);
        teacherRepository.save(t3);


        Student s3 = new Student();
        s3.setUser(userS3);
        s3.setTeacher(t3);
        studentRepository.save(s3);

        t3.getOwnStudent().add(s3);

        teacherRepository.save(t3);

        Student s4 = new Student();
        s4.setUser(userS4);
        s4.setTeacher(t3);
        studentRepository.save(s4);
        t3.getOwnStudent().add(s4);
        teacherRepository.save(t3);

        Student s5 = new Student();
        s5.setUser(userS5);
        s5.setTeacher(t2);
        studentRepository.save(s5);
        t2.getOwnStudent().add(s5);
        teacherRepository.save(t2);

        Student s6 = new Student();
        s6.setUser(userS6);
        s6.setTeacher(t1);
        studentRepository.save(s6);
        t1.getOwnStudent().add(s6);
        teacherRepository.save(t1);

        Student s7 = new Student();
        s7.setUser(userS7);
        s7.setTeacher(t1);
        studentRepository.save(s7);
        t1.getOwnStudent().add(s7);
        teacherRepository.save(t1);

    }
}
