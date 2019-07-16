package com.vastika.training.java.jdbc1.basics;


import java.util.List;

public class TeacherRepository implements CrudeRepository<Teacher>{
    @Override
    public List<Teacher> findAll() {
        return null;
    }

    @Override
    public Teacher findById(int id) {
        return null;
    }

    @Override
    public boolean update(Teacher teacher) {
        return false;
    }


}

