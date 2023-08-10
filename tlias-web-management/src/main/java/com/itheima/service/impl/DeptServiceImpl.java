package com.itheima.service.impl;

import com.itheima.mapper.DeptMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Dept;
import com.itheima.pojo.DeptLog;
import com.itheima.service.*;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    //service中DeptServiceImpl不能操作数据库
    // 需要调用mapper中的方法 使用注入的方法
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private DeptLogService deptLogService;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }


    @Transactional(rollbackFor = Exception.class ) //事务管理 默认是运行时异常
    @Override
    public void delete(Integer id) throws Exception {

        try {
            //根据id删除部门
            deptMapper.deleteById(id);
            //模拟：异常
//            if(true){
//                throw new Exception("出现异常了~~~");
//            }
//            //根据部门id删除该部门下的员工
            empMapper.deleteByDeptId(id);


        } finally {
            //不论是否有异常都会会执行 记录日志
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了删除部门的操作，删除的部门是"+id+"号部门");
            deptLogService.insert(deptLog);
        }
    }




    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);


    }


    @Override
    public Dept getById(Integer id) {
        Dept dept = deptMapper.getById(id);
        return dept;
    }



    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);

    }
}
