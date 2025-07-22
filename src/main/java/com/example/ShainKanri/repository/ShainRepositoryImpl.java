package com.example.ShainKanri.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.ShainKanri.entity.Shain;

@Repository
public class ShainRepositoryImpl implements ShainRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Shain> findAll() {
		//SQL文の作成
		final String sql = "select id, name, sei, nen, address from shain";

		//SQLの実行
		List<Shain> shainList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Shain>(Shain.class));

		return shainList;
	}

	@Override
	public Shain findByShainId(int shainId) {
		//SQL文の作成
		final String sql = "select id, name, sei, nen, address from shain where id = :id";

		// パラメータの作成
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", shainId);

		// SQLの実行
		List<Shain> shainList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Shain>(Shain.class));

		//リストを判定して戻す
		return shainList.isEmpty() ? null : shainList.get(0);
	}

	@Override
	public void insertShain(Shain shain) {
		//SQL文の作成
		final String sql = "insert into shain(id, name, sei, nen, address) "
				+ "values(:id,:name,:sei,:nen,:address)";

		// パラメータの作成
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", shain.getId());
		param.addValue("name", shain.getName());
		param.addValue("sei", shain.getSei());
		param.addValue("nen", shain.getNen());
		param.addValue("address", shain.getAddress());

		// SQLの実行
		jdbcTemplate.update(sql, param);

	}

	@Override
	public void updateShain(Shain shain) {
		//SQL文の作成
		final String sql = "update shain set name=:name, sei=:sei, nen=:nen, address=:address "
				+ "where id=:id";

		// パラメータの作成
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", shain.getId());
		param.addValue("name", shain.getName());
		param.addValue("sei", shain.getSei());
		param.addValue("nen", shain.getNen());
		param.addValue("address", shain.getAddress());

		// SQLの実行
		jdbcTemplate.update(sql, param);

	}

	@Override
	public void deleteShain(int shainId) {
		//SQL文の作成
		final String sql = "delete  from shain where id=:id";

		// パラメータの作成
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", shainId);

		// SQLの実行
		jdbcTemplate.update(sql, param);

	}

}
