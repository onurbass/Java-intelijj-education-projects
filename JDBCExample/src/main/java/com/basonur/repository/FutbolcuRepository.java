package com.basonur.repository;

import com.basonur.repository.entity.Futbolcu;
import com.basonur.utility.ConnectionProvider;
import com.basonur.utility.ICrud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FutbolcuRepository implements ICrud<Futbolcu> {

    private ConnectionProvider connectionProvider;
    String sql = "";

    public FutbolcuRepository(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    @Override
    public void save(Futbolcu futbolcu) {
        String sql = "insert into futbolcu (ad,mevki,forma_no,deger,takim_id) values ('" + futbolcu.getAd() + "','" +
                futbolcu.getMevki() + "','" +
                futbolcu.getFormaNo() + "','" +
                futbolcu.getDeger() + "','" +
                futbolcu.getTakim_id() + "')";

        connectionProvider.openConnection();
        try {
            PreparedStatement preparedStatement = connectionProvider.getConnection().prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionProvider.closeConnection();
        }
    }

    public void save2(Futbolcu futbolcu) {
        sql = "insert into futbolcu (ad,mevki,forma_no,deger,takim_id) values(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connectionProvider.getPreparedStatement(sql);
            preparedStatement.setString(1, futbolcu.getAd());
            preparedStatement.setString(2, futbolcu.getMevki());
            preparedStatement.setInt(3, futbolcu.getFormaNo());
            preparedStatement.setLong(4, futbolcu.getDeger());
            preparedStatement.setLong(5, futbolcu.getTakim_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionProvider.closeConnection();
        }
    }

    @Override
    public void update(Futbolcu futbolcu) {

        sql = "UPDATE futbolcu SET ad = ?, mevki = ?, forma_no = ?, deger = ?, takim_id = ? WHERE id = " + futbolcu.getId();

        PreparedStatement preparedStatement = connectionProvider.getPreparedStatement(sql);

        try {

            preparedStatement.setString(1, futbolcu.getAd());
            preparedStatement.setString(2, futbolcu.getMevki());
            preparedStatement.setInt(3, futbolcu.getFormaNo());
            preparedStatement.setLong(4, futbolcu.getDeger());
            preparedStatement.setLong(5, futbolcu.getTakim_id());
            int count = preparedStatement.executeUpdate();

            if (count > 0) {
                System.out.println("Güncelleme Başarılı");
            } else {
                System.out.println("Güncelleme Başarısız!!!");
            }
        } catch (SQLException e) {

            throw new RuntimeException(e);
        } finally {

            connectionProvider.closeConnection();
        }
    }

    @Override
    public void deleteById(Long id) {
        sql = "delete from futbolcu where id=" + id;
        PreparedStatement preparedStatement = connectionProvider.getPreparedStatement(sql);
        try {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            connectionProvider.closeConnection();
        }
    }

    @Override
    public List<Futbolcu> findAll() {
        List<Futbolcu> futbolcuList = new ArrayList<>();
        sql = " select * from futbolcu";
        PreparedStatement preparedStatement = connectionProvider.getPreparedStatement(sql);
        try {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String ad = resultSet.getString(2);
                String mevki = resultSet.getString("mevki");
                Long deger = resultSet.getLong("deger");
                int formaNo = resultSet.getInt("forma_no");
                Long takim_id = resultSet.getLong("takim_id");
                futbolcuList.add(Futbolcu.builder()
                        .id(id)
                        .ad(ad)
                        .mevki(mevki)
                        .deger(deger)
                        .formaNo(formaNo)
                        .takim_id(takim_id)
                        .build());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionProvider.closeConnection();
        }
        return futbolcuList;
    }

    @Override
    public Optional<Futbolcu> findById(Long id) {
        Futbolcu futbolcu = null;
        sql = " select * from futbolcu where id = "+id;
        PreparedStatement preparedStatement = connectionProvider.getPreparedStatement(sql);
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            Long futbolcuId = resultSet.getLong(1);
            String ad = resultSet.getString(2);
            String mevki = resultSet.getString("mevki");
            Long deger = resultSet.getLong("deger");
            int formaNo = resultSet.getInt("forma_no");
            Long takim_id = resultSet.getLong("takim_id");
            futbolcu=Futbolcu.builder()
                    .id(futbolcuId)
                    .ad(ad)
                    .mevki(mevki)
                    .deger(deger)
                    .formaNo(formaNo)
                    .takim_id(takim_id)
                    .build();
        }
     catch (SQLException e) {
         System.out.println("Bulunamadı");
    } finally {
        connectionProvider.closeConnection();
    }

        return Optional.ofNullable(futbolcu);
    }
}
