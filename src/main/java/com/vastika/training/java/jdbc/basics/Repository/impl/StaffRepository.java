package com.vastika.training.java.jdbc.basics.Repository.impl;

import com.vastika.training.java.jdbc.basics.DbConnector;
import com.vastika.training.java.jdbc.basics.Models.Staff;
import com.vastika.training.java.jdbc.basics.Repository.CrudeRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffRepository implements CrudeRepository<Staff> {
    public List<Staff> findAll() {
        Connection connection = DbConnector.getConnection();
        List<Staff> staffs = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from staff");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String department = rs.getString("department");

                Staff staff = new Staff(id, firstName, lastName, department);

                staffs.add(staff);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return staffs;
    }

    public Staff findById(int userid) {
        Connection connection = DbConnector.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from staff where id = ?");
            ps.setInt(1,userid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String department = rs.getString("department");
                Staff staff = new Staff(id, firstName,lastName, department);
                return staff;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean update(Staff staff){
        Connection connection = DbConnector.getConnection();

        try{
            String sql1 = "Insert into staff( id, firstname, lastname, department) values(?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql1);
            ps.setInt(1, staff.getId());
            ps.setString(2, staff.getFirstName());
            ps.setString(3, staff.getLastName());
            ps.setString(4, staff.getDepartment());

            ps.executeUpdate();
            return true;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }


}

