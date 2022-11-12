package com.jason.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jason.common.Result;
import com.jason.pojo.Employee;
import com.jason.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login")
    public Result<Employee> login(HttpServletRequest request, @RequestBody Employee employee){
        //1,将页面提交的密码password进行MD5加密处理
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        //2,根据页面提交的用户名username查询数据库
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getUsername,employee.getUsername());
        Employee emp = employeeService.getOne(queryWrapper);
        //3,如果没有查询到则返回登录失败结果
        if(emp == null){
            return Result.error("登录失败");
        }
        //4,密码比对，如果比对不一致则返回登录失败结果
        if(!emp.getPassword().equals(password)){
            return Result.error("登录失败");
        }
        //5,查看员工状态，如果为已禁用状态，则返回员工已禁用结果
        if(emp.getStatus() == 0){
            return Result.error("账号已禁用");
        }
        //6，登录成功，将员工id存入session并返回成功结果
        request.getSession().setAttribute("employee",emp.getId());
        return Result.success(emp);
    }
    @PostMapping("/logout")
    public Result<String> logout(HttpServletRequest request ){
        //1,清理session中保存的当前员工的id
        request.getSession().removeAttribute("employee");
        //2,退出成功
        return Result.success("退出成功");
    }
    @PostMapping
    public Result<String> add(@RequestBody Employee employee,HttpServletRequest request){
        //设置初始密码123456，需要进行MD5加密
        employee.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
//        //设置创建时间
//        employee.setCreateTime(LocalDateTime.now());
//        //设置更新时间
//        employee.setUpdateTime(LocalDateTime.now());
//        //获取当前用户
//        long empId = (long) request.getSession().getAttribute("employee");
//        //设置创建者
//        employee.setCreateUser(empId);
//        //设置更新者
//        employee.setUpdateUser(empId);
        employeeService.save(employee);
        return Result.success("新增员工成功");
    }
    @GetMapping("/page")
    public Result<Page> page(int page,int pageSize,String name){
        //构造分页构造器
        Page pageInfo = new Page(page,pageSize);
        //构造条件构造器
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        //添加过滤条件
        queryWrapper.like(!(name == null || "".equals(name)), Employee::getName, name);
        //对查询的结果进行降序排序，根据更新时间
        queryWrapper.orderByDesc(Employee::getUpdateTime);
        //执行查询
        employeeService.page(pageInfo, queryWrapper);
        return Result.success(pageInfo);
    }
    @PutMapping
    public Result<String> update(@RequestBody Employee employee, HttpServletRequest request) {
//        //或取当前操作人
//        Long id = (Long) request.getSession().getAttribute("employee");
//        //设置更新者
//        employee.setUpdateUser(id);
//        //设置更新时间
//        employee.setUpdateTime(LocalDateTime.now());
        //更新
        employeeService.updateById(employee);
        return Result.success("员工信息修改成功");
    }
    @GetMapping("/{id}")
    public Result<Employee> getById(@PathVariable Long id) {
        Employee employee = employeeService.getById(id);
        if (employee != null) {
            return Result.success(employee);
        }
        return Result.error("未查询到该员工信息");
    }
}
