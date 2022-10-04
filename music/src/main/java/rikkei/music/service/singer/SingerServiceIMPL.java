package rikkei.music.service.singer;

import rikkei.music.config.ConnectMySQL;
import rikkei.music.model.Singer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SingerServiceIMPL implements ISingerService {
    private Connection connection = ConnectMySQL.getConnection();
    private static final String CREATE_SINGER = "INSERT INTO singer(name,age,sex) VALUES (?,?,?)";
    private static final String LIST_SINGER = "SELECT *FROM singer WHERE  id = ?;";

    @Override
    public List<Singer> findAll() {
        List<Singer> singerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(LIST_SINGER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                int age = resultSet.getInt("age");
                Singer singer = new Singer(id, name,age,sex);
                singerList.add(singer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void save(Singer singer) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_SINGER);
            preparedStatement.setString(1, singer.getName());
            preparedStatement.setInt(2, singer.getAge());
            preparedStatement.setString(3, singer.getSex());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Singer findById(int id) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Singer> findByName(String name) {
        return null;
    }
}
