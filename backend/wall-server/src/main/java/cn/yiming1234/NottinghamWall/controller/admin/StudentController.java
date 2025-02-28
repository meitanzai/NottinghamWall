package cn.yiming1234.NottinghamWall.controller.admin;

import cn.yiming1234.NottinghamWall.dto.PageQueryDTO;
import cn.yiming1234.NottinghamWall.entity.Student;
import cn.yiming1234.NottinghamWall.result.PageResult;
import cn.yiming1234.NottinghamWall.result.Result;
import cn.yiming1234.NottinghamWall.service.StudentService;
import com.aliyuncs.exceptions.ClientException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("adminStudentController")
@RequestMapping("/admin/student")
@Slf4j
@Api(tags = "管理端学生接口")
public class StudentController {

       @Autowired
       private StudentService studentService;

        /**
        * 学生分页查询
         */
        @GetMapping("/page")
        @ApiOperation("分页查询学生")
        public Result<PageResult<Student>> page(PageQueryDTO pageQueryDTO){
            log.info("学生分页查询：{}", pageQueryDTO);
            PageResult<Student> pageResult = studentService.pageQuery(pageQueryDTO);
            return Result.success(pageResult);
        }
        /**
        * 根据id查询学生
         */
        @GetMapping("/{id}")
        @ApiOperation("根据id查询学生")
        public Result<Student> getById(@PathVariable Integer id) throws ClientException {
            Student student = studentService.getById(id);
            return Result.success(student);
        }

        /**
        * 根据学号查询学生
         */
        @GetMapping("/getByStudentId/{studentId}")
        @ApiOperation("根据学号查询学生")
        public Result<Student> getByStudentId(@PathVariable Integer studentId){
            Student student = studentService.getByStudentId(studentId);
            return Result.success(student);
        }

        /**
        * 根据邮箱查询学生
         */
        @GetMapping("/getByEmail/{email}")
        @ApiOperation("根据邮箱查询学生")
        public  Result<Student> getByEmail(@PathVariable String email){
            Student student = studentService.getByEmail(email);
            return Result.success(student);
        }
}
